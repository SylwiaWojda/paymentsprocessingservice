package meena.demo.paymentsprocessingservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import meena.demo.paymentsprocessingservice.xmlvalidation.XMLValidator;
import meena.demo.paymentsprocessingservice.logger.LoggerService;
import meena.demo.paymentsprocessingservice.mapper.PAIN001ToPACS008Mapper;
import meena.demo.paymentsprocessingservice.model.pacs008.PACS008Document;
import meena.demo.paymentsprocessingservice.model.pain001.PAIN001Document;
import meena.demo.paymentsprocessingservice.repository.PaymentsProcessingServicePACS008Repository;
import meena.demo.paymentsprocessingservice.repository.PaymentsProcessingServicePAIN001Repository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.MDC;
import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @Autowired
    LoggerService logger;

    @Autowired
    XMLValidator xmlValidator;

    @Autowired
    XMLUtilService xmlUtilService;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    PaymentsProcessingServicePAIN001Repository paymentsProcessingServiceRepository;

    @Autowired
    PaymentsProcessingServicePACS008Repository paymentsProcessingServiceRepo;

    private String transactionID = "tx.id";

    @KafkaListener(topics = "${kafka.topic_name}" , groupId = "group_id")
    public void consume(ConsumerRecord<String, String> consumerRecord){
        try {
            // Setting up Payment Unique tracking Id
            MDC.put(transactionID,
                    new String(consumerRecord.headers().lastHeader(transactionID).value(), StandardCharsets.UTF_8));
            logger.logTemplate(
                    "Debtor Service",
                    "Payment Processing Service",
                    "Request received from debtor Service", consumerRecord.value());
            // XML Validation
            boolean xmlValidatorValid = xmlValidator.isValid("pain.001.001.03.xsd" , consumerRecord.value());
            logger.logStr("Received PAIN001 XML valid ?   " + xmlValidatorValid);

            if(xmlValidatorValid){
                // PAIN001 XML to PAIN001 POJO conversion
                PAIN001Document pain001pojo = xmlUtilService.convertXMLToPOJO(consumerRecord.value());
                //Write pain001 xml to mongoDB
                paymentsProcessingServiceRepository.insert(pain001pojo);
                logger.logStr("PAIN001 POJO :::: "+ mapper.writeValueAsString(pain001pojo));
                // PAIN001 POJO to PACS008 POJO Mapper
                PACS008Document pacs008pojo = PAIN001ToPACS008Mapper.mapper.pain001ToPacs008(pain001pojo);
                logger.logStr("PACS008 POJO :::: "+ mapper.writeValueAsString(pacs008pojo));
                //PACS008 POJO to PACS008 XML conversion
                String pacs008XML = xmlUtilService.convertPOJOToXML(pacs008pojo);
                logger.logStr("PACS008 XML :::: "+ pacs008XML);
                //To Validate PACS008 XML
                boolean pacs008XMLValidatorValid = xmlValidator.isValid("pacs.008.001.02.xsd" , pacs008XML);
                logger.logStr("Generated PACS008 XML valid ?   " + pacs008XMLValidatorValid);
                //Write pacs.008 xml to mongoDB
                paymentsProcessingServiceRepo.insert(pacs008pojo);
                //Write PAIN001 and PACS008 messages to Mongo DB
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

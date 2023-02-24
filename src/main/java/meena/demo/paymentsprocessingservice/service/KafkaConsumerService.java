package meena.demo.paymentsprocessingservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import meena.demo.paymentsprocessingservice.XMLValidation.XMLValidator;
import meena.demo.paymentsprocessingservice.logger.LoggerService;
import meena.demo.paymentsprocessingservice.mapper.PAIN001ToPACS008Mapper;
import meena.demo.paymentsprocessingservice.model.pacs008.PACS008Document;
import meena.demo.paymentsprocessingservice.model.pain001.PAIN001Document;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.MDC;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @Autowired
    private LoggerService logger;

    @Autowired
    private XMLValidator xmlValidator;

    @Autowired
    private XMLUtilService xmlUtilService;

    @Autowired
    ObjectMapper mapper;

    @KafkaListener(topics = "${kafka.topic_name}" , groupId = "group_id")
    public void consume(ConsumerRecord<String, String> record){
        try {
            // Setting up Payment Unique tracking Id
            MDC.put("tx.id",
                    new String(record.headers().lastHeader("tx.id").value(), StandardCharsets.UTF_8));
            logger.logTemplate(
                    "Debtor Service",
                    "Payment Processing Service",
                    "Request received from debtor Service", record.value());
            // XML Validation
            boolean xmlValidatorValid = xmlValidator.isValid("pain.001.001.03.xsd" , record.value());
            logger.logStr("Received PAIN001 XML valid ?   " + xmlValidatorValid);

            if(xmlValidatorValid){
                // PAIN001 XML to PAIN001 POJO conversion
                PAIN001Document pain001pojo = xmlUtilService.convertXMLToPOJO(record.value());
                logger.logStr("PAIN001 POJO :::: "+ mapper.writeValueAsString(pain001pojo));
                // PAIN001 POJO to PACS008 POJO Mapper
                PACS008Document pacs008pojo = PAIN001ToPACS008Mapper.mapper.pain001ToPacs008(pain001pojo);
                logger.logStr("PACS008 POJO :::: "+ mapper.writeValueAsString(pacs008pojo));
                //PACS008 POJO to PACS008 XML conversion
                String pacs008XML = xmlUtilService.convertPOJOToXML(pacs008pojo);
                logger.logStr("PACS008 XML :::: "+ pacs008XML);
                //Write PAIN001 and PACS008 messages to Mongo DB
                //TBU
                //Send PACS008 XML to Kafka Topic
                //;;;;;;;;;;;;;;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

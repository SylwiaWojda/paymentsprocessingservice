package meena.demo.paymentsprocessingservice.KafkaConsumer;

import meena.demo.paymentsprocessingservice.XMLValidation.XMLValidator;
import meena.demo.paymentsprocessingservice.logger.LoggerService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @Autowired
    private static LoggerService logger = new LoggerService();

    //private static Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    private static XMLValidator xmlValidator = new XMLValidator();

    @KafkaListener(topics = "${kafka.topic_name}" , groupId = "group_id")
    public void consume(ConsumerRecord<String, String> record){
        try {
            MDC.put("tx.id", new String(record.headers().lastHeader("tx.id").value(),
                    StandardCharsets.UTF_8));
            //logger.logStr("Record Message ::: " + record.value());
            //logger.logTemplate("Debtor(User)", "Debtor Service", "Request received from debtor", record.value());
            boolean xmlValidatorValid = xmlValidator.isValid("pain.001.001.03.xsd" , record.value());
            logger.logStr("pain.001 XML is Valid or Not   " + xmlValidatorValid);
        }
        catch (Exception e){
            //log.info("Exception ::::" + e);
            e.printStackTrace();

        }
    }
}

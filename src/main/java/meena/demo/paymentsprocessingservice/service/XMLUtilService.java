package meena.demo.paymentsprocessingservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import meena.demo.paymentsprocessingservice.logger.LoggerService;
import meena.demo.paymentsprocessingservice.model.pacs008.PACS008Document;
import meena.demo.paymentsprocessingservice.model.pain001.PAIN001Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

@Service
public class XMLUtilService {

    @Autowired
    LoggerService logger;

    public PAIN001Document convertXMLToPOJO(String xml) {
        JAXBContext jaxbContext;
        try{
            jaxbContext = JAXBContext.newInstance(PAIN001Document.class);
            Unmarshaller unm = jaxbContext.createUnmarshaller();
            PAIN001Document document = (PAIN001Document) unm.unmarshal(new StringReader(xml));
            return document;
        }
        catch (Exception e){
            e.printStackTrace();
            return new PAIN001Document();
        }
    }

    public String convertPOJOToXML(PACS008Document pojo) {
        JAXBContext jaxbContext;
        try{
            jaxbContext = JAXBContext.newInstance(PACS008Document.class);
            Marshaller m = jaxbContext.createMarshaller();
            StringWriter writer = new StringWriter();
            m.marshal(pojo, writer);
            return writer.toString();
        }
        catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }
}

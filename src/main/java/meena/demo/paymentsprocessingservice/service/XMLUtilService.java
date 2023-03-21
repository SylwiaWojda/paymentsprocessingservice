package meena.demo.paymentsprocessingservice.service;

import meena.demo.paymentsprocessingservice.logger.LoggerService;
import meena.demo.paymentsprocessingservice.model.pacs008.PACS008Document;
import meena.demo.paymentsprocessingservice.model.pain001.PAIN001Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
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
            return (PAIN001Document) unm.unmarshal(new StringReader(xml));
        }
        catch (Exception e){
            return new PAIN001Document();
        }
    }

    public String convertPOJOToXML(PACS008Document pojo) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(PACS008Document.class);
        Marshaller m = jaxbContext.createMarshaller();
        StringWriter writer = new StringWriter();
        m.marshal(pojo, writer);
        return writer.toString();
    }
}

package meena.demo.paymentsprocessingservice.XMLValidation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Component
public class XMLValidator {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private Validator initValidator(String xsdPath) throws SAXException, URISyntaxException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source schemaFile = new StreamSource(getFile(xsdPath));
        Schema schema = factory.newSchema(schemaFile);
        return schema.newValidator();
    }

    private File getFile(String xsdPath) throws URISyntaxException {
        return new File("D:\\XSD\\" + xsdPath);
    }

    public boolean isValid(String xsdPath, String xmlPath) throws IOException, SAXException, URISyntaxException {
        Validator validator = initValidator(xsdPath);
        List<SAXParseException> exceptions = new ArrayList<SAXParseException>();
        try {
            validator.setErrorHandler(new ErrorHandler() {
                @Override
                public void warning(SAXParseException exception) throws SAXException {
                    exceptions.add(exception);
                }

                @Override
                public void error(SAXParseException exception) throws SAXException {
                    exceptions.add(exception);
                }

                @Override
                public void fatalError(SAXParseException exception) throws SAXException {
                    exceptions.add(exception);
                }
            });
            validator.validate(new StreamSource(new StringReader(xmlPath)));
            if(!exceptions.isEmpty()){
                exceptions.forEach( e -> logger.info(e.toString()));
                return false;
            }
            return true;
        } catch (SAXException e) {
            logger.info("XML Validation Failed ::: " + e.toString());
            return false;
        }
        catch (Exception e){
            logger.info("XML Validation Failed ::: ", e);
            return false;
        }
    }
}

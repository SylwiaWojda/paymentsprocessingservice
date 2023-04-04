package meena.demo.paymentsprocessingservice.mapper;


import meena.demo.paymentsprocessingservice.model.pain001.PaymentInstructionInformation3;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import javax.xml.datatype.DatatypeFactory;
import java.util.GregorianCalendar;


@Mapper(imports = {DatatypeFactory.class, GregorianCalendar.class, PaymentInstructionInformation3.class})
public interface PACS008ToPACS002Mapper {

    PACS008ToPACS002Mapper mapper = Mappers.getMapper(PACS008ToPACS002Mapper.class);


}


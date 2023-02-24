package meena.demo.paymentsprocessingservice.mapper;

import meena.demo.paymentsprocessingservice.model.pacs008.*;
import meena.demo.paymentsprocessingservice.model.pacs008.BranchAndFinancialInstitutionIdentification4;
import meena.demo.paymentsprocessingservice.model.pacs008.CashAccount16;
import meena.demo.paymentsprocessingservice.model.pacs008.PartyIdentification32;
import meena.demo.paymentsprocessingservice.model.pacs008.RemittanceInformation5;
import meena.demo.paymentsprocessingservice.model.pain001.*;
import meena.demo.paymentsprocessingservice.model.pain001.ActiveOrHistoricCurrencyAndAmount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import javax.xml.datatype.DatatypeFactory;
import java.util.GregorianCalendar;
import java.util.List;


@Mapper(imports = {DatatypeFactory.class, GregorianCalendar.class, PaymentInstructionInformation3.class})
public interface PAIN001ToPACS008Mapper {

    PAIN001ToPACS008Mapper mapper = Mappers.getMapper(PAIN001ToPACS008Mapper.class);

    @Mapping(target="FIToFICstmrCdtTrf.grpHdr", source = "cstmrCdtTrfInitn")
    @Mapping(target="FIToFICstmrCdtTrf.cdtTrfTxInf", source = "cstmrCdtTrfInitn.pmtInf")
    PACS008Document pain001ToPacs008(PAIN001Document pain001Document);

    @Mapping(target="msgId", source="grpHdr.msgId")
    @Mapping(target="creDtTm", source="grpHdr.creDtTm")
    @Mapping(target="nbOfTxs", source="grpHdr.nbOfTxs")
    @Mapping(target="ctrlSum", source="grpHdr.ctrlSum")
    @Mapping(target="intrBkSttlmDt",
            expression = "java(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()))")
    @Mapping(target="sttlmInf.sttlmMtd", constant = "CLRG")
    @Mapping(target="instgAgt.finInstnId.BIC", source="pmtInf", qualifiedByName = "deriveBIC")
    GroupHeader33 mapHdr(CustomerCreditTransferInitiationV03 cstmrCdtTrfInitn) throws Exception;

    @Mapping(target = "pmtId.endToEndId",
            expression = "java(paymentInstructionInformation3.getCdtTrfTxInf().get(0).getPmtId().getEndToEndId())")
    @Mapping(target = "pmtId.txId", source = "paymentInstructionInformation3.pmtInfId")
    @Mapping(target = "intrBkSttlmAmt",
            expression = "java(mapACA(paymentInstructionInformation3.getCdtTrfTxInf().get(0).getAmt().getInstdAmt()))")
    @Mapping(target = "cdtr",
            expression = "java(mapPI32(paymentInstructionInformation3.getCdtTrfTxInf().get(0).getCdtr()))")
    @Mapping(target = "cdtrAcct",
            expression = "java(mapCA16(paymentInstructionInformation3.getCdtTrfTxInf().get(0).getCdtrAcct()))")
    @Mapping(target = "cdtrAgt",
            expression = "java(mapBFI4(paymentInstructionInformation3.getCdtTrfTxInf().get(0).getCdtrAgt()))")
    @Mapping(target = "cdtrAgtAcct",
            expression = "java(mapCA16(paymentInstructionInformation3.getCdtTrfTxInf().get(0).getCdtrAgtAcct()))")
    @Mapping(target = "ultmtCdtr",
            expression = "java(mapPI32(paymentInstructionInformation3.getCdtTrfTxInf().get(0).getUltmtCdtr()))")
    @Mapping(target = "rmtInf",
            expression = "java(mapRI5(paymentInstructionInformation3.getCdtTrfTxInf().get(0).getRmtInf()))")
    CreditTransferTransactionInformation11 mapBody(PaymentInstructionInformation3 paymentInstructionInformation3);

    ActiveCurrencyAndAmount mapACA(ActiveOrHistoricCurrencyAndAmount amt);

    PartyIdentification32 mapPI32(meena.demo.paymentsprocessingservice.model.pain001.PartyIdentification32 partyIdentification32);

    CashAccount16 mapCA16(meena.demo.paymentsprocessingservice.model.pain001.CashAccount16 cashAccount16);

    BranchAndFinancialInstitutionIdentification4 mapBFI4(meena.demo.paymentsprocessingservice.model.pain001.BranchAndFinancialInstitutionIdentification4 branchAndFinancialInstitutionIdentification4);

    RemittanceInformation5 mapRI5(meena.demo.paymentsprocessingservice.model.pain001.RemittanceInformation5 remittanceInformation5);

    @Named("deriveBIC")
    default String deriveBIC(List<PaymentInstructionInformation3> pmtInfLst){
        return pmtInfLst
                .stream()
                .filter(pmtInf -> pmtInf.getDbtrAgt() != null)
                .findFirst().get().getDbtrAgt().getFinInstnId().getBIC();
    }
}


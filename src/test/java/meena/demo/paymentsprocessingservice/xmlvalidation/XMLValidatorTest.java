package meena.demo.paymentsprocessingservice.xmlvalidation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.xml.sax.SAXException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class XMLValidatorTest {

    @Autowired
    XMLValidator validator;

    @Test
    void testValidXML() throws  SAXException {
        boolean isValid = validator.isValid("pain.001.001.03.xsd", testDataPAIN001xml());
        assertTrue(true);
    }

    @Test
    void testXMLValidationError() throws  SAXException {
        boolean isValid = validator.isValid("pain.001.001.03.xsd", testDataPAIN001xml().replace("message-id-001", "message-id-001-message-id-001-message-id-001"));
        assertFalse(false);
    }

    @Test
    void testInvalidXML() throws  SAXException {
        boolean isValid = validator.isValid("pain.001.001.03.xsd", "Invalid XML");
        assertFalse(false);
    }

    String testDataPAIN001xml(){
        return  "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pain.001.001.03\">\n" +
                "\t<CstmrCdtTrfInitn>\n" +
                "\t\t<GrpHdr>\n" +
                "\t\t\t<MsgId>message-id-001</MsgId>\n" +
                "\t\t\t<CreDtTm>2010-09-28T14:07:00</CreDtTm>\n" +
                "\t\t\t<NbOfTxs>1</NbOfTxs>\n" +
                "\t\t\t<CtrlSum>10.1</CtrlSum>\n" +
                "\t\t\t<InitgPty>\n" +
                "\t\t\t\t<Nm>Bedrijfsnaam</Nm>\n" +
                "\t\t\t\t<Id>\n" +
                "\t\t\t\t\t<OrgId>\n" +
                "\t\t\t\t\t\t<Othr>\n" +
                "\t\t\t\t\t\t\t<Id>123456789123456</Id>\n" +
                "\t\t\t\t\t\t</Othr>\n" +
                "\t\t\t\t\t</OrgId>\n" +
                "\t\t\t\t</Id>\n" +
                "\t\t\t</InitgPty>\n" +
                "\t\t</GrpHdr>\n" +
                "\t\t<PmtInf>\n" +
                "\t\t\t<PmtInfId>minimaal gevuld</PmtInfId>\n" +
                "\t\t\t<PmtMtd>TRF</PmtMtd>\n" +
                "\t\t\t<NbOfTxs>1</NbOfTxs>\n" +
                "\t\t\t<CtrlSum>10.1</CtrlSum>\n" +
                "\t\t\t<ReqdExctnDt>2009-11-01</ReqdExctnDt>\n" +
                "\t\t\t<Dbtr>\n" +
                "\t\t\t\t<Nm>Naam</Nm>\n" +
                "\t\t\t</Dbtr>\n" +
                "\t\t\t<DbtrAcct>\n" +
                "\t\t\t\t<Id>\n" +
                "\t\t\t\t\t<IBAN>NL44RABO0123456789</IBAN>\n" +
                "\t\t\t\t</Id>\n" +
                "\t\t\t</DbtrAcct>\n" +
                "\t\t\t<DbtrAgt>\n" +
                "\t\t\t\t<FinInstnId>\n" +
                "\t\t\t\t\t<BIC>RABONL2U</BIC>\n" +
                "\t\t\t\t</FinInstnId>\n" +
                "\t\t\t</DbtrAgt>\n" +
                "\t\t\t<CdtTrfTxInf>\n" +
                "\t\t\t\t<PmtId>\n" +
                "\t\t\t\t\t<EndToEndId>non ref</EndToEndId>\n" +
                "\t\t\t\t</PmtId>\n" +
                "\t\t\t\t<Amt>\n" +
                "\t\t\t\t\t<InstdAmt Ccy=\"EUR\">10.1</InstdAmt>\n" +
                "\t\t\t\t</Amt>\n" +
                "\t\t\t\t<ChrgBr>SLEV</ChrgBr>\n" +
                "\t\t\t\t<CdtrAgt>\n" +
                "\t\t\t\t\t<FinInstnId>\n" +
                "\t\t\t\t\t\t<BIC>ABNANL2A</BIC>\n" +
                "\t\t\t\t\t</FinInstnId>\n" +
                "\t\t\t\t</CdtrAgt>\n" +
                "\t\t\t\t<Cdtr>\n" +
                "\t\t\t\t\t<Nm>Naam creditor</Nm>\n" +
                "\t\t\t\t</Cdtr>\n" +
                "\t\t\t\t<CdtrAcct>\n" +
                "\t\t\t\t\t<Id>\n" +
                "\t\t\t\t\t\t<IBAN>NL90ABNA0111111111</IBAN>\n" +
                "\t\t\t\t\t</Id>\n" +
                "\t\t\t\t</CdtrAcct>\n" +
                "\t\t\t\t<RmtInf>\n" +
                "\t\t\t\t\t<Ustrd>vrije tekst</Ustrd>\n" +
                "\t\t\t\t</RmtInf>\n" +
                "\t\t\t</CdtTrfTxInf>\n" +
                "\t\t</PmtInf>\n" +
                "\t\t<PmtInf>\n" +
                "\t\t\t<PmtInfId>maximaal gevuld</PmtInfId>\n" +
                "\t\t\t<PmtMtd>TRF</PmtMtd>\n" +
                "\t\t\t<BtchBookg>true</BtchBookg>\n" +
                "\t\t\t<NbOfTxs>1</NbOfTxs>\n" +
                "\t\t\t<CtrlSum>20.2</CtrlSum>\n" +
                "\t\t\t<PmtTpInf>\n" +
                "\t\t\t\t<InstrPrty>NORM</InstrPrty>\n" +
                "\t\t\t\t<SvcLvl>\n" +
                "\t\t\t\t\t<Cd>SEPA</Cd>\n" +
                "\t\t\t\t</SvcLvl>\n" +
                "\t\t\t\t<LclInstrm>\n" +
                "\t\t\t\t\t<Cd>IDEAL</Cd>\n" +
                "\t\t\t\t</LclInstrm>\n" +
                "\t\t\t\t<CtgyPurp>\n" +
                "\t\t\t\t\t<Cd>SECU</Cd>\n" +
                "\t\t\t\t</CtgyPurp>\n" +
                "\t\t\t</PmtTpInf>\n" +
                "\t\t\t<ReqdExctnDt>2009-11-01</ReqdExctnDt>\n" +
                "\t\t\t<Dbtr>\n" +
                "\t\t\t\t<Nm>Naam</Nm>\n" +
                "\t\t\t\t<PstlAdr>\n" +
                "\t\t\t\t\t<Ctry>NL</Ctry>\n" +
                "\t\t\t\t\t<AdrLine>Debtor straat 1</AdrLine>\n" +
                "\t\t\t\t\t<AdrLine>9999 XX Plaats debtor</AdrLine>\n" +
                "\t\t\t\t</PstlAdr>\n" +
                "\t\t\t</Dbtr>\n" +
                "\t\t\t<DbtrAcct>\n" +
                "\t\t\t\t<Id>\n" +
                "\t\t\t\t\t<IBAN>NL44RABO0123456789</IBAN>\n" +
                "\t\t\t\t</Id>\n" +
                "\t\t\t</DbtrAcct>\n" +
                "\t\t\t<DbtrAgt>\n" +
                "\t\t\t\t<FinInstnId>\n" +
                "\t\t\t\t\t<BIC>RABONL2U</BIC>\n" +
                "\t\t\t\t</FinInstnId>\n" +
                "\t\t\t</DbtrAgt>\n" +
                "\t\t\t<UltmtDbtr>\n" +
                "\t\t\t\t<Id>\n" +
                "\t\t\t\t\t<OrgId>\n" +
                "\t\t\t\t\t\t<Othr>\n" +
                "\t\t\t\t\t\t\t<Id>12345678</Id>\n" +
                "\t\t\t\t\t\t\t<SchmeNm>\n" +
                "\t\t\t\t\t\t\t\t<Prtry>klantnummer</Prtry>\n" +
                "\t\t\t\t\t\t\t</SchmeNm>\n" +
                "\t\t\t\t\t\t\t<Issr>klantnummer uitgifte instantie</Issr>\n" +
                "\t\t\t\t\t\t</Othr>\n" +
                "\t\t\t\t\t</OrgId>\n" +
                "\t\t\t\t</Id>\n" +
                "\t\t\t</UltmtDbtr>\n" +
                "\t\t\t<ChrgBr>SLEV</ChrgBr>\n" +
                "\t\t\t<CdtTrfTxInf>\n" +
                "\t\t\t\t<PmtId>\n" +
                "\t\t\t\t\t<InstrId>debtor-to-debtor-bank-01</InstrId>\n" +
                "\t\t\t\t\t<EndToEndId>End-to-end-id-debtor-to-creditor-01</EndToEndId>\n" +
                "\t\t\t\t</PmtId>\n" +
                "\t\t\t\t<Amt>\n" +
                "\t\t\t\t\t<InstdAmt Ccy=\"EUR\">20.2</InstdAmt>\n" +
                "\t\t\t\t</Amt>\n" +
                "\t\t\t\t<CdtrAgt>\n" +
                "\t\t\t\t\t<FinInstnId>\n" +
                "\t\t\t\t\t\t<BIC>ABNANL2A</BIC>\n" +
                "\t\t\t\t\t</FinInstnId>\n" +
                "\t\t\t\t</CdtrAgt>\n" +
                "\t\t\t\t<Cdtr>\n" +
                "\t\t\t\t\t<Nm>Naam creditor</Nm>\n" +
                "\t\t\t\t\t<PstlAdr>\n" +
                "\t\t\t\t\t\t<Ctry>NL</Ctry>\n" +
                "\t\t\t\t\t\t<AdrLine>Straat creditor 1</AdrLine>\n" +
                "\t\t\t\t\t\t<AdrLine>9999 XX Plaats creditor</AdrLine>\n" +
                "\t\t\t\t\t</PstlAdr>\n" +
                "\t\t\t\t</Cdtr>\n" +
                "\t\t\t\t<CdtrAcct>\n" +
                "\t\t\t\t\t<Id>\n" +
                "\t\t\t\t\t\t<IBAN>NL90ABNA0111111111</IBAN>\n" +
                "\t\t\t\t\t</Id>\n" +
                "\t\t\t\t</CdtrAcct>\n" +
                "\t\t\t\t<UltmtCdtr>\n" +
                "\t\t\t\t\t<Id>\n" +
                "\t\t\t\t\t\t<PrvtId>\n" +
                "\t\t\t\t\t\t\t<DtAndPlcOfBirth>\n" +
                "\t\t\t\t\t\t\t\t<BirthDt>1969-07-03</BirthDt>\n" +
                "\t\t\t\t\t\t\t\t<CityOfBirth>PLAATS</CityOfBirth>\n" +
                "\t\t\t\t\t\t\t\t<CtryOfBirth>NL</CtryOfBirth>\n" +
                "\t\t\t\t\t\t\t</DtAndPlcOfBirth>\n" +
                "\t\t\t\t\t\t</PrvtId>\n" +
                "\t\t\t\t\t</Id>\n" +
                "\t\t\t\t</UltmtCdtr>\n" +
                "\t\t\t\t<Purp>\n" +
                "\t\t\t\t\t<Cd>CHAR</Cd>\n" +
                "\t\t\t\t</Purp>\n" +
                "\t\t\t\t<RmtInf>\n" +
                "\t\t\t\t\t<Strd>\n" +
                "\t\t\t\t\t\t<CdtrRefInf>\n" +
                "\t\t\t\t\t\t\t<Tp>\n" +
                "\t\t\t\t\t\t\t\t<CdOrPrtry>\n" +
                "\t\t\t\t\t\t\t\t\t<Cd>SCOR</Cd>\n" +
                "\t\t\t\t\t\t\t\t</CdOrPrtry>\n" +
                "\t\t\t\t\t\t\t\t<Issr>CUR</Issr>\n" +
                "\t\t\t\t\t\t\t</Tp>\n" +
                "\t\t\t\t\t\t\t<Ref>1234567</Ref>\n" +
                "\t\t\t\t\t\t</CdtrRefInf>\n" +
                "\t\t\t\t\t</Strd>\n" +
                "\t\t\t\t</RmtInf>\n" +
                "\t\t\t</CdtTrfTxInf>\n" +
                "\t\t</PmtInf>\n" +
                "\t</CstmrCdtTrfInitn>\n" +
                "</Document>";
    }

}

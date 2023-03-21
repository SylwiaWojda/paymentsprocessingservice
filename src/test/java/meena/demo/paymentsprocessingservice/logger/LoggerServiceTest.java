package meena.demo.paymentsprocessingservice.logger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoggerServiceTest {

    @Autowired
    LoggerService loggerService;

    @Test
    void testLogService() {
        String source = "Debtor";
        String destination = "DebtorService";
        String description = "Request received from Debtor";
        String payload = testData();
        loggerService.logTemplate(source, destination, description, payload);
    }

    @Test
    void testLogStr(){
        String log = "PAIN001";
        loggerService.logStr(log);
        Assertions.assertEquals("PAIN001" , log);
    }

    String testData() {
        return "<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\"?>\\n\" +\n" +
                "                \"<Document xmlns=\\\"urn:iso:std:iso:20022:tech:xsd:pain.001.001.03\\\">\\n\" +\n" +
                "                \"\\t<CstmrCdtTrfInitn>\\n\" +\n" +
                "                \"\\t\\t<GrpHdr>\\n\" +\n" +
                "                \"\\t\\t\\t<MsgId>message-id-001</MsgId>\\n\" +\n" +
                "                \"\\t\\t\\t<CreDtTm>2010-09-28T14:07:00</CreDtTm>\\n\" +\n" +
                "                \"\\t\\t\\t<NbOfTxs>1</NbOfTxs>\\n\" +\n" +
                "                \"\\t\\t\\t<CtrlSum>10.1</CtrlSum>\\n\" +\n" +
                "                \"\\t\\t\\t<InitgPty>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<Nm>Bedrijfsnaam</Nm>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<Id>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t<OrgId>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t<Othr>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t\\t<Id>123456789123456</Id>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t</Othr>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t</OrgId>\\n\" +\n" +
                "                \"\\t\\t\\t\\t</Id>\\n\" +\n" +
                "                \"\\t\\t\\t</InitgPty>\\n\" +\n" +
                "                \"\\t\\t</GrpHdr>\\n\" +\n" +
                "                \"\\t\\t<PmtInf>\\n\" +\n" +
                "                \"\\t\\t\\t<PmtInfId>minimaal gevuld</PmtInfId>\\n\" +\n" +
                "                \"\\t\\t\\t<PmtMtd>TRF</PmtMtd>\\n\" +\n" +
                "                \"\\t\\t\\t<NbOfTxs>1</NbOfTxs>\\n\" +\n" +
                "                \"\\t\\t\\t<CtrlSum>10.1</CtrlSum>\\n\" +\n" +
                "                \"\\t\\t\\t<ReqdExctnDt>2009-11-01</ReqdExctnDt>\\n\" +\n" +
                "                \"\\t\\t\\t<Dbtr>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<Nm>Naam</Nm>\\n\" +\n" +
                "                \"\\t\\t\\t</Dbtr>\\n\" +\n" +
                "                \"\\t\\t\\t<DbtrAcct>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<Id>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t<IBAN>NL44RABO0123456789</IBAN>\\n\" +\n" +
                "                \"\\t\\t\\t\\t</Id>\\n\" +\n" +
                "                \"\\t\\t\\t</DbtrAcct>\\n\" +\n" +
                "                \"\\t\\t\\t<DbtrAgt>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<FinInstnId>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t<BIC>RABONL2U</BIC>\\n\" +\n" +
                "                \"\\t\\t\\t\\t</FinInstnId>\\n\" +\n" +
                "                \"\\t\\t\\t</DbtrAgt>\\n\" +\n" +
                "                \"\\t\\t\\t<CdtTrfTxInf>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<PmtId>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t<EndToEndId>non ref</EndToEndId>\\n\" +\n" +
                "                \"\\t\\t\\t\\t</PmtId>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<Amt>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t<InstdAmt Ccy=\\\"EUR\\\">10.1</InstdAmt>\\n\" +\n" +
                "                \"\\t\\t\\t\\t</Amt>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<ChrgBr>SLEV</ChrgBr>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<CdtrAgt>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t<FinInstnId>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t<BIC>ABNANL2A</BIC>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t</FinInstnId>\\n\" +\n" +
                "                \"\\t\\t\\t\\t</CdtrAgt>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<Cdtr>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t<Nm>Naam creditor</Nm>\\n\" +\n" +
                "                \"\\t\\t\\t\\t</Cdtr>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<CdtrAcct>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t<Id>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t<IBAN>NL90ABNA0111111111</IBAN>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t</Id>\\n\" +\n" +
                "                \"\\t\\t\\t\\t</CdtrAcct>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<RmtInf>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t<Ustrd>vrije tekst</Ustrd>\\n\" +\n" +
                "                \"\\t\\t\\t\\t</RmtInf>\\n\" +\n" +
                "                \"\\t\\t\\t</CdtTrfTxInf>\\n\" +\n" +
                "                \"\\t\\t</PmtInf>\\n\" +\n" +
                "                \"\\t\\t<PmtInf>\\n\" +\n" +
                "                \"\\t\\t\\t<PmtInfId>maximaal gevuld</PmtInfId>\\n\" +\n" +
                "                \"\\t\\t\\t<PmtMtd>TRF</PmtMtd>\\n\" +\n" +
                "                \"\\t\\t\\t<BtchBookg>true</BtchBookg>\\n\" +\n" +
                "                \"\\t\\t\\t<NbOfTxs>1</NbOfTxs>\\n\" +\n" +
                "                \"\\t\\t\\t<CtrlSum>20.2</CtrlSum>\\n\" +\n" +
                "                \"\\t\\t\\t<PmtTpInf>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<InstrPrty>NORM</InstrPrty>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<SvcLvl>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t<Cd>SEPA</Cd>\\n\" +\n" +
                "                \"\\t\\t\\t\\t</SvcLvl>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<LclInstrm>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t<Cd>IDEAL</Cd>\\n\" +\n" +
                "                \"\\t\\t\\t\\t</LclInstrm>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<CtgyPurp>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t<Cd>SECU</Cd>\\n\" +\n" +
                "                \"\\t\\t\\t\\t</CtgyPurp>\\n\" +\n" +
                "                \"\\t\\t\\t</PmtTpInf>\\n\" +\n" +
                "                \"\\t\\t\\t<ReqdExctnDt>2009-11-01</ReqdExctnDt>\\n\" +\n" +
                "                \"\\t\\t\\t<Dbtr>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<Nm>Naam</Nm>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<PstlAdr>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t<Ctry>NL</Ctry>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t<AdrLine>Debtor straat 1</AdrLine>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t<AdrLine>9999 XX Plaats debtor</AdrLine>\\n\" +\n" +
                "                \"\\t\\t\\t\\t</PstlAdr>\\n\" +\n" +
                "                \"\\t\\t\\t</Dbtr>\\n\" +\n" +
                "                \"\\t\\t\\t<DbtrAcct>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<Id>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t<IBAN>NL44RABO0123456789</IBAN>\\n\" +\n" +
                "                \"\\t\\t\\t\\t</Id>\\n\" +\n" +
                "                \"\\t\\t\\t</DbtrAcct>\\n\" +\n" +
                "                \"\\t\\t\\t<DbtrAgt>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<FinInstnId>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t<BIC>RABONL2U</BIC>\\n\" +\n" +
                "                \"\\t\\t\\t\\t</FinInstnId>\\n\" +\n" +
                "                \"\\t\\t\\t</DbtrAgt>\\n\" +\n" +
                "                \"\\t\\t\\t<UltmtDbtr>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<Id>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t<OrgId>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t<Othr>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t\\t<Id>12345678</Id>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t\\t<SchmeNm>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t\\t\\t<Prtry>klantnummer</Prtry>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t\\t</SchmeNm>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t\\t<Issr>klantnummer uitgifte instantie</Issr>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t</Othr>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t</OrgId>\\n\" +\n" +
                "                \"\\t\\t\\t\\t</Id>\\n\" +\n" +
                "                \"\\t\\t\\t</UltmtDbtr>\\n\" +\n" +
                "                \"\\t\\t\\t<ChrgBr>SLEV</ChrgBr>\\n\" +\n" +
                "                \"\\t\\t\\t<CdtTrfTxInf>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<PmtId>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t<InstrId>debtor-to-debtor-bank-01</InstrId>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t<EndToEndId>End-to-end-id-debtor-to-creditor-01</EndToEndId>\\n\" +\n" +
                "                \"\\t\\t\\t\\t</PmtId>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<Amt>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t<InstdAmt Ccy=\\\"EUR\\\">20.2</InstdAmt>\\n\" +\n" +
                "                \"\\t\\t\\t\\t</Amt>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<CdtrAgt>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t<FinInstnId>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t<BIC>ABNANL2A</BIC>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t</FinInstnId>\\n\" +\n" +
                "                \"\\t\\t\\t\\t</CdtrAgt>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<Cdtr>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t<Nm>Naam creditor</Nm>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t<PstlAdr>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t<Ctry>NL</Ctry>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t<AdrLine>Straat creditor 1</AdrLine>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t<AdrLine>9999 XX Plaats creditor</AdrLine>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t</PstlAdr>\\n\" +\n" +
                "                \"\\t\\t\\t\\t</Cdtr>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<CdtrAcct>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t<Id>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t<IBAN>NL90ABNA0111111111</IBAN>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t</Id>\\n\" +\n" +
                "                \"\\t\\t\\t\\t</CdtrAcct>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<UltmtCdtr>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t<Id>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t<PrvtId>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t\\t<DtAndPlcOfBirth>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t\\t\\t<BirthDt>1969-07-03</BirthDt>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t\\t\\t<CityOfBirth>PLAATS</CityOfBirth>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t\\t\\t<CtryOfBirth>NL</CtryOfBirth>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t\\t</DtAndPlcOfBirth>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t</PrvtId>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t</Id>\\n\" +\n" +
                "                \"\\t\\t\\t\\t</UltmtCdtr>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<Purp>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t<Cd>CHAR</Cd>\\n\" +\n" +
                "                \"\\t\\t\\t\\t</Purp>\\n\" +\n" +
                "                \"\\t\\t\\t\\t<RmtInf>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t<Strd>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t<CdtrRefInf>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t\\t<Tp>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t\\t\\t<CdOrPrtry>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t\\t\\t\\t<Cd>SCOR</Cd>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t\\t\\t</CdOrPrtry>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t\\t\\t<Issr>CUR</Issr>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t\\t</Tp>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t\\t<Ref>1234567</Ref>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t\\t</CdtrRefInf>\\n\" +\n" +
                "                \"\\t\\t\\t\\t\\t</Strd>\\n\" +\n" +
                "                \"\\t\\t\\t\\t</RmtInf>\\n\" +\n" +
                "                \"\\t\\t\\t</CdtTrfTxInf>\\n\" +\n" +
                "                \"\\t\\t</PmtInf>\\n\" +\n" +
                "                \"\\t</CstmrCdtTrfInitn>\\n\" +\n" +
                "                \"</Document>";
    }
}
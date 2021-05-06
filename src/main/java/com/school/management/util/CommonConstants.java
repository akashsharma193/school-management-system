package com.school.management.util;


/**
 * Class CommonConstants contain the Commons constant which are used in middle
 * ware
 * 
 * @author Faizan
 * @version: 1.0
 */
//TODO fix remove the unnecessary constant which are not in static class.
public final class CommonConstants {

	/** TODO fix 'HIGH PRIORITY' remove hardcode APLID from overall system */
	public static final Long APL_ID = (long) 1; 

	public static final String CONTIGENCY = "contigency";
	public static final String CSV = ".csv";
	public static final String UNDERSCORE = "_";
	public static final String DOT = ".";
	
	public static final String BASE_PATH = "/apps/rps/config/";
	public static final String BASE_PATH_CONNECTOR_CONFIG_FILE = BASE_PATH + "config/"
			+ "rps.connector.config.properties";
	public static final String TEMP_PATH = "/apps/rps/temp/";
	public static final String UTF_8_ENCODING = "UTF-8";
	public static final String CONNECTOR_TIMER_JNDI = "CONNECTOR_TIMER_JNDI";
	public static final String CONNECTOR_WM_JNDI = "CONNECTOR_WM_JNDI";
	public static final String DB_JNDI_NAME = "DB_JNDI_NAME";
	public static final String JS_ENGINE_L = "JavaScript";
	public static final String JS_EXEC = "execute";
	public static final String DEFAULT = "DEFAULT";
	public static final String HASH = "#";
	public static final String SLASH = "/";
	public static final String QUESTION_MARK = "?";
	public static final String SYSTEM = "SYSTEM";
	public static final String DB_CONFIG = "DB_CONFIG";
	public static final String DB_ORACLE = "ORACLE";
	public static final String EEE = "EEE";
	public static final String _0 = "0";
	public static final String MI = "MI";
	public static final String _02X = "%02x";
	public static final String Y = "Y";
	public static final String N = "N";
	public static final String DATA = "data";
	public static final String ID = "id";
	public static final String COMMA = ",";
	public static final String SPACE = " ";
	public static final String FROM = "from";
	public static final String TO = "to";
	public static final Integer FROM_VAL = 1;
	public static final Integer TO_VAL = 50000;
	
	public static final String ALPHA_NUM_STR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + "@!#$%^*"
			+ "0123456789";
	public static final String FILE_NAME = "fileName";
	public static final String FROM_SERVER = "fromServer";
	public static final String SERIAL_NO = "serialNo";
	public static final String GZ = ".gz";
	public static final String EMPTY_STRING = "";
	public static final String ZERO = "0";
	public static final String IN = "IN";
	public static final String OUT = "OUT";
	public static final String NULL_CHAR = "\0";
	public static final String ALERT_MSG = "alertMsg";
	public static final String ON = "ON";
	public static final String OFF = "OFF";
	public static final String MESSAGE_NAME = "MESSAGE_NAME";
	public static final String MSG_NO = "msgNo";
	public static final Integer _1_000_000_000 = 1_000_000_000;
	public static final String ERROR = " ERROR ";
	public static final String ENCODING_IBM437 = "IBM437";
	public static final String V = "V";
	public static final String T = "T";
	public static final String FREEMAKER_TEMPLATE = "freeMarkeTemplate";
	public final static int _32_768 = 32_768;
	public static final String INACTIVE = "INACTIVE";
	public static final String ACTIVE = "ACTIVE";
	public static final String PARSED_ERR = "PARSED-ERR";
	public static final String PARSED_BUFFER_ERR = "PARSED-BUFFER-ERR";
	public static final String FORMAT_ERR = "FORMAT-ERR";
	public static final String UNKNOWN = "UNKNOWN";
	public static final String FORMAT_BUFFER_ERR = "FORMAT-BUFFER-ERR";
	public static final String CERT_INVALID = "CERT-INVALID";
	public static final String MANUAL_DE_TRASPASOS = "Manual De Traspasos";
	public static final String F = "F";
	public static final String A = "A";
	public static final String C = "C";
	public static final Integer PAQ_CDA_BYTE_SIZE = 1 + 1 + 2 + 1 + 1 + 1 + 1 + 1 + 2 + 4 + 4 + 4 + 4;
	public static final String CONST02X = "%02x";
	public static final String TRANSFORMATION = "RSA/ECB/PKCS1Padding";
	public static final String PUBLIC = "PUBLIC";
	public static final String PRIVATE = "PRIVATE";
	public static final String CONNECTOR = "CONNECTOR";
	public static final String MW = "MW";
	public static final String UI = "UI";
	public static final String ENSESION_INVALID = "ENSESION_INVALID";
	public static final String SUCCESS = "SUCCESS";
	public static final String FAIL = "FAIL";
	public static final String TOTAL = "TOTAL";
	public static final String FEC="FEC";
	public static final String CEP="CEP";
	public static final String ARA="ARA";

	public static final String OUT_PMT = "OUT_PMT";
	public static final String IN_PMT = "IN_PMT";
	public static final String BOM_MSG = "BOM_MSG";
	public static final String T_FILE = "T_FILE";
	public static final int BATCH_SIZE = 30;
	public static final String FOLIO_LAST_FMT = "FOLIO_LAST_FMT";
	public static final String FOLIO_LAST_SENT = "FOLIO_LAST_SENT";
	public static final String FOLIO_LAST_RCVD = "FOLIO_LAST_RCVD";
	
	public static class FileType{
		public static final String LOG = "LOG";
		public static final String CONTIGENCY = "CONTIGENCY";
	}
	
	public static class FileComponentNm{
		public static final String MW = "MW";
		public static final String CONNECTOR = "CONNECTOR";
		public static final String CONTINGENCY = "CONTINGENCY";
		public static final String UI = "UI";
	}
	
	public static class MessageTypeNumConstants {
		public static final int FINREENVIO = 32;
		public static final int REENVIO = 207;
		public static final int ACUSEPARTESAC = 46;
		public static final int AREYOUALIVE = 245;
		public static final int TRASPASOSPEISIAC = 199;
		public static final int CAMBIARESERVADO = 202;
		public static final int CANCELAPAGO = 205;
		public static final int ORDENTOPOV = 206;
		public static final int ORDENTOPOT = 210;
		public static final int CANCELATRASPASOSPEISIAC = 197;
		public static final int LIQUIDACIONFINAL = 51;
		public static final int PAQCDA = 197;

	}
	
	public static class AlertConstants{
		//below is alert cd constant to be used in master table. in case of new cd constant add here
		public static final String SIGNATURE_FAIL = "BOM_CONNECTOR_SIGN_FAIL_T";
		public static final String PARSING_FAIL = "BOM_CONNECTOR_PARSE_FAIL_T";
		public static final String FORMATTING_FAIL = "BOM_CONNECTOR_FORMAT_FAIL_T";
		public static final String CONNECTION_FAIL = "BOM_CONNECTOR_CONNECTION_T";
		public static final String RECEIVE_LIQUIDACIONFINAL = "BOM_CONNECTOR_RECEIVE_LIQUIDACIONFINAL_T";
		public static final String LOGOUT_CD = "BOM_CONNECTOR_SEND_LOGOUT_T";
		public static final String SENDING_FAIL = "BOM_CONNECTOR_WRITE_ON_SOCKET_T";
		public static final String JUNK_BYTE_CD = "BOM_CONNECTOR_RECEIVED_JUNK_CHAR_T";
		public static final String HANDLE_IN_MSG = "BOM_CONNECTOR_HANDLE_IN_MSG";
		public static final String SAVE_ENSESION_CD = "BOM_CONNECTOR_SAVE_ENSESION";
		public static final String BOM_CONNECTOR_CANCELLATION = "BOM_CONNECTOR_CANCELLATION";
		public static final String ACUSE_NOT_FOUND = "BOM_CONNECTOR_ACUSE_NOT_FOUND";
		public static final String MSG_NOT_PROCESSABLE = "MSG_NOT_PROCESSABLE";
		
		
		//below is general constant related to alert
		public static final String COMPONENT_NM = "componentName";
		public static final String ALERT_CD = "alert_code";
		public static final String UNIQUE_REF = "uni_ref";
		public static final String ALERT_LOG = "alert_log";
		public static final String SERVER_NM = "servername";
		public static final String IP = "ip";
		public static final String PORT = "port";
		public static final String SERIAL_NO = "port";
		public static final String FOLIO = "folio";
		
		
		
	}
	
	public static class BomMessageTypeConstants{
		public static final String TRASPASOSPEISIAC = "TRASPASOSPEISIAC";
		public static final String CAMBIARESERVADO = "CAMBIARESERVADO";
		public static final String TRASPASOSIACSPEI ="TRASPASOSIACSPEI";
	}
	
	public static final class ConnectionConstants{
		public static final String CONNECTION_ERROR = "CONNECTION-ERROR";
		public static final String CONNECTED = "CONNECTED";
		public static final String DISCONNECTED = "DISCONNECTED";
		
	}
	public static final class ParticipantCertConstants{
		public static final String ACTIVE = "A";
		public static final String IN_ACTIVE = "D";
		public static final String REVOKED = "R";
		public static final String NOT_EXIST_ON_ARA = "X";
		public static final String NEW = "N";
		public static final String PROCESSING = "PROCESSING";
	}
	
	public static final class ParticipantConstants{
		public static final String RECEPTIVE = "R";
		public static final String NON_RECEPTIVE = "X";
		public static final String INACTIVE = "D";
	}
	
	public static final class ConfigConstants {
		public static final String DAYS_INACTV_PERM_DISABLE = "DAYS_INACTV_PERM_DISABLE";
		public static final String NO_DAYS_ARC_PMT = "NO_DAYS_ARC_PMT";
		public static final String NO_DAYS_TXN_PMT = "NO_DAYS_TXN_PMT";
		public static final String NO_DAYS_ARC_FEC = "NO_DAYS_ARC_FEC";
		public static final String NO_DAYS_TXN_FEC = "NO_DAYS_TXN_FEC";
		public static final String NO_DAYS_ARC_ARA = "NO_DAYS_ARC_ARA";
		public static final String NO_DAYS_TXN_ARA = "NO_DAYS_TXN_ARA";
		public static final String NO_DAYS_ARC_LIQ = "NO_DAYS_ARC_LIQ";
		public static final String NO_DAYS_TXN_LIQ = "NO_DAYS_TXN_LIQ";
		public static final String NO_DAYS_ARC_FILE = "NO_DAYS_ARC_FILE";
		public static final String NO_DAYS_TXN_FILE = "NO_DAYS_TXN_FILE";
		public static final String NO_DAYS_MST_TRACKER = "NO_DAYS_MST_TRACKER";
		public static final String NO_RECORDS_ARC_DB_ERR = "NO_RECORDS_ARC_DB_ERR";
		public static final String PARTICIPANT_KEY = "PARTICIPANT_KEY";
		public static final String PRIVATE_KEY_SERIAL_NO = "PRIVATE_KEY_SERIAL_NO";
		public static final String MAX_PMT_PER_FEC_MSG = "MAX_PMT_PER_FEC_MSG";
		public static final String EOD_TIME = "EOD_TIME";
		public static final String EOD_TIME_FORCEFULLY = "EOD_TIME_FORCEFULLY";
		public static final String CHANEL1_DEBIT_CARD_ALLOWED = "CHANEL1_DEBIT_CARD_ALLOWED";
		public static final String CDB_FLAG = "CDB_FLAG";
		public static final String SECTOR = "SECTOR";
		public static final String BUSINESS_LINE = "BUSINESS_LINE";
		public static final String PRODUCT = "PRODUCT";
		public static final String SUB_PRODUCT = "SUB_PRODUCT";
		public static final String BATCH_SIZE = "BATCH_SIZE";
		public static final String START_OF_THE_DAY = "START_OF_THE_DAY";
		public static final String END_OF_THE_DAY = "END_OF_THE_DAY";
		public static final String FAILOVER_DELAY_SEC = "FAILOVER_DELAY_SEC";
		public static final String LISTENER_TIMER_FEC_DELAY_MS = "LISTENER_TIMER_FEC_DELAY_MS";
		public static final String LISTENER_TIMER_CACHE_DELAY_MS = "LISTENER_TIMER_CACHE_DELAY_MS";
		public static final String MW_TIMER_WORKFLOW_DELAY_MS = "MW_TIMER_WORKFLOW_DELAY_MS";
		public static final String MW_TIMER_CACHE_DELAY_MS = "MW_TIMER_CACHE_DELAY_MS";
		public static final String MW_TIMER_BOM_DELAY_MS = "MW_TIMER_BOM_DELAY_MS";
		public static final String MW_TIMER_FILE_DELAY_MS = "MW_TIMER_FILE_DELAY_MS";
		public static final String MW_TIMER_FIEL_DELAY_MS = "MW_TIMER_FIEL_DELAY_MS";
		public static final String MW_TIMER_MQ_DELAY_MS = "MW_TIMER_MQ_DELAY_MS";
		public static final String MW_TIMER_WS_DELAY_MS = "MW_TIMER_WS_DELAY_MS";
		public static final String MW_TIMER_SANITY_DELAY_MS = "MW_TIMER_SANITY_DELAY_MS";
		public static final String MW_THREAD_COUNT_MQ_SENDER = "MW_THREAD_COUNT_MQ_SENDER";
		public static final String MW_THREAD_COUNT_MQ_PARSER = "MW_THREAD_COUNT_MQ_PARSER";
		public static final String MW_THREAD_COUNT_CONTROLLER = "MW_THREAD_COUNT_CONTROLLER";
		public static final String MW_THREAD_COUNT_WS_SENDER = "MW_THREAD_COUNT_WS_SENDER";
		public static final String MW_THREAD_COUNT_SANITY = "MW_THREAD_COUNT_SANITY";
		public static final String MW_THREAD_COUNT_FIEL = "MW_THREAD_COUNT_FIEL";
		public static final String LOGGER_LEVEL_MW = "LOGGER_LEVEL_MW";
		public static final String LOGGER_LEVEL_UI = "LOGGER_LEVEL_UI";
		public static final String LOGGER_LEVEL_LISTENER = "LOGGER_LEVEL_LISTENER";
		public static final String LISTENER_TIMER_ARA_DELAY_MS = "LISTENER_TIMER_ARA_DELAY_MS";
		public static final String SMTP_CONFIG = "SMTP_CONFIG";
		public static final String SMTP_PSWD = "SMTP_PSWD";
		public static final String FAIL_LOGIN_ATTEMPTS = "FAIL_LOGIN_ATTEMPTS";
		public static final String DAYS_RST_PSWD = "DAYS_RST_PSWD";
		public static final String RLS_PRCS_CFG = "RLS_PRCS_CFG";
		public static final String LOGIN_LOCK_TIME = "LOGIN_LOCK_TIME";
		public static final String LDAP_DEFAULT_PASS = "LDAP_DEFAULT_PASS";
		//public static final String SYSTEM_HEALTH_JVM_CRON = "SYSTEM_HEALTH_JVM_CRON";
	}

	public static final class SMTPConfigConstants {

		public static final String SMTP_ENABLE = "smtpEnable";
		public static final String SMTP_HOST = "smtpHost";
		public static final String SMTP_PORT = "smtpPort";
		public static final String SMTP_AUTH = "smtpAuth";
		public static final String SMTP_USER_NM = "smtpUserNm";
		public static final String SMTP_FROM_EMAIL = "smtpFromEmail";
		public static final String SMTP_PROTOCOL = "smtpProtocol";
		public static final String SMTP_CONN_TIME_OUT = "smtpConnTimeOut";
		public static final String SMTP_TIME_OUT = "smtpTimeout";
		public static final String SMTP_TLSENABLE = "smtpTlsEnable";
		public static final String SMTP_SOCKET_FAC_PORT = "smtpSocketFacPort";
		public static final String SMTP_SOCKET_FAC_CLASS = "smtpSocketFacClass";
		public static final String SMTP_SOCKET_FACTORY_FALLBK = "smtpSocketFactoryFallbk";
	}

	public static final class DateFormat {
		public static final String DD_MMM_YYYY_HHMMSS = "dd-MMM-yyyy HH:mm:ss";
		public static final String DD_MM_YYYY_HH24MISS ="DD-MM-YYYY HH24:MI:ss";
		public static final String DD_M_MYYYY_HH_MM_SS = "ddMMyyyy HH:mm:ss.SSS";
		public static final String DD_MMM_YYYY = "dd-MMM-yyyy";
		public static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyyMMdd HH:mm:ss.SSS";
		public static final String TIME_00_00_00_000 = "00:00:00.000";
		public static final String TIME_23_59_59_999 = "23:59:59.999";
		public static final String TIME_00_00_00 = "00:00:00";
		public static final String YYYYMMDD = "yyyyMMdd";
		public static final String HHMMSS = "HHmmss";
		public static final String SS = "SS";
		public static final String DAY = "DAY";
		public static final String HH = "HH";
		public static final String MM = "MM";
		public static final String YY = "YY";
		public static final String YYYY = "YYYY";
		public static final String DD = "DD";

	}

	public static final class TableName {
		public static final String TB_RP_T_BOM_MSG = "TB_RP_T_BOM_MSG";
		public static final String TB_RP_T_PMT_OUT = "TB_RP_T_PMT_OUT";
		public static final String TB_RP_T_LIQ = "TB_RP_T_LIQ";
		public static final String TB_RP_T_PMT_IN = "TB_RP_T_PMT_IN";
		public static final String TB_RP_T_EXT_REQ_RESP = "TB_RP_T_EXT_REQ_RESP";
		public static final String TB_RP_T_INTG_QUEUE = "TB_RP_T_INTG_QUEUE";
		public static final String TB_RP_T_FILE = "TB_RP_T_FILE";
		public static final String TB_RP_A_BOM_MSG = "TB_RP_A_BOM_MSG";
		public static final String TB_RP_A_PMT_OUT = "TB_RP_A_PMT_OUT";
		public static final String TB_RP_A_LIQ = "TB_RP_A_LIQ";
		public static final String TB_RP_A_PMT_IN = "TB_RP_A_PMT_IN";
	}

	public static final class ActivityConstants {
		public static final String NEW = "NEW";
		public static final String PROCESSING = "PROCESSING";
		public static final String SENT_TO_CONNECTOR = "SENT_TO_CONNECTOR";
		public static final String SETTLED = "SETTLED";//final status
		public static final String SETTLED_FAILURE = "SETTLED_FAILURE";
		public static final String SENT_TO_BOM = "SENT_TO_BOM";
		public static final String SENT_TO_BOM_FAILURE = "SENT_TO_BOM_FAILURE";
		public static final String SUCCESS = "SUCCESS";//final status
		public static final String ON_HOLD = "ON_HOLD";
		public static final String BALANCE_SHORTFALL = "BALANCE_SHORTFALL";
		public static final String ACK_RECEIVED = "ACK_RECEIVED";
		public static final String ACK_SENT = "ACK_SENT";
		public static final String NACK_SENT = "NACK_SENT";
		public static final String NACK_RECEIVED = "NACK_RECEIVED";
		public static final String ACUSE_ACK_RECEIVED = "ACUSE_ACK_RECEIVED";
		public static final String ACUSE_NACK_RECEIVED = "ACUSE_NACK_RECEIVED";
		public static final String BOM_SIGN_FAILURE = "BOM_SIGN_FAILURE";
		public static final String BANK_SIGN_FAILURE = "BANK_SIGN_FAILURE";
		public static final String CANCELLED_REJECTED = "CANCELLED_REJECTED";
		public static final String CANCELLED_ACCEPTED = "CANCELLED_ACCEPTED";
		public static final String WAITING_FOR_APPROVAL = "WAITING_FOR_APPROVAL";
		public static final String APPROVED = "APPROVED";
		public static final String PARSED = "PARSED";
		public static final String FORMATTED = "FORMATTED";
		public static final String FORMATTED_FAILURE = "FORMATTED_FAILURE";
		public static final String STARTED = "STARTED";
		public static final String FAILURE = "FAILURE";
		public static final String RETRY_AUTO_EXHAUSTED = "RETRY_AUTO_EXHAUSTED";
		public static final String RETRY_MANUAL_EXHAUSTED = "RETRY_MANUAL_EXHAUSTED";
		public static final String RETRY_MANUAL = "RETRY_MANUAL";
		public static final String AUTO_REJECTED = "AUTO_REJECTED";
		public static final String AUTO_DISCARDED = "AUTO_DISCARDED";
		public static final String MANUAL_DISCARDED = "MANUAL_DISCARDED";//final status
		public static final String DEBIT = "DEBIT";
		public static final String DEBIT_SUCCESS = "DEBIT_SUCCESS";
		public static final String DEBIT_FAILURE = "DEBIT_FAILURE";
		public static final String CREDIT = "CREDIT";
		public static final String CREDIT_SUCCESS = "CREDIT_SUCCESS";
		public static final String CREDIT_FAILURE = "CREDIT_FAILURE";
		public static final String CUSTOMER_VALIDATION = "CUSTOMER_VALIDATION";
		public static final String CUSTOMER_VALIDATION_FAILURE = "CUSTOMER_VALIDATION_FAILURE";
		public static final String CUSTOMER_VALIDATION_SUCCESS = "CUSTOMER_VALIDATION_SUCCESS";
		public static final String FRAUD_VALIDATION = "FRAUD_VALIDATION";
		public static final String FRAUD_VALIDATION_FAILURE = "FRAUD_VALIDATION_FAILURE";
		public static final String FRAUD_VALIDATION_SUCCESS = "FRAUD_VALIDATION_SUCCESS";
		public static final String VALIDATION_INTERNAL = "VALIDATION_INTERNAL";
		public static final String VALIDATION_INTERNAL_FAILURE = "VALIDATION_INTERNAL_FAILURE";
		public static final String VALIDATION_INTERNAL_SUCCESS = "VALIDATION_INTERNAL_SUCCESS";
		public static final String RETURNED = "RETURNED";//final status
		public static final String CEP_SENT = "CEP_SENT";
		public static final String CEP_SETTLED = "CEP_SETTLED";//final status
		public static final String CEP_ERROR = "CEP_ERROR";
		public static final String MSG_NOT_PROCESSABLE = "MSG_NOT_PROCESSABLE";
		public static final String CEP_ERROR_CNTGNCY_PROCESS_SUCCESS = "CEP_ERROR_CNTGNCY_PROCESS_SUCCESS";
		public static final String CEP_ERROR_CNTGNCY_PROCESS = "CEP_ERROR_CNTGNCY_PROCESS";
		public static final String AVISO_TRASPASOSPEISIAC_FAILURE = "AVISO_TRASPASOSPEISIAC_FAILURE";
		public static final String AVISO_CAMBIARESERVADO_FAILURE = "AVISO_CAMBIARESERVADO_FAILURE";
	}

	public static final class PmtConstants {
		public static final String PMT_NEW = "NEW";
		public static final String PMT_RETURNED = "RTRN";
		public static final String PMT_CANCELLED = "X";
		public static final String PMT_SETTLE = "S";
		public static final String PMT_SENT_TO_CONNECTOR = "SENT_TO_CONNECTOR";
		public static final String PMT_SENT_TO_CONNECTOR_PICKED = "PMT_SENT_TO_CONNECTOR_PICKED";
		public static final String PMT_PKG_FOR_BOM = "PKG";
		public static final String PMT_SENT_BOM = "SENT_BOM";
		public static final String PMT_ELEMENATE_BOM = "XE";
		public static final String PMT_CANC_PKG_FOR_BOM = "XPKG";
		public static final String PMT_CANC_SENT_TO_BOM = "XSB";
		public static final String PMT_ACUSERECIBO = "PK";
		public static final String PMT_CEP_ELIGIBLE = "CEPE";
		public static final String PMT_CEP_ELIGIBLE_PICKED = "CEPP";
		public static final String PMT_CEP_ELIGIBLE_SENT = "CEP_SENT";
		public static final String ON_HOLD = "ON_HOLD";
		public static final String ERROR = "ERROR";
		public static final String BALANCE_SHORTFALL = "BALANCE_SHORTFALL";
		public static final String MSG_NOT_PROCESSABLE = "MSG_NOT_PROCESSABLE";
		
		//public static final String RECEIVED = "R";//Processing
		
		
		//public static final String PMT_REJECTED = "REJ";//Rejected
		
		
		//public static final String PMT_SENT_TO_MW = "SENT_TO_MW";//Processing
		
		/**This status we set if we receive error code while message parsing like in acuserecibo we can get error*/ 
		 
		
		//public static final String PMT_CANC_RCVD_BOM = "XAB";//Processing
		//public static final String PMT_CANC_ACUSERECIBO_FAIL = "XX";//AckFail
		//public static final String PMT_FMT_FAIL = "FF";//Error
		//public static final String PMT_CARGOS = "PC";//Processed
		//public static final String PMT_CEP_ELIGIBLE_FORMATTED = "CEPF";//Processing
		//public static final String PMT_CEP_ELIGIBLE_SETTLED = "CEPS";//Processed
		
		//public static final String PMT_CEP_ELIGIBLE_ERROR = "CEP_ERROR";//Processed
		//public static final String PMT_WF_NOT_CONFIGRED = "WFX";//Error
		//public static final String PMT_WF_REJECTED = "WFR";//Error
		//public static final String PAYMENT_VALIDATION_FAIL = "PVF";//validation failure(will retry)
	}

	public static final class IntgQueueActionConstants {
		public static final String CONNECTOR_ACTN_TRANSACTION_PAYMENT_CANCELATION = "CONNECTOR_ACTN_TRANSACTION_PAYMENT_CANCELATION";
		public static final String CONNECTOR_ACTN_TRANSACTION_PAYMENT_CREATION = "CONNECTOR_ACTN_TRANSACTION_PAYMENT_CREATION";
		public static final String CONNECTOR_ACTN_DEFAULT = "CONNECTOR_ACTN_DEFAULT";
		public static final String CONNECTOR_FORMATTER = "CONNECTOR_FORMATTER";
		public static final String CONNECTOR_ACTN_AUTO_RSRV_LIQUIDITY_CREATION ="CONNECTOR_ACTN_AUTO_RSRV_LIQUIDITY_CREATION";
		public static final String CONNECTOR_ACTN_AUTO_UNRSRV_LIQUIDITY_CREATION ="CONNECTOR_ACTN_AUTO_UNRSRV_LIQUIDITY_CREATION";
		public static final String CONNECTOR_ACTN_MANUAL_RSRV_LIQUIDITY_CREATION ="CONNECTOR_ACTN_MANUAL_RSRV_LIQUIDITY_CREATION";
		public static final String CONNECTOR_ACTN_MANUAL_UNRSRV_LIQUIDITY_CREATION ="CONNECTOR_ACTN_MANUAL_UNRSRV_LIQUIDITY_CREATION";
		public static final String CONNECTOR_ACTN_LIQUIDITY_CHANGE = "CONNECTOR_ACTN_LIQUIDITY_CHANGE";
		public static final String CONNECTOR_ACTN_LIQUIDITY_CANCELATION = "CONNECTOR_ACTN_LIQUIDITY_CANCELATION";
		public static final String MIDDLEWARE_ACTN_CNTGNCY_FILE_CREATION = "MIDDLEWARE_ACTN_CNTGNCY_FILE_CREATION";
	}

	public static final class IntgQueueComponentConstants {
		public static final String CONNECTOR_FORMATTER = "CONNECTOR_FORMATTER";
		public static final String MIDDLEWARE_TASK_Q = "MIDDLEWARE_TASK_Q";
	}
	
	public static final class SystemConstants{
		public static final String BOM="BOM";
		public static final String RPS="RPS";
	
	}
}

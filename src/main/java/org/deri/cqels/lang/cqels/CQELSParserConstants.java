/* Generated By:JavaCC: Do not edit this line. CQELSParserConstants.java */
/*
 * (c) Copyright 2004, 2005, 2006, 2007, 2008, 2009 Hewlett-Packard Development Company, LP
 * (c) Copyright 2010 Talis Systems Ltd
 * All rights reserved.
 */
package org.deri.cqels.lang.cqels;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface CQELSParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int SINGLE_LINE_COMMENT = 6;
  /** RegularExpression Id. */
  int WS = 7;
  /** RegularExpression Id. */
  int WSC = 8;
  /** RegularExpression Id. */
  int IRIref = 9;
  /** RegularExpression Id. */
  int PNAME_NS = 10;
  /** RegularExpression Id. */
  int PNAME_LN = 11;
  /** RegularExpression Id. */
  int BLANK_NODE_LABEL = 12;
  /** RegularExpression Id. */
  int VAR1 = 13;
  /** RegularExpression Id. */
  int VAR2 = 14;
  /** RegularExpression Id. */
  int LANGTAG = 15;
  /** RegularExpression Id. */
  int A2Z = 16;
  /** RegularExpression Id. */
  int A2ZN = 17;
  /** RegularExpression Id. */
  int KW_A = 18;
  /** RegularExpression Id. */
  int BASE = 19;
  /** RegularExpression Id. */
  int PREFIX = 20;
  /** RegularExpression Id. */
  int SELECT = 21;
  /** RegularExpression Id. */
  int DISTINCT = 22;
  /** RegularExpression Id. */
  int REDUCED = 23;
  /** RegularExpression Id. */
  int DESCRIBE = 24;
  /** RegularExpression Id. */
  int CONSTRUCT = 25;
  /** RegularExpression Id. */
  int ASK = 26;
  /** RegularExpression Id. */
  int LIMIT = 27;
  /** RegularExpression Id. */
  int OFFSET = 28;
  /** RegularExpression Id. */
  int ORDER = 29;
  /** RegularExpression Id. */
  int BY = 30;
  /** RegularExpression Id. */
  int BINDINGS = 31;
  /** RegularExpression Id. */
  int UNDEF = 32;
  /** RegularExpression Id. */
  int ASC = 33;
  /** RegularExpression Id. */
  int DESC = 34;
  /** RegularExpression Id. */
  int NAMED = 35;
  /** RegularExpression Id. */
  int FROM = 36;
  /** RegularExpression Id. */
  int WHERE = 37;
  /** RegularExpression Id. */
  int AND = 38;
  /** RegularExpression Id. */
  int GRAPH = 39;
  /** RegularExpression Id. */
  int STREAM = 40;
  /** RegularExpression Id. */
  int RANGE = 41;
  /** RegularExpression Id. */
  int TRIPLES = 42;
  /** RegularExpression Id. */
  int SLIDE = 43;
  /** RegularExpression Id. */
  int TUMBLING = 44;
  /** RegularExpression Id. */
  int OPTIONAL = 45;
  /** RegularExpression Id. */
  int UNION = 46;
  /** RegularExpression Id. */
  int MINUS_P = 47;
  /** RegularExpression Id. */
  int BIND = 48;
  /** RegularExpression Id. */
  int SERVICE = 49;
  /** RegularExpression Id. */
  int LET = 50;
  /** RegularExpression Id. */
  int FETCH = 51;
  /** RegularExpression Id. */
  int EXISTS = 52;
  /** RegularExpression Id. */
  int NOT = 53;
  /** RegularExpression Id. */
  int AS = 54;
  /** RegularExpression Id. */
  int GROUP = 55;
  /** RegularExpression Id. */
  int HAVING = 56;
  /** RegularExpression Id. */
  int SEPARATOR = 57;
  /** RegularExpression Id. */
  int AGG = 58;
  /** RegularExpression Id. */
  int COUNT = 59;
  /** RegularExpression Id. */
  int MIN = 60;
  /** RegularExpression Id. */
  int MAX = 61;
  /** RegularExpression Id. */
  int SUM = 62;
  /** RegularExpression Id. */
  int AVG = 63;
  /** RegularExpression Id. */
  int STDDEV = 64;
  /** RegularExpression Id. */
  int SAMPLE = 65;
  /** RegularExpression Id. */
  int GROUP_CONCAT = 66;
  /** RegularExpression Id. */
  int FILTER = 67;
  /** RegularExpression Id. */
  int BOUND = 68;
  /** RegularExpression Id. */
  int COALESCE = 69;
  /** RegularExpression Id. */
  int IN = 70;
  /** RegularExpression Id. */
  int IF = 71;
  /** RegularExpression Id. */
  int BNODE = 72;
  /** RegularExpression Id. */
  int IRI = 73;
  /** RegularExpression Id. */
  int URI = 74;
  /** RegularExpression Id. */
  int CAST = 75;
  /** RegularExpression Id. */
  int CALL = 76;
  /** RegularExpression Id. */
  int STR = 77;
  /** RegularExpression Id. */
  int STRLANG = 78;
  /** RegularExpression Id. */
  int STRDT = 79;
  /** RegularExpression Id. */
  int DTYPE = 80;
  /** RegularExpression Id. */
  int LANG = 81;
  /** RegularExpression Id. */
  int LANGMATCHES = 82;
  /** RegularExpression Id. */
  int IS_URI = 83;
  /** RegularExpression Id. */
  int IS_IRI = 84;
  /** RegularExpression Id. */
  int IS_BLANK = 85;
  /** RegularExpression Id. */
  int IS_LITERAL = 86;
  /** RegularExpression Id. */
  int IS_NUMERIC = 87;
  /** RegularExpression Id. */
  int REGEX = 88;
  /** RegularExpression Id. */
  int SAME_TERM = 89;
  /** RegularExpression Id. */
  int RAND = 90;
  /** RegularExpression Id. */
  int ABS = 91;
  /** RegularExpression Id. */
  int CEIL = 92;
  /** RegularExpression Id. */
  int FLOOR = 93;
  /** RegularExpression Id. */
  int ROUND = 94;
  /** RegularExpression Id. */
  int CONCAT = 95;
  /** RegularExpression Id. */
  int SUBSTR = 96;
  /** RegularExpression Id. */
  int STRLEN = 97;
  /** RegularExpression Id. */
  int UCASE = 98;
  /** RegularExpression Id. */
  int LCASE = 99;
  /** RegularExpression Id. */
  int ENCODE_FOR_URI = 100;
  /** RegularExpression Id. */
  int CONTAINS = 101;
  /** RegularExpression Id. */
  int STRSTARTS = 102;
  /** RegularExpression Id. */
  int STRENDS = 103;
  /** RegularExpression Id. */
  int YEAR = 104;
  /** RegularExpression Id. */
  int MONTH = 105;
  /** RegularExpression Id. */
  int DAY = 106;
  /** RegularExpression Id. */
  int HOURS = 107;
  /** RegularExpression Id. */
  int MINUTES = 108;
  /** RegularExpression Id. */
  int SECONDS = 109;
  /** RegularExpression Id. */
  int TIMEZONE = 110;
  /** RegularExpression Id. */
  int TZ = 111;
  /** RegularExpression Id. */
  int NOW = 112;
  /** RegularExpression Id. */
  int VERSION = 113;
  /** RegularExpression Id. */
  int MD5 = 114;
  /** RegularExpression Id. */
  int SHA1 = 115;
  /** RegularExpression Id. */
  int SHA224 = 116;
  /** RegularExpression Id. */
  int SHA256 = 117;
  /** RegularExpression Id. */
  int SHA384 = 118;
  /** RegularExpression Id. */
  int SHA512 = 119;
  /** RegularExpression Id. */
  int TRUE = 120;
  /** RegularExpression Id. */
  int FALSE = 121;
  /** RegularExpression Id. */
  int DATA = 122;
  /** RegularExpression Id. */
  int INSERT = 123;
  /** RegularExpression Id. */
  int DELETE = 124;
  /** RegularExpression Id. */
  int INSERT_DATA = 125;
  /** RegularExpression Id. */
  int DELETE_DATA = 126;
  /** RegularExpression Id. */
  int DELETE_WHERE = 127;
  /** RegularExpression Id. */
  int MODIFY = 128;
  /** RegularExpression Id. */
  int LOAD = 129;
  /** RegularExpression Id. */
  int CLEAR = 130;
  /** RegularExpression Id. */
  int CREATE = 131;
  /** RegularExpression Id. */
  int ADD = 132;
  /** RegularExpression Id. */
  int MOVE = 133;
  /** RegularExpression Id. */
  int COPY = 134;
  /** RegularExpression Id. */
  int META = 135;
  /** RegularExpression Id. */
  int SILENT = 136;
  /** RegularExpression Id. */
  int DROP = 137;
  /** RegularExpression Id. */
  int INTO = 138;
  /** RegularExpression Id. */
  int TO = 139;
  /** RegularExpression Id. */
  int DFT = 140;
  /** RegularExpression Id. */
  int ALL = 141;
  /** RegularExpression Id. */
  int WITH = 142;
  /** RegularExpression Id. */
  int USING = 143;
  /** RegularExpression Id. */
  int DIGITS = 144;
  /** RegularExpression Id. */
  int INTEGER = 145;
  /** RegularExpression Id. */
  int DURATION = 146;
  /** RegularExpression Id. */
  int DECIMAL = 147;
  /** RegularExpression Id. */
  int DOUBLE = 148;
  /** RegularExpression Id. */
  int INTEGER_POSITIVE = 149;
  /** RegularExpression Id. */
  int DECIMAL_POSITIVE = 150;
  /** RegularExpression Id. */
  int DOUBLE_POSITIVE = 151;
  /** RegularExpression Id. */
  int INTEGER_NEGATIVE = 152;
  /** RegularExpression Id. */
  int DECIMAL_NEGATIVE = 153;
  /** RegularExpression Id. */
  int DOUBLE_NEGATIVE = 154;
  /** RegularExpression Id. */
  int EXPONENT = 155;
  /** RegularExpression Id. */
  int QUOTE_3D = 156;
  /** RegularExpression Id. */
  int QUOTE_3S = 157;
  /** RegularExpression Id. */
  int ECHAR = 158;
  /** RegularExpression Id. */
  int STRING_LITERAL1 = 159;
  /** RegularExpression Id. */
  int STRING_LITERAL2 = 160;
  /** RegularExpression Id. */
  int STRING_LITERAL_LONG1 = 161;
  /** RegularExpression Id. */
  int STRING_LITERAL_LONG2 = 162;
  /** RegularExpression Id. */
  int LPAREN = 163;
  /** RegularExpression Id. */
  int RPAREN = 164;
  /** RegularExpression Id. */
  int NIL = 165;
  /** RegularExpression Id. */
  int LBRACE = 166;
  /** RegularExpression Id. */
  int RBRACE = 167;
  /** RegularExpression Id. */
  int LBRACKET = 168;
  /** RegularExpression Id. */
  int RBRACKET = 169;
  /** RegularExpression Id. */
  int ANON = 170;
  /** RegularExpression Id. */
  int SEMICOLON = 171;
  /** RegularExpression Id. */
  int COMMA = 172;
  /** RegularExpression Id. */
  int DOT = 173;
  /** RegularExpression Id. */
  int EQ = 174;
  /** RegularExpression Id. */
  int NE = 175;
  /** RegularExpression Id. */
  int GT = 176;
  /** RegularExpression Id. */
  int LT = 177;
  /** RegularExpression Id. */
  int LE = 178;
  /** RegularExpression Id. */
  int GE = 179;
  /** RegularExpression Id. */
  int BANG = 180;
  /** RegularExpression Id. */
  int TILDE = 181;
  /** RegularExpression Id. */
  int COLON = 182;
  /** RegularExpression Id. */
  int SC_OR = 183;
  /** RegularExpression Id. */
  int SC_AND = 184;
  /** RegularExpression Id. */
  int PLUS = 185;
  /** RegularExpression Id. */
  int MINUS = 186;
  /** RegularExpression Id. */
  int STAR = 187;
  /** RegularExpression Id. */
  int SLASH = 188;
  /** RegularExpression Id. */
  int DATATYPE = 189;
  /** RegularExpression Id. */
  int AT = 190;
  /** RegularExpression Id. */
  int ASSIGN = 191;
  /** RegularExpression Id. */
  int VBAR = 192;
  /** RegularExpression Id. */
  int CARAT = 193;
  /** RegularExpression Id. */
  int FPATH = 194;
  /** RegularExpression Id. */
  int RPATH = 195;
  /** RegularExpression Id. */
  int QMARK = 196;
  /** RegularExpression Id. */
  int PN_CHARS_BASE = 197;
  /** RegularExpression Id. */
  int PN_CHARS_U = 198;
  /** RegularExpression Id. */
  int PN_CHARS = 199;
  /** RegularExpression Id. */
  int PN_PREFIX = 200;
  /** RegularExpression Id. */
  int PN_LOCAL = 201;
  /** RegularExpression Id. */
  int VARNAME = 202;
  /** RegularExpression Id. */
  int UNKNOWN = 203;

  /** Lexical state. */
  int DEFAULT = 0;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\"",
    "\"\\f\"",
    "<SINGLE_LINE_COMMENT>",
    "<WS>",
    "<WSC>",
    "<IRIref>",
    "<PNAME_NS>",
    "<PNAME_LN>",
    "<BLANK_NODE_LABEL>",
    "<VAR1>",
    "<VAR2>",
    "<LANGTAG>",
    "<A2Z>",
    "<A2ZN>",
    "\"a\"",
    "\"base\"",
    "\"prefix\"",
    "\"select\"",
    "\"distinct\"",
    "\"reduced\"",
    "\"describe\"",
    "\"construct\"",
    "\"ask\"",
    "\"limit\"",
    "\"offset\"",
    "\"order\"",
    "\"by\"",
    "\"bindings\"",
    "\"undef\"",
    "\"asc\"",
    "\"desc\"",
    "\"named\"",
    "\"from\"",
    "\"where\"",
    "\"and\"",
    "\"graph\"",
    "\"stream\"",
    "\"range\"",
    "\"triples\"",
    "\"slide\"",
    "\"tumbling\"",
    "\"optional\"",
    "\"union\"",
    "\"minus\"",
    "\"bind\"",
    "\"service\"",
    "\"let\"",
    "\"fetch\"",
    "\"exists\"",
    "\"not\"",
    "\"as\"",
    "\"group\"",
    "\"having\"",
    "\"separator\"",
    "\"agg\"",
    "\"count\"",
    "\"min\"",
    "\"max\"",
    "\"sum\"",
    "\"avg\"",
    "\"stdev\"",
    "\"sample\"",
    "\"group_concat\"",
    "\"filter\"",
    "\"bound\"",
    "\"coalesce\"",
    "\"in\"",
    "\"if\"",
    "\"bnode\"",
    "\"iri\"",
    "\"uri\"",
    "\"cast\"",
    "\"call\"",
    "\"str\"",
    "\"strlang\"",
    "\"strdt\"",
    "\"datatype\"",
    "\"lang\"",
    "\"langmatches\"",
    "\"isURI\"",
    "\"isIRI\"",
    "\"isBlank\"",
    "\"isLiteral\"",
    "\"isNumeric\"",
    "\"regex\"",
    "\"sameTerm\"",
    "\"RAND\"",
    "\"ABS\"",
    "\"CEIL\"",
    "\"FLOOR\"",
    "\"ROUND\"",
    "\"CONCAT\"",
    "\"SUBSTR\"",
    "\"STRLEN\"",
    "\"UCASE\"",
    "\"LCASE\"",
    "\"ENCODE_FOR_URI\"",
    "\"CONTAINS\"",
    "\"strSTARTS\"",
    "\"strENDS\"",
    "\"YEAR\"",
    "\"MONTH\"",
    "\"DAY\"",
    "\"HOURS\"",
    "\"MINUTES\"",
    "\"SECONDS\"",
    "\"TIMEZONE\"",
    "\"TZ\"",
    "\"NOW\"",
    "\"VERSION\"",
    "\"MD5\"",
    "\"SHA1\"",
    "\"SHA224\"",
    "\"SHA256\"",
    "\"SHA384\"",
    "\"SHA512\"",
    "\"true\"",
    "\"false\"",
    "\"data\"",
    "\"insert\"",
    "\"delete\"",
    "<INSERT_DATA>",
    "<DELETE_DATA>",
    "<DELETE_WHERE>",
    "\"modify\"",
    "\"load\"",
    "\"clear\"",
    "\"create\"",
    "\"add\"",
    "\"move\"",
    "\"copy\"",
    "\"meta\"",
    "\"silent\"",
    "\"drop\"",
    "\"into\"",
    "\"to\"",
    "\"default\"",
    "\"all\"",
    "\"with\"",
    "\"using\"",
    "<DIGITS>",
    "<INTEGER>",
    "<DURATION>",
    "<DECIMAL>",
    "<DOUBLE>",
    "<INTEGER_POSITIVE>",
    "<DECIMAL_POSITIVE>",
    "<DOUBLE_POSITIVE>",
    "<INTEGER_NEGATIVE>",
    "<DECIMAL_NEGATIVE>",
    "<DOUBLE_NEGATIVE>",
    "<EXPONENT>",
    "\"\\\"\\\"\\\"\"",
    "\"\\\'\\\'\\\'\"",
    "<ECHAR>",
    "<STRING_LITERAL1>",
    "<STRING_LITERAL2>",
    "<STRING_LITERAL_LONG1>",
    "<STRING_LITERAL_LONG2>",
    "\"(\"",
    "\")\"",
    "<NIL>",
    "\"{\"",
    "\"}\"",
    "\"[\"",
    "\"]\"",
    "<ANON>",
    "\";\"",
    "\",\"",
    "\".\"",
    "\"=\"",
    "\"!=\"",
    "\">\"",
    "\"<\"",
    "\"<=\"",
    "\">=\"",
    "\"!\"",
    "\"~\"",
    "\":\"",
    "\"||\"",
    "\"&&\"",
    "\"+\"",
    "\"-\"",
    "\"*\"",
    "\"/\"",
    "\"^^\"",
    "\"@\"",
    "\":=\"",
    "\"|\"",
    "\"^\"",
    "\"->\"",
    "\"<-\"",
    "\"?\"",
    "<PN_CHARS_BASE>",
    "<PN_CHARS_U>",
    "<PN_CHARS>",
    "<PN_PREFIX>",
    "<PN_LOCAL>",
    "<VARNAME>",
    "<UNKNOWN>",
  };

}

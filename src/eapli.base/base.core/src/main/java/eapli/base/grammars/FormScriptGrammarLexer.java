// Generated from FormScriptGrammar.g4 by ANTLR 4.9.2
package eapli.base.grammars;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FormScriptGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, BOOLEAN=2, DOUBLE=3, STRING=4, FLOAT=5, LONG=6, EQ=7, NEQ=8, LTEQ=9, 
		GTEQ=10, GT=11, LT=12, AMP=13, COLON=14, ATTRIB=15, HASHTAG=16, COMMA=17, 
		SEMI=18, LPAR=19, RPAR=20, LBRACKET=21, RBRACKET=22, SIDE_BAR_RL=23, UNDER=24, 
		AT=25, DOT=26, CURRENCY_HEADER=27, EURO=28, CURRENCY=29, IF=30, STR=31, 
		NUM=32, NEWLINE=33, WS=34;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT", "BOOLEAN", "DOUBLE", "STRING", "FLOAT", "LONG", "EQ", "NEQ", "LTEQ", 
			"GTEQ", "GT", "LT", "AMP", "ABS", "EXCL", "COLON", "ATTRIB", "HASHTAG", 
			"COMMA", "SEMI", "LPAR", "RPAR", "LBRACKET", "RBRACKET", "SIDE_BAR_RL", 
			"UNDER", "AT", "DOT", "CURRENCY_HEADER", "EURO", "CURRENCY", "IF", "STR", 
			"NUM", "NEWLINE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'boolean'", "'double'", null, "'float'", null, "'='", 
			"'<>'", "'<='", "'>='", "'>'", "'<'", "'&'", "':'", "':='", "'#'", "','", 
			"';'", "'('", "')'", "'{'", "'}'", "'/'", "'_'", "'@'", "'.'", null, 
			"'#euro'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "BOOLEAN", "DOUBLE", "STRING", "FLOAT", "LONG", "EQ", "NEQ", 
			"LTEQ", "GTEQ", "GT", "LT", "AMP", "COLON", "ATTRIB", "HASHTAG", "COMMA", 
			"SEMI", "LPAR", "RPAR", "LBRACKET", "RBRACKET", "SIDE_BAR_RL", "UNDER", 
			"AT", "DOT", "CURRENCY_HEADER", "EURO", "CURRENCY", "IF", "STR", "NUM", 
			"NEWLINE", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public FormScriptGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FormScriptGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u00ec\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\5\5k\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\5\7{\n\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f"+
		"\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3"+
		"\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3"+
		"\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u00bf"+
		"\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \5 \u00cd\n \3!\3"+
		"!\3!\3!\3!\3!\5!\u00d5\n!\3\"\6\"\u00d8\n\"\r\"\16\"\u00d9\3#\6#\u00dd"+
		"\n#\r#\16#\u00de\3$\5$\u00e2\n$\3$\3$\3%\6%\u00e7\n%\r%\16%\u00e8\3%\3"+
		"%\2\2&\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\2\37\2!\20#\21%\22\'\23)\24+\25-\26/\27\61\30\63\31\65\32\67\339\34"+
		";\35=\36?\37A C!E\"G#I$\3\2\5\4\2C\\c|\3\2\62;\4\2\13\13\"\"\2\u00f5\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\3K\3\2\2\2\5O"+
		"\3\2\2\2\7W\3\2\2\2\tj\3\2\2\2\13l\3\2\2\2\rz\3\2\2\2\17|\3\2\2\2\21~"+
		"\3\2\2\2\23\u0081\3\2\2\2\25\u0084\3\2\2\2\27\u0087\3\2\2\2\31\u0089\3"+
		"\2\2\2\33\u008b\3\2\2\2\35\u008d\3\2\2\2\37\u008f\3\2\2\2!\u0091\3\2\2"+
		"\2#\u0093\3\2\2\2%\u0096\3\2\2\2\'\u0098\3\2\2\2)\u009a\3\2\2\2+\u009c"+
		"\3\2\2\2-\u009e\3\2\2\2/\u00a0\3\2\2\2\61\u00a2\3\2\2\2\63\u00a4\3\2\2"+
		"\2\65\u00a6\3\2\2\2\67\u00a8\3\2\2\29\u00aa\3\2\2\2;\u00be\3\2\2\2=\u00c0"+
		"\3\2\2\2?\u00cc\3\2\2\2A\u00d4\3\2\2\2C\u00d7\3\2\2\2E\u00dc\3\2\2\2G"+
		"\u00e1\3\2\2\2I\u00e6\3\2\2\2KL\7k\2\2LM\7p\2\2MN\7v\2\2N\4\3\2\2\2OP"+
		"\7d\2\2PQ\7q\2\2QR\7q\2\2RS\7n\2\2ST\7g\2\2TU\7c\2\2UV\7p\2\2V\6\3\2\2"+
		"\2WX\7f\2\2XY\7q\2\2YZ\7w\2\2Z[\7d\2\2[\\\7n\2\2\\]\7g\2\2]\b\3\2\2\2"+
		"^_\7u\2\2_`\7v\2\2`a\7t\2\2ab\7k\2\2bc\7p\2\2ck\7i\2\2de\7U\2\2ef\7v\2"+
		"\2fg\7t\2\2gh\7k\2\2hi\7p\2\2ik\7i\2\2j^\3\2\2\2jd\3\2\2\2k\n\3\2\2\2"+
		"lm\7h\2\2mn\7n\2\2no\7q\2\2op\7c\2\2pq\7v\2\2q\f\3\2\2\2rs\7n\2\2st\7"+
		"q\2\2tu\7p\2\2u{\7i\2\2vw\7N\2\2wx\7q\2\2xy\7p\2\2y{\7i\2\2zr\3\2\2\2"+
		"zv\3\2\2\2{\16\3\2\2\2|}\7?\2\2}\20\3\2\2\2~\177\7>\2\2\177\u0080\7@\2"+
		"\2\u0080\22\3\2\2\2\u0081\u0082\7>\2\2\u0082\u0083\7?\2\2\u0083\24\3\2"+
		"\2\2\u0084\u0085\7@\2\2\u0085\u0086\7?\2\2\u0086\26\3\2\2\2\u0087\u0088"+
		"\7@\2\2\u0088\30\3\2\2\2\u0089\u008a\7>\2\2\u008a\32\3\2\2\2\u008b\u008c"+
		"\7(\2\2\u008c\34\3\2\2\2\u008d\u008e\7&\2\2\u008e\36\3\2\2\2\u008f\u0090"+
		"\7#\2\2\u0090 \3\2\2\2\u0091\u0092\7<\2\2\u0092\"\3\2\2\2\u0093\u0094"+
		"\7<\2\2\u0094\u0095\7?\2\2\u0095$\3\2\2\2\u0096\u0097\7%\2\2\u0097&\3"+
		"\2\2\2\u0098\u0099\7.\2\2\u0099(\3\2\2\2\u009a\u009b\7=\2\2\u009b*\3\2"+
		"\2\2\u009c\u009d\7*\2\2\u009d,\3\2\2\2\u009e\u009f\7+\2\2\u009f.\3\2\2"+
		"\2\u00a0\u00a1\7}\2\2\u00a1\60\3\2\2\2\u00a2\u00a3\7\177\2\2\u00a3\62"+
		"\3\2\2\2\u00a4\u00a5\7\61\2\2\u00a5\64\3\2\2\2\u00a6\u00a7\7a\2\2\u00a7"+
		"\66\3\2\2\2\u00a8\u00a9\7B\2\2\u00a98\3\2\2\2\u00aa\u00ab\7\60\2\2\u00ab"+
		":\3\2\2\2\u00ac\u00ad\7%\2\2\u00ad\u00ae\7g\2\2\u00ae\u00af\7w\2\2\u00af"+
		"\u00b0\7t\2\2\u00b0\u00bf\7q\2\2\u00b1\u00b2\7%\2\2\u00b2\u00b3\7f\2\2"+
		"\u00b3\u00b4\7q\2\2\u00b4\u00b5\7n\2\2\u00b5\u00b6\7n\2\2\u00b6\u00b7"+
		"\7c\2\2\u00b7\u00bf\7t\2\2\u00b8\u00b9\7%\2\2\u00b9\u00ba\7r\2\2\u00ba"+
		"\u00bb\7q\2\2\u00bb\u00bc\7w\2\2\u00bc\u00bd\7p\2\2\u00bd\u00bf\7f\2\2"+
		"\u00be\u00ac\3\2\2\2\u00be\u00b1\3\2\2\2\u00be\u00b8\3\2\2\2\u00bf<\3"+
		"\2\2\2\u00c0\u00c1\7%\2\2\u00c1\u00c2\7g\2\2\u00c2\u00c3\7w\2\2\u00c3"+
		"\u00c4\7t\2\2\u00c4\u00c5\7q\2\2\u00c5>\3\2\2\2\u00c6\u00cd\7&\2\2\u00c7"+
		"\u00c8\7\u00c4\2\2\u00c8\u00cd\7\u00a5\2\2\u00c9\u00ca\7\u00e4\2\2\u00ca"+
		"\u00cb\7\u201c\2\2\u00cb\u00cd\7\u00ae\2\2\u00cc\u00c6\3\2\2\2\u00cc\u00c7"+
		"\3\2\2\2\u00cc\u00c9\3\2\2\2\u00cd@\3\2\2\2\u00ce\u00cf\7k\2\2\u00cf\u00d5"+
		"\7h\2\2\u00d0\u00d1\7K\2\2\u00d1\u00d5\7h\2\2\u00d2\u00d3\7K\2\2\u00d3"+
		"\u00d5\7H\2\2\u00d4\u00ce\3\2\2\2\u00d4\u00d0\3\2\2\2\u00d4\u00d2\3\2"+
		"\2\2\u00d5B\3\2\2\2\u00d6\u00d8\t\2\2\2\u00d7\u00d6\3\2\2\2\u00d8\u00d9"+
		"\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00daD\3\2\2\2\u00db"+
		"\u00dd\t\3\2\2\u00dc\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00dc\3\2"+
		"\2\2\u00de\u00df\3\2\2\2\u00dfF\3\2\2\2\u00e0\u00e2\7\17\2\2\u00e1\u00e0"+
		"\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\7\f\2\2\u00e4"+
		"H\3\2\2\2\u00e5\u00e7\t\4\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2"+
		"\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb"+
		"\b%\2\2\u00ebJ\3\2\2\2\f\2jz\u00be\u00cc\u00d4\u00d9\u00de\u00e1\u00e8"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
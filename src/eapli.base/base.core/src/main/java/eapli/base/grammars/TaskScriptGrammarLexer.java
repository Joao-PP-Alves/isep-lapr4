// Generated from TaskScriptGrammar.g4 by ANTLR 4.9.2
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
public class TaskScriptGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, EQ=7, NEQ=8, LTEQ=9, GTEQ=10, 
		GT=11, LT=12, PLUS=13, MINUS=14, MULTI=15, DIV=16, POWER=17, PERCENT=18, 
		COMMA=19, SEMI=20, LPAR=21, RPAR=22, LBRACKET=23, RBRACKET=24, UNDER=25, 
		AT=26, DOT=27, DOLLAR=28, EURO=29, FILE_CATCHER=30, EMAIL_CATCHER=31, 
		STR=32, NUM=33, NEWLINE=34, WS=35;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "EQ", "NEQ", "LTEQ", 
			"GTEQ", "GT", "LT", "PLUS", "MINUS", "MULTI", "DIV", "POWER", "PERCENT", 
			"COMMA", "SEMI", "LPAR", "RPAR", "LBRACKET", "RBRACKET", "UNDER", "AT", 
			"DOT", "DOLLAR", "EURO", "FILE_CATCHER", "EMAIL_CATCHER", "STR", "NUM", 
			"NEWLINE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'write to ''", "'''", "'read from ''", "'.txt'", "'.xsl'", "'.xml'", 
			"'='", "'<>'", "'<='", "'>='", "'>'", "'<'", "'+'", "'-'", "'*'", "'/'", 
			"'^'", "'%'", "','", "';'", "'('", "')'", "'{'", "'}'", "'_'", "'@'", 
			"'.'", "'$'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "EQ", "NEQ", "LTEQ", "GTEQ", 
			"GT", "LT", "PLUS", "MINUS", "MULTI", "DIV", "POWER", "PERCENT", "COMMA", 
			"SEMI", "LPAR", "RPAR", "LBRACKET", "RBRACKET", "UNDER", "AT", "DOT", 
			"DOLLAR", "EURO", "FILE_CATCHER", "EMAIL_CATCHER", "STR", "NUM", "NEWLINE", 
			"WS"
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


	public TaskScriptGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TaskScriptGrammar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2%\u00d7\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3"+
		"\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3"+
		"\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3"+
		"\36\3\36\3\36\5\36\u00a6\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\5\37\u00b2\n\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u00c0"+
		"\n \3!\6!\u00c3\n!\r!\16!\u00c4\3\"\6\"\u00c8\n\"\r\"\16\"\u00c9\3#\5"+
		"#\u00cd\n#\3#\3#\3$\6$\u00d2\n$\r$\16$\u00d3\3$\3$\2\2%\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%\3\2\5\4\2C\\c|\3\2\62;\4\2\13\13\"\"\2\u00dd\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\3I\3\2\2\2\5T\3\2\2\2"+
		"\7V\3\2\2\2\tb\3\2\2\2\13g\3\2\2\2\rl\3\2\2\2\17q\3\2\2\2\21s\3\2\2\2"+
		"\23v\3\2\2\2\25y\3\2\2\2\27|\3\2\2\2\31~\3\2\2\2\33\u0080\3\2\2\2\35\u0082"+
		"\3\2\2\2\37\u0084\3\2\2\2!\u0086\3\2\2\2#\u0088\3\2\2\2%\u008a\3\2\2\2"+
		"\'\u008c\3\2\2\2)\u008e\3\2\2\2+\u0090\3\2\2\2-\u0092\3\2\2\2/\u0094\3"+
		"\2\2\2\61\u0096\3\2\2\2\63\u0098\3\2\2\2\65\u009a\3\2\2\2\67\u009c\3\2"+
		"\2\29\u009e\3\2\2\2;\u00a5\3\2\2\2=\u00b1\3\2\2\2?\u00bf\3\2\2\2A\u00c2"+
		"\3\2\2\2C\u00c7\3\2\2\2E\u00cc\3\2\2\2G\u00d1\3\2\2\2IJ\7y\2\2JK\7t\2"+
		"\2KL\7k\2\2LM\7v\2\2MN\7g\2\2NO\7\"\2\2OP\7v\2\2PQ\7q\2\2QR\7\"\2\2RS"+
		"\7)\2\2S\4\3\2\2\2TU\7)\2\2U\6\3\2\2\2VW\7t\2\2WX\7g\2\2XY\7c\2\2YZ\7"+
		"f\2\2Z[\7\"\2\2[\\\7h\2\2\\]\7t\2\2]^\7q\2\2^_\7o\2\2_`\7\"\2\2`a\7)\2"+
		"\2a\b\3\2\2\2bc\7\60\2\2cd\7v\2\2de\7z\2\2ef\7v\2\2f\n\3\2\2\2gh\7\60"+
		"\2\2hi\7z\2\2ij\7u\2\2jk\7n\2\2k\f\3\2\2\2lm\7\60\2\2mn\7z\2\2no\7o\2"+
		"\2op\7n\2\2p\16\3\2\2\2qr\7?\2\2r\20\3\2\2\2st\7>\2\2tu\7@\2\2u\22\3\2"+
		"\2\2vw\7>\2\2wx\7?\2\2x\24\3\2\2\2yz\7@\2\2z{\7?\2\2{\26\3\2\2\2|}\7@"+
		"\2\2}\30\3\2\2\2~\177\7>\2\2\177\32\3\2\2\2\u0080\u0081\7-\2\2\u0081\34"+
		"\3\2\2\2\u0082\u0083\7/\2\2\u0083\36\3\2\2\2\u0084\u0085\7,\2\2\u0085"+
		" \3\2\2\2\u0086\u0087\7\61\2\2\u0087\"\3\2\2\2\u0088\u0089\7`\2\2\u0089"+
		"$\3\2\2\2\u008a\u008b\7\'\2\2\u008b&\3\2\2\2\u008c\u008d\7.\2\2\u008d"+
		"(\3\2\2\2\u008e\u008f\7=\2\2\u008f*\3\2\2\2\u0090\u0091\7*\2\2\u0091,"+
		"\3\2\2\2\u0092\u0093\7+\2\2\u0093.\3\2\2\2\u0094\u0095\7}\2\2\u0095\60"+
		"\3\2\2\2\u0096\u0097\7\177\2\2\u0097\62\3\2\2\2\u0098\u0099\7a\2\2\u0099"+
		"\64\3\2\2\2\u009a\u009b\7B\2\2\u009b\66\3\2\2\2\u009c\u009d\7\60\2\2\u009d"+
		"8\3\2\2\2\u009e\u009f\7&\2\2\u009f:\3\2\2\2\u00a0\u00a1\7\u00e4\2\2\u00a1"+
		"\u00a2\7\u201c\2\2\u00a2\u00a6\7\u00ae\2\2\u00a3\u00a4\7\u00c4\2\2\u00a4"+
		"\u00a6\7\u00a5\2\2\u00a5\u00a0\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6<\3\2"+
		"\2\2\u00a7\u00a8\7h\2\2\u00a8\u00a9\7k\2\2\u00a9\u00aa\7n\2\2\u00aa\u00ab"+
		"\7g\2\2\u00ab\u00b2\7<\2\2\u00ac\u00ad\7H\2\2\u00ad\u00ae\7k\2\2\u00ae"+
		"\u00af\7n\2\2\u00af\u00b0\7g\2\2\u00b0\u00b2\7<\2\2\u00b1\u00a7\3\2\2"+
		"\2\u00b1\u00ac\3\2\2\2\u00b2>\3\2\2\2\u00b3\u00b4\7g\2\2\u00b4\u00b5\7"+
		"o\2\2\u00b5\u00b6\7c\2\2\u00b6\u00b7\7k\2\2\u00b7\u00b8\7n\2\2\u00b8\u00c0"+
		"\7<\2\2\u00b9\u00ba\7G\2\2\u00ba\u00bb\7o\2\2\u00bb\u00bc\7c\2\2\u00bc"+
		"\u00bd\7k\2\2\u00bd\u00be\7n\2\2\u00be\u00c0\7<\2\2\u00bf\u00b3\3\2\2"+
		"\2\u00bf\u00b9\3\2\2\2\u00c0@\3\2\2\2\u00c1\u00c3\t\2\2\2\u00c2\u00c1"+
		"\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"B\3\2\2\2\u00c6\u00c8\t\3\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2"+
		"\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00caD\3\2\2\2\u00cb\u00cd\7"+
		"\17\2\2\u00cc\u00cb\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce"+
		"\u00cf\7\f\2\2\u00cfF\3\2\2\2\u00d0\u00d2\t\4\2\2\u00d1\u00d0\3\2\2\2"+
		"\u00d2\u00d3\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5"+
		"\3\2\2\2\u00d5\u00d6\b$\2\2\u00d6H\3\2\2\2\n\2\u00a5\u00b1\u00bf\u00c4"+
		"\u00c9\u00cc\u00d3\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
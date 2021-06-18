// Generated from TaskScriptGrammar.g4 by ANTLR 4.9.2
package eapli.base.grammars;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TaskScriptGrammarParser extends Parser {
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
	public static final int
		RULE_init = 0, RULE_exprs = 1, RULE_expr = 2, RULE_operation = 3, RULE_symbol = 4, 
		RULE_email = 5, RULE_body = 6, RULE_oper = 7, RULE_file = 8, RULE_filename = 9, 
		RULE_extension = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"init", "exprs", "expr", "operation", "symbol", "email", "body", "oper", 
			"file", "filename", "extension"
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

	@Override
	public String getGrammarFileName() { return "TaskScriptGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TaskScriptGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class InitContext extends ParserRuleContext {
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaskScriptGrammarListener ) ((TaskScriptGrammarListener)listener).enterInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaskScriptGrammarListener ) ((TaskScriptGrammarListener)listener).exitInit(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_init);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			exprs();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprsContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(TaskScriptGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(TaskScriptGrammarParser.NEWLINE, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaskScriptGrammarListener ) ((TaskScriptGrammarListener)listener).enterExprs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaskScriptGrammarListener ) ((TaskScriptGrammarListener)listener).exitExprs(this);
		}
	}

	public final ExprsContext exprs() throws RecognitionException {
		ExprsContext _localctx = new ExprsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_exprs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << FILE_CATCHER) | (1L << EMAIL_CATCHER) | (1L << NEWLINE))) != 0)) {
				{
				{
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << FILE_CATCHER) | (1L << EMAIL_CATCHER))) != 0)) {
					{
					setState(24);
					expr();
					}
				}

				setState(27);
				match(NEWLINE);
				}
				}
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode FILE_CATCHER() { return getToken(TaskScriptGrammarParser.FILE_CATCHER, 0); }
		public FileContext file() {
			return getRuleContext(FileContext.class,0);
		}
		public TerminalNode EQ() { return getToken(TaskScriptGrammarParser.EQ, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public TerminalNode EMAIL_CATCHER() { return getToken(TaskScriptGrammarParser.EMAIL_CATCHER, 0); }
		public EmailContext email() {
			return getRuleContext(EmailContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaskScriptGrammarListener ) ((TaskScriptGrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaskScriptGrammarListener ) ((TaskScriptGrammarListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expr);
		try {
			setState(39);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FILE_CATCHER:
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				match(FILE_CATCHER);
				setState(34);
				file();
				}
				break;
			case EQ:
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				match(EQ);
				setState(36);
				operation();
				}
				break;
			case EMAIL_CATCHER:
				enterOuterAlt(_localctx, 3);
				{
				setState(37);
				match(EMAIL_CATCHER);
				setState(38);
				email();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperationContext extends ParserRuleContext {
		public List<TerminalNode> NUM() { return getTokens(TaskScriptGrammarParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(TaskScriptGrammarParser.NUM, i);
		}
		public List<SymbolContext> symbol() {
			return getRuleContexts(SymbolContext.class);
		}
		public SymbolContext symbol(int i) {
			return getRuleContext(SymbolContext.class,i);
		}
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaskScriptGrammarListener ) ((TaskScriptGrammarListener)listener).enterOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaskScriptGrammarListener ) ((TaskScriptGrammarListener)listener).exitOperation(this);
		}
	}

	public final OperationContext operation() throws RecognitionException {
		OperationContext _localctx = new OperationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_operation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(NUM);
			setState(42);
			symbol();
			setState(43);
			match(NUM);
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << LTEQ) | (1L << GTEQ) | (1L << GT) | (1L << LT) | (1L << PLUS) | (1L << MINUS) | (1L << MULTI) | (1L << DIV) | (1L << POWER) | (1L << PERCENT))) != 0)) {
				{
				{
				setState(44);
				symbol();
				setState(45);
				match(NUM);
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SymbolContext extends ParserRuleContext {
		public OperContext oper() {
			return getRuleContext(OperContext.class,0);
		}
		public TerminalNode MULTI() { return getToken(TaskScriptGrammarParser.MULTI, 0); }
		public TerminalNode DIV() { return getToken(TaskScriptGrammarParser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(TaskScriptGrammarParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(TaskScriptGrammarParser.MINUS, 0); }
		public TerminalNode POWER() { return getToken(TaskScriptGrammarParser.POWER, 0); }
		public TerminalNode PERCENT() { return getToken(TaskScriptGrammarParser.PERCENT, 0); }
		public SymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaskScriptGrammarListener ) ((TaskScriptGrammarListener)listener).enterSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaskScriptGrammarListener ) ((TaskScriptGrammarListener)listener).exitSymbol(this);
		}
	}

	public final SymbolContext symbol() throws RecognitionException {
		SymbolContext _localctx = new SymbolContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_symbol);
		int _la;
		try {
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EQ:
			case NEQ:
			case LTEQ:
			case GTEQ:
			case GT:
			case LT:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				oper();
				}
				break;
			case MULTI:
			case DIV:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				_la = _input.LA(1);
				if ( !(_la==MULTI || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case PLUS:
			case MINUS:
				enterOuterAlt(_localctx, 3);
				{
				setState(54);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case POWER:
				enterOuterAlt(_localctx, 4);
				{
				setState(55);
				match(POWER);
				}
				break;
			case PERCENT:
				enterOuterAlt(_localctx, 5);
				{
				setState(56);
				match(PERCENT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EmailContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(TaskScriptGrammarParser.NEWLINE, 0); }
		public TerminalNode SEMI() { return getToken(TaskScriptGrammarParser.SEMI, 0); }
		public List<BodyContext> body() {
			return getRuleContexts(BodyContext.class);
		}
		public BodyContext body(int i) {
			return getRuleContext(BodyContext.class,i);
		}
		public List<TerminalNode> STR() { return getTokens(TaskScriptGrammarParser.STR); }
		public TerminalNode STR(int i) {
			return getToken(TaskScriptGrammarParser.STR, i);
		}
		public List<TerminalNode> NUM() { return getTokens(TaskScriptGrammarParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(TaskScriptGrammarParser.NUM, i);
		}
		public EmailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_email; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaskScriptGrammarListener ) ((TaskScriptGrammarListener)listener).enterEmail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaskScriptGrammarListener ) ((TaskScriptGrammarListener)listener).exitEmail(this);
		}
	}

	public final EmailContext email() throws RecognitionException {
		EmailContext _localctx = new EmailContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_email);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(59);
				_la = _input.LA(1);
				if ( !(_la==STR || _la==NUM) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(62); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==STR || _la==NUM );
			setState(64);
			match(NEWLINE);
			setState(66); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(65);
				body();
				}
				}
				setState(68); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << PERCENT) | (1L << AT) | (1L << STR) | (1L << NUM))) != 0) );
			setState(70);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodyContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(TaskScriptGrammarParser.NEWLINE, 0); }
		public List<TerminalNode> STR() { return getTokens(TaskScriptGrammarParser.STR); }
		public TerminalNode STR(int i) {
			return getToken(TaskScriptGrammarParser.STR, i);
		}
		public List<TerminalNode> NUM() { return getTokens(TaskScriptGrammarParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(TaskScriptGrammarParser.NUM, i);
		}
		public List<TerminalNode> AT() { return getTokens(TaskScriptGrammarParser.AT); }
		public TerminalNode AT(int i) {
			return getToken(TaskScriptGrammarParser.AT, i);
		}
		public List<TerminalNode> PERCENT() { return getTokens(TaskScriptGrammarParser.PERCENT); }
		public TerminalNode PERCENT(int i) {
			return getToken(TaskScriptGrammarParser.PERCENT, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(TaskScriptGrammarParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(TaskScriptGrammarParser.MINUS, i);
		}
		public List<TerminalNode> EQ() { return getTokens(TaskScriptGrammarParser.EQ); }
		public TerminalNode EQ(int i) {
			return getToken(TaskScriptGrammarParser.EQ, i);
		}
		public List<TerminalNode> LBRACKET() { return getTokens(TaskScriptGrammarParser.LBRACKET); }
		public TerminalNode LBRACKET(int i) {
			return getToken(TaskScriptGrammarParser.LBRACKET, i);
		}
		public List<TerminalNode> DOLLAR() { return getTokens(TaskScriptGrammarParser.DOLLAR); }
		public TerminalNode DOLLAR(int i) {
			return getToken(TaskScriptGrammarParser.DOLLAR, i);
		}
		public List<TerminalNode> RBRACKET() { return getTokens(TaskScriptGrammarParser.RBRACKET); }
		public TerminalNode RBRACKET(int i) {
			return getToken(TaskScriptGrammarParser.RBRACKET, i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaskScriptGrammarListener ) ((TaskScriptGrammarListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaskScriptGrammarListener ) ((TaskScriptGrammarListener)listener).exitBody(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(72);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << PERCENT) | (1L << AT) | (1L << STR) | (1L << NUM))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(83);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					{
					setState(73);
					_la = _input.LA(1);
					if ( !(_la==STR || _la==NUM) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(74);
					match(EQ);
					setState(75);
					match(LBRACKET);
					setState(76);
					match(LBRACKET);
					setState(77);
					match(DOLLAR);
					setState(78);
					_la = _input.LA(1);
					if ( !(_la==STR || _la==NUM) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(79);
					match(RBRACKET);
					setState(80);
					match(RBRACKET);
					}
					setState(82);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << PERCENT) | (1L << AT) | (1L << STR) | (1L << NUM))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				}
				}
				setState(87); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << PERCENT) | (1L << AT) | (1L << STR) | (1L << NUM))) != 0) );
			setState(89);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(TaskScriptGrammarParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(TaskScriptGrammarParser.NEQ, 0); }
		public TerminalNode LT() { return getToken(TaskScriptGrammarParser.LT, 0); }
		public TerminalNode GT() { return getToken(TaskScriptGrammarParser.GT, 0); }
		public TerminalNode LTEQ() { return getToken(TaskScriptGrammarParser.LTEQ, 0); }
		public TerminalNode GTEQ() { return getToken(TaskScriptGrammarParser.GTEQ, 0); }
		public OperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaskScriptGrammarListener ) ((TaskScriptGrammarListener)listener).enterOper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaskScriptGrammarListener ) ((TaskScriptGrammarListener)listener).exitOper(this);
		}
	}

	public final OperContext oper() throws RecognitionException {
		OperContext _localctx = new OperContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_oper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << LTEQ) | (1L << GTEQ) | (1L << GT) | (1L << LT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FileContext extends ParserRuleContext {
		public FilenameContext filename() {
			return getRuleContext(FilenameContext.class,0);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaskScriptGrammarListener ) ((TaskScriptGrammarListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaskScriptGrammarListener ) ((TaskScriptGrammarListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_file);
		try {
			setState(101);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				match(T__0);
				setState(94);
				filename();
				setState(95);
				match(T__1);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				match(T__2);
				setState(98);
				filename();
				setState(99);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FilenameContext extends ParserRuleContext {
		public ExtensionContext extension() {
			return getRuleContext(ExtensionContext.class,0);
		}
		public List<TerminalNode> STR() { return getTokens(TaskScriptGrammarParser.STR); }
		public TerminalNode STR(int i) {
			return getToken(TaskScriptGrammarParser.STR, i);
		}
		public List<TerminalNode> NUM() { return getTokens(TaskScriptGrammarParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(TaskScriptGrammarParser.NUM, i);
		}
		public List<TerminalNode> UNDER() { return getTokens(TaskScriptGrammarParser.UNDER); }
		public TerminalNode UNDER(int i) {
			return getToken(TaskScriptGrammarParser.UNDER, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(TaskScriptGrammarParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(TaskScriptGrammarParser.MINUS, i);
		}
		public FilenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaskScriptGrammarListener ) ((TaskScriptGrammarListener)listener).enterFilename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaskScriptGrammarListener ) ((TaskScriptGrammarListener)listener).exitFilename(this);
		}
	}

	public final FilenameContext filename() throws RecognitionException {
		FilenameContext _localctx = new FilenameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_filename);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(103);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << UNDER) | (1L << STR) | (1L << NUM))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(106); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << UNDER) | (1L << STR) | (1L << NUM))) != 0) );
			setState(108);
			extension();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExtensionContext extends ParserRuleContext {
		public ExtensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extension; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaskScriptGrammarListener ) ((TaskScriptGrammarListener)listener).enterExtension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaskScriptGrammarListener ) ((TaskScriptGrammarListener)listener).exitExtension(this);
		}
	}

	public final ExtensionContext extension() throws RecognitionException {
		ExtensionContext _localctx = new ExtensionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_extension);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%s\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f"+
		"\t\f\3\2\3\2\3\3\5\3\34\n\3\3\3\7\3\37\n\3\f\3\16\3\"\13\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\5\4*\n\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5\62\n\5\f\5\16\5\65\13"+
		"\5\3\6\3\6\3\6\3\6\3\6\5\6<\n\6\3\7\6\7?\n\7\r\7\16\7@\3\7\3\7\6\7E\n"+
		"\7\r\7\16\7F\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bV"+
		"\n\b\6\bX\n\b\r\b\16\bY\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\5\nh\n\n\3\13\6\13k\n\13\r\13\16\13l\3\13\3\13\3\f\3\f\3\f\2\2\r\2"+
		"\4\6\b\n\f\16\20\22\24\26\2\t\3\2\21\22\3\2\17\20\3\2\"#\6\2\20\20\24"+
		"\24\34\34\"#\3\2\t\16\5\2\20\20\33\33\"#\3\2\6\b\2v\2\30\3\2\2\2\4 \3"+
		"\2\2\2\6)\3\2\2\2\b+\3\2\2\2\n;\3\2\2\2\f>\3\2\2\2\16W\3\2\2\2\20]\3\2"+
		"\2\2\22g\3\2\2\2\24j\3\2\2\2\26p\3\2\2\2\30\31\5\4\3\2\31\3\3\2\2\2\32"+
		"\34\5\6\4\2\33\32\3\2\2\2\33\34\3\2\2\2\34\35\3\2\2\2\35\37\7$\2\2\36"+
		"\33\3\2\2\2\37\"\3\2\2\2 \36\3\2\2\2 !\3\2\2\2!\5\3\2\2\2\" \3\2\2\2#"+
		"$\7 \2\2$*\5\22\n\2%&\7\t\2\2&*\5\b\5\2\'(\7!\2\2(*\5\f\7\2)#\3\2\2\2"+
		")%\3\2\2\2)\'\3\2\2\2*\7\3\2\2\2+,\7#\2\2,-\5\n\6\2-\63\7#\2\2./\5\n\6"+
		"\2/\60\7#\2\2\60\62\3\2\2\2\61.\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63"+
		"\64\3\2\2\2\64\t\3\2\2\2\65\63\3\2\2\2\66<\5\20\t\2\67<\t\2\2\28<\t\3"+
		"\2\29<\7\23\2\2:<\7\24\2\2;\66\3\2\2\2;\67\3\2\2\2;8\3\2\2\2;9\3\2\2\2"+
		";:\3\2\2\2<\13\3\2\2\2=?\t\4\2\2>=\3\2\2\2?@\3\2\2\2@>\3\2\2\2@A\3\2\2"+
		"\2AB\3\2\2\2BD\7$\2\2CE\5\16\b\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2"+
		"\2GH\3\2\2\2HI\7\26\2\2I\r\3\2\2\2JU\t\5\2\2KL\t\4\2\2LM\7\t\2\2MN\7\31"+
		"\2\2NO\7\31\2\2OP\7\36\2\2PQ\t\4\2\2QR\7\32\2\2RS\7\32\2\2ST\3\2\2\2T"+
		"V\t\5\2\2UK\3\2\2\2UV\3\2\2\2VX\3\2\2\2WJ\3\2\2\2XY\3\2\2\2YW\3\2\2\2"+
		"YZ\3\2\2\2Z[\3\2\2\2[\\\7$\2\2\\\17\3\2\2\2]^\t\6\2\2^\21\3\2\2\2_`\7"+
		"\3\2\2`a\5\24\13\2ab\7\4\2\2bh\3\2\2\2cd\7\5\2\2de\5\24\13\2ef\7\4\2\2"+
		"fh\3\2\2\2g_\3\2\2\2gc\3\2\2\2h\23\3\2\2\2ik\t\7\2\2ji\3\2\2\2kl\3\2\2"+
		"\2lj\3\2\2\2lm\3\2\2\2mn\3\2\2\2no\5\26\f\2o\25\3\2\2\2pq\t\b\2\2q\27"+
		"\3\2\2\2\r\33 )\63;@FUYgl";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
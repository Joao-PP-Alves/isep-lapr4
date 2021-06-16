// Generated from TaskScriptGrammar.g4 by ANTLR 4.9.2
 // classes a incluir
package eapli.base.grammars;

import java.util.*;
    import java.lang.*;
    import java.io.*;

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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, EQ=9, 
		NEQ=10, LTEQ=11, GTEQ=12, GT=13, LT=14, PLUS=15, MINUS=16, MULTI=17, DIV=18, 
		POWER=19, PERCENT=20, COMMA=21, SEMI=22, LPAR=23, RPAR=24, LBRACKET=25, 
		RBRACKET=26, UNDER=27, AT=28, DOT=29, DOLLAR=30, EURO=31, FILE_CATCHER=32, 
		EMAIL_CATCHER=33, STR=34, NUM=35, NEWLINE=36, WS=37;
	public static final int
		RULE_init = 0, RULE_exprs = 1, RULE_expr = 2, RULE_operation = 3, RULE_semi_op = 4, 
		RULE_email = 5, RULE_body = 6, RULE_destination = 7, RULE_email_extension = 8, 
		RULE_oper = 9, RULE_file = 10, RULE_filename = 11, RULE_extension = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"init", "exprs", "expr", "operation", "semi_op", "email", "body", "destination", 
			"email_extension", "oper", "file", "filename", "extension"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'pt'", "'com'", "'write to ''", "'''", "'read from ''", "'.txt'", 
			"'.xsl'", "'.xml'", "'='", "'<>'", "'<='", "'>='", "'>'", "'<'", "'+'", 
			"'-'", "'*'", "'/'", "'^'", "'%'", "','", "';'", "'('", "')'", "'{'", 
			"'}'", "'_'", "'@'", "'.'", "'$'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "EQ", "NEQ", "LTEQ", 
			"GTEQ", "GT", "LT", "PLUS", "MINUS", "MULTI", "DIV", "POWER", "PERCENT", 
			"COMMA", "SEMI", "LPAR", "RPAR", "LBRACKET", "RBRACKET", "UNDER", "AT", 
			"DOT", "DOLLAR", "EURO", "FILE_CATCHER", "EMAIL_CATCHER", "STR", "NUM", 
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
			setState(26);
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
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << FILE_CATCHER) | (1L << EMAIL_CATCHER) | (1L << NEWLINE))) != 0)) {
				{
				{
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << FILE_CATCHER) | (1L << EMAIL_CATCHER))) != 0)) {
					{
					setState(28);
					expr();
					}
				}

				setState(31);
				match(NEWLINE);
				}
				}
				setState(36);
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
		public List<Semi_opContext> semi_op() {
			return getRuleContexts(Semi_opContext.class);
		}
		public Semi_opContext semi_op(int i) {
			return getRuleContext(Semi_opContext.class,i);
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
		int _la;
		try {
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FILE_CATCHER:
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				match(FILE_CATCHER);
				setState(38);
				file();
				}
				break;
			case EQ:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				match(EQ);
				setState(40);
				operation();
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << LTEQ) | (1L << GTEQ) | (1L << GT) | (1L << LT) | (1L << PLUS) | (1L << MINUS) | (1L << MULTI) | (1L << DIV) | (1L << POWER) | (1L << PERCENT))) != 0)) {
					{
					{
					setState(41);
					semi_op();
					}
					}
					setState(46);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case EMAIL_CATCHER:
				enterOuterAlt(_localctx, 3);
				{
				setState(47);
				match(EMAIL_CATCHER);
				setState(48);
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
		public OperContext oper() {
			return getRuleContext(OperContext.class,0);
		}
		public TerminalNode MULTI() { return getToken(TaskScriptGrammarParser.MULTI, 0); }
		public TerminalNode DIV() { return getToken(TaskScriptGrammarParser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(TaskScriptGrammarParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(TaskScriptGrammarParser.MINUS, 0); }
		public TerminalNode POWER() { return getToken(TaskScriptGrammarParser.POWER, 0); }
		public TerminalNode PERCENT() { return getToken(TaskScriptGrammarParser.PERCENT, 0); }
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
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				match(NUM);
				setState(52);
				oper();
				setState(53);
				match(NUM);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				match(NUM);
				setState(56);
				_la = _input.LA(1);
				if ( !(_la==MULTI || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(57);
				match(NUM);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(58);
				match(NUM);
				setState(59);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(60);
				match(NUM);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(61);
				match(NUM);
				setState(62);
				match(POWER);
				setState(63);
				match(NUM);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(64);
				match(NUM);
				setState(65);
				match(PERCENT);
				setState(66);
				match(NUM);
				}
				break;
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

	public static class Semi_opContext extends ParserRuleContext {
		public OperContext oper() {
			return getRuleContext(OperContext.class,0);
		}
		public TerminalNode NUM() { return getToken(TaskScriptGrammarParser.NUM, 0); }
		public TerminalNode MULTI() { return getToken(TaskScriptGrammarParser.MULTI, 0); }
		public TerminalNode DIV() { return getToken(TaskScriptGrammarParser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(TaskScriptGrammarParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(TaskScriptGrammarParser.MINUS, 0); }
		public TerminalNode POWER() { return getToken(TaskScriptGrammarParser.POWER, 0); }
		public TerminalNode PERCENT() { return getToken(TaskScriptGrammarParser.PERCENT, 0); }
		public Semi_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_semi_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaskScriptGrammarListener ) ((TaskScriptGrammarListener)listener).enterSemi_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaskScriptGrammarListener ) ((TaskScriptGrammarListener)listener).exitSemi_op(this);
		}
	}

	public final Semi_opContext semi_op() throws RecognitionException {
		Semi_opContext _localctx = new Semi_opContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_semi_op);
		int _la;
		try {
			setState(80);
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
				setState(69);
				oper();
				setState(70);
				match(NUM);
				}
				break;
			case MULTI:
			case DIV:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				_la = _input.LA(1);
				if ( !(_la==MULTI || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(73);
				match(NUM);
				}
				break;
			case PLUS:
			case MINUS:
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(75);
				match(NUM);
				}
				break;
			case POWER:
				enterOuterAlt(_localctx, 4);
				{
				setState(76);
				match(POWER);
				setState(77);
				match(NUM);
				}
				break;
			case PERCENT:
				enterOuterAlt(_localctx, 5);
				{
				setState(78);
				match(PERCENT);
				setState(79);
				match(NUM);
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
		public DestinationContext destination() {
			return getRuleContext(DestinationContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(TaskScriptGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(TaskScriptGrammarParser.NEWLINE, i);
		}
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
			setState(82);
			destination();
			setState(83);
			match(NEWLINE);
			setState(85); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(84);
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
				setState(87); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==STR || _la==NUM );
			setState(89);
			match(NEWLINE);
			setState(91); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(90);
				body();
				}
				}
				setState(93); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << PERCENT) | (1L << AT) | (1L << STR) | (1L << NUM))) != 0) );
			setState(95);
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
			setState(110); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(97);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << PERCENT) | (1L << AT) | (1L << STR) | (1L << NUM))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(108);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					{
					setState(98);
					_la = _input.LA(1);
					if ( !(_la==STR || _la==NUM) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(99);
					match(EQ);
					setState(100);
					match(LBRACKET);
					setState(101);
					match(LBRACKET);
					setState(102);
					match(DOLLAR);
					setState(103);
					_la = _input.LA(1);
					if ( !(_la==STR || _la==NUM) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(104);
					match(RBRACKET);
					setState(105);
					match(RBRACKET);
					}
					setState(107);
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
				setState(112); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << PERCENT) | (1L << AT) | (1L << STR) | (1L << NUM))) != 0) );
			setState(114);
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

	public static class DestinationContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(TaskScriptGrammarParser.AT, 0); }
		public Email_extensionContext email_extension() {
			return getRuleContext(Email_extensionContext.class,0);
		}
		public List<TerminalNode> STR() { return getTokens(TaskScriptGrammarParser.STR); }
		public TerminalNode STR(int i) {
			return getToken(TaskScriptGrammarParser.STR, i);
		}
		public List<TerminalNode> NUM() { return getTokens(TaskScriptGrammarParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(TaskScriptGrammarParser.NUM, i);
		}
		public DestinationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_destination; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaskScriptGrammarListener ) ((TaskScriptGrammarListener)listener).enterDestination(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaskScriptGrammarListener ) ((TaskScriptGrammarListener)listener).exitDestination(this);
		}
	}

	public final DestinationContext destination() throws RecognitionException {
		DestinationContext _localctx = new DestinationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_destination);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(116);
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
				setState(119); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==STR || _la==NUM );
			setState(121);
			match(AT);
			setState(123); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(122);
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
				setState(125); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==STR || _la==NUM );
			setState(127);
			email_extension();
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

	public static class Email_extensionContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(TaskScriptGrammarParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(TaskScriptGrammarParser.DOT, i);
		}
		public List<TerminalNode> STR() { return getTokens(TaskScriptGrammarParser.STR); }
		public TerminalNode STR(int i) {
			return getToken(TaskScriptGrammarParser.STR, i);
		}
		public List<TerminalNode> NUM() { return getTokens(TaskScriptGrammarParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(TaskScriptGrammarParser.NUM, i);
		}
		public Email_extensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_email_extension; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TaskScriptGrammarListener ) ((TaskScriptGrammarListener)listener).enterEmail_extension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TaskScriptGrammarListener ) ((TaskScriptGrammarListener)listener).exitEmail_extension(this);
		}
	}

	public final Email_extensionContext email_extension() throws RecognitionException {
		Email_extensionContext _localctx = new Email_extensionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_email_extension);
		int _la;
		try {
			int _alt;
			setState(155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(129);
						match(DOT);
						setState(131); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(130);
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
							setState(133); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==STR || _la==NUM );
						}
						} 
					}
					setState(139);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				}
				setState(140);
				match(DOT);
				setState(141);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(142);
						match(DOT);
						setState(144); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(143);
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
							setState(146); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==STR || _la==NUM );
						}
						} 
					}
					setState(152);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				}
				setState(153);
				match(DOT);
				setState(154);
				match(T__1);
				}
				break;
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
		enterRule(_localctx, 18, RULE_oper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
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
		enterRule(_localctx, 20, RULE_file);
		try {
			setState(167);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				match(T__2);
				setState(160);
				filename();
				setState(161);
				match(T__3);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				match(T__4);
				setState(164);
				filename();
				setState(165);
				match(T__3);
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
		enterRule(_localctx, 22, RULE_filename);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(169);
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
				setState(172); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << UNDER) | (1L << STR) | (1L << NUM))) != 0) );
			setState(174);
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
		enterRule(_localctx, 24, RULE_extension);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7))) != 0)) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'\u00b5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\5\3 \n\3\3\3\7\3#\n\3\f\3\16"+
		"\3&\13\3\3\4\3\4\3\4\3\4\3\4\7\4-\n\4\f\4\16\4\60\13\4\3\4\3\4\5\4\64"+
		"\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5"+
		"\5F\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6S\n\6\3\7\3\7\3"+
		"\7\6\7X\n\7\r\7\16\7Y\3\7\3\7\6\7^\n\7\r\7\16\7_\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bo\n\b\6\bq\n\b\r\b\16\br\3\b\3\b\3\t"+
		"\6\tx\n\t\r\t\16\ty\3\t\3\t\6\t~\n\t\r\t\16\t\177\3\t\3\t\3\n\3\n\6\n"+
		"\u0086\n\n\r\n\16\n\u0087\7\n\u008a\n\n\f\n\16\n\u008d\13\n\3\n\3\n\3"+
		"\n\3\n\6\n\u0093\n\n\r\n\16\n\u0094\7\n\u0097\n\n\f\n\16\n\u009a\13\n"+
		"\3\n\3\n\5\n\u009e\n\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00aa"+
		"\n\f\3\r\6\r\u00ad\n\r\r\r\16\r\u00ae\3\r\3\r\3\16\3\16\3\16\2\2\17\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\2\t\3\2\23\24\3\2\21\22\3\2$%\6\2\22\22"+
		"\26\26\36\36$%\3\2\13\20\5\2\22\22\35\35$%\3\2\b\n\2\u00c1\2\34\3\2\2"+
		"\2\4$\3\2\2\2\6\63\3\2\2\2\bE\3\2\2\2\nR\3\2\2\2\fT\3\2\2\2\16p\3\2\2"+
		"\2\20w\3\2\2\2\22\u009d\3\2\2\2\24\u009f\3\2\2\2\26\u00a9\3\2\2\2\30\u00ac"+
		"\3\2\2\2\32\u00b2\3\2\2\2\34\35\5\4\3\2\35\3\3\2\2\2\36 \5\6\4\2\37\36"+
		"\3\2\2\2\37 \3\2\2\2 !\3\2\2\2!#\7&\2\2\"\37\3\2\2\2#&\3\2\2\2$\"\3\2"+
		"\2\2$%\3\2\2\2%\5\3\2\2\2&$\3\2\2\2\'(\7\"\2\2(\64\5\26\f\2)*\7\13\2\2"+
		"*.\5\b\5\2+-\5\n\6\2,+\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\64\3\2"+
		"\2\2\60.\3\2\2\2\61\62\7#\2\2\62\64\5\f\7\2\63\'\3\2\2\2\63)\3\2\2\2\63"+
		"\61\3\2\2\2\64\7\3\2\2\2\65\66\7%\2\2\66\67\5\24\13\2\678\7%\2\28F\3\2"+
		"\2\29:\7%\2\2:;\t\2\2\2;F\7%\2\2<=\7%\2\2=>\t\3\2\2>F\7%\2\2?@\7%\2\2"+
		"@A\7\25\2\2AF\7%\2\2BC\7%\2\2CD\7\26\2\2DF\7%\2\2E\65\3\2\2\2E9\3\2\2"+
		"\2E<\3\2\2\2E?\3\2\2\2EB\3\2\2\2F\t\3\2\2\2GH\5\24\13\2HI\7%\2\2IS\3\2"+
		"\2\2JK\t\2\2\2KS\7%\2\2LM\t\3\2\2MS\7%\2\2NO\7\25\2\2OS\7%\2\2PQ\7\26"+
		"\2\2QS\7%\2\2RG\3\2\2\2RJ\3\2\2\2RL\3\2\2\2RN\3\2\2\2RP\3\2\2\2S\13\3"+
		"\2\2\2TU\5\20\t\2UW\7&\2\2VX\t\4\2\2WV\3\2\2\2XY\3\2\2\2YW\3\2\2\2YZ\3"+
		"\2\2\2Z[\3\2\2\2[]\7&\2\2\\^\5\16\b\2]\\\3\2\2\2^_\3\2\2\2_]\3\2\2\2_"+
		"`\3\2\2\2`a\3\2\2\2ab\7\30\2\2b\r\3\2\2\2cn\t\5\2\2de\t\4\2\2ef\7\13\2"+
		"\2fg\7\33\2\2gh\7\33\2\2hi\7 \2\2ij\t\4\2\2jk\7\34\2\2kl\7\34\2\2lm\3"+
		"\2\2\2mo\t\5\2\2nd\3\2\2\2no\3\2\2\2oq\3\2\2\2pc\3\2\2\2qr\3\2\2\2rp\3"+
		"\2\2\2rs\3\2\2\2st\3\2\2\2tu\7&\2\2u\17\3\2\2\2vx\t\4\2\2wv\3\2\2\2xy"+
		"\3\2\2\2yw\3\2\2\2yz\3\2\2\2z{\3\2\2\2{}\7\36\2\2|~\t\4\2\2}|\3\2\2\2"+
		"~\177\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\3\2\2\2\u0081"+
		"\u0082\5\22\n\2\u0082\21\3\2\2\2\u0083\u0085\7\37\2\2\u0084\u0086\t\4"+
		"\2\2\u0085\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0085\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\u008a\3\2\2\2\u0089\u0083\3\2\2\2\u008a\u008d\3\2"+
		"\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008e\u008f\7\37\2\2\u008f\u009e\7\3\2\2\u0090\u0092\7"+
		"\37\2\2\u0091\u0093\t\4\2\2\u0092\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3\2\2\2\u0096\u0090\3\2"+
		"\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099"+
		"\u009b\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009c\7\37\2\2\u009c\u009e\7"+
		"\4\2\2\u009d\u008b\3\2\2\2\u009d\u0098\3\2\2\2\u009e\23\3\2\2\2\u009f"+
		"\u00a0\t\6\2\2\u00a0\25\3\2\2\2\u00a1\u00a2\7\5\2\2\u00a2\u00a3\5\30\r"+
		"\2\u00a3\u00a4\7\6\2\2\u00a4\u00aa\3\2\2\2\u00a5\u00a6\7\7\2\2\u00a6\u00a7"+
		"\5\30\r\2\u00a7\u00a8\7\6\2\2\u00a8\u00aa\3\2\2\2\u00a9\u00a1\3\2\2\2"+
		"\u00a9\u00a5\3\2\2\2\u00aa\27\3\2\2\2\u00ab\u00ad\t\7\2\2\u00ac\u00ab"+
		"\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af"+
		"\u00b0\3\2\2\2\u00b0\u00b1\5\32\16\2\u00b1\31\3\2\2\2\u00b2\u00b3\t\b"+
		"\2\2\u00b3\33\3\2\2\2\25\37$.\63ERY_nry\177\u0087\u008b\u0094\u0098\u009d"+
		"\u00a9\u00ae";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
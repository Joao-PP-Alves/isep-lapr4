// Generated from FormScriptGrammar.g4 by ANTLR 4.9.2
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
public class FormScriptGrammarParser extends Parser {
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
	public static final int
		RULE_init = 0, RULE_exprs = 1, RULE_expr = 2, RULE_field = 3, RULE_var = 4, 
		RULE_dependencies = 5, RULE_type = 6, RULE_keyevent = 7, RULE_unlock = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"init", "exprs", "expr", "field", "var", "dependencies", "type", "keyevent", 
			"unlock"
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

	@Override
	public String getGrammarFileName() { return "FormScriptGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }




	public FormScriptGrammarParser(TokenStream input) {
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
			if ( listener instanceof FormScriptGrammarListener ) ((FormScriptGrammarListener)listener).enterInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormScriptGrammarListener ) ((FormScriptGrammarListener)listener).exitInit(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_init);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
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
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(FormScriptGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FormScriptGrammarParser.NEWLINE, i);
		}
		public ExprsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormScriptGrammarListener ) ((FormScriptGrammarListener)listener).enterExprs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormScriptGrammarListener ) ((FormScriptGrammarListener)listener).exitExprs(this);
		}
	}

	public final ExprsContext exprs() throws RecognitionException {
		ExprsContext _localctx = new ExprsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_exprs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STR || _la==NUM) {
				{
				{
				setState(20);
				expr();
				setState(22);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(21);
					match(NEWLINE);
					}
				}

				}
				}
				setState(28);
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
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(FormScriptGrammarParser.SEMI, 0); }
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public KeyeventContext keyevent() {
			return getRuleContext(KeyeventContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormScriptGrammarListener ) ((FormScriptGrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormScriptGrammarListener ) ((FormScriptGrammarListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expr);
		try {
			setState(40);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				var();
				setState(30);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(32);
				field();
				setState(33);
				match(SEMI);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(35);
				field();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(36);
				keyevent();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(37);
				keyevent();
				setState(38);
				match(SEMI);
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

	public static class FieldContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(FormScriptGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FormScriptGrammarParser.COMMA, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> STR() { return getTokens(FormScriptGrammarParser.STR); }
		public TerminalNode STR(int i) {
			return getToken(FormScriptGrammarParser.STR, i);
		}
		public TerminalNode SIDE_BAR_RL() { return getToken(FormScriptGrammarParser.SIDE_BAR_RL, 0); }
		public DependenciesContext dependencies() {
			return getRuleContext(DependenciesContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormScriptGrammarListener ) ((FormScriptGrammarListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormScriptGrammarListener ) ((FormScriptGrammarListener)listener).exitField(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_field);
		int _la;
		try {
			int _alt;
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				var();
				setState(43);
				match(COMMA);
				setState(45); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(44);
					match(STR);
					}
					}
					setState(47); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==STR );
				setState(49);
				match(COMMA);
				setState(51); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(50);
					match(STR);
					}
					}
					setState(53); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==STR );
				setState(55);
				match(COMMA);
				setState(56);
				type();
				setState(57);
				match(COMMA);
				setState(59); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(58);
						match(STR);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(61); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				var();
				setState(64);
				match(COMMA);
				setState(66); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(65);
					match(STR);
					}
					}
					setState(68); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==STR );
				setState(70);
				match(COMMA);
				setState(72); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(71);
					match(STR);
					}
					}
					setState(74); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==STR );
				setState(76);
				match(COMMA);
				setState(77);
				type();
				setState(78);
				match(COMMA);
				setState(80); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(79);
					match(STR);
					}
					}
					setState(82); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==STR );
				setState(84);
				match(SIDE_BAR_RL);
				setState(85);
				dependencies(0);
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

	public static class VarContext extends ParserRuleContext {
		public List<TerminalNode> STR() { return getTokens(FormScriptGrammarParser.STR); }
		public TerminalNode STR(int i) {
			return getToken(FormScriptGrammarParser.STR, i);
		}
		public List<TerminalNode> NUM() { return getTokens(FormScriptGrammarParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(FormScriptGrammarParser.NUM, i);
		}
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormScriptGrammarListener ) ((FormScriptGrammarListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormScriptGrammarListener ) ((FormScriptGrammarListener)listener).exitVar(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_var);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(90); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(89);
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
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(92); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class DependenciesContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public DependenciesContext dependencies() {
			return getRuleContext(DependenciesContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(FormScriptGrammarParser.COMMA, 0); }
		public DependenciesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dependencies; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormScriptGrammarListener ) ((FormScriptGrammarListener)listener).enterDependencies(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormScriptGrammarListener ) ((FormScriptGrammarListener)listener).exitDependencies(this);
		}
	}

	public final DependenciesContext dependencies() throws RecognitionException {
		return dependencies(0);
	}

	private DependenciesContext dependencies(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DependenciesContext _localctx = new DependenciesContext(_ctx, _parentState);
		DependenciesContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_dependencies, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(95);
			var();
			}
			_ctx.stop = _input.LT(-1);
			setState(102);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DependenciesContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_dependencies);
					setState(97);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(98);
					match(COMMA);
					setState(99);
					var();
					}
					} 
				}
				setState(104);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(FormScriptGrammarParser.INT, 0); }
		public TerminalNode STRING() { return getToken(FormScriptGrammarParser.STRING, 0); }
		public TerminalNode FLOAT() { return getToken(FormScriptGrammarParser.FLOAT, 0); }
		public TerminalNode BOOLEAN() { return getToken(FormScriptGrammarParser.BOOLEAN, 0); }
		public TerminalNode LONG() { return getToken(FormScriptGrammarParser.LONG, 0); }
		public TerminalNode DOUBLE() { return getToken(FormScriptGrammarParser.DOUBLE, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormScriptGrammarListener ) ((FormScriptGrammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormScriptGrammarListener ) ((FormScriptGrammarListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOLEAN) | (1L << DOUBLE) | (1L << STRING) | (1L << FLOAT) | (1L << LONG))) != 0)) ) {
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

	public static class KeyeventContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public TerminalNode EQ() { return getToken(FormScriptGrammarParser.EQ, 0); }
		public UnlockContext unlock() {
			return getRuleContext(UnlockContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(FormScriptGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FormScriptGrammarParser.COMMA, i);
		}
		public List<TerminalNode> NUM() { return getTokens(FormScriptGrammarParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(FormScriptGrammarParser.NUM, i);
		}
		public List<TerminalNode> STR() { return getTokens(FormScriptGrammarParser.STR); }
		public TerminalNode STR(int i) {
			return getToken(FormScriptGrammarParser.STR, i);
		}
		public KeyeventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyevent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormScriptGrammarListener ) ((FormScriptGrammarListener)listener).enterKeyevent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormScriptGrammarListener ) ((FormScriptGrammarListener)listener).exitKeyevent(this);
		}
	}

	public final KeyeventContext keyevent() throws RecognitionException {
		KeyeventContext _localctx = new KeyeventContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_keyevent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			var();
			setState(108);
			match(EQ);
			setState(110); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(109);
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
				setState(112); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==STR || _la==NUM );
			setState(114);
			unlock();
			setState(115);
			var();
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(116);
				match(COMMA);
				setState(117);
				var();
				}
				}
				setState(122);
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

	public static class UnlockContext extends ParserRuleContext {
		public List<TerminalNode> COLON() { return getTokens(FormScriptGrammarParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(FormScriptGrammarParser.COLON, i);
		}
		public UnlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormScriptGrammarListener ) ((FormScriptGrammarListener)listener).enterUnlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormScriptGrammarListener ) ((FormScriptGrammarListener)listener).exitUnlock(this);
		}
	}

	public final UnlockContext unlock() throws RecognitionException {
		UnlockContext _localctx = new UnlockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_unlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(COLON);
			setState(124);
			match(COLON);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return dependencies_sempred((DependenciesContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean dependencies_sempred(DependenciesContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u0081\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\3\3\3\5\3\31\n\3\7\3\33\n\3\f\3\16\3\36\13\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\5\4+\n\4\3\5\3\5\3\5\6\5\60\n\5\r\5\16\5\61\3\5"+
		"\3\5\6\5\66\n\5\r\5\16\5\67\3\5\3\5\3\5\3\5\6\5>\n\5\r\5\16\5?\3\5\3\5"+
		"\3\5\6\5E\n\5\r\5\16\5F\3\5\3\5\6\5K\n\5\r\5\16\5L\3\5\3\5\3\5\3\5\6\5"+
		"S\n\5\r\5\16\5T\3\5\3\5\3\5\5\5Z\n\5\3\6\6\6]\n\6\r\6\16\6^\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\7\7g\n\7\f\7\16\7j\13\7\3\b\3\b\3\t\3\t\3\t\6\tq\n\t\r"+
		"\t\16\tr\3\t\3\t\3\t\3\t\7\ty\n\t\f\t\16\t|\13\t\3\n\3\n\3\n\3\n\2\3\f"+
		"\13\2\4\6\b\n\f\16\20\22\2\4\3\2!\"\3\2\3\b\2\u0088\2\24\3\2\2\2\4\34"+
		"\3\2\2\2\6*\3\2\2\2\bY\3\2\2\2\n\\\3\2\2\2\f`\3\2\2\2\16k\3\2\2\2\20m"+
		"\3\2\2\2\22}\3\2\2\2\24\25\5\4\3\2\25\3\3\2\2\2\26\30\5\6\4\2\27\31\7"+
		"#\2\2\30\27\3\2\2\2\30\31\3\2\2\2\31\33\3\2\2\2\32\26\3\2\2\2\33\36\3"+
		"\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2\35\5\3\2\2\2\36\34\3\2\2\2\37 \5\n"+
		"\6\2 !\7\24\2\2!+\3\2\2\2\"#\5\b\5\2#$\7\24\2\2$+\3\2\2\2%+\5\b\5\2&+"+
		"\5\20\t\2\'(\5\20\t\2()\7\24\2\2)+\3\2\2\2*\37\3\2\2\2*\"\3\2\2\2*%\3"+
		"\2\2\2*&\3\2\2\2*\'\3\2\2\2+\7\3\2\2\2,-\5\n\6\2-/\7\23\2\2.\60\7!\2\2"+
		"/.\3\2\2\2\60\61\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\63\3\2\2\2\63\65"+
		"\7\23\2\2\64\66\7!\2\2\65\64\3\2\2\2\66\67\3\2\2\2\67\65\3\2\2\2\678\3"+
		"\2\2\289\3\2\2\29:\7\23\2\2:;\5\16\b\2;=\7\23\2\2<>\7!\2\2=<\3\2\2\2>"+
		"?\3\2\2\2?=\3\2\2\2?@\3\2\2\2@Z\3\2\2\2AB\5\n\6\2BD\7\23\2\2CE\7!\2\2"+
		"DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2\2GH\3\2\2\2HJ\7\23\2\2IK\7!\2\2"+
		"JI\3\2\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MN\3\2\2\2NO\7\23\2\2OP\5\16\b"+
		"\2PR\7\23\2\2QS\7!\2\2RQ\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2UV\3\2\2"+
		"\2VW\7\31\2\2WX\5\f\7\2XZ\3\2\2\2Y,\3\2\2\2YA\3\2\2\2Z\t\3\2\2\2[]\t\2"+
		"\2\2\\[\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\13\3\2\2\2`a\b\7\1\2a"+
		"b\5\n\6\2bh\3\2\2\2cd\f\4\2\2de\7\23\2\2eg\5\n\6\2fc\3\2\2\2gj\3\2\2\2"+
		"hf\3\2\2\2hi\3\2\2\2i\r\3\2\2\2jh\3\2\2\2kl\t\3\2\2l\17\3\2\2\2mn\5\n"+
		"\6\2np\7\t\2\2oq\t\2\2\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2st\3\2"+
		"\2\2tu\5\22\n\2uz\5\n\6\2vw\7\23\2\2wy\5\n\6\2xv\3\2\2\2y|\3\2\2\2zx\3"+
		"\2\2\2z{\3\2\2\2{\21\3\2\2\2|z\3\2\2\2}~\7\20\2\2~\177\7\20\2\2\177\23"+
		"\3\2\2\2\20\30\34*\61\67?FLTY^hrz";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
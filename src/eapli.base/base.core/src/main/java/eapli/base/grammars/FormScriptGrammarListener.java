// Generated from FormScriptGrammar.g4 by ANTLR 4.9.2
 // classes a incluir
package eapli.base.grammars;

    import java.util.*;
    import java.lang.*;
    import java.io.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FormScriptGrammarParser}.
 */
public interface FormScriptGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FormScriptGrammarParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(FormScriptGrammarParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormScriptGrammarParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(FormScriptGrammarParser.InitContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormScriptGrammarParser#exprs}.
	 * @param ctx the parse tree
	 */
	void enterExprs(FormScriptGrammarParser.ExprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormScriptGrammarParser#exprs}.
	 * @param ctx the parse tree
	 */
	void exitExprs(FormScriptGrammarParser.ExprsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormScriptGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(FormScriptGrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormScriptGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(FormScriptGrammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormScriptGrammarParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(FormScriptGrammarParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormScriptGrammarParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(FormScriptGrammarParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormScriptGrammarParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(FormScriptGrammarParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormScriptGrammarParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(FormScriptGrammarParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormScriptGrammarParser#dependencies}.
	 * @param ctx the parse tree
	 */
	void enterDependencies(FormScriptGrammarParser.DependenciesContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormScriptGrammarParser#dependencies}.
	 * @param ctx the parse tree
	 */
	void exitDependencies(FormScriptGrammarParser.DependenciesContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormScriptGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(FormScriptGrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormScriptGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(FormScriptGrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormScriptGrammarParser#keyevent}.
	 * @param ctx the parse tree
	 */
	void enterKeyevent(FormScriptGrammarParser.KeyeventContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormScriptGrammarParser#keyevent}.
	 * @param ctx the parse tree
	 */
	void exitKeyevent(FormScriptGrammarParser.KeyeventContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormScriptGrammarParser#unlock}.
	 * @param ctx the parse tree
	 */
	void enterUnlock(FormScriptGrammarParser.UnlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormScriptGrammarParser#unlock}.
	 * @param ctx the parse tree
	 */
	void exitUnlock(FormScriptGrammarParser.UnlockContext ctx);
}
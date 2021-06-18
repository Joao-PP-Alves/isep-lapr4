// Generated from TaskScriptGrammar.g4 by ANTLR 4.9.2
package eapli.base.grammars;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TaskScriptGrammarParser}.
 */
public interface TaskScriptGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TaskScriptGrammarParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(TaskScriptGrammarParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaskScriptGrammarParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(TaskScriptGrammarParser.InitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaskScriptGrammarParser#exprs}.
	 * @param ctx the parse tree
	 */
	void enterExprs(TaskScriptGrammarParser.ExprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaskScriptGrammarParser#exprs}.
	 * @param ctx the parse tree
	 */
	void exitExprs(TaskScriptGrammarParser.ExprsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaskScriptGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(TaskScriptGrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaskScriptGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(TaskScriptGrammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaskScriptGrammarParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterOperation(TaskScriptGrammarParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaskScriptGrammarParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitOperation(TaskScriptGrammarParser.OperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaskScriptGrammarParser#symbol}.
	 * @param ctx the parse tree
	 */
	void enterSymbol(TaskScriptGrammarParser.SymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaskScriptGrammarParser#symbol}.
	 * @param ctx the parse tree
	 */
	void exitSymbol(TaskScriptGrammarParser.SymbolContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaskScriptGrammarParser#email}.
	 * @param ctx the parse tree
	 */
	void enterEmail(TaskScriptGrammarParser.EmailContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaskScriptGrammarParser#email}.
	 * @param ctx the parse tree
	 */
	void exitEmail(TaskScriptGrammarParser.EmailContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaskScriptGrammarParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(TaskScriptGrammarParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaskScriptGrammarParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(TaskScriptGrammarParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaskScriptGrammarParser#oper}.
	 * @param ctx the parse tree
	 */
	void enterOper(TaskScriptGrammarParser.OperContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaskScriptGrammarParser#oper}.
	 * @param ctx the parse tree
	 */
	void exitOper(TaskScriptGrammarParser.OperContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaskScriptGrammarParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(TaskScriptGrammarParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaskScriptGrammarParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(TaskScriptGrammarParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaskScriptGrammarParser#filename}.
	 * @param ctx the parse tree
	 */
	void enterFilename(TaskScriptGrammarParser.FilenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaskScriptGrammarParser#filename}.
	 * @param ctx the parse tree
	 */
	void exitFilename(TaskScriptGrammarParser.FilenameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaskScriptGrammarParser#extension}.
	 * @param ctx the parse tree
	 */
	void enterExtension(TaskScriptGrammarParser.ExtensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaskScriptGrammarParser#extension}.
	 * @param ctx the parse tree
	 */
	void exitExtension(TaskScriptGrammarParser.ExtensionContext ctx);
}
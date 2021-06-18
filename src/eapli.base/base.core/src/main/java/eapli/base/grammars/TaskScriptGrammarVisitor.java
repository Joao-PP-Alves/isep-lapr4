package eapli.base.grammars;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

public interface TaskScriptGrammarVisitor<T> extends ParseTreeVisitor<T> {

    T visitInit(TaskScriptGrammarParser.InitContext ctx);
    T visitBody(TaskScriptGrammarParser.BodyContext ctx);

    T visitEmail(TaskScriptGrammarParser.EmailContext ctx);

    T visitExpr(TaskScriptGrammarParser.ExprContext ctx);

    T visitExtension(TaskScriptGrammarParser.ExtensionContext ctx);

    T visitFile(TaskScriptGrammarParser.FileContext ctx);

    T visitFilename(TaskScriptGrammarParser.FilenameContext ctx);

    T visitOperation(TaskScriptGrammarParser.OperationContext ctx);

    T visitOper(TaskScriptGrammarParser.OperContext ctx);

    T visitExprs(TaskScriptGrammarParser.ExprsContext ctx);

    T visitSymbol(TaskScriptGrammarParser.SymbolContext ctx);
}

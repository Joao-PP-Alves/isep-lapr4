package eapli.base.grammars;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

public class TaskScriptGrammarBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements TaskScriptGrammarVisitor<T> {
    @Override
    public T visitInit(TaskScriptGrammarParser.InitContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitBody(TaskScriptGrammarParser.BodyContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitEmail(TaskScriptGrammarParser.EmailContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitExpr(TaskScriptGrammarParser.ExprContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitExtension(TaskScriptGrammarParser.ExtensionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitFile(TaskScriptGrammarParser.FileContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitFilename(TaskScriptGrammarParser.FilenameContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitOperation(TaskScriptGrammarParser.OperationContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitOper(TaskScriptGrammarParser.OperContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitSemi_op(TaskScriptGrammarParser.Semi_opContext ctx) {
        return visitChildren(ctx);
    }


    @Override
    public T visitExprs(TaskScriptGrammarParser.ExprsContext ctx) {
        return visitChildren(ctx);
    }
}

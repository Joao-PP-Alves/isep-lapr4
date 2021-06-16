package eapli.base.grammars;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

public class FormScriptGrammarBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements FormScriptGrammarVisitor<T> {

    @Override
    public T visitInit(FormScriptGrammarParser.InitContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitExpr(FormScriptGrammarParser.ExprContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitExprs(FormScriptGrammarParser.ExprsContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitField(FormScriptGrammarParser.FieldContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitDependencies(FormScriptGrammarParser.DependenciesContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitKeys(FormScriptGrammarParser.KeyeventContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitTypes(FormScriptGrammarParser.TypeContext ctx) {
        return visitChildren(ctx);
    }

}

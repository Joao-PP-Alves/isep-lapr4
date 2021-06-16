package eapli.base.grammars;

import eapli.base.service.domain.Form;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

public interface FormScriptGrammarVisitor<T> extends ParseTreeVisitor<T> {

    T visitInit(FormScriptGrammarParser.InitContext ctx);

    T visitExpr(FormScriptGrammarParser.ExprContext ctx);

    T visitExprs(FormScriptGrammarParser.ExprsContext ctx);

    T visitField(FormScriptGrammarParser.FieldContext ctx);

    T visitDependencies(FormScriptGrammarParser.DependenciesContext ctx);

    T visitKeys(FormScriptGrammarParser.KeyeventContext ctx);

    T visitTypes(FormScriptGrammarParser.TypeContext ctx);

}

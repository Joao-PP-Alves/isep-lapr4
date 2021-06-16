package eapli.base.grammars;

import org.antlr.v4.runtime.tree.*;

public class EvalVisitor extends FormScriptGrammarBaseVisitor<String>{

    private final String VALID = "OK";
    private final String INVALID = "NotOK";

    @Override
    public String visitInit(FormScriptGrammarParser.InitContext ctx) {
        System.out.println("Inicio da validacao do formulario");
        return visit(ctx.exprs());
    }

    @Override
    public String visitExpr(FormScriptGrammarParser.ExprContext ctx){
        String varValid = visit(ctx.var());
        String field = visit(ctx.field());
        String keyevent = visit(ctx.keyevent());
        if (varValid.equals(INVALID) || field.equals(INVALID) || keyevent.equals(INVALID)){
            return INVALID;
        }
        return VALID;
    }

    @Override
    public String visitField(FormScriptGrammarParser.FieldContext ctx){
        String varValid = visit(ctx.var());
        String dep = visit(ctx.dependencies());
        String type = visit(ctx.type());
        if (varValid.equals(INVALID)||dep.equals(INVALID)||type.equals(INVALID)){
            return INVALID;
        }
        return VALID;
    }

    @Override
    public String visitDependencies(FormScriptGrammarParser.DependenciesContext ctx){
        if (visit(ctx.var()).equals(INVALID)){
            return INVALID;
        }
        return visitChildren(ctx);
    }

    @Override
    public String visitKeys(FormScriptGrammarParser.KeyeventContext ctx){
        if(visit(ctx.var(0)).equals(INVALID) || visit(ctx.var(1)).equals(INVALID)){
            return INVALID;
        }

        return visit(ctx.unlock());
    }

    @Override
    public String visitTypes(FormScriptGrammarParser.TypeContext ctx){
        switch (ctx.getText()) {
            case "int":
            case "float":
            case "double":
            case "String":
            case "boolean":
            case "long":
                return VALID;
        }
        return INVALID;
    }

    @Override
    public String visitExprs(FormScriptGrammarParser.ExprsContext ctx){
        return visitChildren(ctx);
    }

}

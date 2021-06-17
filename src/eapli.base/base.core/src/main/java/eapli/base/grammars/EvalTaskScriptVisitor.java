package eapli.base.grammars;

public class EvalTaskScriptVisitor extends TaskScriptGrammarBaseVisitor<Integer>{

    @Override
    public Integer visitInit(TaskScriptGrammarParser.InitContext ctx){
        return visit(ctx.exprs());
    }

/*    @Override
    public Integer visitExpr(TaskScriptGrammarParser.ExprContext ctx){
        if (ctx.isEmpty()){
            return 0;
        }
        if (!ctx.email().isEmpty()){
            visitEmail(ctx.email());
        }
        if (!ctx.file().isEmpty()) {
            visitFile(ctx.file());
        }
        if (!ctx.operation().isEmpty()){
            if (!ctx.semi_op().isEmpty()){
                for (int i=0; i< ctx.semi_op().size(); i++){
                    int num = visit(ctx.semi_op(i).NUM());
                    char smth = visit(ctx.semi_op(i).symbol());
                }
                visitSemi_op(ctx.semi_op())
            }
            visitOperation(ctx.operation());
        }
       return visitChildren(ctx);
    }

    @Override
    public Integer visitEmail(TaskScriptGrammarParser.EmailContext ctx){

    }*/
}

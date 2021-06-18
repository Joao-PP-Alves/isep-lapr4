package eapli.base.grammars;

import eapli.base.APIs.email.EmailAPI;
import eapli.base.APIs.fileOpener.fileHandler;
import eapli.base.APIs.operationHandler.OperationHandler;

import java.util.Arrays;
import java.util.List;
import java.util.logging.FileHandler;

public class EvalTaskScriptVisitor extends TaskScriptGrammarBaseVisitor<String>{

    protected String writeToFile;
    protected String collabMail;
    @Override
    public String visitInit(TaskScriptGrammarParser.InitContext ctx){
        return visit(ctx.exprs());
    }

   @Override
    public String visitExpr(TaskScriptGrammarParser.ExprContext ctx){
        if (ctx.isEmpty()){
            return "Empty";
        }
        if (!ctx.email().isEmpty()){
            visitEmail(ctx.email());
        }
        if (!ctx.file().isEmpty()) {
            visitFile(ctx.file());
        }
        if (!ctx.operation().isEmpty()){
            visitOperation(ctx.operation());
        }
       return visitChildren(ctx);
    }

    @Override
    public String visitEmail(TaskScriptGrammarParser.EmailContext ctx){
        String body = Arrays.toString(ctx.body().toArray());
        EmailAPI.sendEmailToClient(collabMail,ctx.getText(),body);
        return "Done";
    }

    @Override
    public String visitOperation(TaskScriptGrammarParser.OperationContext ctx){
        int num1 = Integer.parseInt(ctx.NUM(0).getSymbol().getText());
        int num2 = Integer.parseInt(ctx.NUM(1).getSymbol().getText());
        String symbol = visit(ctx.symbol(0)).toString();
        int line = Integer.parseInt(visitSymbol(ctx.symbol(0)));
        int res1;
        double res2;
        if (line == 1){
            boolean res = OperationHandler.handleOper(num1,num2,symbol);
            System.out.println(res);
            writeToFile = writeToFile + "\n" + String.valueOf(res);
            return String.valueOf(res);
        }
        if (line == 2) {
            res1 = OperationHandler.handlePlusMinus(num1,num2,symbol);
            System.out.println(res1);
            writeToFile = writeToFile + "\n" + String.valueOf(res1);
            return String.valueOf(res1);
        }
        if (line == 3){
            res2 = OperationHandler.handleDivMul(num1,num2,symbol);
            System.out.println(res2);
            writeToFile = writeToFile + "\n" + String.valueOf(res2);

            return String.valueOf(res2);
        }
        if (line== 4){
            res2 = OperationHandler.handlePower(num1,num2,symbol);
            System.out.println(res2);
            writeToFile = writeToFile + "\n" + String.valueOf(res2);

            return String.valueOf(res2);
        }
        if (line == 5){
            res2 = OperationHandler.handlePercent(num1,num2,symbol);
            System.out.println(res2);
            writeToFile = writeToFile + "\n" + String.valueOf(res2);

            return String.valueOf(res2);
        }
        return "No operation resolved";
    }

    @Override
    public String visitSymbol(TaskScriptGrammarParser.SymbolContext ctx){
        if (ctx.isEmpty()){
            return "Empty";
        }
        if (ctx.getRuleIndex() == 0){
            return "1";
        } else if (ctx.getRuleIndex() == 1){
            return "2";
        } else if (ctx.getRuleIndex() ==2){
            return "3";
        } else if (ctx.getRuleIndex() == 3){
            return "4";
        } else if (ctx.getRuleIndex() == 4){
            return "5";
        }
        return "2";
    }

    @Override
    public String visitFile(TaskScriptGrammarParser.FileContext ctx){
        if (ctx.isEmpty()){
            return "Empty";
        }
        String filename = visitFilename(ctx.filename());
        if (ctx.getText().startsWith("write")){
            fileHandler.fileWriter(filename,writeToFile);
            writeToFile = "";
            return "File Written";
        }
        if (ctx.getText().startsWith("read")){
            return fileHandler.fileReader(filename);
        }
        return "NO FILE OPERATION DONE";
    }

    @Override
    public String visitFilename(TaskScriptGrammarParser.FilenameContext ctx){
        if (ctx.isEmpty()){
            return "Empty";
        }
        String filename = ctx.getText();
        filename = filename + visitExtension(ctx.extension());
        return filename;
    }

    @Override
    public String visitExtension(TaskScriptGrammarParser.ExtensionContext ctx){
        if (ctx.isEmpty()){
            return ".txt";
        }
        return ctx.getText();
    }
}

package eapli.base.grammars;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileInputStream;
import java.io.IOException;

public class TaskHandler {

    public static void validation(String path){
        try{
            FileInputStream fis = new FileInputStream(path);
            TaskScriptGrammarLexer lexer = new TaskScriptGrammarLexer(new ANTLRInputStream(fis));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            TaskScriptGrammarParser parser = new TaskScriptGrammarParser(tokens);
            parser.init();
        } catch (IOException io){
            System.out.println(io);
        }
    }

    public static void execution(String path,String mail){

        try{
            FileInputStream fis = new FileInputStream(path);
            TaskScriptGrammarLexer lexer = new TaskScriptGrammarLexer(new ANTLRInputStream(fis));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            TaskScriptGrammarParser parser = new TaskScriptGrammarParser(tokens);
            ParseTree tree = parser.init();
            EvalTaskScriptVisitor eval = new EvalTaskScriptVisitor();
            eval.collabMail = mail;
            eval.visit(tree);
        } catch (IOException io){
            System.out.println(io);
        }
    }

}

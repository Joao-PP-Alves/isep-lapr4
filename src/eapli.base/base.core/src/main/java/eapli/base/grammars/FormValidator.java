package eapli.base.grammars;

import eapli.base.service.domain.Script;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FormValidator {

    public static String validation(String path) {
        try {
            FileInputStream file = new FileInputStream(new File(path));
            FormScriptGrammarLexer lexer = new FormScriptGrammarLexer(new ANTLRInputStream(file));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            FormScriptGrammarParser parser = new FormScriptGrammarParser(tokenStream);
            ParseTree tree = parser.init();
            EvalVisitor evalVisitor = new EvalVisitor();
            return evalVisitor.visit(tree);
        } catch (IOException io) {
            System.out.println(io);
        }
        return "NotOK";
    }
}

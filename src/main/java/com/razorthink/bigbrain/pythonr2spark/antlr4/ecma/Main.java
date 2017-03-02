package com.razorthink.bigbrain.pythonr2spark.antlr4.ecma;

import com.razorthink.bigbrain.antlr.ECMAScriptLexer;
import com.razorthink.bigbrain.antlr.ECMAScriptParser;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.DOTTreeGenerator;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by phaneendra on 2/28/17.
 */
public class Main {

    public static void main(String[] args) throws IOException {
            System.out.println("Jarvis : I am waiting for your command");


            while (true)
            {
                    Scanner reader = new Scanner(System.in);  // Reading from System.in
                    String commnad = reader.nextLine();

                    ECMAScriptLexer lexer = new ECMAScriptLexer(new ANTLRInputStream(commnad));

                    ECMAScriptParser parser = new ECMAScriptParser(new CommonTokenStream(lexer));

                    parser.setBuildParseTree(true);
                    RuleContext tree = parser.program();
//            System.out.println(tree.toStringTree(parser));

                    ParseTreeWalker walker = new ParseTreeWalker();
                    SingleExpressionListner extractor = new SingleExpressionListner(parser);
                    walker.walk(extractor, tree);
            }

    }
}

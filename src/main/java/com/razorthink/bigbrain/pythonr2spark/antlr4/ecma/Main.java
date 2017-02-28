package com.razorthink.bigbrain.pythonr2spark.antlr4.ecma;

import com.razorthink.bigbrain.antlr.ECMAScriptLexer;
import com.razorthink.bigbrain.antlr.ECMAScriptParser;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.DOTTreeGenerator;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

/**
 * Created by phaneendra on 2/28/17.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        ECMAScriptLexer lexer = new ECMAScriptLexer(new ANTLRFileStream("src/test/test-script.tl"));

        ECMAScriptParser parser = new ECMAScriptParser(new CommonTokenStream(lexer));

        parser.setBuildParseTree(true);
        RuleContext tree = parser.program();
        System.out.println(tree.toStringTree(parser));

        ParseTreeWalker walker = new ParseTreeWalker();
        SingleExpressionListner extractor = new SingleExpressionListner(parser);
        walker.walk(extractor, tree);

    }
}

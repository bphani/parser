package com.razorthink.bigbrain.pythonr2spark.antlr4;

import java.io.FileInputStream;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;

import com.razorthink.bigbrain.antlr.*;

/**
 * Created by phaneendra on 2/26/17.
 */
public class TestR {

    public static void main(String[] args) throws Exception {
        String inputFile = "/Users/phaneendra/IdeaProjects/feb24/tiny-language-antlr4/src/main/tl/test.r";
        //if ( args.length>0 ) inputFile = args[0];
        InputStream is = System.in;
        if ( inputFile!=null ) {
            is = new FileInputStream(inputFile);
        }
        ANTLRInputStream input = new ANTLRInputStream(is);
        RLexer lexer = new RLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Print tokens BEFORE filtering
		tokens.fill();
		for (Object tok : tokens.getTokens()) {
			System.out.println(tok);
		}
        RFilter filter = new RFilter(tokens);
        filter.stream(); // call start rule: stream
        tokens.reset();
        // Print tokens AFTER filtering
		for (Object tok : tokens.getTokens()) {
			System.out.println(tok);
		}
        RParser parser = new RParser(tokens);
        parser.setBuildParseTree(true);
        RuleContext tree = parser.prog();
        //tree.save(parser, "/tmp/R.ps"); // Generate postscript
        System.out.println(tree.toStringTree(parser));
    }

}

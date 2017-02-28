package com.razorthink.bigbrain.pythonr2spark.antlr4;

import com.razorthink.bigbrain.antlr.DrinkLexer;
import org.antlr.v4.runtime.ANTLRFileStream;

import java.io.IOException;

/**
 * Created by phaneendra on 2/27/17.
 */
public class TestDrink {

    public static void main(String[] args) throws IOException {
        DrinkLexer lexer = new DrinkLexer(new ANTLRFileStream("src/test/drink.tl"));
    }
}

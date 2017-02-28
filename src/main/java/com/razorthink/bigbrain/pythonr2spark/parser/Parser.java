package com.razorthink.bigbrain.pythonr2spark.parser;

import com.razorthink.bigbrain.pythonr2spark.token.Tokenizer;

/**
 * Created by phaneendra on 2/25/17.
 */
public abstract class Parser<T extends String> {

    /**
     * Takes a line and checks to see if it is for this parser by using regex.
     */
    public abstract boolean shouldParse(String line);

    /**
     * Take the superBlock and the tokenizer for the line and return a block of this parser's type.
     */
    public abstract T parse(String superBlock, Tokenizer tokenizer);
}

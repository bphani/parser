package com.razorthink.bigbrain.pythonr2spark.token;

/**
 * Created by phaneendra on 2/25/17.
 */
public class TokenizerTest {

    public static void main(String[] args) {
        String code = "x=2*3+5";

        Tokenizer tokenizer = new Tokenizer(code);

        while (tokenizer.hasNextToken()) {
            Token t = tokenizer.nextToken();
            System.out.println(t.getType() + " " + t.getToken());
        }
    }
}

package com.razorthink.bigbrain.pythonr2spark.token;

/**
 * Created by phaneendra on 2/25/17.
 */
public class TokenizerTest {

    public static void main(String[] args) {
        String code =
                "x=df[\"abc\"].join(df[\"bef\"])";

        Tokenizer tokenizer = new Tokenizer(code);

        while (tokenizer.hasNextToken()) {
            Token t = tokenizer.nextToken();
            System.out.println(t.getType() + " " + t.getToken());
        }
    }
}

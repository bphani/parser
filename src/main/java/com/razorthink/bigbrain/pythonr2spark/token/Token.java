package com.razorthink.bigbrain.pythonr2spark.token;

/**
 * Created by phaneendra on 2/25/17.
 */


public class Token {
    private String token;
    private TokenType type;

    public Token(String token, TokenType type) {
        this.token = token;
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public TokenType getType() {
        return type;
    }
}

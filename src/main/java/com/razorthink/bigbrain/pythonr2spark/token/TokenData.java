package com.razorthink.bigbrain.pythonr2spark.token;

import java.util.regex.Pattern;

/**
 * Created by phaneendra on 2/25/17.
 */

public class TokenData {

    private Pattern pattern;
    private TokenType type;

    public TokenData(Pattern pattern, TokenType type) {
        this.pattern = pattern;
        this.type = type;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public TokenType getType() {
        return type;
    }

}

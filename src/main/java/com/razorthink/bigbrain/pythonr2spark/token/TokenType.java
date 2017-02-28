package com.razorthink.bigbrain.pythonr2spark.token;

/**
 * Created by phaneendra on 2/25/17.
 */

public enum TokenType {

    /** Absolutely nothing. */
    EMPTY,

    /** A token. For example, ( ) = , */
    TOKEN,

    /** First character is a letter, any proceeding characters are letters or numbers. */
    IDENTIFIER,

    /** A number. */
    INTEGER_LITERAL,

    /** Anything enclosed in double quotes. "Hello" "1" */
    STRING_LITERAL
}

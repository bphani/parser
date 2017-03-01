package com.razorthink.bigbrain.pythonr2spark.antlr4.ecma;

import com.razorthink.bigbrain.antlr.ECMAScriptBaseVisitor;
import com.razorthink.bigbrain.antlr.ECMAScriptParser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by phaneendra on 3/1/17.
 */
public class EvalVisitor extends ECMAScriptBaseVisitor<Value> {

    private Map<String, Value> memory = new HashMap<String, Value>();
    ECMAScriptParser parser;


    public EvalVisitor(ECMAScriptParser parser){
        this.parser=parser;
    }



    public Value visitDataFrameJoinExpression(ECMAScriptParser.DataFrameJoinExpressionContext ctx){
        String fullSignature =
                parser.getTokenStream().getText(ctx);
        return new Value(fullSignature+"::");
    }

}

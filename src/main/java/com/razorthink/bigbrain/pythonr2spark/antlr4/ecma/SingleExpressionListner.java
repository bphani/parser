package com.razorthink.bigbrain.pythonr2spark.antlr4.ecma;

import com.razorthink.bigbrain.antlr.ECMAScriptBaseListener;
import com.razorthink.bigbrain.antlr.ECMAScriptParser;

/**
 * Created by phaneendra on 2/28/17.
 */
public class SingleExpressionListner extends ECMAScriptBaseListener {

    ECMAScriptParser parser;

    public SingleExpressionListner(ECMAScriptParser parser){
        this.parser=parser;
    }

    @Override
    public void enterDataFrameJoinExpression(ECMAScriptParser.DataFrameJoinExpressionContext ctx){
        String fullSignature =
                parser.getTokenStream().getText(ctx);
        System.out.println("::"+fullSignature);
    }

    @Override
    public void exitDataFrameJoinExpression(ECMAScriptParser.DataFrameJoinExpressionContext ctx){
        //System.out.println(ctx.singleExpression()+"::");
    }
}

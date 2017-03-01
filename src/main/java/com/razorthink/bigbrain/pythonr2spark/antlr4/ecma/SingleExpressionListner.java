package com.razorthink.bigbrain.pythonr2spark.antlr4.ecma;

import com.razorthink.bigbrain.antlr.ECMAScriptBaseListener;
import com.razorthink.bigbrain.antlr.ECMAScriptParser;
import org.antlr.v4.misc.OrderedHashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by phaneendra on 2/28/17.
 */
public class SingleExpressionListner extends ECMAScriptBaseListener {

    ECMAScriptParser parser;

    public SingleExpressionListner(ECMAScriptParser parser){
        this.parser=parser;
    }

    private Map<String, String> commands = new OrderedHashMap<>();

    @Override
    public void enterDataFrameJoinExpression(ECMAScriptParser.DataFrameJoinExpressionContext ctx){
        String fullSignature =
                parser.getTokenStream().getText(ctx);
        String id = ctx.dataframeCommand().getText();

        commands.put(id,ctx.getText());
        System.out.println("::"+fullSignature);
    }

    @Override
    public void enterDataFrameNumericExpression(ECMAScriptParser.DataFrameNumericExpressionContext ctx){
        String fullSignature =
                parser.getTokenStream().getText(ctx);
        System.out.println("*"+ctx.numericLiteral().getText());
        System.out.println("**"+ctx.getText());
        String id = ctx.DataFrame().getText();
        commands.put(id,fullSignature);
        System.out.println("::"+fullSignature);
    }

    @Override
    public void enterDataFrameLiteralExpression(ECMAScriptParser.DataFrameLiteralExpressionContext ctx){
        String fullSignature =
                parser.getTokenStream().getText(ctx);
        System.out.println("**"+ctx.literal().getText());
        String id = ctx.DataFrame().getText();
        commands.put(id,fullSignature);
        System.out.println("::"+fullSignature);
    }

    @Override
    public void exitDataFrameJoinExpression(ECMAScriptParser.DataFrameJoinExpressionContext ctx){
        //System.out.println(ctx.singleExpression()+"::");
    }

    public Map<String, String> getCommands() {
        return commands;
    }
}

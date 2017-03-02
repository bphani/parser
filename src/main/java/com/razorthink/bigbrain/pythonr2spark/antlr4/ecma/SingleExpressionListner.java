package com.razorthink.bigbrain.pythonr2spark.antlr4.ecma;

import com.razorthink.bigbrain.antlr.ECMAScriptBaseListener;
import com.razorthink.bigbrain.antlr.ECMAScriptParser;

/**
 * Created by phaneendra on 2/28/17.
 */
public class SingleExpressionListner extends ECMAScriptBaseListener {

    private static String DATA_FRAME = "df";
    private static String UPPER_CASE = "upper";
    private static String LOWER_CASE = "lower";
    private static String REGEX_REPLACE = "regexp_replace";
    ECMAScriptParser parser;

    public SingleExpressionListner( ECMAScriptParser parser )
    {
        this.parser = parser;
    }

    @Override
    public void enterDataFrameJoinExpression( ECMAScriptParser.DataFrameJoinExpressionContext ctx )
    {
        //        String fullSignature =
        //                parser.getTokenStream().getText(ctx);
        int count = ctx.getChildCount();
        PythonParser pythonParser = new PythonParser();
        org.antlr.v4.runtime.tree.ParseTree parse;
        int loop = 0;
        String pythonCode = "";
        while( loop < count )
        {
            parse = ctx.getChild(loop);

            if( parse.getClass().getCanonicalName()
                    .equals(ECMAScriptParser.DataExpressionNumericContext.class.getCanonicalName()) )
            {
                pythonCode = pythonCode + DATA_FRAME + ".columns" + "[" + parse.getChild(2).getText() + "]";
            }
            if( parse.getClass().getCanonicalName()
                    .equals(ECMAScriptParser.DataExpressionColumnNameContext.class.getCanonicalName()) )
            {
                pythonCode = pythonCode + DATA_FRAME + ".columnName" + "[" + parse.getChild(2).getText() + "]";
            }
            if( parse.getClass().getCanonicalName()
                    .equals(ECMAScriptParser.DataFrameJoinCommandContext.class.getCanonicalName()) )
            {
                pythonCode = pythonCode + "." + parse.getText() + "(";
            }
            if(parse.getClass().getCanonicalName().equals(ECMAScriptParser.DataFrameToLowerExpContext.class.getCanonicalName()))
            {
                int countLower = parse.getChildCount();
                int loopLower = 0;
                String dataFrameValueExpression = "";
                String dataFrameValue = "";
                org.antlr.v4.runtime.tree.ParseTree parseLower;

                while( loopLower < countLower )
                {
                    parseLower = parse.getChild(loopLower);
                    if( parseLower.getClass().getCanonicalName()
                            .equals(ECMAScriptParser.DataExpressionNumericContext.class.getCanonicalName()) )
                    {
                        dataFrameValueExpression = pythonCode + DATA_FRAME + ".columns" + "[" + parseLower.getChild(2).getText()
                                + "]";
                        dataFrameValue = parseLower.getChild(2).getText();
                    }
                    if( parseLower.getClass().getCanonicalName()
                            .equals(ECMAScriptParser.DataExpressionColumnNameContext.class.getCanonicalName()) )
                    {
                        dataFrameValueExpression = pythonCode + DATA_FRAME + ".columnName" + "[" + parseLower.getChild(2).getText()
                                + "]";
                        dataFrameValue = parseLower.getChild(2).getText();

                    }

                    loopLower++;
                }

                pythonCode = pythonCode + DATA_FRAME + ".withColumn(" + dataFrameValue + ","+LOWER_CASE+"("
                        + dataFrameValueExpression + "))";
                pythonCode = pythonCode.replaceAll("\"", "'");
            }
            loop++;
        }

        pythonCode = pythonCode + ")";
        pythonCode = pythonCode.replaceAll("\"","'");
        System.out.println("Python Code :" + pythonCode);

    }

    @Override
    public void exitDataFrameJoinExpression( ECMAScriptParser.DataFrameJoinExpressionContext ctx )
    {
        //System.out.println(ctx.singleExpression()+"::");
    }

    @Override
    public void enterDataFrameNumericExpression( ECMAScriptParser.DataFrameNumericExpressionContext ctx )
    {

        int count = ctx.getChildCount();
        PythonParser pythonParser = new PythonParser();
        org.antlr.v4.runtime.tree.ParseTree parse;
        int loop = 0;
        String pythonCode = "";
        if( ctx.getClass().getCanonicalName()
                .equals(ECMAScriptParser.DataFrameNumericExpressionContext.class.getCanonicalName()) )
        {
            pythonCode = pythonCode + DATA_FRAME + ".columns" + "[" + ctx.getChild(2).getText() + "]";
        }

        System.out.print("Python Code :" + pythonCode);

    }

    //DataFrameStringExpression
    @Override
    public void enterDataFrameStringExpression( ECMAScriptParser.DataFrameStringExpressionContext ctx )
    {

        int count = ctx.getChildCount();
        PythonParser pythonParser = new PythonParser();
        org.antlr.v4.runtime.tree.ParseTree parse;
        String pythonCode = "";
        if( ctx.getClass().getCanonicalName()
                .equals(ECMAScriptParser.DataFrameStringExpressionContext.class.getCanonicalName()) )
        {
            pythonCode = pythonCode + DATA_FRAME + ".columnName" + "[" + ctx.getChild(2).getText() + "]";
        }

        pythonCode = pythonCode.replaceAll("\"","'");
        System.out.print("Python Code :" + pythonCode);

    }

    //DataFrameToUpperExpression

    @Override
    public void enterDataFrameToUpperExpression( ECMAScriptParser.DataFrameToUpperExpressionContext ctx )
    {

        int count = ctx.getChildCount();
        PythonParser pythonParser = new PythonParser();
        org.antlr.v4.runtime.tree.ParseTree parse;
        int loop = 0;
        String pythonCode = "";
        String dataFrameValueExpression = "";
        String dataFrameValue = "";
        while( loop < count )
        {
            parse = ctx.getChild(loop);
            if( parse.getClass().getCanonicalName()
                    .equals(ECMAScriptParser.DataExpressionNumericContext.class.getCanonicalName()) )
            {
                dataFrameValueExpression = pythonCode + DATA_FRAME + ".columns" + "[" + parse.getChild(2).getText()
                        + "]";
                dataFrameValue = parse.getChild(2).getText();
            }
            if( parse.getClass().getCanonicalName()
                    .equals(ECMAScriptParser.DataExpressionColumnNameContext.class.getCanonicalName()) )
            {
                dataFrameValueExpression = pythonCode + DATA_FRAME + ".columnName" + "[" + parse.getChild(2).getText()
                        + "]";
                dataFrameValue = parse.getChild(2).getText();

            }

            loop++;
        }

        pythonCode = DATA_FRAME + " = " + DATA_FRAME + ".withColumn(" + dataFrameValue + ","+UPPER_CASE+"("
                + dataFrameValueExpression + "))";
        pythonCode = pythonCode.replaceAll("\"", "'");
        System.out.print("Python Code :" + pythonCode);

    }

    //DataFrameToLowerExpression

    @Override
    public void enterDataFrameToLowerExpression( ECMAScriptParser.DataFrameToLowerExpressionContext ctx )
    {

        int count = ctx.getChildCount();
        PythonParser pythonParser = new PythonParser();
        org.antlr.v4.runtime.tree.ParseTree parse;
        int loop = 0;
        String pythonCode = "";
        String dataFrameValueExpression = "";
        String dataFrameValue = "";
        while( loop < count )
        {
            parse = ctx.getChild(loop);
            if( parse.getClass().getCanonicalName()
                    .equals(ECMAScriptParser.DataExpressionNumericContext.class.getCanonicalName()) )
            {
                dataFrameValueExpression = pythonCode + DATA_FRAME + ".columns" + "[" + parse.getChild(2).getText()
                        + "]";
                dataFrameValue = parse.getChild(2).getText();
            }
            if( parse.getClass().getCanonicalName()
                    .equals(ECMAScriptParser.DataExpressionColumnNameContext.class.getCanonicalName()) )
            {
                dataFrameValueExpression = pythonCode + DATA_FRAME + ".columnName" + "[" + parse.getChild(2).getText()
                        + "]";
                dataFrameValue = parse.getChild(2).getText();

            }

            loop++;
        }

        pythonCode = DATA_FRAME + " = " + DATA_FRAME + ".withColumn(" + dataFrameValue + ","+LOWER_CASE+"("
                + dataFrameValueExpression + "))";
        pythonCode = pythonCode.replaceAll("\"", "'");
        System.out.print("Python Code :" + pythonCode);

    }

    //DataFrameRegexReplaceExpression
    @Override
    public void enterDataFrameRegexReplaceExpression( ECMAScriptParser.DataFrameRegexReplaceExpressionContext ctx )
    {
        int count = ctx.getChildCount();
        org.antlr.v4.runtime.tree.ParseTree parse;
        int loop = 0;
        String pythonCode = "self.df = self.df.withColumn(";
        String columnName = "";
        while( loop < count ) {

            parse = ctx.getChild(loop);
            if( parse.getClass().getCanonicalName()
                    .equals(ECMAScriptParser.DataExpressionColumnNameContext.class.getCanonicalName()) ) {
                columnName = parse.getChild(2).getText();
                pythonCode = pythonCode + columnName + ", " + REGEX_REPLACE + "(self."+DATA_FRAME+ "[" + columnName + "]" ;
            }
            if(parse.getClass().getCanonicalName().equals(ECMAScriptParser.LiteralContext.class.getCanonicalName()))
            {
                pythonCode = pythonCode + ", "+ parse.getText();
        }
        loop++;
        }

        pythonCode = pythonCode + "))";
        pythonCode = pythonCode.replaceAll("\"","'");
        System.out.print(pythonCode);
    }

}

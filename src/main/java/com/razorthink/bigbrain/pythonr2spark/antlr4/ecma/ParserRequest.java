package com.razorthink.bigbrain.pythonr2spark.antlr4.ecma;

/**
 * Created by sunilrao on 02/03/17.
 */
public class ParserRequest
{
    private String inputCode;
    private String filePath;
    private int dataSourceInstanceId;

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int getDataSourceInstanceId() {
        return dataSourceInstanceId;
    }

    public void setDataSourceInstanceId(int dataSourceInstanceId) {
        this.dataSourceInstanceId = dataSourceInstanceId;
    }
}

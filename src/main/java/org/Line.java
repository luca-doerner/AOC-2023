package org;

public class Line {
    private String input;

    public Line(String input){
        this.input = input;
    }

    public String getInput(){
        return this.input;
    }

    public void setInput(String input){
        this.input = input;
    }

    protected boolean isDigit(char character){
        return character >= 48 && character <= 57;
    }
}

package org.example;

public class Line {
    String input;

    public Line(String input){
        this.input = input;
    }

    private boolean isDigit(char character){
        return character >= 48 && character <= 57;
    }

    public int getCalibrationValue(){
        int calibrationValue;
        int first = -1, last = -1;
        for(int i = 0; i < input.length(); i++){
            char character = input.charAt(i);
            if(isDigit(character)){
                if(first == -1){
                    first = Integer.parseInt(String.valueOf(character));
                }
                last = Integer.parseInt(String.valueOf(character));
            }
        }

        calibrationValue = Integer.parseInt(first + "" + last);

        return calibrationValue;
    }
}

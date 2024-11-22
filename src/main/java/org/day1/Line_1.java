package org.day1;

import org.Line;

public class Line_1 extends Line {

    protected Line_1(Line line){
        super(line.getInput());
    }


    public int getCalibrationValue(){
        int calibrationValue;
        int first = -1, last = -1;
        for(int i = 0; i < this.getInput().length(); i++){
            char character = this.getInput().charAt(i);
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

    public void transformLine(){
        String[] numStr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        StringBuilder onlyNumbers = new StringBuilder();
        for(int i = 0; i < this.getInput().length(); i++){
            char character = this.getInput().charAt(i);
            if(!isDigit(character)){
                for(int j = 0; j < numStr.length; j++){
                    if(i + numStr[j].length() <= this.getInput().length()){
                        if(this.getInput().startsWith(numStr[j], i)){
                            onlyNumbers.append(j);
                            break;
                        }
                    }
                }
            } else{
                onlyNumbers.append(character);
            }
        }

        this.setInput(onlyNumbers.toString());
    }
}

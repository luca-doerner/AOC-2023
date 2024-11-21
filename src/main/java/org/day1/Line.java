package org.day1;

public class Line {
    String input;

    public Line(String input){
        this.input = input;
    }

    private boolean isDigit(char character){
        return character >= 48 && character <= 57;
    }

    public int getCalibrationValuePart1(){
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

    public void transformLine(){
        String[] numStr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        StringBuilder onlyNumbers = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            char character = input.charAt(i);
            if(!isDigit(character)){
                for(int j = 0; j < numStr.length; j++){
                    if(i + numStr[j].length() <= input.length()){
                        if(input.startsWith(numStr[j], i)){
                            onlyNumbers.append(j);
                            break;
                        }
                    }
                }
            } else{
                onlyNumbers.append(character);
            }
        }

        input = onlyNumbers.toString();
    }
}

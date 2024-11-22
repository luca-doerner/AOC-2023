package org.day4;

import org.Line;

import java.util.ArrayList;
import java.util.Arrays;

public class Line_4 extends Line {
    ArrayList<String> winningNumbers;
    ArrayList<String> yourNumbers;

    public Line_4(Line line){
        super(line.getInput());
        getNumbers();
    }

    private void getNumbers(){
        String numbers = this.getInput().split(": ")[1];
        String winningNumberStr = numbers.split("\\|")[0];
        String yourNumberStr = numbers.split("\\|")[1];

        winningNumbers = new ArrayList<>(Arrays.asList(winningNumberStr.split(" ")));
        winningNumbers.removeAll(Arrays.asList("", null));
        yourNumbers = new ArrayList<>(Arrays.asList(yourNumberStr.split(" ")));
        yourNumbers.removeAll(Arrays.asList("", null));
    }

    public int calcWin(){
        int sum = 0;
        for(String num: yourNumbers){
            if(winningNumbers.contains(num)){
                if(sum == 0){
                    sum = 1;
                } else{
                    sum *= 2;
                }
            }
        }

        return sum;
    }

    public int calcWinnings(){
        int sum = 0;
        for(String num: yourNumbers){
            if(winningNumbers.contains(num)){
                sum += 1;
            }
        }

        return sum;
    }
}

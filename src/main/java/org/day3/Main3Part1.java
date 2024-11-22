package org.day3;

import org.GetInput;
import org.Line;

import java.util.ArrayList;

public class Main3Part1 {
    public static void main(String[] args) {
        GetInput getInput;

        try {
            getInput = new GetInput("input_day_3.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ArrayList<Line_3> lines = new ArrayList<>();

        int index = 0;
        for(Line line: getInput.getLines()){
            index++;
            lines.add(new Line_3(line, index));
        }

        int sum = 0;

        for(int i = 0; i < lines.size(); i++){
            if(i > 0){
                lines.get(i).checkNumbersOtherLine(lines.get(i-1));
            }
            if(i < lines.size()-1){
                lines.get(i).checkNumbersOtherLine(lines.get(i+1));
            }
            sum += lines.get(i).sumAllTrue();
        }

        System.out.println(sum);
    }
}

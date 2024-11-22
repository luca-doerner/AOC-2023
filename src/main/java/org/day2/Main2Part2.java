package org.day2;

import org.GetInput;
import org.Line;

import java.util.ArrayList;

public class Main2Part2 {
    public static void main(String[] args) {
        GetInput getInput;
        try {
            getInput = new GetInput("input_day_2.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ArrayList<Line_2> lines = new ArrayList<>();

        for(Line line: getInput.getLines()){
            lines.add(new Line_2(line));
        }

        int sum = 0;

        for(Line_2 line: lines){
            sum += line.getMinMax();
        }

        System.out.println(sum);
    }
}

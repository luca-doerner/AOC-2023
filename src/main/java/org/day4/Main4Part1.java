package org.day4;

import org.GetInput;
import org.Line;

import java.util.ArrayList;

public class Main4Part1 {
    public static void main(String[] args) {
        GetInput getInput;
        try {
            getInput = new GetInput("input_day_4.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ArrayList<Line_4> lines = new ArrayList<>();

        for(Line line: getInput.getLines()){
            lines.add(new Line_4(line));
        }

        int sum = 0;

        for(Line_4 line: lines){
            sum += line.calcWin();
        }
        System.out.println(sum);
    }
}

package org.day1;

import org.GetInput;
import org.Line;

import java.util.ArrayList;

public class Main1Part2 {
    public static void main(String[] args) {
        GetInput get;
        try {
            get = new GetInput("input_day_1.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        int totalCalibrationValue = 0;

        ArrayList<Line_1> lines = new ArrayList<>();

        for(Line line: get.getLines()){
            lines.add(new Line_1(line));
        }

        for (Line_1 line : lines) {
            System.out.print(line.getInput());
            System.out.print("    ");
            line.transformLine();
            System.out.print(line.getInput());
            System.out.print("    ");
            System.out.println(line.getCalibrationValue());
            totalCalibrationValue += line.getCalibrationValue();
        }

        System.out.println(totalCalibrationValue);
    }
}

package org.day4;

import org.GetInput;
import org.Line;

import java.util.ArrayList;

public class Main4Part2 {
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

        for(int i = 0; i < lines.size(); i++){
            sum += totalScratchcards(lines, i);
        }

        System.out.println(sum);
    }

    public static int totalScratchcards(ArrayList<Line_4> lines, int index){
        int sum = 1;

        for(int j = 1; j <= lines.get(index).calcWinnings(); j++){
            if(index + j <= lines.size()){
                sum += totalScratchcards(lines, index+j);
            }
        }

        return sum;
    }
}

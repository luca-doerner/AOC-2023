package org.day4;

import org.GetInput;

public class Main4Part1 {
    public static void main(String[] args) {
        GetInput getInput;
        try {
            getInput = new GetInput("input_day_4.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

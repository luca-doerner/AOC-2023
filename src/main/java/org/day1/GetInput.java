package org.day1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class GetInput {
    ArrayList<Line> lines;

    GetInput() throws Exception {
        lines = new ArrayList<>();

        InputStreamReader isr = new InputStreamReader(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("input.txt")));

        try(BufferedReader reader = new BufferedReader(isr)){
            for(String line; (line = reader.readLine()) != null; ){
                lines.add(new Line(line));
            }
        }
    }

    public ArrayList<Line> getLines() {
        return this.lines;
    }

    public Line getLineByIndex(int index) {
        return this.lines.get(index);
    }
}

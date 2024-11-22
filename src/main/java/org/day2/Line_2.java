package org.day2;

import org.Line;

import java.util.Objects;

public class Line_2 extends Line{
    final static int[] MAX_COLORS = {12, 13, 14};
    final static String[] COLORS = {"red", "green", "blue"};
    int[] minMaxColors = {1, 1, 1};
    private int ID;

    public Line_2(Line line){
        super(line.getInput());
        ID = -1;
    }

    public int getID(){
        return this.ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public boolean solveLine(){
        String name = this.getInput().split(":")[0];
        String idStr = name.split(" ")[1];

        setID(Integer.parseInt(idStr));

        String gameStr = this.getInput().split(": ")[1];
        String[] sets = gameStr.split("; ");

        for(String set: sets){
            String[] cubes = set.split(", ");

            for(String cube: cubes){
                int num = Integer.parseInt(cube.split(" ")[0]);
                String color = cube.split(" ")[1];

                for(int i = 0; i < COLORS.length; i++){
                    if(Objects.equals(COLORS[i], color) && num > MAX_COLORS[i]){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public int getMinMax(){
        String name = this.getInput().split(":")[0];
        String idStr = name.split(" ")[1];

        setID(Integer.parseInt(idStr));

        String gameStr = this.getInput().split(": ")[1];
        String[] sets = gameStr.split("; ");

        for(String set: sets){
            String[] cubes = set.split(", ");

            for(String cube: cubes){
                int num = Integer.parseInt(cube.split(" ")[0]);
                String color = cube.split(" ")[1];

                for(int i = 0; i < COLORS.length; i++){
                    if(Objects.equals(COLORS[i], color) && num > minMaxColors[i]){
                        minMaxColors[i] = num;
                    }
                }
            }
        }

        int sum = 1;

        for(int i: minMaxColors){
            sum *= i;
        }

        return sum;
    }
}

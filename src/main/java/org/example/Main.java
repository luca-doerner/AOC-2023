package org.example;

public class Main {
    public static void main(String[] args) {
        GetInput get;
        try {
            get = new GetInput();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        int totalCalibrationValue = 0;

        for(int i = 0; i < get.getLines().size(); i++){
            totalCalibrationValue += get.getLineByIndex(i).getCalibrationValue();
        }

        System.out.println(totalCalibrationValue);
    }
}

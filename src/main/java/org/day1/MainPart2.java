package org.day1;

public class MainPart2 {
    public static void main(String[] args) {
        GetInput get;
        try {
            get = new GetInput();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        int totalCalibrationValue = 0;

        for(int i = 0; i < get.getLines().size(); i++){
            System.out.print(get.getLineByIndex(i).input);
            System.out.print("    ");
            get.getLineByIndex(i).transformLine();
            System.out.print(get.getLineByIndex(i).input);
            System.out.print("    ");
            System.out.println(get.getLineByIndex(i).getCalibrationValuePart1());
            totalCalibrationValue += get.getLineByIndex(i).getCalibrationValuePart1();
        }

        System.out.println(totalCalibrationValue);
    }
}

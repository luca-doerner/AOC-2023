package org.day3;

import org.Line;

import java.util.ArrayList;
import java.util.Arrays;

public class Line_3 extends Line{
    public char[] characters;
    public ArrayList<Integer> nums;
    public ArrayList<Integer> numLengths;
    public ArrayList<Integer> numIndexes;
    public boolean[] numsValid;
    public ArrayList<ArrayList<Integer>> gearIndexes;
    public ArrayList<Integer> gearRatio;
    int index;

    public Line_3(Line line, int index){
        super(line.getInput());
        this.index = index;
        characters = getChars();
        getNums();
        numsValid = new boolean[numLengths.size()];
        for(int i = 0; i < numIndexes.size(); i++){
            numsValid[i] = false;
        }
        checkNumberNeighbors();

    }

    public char[] getChars(){
        return this.getInput().toCharArray();
    }

    public void getGears(){
        ArrayList<ArrayList<Integer>> gearIndexes = new ArrayList<>();

        for(int i = 0; i < characters.length; i++){
            if((characters[i] + "").equals("*")){
                ArrayList<Integer> gearBegin = new ArrayList<>();
                gearBegin.add(i);
                gearIndexes.add(gearBegin);
            }
        }

        this.gearIndexes = gearIndexes;
    }

    public void checkGearNeighbors(){
        for(int i = 0; i < numIndexes.size(); i++){

        }
    }

    public void getNums() {
        ArrayList<String> numsAndSymsTest = new ArrayList<>(Arrays.asList(this.getInput().split("\\.")));
        ArrayList<String> numsAndSyms = new ArrayList<>();
        numsAndSymsTest.removeAll(Arrays.asList("", null));

        for(int i = 0; i < numsAndSymsTest.size(); i++){
            numsAndSymsTest.set(i, numsAndSymsTest.get(i).replaceAll("[^\\d]", " "));
            ArrayList<String> saveSplit = new ArrayList<>(Arrays.asList(numsAndSymsTest.get(i).split(" ")));
            saveSplit.removeAll(Arrays.asList("", null));
            numsAndSyms.addAll(saveSplit);
        }

        //for(int i = 0; i < numsAndSymsTest.size)
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Integer> numLenghts = new ArrayList<>();
        ArrayList<Integer> numIndexes = new ArrayList<>();

        int previousLastindex = -1;

        for(String str: numsAndSyms){

            for(int i = 0; i < characters.length-str.length()+1; i++){
                if(isDigit(characters[i]) && characters[i] == str.charAt(0) && characters[i+str.length()-1] == str.charAt(str.length()-1) && i > previousLastindex){
                    nums.add(Integer.parseInt(str));
                    numLenghts.add(str.length());
                    numIndexes.add(i);
                    previousLastindex = i+str.length()-1;
                    break;
                }
            }
        }
        this.nums = nums;
        this.numLengths = numLenghts;
        this.numIndexes = numIndexes;
    }

    public void checkNumberNeighbors(){
        for(int i = 0; i < numIndexes.size(); i++){
            int lastIndex = numIndexes.get(i) + numLengths.get(i) - 1;

            if(numIndexes.get(i) > 0){
                if(!isDigit(characters[numIndexes.get(i)-1]) && characters[numIndexes.get(i)-1] != '.'){
                    numsValid[i] = true;
                }
            }
            if(lastIndex < characters.length-1){
                if(!isDigit(characters[lastIndex+1]) && characters[lastIndex+1] != '.'){
                    numsValid[i] = true;
                }
            }

        }

    }

    public void checkNumbersOtherLine(Line_3 line){
        System.out.print(index);
        for(int i = 0; i < numIndexes.size(); i++){
            int firstIndex = numIndexes.get(i);
            int lastIndex = numIndexes.get(i) + numLengths.get(i) - 1;

            System.out.print(" ");
            System.out.print(numIndexes.get(i));
            System.out.print(" ");
            System.out.print(nums.get(i));

            for(int j = firstIndex; j <= lastIndex; j++){
                //links
                if(j > 0){
                    if(!isDigit(line.characters[j-1]) && line.characters[j-1] != '.'){
                        numsValid[i] = true;
                    }
                }
                //direkt
                if(!isDigit(line.characters[j]) && line.characters[j] != '.'){
                    numsValid[i] = true;
                }
                //rechts
                if(j < line.characters.length-1){
                    if(!isDigit(line.characters[j+1]) && line.characters[j+1] != '.'){
                        numsValid[i] = true;
                    }
                }

            }
            System.out.print(numsValid[i]);
        }
        System.out.println();

    }

    public int sumAllTrue(){
        int sum = 0;
        for(int i = 0; i < numsValid.length; i++){
            if(numsValid[i]){
                sum += nums.get(i);
            }
        }

        return sum;
    }
}

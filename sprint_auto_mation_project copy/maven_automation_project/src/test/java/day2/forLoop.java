package day2;

import java.util.ArrayList;

public class forLoop {
    public static void main(String[] args) {

        //create an arrayList for cities and loop/iterating through all the values using for loop
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brooklyn");
        cities.add("Queen");
        cities.add("Manhattan");
        cities.add("Staten island ");

        for (int i = 0; i < cities.size(); i++){
            System.out.println("i is now " +i);
            System.out.println(" My city is " + cities.get(3));
        }//end for loop









    }//end of main method

}//end of java class

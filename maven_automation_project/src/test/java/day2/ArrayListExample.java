package day2;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        //create an ArrayList for countries
        ArrayList<String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("Bangladesh");
        countries.add("India");
        countries.add("Canada");
        countries.add("Pakistan");


        //I want to print 4th value from the list and the third value from the list
        System.out.println("My last country is " + countries.get(4) + " and my third country is " + countries.get(2));

        //create an arrayList for boroughs
        ArrayList<String> boroughs = new ArrayList<>();
        boroughs.add("manhattan");
        boroughs.add("staten island");
        boroughs.add("brooklyn");
        boroughs.add("queens");
        boroughs.add("bronx");

        //I want to print 2nd and 4 borough from the list
        System.out.println(" my second borough is " + boroughs.get(1) + " and my 4th borough is " + boroughs.get(3));



    }//end of main method
}//end of java class

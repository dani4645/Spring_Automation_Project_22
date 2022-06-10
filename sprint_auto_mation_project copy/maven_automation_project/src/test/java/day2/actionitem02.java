package day2;

import java.util.ArrayList;

public class actionitem02 {
    public static void main(String[] args) {

        //create an array list for countries
        ArrayList<String> countries = new ArrayList<>();
        countries.add( "Pakistan");
        countries.add( "usa");
        countries.add( "bangladesh");

        //declare country code as integers
        ArrayList<Integer> countryCodes= new ArrayList<>();
        countryCodes.add(+92);
        countryCodes.add(+1 );
        countryCodes.add(+880 );

        //declare a for loop of countries and their countryCodes
        for (int i = 0;  i < countries.size() ; i++){


                System.out.println(" My country is " + countries.get(i) + " and my countryCode is " + countryCodes.get(i));

            }//END OF FOR LOOP




    }//END OF MAIN
}//end of java class

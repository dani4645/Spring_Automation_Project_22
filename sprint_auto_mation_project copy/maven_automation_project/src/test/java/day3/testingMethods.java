package day3;

import ReusableLibraries.ReusableMethods;

public class testingMethods {
    public static void main(String[] args) {

        //call the add two number method and execute it
       // ReusableMethod.addTwoNumbers(20,30);

        //call the return method and store it in a variable  to perform something else
        int finalResult = ReusableMethods.subtractTwoNumbers( 20, 10);
        int newResult = finalResult + 10;
        System.out.println(" new result is " + newResult);

    }//end of main method
}//end of java class

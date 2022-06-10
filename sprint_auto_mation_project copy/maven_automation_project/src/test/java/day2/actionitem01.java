package day2;


public class actionitem01 {
    public static void main(String[] args) {
        //create string array for region and country codes
        String[] region = new String[]{" lahore "," islamabad ", " karachi ", };
        int[] areaCode = new int[]{ 111,222,333};

        //initializing starting point before calling while loop
        int i = 0;
        //define endpoint for while loop
        while (i < region.length){
            System.out.println("My region is " + region[i] + " and My area code is " + areaCode[i]);

            //increamenting
            i = i+1;

        }//end of while loop

    }//end of main
}//end of java class

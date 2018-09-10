package kap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Reuben Dack
 * @since 27/08/2018 16:09
 */
public class KapRunner {

    public static int[][] kapRun() {


        //get Input number
        //int input;
        int n_dash;
        int n_doubleDash;
        String newTotal;
        String input;
        int newTotalInt;
        //Scanner keyboard = new Scanner(System.in);
        //System.out.print("Enter integer: ");
        //input = keyboard.next();

        // important variables
        int noOut=10000;
        int maxLoop=10;
        int k = 4;
        String[] outputStringArray = new String[noOut];
        // variables to add?
        //Base --BigInteger


        int[][] loopsArray =new int [maxLoop][noOut];
        int counter;

        int[][] totalArray = new int[maxLoop][noOut];
//        try {
//            FileOutputStream file = new FileOutputStream("Kaprekar_Routine.dat");


            for (counter = 0; counter < noOut; counter++) {
                input = Integer.toString(counter);


                while (input.length() != k) {
                    input = "0" + input;
                    //System.out.println("while loop active");
                }
                newTotal = input;


                int loopCounter = 1;
                int flag = 0;
                int elementNo = -1;

//                for (int i = 0; i < Array.getLength(totalArray); i++) {
//                    totalArray[i][counter] = 0;
//                }


                totalArray[0][counter] = Integer.parseInt(input);


                //Loop for or while
                while (flag == 0) {
                    //System.out.println("loop=" + j);

                    //create new number n' in descending order
                    String strNDash = newTotal;
                    String[] strNDashArray = strNDash.split("");
                    Integer[] intNDashArray = new Integer[strNDashArray.length];

                    for (int i = 0; i < intNDashArray.length; i++) {
                        intNDashArray[i] = Integer.valueOf(strNDashArray[i]);
                    }

                    Arrays.sort(intNDashArray, Collections.reverseOrder());

                    strNDash = "";

                    for (int i = 0; i < intNDashArray.length; i++) {
                        strNDash = strNDash + intNDashArray[i];
                    }

                    n_dash = Integer.parseInt(strNDash);


                    //create new number n'' in ascending order
                    String strNDoubleDash = newTotal;
                    String[] strNDoubleDashArray = strNDoubleDash.split("");
                    Integer[] intNDoubleDashArray = new Integer[strNDoubleDashArray.length];

                    for (int i = 0; i < intNDoubleDashArray.length; i++) {
                        intNDoubleDashArray[i] = Integer.valueOf(strNDoubleDashArray[i]);
                    }

                    Arrays.sort(intNDoubleDashArray);

                    strNDoubleDash = "";

                    for (int i = 0; i < intNDashArray.length; i++) {
                        strNDoubleDash = strNDoubleDash + intNDoubleDashArray[i];
                    }

                    n_doubleDash = Integer.parseInt(strNDoubleDash);


                    //subtract n'-n''

                    newTotalInt = n_dash - n_doubleDash;

                    //deal with missing leading zeros

//            String strNewTotal =Integer.toString(newTotalInt);
//
//            int [] newTotalIntArray = new int[stringLength];
//
//            for (i = 0; i < ;)


                    //for (int i = strNDashArray.length; i > 0; i--){

                    //}
                    newTotal = Integer.toString(newTotalInt);
                    //System.out.println("newTotal");

                    while (newTotal.length() != input.length()) {
                        newTotal = "0" + newTotal;
                        //System.out.println("while loop active");
                    }

//                System.out.println("Input= " + counter);
//                System.out.print("n'= ");
//                System.out.println(n_dash);
//                System.out.print("n''= ");
//                System.out.println(n_doubleDash);
//                System.out.print("n'-n''= ");
//                System.out.println(newTotal);
                    //System.out.println(Arrays.toString(totalArray));

                    totalArray[loopCounter][counter] = newTotalInt;

                    for (int i = 0; i < loopCounter; i++) {
                        if (newTotalInt == totalArray[i][counter]) {
                            flag = 1;
                            elementNo = i;
                            int loopInt=0;

                            for (int j = elementNo; j < loopCounter; j++){
                                loopsArray[loopInt][counter] = totalArray[j][counter];
                                loopInt++;
                            }
                            outputStringArray[counter] = "";
                            for (int p=0; p < maxLoop; p++)
                                outputStringArray[counter] = outputStringArray[counter] + Integer.toString(loopsArray[p][counter]) + ", ";


                            break;
                        }
                    }
                    loopCounter++;
                    //System.out.println(totalArray);


                }
//            System.out.println("elementNo=");
//            System.out.println(elementNo);
//            System.out.println("loopCounter=");
//            System.out.println(loopCounter - 1)
//            System.out.println(Arrays.toString(totalArray));

                //write to file
//                for (int i = 0; i < totalArray.length; i++)
//                    file.write(totalArray[i]);


            }
//            file.close();
//        }
//        catch (IOException e) {
//            System.out.println("Error - " + e.toString());
//        }

//        for (int i=0; i < counter; i++ ){
//            System.out.println(outputStringArray[i]);
//        }
        System.err.println("Finding outputs 20:38");
        String[] loopsOut = new String[noOut];

        for (int i=0; i< counter; i++){
            loopsOut[i]= " ";
            boolean newOut = true;
             //   for (int j=0 ; j < counter; j++){
                    // if (outputStringArray[i].equals(outputStringArray[j])==true){
                         for (int l=0; l < counter; l++){
                             if (outputStringArray[i].equals(loopsOut[l])){
                              newOut =false;
                             }
                        }
                   // }
              //  }
                if (newOut==true){
                    loopsOut[i] = outputStringArray[i];
                }
            System.err.println("looping " + i);

        }

        System.err.println("out of loop");

        for (int i =0; i < counter; i++){
            if (loopsOut[i].equals(" ")==false){
                System.out.println(loopsOut[i]);
            }

        }


        return totalArray;
    }
}

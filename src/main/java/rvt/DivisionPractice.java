package rvt;

import java.util.*;
import java.lang.*;
public class DivisionPractice
{
    /***
     * 
     * Enhance the DivisionPractice program from the chapter:

        Put in a loop so that the user is repeatedly asked for the numerator and the divisor. 
        For each set of data, the program prints out the result, or an informative error message if there is a problem (division by zero or poor input data).
        The program continues looping, even if there is a problem
        Exit the loop when data entered for the numerator start with characters "q" or "Q". Don't print out an error message in this case.
        Don't ask for the divisor if the user just asked to quit. 

        Here is sample output from one run:

        Enter the numerator: 12
        Enter the divisor:  4
        12 / 4 is 3

        Enter the numerator: 12
        Enter the divisor  : 0
        You can't divide 12 by 0

        Enter the numerator: glarch
        You entered bad data.
        Please try again.

        Enter the numerator: quit

        You will need to use the method charAt() from the String class. 
     */
  public static void main ( String[] a ) 
  {
    Scanner scan = new Scanner( System.in  );
    String num = null;
    int div = 0;
    while (true){
        try
        { 
        System.out.print("Enter the numerator: ");
        num = scan.next();
        char isq = num.charAt(0);
        if (isq == 'q'){
          break;
        }
        System.out.print("Enter the divisor  : ");
        div = scan.nextInt();
        System.out.println( num + " / " + div + " is " + (Integer.valueOf(num)/div) + " rem " + (Integer.valueOf(num)%div) );
        } 
        catch (InputMismatchException ex )
        { 
        System.out.println("You entered bad data. Only integers allowed or enter q to exit programm." );
        }
        catch (ArithmeticException ex )
        { 
        System.out.println("You can't divide " + num + " by " + div);
        } 
    }
  }
}
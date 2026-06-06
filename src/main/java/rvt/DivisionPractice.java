package rvt;

import java.util.*;
import java.lang.*;
public class DivisionPractice
{

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
          scan.close();
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
  public static void groupAdd(){
    Scanner scan = new Scanner( System.in  );
    String input = scan.nextLine();
  }
}

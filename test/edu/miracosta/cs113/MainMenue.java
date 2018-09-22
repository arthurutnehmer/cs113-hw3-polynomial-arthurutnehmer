package edu.miracosta.cs113;
import javafx.scene.Scene;

import java.util.Scanner;
public class MainMenue
{
    public static void main(String[]args)
    {
        Scanner keyboard = new Scanner(System.in);
        boolean alive = true;
        Driver driver = new Driver();
        System.out.println("Welcome to Polynomial adder 1.0");
        System.out.println("select a letter to perform an action");
        System.out.println("C.) Create polynomial 1.");
        String selection = keyboard.nextLine();
        selection.toUpperCase();
        while (alive = true)
        {
            if(selection.toUpperCase().equals("C"))
            {
                System.out.println("********Please enter your polynomial as followed:********");
                System.out.println("2x^2 +2x^2 +3x^2");
                System.out.println("use + or - in front of each term to indicate its polatity.");
                System.out.println("+2^0 indicates 2");
                System.out.println("Spaces are used in between terms while ^ is used to indicate a power.");
                System.out.println("********Please enter your polynomial as followed:********");
                driver.createPolynomial1();
                driver.enterPolynomial1AllAtOnce(keyboard.nextLine());
            }
            else if(selection.toUpperCase().equals("S"))
            {
                driver.printPolynomial1User();
            }
            else if(selection.toUpperCase().equals("CL"))
            {
                driver.clearPolynomial1();
            }

            else if(selection.toUpperCase().equals("C2"))
            {
                System.out.println("********Please enter your polynomial as followed:********");
                System.out.println("2x^2 +2x^2 +3x^2");
                System.out.println("use + or - in front of each term to indicate its polatity.");
                System.out.println("+2^0 indicates 2");
                System.out.println("Spaces are used in between terms while ^ is used to indicate a power.");
                System.out.println("********Please enter your polynomial as followed:********");
                driver.createPolynomial2();
                driver.enterPolynomial2AllAtOnce(keyboard.nextLine());
            }
            else if(selection.toUpperCase().equals("S2"))
            {
                driver.printPolynomial2User();
            }
            else if(selection.toUpperCase().equals("CL2"))
            {
                driver.clearPolynomial2();
            }

            else if(selection.toUpperCase().equals("A"))
            {
                driver.addPolynomialsTogether();
            }
            else if(selection.toUpperCase().equals("E"))
            {
                alive = false;
                System.exit(0);
                break;
            }
            System.out.println("-------------------select a letter to perform an action-------------------");
            System.out.println("  C.) Create a polynomial1.");
            System.out.println("  S.) See polynomial 1");
            System.out.println(" CL.) Clear polynomial 1");
            System.out.println(" C2.) Create a polynomial2.");
            System.out.println(" S2.) See polynomial 2");
            System.out.println("CL2.) Clear polynomial 2");
            System.out.println("  A.) ADD TERMS TOGETHER");
            System.out.println("  E.) Exit");
            System.out.println("-------------------select a letter to perform an action-------------------");
            selection = keyboard.nextLine();
            selection.toUpperCase();

        }
    }
}

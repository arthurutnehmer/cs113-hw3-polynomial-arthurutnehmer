/**
 * Term.java : This class is responsible for storing terms of a polynomial.
 * The terms are split into operand, coefficient, and exponent
 *
 * @author  arthurutnehmer <arthurutnehmer@gmail.com>
 * @version 1.0
 */

package edu.miracosta.cs113;

public class Term
{
    public int exponent;
    public int coefficient;

    //default empty constructor.
    public Term()
    {
        this.coefficient = 1;
        this.exponent = 1;
    }

    //int constructor.
    public Term(int coefficient, int exponent)
    {
        this.coefficient = coefficient;
        this.exponent = exponent;

    }

    //String constructor.
    public Term(String term)
    {


    }


    public int getExponent()
    {
        return exponent;
    }

    public void setExponent(int exponent)
    {
        this.exponent = exponent;
    }


    public void setCoefficient(int coefficient)
    {
        this.coefficient = coefficient;
    }

    public int getCoefficient()
    {
        return coefficient;
    }

    public void setAll(int coefficient, int exponent)
    {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public Term(Term anotherTerm)
    {
        this.exponent = anotherTerm.getExponent();
        this.coefficient = anotherTerm.getCoefficient();
    }

    @Override
    public String toString()
    {
        String message = "Exponent:"+ exponent + " Coefficient:" + coefficient;
        return message;
    }
}
/**
 * Term.java : This class is responsible for storing terms of a polynomial.
 * The terms are split into operand, coefficient, and exponent
 *
 * @author  arthurutnehmer <arthurutnehmer@gmail.com>
 * @version 1.0
 */

package edu.miracosta.cs113;
import java.util.StringTokenizer;

public class Term implements Cloneable
{
    private int exponent;
    private int coefficient;
    private String variableCharacter;

    //default empty constructor.
    public Term()
    {
        this.coefficient = 1;
        this.exponent = 1;
        this.variableCharacter = "";
    }

    //int constructor.
    public Term(int coefficient, int exponent)
    {
        this.coefficient = coefficient;
        this.exponent = exponent;

    }

    public Term(int coefficient, int exponent, String variableCharacter)
    {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.variableCharacter = variableCharacter;

    }

    //String constructor.
    public Term(String term)
    {
        //default parameters.
        exponent = 0;
        coefficient = 0;
        variableCharacter = "";
        //Tokenizer that will separate the coefficient and exponent.
        StringTokenizer tok = new StringTokenizer(term , "^//x");

        //Do while their are still numbers. *will remove all numbers from the string and seperate them into
        //exponents and coefficients.
        boolean coefficientFound = false;
        while (tok.hasMoreTokens())
        {

            if(!coefficientFound && tok.hasMoreTokens()  )
            {
                coefficient = Integer.parseInt(tok.nextToken());
                coefficientFound = true;
            }

            else if(coefficientFound && tok.hasMoreTokens() )
            {
                exponent = Integer.parseInt( tok.nextToken());
            }
        }

        //Determine if the number has an x.
        for(int i = 0; i < term.length(); i++)
        {
            if( Character.toString( term.charAt(i) ).equals("x"))
            {
                variableCharacter = "x";
            }

        }

        if (variableCharacter.equals("x") && coefficient==0  && exponent == 0)
        {
            coefficient = 1;
            exponent = 1;
        }

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

    public String getVariableCharacter()
    {
        return variableCharacter;
    }

    public void setVariableCharacter(String variableCharacter)
    {
        this.variableCharacter = variableCharacter;
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
        this.variableCharacter = anotherTerm.getVariableCharacter();
    }
    //clones the object.
    public Term clone()
    {
        try
        {
            Term clonedTerm = (Term) super.clone();
            return clonedTerm;
        }
        catch (CloneNotSupportedException e)
        {
            return null;
        }
    }

    //Standard compare to method/compares the terms
    public int compareTo(Object T)
    {
        Term anotherTerm = (Term) T;
        if (this.exponent > anotherTerm.getExponent())
        {
            return 1;
        }
        else if (this.exponent < anotherTerm.getExponent())
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }

    //checks to see if coefficients and exponents are equal.
    public boolean equals(Object other)
    {
        if (other == null || other.getClass() != this.getClass())
        {
            return false;
        }
        else
        {
            Term otherTerm = (Term) other;
            return this.coefficient == otherTerm.getCoefficient()
                    && this.exponent == otherTerm.getExponent();
        }
    }

    @Override
    public String toString()
    {
        String message = "";
        if( coefficient > 1)
        {
            if(exponent > 0)
            {
                if(exponent == 1)
                {
                    message = "+" + coefficient + "x";
                }
                else if(exponent > 1)
                {
                    message = "+" + coefficient + "x"+ "^" + exponent;
                }
            }
            else if(exponent == 0)
            {
                message = "+" + coefficient + "";
            }

            else if (exponent < 0)
            {
                    message = "+" + coefficient + "x"+ "^ " + exponent;
            }

        }

        else if(coefficient == 1)
        {
            if(exponent != 0)
            {
                if(exponent == 1)
                {
                    message = "+x";
                }
                else
                {
                    message = "+" + "x^" + exponent;
                }
            }
            else if(exponent == 0)
            {
                message = "+" + coefficient + "";
            }
        }

        else if(coefficient == -1)
        {
            if(exponent != 0)
            {
                if(exponent == 1)
                {
                    message = "-x";
                }
                else
                {
                    message = "-" + "x^" + exponent;
                }
            }
            else if(exponent == 0)
            {
                message = "+" + coefficient + "";
            }
        }
        else if(coefficient < -1)
        {
            if(exponent != 0)
            {
                if(exponent == 1)
                {
                    message =  coefficient + "x";
                }
                else
                {
                    message = "" + coefficient + "x^" + exponent;
                }
            }
            else if(exponent == 0)
            {
                message = "" + coefficient + "";
            }
        }
        else if(coefficient == 0)
        {
            message = "";
        }


        return message;
    }
}
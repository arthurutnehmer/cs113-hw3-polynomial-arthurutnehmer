package edu.miracosta.cs113;
import java.util.StringTokenizer;

public class Driver
{
    private Polynomial polynomial1;
    private Polynomial polynomial2;
    private Polynomial polynomial1User;
    private Polynomial polynomial2User;

    public Driver()
    {

    }

    public void createPolynomial1()
    {
        polynomial1 = new Polynomial();
    }

    public void createPolynomial2()
    {
        polynomial2 = new Polynomial();
    }

    public void addOneTermToPolynomial1(String term)
    {
        Term TmpTerm = new Term(term);
        polynomial1.addTerm(TmpTerm);
    }

    public void addOneTermToPolynomial2(String term)
    {
        Term TmpTerm = new Term(term);
        polynomial2.addTerm(TmpTerm);
    }

    public void showPolynomial1()
    {
        if(polynomial1 != null)
        {
            System.out.println(polynomial1);
        }
    }

    public void showPolynomial2()
    {
        if(polynomial2 != null)
        {
            System.out.println(polynomial2);
        }
    }

    public void addPolynomialsTogether()
    {
        Polynomial tmpPolynomial = new Polynomial(polynomial1);
        tmpPolynomial.add(polynomial2);
        System.out.println("***********************Added Polynomials***************************");
        System.out.println("Polynomial 1: " + polynomial1User);
        System.out.println("Polynomial 2: " + polynomial2User);
        System.out.println("       Equal: " + tmpPolynomial.toString());
        System.out.println("***********************Added Polynomials***************************");
    }

    public void clearPolynomial1()
    {
        polynomial1.clear();
        polynomial1User.clear();
    }

    public void clearPolynomial2()
    {
        polynomial2.clear();
        polynomial2User.clear();
    }

    public void enterPolynomial1AllAtOnce(String polynomialToDecode)
    {
        //feeds to computer.
        StringTokenizer tok = new StringTokenizer(polynomialToDecode , " ");
        while(tok.hasMoreTokens())
        {
            polynomial1.addTerm(new Term(tok.nextToken()));
        }

        polynomial1User = new Polynomial();
        tok = new StringTokenizer(polynomialToDecode , " ");
        while(tok.hasMoreTokens())
        {
            polynomial1User.addTermFromUser(new Term(tok.nextToken()));
        }

    }

    public void enterPolynomial2AllAtOnce(String polynomialToDecode)
    {
        StringTokenizer tok = new StringTokenizer(polynomialToDecode , " ");
        while(tok.hasMoreTokens())
        {
            polynomial2.addTerm(new Term(tok.nextToken()));
        }
        polynomial2User = new Polynomial();
        tok = new StringTokenizer(polynomialToDecode , " ");
        while(tok.hasMoreTokens())
        {
            polynomial2User.addTermFromUser(new Term(tok.nextToken()));
        }

    }

    public void printPolynomial1User()
    {
        if(polynomial1User != null)
        {
            System.out.println("---------------Polynomial 1-------------");
            System.out.println("----------------------------------------");
            System.out.println(polynomial1User);
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
        }
    }

    public void printPolynomial2User()
    {
        if(polynomial2User != null)
        {
            System.out.println("---------------Polynomial 2-------------");
            System.out.println("----------------------------------------");
            System.out.println(polynomial2User);
            System.out.println("---------------Polynomial 2-------------");
            System.out.println("----------------------------------------");
        }
    }

    public void addToPolynomial1(String polynomialToDecode)
    {
        StringTokenizer tok = new StringTokenizer(polynomialToDecode , " ");
        while(tok.hasMoreTokens())
        {
            polynomial1.addTerm(new Term(tok.nextToken()));
        }
        tok = new StringTokenizer(polynomialToDecode , " ");
        while(tok.hasMoreTokens())
        {
            polynomial1User.addTermFromUser(new Term(tok.nextToken()));
        }
    }

    public void addToPolynomial2(String polynomialToDecode)
    {
        StringTokenizer tok = new StringTokenizer(polynomialToDecode , " ");
        while(tok.hasMoreTokens())
        {
            polynomial2.addTerm(new Term(tok.nextToken()));
        }
        tok = new StringTokenizer(polynomialToDecode , " ");
        while(tok.hasMoreTokens())
        {
            polynomial2User.addTermFromUser(new Term(tok.nextToken()));
        }
    }
}

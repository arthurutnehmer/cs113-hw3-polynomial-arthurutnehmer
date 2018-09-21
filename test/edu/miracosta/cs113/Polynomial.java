package edu.miracosta.cs113;

import java.util.LinkedList;
import java.util.Iterator;

public class Polynomial
{
    private LinkedList<Term> terms;

    Polynomial()
    {
        terms = new LinkedList<Term>();
    }

    public Polynomial(Polynomial polynomial)
    {
        this.terms = new LinkedList();

        if (polynomial != null)
        {
            for (int i = 0; i < polynomial.getNumTerms(); i++)
            {
                terms.add(new Term(polynomial.getTerm(i)));
            }
        }
    }

    public int getNumTerms()
    {
        return terms.size();
    }

    public void addTerm(Term term)
    {
        terms.add(term);
    }

    public Term getTerm(int index)
    {
        return terms.get(index);
    }

    public void clear()
    {
        terms = new LinkedList<Term>();
    }

    //Traverses the polynomial until both are empty.
    public void add(Polynomial anotherPolynomial)
    {

        //I is related to numer of terms in this polynomial.
        for(int i = 0; i< terms.size(); i++)
        {
            //Iterator resets after list is traversed.
            Iterator pointerForOtherPolynomial = anotherPolynomial.getList().iterator();

            while (pointerForOtherPolynomial.hasNext())
            {
                //store next term as term.
                Term tmpTerm = new Term((Term)pointerForOtherPolynomial.next());
                if( tmpTerm.getExponent() == terms.get(i).getExponent())
                {
                    int firstCoefficient = tmpTerm.getCoefficient();
                    int firstExponent = tmpTerm.getExponent();

                    int secondExponent = terms.get(i).getExponent();

                    int combinedCoefficient = firstCoefficient;
                    int combinedExponent = firstExponent + secondExponent;

                    terms.set(i,new Term(combinedCoefficient, combinedExponent));
                    pointerForOtherPolynomial.remove();
                }

            }

        }

    }

    public LinkedList<Term> getList()
    {
        return terms;
    }
}

package edu.miracosta.cs113;
import java.util.Collections;
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
        Collections.sort(terms, Collections.reverseOrder());
    }

    public Polynomial(Term term)
    {
        this.terms = new LinkedList();
        terms.add(term);
    }

    public int getNumTerms()
    {
        return terms.size();
    }

    //Will add terms from largest to smallest.
    public void addTerm(Term term)
    {
        Polynomial tmpPoly = new Polynomial(term);
        this.add(tmpPoly);
    }

    //Will add terms from largest to smallest.
    public void addTermFromUser(Term term)
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
        //Polynomials that are to be added
        Polynomial PolynomialsLeftOver = new Polynomial(anotherPolynomial);

        //outer loop will loop until all of the terms in list 1 and compared against all of the terms in list 2.
        for(int i = 0; i< terms.size(); i++)
        {
            //Iterator resets after list is traversed.
            Iterator pointerForOtherPolynomial = anotherPolynomial.getList().iterator();

            //While that loops until term with index i in list 1 has been compared to all of the terms in list 2.
            while (pointerForOtherPolynomial.hasNext())
            {
                //store next term as term.
                Term tmpTerm = new Term((Term)pointerForOtherPolynomial.next());
                //if exponents are equal.
                if( tmpTerm.getExponent() == terms.get(i).getExponent())
                {
                    int firstCoefficient = tmpTerm.getCoefficient();
                    int firstExponent = tmpTerm.getExponent();

                    int secondCoefficient = terms.get(i).getCoefficient();

                    int combinedCoefficient = firstCoefficient + secondCoefficient;
                    int combinedExponent = firstExponent;
                    //if the terms dont cancel
                    if(combinedCoefficient != 0)
                    {
                        terms.set(i, new Term(combinedCoefficient, combinedExponent));
                        PolynomialsLeftOver.getList().remove(tmpTerm);
                    }
                    //If the terms do cancel out.
                    else if(combinedCoefficient == 0)
                    {
                        terms.remove(i);
                        PolynomialsLeftOver.getList().remove(tmpTerm);
                        i = i-1;
                    }
                }

            }

        }

        terms.addAll(PolynomialsLeftOver.getList());

        Collections.sort(terms, Collections.reverseOrder());

    }

    public LinkedList<Term> getList()
    {
        return terms;
    }

    @Override
    public String toString()
    {
        String message;

        if (this.terms == null || this.terms.size() == 0)
        {
            message = "0";
        }
        else
        {
            message = "";

            for (Term term : terms)
            {
                message += term.toString() + " ";
            }
            if (message.substring(0,1).equals("+"))
            {
                message = message.substring(1);
            }
        }
        return message;
    }
}

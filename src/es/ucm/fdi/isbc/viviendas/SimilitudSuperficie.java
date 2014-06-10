package es.ucm.fdi.isbc.viviendas;

import jcolibri.method.retrieve.NNretrieval.similarity.LocalSimilarityFunction;

public class SimilitudSuperficie implements LocalSimilarityFunction {

	/** Interval */
	double _interval;

	/**
	 * Constructor.
	 */
	public SimilitudSuperficie(double interval) {
		_interval = interval;
	}

	/**
	 * Applies the similarity function.
	 * 
	 * @param o1
	 *            Number
	 * @param o2
	 *            Number
	 * @return result of apply the similarity function.
	 */
	public double compute(Object o1, Object o2) throws jcolibri.exception.NoApplicableSimilarityFunctionException{
		if ((o1 == null) || (o2 == null))
			return 0;
		if (!(o1 instanceof java.lang.Number))
			throw new jcolibri.exception.NoApplicableSimilarityFunctionException(this.getClass(), o1.getClass());
		if (!(o2 instanceof java.lang.Number))
			throw new jcolibri.exception.NoApplicableSimilarityFunctionException(this.getClass(), o2.getClass());


		Number i1 = (Number) o1;
		Number i2 = (Number) o2;
		
		double v1 = i1.doubleValue();
		double v2 = i2.doubleValue();
		
		
		System.out.print("valor 1:  "+v1);
		System.out.print("   valor 2:  "+v2);
		double similitud = 0;
		
		if(v2>v1) similitud = 0;
		else similitud =  1 - ((double) Math.abs(v1 - v2) / _interval);
		
		System.out.println("   similitud:  "+ similitud);
		System.out.println(" ");
		return similitud;
	}
	
	/** Applicable to Integer */
	public boolean isApplicable(Object o1, Object o2)
	{
		if((o1==null)&&(o2==null))
			return true;
		else if(o1==null)
			return o2 instanceof Number;
		else if(o2==null)
			return o1 instanceof Number;
		else
			return (o1 instanceof Number)&&(o2 instanceof Number);
	}

}

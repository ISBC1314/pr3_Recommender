package es.ucm.fdi.isbc.viviendas;

import jcolibri.method.retrieve.NNretrieval.similarity.LocalSimilarityFunction;
import es.ucm.fdi.isbc.viviendas.representacion.ExtrasBasicos;

public class SimilitudExtrasBasicos implements LocalSimilarityFunction {



	public SimilitudExtrasBasicos() {
		
	}


	public double compute(Object o1, Object o2) throws jcolibri.exception.NoApplicableSimilarityFunctionException{
		if ((o1 == null) || (o2 == null))
			return 0;
		if (!(o1 instanceof ExtrasBasicos))
			throw new jcolibri.exception.NoApplicableSimilarityFunctionException(this.getClass(), o1.getClass());
		if (!(o2 instanceof ExtrasBasicos))
			throw new jcolibri.exception.NoApplicableSimilarityFunctionException(this.getClass(), o2.getClass());

		ExtrasBasicos e1 = (ExtrasBasicos) o1;
		ExtrasBasicos e2 = (ExtrasBasicos) o2;

		double similitud = e2.isAmueblado() == e1.isAmueblado() ? 0.3 : 0;
		similitud += e2.isAireAcondicionado() == e1.isAireAcondicionado() ? 0.3 : 0;
		similitud += e2.isCalefaccion() == e1.isCalefaccion() ? 0.4 : 0;

		return similitud;
		
	}
	
	public boolean isApplicable(Object o1, Object o2)
	{
		if((o1==null)&&(o2==null))
			return true;
		else if(o1==null)
			return o2 instanceof ExtrasBasicos;
		else if(o2==null)
			return o1 instanceof ExtrasBasicos;
		else
			return (o1 instanceof ExtrasBasicos)&&(o2 instanceof ExtrasBasicos);
	}

}


package es.ucm.fdi.isbc.viviendas;

import es.ucm.fdi.isbc.viviendas.representacion.ExtrasOtros;
import jcolibri.method.retrieve.NNretrieval.similarity.LocalSimilarityFunction;

public class SimilitudExtrasOtros implements LocalSimilarityFunction {



	public SimilitudExtrasOtros() {
		
	}


	public double compute(Object o1, Object o2) throws jcolibri.exception.NoApplicableSimilarityFunctionException{
		if ((o1 == null) || (o2 == null))
			return 0;
		if (!(o1 instanceof ExtrasOtros))
			throw new jcolibri.exception.NoApplicableSimilarityFunctionException(this.getClass(), o1.getClass());
		if (!(o2 instanceof ExtrasOtros))
			throw new jcolibri.exception.NoApplicableSimilarityFunctionException(this.getClass(), o2.getClass());

		ExtrasOtros e1 = (ExtrasOtros) o1;
		ExtrasOtros e2 = (ExtrasOtros) o2;

		double similitud = e2.isPiscina() == e1.isPiscina() || e2.isPiscinaComunitaria() == e1.isPiscinaComunitaria() ? 0.5 : 0;
		similitud += e2.isTerraza() == e1.isTerraza() ? 0.5 : 0;

		return similitud;
		
	}
	
	public boolean isApplicable(Object o1, Object o2)
	{
		if((o1==null)&&(o2==null))
			return true;
		else if(o1==null)
			return o2 instanceof ExtrasOtros;
		else if(o2==null)
			return o1 instanceof ExtrasOtros;
		else
			return (o1 instanceof ExtrasOtros)&&(o2 instanceof ExtrasOtros);
	}

}

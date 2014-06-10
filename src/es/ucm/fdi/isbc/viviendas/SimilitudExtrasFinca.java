package es.ucm.fdi.isbc.viviendas;

import jcolibri.method.retrieve.NNretrieval.similarity.LocalSimilarityFunction;
import es.ucm.fdi.isbc.viviendas.representacion.ExtrasFinca;

public class SimilitudExtrasFinca implements LocalSimilarityFunction {



	public SimilitudExtrasFinca() {
		
	}


	public double compute(Object o1, Object o2) throws jcolibri.exception.NoApplicableSimilarityFunctionException{
		if ((o1 == null) || (o2 == null))
			return 0;
		if (!(o1 instanceof ExtrasFinca))
			throw new jcolibri.exception.NoApplicableSimilarityFunctionException(this.getClass(), o1.getClass());
		if (!(o2 instanceof ExtrasFinca))
			throw new jcolibri.exception.NoApplicableSimilarityFunctionException(this.getClass(), o2.getClass());

		ExtrasFinca e1 = (ExtrasFinca) o1;
		ExtrasFinca e2 = (ExtrasFinca) o2;

		double similitud = e2.isGarajePrivado() == e1.isGarajePrivado() || e2.isParkingComunitario() == e1.isParkingComunitario() ? 0.5 : 0;
		similitud += e2.isAscensor() == e1.isAscensor() ? 0.5 : 0;		

		return similitud;
		
	}
	
	public boolean isApplicable(Object o1, Object o2)
	{
		if((o1==null)&&(o2==null))
			return true;
		else if(o1==null)
			return o2 instanceof ExtrasFinca;
		else if(o2==null)
			return o1 instanceof ExtrasFinca;
		else
			return (o1 instanceof ExtrasFinca)&&(o2 instanceof ExtrasFinca);
	}

}

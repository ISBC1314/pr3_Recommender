package es.ucm.fdi.isbc.viviendas;

import es.ucm.fdi.isbc.viviendas.representacion.Coordenada;
import jcolibri.exception.NoApplicableSimilarityFunctionException;
import jcolibri.method.retrieve.NNretrieval.similarity.LocalSimilarityFunction;

public class SimilitudCoordenadas implements LocalSimilarityFunction {
	
	//Radio en el que buscamos la similitud en km
	double _interval;
	
	public SimilitudCoordenadas(double interval) {
		_interval = interval;
	}
	
	@Override
	public double compute(Object o1, Object o2) throws NoApplicableSimilarityFunctionException {
		if ((o1 == null) || (o2 == null))
			return 0;
		if (!(o1 instanceof Coordenada))
			throw new jcolibri.exception.NoApplicableSimilarityFunctionException(this.getClass(), o1.getClass());
		if (!(o2 instanceof Coordenada))
			throw new jcolibri.exception.NoApplicableSimilarityFunctionException(this.getClass(), o2.getClass());


		Coordenada c1 = (Coordenada) o1;
		Coordenada c2 = (Coordenada) o2;

		double distancia = distanciaEntreCoordenadas(c1, c2);
		
		if (distancia > _interval) return  0;
		else return( 1- distancia /_interval);
	}

	@Override
	public boolean isApplicable(Object o1, Object o2) {
		if((o1==null)&&(o2==null))
			return true;
		else if(o1==null)
			return o2 instanceof Coordenada;
		else if(o2==null)
			return o1 instanceof Coordenada;
		else
			return (o1 instanceof Coordenada)&&(o2 instanceof Coordenada);
	}
	
	private double pasarARadianes(double c){	
		return  c *Math.PI / 180;
	}
	
	private double distanciaEntreCoordenadas(Coordenada c1, Coordenada c2) {
		//http://www.ehowenespanol.com/calcular-distancia-puntos-latitud-longitud-como_452715/
		//Pasamos las coordenadas a radianes
		Coordenada r1 = new Coordenada(pasarARadianes(c1.getLatitud()) , pasarARadianes(c1.getLongitud()));
		Coordenada r2 = new Coordenada(pasarARadianes(c2.getLatitud()) , pasarARadianes(c2.getLongitud()));
		
		//Calculamos la distancia matemática entre los números
		double deltaLat = Math.abs(r1.getLatitud())-Math.abs(r2.getLatitud());
		double deltaLong = Math.abs(Math.abs(r1.getLongitud()-r2.getLongitud()));
		
		//Formulas 
		double senLat = Math.sin(deltaLat/2);
		double senLong = Math.sin(deltaLong/2);
		double aux1 = Math.pow(senLat,2) + Math.cos(r1.getLatitud());
		double aux2 = aux1 * Math.cos(r2.getLatitud()) * Math.pow(senLong, 2); 
		double aux3 = 2 * Math.atan2(Math.sqrt(aux2), Math.sqrt(1- aux2));
		
		return 6371 * aux3; //en kilometros;
	}

}

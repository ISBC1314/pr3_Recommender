package es.ucm.fdi.isbc.viviendas;

import java.util.ArrayList;
import java.util.Collection;

import es.ucm.fdi.isbc.viviendas.representacion.DescripcionVivienda;
import jcolibri.casebase.LinealCaseBase;
import jcolibri.cbraplications.StandardCBRApplication;
import jcolibri.cbrcore.Attribute;
import jcolibri.cbrcore.CBRCase;
import jcolibri.cbrcore.CBRCaseBase;
import jcolibri.cbrcore.CBRQuery;
import jcolibri.cbrcore.Connector;
import jcolibri.exception.ExecutionException;
import jcolibri.extensions.recommendation.casesDisplay.DisplayCasesTableMethod;
import jcolibri.method.retrieve.RetrievalResult;
import jcolibri.method.retrieve.NNretrieval.NNConfig;
import jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import jcolibri.method.retrieve.NNretrieval.similarity.local.Equal;
import jcolibri.method.retrieve.NNretrieval.similarity.local.Interval;
import jcolibri.method.retrieve.selection.SelectCases;


public class ViviendasRecomendador implements StandardCBRApplication {
	
	/** Connector object */
	Connector _connector;
	
	/** CaseBase object */
	CBRCaseBase _caseBase;

	@Override
	public void configure() throws ExecutionException {
		try{
			// Create a data base connector
			_connector = new ViviendasConnector();
				
			// Create a Lineal case base for in-memory organization
			_caseBase  = new LinealCaseBase();
		}
		catch (Exception e){
			throw new ExecutionException(e);
		}
		
	}

	@Override
	public CBRCaseBase preCycle() throws ExecutionException {
		// Load cases from connector into the case base
		_caseBase.init(_connector);		
		_caseBase.learnCases(_connector.retrieveAllCases());
		return _caseBase;
	}

	@Override
	public void cycle(CBRQuery query) throws ExecutionException {
		//Para configurar el KNN se utiliza un objeto NNConfig
		NNConfig simConfig = new NNConfig();
		//Fijamos la funcion de similitud global
		simConfig.setDescriptionSimFunction(new Average());
		
		//Fijamos las funciones de similitud locales
		//simConfig.addMapping(new Attribute("Localizacion",  DescripcionViviendaAux.class), new Equal());
		simConfig.addMapping(new Attribute("tipo",  DescripcionVivienda.class), new Equal());
		simConfig.addMapping(new Attribute("superficie",  DescripcionVivienda.class), new Interval(50));
		simConfig.addMapping(new Attribute("habitaciones",  DescripcionVivienda.class), new Interval(2));
		simConfig.addMapping(new Attribute("banios", DescripcionVivienda.class), new Interval(2));
		
		//Es posible modificar el peso de cada atributo en la media ponderada
		//Por defecto el peso es 1
		//simConfig.setWeight(new Attribute("Localizacion", TravelDescription.class), 0.5);
		
		//Ejecutamos la recuperacio por el vecino mas proximo
		Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(_caseBase.getCases(),  query, simConfig);
		
		//Seleccionamos los k mejores casos
		eval = SelectCases.selectTopKRR(eval, 5);
		
		//Imprimimos el resultado del k-NN y obtenemos la lista de casos recuperados
		Collection<CBRCase> casos = new ArrayList<CBRCase>();
		System.out.println("Casos recuperados:");
		for(RetrievalResult nse: eval){
			System.out.println(nse);
			casos.add(nse.get_case());
		}
		
		//Aqui se incluiria el codigo para adaptar la solucion
		
		//Solamente mostramos el resultado
		DisplayCasesTableMethod.displayCasesInTableBasic(casos);
		
	}

	@Override
	public void postCycle() throws ExecutionException {
		this._caseBase.close();
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("Ini recomendador");
		
		//Crear el objeto que implementa la aplicacion CBR
		ViviendasRecomendador trApp = new ViviendasRecomendador();
		
		try
		{
			//Configuracion
			trApp.configure();
			//Preciclo
			trApp.preCycle();
			
			//Crear Descripcion vivienda
			DescripcionVivienda des = new DescripcionVivienda(1);
			des.setBanios(2);
			des.setHabitaciones(3);
			
			//Crear objeto que almacena la consulta
			CBRQuery query = new CBRQuery();
			query.setDescription(des);
			
			//Ejecutar el ciclo
			trApp.cycle(query);
			

		} catch (Exception e)
		{
			org.apache.commons.logging.LogFactory.getLog(ViviendasRecomendador.class).error(e);
		}
		
		System.out.println("Fin recomendador");
		
	}


}
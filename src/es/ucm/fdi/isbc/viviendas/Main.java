package es.ucm.fdi.isbc.viviendas;

import gui.VistaPrincipal;

public class Main {
	
	public static void main (String[] args)
	{

		//Crear el objeto que implementa la aplicacion CBR
		ViviendasRecomendador viviendasRecomendador = new ViviendasRecomendador();
		
		try
		{
			//Configuracion
			viviendasRecomendador.configure();
			//Preciclo
			viviendasRecomendador.preCycle();
			
		} catch (Exception e)
		{
			e.printStackTrace();
			//org.apache.commons.logging.LogFactory.getLog(ViviendasRecomendador.class).error(e);
		}
		
		
		VistaPrincipal vistaPrincipal = new VistaPrincipal(viviendasRecomendador);
		viviendasRecomendador.setVista(vistaPrincipal);

	}

}

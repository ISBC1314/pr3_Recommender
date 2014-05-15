package es.ucm.fdi.isbc.viviendas;

import gui.VistaPrincipal;

public class Main {
	
	public static void main (String[] args)
	{
		
		
		//Crear el objeto que implementa la aplicacion CBR
		ViviendasRecomendador vr = new ViviendasRecomendador();
		
		try
		{
			//Configuracion
			vr.configure();
			//Preciclo
			vr.preCycle();
			
		} catch (Exception e)
		{
			org.apache.commons.logging.LogFactory.getLog(ViviendasRecomendador.class).error(e);
		}
		
		VistaPrincipal vpa = new VistaPrincipal(vr);

	}

}

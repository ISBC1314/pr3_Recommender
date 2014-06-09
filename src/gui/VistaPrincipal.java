package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import es.ucm.fdi.isbc.viviendas.ViviendasRecomendador;
import es.ucm.fdi.isbc.viviendas.representacion.DescripcionVivienda;
import es.ucm.fdi.isbc.viviendas.representacion.DescripcionVivienda.EstadoVivienda;
import es.ucm.fdi.isbc.viviendas.representacion.DescripcionVivienda.TipoVivienda;

public class VistaPrincipal {
	
	private JFrame frmIsbc;
	
	private ViviendasRecomendador recomendador;
	
	//Datos formulario
	JComboBox<String> JComboBox_superficie;
	JComboBox<String> JComboBox_habitaciones;
	JComboBox<String> JComboBox_banios;
	JComboBox<String> JComboBox_precio;
	JComboBox<String> JComboBox_localizacion;
	JComboBox<String> JComboBox_estado;

	/**
	 * Create the application.
	 */
	public VistaPrincipal(ViviendasRecomendador viviendasRecomendador) {
		recomendador = viviendasRecomendador;
		initialize();
		frmIsbc.setBounds(100, 100, 1093,800);
		frmIsbc.setVisible(true);
		formularioInicial();
		
		
		//String[] ciudades = recomendador.getCiudades().toArray(new String[recomendador.getCiudades().size()]);
		//for(String ciudad : c)
		//	System.out.println(ciudad.toString());
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIsbc = new JFrame();
		
		frmIsbc.getContentPane().setLayout(new MigLayout("", "[50.00,grow][200.00,grow][50.00,grow][700.00,grow][]", "[grow 600]"));
		
		JPanel JPanel_filtros = new JPanel();
		frmIsbc.getContentPane().add(JPanel_filtros, "cell 1 0,grow");
		JPanel_filtros.setLayout(new MigLayout("", "[75.00,grow][25.00,grow][grow]", "[grow]"));
		
		
		
		//Superficie
		JLabel JLabel_superficie = new JLabel("Superficie:");
		JLabel_superficie.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_superficie.setFont(new Font("Tahoma", Font.BOLD, 12));
		JPanel_filtros.add(JLabel_superficie, "cell 0 0");		    
		String[] superficies = {"Desde 50m\u00B2","Desde 100m\u00B2","Desde 150m\u00B2","Desde 200m\u00B2","Desde 250m\u00B2" };
		JComboBox_superficie = new JComboBox<String>(superficies);
		JComboBox_superficie.setSelectedIndex(0);
		JPanel_filtros.add(JComboBox_superficie,"cell 1 0");
		
		//Habitaciones
		JLabel JLabel_habitaciones = new JLabel("Habitaciones:");
		JLabel_habitaciones.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_habitaciones.setFont(new Font("Tahoma", Font.BOLD, 12));
		JPanel_filtros.add(JLabel_habitaciones, "cell 0 1");		    
		String[] habitaciones = {"1","2","3","4","Más de 4" };
		JComboBox_habitaciones = new JComboBox<String>(habitaciones);
		JComboBox_habitaciones.setSelectedIndex(0);
		JPanel_filtros.add(JComboBox_habitaciones,"cell 1 1");
		
		//Baños
		JLabel JLabel_banios = new JLabel("Baños:");
		JLabel_banios.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_banios.setFont(new Font("Tahoma", Font.BOLD, 12));
		JPanel_filtros.add(JLabel_banios, "cell 0 2");		    
		String[] banios = {"1","2","Más de 2" };
		JComboBox_banios = new JComboBox<String>(banios);
		JComboBox_banios.setSelectedIndex(0);
		JPanel_filtros.add(JComboBox_banios,"cell 1 2");
		
		//Precio
		JLabel JLabel_precio = new JLabel("Precio:");
		JLabel_precio.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_precio.setFont(new Font("Tahoma", Font.BOLD, 12));
		JPanel_filtros.add(JLabel_precio, "cell 0 3");
		String[] precios = {"Menos de 250.000\u20AC","Entre 250.000\u20AC y 650.000\u20AC","Entre 650.000\u20AC y 1.000.000\u20AC","Entre 1.000.000\u20AC y 1.500.000\u20AC","M\u00E1s 1.500.000\u20AC"};
		JComboBox_precio = new JComboBox<String>(precios);
		JComboBox_precio.setSelectedIndex(0);
		JPanel_filtros.add(JComboBox_precio,"cell 1 3");
		
		//Localizacion
		JLabel JLabel_localizacion = new JLabel("Localización:");
		JLabel_localizacion.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_localizacion.setFont(new Font("Tahoma", Font.BOLD, 12));
		JPanel_filtros.add(JLabel_localizacion, "cell 0 4");
		JComboBox_localizacion = new JComboBox<String>();
		for (String ciudad : recomendador.getCiudades())
			JComboBox_localizacion.addItem(ciudad);
		JComboBox_localizacion.setSelectedIndex(0);
		JPanel_filtros.add(JComboBox_localizacion,"cell 1 4");
		
		//Estado
		JLabel JLabel_estado = new JLabel("Localización:");
		JLabel_estado.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_estado.setFont(new Font("Tahoma", Font.BOLD, 12));
		JPanel_filtros.add(JLabel_estado, "cell 0 5");
		String[] estados = {"Muy bien", "Reformado", "Casinuevo", "Bien", "Areformar"};
		JComboBox_estado = new JComboBox<String>(estados);
		JComboBox_estado.setSelectedIndex(0);
		JPanel_filtros.add(JComboBox_estado,"cell 1 5");
		
		//Extras
		JPanel JPanel_extras = new JPanel();
		JPanel_filtros.add(JPanel_extras, "cell 0 6 1 6,grow");
		JPanel_extras.setBorder(new TitledBorder(null, "Extras",TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JPanel_extras.setLayout(new MigLayout("", "[75.00,grow][25.00,grow][grow]", "[grow]"));
		//Amueblado
		JLabel JLabel_amueblado = new JLabel("Amueblado:");
		JLabel_amueblado.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_amueblado.setFont(new Font("Tahoma", Font.BOLD, 12));
		JPanel_extras.add(JLabel_amueblado, "cell 0 0");		    
		JCheckBox JCheckBox_amueblado = new JCheckBox();
		JPanel_extras.add(JCheckBox_amueblado,"cell 1 0");
		//Ascensor
		JLabel JLabel_ascensor = new JLabel("Ascensor:");
		JLabel_ascensor.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_ascensor.setFont(new Font("Tahoma", Font.BOLD, 12));
		JPanel_extras.add(JLabel_ascensor, "cell 0 1");		    
		JCheckBox JCheckBox_ascensor = new JCheckBox();
		JPanel_extras.add(JCheckBox_ascensor,"cell 1 1");
		//Garaje
		JLabel JLabel_garaje = new JLabel("Garaje:");
		JLabel_garaje.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_garaje.setFont(new Font("Tahoma", Font.BOLD, 12));
		JPanel_extras.add(JLabel_garaje, "cell 0 2");		    
		JCheckBox JCheckBox_garaje = new JCheckBox();
		JPanel_extras.add(JCheckBox_garaje,"cell 1 2");
		//Calefaccion
		JLabel JLabel_calefaccion = new JLabel("Calefaccion:");
		JLabel_calefaccion.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_calefaccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		JPanel_extras.add(JLabel_calefaccion, "cell 0 3");		    
		JCheckBox JCheckBox_calefaccion = new JCheckBox();
		JPanel_extras.add(JCheckBox_calefaccion,"cell 1 3");
		//Aire acondicionado
		JLabel JLabel_aire = new JLabel("Aire acondicionado:");
		JLabel_aire.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_aire.setFont(new Font("Tahoma", Font.BOLD, 12));
		JPanel_extras.add(JLabel_aire, "cell 0 4");		    
		JCheckBox JCheckBox_aire = new JCheckBox();
		JPanel_extras.add(JCheckBox_aire,"cell 1 4");
		//Terraza
		JLabel JLabel_terraza = new JLabel("Terraza:");
		JLabel_terraza.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_terraza.setFont(new Font("Tahoma", Font.BOLD, 12));
		JPanel_extras.add(JLabel_terraza, "cell 0 5");		    
		JCheckBox JCheckBox_terraza = new JCheckBox();
		JPanel_extras.add(JCheckBox_terraza,"cell 1 5");
		//Piscina
		JLabel JLabel_piscina = new JLabel("Piscina:");
		JLabel_piscina.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_piscina.setFont(new Font("Tahoma", Font.BOLD, 12));
		JPanel_extras.add(JLabel_piscina, "cell 0 6");		    
		JCheckBox JCheckBox_piscina = new JCheckBox();
		JPanel_extras.add(JCheckBox_piscina,"cell 1 6");
		
		//Botón
		JButton JButton_buscar = new JButton("Buscar");
		JPanel_filtros.add(JButton_buscar,"cell 0 6");
		
	
	}
	
	
	public void formularioInicial(){
		String[] precios = {"Menos de 250.000\u20AC","Entre 250.000\u20AC y 650.000\u20AC","Entre 650.000\u20AC y 1.000.000\u20AC","Entre 1.000.000\u20AC y 1.500.000\u20AC","M\u00E1s 1.500.000\u20AC"};
		JComboBox<String> precio = new JComboBox<String>(precios);
		precio.setSelectedIndex(0);
		
		JComboBox<String> localizacion = new JComboBox<String>();
		for (String ciudad: recomendador.getCiudades())
			localizacion.addItem(ciudad);
		localizacion.setSelectedIndex(0);
		
		Object[] options = {
			"Ciudad:", localizacion,
		    "Precio máximo:", precio
		};
		
		int option = JOptionPane.showConfirmDialog(null, options, "Parámetros iniciales", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION){
			String ciudad_vivienda = (String) localizacion.getSelectedItem();
			int precioMax_vivienda = getPrecioFromIndex(precio.getSelectedIndex());
			System.out.println("ciudad="+ciudad_vivienda+"    precio="+precioMax_vivienda);
			
			ejecutaConsultaInicial(ciudad_vivienda,precioMax_vivienda);
		}
		else{
			ejecutaConsultaInicial("",-1);
		}
	}
	
	
	public void ejecutaConsultaInicial(String ciudad, int precio){
		//if (recomendador == null) System.out.println("recomendador null");
		//Valores introducidos en el formulario inicial
		if (!ciudad.equals("") && precio != -1){
			DescripcionVivienda des = new DescripcionVivienda(1);
			des.setPrecio(precio);
			des.setLocalizacion(ciudad);
			recomendador.ejecutarConsulta(des);
		}
		//Valores iniciales vacios
		else{
			
		}
	}
	
	public int getPrecioFromIndex(int index){
		
		int precio = 0;
		
		switch (index) {
        case 0:  precio = 250000;
                 break;
        case 1:  precio = 650000;
                 break;
        case 2:  precio = 1000000;
                 break;
        case 3:  precio = 1500000;
                 break;
        case 4:  precio = 50000000;
        		 break;
        default: precio = 650000;
                 break;
		}
		return precio;
	}
}

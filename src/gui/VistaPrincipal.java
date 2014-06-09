package gui;

import java.awt.Font;

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

public class VistaPrincipal {
	
	private JFrame frmIsbc;
	
	private ViviendasRecomendador recomendador;

	/**
	 * Create the application.
	 */
	public VistaPrincipal(ViviendasRecomendador viviendasRecomendador) {
		initialize();
		frmIsbc.setBounds(100, 100, 1093,800);
		frmIsbc.setVisible(true);
		formularioInicial();
		recomendador = viviendasRecomendador;
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIsbc = new JFrame();
		
		frmIsbc.getContentPane().setLayout(new MigLayout("", "[50.00,grow][200.00,grow][50.00,grow][700.00,grow][]", "[grow 600]"));
		
		JPanel JPanel_filtros = new JPanel();
		frmIsbc.getContentPane().add(JPanel_filtros, "cell 1 0,grow");
		JPanel_filtros.setLayout(new MigLayout("", "[125.00,grow][75.00,grow][grow]", "[15.00,grow][15.00,grow][15.00,grow][15.00,grow][15.00,grow][30.00,grow][15.00,grow][grow]"));
		
		//Superficie
		JLabel JLabel_superficie = new JLabel("Superficie:");
		JLabel_superficie.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_superficie.setFont(new Font("Tahoma", Font.BOLD, 12));
		JPanel_filtros.add(JLabel_superficie, "cell 0 0");		    
		String[] superficies = {"Desde 50m\u00B2","Desde 100m\u00B2","Desde 150m\u00B2","Desde 200m\u00B2","Desde 250m\u00B2" };
		JComboBox JComboBox_superficie = new JComboBox(superficies);
		JPanel_filtros.add(JComboBox_superficie,"cell 1 0");
		
		//Habitaciones
		JLabel JLabel_habitaciones = new JLabel("Habitaciones:");
		JLabel_habitaciones.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_habitaciones.setFont(new Font("Tahoma", Font.BOLD, 12));
		JPanel_filtros.add(JLabel_habitaciones, "cell 0 1");		    
		String[] habitaciones = {"1","2","3","4","Más de 4" };
		JComboBox JComboBox_habitaciones = new JComboBox(habitaciones);
		JPanel_filtros.add(JComboBox_habitaciones,"cell 1 1");
		
		//Baños
		JLabel JLabel_banios = new JLabel("Baños:");
		JLabel_banios.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_banios.setFont(new Font("Tahoma", Font.BOLD, 12));
		JPanel_filtros.add(JLabel_banios, "cell 0 2");		    
		String[] banios = {"1","2","Más de 2" };
		JComboBox JComboBox_banios = new JComboBox(banios);
		JPanel_filtros.add(JComboBox_banios,"cell 1 2");
		
		//Precio
		JLabel JLabel_precio = new JLabel("Precio:");
		JLabel_precio.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_precio.setFont(new Font("Tahoma", Font.BOLD, 12));
		JPanel_filtros.add(JLabel_precio, "cell 0 3");		    
		String[] precios = {"Menos de 250.000\u20AC","Entre 250.000\u20AC y 650.000\u20AC","Entre 650.000\u20AC y 1.000.000\u20AC","Entre 1.000.000\u20AC y 1.500.000\u20AC","M\u00E1s 1.500.000\u20AC"};
		JComboBox JComboBox_precio = new JComboBox(precios);
		JPanel_filtros.add(JComboBox_precio,"cell 1 3");
		
		//Localizacion
		JLabel JLabel_localizacion = new JLabel("Localización:");
		JLabel_localizacion.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_localizacion.setFont(new Font("Tahoma", Font.BOLD, 12));
		JPanel_filtros.add(JLabel_localizacion, "cell 0 4");		    
		String[] localizaciones = {"Ciudad1","Ciudad2","Ciudad3","Ciudad4","Ciudad5" };
		JComboBox JComboBox_localizacion = new JComboBox(localizaciones);
		JPanel_filtros.add(JComboBox_localizacion,"cell 1 4");
		
		//Extras
		JPanel JPanel_extras = new JPanel();
		JPanel_filtros.add(JPanel_extras, "cell 0 5 1 5,grow");
		JPanel_extras.setBorder(new TitledBorder(null, "Extras",TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JPanel_extras.setLayout(new MigLayout("", "[125.00,grow][75.00,grow][grow]", "[10.00,grow][10.00,grow][10.00,grow][grow]"));
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
		
		//Botón
		JButton JButton_buscar = new JButton("Buscar");
		JPanel_filtros.add(JButton_buscar,"cell 0 8");
		
	
	}
	
	
	public void formularioInicial(){
		String[] precios = {"Menos de 250.000\u20AC",
				"Entre 250.000\u20AC y 650.000\u20AC",
				"Entre 650.000\u20AC y 1.000.000\u20AC",
				"Entre 1.000.000\u20AC y 1.500.000\u20AC",
				"M\u00E1s 1.500.000\u20AC"};
		String[] ciudades = {};
		JComboBox ciudad = new JComboBox(ciudades);
		JComboBox precioMax = new JComboBox(precios);
		Object[] options = {
			"Ciudad:", ciudad,
		    "Precio máximo:", precioMax
		};
		int option = JOptionPane.showConfirmDialog(null, options, "Parámetros iniciales", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION){
			String ciudad_vivienda = ciudad.getName();
			int precioMax_vivienda = precioMax.getComponentCount();
			ejecutaConsultaInicial(ciudad_vivienda,precioMax_vivienda);
		}
	}
	
	public void ejecutaConsultaInicial(String ciudad, int precio){
		
	}
}

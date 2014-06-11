package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import jcolibri.cbrcore.CBRCase;
import net.miginfocom.swing.MigLayout;
import es.ucm.fdi.isbc.viviendas.ViviendasRecomendador;
import es.ucm.fdi.isbc.viviendas.representacion.DescripcionVivienda;
import es.ucm.fdi.isbc.viviendas.representacion.ExtrasBasicos;
import es.ucm.fdi.isbc.viviendas.representacion.ExtrasFinca;
import es.ucm.fdi.isbc.viviendas.representacion.ExtrasOtros;

public class VistaPrincipal {
	
	private JFrame frmIsbc;
	private JScrollPane JScrollPane_listaViviendas;
	
	private ViviendasRecomendador recomendador;
	

	
	//Paneles
	private JList<DescripcionVivienda> JList_viviendas;
	private JPanel JPanel_1;
	private JPanel JPanel_filtros;
	private JPanel JPanel_vistaVivienda;
	
	//Datos formulario
	private JComboBox<String> JComboBox_superficie;
	private JComboBox<String> JComboBox_habitaciones;
	private JComboBox<String> JComboBox_banios;
	private JComboBox<String> JComboBox_precio;
	private JComboBox<String> JComboBox_localizacion;
	//private JComboBox<String> JComboBox_estado;
	private JButton JButton_buscar;
	private JButton JButton_filtrar;
	private JCheckBox JCheckBox_piscina;
	private JCheckBox JCheckBox_terraza;
	private JCheckBox JCheckBox_aire;
	private JCheckBox JCheckBox_calefaccion;
	private JCheckBox JCheckBox_garaje;
	private JCheckBox JCheckBox_ascensor;
	private JCheckBox JCheckBox_amueblado;

	/**
	 * Create the application.
	 */
	public VistaPrincipal(ViviendasRecomendador viviendasRecomendador) {
		recomendador = viviendasRecomendador;
		initialize();
		frmIsbc.setVisible(true);
		formularioInicial();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIsbc = new JFrame();
		frmIsbc.setBounds(50,50,900,500);
		
		JPanel_1 = new JPanel();
		JPanel_1.setLayout(new MigLayout("", "[10.00,grow][300.00,grow][10.00,grow][600.00,grow][]", "[grow 500]"));
		frmIsbc.getContentPane().add(JPanel_1);	
		
		
		/*********** FORMULARIO DE BUSQUEDA **********/
		
		JPanel_filtros = new JPanel();
		JPanel_filtros.setBackground(Color.gray);
		JPanel_1.add(JPanel_filtros,"cell 1 0,grow");
		JPanel_filtros.setLayout(new MigLayout("", "[150]23[127]", "[][][][][]30[]30[]"));
		
		//Superficie
		JLabel JLabel_superficie = new JLabel("Superficie:");
		JLabel_superficie.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_superficie.setFont(new Font("Tahoma", Font.BOLD, 12));
		JLabel_superficie.setForeground(new Color(224,238,238));
		JPanel_filtros.add(JLabel_superficie, "cell 0 0");		    
		String[] superficies = {"Indiferente","Desde 50m\u00B2","Desde 100m\u00B2","Desde 150m\u00B2","Desde 200m\u00B2","Desde 250m\u00B2" };
		JComboBox_superficie = new JComboBox<String>(superficies);
		JComboBox_superficie.setSelectedIndex(0);
		JPanel_filtros.add(JComboBox_superficie,"cell 1 0");
		//Habitaciones
		JLabel JLabel_habitaciones = new JLabel("Habitaciones:");
		JLabel_habitaciones.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_habitaciones.setFont(new Font("Tahoma", Font.BOLD, 12));
		JLabel_habitaciones.setForeground(new Color(224,238,238));
		JPanel_filtros.add(JLabel_habitaciones, "cell 0 1");		    
		String[] habitaciones = {"Indiferente","1","2","3","4","Más de 4" };
		JComboBox_habitaciones = new JComboBox<String>(habitaciones);
		JComboBox_habitaciones.setSelectedIndex(0);
		JPanel_filtros.add(JComboBox_habitaciones,"cell 1 1");
		//Baños
		JLabel JLabel_banios = new JLabel("Baños:");
		JLabel_banios.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_banios.setFont(new Font("Tahoma", Font.BOLD, 12));
		JLabel_banios.setForeground(new Color(224,238,238));
		JPanel_filtros.add(JLabel_banios, "cell 0 2");		    
		String[] banios = {"Indiferente","1","2","Más de 2" };
		JComboBox_banios = new JComboBox<String>(banios);
		JComboBox_banios.setSelectedIndex(0);
		JPanel_filtros.add(JComboBox_banios,"cell 1 2");
		//Precio
		JLabel JLabel_precio = new JLabel("Precio:");
		JLabel_precio.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_precio.setFont(new Font("Tahoma", Font.BOLD, 12));
		JLabel_precio.setForeground(new Color(224,238,238));
		JPanel_filtros.add(JLabel_precio, "cell 0 3");
		String[] precios = {"Indiferente","Menos de 250.000\u20AC","Entre 250.000\u20AC y 650.000\u20AC","Entre 650.000\u20AC y 1.000.000\u20AC","Entre 1.000.000\u20AC y 1.500.000\u20AC","M\u00E1s 1.500.000\u20AC"};
		JComboBox_precio = new JComboBox<String>(precios);
		JComboBox_precio.setSelectedIndex(0);
		JPanel_filtros.add(JComboBox_precio,"cell 1 3");
		//Localizacion
		JLabel JLabel_localizacion = new JLabel("Localización:");
		JLabel_localizacion.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_localizacion.setFont(new Font("Tahoma", Font.BOLD, 12));
		JLabel_localizacion.setForeground(new Color(224,238,238));
		JPanel_filtros.add(JLabel_localizacion, "cell 0 4");
		JComboBox_localizacion = new JComboBox<String>();
		for (String ciudad : recomendador.getCiudades())
			JComboBox_localizacion.addItem(ciudad);
		JComboBox_localizacion.setSelectedIndex(0);
		JPanel_filtros.add(JComboBox_localizacion,"wrap");
		
		//Extras
		JPanel JPanel_extras = new JPanel();
		JPanel_filtros.add(JPanel_extras, "span");
		JPanel_extras.setBackground(Color.gray);
		JPanel_extras.setBorder(new TitledBorder(null, "Extras",TitledBorder.LEADING, TitledBorder.TOP, null, new Color(224,238,238)));
		JPanel_extras.setLayout(new MigLayout("", "[150.00]20[30.00][]", "[]"));
		//Amueblado
		JLabel JLabel_amueblado = new JLabel("Amueblado:");
		JLabel_amueblado.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_amueblado.setFont(new Font("Tahoma", Font.BOLD, 12));
		JLabel_amueblado.setForeground(new Color(202,255,112));
		JPanel_extras.add(JLabel_amueblado, "cell 0 0");	
		JCheckBox_amueblado = new JCheckBox();
		JCheckBox_amueblado.setBackground(Color.gray);
		JPanel_extras.add(JCheckBox_amueblado,"cell 1 0");
		//Ascensor
		JLabel JLabel_ascensor = new JLabel("Ascensor:");
		JLabel_ascensor.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_ascensor.setFont(new Font("Tahoma", Font.BOLD, 12));
		JLabel_ascensor.setForeground(new Color(202,255,112));
		JPanel_extras.add(JLabel_ascensor, "cell 0 1");		    
		JCheckBox_ascensor = new JCheckBox();
		JCheckBox_ascensor.setBackground(Color.gray);
		JPanel_extras.add(JCheckBox_ascensor,"cell 1 1");
		//Garaje
		JLabel JLabel_garaje = new JLabel("Garaje:");
		JLabel_garaje.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_garaje.setFont(new Font("Tahoma", Font.BOLD, 12));
		JLabel_garaje.setForeground(new Color(202,255,112));
		JPanel_extras.add(JLabel_garaje, "cell 0 2");		    
		JCheckBox_garaje = new JCheckBox();
		JCheckBox_garaje.setBackground(Color.gray);
		JPanel_extras.add(JCheckBox_garaje,"cell 1 2");
		//Calefaccion
		JLabel JLabel_calefaccion = new JLabel("Calefaccion:");
		JLabel_calefaccion.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_calefaccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		JLabel_calefaccion.setForeground(new Color(202,255,112));
		JPanel_extras.add(JLabel_calefaccion, "cell 0 3");		    
		JCheckBox_calefaccion = new JCheckBox();
		JCheckBox_calefaccion.setBackground(Color.gray);
		JPanel_extras.add(JCheckBox_calefaccion,"cell 1 3");
		//Aire acondicionado
		JLabel JLabel_aire = new JLabel("Aire acondicionado:");
		JLabel_aire.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_aire.setFont(new Font("Tahoma", Font.BOLD, 12));
		JLabel_aire.setForeground(new Color(202,255,112));
		JPanel_extras.add(JLabel_aire, "cell 0 4");		    
		JCheckBox_aire = new JCheckBox();
		JCheckBox_aire.setBackground(Color.gray);
		JPanel_extras.add(JCheckBox_aire,"cell 1 4");
		//Terraza
		JLabel JLabel_terraza = new JLabel("Terraza:");
		JLabel_terraza.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_terraza.setFont(new Font("Tahoma", Font.BOLD, 12));
		JLabel_terraza.setForeground(new Color(202,255,112));
		JPanel_extras.add(JLabel_terraza, "cell 0 5");		    
		JCheckBox_terraza = new JCheckBox();
		JCheckBox_terraza.setBackground(Color.gray);
		JPanel_extras.add(JCheckBox_terraza,"cell 1 5");
		//Piscina
		JLabel JLabel_piscina = new JLabel("Piscina:");
		JLabel_piscina.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_piscina.setFont(new Font("Tahoma", Font.BOLD, 12));
		JLabel_piscina.setForeground(new Color(202,255,112));
		JPanel_extras.add(JLabel_piscina, "cell 0 6");		    
		JCheckBox_piscina = new JCheckBox();
		JCheckBox_piscina.setBackground(Color.gray);
		JPanel_extras.add(JCheckBox_piscina,"cell 1 6");
		
		//Botones
		JPanel JPanel_botones = new JPanel();
		JPanel_botones.setBackground(Color.gray);
		JPanel_botones.setLayout(new MigLayout("","[]30[]","[]"));
		JPanel_filtros.add(JPanel_botones,"span");
		//Boton buscar
		JButton_buscar = new JButton("Buscar");
		JPanel_botones.add(JButton_buscar,"cell 0 0");
		JButton_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarLista(recomendador.ejecutarConsulta(getDescripcionVivienda()));
			}
		});
		//Boton filtrar
		JButton_filtrar = new JButton("Filtrar");
		JPanel_botones.add(JButton_filtrar,"cell 1 0");
		JButton_filtrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
				//mostrarLista(recomendador.ejecutarFiltro(getDescripcionVivienda()));
			}
		});
		
		/********************** VISTA DE LISTA DE VIVIENDAS RESULTADO ********************/
		
		JList_viviendas = new JList<DescripcionVivienda>();
		JList_viviendas.setModel(new DefaultListModel<DescripcionVivienda>());
		JList_viviendas.setCellRenderer(new CellRendererViviendas());
		JList_viviendas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Object source = e.getSource();
				if (source.equals(JList_viviendas)){
					int index = JList_viviendas.getSelectedIndex();
					if (index != -1){
						DescripcionVivienda des = JList_viviendas.getModel().getElementAt(index);
						mostrarVistaVivienda(des);
					}
				}
			}
		});
		
		JScrollPane_listaViviendas = new JScrollPane(JList_viviendas);
		JPanel_1.add(JScrollPane_listaViviendas,"cell 3 0 3 5,grow");
		
		/************** VISTA DE UNA VIVIENDA ****************/
		JPanel_vistaVivienda = new JPanel();
		//frmIsbc.getContentPane().add(JPanel_vistaVivienda);

	}
	
	public DescripcionVivienda getDescripcionVivienda(){
		DescripcionVivienda des = new DescripcionVivienda(1);
		if (JComboBox_superficie.getSelectedIndex() != 0){
			switch (JComboBox_superficie.getSelectedIndex()){
			case 1: des.setSuperficie(50);break;
			case 2: des.setSuperficie(100);break;
			case 3: des.setSuperficie(150);break;
			case 4: des.setSuperficie(200);break;
			case 5: des.setSuperficie(250);break;
			}
		}
		if (JComboBox_banios.getSelectedIndex() != 0){
			switch (JComboBox_banios.getSelectedIndex()){
			case 1: des.setBanios(1);break;
			case 2: des.setBanios(2);break;
			case 3: des.setBanios(3);break;
			}
		}
		if (JComboBox_habitaciones.getSelectedIndex() != 0){
			switch (JComboBox_habitaciones.getSelectedIndex()){
			case 1: des.setHabitaciones(1);break;
			case 2: des.setHabitaciones(2);break;
			case 3: des.setHabitaciones(3);break;
			case 4: des.setHabitaciones(4);break;
			case 5: des.setHabitaciones(5);break;
			}
		}
		/*
		if (JComboBox_estado.getSelectedIndex() != 0){
			switch (JComboBox_estado.getSelectedIndex()){
			case 1: des.setEstado("Muy bien");break;
			case 2: des.setHabitaciones(2);break;
			case 3: des.setHabitaciones(3);break;
			case 4: des.setHabitaciones(4);break;
			case 5: des.setHabitaciones(5);break;
			}
		}
		*/
		if (JComboBox_precio.getSelectedIndex() != 0){
			des.setPrecio(getPrecioFromIndex(JComboBox_precio.getSelectedIndex()-1));
		}
		
		des.setLocalizacion((String)JComboBox_localizacion.getSelectedItem());
		des.setCoordenada(recomendador.getPosicionCiudades().get((String)JComboBox_localizacion.getSelectedItem()));
		
		if (JCheckBox_aire.isSelected() || JCheckBox_calefaccion.isSelected() || JCheckBox_amueblado.isSelected()){
			ExtrasBasicos extrasBasicos = new ExtrasBasicos(0);
			extrasBasicos.setAmueblado(JCheckBox_amueblado.isSelected());
			extrasBasicos.setAireAcondicionado(JCheckBox_aire.isSelected());
			extrasBasicos.setCalefaccion(JCheckBox_calefaccion.isSelected());
			des.setExtrasBasicos(extrasBasicos);
		}
		if (JCheckBox_ascensor.isSelected() || JCheckBox_garaje.isSelected()){
			ExtrasFinca extrasFinca = new ExtrasFinca(0);
			extrasFinca.setAscensor(JCheckBox_ascensor.isSelected());
			extrasFinca.setGarajePrivado(JCheckBox_garaje.isSelected());
			extrasFinca.setParkingComunitario(JCheckBox_garaje.isSelected());
			des.setExtrasFinca(extrasFinca);
		}
		if (JCheckBox_terraza.isSelected() || JCheckBox_piscina.isSelected()){
			ExtrasOtros extrasOtros = new ExtrasOtros(0);
			extrasOtros.setTerraza(JCheckBox_terraza.isSelected());
			extrasOtros.setPiscina(JCheckBox_piscina.isSelected());
			extrasOtros.setPiscinaComunitaria(JCheckBox_piscina.isSelected());
			des.setExtrasOtros(extrasOtros);
		}
		System.out.println("vp"+des.toString());
		
		return des;
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
			JComboBox_localizacion.setSelectedIndex(localizacion.getSelectedIndex());
			int precioMax_vivienda = getPrecioFromIndex(precio.getSelectedIndex());
			JComboBox_precio.setSelectedIndex(precio.getSelectedIndex());
			System.out.println("Consulta Inicial  ciudad="+ciudad_vivienda+"    precio="+precioMax_vivienda);
			
			ejecutaConsultaInicial(ciudad_vivienda,precioMax_vivienda);
		}
		else{
			ejecutaConsultaInicial("",-1);
		}
	}
	
	
	public void ejecutaConsultaInicial(String ciudad, int precio){
		//Valores introducidos en el formulario inicial
		//sino formulario vacio
		if (!ciudad.equals("") && precio != -1){
			DescripcionVivienda des = new DescripcionVivienda(1);
			des.setPrecio(precio);
			des.setLocalizacion(ciudad);
			des.setCoordenada(recomendador.getPosicionCiudades().get(ciudad));
			actualizarLista(recomendador.ejecutarConsulta(des));
		}
	}
	
	
	public void mostrarVistaVivienda(final DescripcionVivienda des){
		JPanel_vistaVivienda = new JPanel();
		JPanel_vistaVivienda.setLayout(new MigLayout("","[200.00, grow]50[700.00, grow]","[]"));
		
		JPanel JPanel_botones = new JPanel();
		JPanel_botones.setLayout(new MigLayout("","[]","[]50[]50[]50[]"));
		JPanel_vistaVivienda.add(JPanel_botones,"cell 0 0");
		
		JButton JButton_volver = new JButton("Volver");
		//JButton_volver.setBounds(0,0,150,50);
		JButton_volver.setIcon(new ImageIcon(new ImageIcon("./imgs/icono_volver.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
			JButton_volver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmIsbc.getContentPane().add(JPanel_1);
					frmIsbc.getContentPane().remove(JPanel_vistaVivienda);
					SwingUtilities.updateComponentTreeUI(frmIsbc);
				}
			});
		JButton JButton_comprar = new JButton ("Me la quedo");
		//JButton_comprar.setBounds(0,0,150,50);
		JButton_comprar.setIcon(new ImageIcon(new ImageIcon("./imgs/icono_comprar.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
			JButton_comprar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog (frmIsbc, "Enhorabuena por su compra");
					System.exit(0);
				}
			});
		JButton JButton_descartar = new JButton("No me gusta");
		//JButton_descartar.setBounds(0,0,150,50);
		JButton_descartar.setIcon(new ImageIcon(new ImageIcon("./imgs/icono_descartar.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
			JButton_descartar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog (frmIsbc, "Casa descartada de la busqueda");
					recomendador.anyadirAListaTabu(des);
					DefaultListModel<DescripcionVivienda> model = (DefaultListModel<DescripcionVivienda>) JList_viviendas.getModel();
					model.removeElement(des);
					frmIsbc.getContentPane().add(JPanel_1);
					frmIsbc.getContentPane().remove(JPanel_vistaVivienda);
					SwingUtilities.updateComponentTreeUI(frmIsbc);
				}
			});
		JButton JButton_mas = new JButton("Otra como esta");
		//JButton_mas.setBounds(0,0,150,50);
		JButton_mas.setIcon(new ImageIcon(new ImageIcon("./imgs/icono_mas.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
			JButton_mas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog (frmIsbc, "Más casas similares");
					actualizarLista(recomendador.ejecutarConsulta(des));
					System.out.println("boton pulsado");
					frmIsbc.getContentPane().add(JPanel_1);
					frmIsbc.getContentPane().remove(JPanel_vistaVivienda);
					SwingUtilities.updateComponentTreeUI(frmIsbc);
				}
			});
		
		JPanel_botones.add(JButton_volver,"cell 0 0");
		JPanel_botones.add(JButton_comprar,"cell 0 1");
		JPanel_botones.add(JButton_descartar,"cell 0 2");
		JPanel_botones.add(JButton_mas,"cell 0 3");
		
		JPanel JPanel_vivienda = new JPanel();
		JPanel_vivienda.setBorder(BorderFactory.createLineBorder(Color.black));
		JPanel_vivienda.setLayout(new MigLayout("","[]20[]","[]5[]8[]8[]10[]"));
		JPanel_vistaVivienda.add(JPanel_vivienda,"cell 0 0");
		
		ImageIcon icono = new ImageIcon("./imgs/icono_casa2.png");
		icono = new ImageIcon(icono.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
		JLabel JLabel_icono = new JLabel();
		JLabel_icono.setIcon(icono);
		JLabel JLabel_titulo = new JLabel(des.getTitulo());
		JLabel_titulo.setForeground(new Color(3,168,158));
		JLabel_titulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JPanel JPanel_datos = new JPanel();
		JPanel_datos.setLayout(new MigLayout("","[left]8[left]100[right]8[right]","[]10[]5[]"));
		
		JLabel JLabel_localizacion = new JLabel(des.getLocalizacion().split("/")[0]);
		JLabel_localizacion.setForeground(new Color(220,20,60));
		JLabel_localizacion.setFont(new Font("Tahoma", Font.BOLD, 17));
		JLabel JLabel_precio = new JLabel(des.getPrecio().toString());
		JLabel_precio.setForeground(new Color(220,20,60));
		JLabel_precio.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel JLabel_thabitaciones = new JLabel ("Habitaciones:");
		JLabel_thabitaciones.setForeground(new Color(46,139,87));
		JLabel_thabitaciones.setFont(new Font("Tahoma", Font.BOLD, 15));
		JLabel JLabel_habitaciones = new JLabel (des.getHabitaciones().toString());
		JLabel_habitaciones.setForeground(new Color(131,139,131));
		JLabel_habitaciones.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel JLabel_tbanios = new JLabel ("Baños:");
		JLabel_tbanios.setForeground(new Color(46,139,87));
		JLabel_tbanios.setFont(new Font("Tahoma", Font.BOLD, 15));
		JLabel JLabel_banios = new JLabel (des.getBanios().toString());
		JLabel_banios.setForeground(new Color(131,139,131));
		JLabel_banios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel JLabel_tprecioMedio = new JLabel ("Precio medio:");
		JLabel_tprecioMedio.setForeground(new Color(46,139,87));
		JLabel_tprecioMedio.setFont(new Font("Tahoma", Font.BOLD, 15));
		JLabel JLabel_precioMedio = new JLabel (des.getPrecioMedio().toString());
		JLabel_precioMedio.setForeground(new Color(131,139,131));
		JLabel_precioMedio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel JLabel_tprecioZona = new JLabel ("Precio zona:");
		JLabel_tprecioZona.setForeground(new Color(46,139,87));
		JLabel_tprecioZona.setFont(new Font("Tahoma", Font.BOLD, 15));
		JLabel JLabel_precioZona = new JLabel (des.getPrecioZona().toString());
		JLabel_precioZona.setForeground(new Color(131,139,131));
		JLabel_precioZona.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel_datos.add(JLabel_localizacion,"cell 0 0,span 2");
		JPanel_datos.add(JLabel_precio,"cell 2 0,span 2");
		JPanel_datos.add(JLabel_thabitaciones,"cell 0 1");
		JPanel_datos.add(JLabel_habitaciones,"cell 1 1");
		JPanel_datos.add(JLabel_tbanios,"cell 0 2");
		JPanel_datos.add(JLabel_banios,"cell 1 2");
		JPanel_datos.add(JLabel_tprecioMedio,"cell 2 1");
		JPanel_datos.add(JLabel_precioMedio,"cell 3 1");
		JPanel_datos.add(JLabel_tprecioZona,"cell 2 2");
		JPanel_datos.add(JLabel_precioZona,"cell 3 2");
		
		
		JPanel JPanel_datos2 = new JPanel();
		JPanel_datos2.setLayout(new MigLayout("","80[]10[]40[]10[]40[]10[]","[]"));
		
		JLabel JLabel_tsuperficie = new JLabel ("Superficie:");
		JLabel_tsuperficie.setForeground(new Color(46,139,87));
		JLabel_tsuperficie.setFont(new Font("Tahoma", Font.BOLD, 15));
		JLabel JLabel_superficie = new JLabel (des.getSuperficie().toString());
		JLabel_superficie.setForeground(new Color(131,139,131));
		JLabel_superficie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel JLabel_testado = new JLabel ("Estado:");
		JLabel_testado.setForeground(new Color(46,139,87));
		JLabel_testado.setFont(new Font("Tahoma", Font.BOLD, 15));
		JLabel JLabel_estado = new JLabel (des.getEstado().toString());
		JLabel_estado.setForeground(new Color(131,139,131));
		JLabel_estado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel JLabel_ttipo = new JLabel ("Tipo vivienda:");
		JLabel_ttipo.setForeground(new Color(46,139,87));
		JLabel_ttipo.setFont(new Font("Tahoma", Font.BOLD, 15));
		JLabel JLabel_tipo = new JLabel (des.getTipo().toString());
		JLabel_tipo.setForeground(new Color(131,139,131));
		JLabel_tipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel_datos2.add(JLabel_tsuperficie,"cell 0 0");
		JPanel_datos2.add(JLabel_superficie,"cell 1 0");
		JPanel_datos2.add(JLabel_testado,"cell 2 0");
		JPanel_datos2.add(JLabel_estado,"cell 3 0");
		JPanel_datos2.add(JLabel_ttipo,"cell 4 0");
		JPanel_datos2.add(JLabel_tipo,"cell 5 0");
		
		JPanel JPanel_extras = new JPanel();
		JPanel_extras.setLayout(new MigLayout("","[]","[]3[]7[]3[]7[]3[]"));
		
		JLabel JLabel_textrasBasicos = new JLabel ("Extras básicos:");
		JLabel_textrasBasicos.setForeground(new Color(46,139,87));
		JLabel_textrasBasicos.setFont(new Font("Tahoma", Font.BOLD, 15));
		JLabel JLabel_extrasBasicos = new JLabel (des.getExtrasBasicos().writeString().substring(0, des.getExtrasBasicos().writeString().length()-2));
		JLabel_extrasBasicos.setForeground(new Color(131,139,131));
		JLabel_extrasBasicos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel JLabel_textrasFinca = new JLabel ("Extras finca:");
		JLabel_textrasFinca.setForeground(new Color(46,139,87));
		JLabel_textrasFinca.setFont(new Font("Tahoma", Font.BOLD, 15));
		JLabel JLabel_extrasFinca = new JLabel (des.getExtrasFinca().writeString().substring(0, des.getExtrasFinca().writeString().length()-2));
		JLabel_extrasFinca.setForeground(new Color(131,139,131));
		JLabel_extrasFinca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel JLabel_textrasOtros = new JLabel ("Otros extras:");
		JLabel_textrasOtros.setForeground(new Color(46,139,87));
		JLabel_textrasOtros.setFont(new Font("Tahoma", Font.BOLD, 15));
		JLabel JLabel_extrasOtros = new JLabel (des.getExtrasOtros().writeString().substring(0, des.getExtrasOtros().writeString().length()-2));
		JLabel_extrasOtros.setForeground(new Color(131,139,131));
		JLabel_extrasOtros.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel_extras.add(JLabel_textrasBasicos,"cell 0 0");
		JPanel_extras.add(JLabel_extrasBasicos,"cell 0 1");
		JPanel_extras.add(JLabel_textrasFinca,"cell 0 2");
		JPanel_extras.add(JLabel_extrasFinca,"cell 0 3");
		JPanel_extras.add(JLabel_textrasOtros,"cell 0 4");
		JPanel_extras.add(JLabel_extrasOtros,"cell 0 5");
		
		JPanel JPanel_descripcion = new JPanel();
		JPanel_descripcion.setLayout(new MigLayout("","[]","[]3[]"));
		
		JLabel JLabel_tdescripcion = new JLabel ("Descripcion:");
		JLabel_tdescripcion.setForeground(new Color(46,139,87));
		JLabel_tdescripcion.setFont(new Font("Tahoma", Font.BOLD, 15));
		String aux = des.getDescripcion();
		String label = "";
		while (aux.length() > 80){
			label += aux.substring(0, 80);
			label +="\n";
			aux = aux.substring(80);
		}
		label += aux;
		JTextArea JTextArea_descripcion = new JTextArea();
		JTextArea_descripcion.setText(label);
		JTextArea_descripcion.setForeground(new Color(131,139,131));
		JTextArea_descripcion.setOpaque(false);
		JTextArea_descripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		/*
		JLabel JLabel_descripcion = new JLabel(label);
		JLabel_descripcion.setForeground(new Color(131,139,131));
		JLabel_descripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		*/
		JPanel_descripcion.add(JLabel_tdescripcion,"cell 0 0");
		JPanel_descripcion.add(JTextArea_descripcion,"cell 0 1");
		//JPanel_descripcion.add(JLabel_descripcion,"cell 0 1");
		
		//JLabel JLabel_descripcion = new JLabel (des.getDescripcion());
		
		JPanel_vivienda.add(JLabel_icono,"cell 0 0 0 2");
		JPanel_vivienda.add(JLabel_titulo,"cell 1 0");
		JPanel_vivienda.add(JPanel_datos,"cell 1 1,wrap");
		JPanel_vivienda.add(JPanel_datos2,"span,wrap");
		JPanel_vivienda.add(JPanel_extras,"span,wrap");
		JPanel_vivienda.add(JPanel_descripcion,"span");
		
		frmIsbc.getContentPane().remove(JPanel_1);
		frmIsbc.getContentPane().add(JPanel_vistaVivienda);
		
		SwingUtilities.updateComponentTreeUI(frmIsbc);
		
	}

	public void actualizarLista (ArrayList<CBRCase> casos){
		DefaultListModel<DescripcionVivienda> model = (DefaultListModel<DescripcionVivienda>) JList_viviendas.getModel();
		model.removeAllElements();
		for (int i=0;i<casos.size();i++)
			model.addElement((DescripcionVivienda) casos.get(i).getDescription());
		SwingUtilities.updateComponentTreeUI(frmIsbc);
		//frmIsbc.repaint();
	}
	
	public int getPrecioFromIndex(int index){
		
		int precio = 0;
		
		switch (index) {
        case 0:  precio = 150000;
                 break;
        case 1:  precio = 500000;
                 break;
        case 2:  precio = 900000;
                 break;
        case 3:  precio = 1750000;
                 break;
        case 4:  precio = 30000000;
        		 break;
        default: precio = 450000;
                 break;
		}
		return precio;
	}
}

package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

import es.ucm.fdi.isbc.viviendas.ViviendasRecomendador;
import es.ucm.fdi.isbc.viviendas.representacion.DescripcionVivienda;
import es.ucm.fdi.isbc.viviendas.representacion.DescripcionVivienda.EstadoVivienda;
import es.ucm.fdi.isbc.viviendas.representacion.DescripcionVivienda.TipoVivienda;

import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import jcolibri.cbrcore.CBRCase;

public class VistaPrincipal {
	
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPaneSoluciones;
	
	private JFrame frmIsbc;
	private JTextField textFieldHabitaciones;
	private JTextField textFieldSuperficie;
	private JTextField textFieldPrecioMedio;
	private JTextField textFieldPrecioZona;
	private JTextField textFieldPrecio;
	private JTextField textFieldBanios;
	private JTextField textFieldZona;
	
	JComboBox comboBoxEstado;
	JComboBox comboBoxTipoVivienda;
	
	private ViviendasRecomendador recomendador;
	private JTable tablaSoluciones;

	/**
	 * Create the application.
	 */
	public VistaPrincipal(ViviendasRecomendador vr) {
		initialize();
		frmIsbc.setBounds(100, 100, 1093,800);
		frmIsbc.setVisible(true);
		formularioInicial();
		recomendador = vr;
		
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
		String[] superficies = {"Desde 50m%B2","Desde 100m%B2","Desde 150m%B2","Desde 200m%B2","Desde 250m%B2" };
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
		JLabel JLabel_banios = new JLabel("Banios:");
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
		
		/*
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel panelConsultas = new JPanel();
		tabbedPane.addTab("Consultas", null, panelConsultas, null);
		
		JLabel lblPrecio = new JLabel("Precio");
		
		JLabel lblZona = new JLabel("Zona");
		
		JLabel lblBaos = new JLabel("Ba\u00F1os");
		
		JLabel lblHabitaciones = new JLabel("Habitaciones");
		
		JLabel lblTipoVivienda = new JLabel("Tipo vivienda");
		
		JLabel lblSuperficie = new JLabel("Superficie");
		
		JLabel lblEstado = new JLabel("Estado");
		
		JLabel lblPrecioMedio = new JLabel("Precio Medio");
		
		JLabel lblPrecioZona = new JLabel("Precio Zona");
		
		textFieldHabitaciones = new JTextField();
		textFieldHabitaciones.setColumns(10);
		
		textFieldSuperficie = new JTextField();
		textFieldSuperficie.setColumns(10);
		
		textFieldPrecioMedio = new JTextField();
		textFieldPrecioMedio.setColumns(10);
		
		textFieldPrecioZona = new JTextField();
		textFieldPrecioZona.setColumns(10);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		
		textFieldBanios = new JTextField();
		textFieldBanios.setColumns(10);
		
		comboBoxEstado = new JComboBox();
		comboBoxEstado.setModel(new DefaultComboBoxModel(new String[] {"No importa", "Muybien", "Reformado", "Areformar", "Casinuevo", "Bien"}));
		
		comboBoxTipoVivienda = new JComboBox();
		comboBoxTipoVivienda.setModel(new DefaultComboBoxModel(new String[] {"No importa","Atico", "Plantabaja", "Piso", "Loft", "Casaadosada", "CasaChalet", "Duplex", "Estudio", "Fincarustica", "Apartamento"}));
		
		textFieldZona = new JTextField();
		textFieldZona.setColumns(10);
		
		JButton btnBuscarCasas = new JButton("Buscar Casas");
		btnBuscarCasas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonBuscaCasas();
			}
		});
		GroupLayout gl_panelConsultas = new GroupLayout(panelConsultas);
		gl_panelConsultas.setHorizontalGroup(
			gl_panelConsultas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelConsultas.createSequentialGroup()
					.addGroup(gl_panelConsultas.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelConsultas.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelConsultas.createParallelGroup(Alignment.LEADING)
								.addComponent(lblZona)
								.addComponent(lblBaos)
								.addComponent(lblEstado)
								.addGroup(gl_panelConsultas.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_panelConsultas.createSequentialGroup()
										.addComponent(lblSuperficie)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(textFieldSuperficie, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panelConsultas.createSequentialGroup()
										.addGroup(gl_panelConsultas.createParallelGroup(Alignment.LEADING)
											.addComponent(lblHabitaciones)
											.addComponent(lblPrecio)
											.addComponent(lblTipoVivienda)
											.addComponent(lblPrecioMedio)
											.addComponent(lblPrecioZona))
										.addGap(27)
										.addGroup(gl_panelConsultas.createParallelGroup(Alignment.LEADING, false)
											.addComponent(textFieldPrecioZona, 0, 0, Short.MAX_VALUE)
											.addComponent(textFieldPrecioMedio, 0, 0, Short.MAX_VALUE)
											.addComponent(comboBoxTipoVivienda, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(textFieldHabitaciones, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
											.addComponent(textFieldBanios, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
											.addComponent(textFieldPrecio, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
											.addComponent(textFieldZona)
											.addComponent(comboBoxEstado, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
						.addGroup(gl_panelConsultas.createSequentialGroup()
							.addGap(54)
							.addComponent(btnBuscarCasas)))
					.addContainerGap(589, Short.MAX_VALUE))
		);
		gl_panelConsultas.setVerticalGroup(
			gl_panelConsultas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelConsultas.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelConsultas.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrecio, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelConsultas.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblZona)
						.addComponent(textFieldZona, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelConsultas.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBaos)
						.addComponent(textFieldBanios, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelConsultas.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHabitaciones)
						.addComponent(textFieldHabitaciones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelConsultas.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoVivienda)
						.addComponent(comboBoxTipoVivienda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelConsultas.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSuperficie)
						.addComponent(textFieldSuperficie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelConsultas.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstado)
						.addComponent(comboBoxEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelConsultas.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrecioMedio)
						.addComponent(textFieldPrecioMedio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelConsultas.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrecioZona)
						.addComponent(textFieldPrecioZona, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnBuscarCasas)
					.addContainerGap(454, Short.MAX_VALUE))
		);
		panelConsultas.setLayout(gl_panelConsultas);
		
        tablaSoluciones = new JTable();
		
		
		scrollPaneSoluciones = new JScrollPane(tablaSoluciones);
		tabbedPane.addTab("Soluciones", null, scrollPaneSoluciones, null);

		GroupLayout groupLayout = new GroupLayout(frmIsbc.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		frmIsbc.getContentPane().setLayout(groupLayout);
		*/
	}
	
	
	private void botonBuscaCasas(){		

		//Crear Descripcion vivienda
		DescripcionVivienda des = new DescripcionVivienda(1);
		
		if(!textFieldPrecio.getText().equals(""))
			des.setPrecio(Integer.parseInt(textFieldPrecio.getText()));
		
		if(!textFieldZona.getText().equals(""))
			des.setLocalizacion(textFieldZona.getText());
		
		if(!textFieldBanios.getText().equals(""))
			des.setBanios(Integer.parseInt(textFieldBanios.getText()));
		
		if(!textFieldHabitaciones.getText().equals(""))
			des.setHabitaciones(Integer.parseInt(textFieldHabitaciones.getText()));
		
		if(!comboBoxTipoVivienda.getSelectedItem().equals("No importa"))
			des.setTipo(TipoVivienda.valueOf(comboBoxTipoVivienda.getSelectedItem().toString()));
		
		if(!textFieldSuperficie.getText().equals(""))
			des.setSuperficie(Integer.parseInt(textFieldSuperficie.getText()));
		
		if(!comboBoxEstado.getSelectedItem().equals("No importa"))
			des.setEstado(EstadoVivienda.valueOf(comboBoxEstado.getSelectedItem().toString()));
		
		if(!textFieldPrecioMedio.getText().equals(""))
			des.setPrecioMedio(Integer.parseInt(textFieldPrecioMedio.getText()));
		
		if(!textFieldPrecioZona.getText().equals(""))
			des.setPrecioZona(Integer.parseInt(textFieldPrecioZona.getText()));


		ArrayList<CBRCase> solucion = recomendador.ejecutarConsulta(des);
		
		 TablaResultados res = new TablaResultados(solucion);
         tablaSoluciones = new JTable(res);
         scrollPaneSoluciones = new JScrollPane(tablaSoluciones);
 		 tabbedPane.removeTabAt(1);
 		 tabbedPane.addTab("Soluciones", null, scrollPaneSoluciones, null);
         tabbedPane.setSelectedIndex(1);

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

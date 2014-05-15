package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import es.ucm.fdi.isbc.viviendas.ViviendasRecomendador;
import es.ucm.fdi.isbc.viviendas.representacion.DescripcionVivienda;
import es.ucm.fdi.isbc.viviendas.representacion.DescripcionVivienda.EstadoVivienda;
import es.ucm.fdi.isbc.viviendas.representacion.DescripcionVivienda.TipoVivienda;

public class VistaPrincipal {
	
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

	/**
	 * Create the application.
	 */
	public VistaPrincipal(ViviendasRecomendador vr) {
		initialize();
		frmIsbc.setBounds(100, 100, 800,800);
		frmIsbc.setVisible(true);
		recomendador = vr;
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIsbc = new JFrame();
		frmIsbc.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmIsbc.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Consultas", null, panel, null);
		
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
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblZona)
								.addComponent(lblBaos)
								.addComponent(lblEstado)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblSuperficie)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(textFieldSuperficie, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(lblHabitaciones)
											.addComponent(lblPrecio)
											.addComponent(lblTipoVivienda)
											.addComponent(lblPrecioMedio)
											.addComponent(lblPrecioZona))
										.addGap(27)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
											.addComponent(textFieldPrecioZona, 0, 0, Short.MAX_VALUE)
											.addComponent(textFieldPrecioMedio, 0, 0, Short.MAX_VALUE)
											.addComponent(comboBoxTipoVivienda, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(textFieldHabitaciones, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
											.addComponent(textFieldBanios, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
											.addComponent(textFieldPrecio, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
											.addComponent(textFieldZona)
											.addComponent(comboBoxEstado, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(54)
							.addComponent(btnBuscarCasas)))
					.addContainerGap(589, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrecio, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblZona)
						.addComponent(textFieldZona, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBaos)
						.addComponent(textFieldBanios, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHabitaciones)
						.addComponent(textFieldHabitaciones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoVivienda)
						.addComponent(comboBoxTipoVivienda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSuperficie)
						.addComponent(textFieldSuperficie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstado)
						.addComponent(comboBoxEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrecioMedio)
						.addComponent(textFieldPrecioMedio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrecioZona)
						.addComponent(textFieldPrecioZona, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnBuscarCasas)
					.addContainerGap(454, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabbedPane_1, null);
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


		recomendador.ejecutarConsulta(des);
	}
}

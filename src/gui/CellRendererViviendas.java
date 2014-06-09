package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import es.ucm.fdi.isbc.viviendas.representacion.DescripcionVivienda;


public class CellRendererViviendas extends DefaultListCellRenderer{

	public Component getListCellRendererComponent(JList<?> list, Object value,int index, boolean isSelected, boolean hasFocus) {
		JPanel panel = new JPanel();
		DescripcionVivienda descripcion = (DescripcionVivienda)value;
		
		panel.setLayout(new MigLayout("", "[100][150][100][150]", "[60][30][60][grow]"));
		panel.setPreferredSize(new Dimension(500,150));
		
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel JLabel_titulo = new JLabel (descripcion.getTitulo());
		JLabel JLabel_precio = new JLabel (descripcion.getPrecio().toString());
		JLabel JLabel_habitaciones = new JLabel (descripcion.getHabitaciones().toString());
		JLabel JLabel_banios = new JLabel (descripcion.getBanios().toString());
		JLabel JLabel_superficie = new JLabel (descripcion.getSuperficie().toString());
		JLabel JLabel_descripcion = new JLabel (descripcion.getDescripcion());
		ImageIcon icono = new ImageIcon("./imgs/icono_casa.png");
		icono = new ImageIcon(icono.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		JLabel JLabel_icono = new JLabel();
		JLabel_icono.setIcon(icono);
		
		panel.add(JLabel_icono, "cell 0 0 0 2");
		panel.add(JLabel_titulo,"cell 1 0");
		panel.add(JLabel_precio, "cell 3 0");
		panel.add(JLabel_habitaciones, "cell 1 1");
		panel.add(JLabel_banios, "cell 2 1");
		panel.add(JLabel_superficie, "cell 3 1");
		panel.add(JLabel_descripcion, "cell 1 2 3 2");
		
		return panel;
	}
	
}

package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import es.ucm.fdi.isbc.viviendas.representacion.DescripcionVivienda;

public class CellRendererViviendas extends DefaultListCellRenderer{

	public Component getListCellRendererComponent(JList<?> list, Object value,int index, boolean isSelected, boolean hasFocus) {
		JPanel panel = new JPanel();
		DescripcionVivienda descripcion = (DescripcionVivienda)value;
		
		panel.setPreferredSize(new Dimension(500,330));
		
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel JLabel_titulo = new JLabel (descripcion.getTitulo());
		JLabel JLabel_habitaciones = new JLabel (descripcion.getHabitaciones().toString());
		JLabel JLabel_banios = new JLabel (descripcion.getBanios().toString());
		JLabel JLabel_descripcion = new JLabel (descripcion.getDescripcion());
		
		panel.add(JLabel_titulo);
		panel.add(JLabel_habitaciones);
		panel.add(JLabel_banios);
		panel.add(JLabel_descripcion);
		
		return panel;
	}
	
}

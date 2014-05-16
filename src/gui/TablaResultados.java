package gui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.swing.JRadioButton;
import javax.swing.table.AbstractTableModel;

import jcolibri.cbrcore.Attribute;
import jcolibri.cbrcore.CBRCase;
import jcolibri.cbrcore.CaseComponent;
import jcolibri.util.AttributeUtils;

public class TablaResultados extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<CBRCase> solucion;
	Vector<Object> columNames;
	Vector<Object> rowsContent;

    public TablaResultados(ArrayList<CBRCase> solucion) {
        this.solucion = solucion;
        columNames = extractColumnNames(solucion.iterator().next());
        
        rowsContent = new Vector<Object>();
    	for(CBRCase s: solucion)
    	    rowsContent.add(getAttributes(s));
    }

    @Override
    public int getRowCount() {
        return solucion.size();
    }

    @Override
    public int getColumnCount() {
        return columNames.size();
    }

    @Override
    public String getColumnName(int column) {
        String name = "??";
        name = columNames.get(column).toString();
        return name;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class type = String.class;
        switch (columnIndex) {
            case 0:
            case 1:
                type = Integer.class;
                break;
        }
        return type;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	Collection<Attribute> atributos = (Collection<Attribute>) rowsContent.get(rowIndex);
        Object value = null;
        
        value = ((Vector) atributos).get(columnIndex);
        
        return value;
    } 
    
	/**
	 * Returns a list with the values of the attributes of a case.
	 * 
	 * @param c
	 *            the case
	 * @return Vector of Objects
	 */
	private static Vector getAttributes(CBRCase c) {
		Vector<Object> res = new Vector<Object>();

		JRadioButton rb = new JRadioButton(c.getID().toString());
		res.add(rb);

		getAttributes(c.getDescription(), res);
		getAttributes(c.getSolution(), res);
		getAttributes(c.getJustificationOfSolution(), res);
		getAttributes(c.getResult(), res);

		return res;
	}

	/**
	 * Fills the list with the values of the attributes of the CaseComponent.
	 * 
	 * @param cc
	 *            CaseComponent
	 * @param res
	 *            List to fill
	 */
	private static void getAttributes(CaseComponent cc, Vector<Object> res) {
		Collection<Attribute> atts = AttributeUtils.getAttributes(cc);
		if (atts == null)
			return;

		Attribute id = cc.getIdAttribute();
		for (Attribute a : atts) {
			if (!a.equals(id))
				res.add(AttributeUtils.findValue(a, cc));
		}
	}

	/**
	 * Obtains the column names of the tables from a case. (It obtains the names
	 * of the attributes)
	 * 
	 * @param c
	 *            is any case.
	 * @return a list of objects
	 */
	private static Vector<Object> extractColumnNames(CBRCase c) {
		Vector<Object> res = new Vector<Object>();
		res.add("Select");
		extractColumnNames(c.getDescription(), res);
		extractColumnNames(c.getSolution(), res);
		extractColumnNames(c.getJustificationOfSolution(), res);
		extractColumnNames(c.getResult(), res);
		return res;
	}

	/**
	 * Extracts the column names (names of the attributes) from a CaseComponent.
	 * 
	 * @param cc
	 *            is the CaseComponent.
	 * @param res
	 *            List to fill.
	 */
	private static void extractColumnNames(CaseComponent cc, Vector<Object> res) {
		Collection<Attribute> atts = AttributeUtils.getAttributes(cc);
		if (atts == null)
			return;
		Attribute id = cc.getIdAttribute();
		for (Attribute a : atts) {
			if (!a.equals(id))
				res.add(a.getName());
		}
	}
}        


package es.ucm.fdi.isbc.viviendas.representacion;

import jcolibri.cbrcore.Attribute;
import jcolibri.cbrcore.CaseComponent;

public class ExtrasOtros implements CaseComponent {
	
	Integer id;
	boolean patio;
	boolean balcon;
	boolean zonaDeportiva;
	boolean zonaComunitaria;
	boolean terraza;
	boolean piscinaComunitaria;
	boolean jardinPrivado;
	boolean zonaInfantil;
	boolean piscina;
	
	

	public ExtrasOtros(int id) {
		super();
		this.id = id;
	}

	public ExtrasOtros(String stringRep)
	{
		String[] values = stringRep.split(",");
		id = Integer.valueOf(values[0]);
		this.patio = Boolean.valueOf(values[1]);
		this.balcon = Boolean.valueOf(values[2]);
		this.zonaDeportiva = Boolean.valueOf(values[3]);
		this.zonaComunitaria = Boolean.valueOf(values[4]);
		this.terraza = Boolean.valueOf(values[5]);
		this.piscinaComunitaria = Boolean.valueOf(values[6]);
		this.jardinPrivado = Boolean.valueOf(values[7]);
		this.zonaInfantil = Boolean.valueOf(values[8]);
		this.piscina = Boolean.valueOf(values[9]);
	}
	
	
	
	@Override
	public String toString() {
		return "ExtrasOtros [id=" + id + ", patio=" + patio + ", balcon=" + balcon + ", zonaDeportiva=" + zonaDeportiva
				+ ", zonaComunitaria=" + zonaComunitaria + ", terraza=" + terraza + ", piscinaComunitaria="
				+ piscinaComunitaria + ", jardinPrivado=" + jardinPrivado + ", zonaInfantil=" + zonaInfantil
				+ ", piscina=" + piscina + "]";
	}

	public String writeString(){
		String aux ="";
		if (patio)
			aux += "patio, ";
		if (balcon)
			aux += "balcón, ";
		if (zonaDeportiva)
			aux += ", zona deportiva, ";
		if (zonaComunitaria)
			aux += "zona comunitaria, ";
		if (terraza)
			aux += "terraza, ";
		if (piscinaComunitaria)
			aux += "piscina comunitaria, ";
		if (jardinPrivado)
			aux += "jardin privado, ";
		if (zonaInfantil)
			aux += "zona infantil, ";
		if (piscina)
			aux += "piscina, ";
		return aux;
	}
	
	@Override
	public Attribute getIdAttribute() {
		return new Attribute("id", DescripcionVivienda.class);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isPatio() {
		return patio;
	}
	public void setPatio(boolean patio) {
		this.patio = patio;
	}
	public boolean isBalcon() {
		return balcon;
	}
	public void setBalcon(boolean balcon) {
		this.balcon = balcon;
	}
	public boolean isZonaDeportiva() {
		return zonaDeportiva;
	}
	public void setZonaDeportiva(boolean zonaDeportiva) {
		this.zonaDeportiva = zonaDeportiva;
	}
	public boolean isZonaComunitaria() {
		return zonaComunitaria;
	}
	public void setZonaComunitaria(boolean zonaComunitaria) {
		this.zonaComunitaria = zonaComunitaria;
	}
	public boolean isTerraza() {
		return terraza;
	}
	public void setTerraza(boolean terraza) {
		this.terraza = terraza;
	}
	public boolean isPiscinaComunitaria() {
		return piscinaComunitaria;
	}
	public void setPiscinaComunitaria(boolean piscinaComunitaria) {
		this.piscinaComunitaria = piscinaComunitaria;
	}
	public boolean isJardinPrivado() {
		return jardinPrivado;
	}
	public void setJardinPrivado(boolean jardinPrivado) {
		this.jardinPrivado = jardinPrivado;
	}
	public boolean isZonaInfantil() {
		return zonaInfantil;
	}
	public void setZonaInfantil(boolean zonaInfantil) {
		this.zonaInfantil = zonaInfantil;
	}
	public boolean isPiscina() {
		return piscina;
	}
	public void setPiscina(boolean piscina) {
		this.piscina = piscina;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (balcon ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (jardinPrivado ? 1231 : 1237);
		result = prime * result + (patio ? 1231 : 1237);
		result = prime * result + (piscina ? 1231 : 1237);
		result = prime * result + (piscinaComunitaria ? 1231 : 1237);
		result = prime * result + (terraza ? 1231 : 1237);
		result = prime * result + (zonaComunitaria ? 1231 : 1237);
		result = prime * result + (zonaDeportiva ? 1231 : 1237);
		result = prime * result + (zonaInfantil ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExtrasOtros other = (ExtrasOtros) obj;
		if (balcon != other.balcon)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (jardinPrivado != other.jardinPrivado)
			return false;
		if (patio != other.patio)
			return false;
		if (piscina != other.piscina)
			return false;
		if (piscinaComunitaria != other.piscinaComunitaria)
			return false;
		if (terraza != other.terraza)
			return false;
		if (zonaComunitaria != other.zonaComunitaria)
			return false;
		if (zonaDeportiva != other.zonaDeportiva)
			return false;
		if (zonaInfantil != other.zonaInfantil)
			return false;
		return true;
	}
	
	
}

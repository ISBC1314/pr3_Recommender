package es.ucm.fdi.isbc.viviendas.representacion;

import jcolibri.cbrcore.Attribute;
import jcolibri.cbrcore.CaseComponent;

public class ExtrasFinca implements CaseComponent{

	Integer id;
	boolean ascensor;
	boolean trastero;
	boolean energiaSolar;
	boolean servPorteria;
	boolean parkingComunitario;
	boolean garajePrivado;
	boolean videoportero;
	
	
	public ExtrasFinca(int id)
	{
		super();
		this.id = id;
	}
	
	public ExtrasFinca(String stringRep)
	{
		String[] values = stringRep.split(",");
		id = Integer.valueOf(values[0]);
		ascensor = Boolean.valueOf(values[1]);
		trastero = Boolean.valueOf(values[2]);
		energiaSolar = Boolean.valueOf(values[3]);
		servPorteria  = Boolean.valueOf(values[4]);
		parkingComunitario = Boolean.valueOf(values[5]);
		garajePrivado = Boolean.valueOf(values[6]);
		videoportero = Boolean.valueOf(values[7]);
	}
	
	@Override
	public String toString() {
		return id+ "," + ascensor + "," + trastero + "," + energiaSolar + ","
				+ servPorteria + "," + parkingComunitario + "," + garajePrivado
				+ "," + videoportero;
	}
	
	public String writeString(){
		String aux ="";
		if (ascensor)
			aux += "ascensor, ";
		if (trastero)
			aux += "trastero, ";
		if (energiaSolar)
			aux += ", energía solar, ";
		if (servPorteria)
			aux += "servicio de portería, ";
		if (parkingComunitario)
			aux += "parking comunitario, ";
		if (garajePrivado)
			aux += "garaje privado, ";
		if (videoportero)
			aux += "video portero, ";
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

	public boolean isAscensor() {
		return ascensor;
	}
	public void setAscensor(boolean ascensor) {
		this.ascensor = ascensor;
	}
	public boolean isTrastero() {
		return trastero;
	}
	public void setTrastero(boolean trastero) {
		this.trastero = trastero;
	}
	public boolean isEnergiaSolar() {
		return energiaSolar;
	}
	public void setEnergiaSolar(boolean energiaSolar) {
		this.energiaSolar = energiaSolar;
	}
	public boolean isServPorteria() {
		return servPorteria;
	}
	public void setServPorteria(boolean servPorteria) {
		this.servPorteria = servPorteria;
	}
	public boolean isParkingComunitario() {
		return parkingComunitario;
	}
	public void setParkingComunitario(boolean parkingComunitario) {
		this.parkingComunitario = parkingComunitario;
	}
	public boolean isGarajePrivado() {
		return garajePrivado;
	}
	public void setGarajePrivado(boolean garajePrivado) {
		this.garajePrivado = garajePrivado;
	}
	public boolean isVideoportero() {
		return videoportero;
	}
	public void setVideoportero(boolean videoportero) {
		this.videoportero = videoportero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ascensor ? 1231 : 1237);
		result = prime * result + (energiaSolar ? 1231 : 1237);
		result = prime * result + (garajePrivado ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (parkingComunitario ? 1231 : 1237);
		result = prime * result + (servPorteria ? 1231 : 1237);
		result = prime * result + (trastero ? 1231 : 1237);
		result = prime * result + (videoportero ? 1231 : 1237);
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
		ExtrasFinca other = (ExtrasFinca) obj;
		if (ascensor != other.ascensor)
			return false;
		if (energiaSolar != other.energiaSolar)
			return false;
		if (garajePrivado != other.garajePrivado)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (parkingComunitario != other.parkingComunitario)
			return false;
		if (servPorteria != other.servPorteria)
			return false;
		if (trastero != other.trastero)
			return false;
		if (videoportero != other.videoportero)
			return false;
		return true;
	}
	
	
	
}

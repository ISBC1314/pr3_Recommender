package es.ucm.fdi.isbc.viviendas.representacion;

import jcolibri.cbrcore.Attribute;
import jcolibri.cbrcore.CaseComponent;

public class DescripcionVivienda implements CaseComponent{

	public enum TipoVivienda {Atico, Plantabaja, Piso, Loft, Casaadosada, CasaChalet, Duplex, Estudio, Fincarustica, Apartamento}
	public enum EstadoVivienda { Muybien, Reformado, Areformar, Casinuevo, Bien};
	
	Integer id;
	
	String titulo;
	String localizacion;
	String urlFoto;
	String url;
	
	TipoVivienda tipo;
	
	Integer superficie;
	Integer habitaciones;
	Integer banios;
	EstadoVivienda estado;
	String descripcion;
	
	Coordenada coordenada;
	
	Integer precio;
	Integer precioMedio;
	Integer precioZona;
	
	
	ExtrasFinca extrasFinca;
	ExtrasBasicos extrasBasicos;
	ExtrasOtros extrasOtros;
	
	
	public DescripcionVivienda(int id)
	{
		super();
		this.id = id;
	}
	
	
	public DescripcionVivienda(String stringRep)
	{
		String[] values = stringRep.split("#");
		id = Integer.valueOf(values[0]);
		titulo = values[1];
		localizacion = getLocalizacionFromUrl(values[4]);
		urlFoto = values[3];
		url = values[4];
		
		tipo = TipoVivienda.valueOf(values[5]);
		
		superficie = Integer.valueOf(values[6]);
		habitaciones= Integer.valueOf(values[7]);
		banios= Integer.valueOf(values[8]);
		estado= EstadoVivienda.valueOf(values[9]);
		
		coordenada = new Coordenada(Double.valueOf(values[10]),Double.valueOf(values[11]));
			
		precio= Integer.valueOf(values[12]);
		precioMedio= Integer.valueOf(values[13]);
		precioZona= Integer.valueOf(values[14]);
		
		
		extrasFinca= new ExtrasFinca(values[15]);
		extrasBasicos= new ExtrasBasicos(values[16]);
		extrasOtros= new ExtrasOtros(values[17]);
		
		descripcion = values[18];

	}
	

	@Override
	public String toString() {
		return "DescripcionVivienda [id=" + id + ", titulo=" + titulo + ", localizacion=" + localizacion + ", urlFoto="
				+ urlFoto + ", url=" + url + ", tipo=" + tipo + ", superficie=" + superficie + ", habitaciones="
				+ habitaciones + ", banios=" + banios + ", estado=" + estado + ", descripcion=" + descripcion
				+ ", coordenada=" + coordenada + ", precio=" + precio + ", precioMedio=" + precioMedio
				+ ", precioZona=" + precioZona + ", extrasFinca=" + extrasFinca + ", extrasBasicos=" + extrasBasicos
				+ ", extrasOtros=" + extrasOtros + "]";
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoVivienda getTipo() {
		return tipo;
	}

	public void setTipo(TipoVivienda tipo) {
		this.tipo = tipo;
	}

	public ExtrasFinca getExtrasFinca() {
		return extrasFinca;
	}
	public void setExtrasFinca(ExtrasFinca extrasFinca) {
		this.extrasFinca = extrasFinca;
	}
	public ExtrasBasicos getExtrasBasicos() {
		return extrasBasicos;
	}
	public void setExtrasBasicos(ExtrasBasicos extrasBasicos) {
		this.extrasBasicos = extrasBasicos;
	}
	public ExtrasOtros getExtrasOtros() {
		return extrasOtros;
	}
	public void setExtrasOtros(ExtrasOtros extrasOtros) {
		this.extrasOtros = extrasOtros;
	}
	
	public String getLocalizacion() {
		return localizacion;
	}
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	public Coordenada getCoordenada() {
		return coordenada;
	}
	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public Integer getSuperficie() {
		return superficie;
	}
	public void setSuperficie(Integer superficie) {
		this.superficie = superficie;
	}
	public Integer getHabitaciones() {
		return habitaciones;
	}
	public void setHabitaciones(Integer habitaciones) {
		this.habitaciones = habitaciones;
	}
	public Integer getBanios() {
		return banios;
	}
	public void setBanios(Integer banios) {
		this.banios = banios;
	}
	public EstadoVivienda getEstado() {
		return estado;
	}
	public void setEstado(EstadoVivienda estado) {
		this.estado = estado;
	}
	public String getUrlFoto() {
		return urlFoto;
	}
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public Integer getPrecioMedio() {
		return precioMedio;
	}
	public void setPrecioMedio(Integer precioMedio) {
		this.precioMedio = precioMedio;
	}
	public Integer getPrecioZona() {
		return precioZona;
	}
	public void setPrecioZona(Integer precioZona) {
		this.precioZona = precioZona;
	}

	@Override
	public Attribute getIdAttribute() {
		return new Attribute("id", DescripcionVivienda.class);
	}
	
	private String getLocalizacionFromUrl(String url){		
		String[] split = url.split("/");
		return (split[4]);	
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((banios == null) ? 0 : banios.hashCode());
		result = prime * result + ((coordenada == null) ? 0 : coordenada.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((extrasBasicos == null) ? 0 : extrasBasicos.hashCode());
		result = prime * result + ((extrasFinca == null) ? 0 : extrasFinca.hashCode());
		result = prime * result + ((extrasOtros == null) ? 0 : extrasOtros.hashCode());
		result = prime * result + ((habitaciones == null) ? 0 : habitaciones.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((localizacion == null) ? 0 : localizacion.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		result = prime * result + ((precioMedio == null) ? 0 : precioMedio.hashCode());
		result = prime * result + ((precioZona == null) ? 0 : precioZona.hashCode());
		result = prime * result + ((superficie == null) ? 0 : superficie.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((urlFoto == null) ? 0 : urlFoto.hashCode());
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
		DescripcionVivienda other = (DescripcionVivienda) obj;
		if (banios == null) {
			if (other.banios != null)
				return false;
		} else if (!banios.equals(other.banios))
			return false;
		if (coordenada == null) {
			if (other.coordenada != null)
				return false;
		} else if (!coordenada.equals(other.coordenada))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (estado != other.estado)
			return false;
		if (extrasBasicos == null) {
			if (other.extrasBasicos != null)
				return false;
		} else if (!extrasBasicos.equals(other.extrasBasicos))
			return false;
		if (extrasFinca == null) {
			if (other.extrasFinca != null)
				return false;
		} else if (!extrasFinca.equals(other.extrasFinca))
			return false;
		if (extrasOtros == null) {
			if (other.extrasOtros != null)
				return false;
		} else if (!extrasOtros.equals(other.extrasOtros))
			return false;
		if (habitaciones == null) {
			if (other.habitaciones != null)
				return false;
		} else if (!habitaciones.equals(other.habitaciones))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (localizacion == null) {
			if (other.localizacion != null)
				return false;
		} else if (!localizacion.equals(other.localizacion))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (precioMedio == null) {
			if (other.precioMedio != null)
				return false;
		} else if (!precioMedio.equals(other.precioMedio))
			return false;
		if (precioZona == null) {
			if (other.precioZona != null)
				return false;
		} else if (!precioZona.equals(other.precioZona))
			return false;
		if (superficie == null) {
			if (other.superficie != null)
				return false;
		} else if (!superficie.equals(other.superficie))
			return false;
		if (tipo != other.tipo)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (urlFoto == null) {
			if (other.urlFoto != null)
				return false;
		} else if (!urlFoto.equals(other.urlFoto))
			return false;
		return true;
	}



	
}

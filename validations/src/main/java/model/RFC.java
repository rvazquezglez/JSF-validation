package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RFC {
	private String siglas;
	private Date fecha;
	private String homonimia;
	private boolean moral;

	public String getSiglas() {
		return siglas;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		sdf.setLenient(false);
		
		return siglas + sdf.format(fecha) + homonimia;
	}

	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHomonimia() {
		return homonimia;
	}

	public void setHomonimia(String homonimia) {
		this.homonimia = homonimia;
	}

	public boolean isMoral() {
		return moral;
	}

	public void setMoral(boolean moral) {
		this.moral = moral;
	}

}

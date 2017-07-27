package com.msd.ham.models;

public class ventas {
	private Integer idVentas;
	private Integer brickVentas;
	private Integer idProducto;
	private Integer anioVenta;
	private Integer mesVenta;
	private String rutaVenta;
	private Integer factorVenta;
	private Integer uniVenta;
	private Integer valVenta;

	public Integer getIdVentas() {
		return idVentas;
	}

	public void setIdVentas(Integer idVentas) {
		this.idVentas = idVentas;
	}

	public Integer getBrickVentas() {
		return brickVentas;
	}

	public void setBrickVentas(Integer brickVentas) {
		this.brickVentas = brickVentas;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getAnioVenta() {
		return anioVenta;
	}

	public void setAnioVenta(Integer anioVenta) {
		this.anioVenta = anioVenta;
	}

	public Integer getMesVenta() {
		return mesVenta;
	}

	public void setMesVenta(Integer mesVenta) {
		this.mesVenta = mesVenta;
	}

	public String getRutaVenta() {
		return rutaVenta;
	}

	public void setRutaVenta(String rutaVenta) {
		this.rutaVenta = rutaVenta;
	}

	public Integer getFactorVenta() {
		return factorVenta;
	}

	public void setFactorVenta(Integer factorVenta) {
		this.factorVenta = factorVenta;
	}

	public Integer getUniVenta() {
		return uniVenta;
	}

	public void setUniVenta(Integer uniVenta) {
		this.uniVenta = uniVenta;
	}

	public Integer getValVenta() {
		return valVenta;
	}

	public void setValVenta(Integer valVenta) {
		this.valVenta = valVenta;
	}

	public ventas() {
		super();
	}

	public ventas(Integer idVentas, Integer brickVentas, Integer idProducto, Integer anioVenta, Integer mesVenta,
			String rutaVenta, Integer factorVenta, Integer uniVenta, Integer valVenta) {
		super();
		this.idVentas = idVentas;
		this.brickVentas = brickVentas;
		this.idProducto = idProducto;
		this.anioVenta = anioVenta;
		this.mesVenta = mesVenta;
		this.rutaVenta = rutaVenta;
		this.factorVenta = factorVenta;
		this.uniVenta = uniVenta;
		this.valVenta = valVenta;
	}

	@Override
	public String toString() {
		return "ventas [idVentas=" + idVentas + ", brickVentas=" + brickVentas + ", idProducto=" + idProducto
				+ ", anioVenta=" + anioVenta + ", mesVenta=" + mesVenta + ", rutaVenta=" + rutaVenta + ", factorVenta="
				+ factorVenta + ", uniVenta=" + uniVenta + ", valVenta=" + valVenta + "]";
	}
	
}

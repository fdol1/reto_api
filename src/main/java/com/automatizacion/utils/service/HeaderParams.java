package com.automatizacion.utils.service;

public enum HeaderParams {

	CONTENT_TYPE("Content-Type"),
	APPLICATION_JSON("application/json"),
	ACCEPT("Accept"),
	COOKIE("Cookie"),
	AUTHORIZATION("Authorization"),
	AUTHORIZATION_VALUE("Basic YWRtaW46cGFzc3dvcmQxMjM=");

	private String nombre;

	HeaderParams(String nombre) {
		this.nombre = nombre;
	}

	public String getName() {
		return nombre;
	}

}




package com.rvmsoft.sisventas.constant;

public final class SisVentasConstant {
	
	//API VERSION
	public static final String API_VERSION = "/v1";
	
	//PATH DEL SISTEMA DE VENTAS
	public static final String RESOURCE_GENERIC = API_VERSION + "/sisventas";
	public static final String RESOURCE_UNIDAD_MEDIDAS = "/unidadMedidas";
	public static final String RESOURCE_UNIDAD_MEDIDA = "/unidadMedida";
	public static final String RESOURCE_GENERIC_ID = "/{id}";
	
	public static final String RESOURCE_UNIDAD_MEDIDA_KEY = "/unidadMedidaKey";
	
	public static final String CLIENT_FRONTEND = "*";
	
	// CLIENT ERRORS
		public static final String BAD_REQUEST = "401";
		public static final String UNAUTHORIZED = "402";
		public static final String FORBIDDEN = "403";
		public static final String NOT_FOUND = "404";
		public static final String METHOD_NOT_ALLOWED = "405";
		public static final String NOT_ACCEPTABLE = "406";
		public static final String CONFLICT = "409";
		public static final String UNPROCESSABLE_ENTITY = "422";
		public static final String EXPECTATION_FAILED = "417";
		public static final Float NR_VUELTO_DEFAULT = (float) 0;
		public static final String VC_NRO_DOCUMENTO = "10469643595";
		public static final String VC_TYPE_SALE = "CONTADO";
		public static final String VC_NR_TELEPHONE = "954395553";

		// SERVER ERRORS
		public static final String INTERNAL_SERVER_ERROR = "500";
		public static final String NOT_IMPLEMENTED = "502";
		public static final String BAD_GATEWAY = "503";
		public static final String SERVICE_UNAVAILABLE = "504";
		public static final String GATEWAY_TIMEOUT = "505";
		public static final String NOT_VALIDATED = "506";

		// ERRORS
		public static final String PREFIX_SERVER_ERROR = "SRV";
		public static final String PREFIX_CLIENT_ERROR = "CLI";

}

package com.test.api.enums;

/**
 * Categorias de articulos de Mercado Libre.
 * 
 * @author Gustavo Borello
 *
 */
public enum Category {
	MOTO("MLA1763");

	private String value;

	Category(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}

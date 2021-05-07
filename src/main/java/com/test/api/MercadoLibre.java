package com.test.api;

import org.springframework.web.client.RestTemplate;

import com.test.api.enums.Category;
import com.test.api.wrappers.ItemsSearchResponse;

/**
 * Interfase REST con Mercado Libre.
 * 
 * @author Gustavo Borello
 *
 */
public class MercadoLibre {

	private MercadoLibre() {}
	
	/**
	 * Devuelve el total de publicaciones que existen para la categoria indicada.
	 * 
	 * @param categoria categoría de item a filtrar.
	 * @return t
	 */
	public static int getTotalByCategory(Category category) {
		ItemsSearchResponse responseEntity = getPublicationsByCategory(category, 0, 1);
		return Integer.parseInt(responseEntity.getPaging().getTotal());
	}
	
	/**
	 * Devuelve los items publicados para la categoría indicada.
	 * 
	 * @param categoria categoría de item a filtrar.
	 * @param offset desplazamiento desde el item 0
	 * @param limit cantidad de resultados devueltos. No puede exceder 50.
	 * @return ItemsSearchResponse resultados
	 */
	public static ItemsSearchResponse getPublicationsByCategory(Category category, int offset, int limit) {
		RestTemplate restTemplate = new RestTemplate();
		String requestURL = "https://api.mercadolibre.com/sites/MLA/search?category={id}&offset={offset}&limit={limit}";

		ItemsSearchResponse responseEntity = restTemplate.getForObject(requestURL, ItemsSearchResponse.class,
				category.getValue(), offset, limit);

		return responseEntity;
	}

}

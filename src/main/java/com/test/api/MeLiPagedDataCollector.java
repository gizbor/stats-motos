package com.test.api;

import com.test.api.enums.Category;
import com.test.api.wrappers.ItemsSearchResponse;
import com.test.stats.reports.PagedDataStore;

/**
 * Colector de información paginada de categorias.
 * 
 * @author Gustavo Borello
 *
 */
public class MeLiPagedDataCollector extends Thread {
	
	private PagedDataStore data;
	private int offset;
	private int limit;
	private Category category;
	
	public MeLiPagedDataCollector(PagedDataStore data, Category category, int offset, int limit) {
		this.data = data;
		this.limit = limit;
		this.offset = offset;
		this.category = category;
	}
	
    public void run() {
		ItemsSearchResponse items = MercadoLibre.getPublicationsByCategory(this.category, this.offset, this.limit);
	
		for (ItemsSearchResponse.Result result : items.getResults()) {
			data.add(result);
		}		
    }
            
}

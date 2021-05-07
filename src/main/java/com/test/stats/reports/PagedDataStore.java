package com.test.stats.reports;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import com.test.api.wrappers.ItemsSearchResponse;

/**
 * Contenedor thread-safe de datos paginados recolectados desde Mercado Libre.
 * 
 * @author Gustavo Borello
 *
 */
public class PagedDataStore {
	
	private Map<String, ArrayList<Double>> data = new Hashtable<String, ArrayList<Double>>();
	private Long totalAppended = 0L;
	private Long totalAnalized = 0L;
	
	public synchronized void add(ItemsSearchResponse.Result result) {
		totalAnalized++;
		if (result.getCondition().compareTo("new")==0) {
			Double price = Double.parseDouble(result.getPrice());
			String brand = result.getAttribute("marca");
			if (!data.containsKey(brand)) {
				data.put(brand, new ArrayList<Double>());
			}
			data.get(brand).add(price);
			totalAppended++;
		}
	}
	
	/**
	 * Imprime reporte del precios promedio por marca de producto.
	 */
	public void printReportMeanPricePerBrand() {
        Set<String> keys = data.keySet();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Reporte Motos Nuevas: Precios promedio por marca en Argentina");
        System.out.println("-------------------------------------------------------------------------------");
        for(String key: keys){
            System.out.print("- "+key.toUpperCase()+" - ");
            
            Double total=0D;
            for (Double price : data.get(key)) {
				total+=price;
			}
            
            Double mean = total / data.get(key).size();
            System.out.println(Math.round(mean)+" ARS$");
        }
        System.out.println("-------------------------------------------------------------------------------");
		System.out.println("- TOTAL DE REGISTROS ANALIZADOS="+this.getTotalAnalized());
		System.out.println("- TOTAL MOTOS ANALIZADAS (SOLO NUEVAS)="+this.getTotalAppended());
		System.out.println("-------------------------------------------------------------------------------");
	}

	private Long getTotalAppended() {
		return totalAppended;
	}

	private Long getTotalAnalized() {
		return totalAnalized;
	}
		
}

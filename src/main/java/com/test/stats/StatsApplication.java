package com.test.stats;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.test.api.MeLiPagedDataCollector;
import com.test.api.MercadoLibre;
import com.test.api.enums.Category;
import com.test.stats.core.exceptions.OutOfRangeException;
import com.test.stats.reports.PagedDataStore;

@SpringBootApplication
public class StatsApplication {

	public static void main(String[] args) {
		generateReport(900, Category.MOTO);	
		System.out.println("Fin del proceso.");
	}
	
	/**
	 * Genera el reporte principal.
	 * 
	 * @param fetchUptoRegister cantidad total de registros a analizar.
	 * @param category categoría de artículo a analizar.
	 */
	private static void generateReport(int fetchUptoRegister, Category category) {		
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("Iniciando generación de reporte...");
		System.out.println("-------------------------------------------------------------------------------");
		PagedDataStore data = new PagedDataStore();
		List<Thread> threads = new ArrayList<>();
				
		try {
			if (fetchUptoRegister > 1000) {
				throw new OutOfRangeException("La máxima cantidad de registros permitida por Mercado Libre es de 1000 sin un access_token");
			}
			
			int total = MercadoLibre.getTotalByCategory(category);
			if (fetchUptoRegister > total) {
				throw new OutOfRangeException("La cantidad excede el total. El total de publicaciones para dicha categoria en Mercado Libre es de "+total);
			}
			
			System.out.println("Publicaciones totales="+total);
			int limit = 50;
			int offset = 0;	
			boolean subrangeReached = false;
			while ( !subrangeReached ) {				
				MeLiPagedDataCollector dataRetriever2 = 
							new MeLiPagedDataCollector(data, category, offset, limit);
				System.out.println("Iniciando hilo [offset="+offset+"|limit="+limit+"] "
						+ "-> Rango=["+offset+","+(offset+limit)+"]...");
				threads.add(dataRetriever2);
				dataRetriever2.start();

				subrangeReached = (fetchUptoRegister > offset && fetchUptoRegister <= (offset+limit));
				if (!subrangeReached) {
					offset += limit;
					// Si el limite superior es mas alto que el total de registros.
					if (offset + limit > total) { 
						limit = total - offset;
					} else if (offset + limit > fetchUptoRegister) {
						limit = fetchUptoRegister - offset;
					}
				}
			}
			
			System.out.println("Esperando respuesta...");
			for (Thread thread : threads) {
				thread.join();
			}
			
			data.printReportMeanPricePerBrand();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (OutOfRangeException e) {
			e.printStackTrace();
		}
	}

}

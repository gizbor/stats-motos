package com.test.api.wrappers;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Wrapper de datos necesarios para generación de reporte.
 * 
 * @author Gustavo Borello
 *
 */
public class ItemsSearchResponse {
	private Paging paging;
	private List<Result> results;
	
	public static class Paging {
		public String total;
		public String primary_results;
		public String offset;
		public String limit;

		public String getPrimary_results() {
			return primary_results;
		}
		public void setPrimary_results(String primary_results) {
			this.primary_results = primary_results;
		}
		public String getOffset() {
			return offset;
		}
		public void setOffset(String offset) {
			this.offset = offset;
		}
		public String getLimit() {
			return limit;
		}
		public void setLimit(String limit) {
			this.limit = limit;
		} 
		public String getTotal() {
			return total;
		}
		public void setTotal(String total) {
			this.total = total;
		}
	}
	
	public static class Result {
		static class Attribute {
			public String name;
			public String value_name;
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getValue_name() {
				return value_name;
			}
			public void setValue_name(String value_name) {
				this.value_name = value_name;
			}
		} 
		
		public String id;
		public String title;
		public String price;
		public String condition;
		private List<Attribute> attributes;
		private Map<String, String> hashedAttributes = null;
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getCondition() {
			return condition;
		}
		public void setCondition(String condition) {
			this.condition = condition;
		}
		public List<Attribute> getAttributes() {
			return attributes;
		}
		public void setAttributes(List<Attribute> attributes) {
			this.attributes = attributes;
		} 
		public String getAttribute(String name) {
			if (hashedAttributes == null) {
				hashedAttributes = new Hashtable<String, String>();
				for (Attribute attribute : attributes) {
					if (attribute.getName() != null && attribute.getValue_name()!=null) {
						hashedAttributes.put(attribute.getName().toLowerCase(), attribute.getValue_name());
					} else {
						System.out.println("WARN: valor vacio");
					}
				}
			}
			
			return hashedAttributes.get(name.toLowerCase());
		}
	}
	
	public List<Result> getResults() {
		return results;
	}
	public void setResults(List<Result> results) {
		this.results = results;
	}
	public Paging getPaging() {
		return paging;
	}
	public void setPaging(Paging paging) {
		this.paging = paging;
	}
	
	
}

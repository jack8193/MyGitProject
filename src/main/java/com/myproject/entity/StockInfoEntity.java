package com.myproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock_info")
public class StockInfoEntity {

	@Id
	@Column(name="stock_id")
	private String stockId;
	
	@Column(name="stock_name")
	private String stockName;
	
	@Column(name="stock_category")
	private String stockCategory;

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getStockCategory() {
		return stockCategory;
	}

	public void setStockCategory(String stockCategory) {
		this.stockCategory = stockCategory;
	}	
	
}

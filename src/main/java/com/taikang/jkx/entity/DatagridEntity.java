package com.taikang.jkx.entity;

import java.util.ArrayList;
import java.util.List;

public class DatagridEntity {
	
	private int total;
	private List<SanmuAll> rows  = new ArrayList<SanmuAll>();
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<SanmuAll> getRows() {
		return rows;
	}
	public void setRows(List<SanmuAll> rows) {
		this.rows = rows;
	}
}

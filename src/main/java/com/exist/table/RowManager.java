package com.exist.table;

import java.util.ArrayList;

public class RowManager implements Table {
	private ArrayList<Row> rowList = new ArrayList<>();;
	private FileManager fileManager;
	public RowManager(){}
	public RowManager (FileManager fileManager) {
		this.fileManager = fileManager;
	}

	public void search(String pattern) {
		int total = 0;
		for(Row row: rowList) {
			row.search(pattern);
			total += row.getOccurence();
		}
		System.out.println(total + " total occurence/s");
	}

	public void print() {
		rowList.forEach(Table::print);
	}

	public void sort() {
		rowList.forEach(Table::sort);
	}

	public void changeKey(String value) throws Exception{
		rowList.get(InputManager.getPositiveNumber("Row Number")).changeKey(value);
		save();
	}

	public void changeValue(String value) throws Exception {
		rowList.get(InputManager.getPositiveNumber("Row Number")).changeValue(value);
		save();
	}

	public void save() {
		fileManager.writer("",false);
		rowList.forEach(row->row.save(fileManager));
		
	} 

	public void add(int rowNumber) throws Exception {
		if(rowNumber <= rowList.size()) {
			if(rowNumber == rowList.size())
				rowList.add(new Row());
			rowList.get(rowNumber).add();
		}
	}

	public void load() {
		fileManager.reader().forEach(r -> rowList.add(new Row(r)));
	}

	public void createTable(int row, int cols) throws Exception {
		rowList.clear();
		fileManager.writer("",false);
		for(int i = 0; i < row; i++) {
			rowList.add(new Row());
		}

		for(Row r : rowList) {
			r.createTable(cols);
		}
		save();
	}


}
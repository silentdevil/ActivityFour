package com.exist.table;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Row extends RowManager {

	private ArrayList<Cell> cellList = new ArrayList<>();
	private static int counter;
	private int id = counter++;
	private int occurence;

	public Row() {}

	public Row(String stream) {
		List<String> stringList = Regex.tokenizer(stream);
		stringList.forEach(s  -> cellList.add(new Cell(s)));
	}

	public int getOccurence() {
		return occurence;
	}

	public void search(String pattern) {
		occurence = 0;
		for(Cell cell : cellList) {
			cell.search(pattern);
			occurence += cell.getKeyOccurence() + cell.getValOccurence();
		}
		if(occurence > 0) {
			System.out.println(occurence + " total occurences in Row" + id);
		}	
	}

	public void add() throws Exception {
			cellList.add(CellFactory.createCell(InputManager.enterKey("Key"), InputManager.enterString("Value")));
	}

	public void print() {
		cellList.forEach(Cell::print);
		System.out.println();
	}

	public void sort() {
		Collections.sort(cellList);
		print();
	}

	public void changeKey(String value) throws Exception {
		cellList.get(InputManager.getPositiveNumber("Column number: ")).changeKey(value);
	}

	public void changeValue(String value) throws Exception {
		cellList.get(InputManager.getPositiveNumber("Column number: ")).changeValue(value);
	}

	public void save(FileManager fileManager) {
		cellList.forEach(cell -> cell.save(fileManager));
		fileManager.writer("\n",true);
	}

	public void createTable(int cols) throws Exception {
		for(int i = 0; i < cols; i++) {
			cellList.add(CellFactory.newCell());
		}
	}


}
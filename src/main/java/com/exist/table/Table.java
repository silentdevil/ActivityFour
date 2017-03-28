package com.exist.table;

interface Table {
	void search(String pattern);
	void print();
	void sort();
	void changeValue(String value) throws Exception;
	void changeKey(String key) throws Exception;
	void createTable(int row, int col) throws Exception;
	void save();
}
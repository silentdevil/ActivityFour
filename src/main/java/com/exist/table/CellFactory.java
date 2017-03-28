package com.exist.table;
import java.util.HashSet;

public class CellFactory {
	private static HashSet<Cell> cellSet = new  HashSet<>();
	private static HashSet<String> keySet = new HashSet<>();

	public static Cell newCell() throws Exception  {
		String key = InputManager.randomizeChar(65,90,3,6);
		String value = InputManager.randomizeChar(65,90,3,6);
		return createCell(key,value);
	}

	public static Cell createCell(String key, String value) throws Exception {
		
		addKey(key);
		Cell cell = new Cell(key, value);

		if(!cellSet.add(cell)) {
			throw new RuntimeException("Duplicate");
		}

		return cell;
	}

	public static void addKey(String key) throws Exception {
		if(!keySet.add(key)) {
			throw new Exception("Duplicate Key");
		}
	}

	public static boolean containsKey(String key) {
		return keySet.contains(key);
	}

	public static void removeKey(String key) {
		keySet.remove(key);
	}
}
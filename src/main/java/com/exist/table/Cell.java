package com.exist.table;
public class Cell implements Comparable<Cell>{

	private String key;
	private String value;
	private int keyOccurence;
	private int valOccurence;
	
	public Cell (String K, String V) {
		key = K;
		value = V;
	}

	public Cell(String stream) {
		try {
			String[] split = stream.split(",");

			key = split[0];
			value = split[1];

		
			CellFactory.addKey(key);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public int getKeyOccurence() {
		return keyOccurence;
	}

	public int getValOccurence() {
		return valOccurence;
	}

	public void search(String pattern) {
		keyOccurence = valOccurence = 0;
		keyOccurence = Regex.occurence(key, pattern);
		valOccurence = Regex.occurence(value, pattern);

		if(keyOccurence + valOccurence > 0) {
			print();
			System.out.println("\tkey : " + keyOccurence + ", value : " + valOccurence);
		}

	}

	public void print() {
		System.out.print ("\t(" + key.trim() + "," + value.trim() + ")\t");
	}

	public void changeKey(String value) throws Exception {
		CellFactory.addKey(value);
		CellFactory.removeKey(key);
		this.key = value;
	}

	public void changeValue(String value) throws Exception {
		this.value = value;
	}

	public void save(FileManager fileManager) {
		fileManager.writer("(" + key + "," + value + ")",true);
	}
	 @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Cell)) {
            return false;
        }
        Cell cell = (Cell) o;
        return java.util.Objects.equals(key, cell.getKey());
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(key);
    }
	
	public int compareTo(Cell c) {
		return key.compareTo(c.getKey());
	}
	
}
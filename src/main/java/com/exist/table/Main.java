package com.exist.table;

public class Main {

	public static void main(String[] args) {
		
		FileManager fileManager = new FileManager();
		RowManager table = new RowManager(fileManager);

		table.load();	
		outer:
		while(true) {
			try {
				System.out.println("What to do: ");
				for(int i = 1; i <= TableFunctions.SIZE; i++) {
					System.out.print(TableFunctions.valueOf(i) + "\t"); 
				}
				System.out.println();
				switch(TableFunctions.valueOf(InputManager.getPositiveNumber(""))) {
					case SEARCH: table.search(InputManager.enterString("What to search: ")); break;
					case CHANGEKEY:	table.changeKey(InputManager.enterKey("NEW")); table.print(); break;
					case CHANGEVALUE:	table.changeValue(InputManager.enterString("New Value")); table.print(); break;
					case ADDCELL:	table.add(InputManager.getPositiveNumber("Row Number")); table.print(); break;
					case SAVE: table.save(); break;
					case PRINT:	table.print(); break;
					case CREATE: table.createTable(InputManager.getPositiveNumber("rows"),
							InputManager.getPositiveNumber("cols"));break;
					case EXIT: break outer;
				}
			} catch(Exception ex) {
				System.out.println(ex);
			}
		}
	}
}

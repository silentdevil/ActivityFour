package com.exist.table;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileManager {

	private File file;

	public FileManager(File file) {
		this.file = file;
	}

	public File() {
		file = new File("//home//jmcarpio//table//builds//files//default.txt");
	}
	
	List<String> stringLine;

	public File getFile() {
		return file;
	}

	public void writer (String text,boolean append) {
		try {
			FileUtils.writeStringToFile(file,text,"UTF-8", append);
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public List<String> reader() {
		
		try {
			stringLine = FileUtils.readLines(file,"UTF-8");
		} catch(Exception ex) {
			writer("", false);
			reader();
		}

		return stringLine;
	}
	
}


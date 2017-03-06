import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fileManagerAPI.FileWriter;


public class Writer extends FileWriter{
	
	private List< String> lines = new ArrayList< String>();

	public Writer(String path, Boolean isRelative, Boolean appendFile) {
		super(path, isRelative, appendFile);
	}

	@Override
	public Object manipulateFile() {
		
		try {
			this.openFile();
			BufferedWriter mani = this.getFileMatipolator();
			for( String s : lines){
				mani.write( s);
				mani.newLine();
			}
			this.closeFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public void setLines(List<String> lines) {
		this.lines = lines;
	}
	
}

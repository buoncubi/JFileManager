import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fileManagerAPI.FileReader;


public class Reader extends FileReader{

	private List< String> readed = new ArrayList< String>();
	
	public Reader(String path, Boolean isRelative) {
		super(path, isRelative);
	}

	@Override
	public Object manipulateFile() {
		
		try {
			this.openFile();
			BufferedReader wr = this.getFileMatipolator();
			String line = wr.readLine();
			while( line != null){
				
				readed.add( line);
				
				line = wr.readLine();
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> getReaded() {
		return readed;
	}
	
}

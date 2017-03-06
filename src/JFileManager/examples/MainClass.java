import java.util.ArrayList;
import java.util.List;


public class MainClass {

	public static void main(String[] args) {
		List< String> toWrite = new ArrayList< String>();
		for( int i = 0; i < 100; i++){
			toWrite.add( "nuova linea " + i);
		}

		
		Writer wr = new Writer( "files/primo.txt", true, true);
		wr.setLines( toWrite);
		wr.manipulateFile();
		
		Reader  re = new Reader( "files/primo.txt", true);
		re.manipulateFile();
		List< String> readed = re.getLines();
		
		System.out.println( readed);
		
		

	}

}

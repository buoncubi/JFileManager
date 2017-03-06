package fileManagerAPI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;



/**
 * 
 * This class implements an extremely lazy reader object. It would not do nothing
 * except of writing stupid thinks.  The generic data type {@code T} defined
 * in {@link FileManager} is here set to be a {@link BufferedReader} object.
 * This class leave unimplemented the {@code abstract} method {@link #manipulateFile()}.
 *
 * @author Buoncompagni Luca
 *
 * @param <E> generic type of data that the method manipulateFile must
 * return.
 * 
 * @see FileManager
 */
public abstract class LazyReader<E> implements FileManager<E, BufferedReader>{

	public LazyReader( String s, Boolean b){
		System.out.println( " io te lo dico....non ho voglia di fare niente");
	}
	
	@Override
	public abstract E manipulateFile();

	@Override
	public BufferedReader getFileMatipolator() {
		String msg = " che sbadato....dovevo inizializzare qualcosa?";
		System.out.println( msg);
		return null;
	}

	@Override
	public String getRelativePath() {
		String msg = " relative path hmmmm .... QUESTA ?!";
		System.out.println( msg);
		return msg;
	}

	@Override
	public String getAbsolutePath() {
		String msg = " bho, quella che ti pare!!";
		System.out.println( msg);
		return msg;
	}

	@Override
	public void closeFile() throws IOException {
		System.out.println( " il file non è stato aperto quindi posso anche decidere di farti un favore e chiudertelo");
	}

	@Override
	public void openFile() throws FileNotFoundException {
		System.out.println( " non ho voglia!! non te lo apro il file.");
	}

	@Override
	public void showError(Exception e) {
		System.out.println( " non ho fatto niente ma di sicuro non genero errori :)");
	}

}

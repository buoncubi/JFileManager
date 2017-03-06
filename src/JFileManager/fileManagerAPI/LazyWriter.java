package fileManagerAPI;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * This class implements an extremely lazy writer object. It would not do nothing
 * except of writing stupid thinks.  The generic data type {@code T} defined
 * in {@link FileManager} is here set to be a {@link BufferedWriter} object.
 * This class leave unimplemented the {@code abstract} method {@link #manipulateFile()}.
 *
 * @param <E> generic type of data that the method manipulateFile must
 * return.
 * 
 * @see FileManager
 * 
 * @author Buoncompagni Luca
 */
public abstract class LazyWriter<E> implements FileManager<E, BufferedWriter>{

	public LazyWriter( String s, Boolean b,  Boolean a){
		System.out.println( " guarda, anche io sono proprio svogliato oggi!!!");
	}
	
	@Override
	public abstract E manipulateFile();

	@Override
	public BufferedWriter getFileMatipolator() {
		System.out.println( " io non ti devo ritornare prprio niente!!!");
		return null;
	}

	@Override
	public String getRelativePath() {
		String msg = " /&%%$%$%/YY&D&D%/HDHD&%%&/ ti sembra una path relativa convinciente?";
		System.out.println( msg);
		return( msg);
	}

	@Override
	public String getAbsolutePath() {
		String msg = " una path assoluta la puoi cercare anche da te con il mouse no?";
		System.out.println( msg);
		return( msg);
	}

	@Override
	public void closeFile() throws IOException {
		String msg = " sinceramente, non sò come chiudere un file che non ho aperto";
		System.out.println( msg);
	}

	@Override
	public void openFile() throws IOException, FileNotFoundException {
		String msg = " lo dice il nome che sono pigro....cosa ti fà pensare che aprirò il file?";
		System.out.println( msg);
	}

	@Override
	public void showError(Exception e) {
		String msg = " niente errori di sicuro!!";
		System.out.println( msg);
	}

	public void setAppendingFile( Boolean append){
		System.out.println( " non mi interessa niente dei tuoi flag");
	}
}

package fileManagerAPI;


import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This interface contains the basic methods used to manipulate a generic file.
 * 
 *  @author Buoncompagni Luca
 *
 * @param <E> generic data type to identify the type of data used to manipulate the file.
 * @param <T> generic data type to identify the type of data returned after data manipulation
 */
public interface FileManager<E,T> {

	/**
	 * Do something on the file. This method need to open, manipulate and close the 
	 * file. It also has to consider possible input/output Exception that this may cause. 
	 * 
	 * @return a generic type of data to notify that all operations has been correctly 
	 * performed. Or it may return a data generated by the manipulations. 
	 */
	public E manipulateFile();
	
	/**
	 * This method is used to get an initialized object which is able to
	 * perform operations over the file.
	 * 
	 * @return a generic object used to manipulate the file.
	 */
	public T getFileMatipolator();
	
	/**
	 * This method is used to get a simplified file path, as long as
	 * it is in the same folder (or sub folders) in which the software is running.
	 * 
	 * @return the path starting from the folder where the program is running.
	 */
	public String getRelativePath();
	
	/**
	 * This method can be used to retrieve the absolute path of
	 * the considered path.
	 * 
	 * @return the directory path starting for the system root.
	 */
	public String getAbsolutePath();
	
	/**
	 * This method is used to close all the connection with the file. 
	 * Possible changes on the file may be available in the file
	 * only when the file has been closed.
	 * 
	 * @throws IOException.
	 */
	public void closeFile() throws IOException;
	
	/**
	 * This method opens a connection with a file. It is not possible
	 * to operate on it before to call this procedure.
	 * 
	 * @throws IOException.
	 * @throws FileNotFoundException.
	 */
	public void openFile() throws IOException, FileNotFoundException;
	
	/**
	 * This method shows informations about possible exceptions generate
	 * during the file manipulations.
	 * 
	 * @param e the type of exception occurs.
	 */
	public void showError( Exception e);
	
/*	public void createFile( T manipulator);
	public void delateFile( T manipulator);
	public void renameFIle( T manipulator);
*/	
}

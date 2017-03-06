import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import myFileManager.Reader;
import myFileManager.Writer;
import fileManagerAPI.FileReader;
import fileManagerAPI.FileWriter;


public class FileManagerRunner {
	
	public static void main(String[] args) {
		
		FileWriter<?> writer1 = createSimpleFile( "files/fristText.txt", true, true);
		String newPath = createAnoterFileInTheSameDirectory( writer1.getAbsolutePath());
		
		synchrounizeFile( writer1.getAbsolutePath(), newPath, false);
	}
	
	private static void synchrounizeFile( String fromThis_path, String toThis_path, Boolean arePathRelative){
		// creo un reader sul primo file
		FileReader<?> reader = new Reader( fromThis_path, arePathRelative);
		// leggo tutte le linee tesutali dal primo file
		reader.manipulateFile();
		// ottengo le linee appena lette
		List<String> lineRead = reader.getLines();
		
		// creo un writer del secondo file (che sovrascrive il contenuto che c'era prima)
		FileWriter<?> writer2 = new Writer( toThis_path, arePathRelative, false);
		// carico la copia del primo file
		writer2.setToAppend( lineRead);
		// la scivo nel seondo
		writer2.manipulateFile();
	}
	
	private static FileWriter<?> createSimpleFile( String path, Boolean isRelativve, Boolean override){
		// creare le linee testuali che si vogliono scrive in un nuovo file
		Integer dimension = new Integer( 100);
		List< String> line = new ArrayList< String>(); 
		for( int i = 1; i <= dimension; i++){
			line.add( "add new line " + i);
		}
		// inizializza l'oggetto writer( path, isRelativePath, toAppend)
		FileWriter<?> writer = new Writer( path , isRelativve, ! override);
		// set le linee da scrivere
		writer.setToAppend( line);
		// scrivi line su file (se nn esiste lo crea)
		writer.manipulateFile();
		
		return( writer);
	}
	
	private static String createAnoterFileInTheSameDirectory( String absolutePath){
		// ottiene il separatore per ogni sistema operativo
		String sepSymb = System.getProperty("file.separator");
		// path assoluta = /Absolute/directory/Path/to/file.tx
		// 				 = /Absolute/directory/Path/to/
		absolutePath = absolutePath.substring( 0, absolutePath.lastIndexOf( sepSymb) + 1);
		// crea un file sempre nella stessa cartella del primo ma con nome diverso
		String newPath = absolutePath + "copyText.txt";
		try {
			File f = new File( newPath);
			FileWriter.createFile( f);
		} catch (IOException e) {
			// stampa se c'è un'errore
			e.printStackTrace();
		}
		return( newPath);
	}
}

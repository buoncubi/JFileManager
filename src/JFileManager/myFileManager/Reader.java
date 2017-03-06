package myFileManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fileManagerAPI.FileReader;
import fileManagerAPI.LazyReader;

			// estende una super classe
@SuppressWarnings("unused")
public class Reader extends FileReader< Boolean>{
					 //extends LazyReader<Boolean>{
	// estende una classe con parametri booleani perchè il
	// metodo manipulateFile() è stato creato in modo da
	// tornare vero se la lettura è andata a buon fine 
	// o false se non
	
	// usa solo il costruttore della super-classe
	public Reader(String path, Boolean isRelative) {
		super(path, isRelative);
	}

	// leggi tutte le righe del file
	@Override
	public Boolean manipulateFile() {
		try {
			this.openFile(); // inizializza manipolatore
			// ottiemi il manipolatore
			BufferedReader reader = this.getFileMatipolator();
			// se non c'è stato nessun errore di input output
			if( reader != null){
				// inizializza list dove verranno racvolti i dati letti
				List<String> lines = new ArrayList<String>();
				// leggi la prossima linea
				String line = reader.readLine();
				// fino a che ci sono nuove linee
				while( line != null){
					// salva una linea nella lista
					lines.add( line);	
					// ottieni la prossima linea
					line = reader.readLine();
				}
				// setta le linee lette nell'atributo della superclasse
				this.setLines( lines);
			}
			// la superclasse si preoccupa degli errori
		} catch (FileNotFoundException e) {
			this.showError( e);
			return( false);
		} catch (IOException e) {
			this.showError( e);
			return( false);
		} finally {
			try {
				// se hai finito con successo 
				// chidi la comunicazione con il file 
				this.closeFile();
			} catch (IOException e) {
				this.showError( e);
				return( false);
			}
		}
		return true;
	}
}

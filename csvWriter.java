/*
 * 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 * 
 * @author Karen Jimena Hernández Ortega
 * @author: Jimena Hernández
 * @version: 01-sep-21
 */

public class csvWriter {
    String cadena;
    File archivo;
    FileReader leer;
    FileWriter escribir;
    PrintWriter linea;
    BufferedReader almacenamiento;
    String texto;
	
	/**
	 * 
@param var Archivo
	*/
    public void crearArchivo(String miArchivo){
 
        archivo = new File(miArchivo);
        if(!archivo.exists()){
            try{
                archivo.createNewFile();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
	
    /**
    * @param datos vehiculos 
    */
    public void write(String m, String mo, String col, String t, int esp, String horaString) throws IOException{

        File file = new File(archivo.getPath());
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(m + ',' + mo + ',' + col + "," + t + "," + esp + "," + horaString);
        bw.newLine();

        bw.close();
        fw.close();
		
		
		
    
    }
}

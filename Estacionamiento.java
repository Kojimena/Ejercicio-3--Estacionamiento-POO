
import java.util.ArrayList;

/**
 *
 * @author Karen Jimena Hernández Ortega
 * @file Estacionamiento.java
 * @version: 01-sep-21
 */
 
public class Estacionamiento{
	private String nombre;
	private String direccion;
	private double precio;
	private ArrayList<Espacioparqueo> espacios = new ArrayList<>();
        
    public Estacionamiento(){
        nombre = "";
        direccion = "";
        precio = 0.0;
        
      
    }
	
    public Estacionamiento(String nombre, String direccion, double precio ){
        this.nombre = nombre;
        this.direccion = direccion;
        this.precio = precio;
        
          for(int i = 0; i < 5; i++){
            double ancho = 5 + (Math.random() * 10);
            double altura = 5 + (Math.random() * 10);
            double largo = 5 + (Math.random() * 10);
            boolean techado = true;
            boolean aereo = false;
            
            Espacioparqueo espacio = new Espacioparqueo(ancho, altura, largo, techado, aereo );
            espacios.add(espacio);

        }
    }
	
    /**
    * @return nombre
    */
    public String getNombre() {
        return nombre;
    }
    /**
    * @return direccion
    */
    public String getDireccion() {
        return direccion;
    }
    /**
    * @return precio
    */
    public double getPrecio() {
        return precio;
    }
    /**
    * @return res
    */
    public String getEspacios2() {
        String res = "";
        for (int i = 0; i < espacios.size(); i++) {
            
            res = res + (i+1) + ". " + espacios.get(i).toString();
            
        }
        
        return res;
    }

    public ArrayList<Espacioparqueo> getEspacios() {
        return espacios;
    }
    
    
    /**
	*Settter setEspacio
    * @return null
    */
    public String setEspacio(){
        if(espacios.size() > 5){
            return "Todos los parqueos estan llenos, intenta creando nuevos parqueos";
        }
        return null;
    }

    
	
}
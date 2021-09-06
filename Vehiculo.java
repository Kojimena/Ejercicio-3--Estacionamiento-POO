
/**
 *
 * @author Karen Jimena Hernández Ortega
 * @file Vehiculo.java
 * @version: 01-sep-21
 */
public class Vehiculo {
    //atributos privados 
	private String tipo;
    private String matricula;
    private String modelo;
    private String color;
    private int espacio;

    public Vehiculo(){
		tipo= "";
        matricula = "";
        modelo = "";
        color = "";
    }

    public Vehiculo(String tipo,String matricula, String modelo, String color, int space){
		this.tipo= tipo;
        this.matricula = matricula;
        this.modelo = modelo;
        this.color = color;
        this.espacio = space;
    }
    /**
    * @param null
    * @return tipo
    */
    public String getTipo() {
        return tipo;
    }
	
    /**
    * @param null
    * @return matricula
    */
    public String getMatricula() {
        return matricula;
    }

    /**
    * @param null
    * @return modelo
    */
    public String getModelo() {
        return modelo;
    }

    /**
    * @param null
    * @return color
    */
    public String getColor() {
        return color;
    }
	
    /**
    *SETTERS
    */
    public void setColor(String color) {
        this.color = color;
    }


    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
	
    /**
    * @param null
    * @return espacio
    */
    public int getEspacio() {
        return espacio;
    }
    
    
    @Override
    public String toString() {
        return "Vehiculo:" + "\nmatricula: " + matricula + " \nmodelo: " + modelo + "\ntipo: " + tipo + "\ncolor: " + color + "\nespacio: " + (espacio + 1);
    }

}
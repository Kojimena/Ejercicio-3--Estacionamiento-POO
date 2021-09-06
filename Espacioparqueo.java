
/**
 *
 * @author Karen Jimena Hernández Ortega
 * @file EspacioParqueo.java
 * @version: 01-sep-21
 */

public class Espacioparqueo{
	private double ancho;
	private double largo;
	private double altura;
	private boolean techado;
	private boolean aereo;
        private boolean carro;
	
	    /**
		*Constuctor
	    * @param ancho, largo, altura, techado, aereo
	    */
		
	public  Espacioparqueo( double ancho, double largo, double altura, boolean techado, boolean aereo){
            
            this.ancho = ancho;
            this.largo = largo;
            this.altura = altura;
            this.techado = techado;
            this.aereo = aereo;
            this.carro = false;
            
	}
        
        public Espacioparqueo(){
            this.ancho = 0;
            this.largo = 0;
            this.altura = 0;
            this.techado = false;
            this.aereo = false;
            
        }

    @Override
    public String toString() {
        return "ancho: " + String.format("%.2f", ancho) + "\n largo: " + String.format("%.2f", largo) + "\n altura: " + String.format("%.2f", altura) + "\n techado: " + techado + "\n aereo: " + aereo +"\n";
    }

    /**
	*Setter de Carro
    * @param null
    */
    public void setCarro() {
        if(carro == false){
            carro = true;
        }
        else{
            carro = false;
        }
    }

    public boolean isCarro() {
        return carro;
    }
    
    
	
    
        
        
}
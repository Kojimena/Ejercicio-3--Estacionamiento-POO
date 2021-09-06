
/**
* @author: Karen Jimena Hernández Ortega
* @version: 01-sep-21
* Esta clase es la vista del programa.Imprime resultados y pide datos.
**/
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;
class Vista{
	Scanner scan = new Scanner(System.in);
	int contador = 0;
	
    /**
    * Despliega el menú de opciones para el usuario. Luego, recibe la opción elegida por el usuario y la devuelve.
    * @return La opción elegida por el usuario
    */
	
    public int menu(){
		int opcion;
		
                System.out.println("\n0. Salir");
                System.out.println("1. Abir estacionamiento (obligatorio para el uso de demás opciones)");
                System.out.println("2. Agregar y asignar lugar a vehiculo");
                System.out.println("3. Agregar espacio parqueo");
                System.out.println("4. Obtener estadísticas");
                System.out.println("5. Ver datos del archivo");
                System.out.println("6. Vaciar- cerrrar estacionamiento");
                System.out.println("7. Mostrar vehiculos");
                System.out.print("Seleccion: ");
		opcion = scan.nextInt();
		scan.nextLine();
		return opcion;
    	}
		
            public void mensaje(String mensaje){
                System.out.println(mensaje);
	    }
                
            public static int checkNumerico(String numero){
                int resultado = 0; //Valor predeterminado 0
                try{
                    if(numero != null){
                        resultado =  Integer.parseInt(numero);

                        if(resultado < 0){
                            resultado = Math.abs(resultado);
                        }
                    }
                }catch(NumberFormatException nfe){
                    System.out.println("Error NumberFormatException value: " + numero);
                }
                return resultado;
              }
            
              public String getNombre(){
                System.out.printf("\nIngrese el nombre del estacionamiento ");

                String nombre = scan.nextLine();

                return nombre;
	    }
		
	    public String getDireccion(){
	      System.out.printf("\nIngrese la dirección del estacionamiento ");

	      String direccion = scan.nextLine();

	      return direccion;
	    }
            
		
	    public double getPrecio(){
                double precio = 0.0;
                String entrada;
                
                while(precio == 0.0){
                    System.out.printf("\nIngrese el precio del estacionamiento ");
                    entrada = scan.nextLine();
                    int res = checkNumerico(entrada);
                    
                    if(res == 0){
                       System.out.printf("Debes ingresar un numero!");
                    }
                    else{
                        precio = res;
                    }
                  
                }
                
                return precio;
             
            }
		
	    /**
	    * Le pide al usuario que ingrese su lugar a estacionar
	    * @return El lugar elegido
	    */
	    public short getLugar(){
	      System.out.printf("\nIngrese el lugar para estacionar el vehiculo: (0~5)");

	      short lugar = scan.nextShort();

	      return lugar;
	    }
		
	    /**
	    * Le pide al usuario que ingrese su lugar a estacionar
	    * @return El lugar a retirar 
	    */
	    public short getLugararetirar(){
	      System.out.printf("\nIngrese el lugar del que quiere retirar el vehiculo: (0~5)");

	      short lugarretiro = scan.nextShort();

	      return lugarretiro;
	    }
		
	    /**
	    * Le pide al usuario que ingrese su lugar a estacionar
	    * @return la matricula 
	    */
	    public String getMatricula(){
	      System.out.printf("\nIngrese la matricula del auto: ");

	      String matricula = scan.nextLine();

	      return matricula;
	    }
		
	    /**
	    * Le pide al usuario que ingrese el tipo
	    * @return El tipo
	    */
	    public String getTipo(){
	      System.out.printf("\nIngrese el tipo de auto: ");

	     String tipo = scan.nextLine();

	     return tipo;
	    }
		
	    /**
	    * Le pide al usuario el modelo
	    * @return El modelo
	    */
	    public String getModelo(){
	      System.out.printf("\nIngrese el modelo: ");

	      String modelo = scan.nextLine();

	      return modelo;
	    }
		
	    /**
	    * Le pide al usuario el color
	    * @return El color
	    */
	    public String getColor(){
	      System.out.printf("\nIngrese el color: ");

	      String color = scan.nextLine();

	      return color;
	    }
		
	    /**
	    * Le pide al usuario el largo
	    * @return El largo
	    */
	    public double getLargo(){
	      System.out.printf("\n Ingrese largo del espacio ");

	      double largo = scan.nextDouble();

	      return largo;
	    }
		
	    /**
	    * Le pide al usuario el ancho
	    * @return El ancho
	    */
	    public double getAncho(){
	      System.out.printf("\n Ingrese ancho del espacio ");

	      double ancho = scan.nextDouble();

	      return ancho;
	    }
		
	    public double getAltura(){
	      System.out.printf("\n Ingrese altura del espacio ");

	      double altura = scan.nextDouble();

	      return altura;
	    }
		
	    /**
	    *
	    * @return contador
	    */
	    public int getContador(){

	      return contador;
	    }
		
	    /**
	    * @param arraylist de espacioparqueo
	    * @return El indice
	    */
		
            public int chooseEstacionamiento(ArrayList<Espacioparqueo> estDis){
              int space = 0;
	      	  String esp;
			  int indice =0;
              
              while(space == 0){
                    System.out.printf("\nIngrese el espacio que desea: ");
                    esp = scan.nextLine();
                    int res = checkNumerico(esp);
                    
                    
                    if(res == 0){
                       System.out.printf("Debes ingresar un numero!");
                    }
                    else{
                        indice = res - 1;
                        if(estDis.get(indice).isCarro() == false){
                            System.out.printf("Carro parqueado en el estacionamiento: " + (res));
							space=1;
                        }
                        else{
                            System.out.printf("El parqueo seleccionado ya tiene un carro");
                           	contador= contador +1;
                        }
                    }
                  
                }
                
                return indice;
             
            }
		
		
		
}

/**
* @author: Karen Jimena Hernández Ortega
* @version: 01-sep-21
* Esta clase es el controlador principal del programa.
**/
import java.io.IOException;
import java.util.ArrayList; // importar clases 
import java.util.HashSet;
import java.util.Collections;

class Controlador{
  /**
  * Main del programa.
  **/
	  
	  /**
	  * Variables instanciadas del programa.
	  **/
    public static void main(String[] args) throws IOException{
        csvWriter csv = new csvWriter();
        int cont = 1;
        ArrayList<Espacioparqueo> espacios = null; 
		ArrayList<String> modelos = new ArrayList<String>();
		ArrayList<String> tipos = new ArrayList<String>();
		ArrayList<Integer> espreferidos = new ArrayList<Integer>();
    	 Vista vista = new Vista();
		 Controlador tVehiculo = new Controlador();
		 Vehiculo vehiculo = new Vehiculo();
		 Espacioparqueo espacioparqueo = new Espacioparqueo();
		 Estacionamiento estacionamiento = new Estacionamiento();
		 ManipulacionArchivo archivos = new ManipulacionArchivo("registros.txt");
		 ArrayList<Vehiculo> autos = null; 
		 Fecha tiempo = new Fecha();
		 

      int opcion;

      System.out.println("PARQUEO");
      System.out.println("¿Qué desea hacer?");
      opcion = vista.menu();
	  /**
	  * Ciclo mientras la opcion no sea 0 que es salir, sigue corriendo.
	  **/
	  while(opcion != 0){
	    switch(opcion)
	    {
            case 0: 
			vista.mensaje("Saliendo del programa...");
                        System.exit(0);
			break;
	  	  /**
	  	  * Opcion de abrir estacionamiento.
	  	  **/
           case 1: 
           if(autos==null){
                           autos = new ArrayList <Vehiculo>(); 
			   String nombre =  vista.getNombre();
			   String direccion =  vista.getDireccion();
			   double precio =  vista.getPrecio();
			   estacionamiento = new Estacionamiento(nombre, direccion, precio);
                           espacios = estacionamiento.getEspacios();
                           System.out.println("-Estacionamiento " + (nombre)+ " "+ "abierto-" );
			   vista.mensaje("UBICACIÓN: " + direccion);
			   System.out.println("PRECIO:"+ "Q." + precio);
			   
                           
                           try{
                               csv.crearArchivo("registros.csv");
                           }catch(Exception e){
                               System.out.println(e);
                           }
           }else{
			       System.out.println("-El estacionamiento ya fue abierto-");
				   break;
		   }
		   break;
 	  	  /**
 	  	  * Opcion asignar lugares y agregar carro.
 	  	  **/
           case 2:
	       	if(autos != null){
                                   String res = estacionamiento.getEspacios2();
                                   
                                   System.out.println(res);
                                   int espacioSelec = vista.chooseEstacionamiento(espacios);
                                   
				   String matricula =  vista.getMatricula();
				   String modelo =  vista.getModelo();
				   String color =  vista.getColor();
				   String tipo =  vista.getTipo();
				   autos.add(new Vehiculo(tipo, matricula,modelo,color, espacioSelec));
				   modelos.add(modelo);
				   tipos.add(tipo);
				   espreferidos.add(espacioSelec);
                                   espacios.get(espacioSelec).setCarro();
                                   csv.write(matricula, modelo, color, tipo, espacioSelec, tiempo.horaActual());
                                   
                    
                                   
				   System.out.println("Tiempo actual: "+ " " + tiempo.horaActual());
				   archivos.escribir("ESPACIO:"+" "+ espacioSelec+"MATRICULA:"+" "+ matricula+ "MODELO:" + " "+ modelo+ "INGRESO:"+ tiempo.horaActual());
         	}
         	else    System.out.println("-El estacionamiento esta cerrado-");
			break;
			
  	  	  /**
  	  	  * Opcion de agregar espacios.
  	  	  **/
            case 3:                 
		   	 	double ancho =  vista.getAncho();
		   	 	double largo =  vista.getLargo();
				double altura =  vista.getAltura();
				boolean techado = false;
				boolean aereo = false;
				espacios.add(new Espacioparqueo(ancho,largo,altura,techado,aereo ));		
			
			
			break;
			
  	  	  /**
  	  	  * Estadisticas varias.
  	  	  **/
            case 4:                  
			String modeloRecurrente = "";
			int modeloRecurrenteN = 0;
			for(int i = 0; i<modelos.size(); i++){
				int frecuencia = Collections.frequency(modelos, modelos.get(i));
				if(frecuencia>modeloRecurrenteN){
					modeloRecurrente = modelos.get(i);
					modeloRecurrenteN = frecuencia;
					vista.mensaje("El modelo más recurrente en los parqueos es:" + modeloRecurrente);
				}
			}
			
			String tiposRecurrente = "";
			int tiposRecurrenteN = 0;
			for(int i = 0; i<tipos.size(); i++){
				int frecuencia = Collections.frequency(tipos, tipos.get(i));
				if(frecuencia>tiposRecurrenteN){
					tiposRecurrente = tipos.get(i);
					tiposRecurrenteN = frecuencia;
					vista.mensaje("Las caracteristicas mas recurrentes de los parqueos son:" + tiposRecurrente);
				}
			}
			
			int paqueoRecurrente = 0;
			int parqueoRecurrenteN = 0;
			for(int i = 0; i<espreferidos.size(); i++){
				int frecuencia = Collections.frequency(espreferidos, espreferidos.get(i));
				if(frecuencia>parqueoRecurrenteN){
					paqueoRecurrente = espreferidos.get(i);
					parqueoRecurrenteN = frecuencia;
					vista.mensaje("El parqueo más preferido es:" + paqueoRecurrente);
				}
			}
			
			System.out.println("Se han rechazado:" +vista.getContador()+ "Parqueos");
			
			break;
			
  	  	  /**
  	  	  * Muestra el archivo. txt.
  	  	  **/
            case 5:
			
			System.out.println(archivos.leer());
			
			break;
		 
            case 6:  
			vista.mensaje("Cerrando parqueo...");
                        System.exit(0);
			
			break;
    	  	  /**
    	  	  * Muestra los carros actuales en el parqueo.
    	  	  **/
            case 7: 
				if(autos!=null){
			            for (int i = 0; i < autos.size(); i++) {
			                System.out.println("ESPACIO DE PARQUEO: ");
			                System.out.println(autos.get(i));
			               }
			    }
			    else    vista.mensaje("-El estacionamiento esta cerrado-");  
				               
			break;
            default: vista.mensaje("-Opcion invalida, porfavor ingrese una opción valida-");   break;
		}
		opcion = vista.menu();
		}
		
		
		
		
		
    }
}


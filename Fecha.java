
import java.util.Calendar;

/**
 * @version: 01-sep-21
 * @author Karen Jimena Hernández Ortega
 * @file Fecha.java
 */
public class Fecha {
    private int anio;
    private int mes;
    private int dia;
    private String hora_registro;
    private int tiempoEnAnios;
    Calendar calendario = Calendar.getInstance();
    
    /**
    * @param null
    * Constructor Fecha
    */
    public Fecha(){
        this.anio = 0;
        this.mes = 0;
        this.dia = 0;
        this.hora_registro = "00:00:00";
    }
    
    public Fecha(int anio, int mes, int dia){
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
        hora_registro = horaActual();
    }
    /**
    * @param hora_registro
    */
    public void setHora_registro(String hora_registro) {
        this.hora_registro = hora_registro;
    }
    /**
    * @param tiempoanios
    */
    public void setTiempoEnAnios(int tiempoEnAnios) {
        this.tiempoEnAnios = tiempoEnAnios;
    }

    public String getHora_registro() {
        return hora_registro;
    }
	
    /**
    * SETTERS
    */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
    
    /**
    * @param null
    * @return tiempoenanios
    */
    public int getTiempoEnAnios (){
        return tiempoEnAnios;
    }
	
    /**
    * @param null
    * @return anios
    */
    public int getAnio() {
        return anio;
    }
    /**
    * @param null
    * @return mes
    */
    public int getMes() {
        return mes;
    }
    /**
    * @param null
    * @return dia
    */
    public int getDia() {
        return dia;
    }

    @Override
    public String toString() {
        return "{" + "a\u00f1o=" + anio + ", mes=" + mes + ", dia=" + dia ;
    }
    
    public int calcularTiempoEnAnios(Fecha nacimiento){
        this.tiempoEnAnios = Calendar.YEAR - nacimiento.anio;
        this.mes = Calendar.MONTH;
        if( (this.mes-nacimiento.mes) < 0 || (nacimiento.mes-this.mes) == 0 && (nacimiento.dia-this.dia < 0) ){
            tiempoEnAnios--;
        }
        return tiempoEnAnios;
    }
    
    /**
    * @param null
    * @return dia - mes - año
    */
    public String fechaActual(){
        int year = calendario.get(Calendar.YEAR);
        int month = calendario.get(Calendar.MONTH);
        int day = calendario.get(Calendar.DAY_OF_WEEK);
        return day+"/"+month+"/"+year;
    }
    
    /**
    * @param null
    * @return hora y minutos
    */
    public String horaActual(){
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        return hora+":"+minutos;
    }
    
}
    
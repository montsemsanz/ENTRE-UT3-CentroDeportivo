import java.util.Scanner;

/**
 *  
 *  Clase para testear la clase CentroDeportivo
 *  
 */
public class DemoCentroDeportivo
{

    private CentroDeportivo centro;
    private static Scanner teclado = new Scanner(System.in);

    /**
     * Constructor de la clase DemoCentroDeportivo
     */
    public DemoCentroDeportivo()    {

        centro = new CentroDeportivo("FITNESS CENTER");
    }

    /**
     *  Inicio de la aplicación
     *  Código de prueba de toda la clase CentroDeportivo
     */
    public void iniciar()    {
        mostrarCabecera();

        char[] tipoActividad = {'S', 'Y', 'S', 'P', 'Y', 'Y'};
        int[] horas = {1, 0, 1, 1, 2, 1};
        int[] minutos = {15, 45, 30, 5, 0, 35};
        int[] inscripciones = {30, 22, 20, 15, 18, 10};

        tarificar(tipoActividad, horas, minutos, inscripciones);
        
        mostrarEstadisticas();

    }

    /**
     * Registrar datos por cada sala
     */
    private void tarificar(char[] tipoActividad, int[] horas, int[] minutos, int[] inscripciones) {

        for (int i = 0; i < tipoActividad.length; i++) {
            centro.tarificarClaseEnSala(i + 1, tipoActividad[i], horas[i], minutos[i], inscripciones[i]);      
            pausa();
        }

    }
    /**
     * Mostrar en pantalla las estadísticas
     */
    private void mostrarEstadisticas() {
        System.out.println("\nTotal importe entre todos los inscritos: " + 
            centro.getImporteTotal()+ "€");
        System.out.println("\nActividad/es con más inscripciones: " + 
            centro.getActividadMaximasInscripciones());
        System.out.println("\nSala de Yoga con más personas inscritas: " + 
            centro.getSala());

    }

    /**
     * Mostrar cabecera con nombre del centro deportivo
     */
    private void mostrarCabecera() {
        System.out.println("*".repeat(60));
        System.out.println("*".repeat(10) +
            String.format("%20s%-20s", "Centro deportivo ", centro.getNombre()) +
            "*".repeat(10));
        System.out.println("*".repeat(60));
        System.out.println();

    }

    /**
     *  hacer una pausa
     */
    private void pausa()    {
        System.out.println("\nPulse tecla para continuar");        
        teclado.nextLine();
        System.out.println("\u000C");    
    }

}

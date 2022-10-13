
/**
 * ENTREGA UT3
 * @author -   Rubén López-Davalillo
 * 
 * 
 * Un centro deportivo oferta clases de yoga, pilates y spinning
 * en sus diferentes salas. En cada sala se realiza una actividad de la misma duración
 * que se repite a lo largo del día un nº de veces. Puede haber salas
 * con la misma actividad pero de duración diferentes (ej. en la sala 1 
 * se hace spinning en clases de 40 minutos y en la sala 3 se
 * hace también spinning pero de duración 70 minutos).
 * 
 * El precio de las clases depende de su duración.
 * El precio base es 5.0€ y se añade a este precio 0.40€ por cada período completo de 15 minutos.
 * 
 * 
 * La primera clase comienza siempre a las 10.30 (a.m) y la última no puede acabar después
 * de las 8.30 (p.m). En todas las salas entre clase y clase (incluida la última) 
 * hay un descanso de 10 minutos
 * 
 * El centro quiere mostrar al usuario el nº de clases que se dan en cada sala con su precio
 * y además quiere efectuar ciertos cálculos dependiendo del nº de personas que se han inscrito 
 * a las actividades de las diferentes salas
 */
public class CentroDeportivo{
    private final int HORA_PRIMERA_CLASE = 10;
    private final int MINUTOS_PRIMERA_CLASE = 30;
    private final int HORA_ULTIMA_CLASE = 8;
    private final int MINUTOS_ULTIMA_CLASE = 30;
    private final int DESCANSO = 10;
    private final double PRECIO_BASE = 5.0;
    private final double PRECIO_QUINCE_MINUTOS = 0.40;
    private final char YOGA = 'Y';
    private final char PILATES = 'P';
    private final char SPINNING = 'S';
    private String nombre; //guarda el nombre del centro deportivo
    private int yoga; //contabiliza el nº de personas inscritas en yoga
    private int pilates; //contabiliza el nº de personas inscritas en pilates
    private int spinning; //contabiliza el nº de personas inscritas en spinning
    private double totalAcumulado; //importe total obtenido entre todos los inscritos
    private int salaMaximoYoga; //nº de sala en la que hay más inscripciones para yoga
    private int maximoInscripcionesYoga; //nº máximo de personas inscritas en yoga en dicha sala

    /**
     * Constructor  - 
     * Recibe un único parámetro, el nombre del centro deportivo
     * e inicializa el resto de atributos adecuadamente 
     */
    public CentroDeportivo(String queNombre){
        nombre = queNombre;
        yoga = 0;
        pilates = 0;
        spinning = 0;
        totalAcumulado = 0;
        salaMaximoYoga = 0;
        maximoInscripcionesYoga = 0;
    }

    /**
     *  Accesor para el nombre del centro deportivo
     *
     */
    public String getNombre(){
        return nombre;
    }

    /**
     *  Mutador para el nombre del centro deportivo
     */
    public void setNombre(String queNombre){
        nombre = queNombre;
    }

    /**
     *  accesor para el importe total acumulado 
     *  entre todos los inscritos en el centro
     *
     */
    public double getImporteTotal(){
        return totalAcumulado;
    }

    /**
     *  Este método recibe 5 parámetros: 
     *      - sala: el nº de sala donde se hace la actividad
     *      - tipo: el tipo de actividad, un carácter 'Y' yoga, 'P' pilates 'S' spinning
     *      - horas y minutos : duración de la actividad en nº horas y minutos
     *      - inscritos: el nº de personas inscritas en esa actividad en la sala
     *      
     *      Por ej, tarificarClaseEnSala(4, 'P', 1, 5, 15) significa que en la sala 4 se hace
     *      pilates, las clases duran 1 hora y  5 minutos y se han inscrito en esta sala 15 personas
     *   
     *   A partir de esta información el método debe calcular:
     *      - total inscritos por tipo de actividad (independientemente de la sala)
     *      - la sala con máximo nº de inscritos en yoga y dicho valor máximo 
     *   
     *   Utiliza una sentencia switch  para analizar el tipo de actividad
     *   
     *   También el método calculará:
     *   
     *      - el precio de la clase en la sala (basándose en su duración). En el ejemplo anterior
     *      la clase de pilates duraba 1 hora y 5 minutos . Como el total de minutos
     *      de duración es 65 su precio será: 5 + 0,40 *  4 = 6,60 ya que son 4 los períodos completos de
     *      15 minutos que hay
     *      - nº de veces que la clase se ofertará en la sala (dependerá de su duración. No olvidar que entre clase 
     *      y clase siempre hay un descanso)
     *      - la hora de finalización de la última clase (hora y minutos) - !!Ver resultados de ejecución!!
     *      - el método además irá registrando el importe total que lleva acumulado el centro entre todas
     *      las personas inscritas 
     *      
     *   En pantalla se mostrarán los datos de la sala tal como indican los resultados de ejecución
     *              
     */
    public void tarificarClaseEnSala(int sala, char tipo, int horas, int minutos, int inscritos)    {
        int horas_en_minutos = horas * 60;
        int total_minutos_clase = horas_en_minutos + minutos;
        int total_minutos_clase_mas_descanso = total_minutos_clase + DESCANSO;
        int HORA_PRIMERA_CLASE_en_minutos = HORA_PRIMERA_CLASE * 60;
        int minutos_total_primera_clase = MINUTOS_PRIMERA_CLASE + HORA_PRIMERA_CLASE_en_minutos;
        int HORA_ULTIMA_CLASE_en_minutos = (HORA_ULTIMA_CLASE + 12) * 60;
        int minutos_total_ultima_clase = MINUTOS_ULTIMA_CLASE + HORA_ULTIMA_CLASE_en_minutos;
        int total_minutos_abierto = minutos_total_ultima_clase - minutos_total_primera_clase;
        String nombreActividad = "";
        switch(tipo){
            case YOGA:
                yoga += inscritos;
                if(inscritos > maximoInscripcionesYoga){
                    maximoInscripcionesYoga = inscritos;
                    salaMaximoYoga = sala;
                }
                nombreActividad = "YOGA";
                break;
            case PILATES:
                pilates += inscritos;
                nombreActividad = "PILATES";
                break;
            case SPINNING:
                spinning += inscritos;
                nombreActividad = "SPINNING";
                break;
        }
        double precio_clase = PRECIO_BASE + (((horas * 60) + minutos) / 15) * PRECIO_QUINCE_MINUTOS;
        int numero_veces = total_minutos_abierto / total_minutos_clase_mas_descanso;
        int ultima_clase = minutos_total_primera_clase + (total_minutos_clase_mas_descanso * numero_veces);
        int hora_final_clase = ultima_clase / 60;
        int minutos_final_clase = ultima_clase - (hora_final_clase * 60);
        totalAcumulado += inscritos * precio_clase;
        System.out.println("Sala Nº: " + sala + "             Actividad: " + nombreActividad + "\n");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Longitud (Duración): " + total_minutos_clase + " min. Descanso: " + DESCANSO + " min");
        System.out.println("Precio clase: " + precio_clase + "€");
        System.out.println("Clase ofertada en sala: " + numero_veces + " veces al día");
        System.out.println("La última clase termina a las: " + hora_final_clase + "h. y " + minutos_final_clase + " minutos");
        System.out.println("Total inscritos en sala: " + inscritos);
    }

    /**
     *  nº sala en la que hay más inscritos en yoga
     *   
     */
    public int getSala(){
        return salaMaximoYoga;
    }
    
    /**
     * Devuelve el nombre de la actividad con más inscritos 
     * independientemente de la sala  (puede haber coincidencias)
     *  
     */
    public String getActividadMaximasInscripciones()    {
        int resultado = 0;
        String mas_insc = "";
        if(yoga >= pilates && yoga >= spinning){
            resultado = yoga;
        }
        else if(pilates >= yoga && pilates >= spinning){
            resultado = pilates;
        }
        else if(spinning >= yoga && spinning >= pilates){
            resultado = spinning;
        }
        if(yoga == resultado){
            mas_insc += "YOGA ";
        }
        if(pilates == resultado){
            mas_insc += "PILATES ";
        }
        if(spinning == resultado){
            mas_insc += "SPINNING";
        }
        return mas_insc;
    }

}

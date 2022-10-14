    
/**
 * ENTREGA UT3
 * @author - (Aimar Urquizu Diego)
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
public class CentroDeportivo
{
    //TODO 
    
    // Nombre del Centro Deportivo
    private String nombre;
    
    // Hora y minutos
    private final int HORA_PRIMERA_CLASE = 10;
    private final int MINUTOS_PRIMERA_CLASE = 30;
    private final int HORA_ULTIMA_CLASE = 8;
    private final int MINUTOS_ULTIMA_CLASE = 30;
    private final int DESCANSO = 10;
    
    // Precio base de las clases
    private final double PRECIO_BASE = 5.0;
    private final double PRECIO_QUINCE_MINUTOS = 0.40;
    
    // Tipo de actividad
    private final char YOGA = 'Y';
    private final char PILATES = 'P';
    private final char SPINNING = 'S';
    
    // Nº de personas inscritas
    private int yoga;
    private int pilates;
    private int spinning;
    
    // Total dinero acumulado
    private double totalAcumulado;
    
    // Mas inscripciones para yoga
    private int salaMaximoYoga;
    
    // Nº maximo personas inscritas en yoga en dicha sala
    private int maximoInscripcionesYoga;

    /**
     * Constructor  - 
     * Recibe un único parámetro, el nombre del centro deportivo
     * e inicializa el resto de atributos adecuadamente 
     */
    public CentroDeportivo(String queCentroDeportivo)    {
        nombre = queCentroDeportivo;
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
    public String getNombre()    {
        return nombre;
        
    }

    /**
     *  Mutador para el nombre del centro deportivo
     */
    public String setNombre(String queCambiarNombre)    {
       return nombre = queCambiarNombre;
       
    }

    /**
     *  accesor para el importe total acumulado 
     *  entre todos los inscritos en el centro
     *
     */
    public double getImporteTotal()    {
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
        // TODO 
        int totalInscritosY = 0;
        int totalInscritosP = 0;
        int totalInscritosS = 0;
        
        // Total inscritos por tipo de actividad
        switch (tipo) {
            case YOGA: totalInscritosY = inscritos;
                break;
            case PILATES: totalInscritosP = inscritos;
                break;
            case SPINNING: totalInscritosS = inscritos;
                break;
        }
        int totalInscritos = totalInscritosY + totalInscritosP + totalInscritosS;
        
        // La sala con máximo Nº de inscritos en yoga y cuál es 
        // ese valor máximo
        salaMaximoYoga = Math.max(totalInscritosY, inscritos);
        maximoInscripcionesYoga = salaMaximoYoga;
        
        // A) El precio de la clase en la sala
        int duracionClase = horas * 60 + minutos;
        double precioClase = PRECIO_BASE + 
                    (PRECIO_QUINCE_MINUTOS * (duracionClase / 15));
                    
        // B) Nº de veces que la clase se ofertará en la sala
        // 10 horas = 600 mins
        int ClasesEnSala = 600 / (duracionClase + DESCANSO);
        
        // C) La hora de finalización de la última clase (hora y minutos)
        int finUltimaClase = 600 - (600 % (duracionClase + DESCANSO));
        int horaFinUltimaClase = finUltimaClase / 60;
        int minFinUltimaClase = finUltimaClase % 60;
             // Pasar a formato reloj la hora y los minutos
        int HoraFinUltimaClase = 10 + horaFinUltimaClase;
        int MinFinUltimaClase = minFinUltimaClase + 30;
        if (minFinUltimaClase >= 30) {
            MinFinUltimaClase = minFinUltimaClase - 30;
            HoraFinUltimaClase ++;
        }
        else {
            MinFinUltimaClase = minFinUltimaClase + 30;
        }
        
        // D) el importe total que lleva acumulado el centro entre 
        //    todas las personas inscritas
        totalAcumulado = totalInscritos * precioClase * ClasesEnSala;
        
        // Sala Print
        
        System.out.println("Sala Nº: " + sala + "               " + 
                            "Actividad: " + tipo);
        System.out.println("_____________________________________");
        System.out.println("Longitud (Duración): " + duracionClase +
                            "min. Descanso: " + DESCANSO + "min.");
        System.out.println("Precio clase: " + precioClase + "€");
         System.out.println("Clase ofertada en sala: " + ClasesEnSala + 
                            " veces al día");
        System.out.println("La última clase termina a las: " +
                            HoraFinUltimaClase + "h. y " +
                            MinFinUltimaClase + "minutos");
        System.out.println("Total inscritos en sala: " + inscritos);
        
    }

    /**
     *  nº sala en la que hay más inscritos en yoga
     *   
     */
    public int getSala()   {
        //TODO 
        return salaMaximoYoga;
    }

    /**
     * Devuelve el nombre de la actividad con más inscritos 
     * independientemente de la sala  (puede haber coincidencias)
     *  
     */
    public String getActividadMaximasInscripciones()    {
        //TODO 
        String getActividadMaximasInscripciones;
        if (yoga > pilates && yoga > spinning) {
            getActividadMaximasInscripciones = "YOGA";
        }
        else if (pilates > yoga && pilates > spinning) {
            getActividadMaximasInscripciones = "PILATES";
        }
        else {
            getActividadMaximasInscripciones = "SPINNING";
        }
        return getActividadMaximasInscripciones;
    }

}

/**
 * ENTREGA UT3
 * @Midgard - (aquí pon tu nombre)
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
    private final int HORA_PRIMERA_CLASE=10;
    private final int MINUTOS_PRIMERA_CLASE=30;
    private final int HORA_ULTIMA_CLASE=8;
    private final int MINUTOS_ULTIMA_CLASE=30;
    private final int DESCANSO=10;
    // horas
    private final double PRECIO_BASE=5.0; 
    private final double PRECIO_QUINCE_MINUTOS=0.40; //añadir al base
    //precios
    private final char YOGA='Y';
    private final char PILATES='P';
    private final char SPINNING='S';
    //actividad y ultimas CONSTANTES
    private String nombre; //Del centro
    private int yoga; // nº de personas inscritas
    private int pilates; // nº de personas inscritas
    private int spinning; // nº de personas inscritas
    private double totalAcumulado; // importe total entre todos
    private int salaMaximoYoga; //nº de sala haya mas gente para yoga
    private int maximoInscripcionesYoga; // nº máximo personas inscritos en yoga en anterior sala
    /**
     * Constructor  - 
     * Recibe un único parámetro, el nombre del centro deportivo
     * e inicializa el resto de atributos adecuadamente 
     */
    public CentroDeportivo(String queNombre)    {
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
    public String getNombre()    {
        return nombre;
    }

    /**
     *  Mutador para el nombre del centro deportivo
     */
    public void  setNombre(String queNombre)    {
        nombre = queNombre;

    }
    //Hasta aqui nombre
    /**
     *  accesor para el importe total acumulado 
     *  entre todos los inscritos en el centro
     */
    public double getImporteTotal()    {
        return totalAcumulado;

    }

    /** 
     * En pantalla se mostrarán los datos de la sala
     * como indican los resultados de ejecución
     *              
     */
    public void tarificarClaseEnSala(int sala, char tipo, int horas, int minutos, 
    int inscritos)    {
        int totalInscritos = inscritos; 
        int horasEnMinutos = horas * 60;
        int minutosClaseTotal = horasEnMinutos + minutos;
        int tiempoTotal = 600; //en minutos
        double numeroClases = (tiempoTotal / minutosClaseTotal); 
        double numeroDescansos = numeroClases; 
        int vecesOfertada = 0;
        double precioClaseSala = PRECIO_BASE+PRECIO_QUINCE_MINUTOS*(minutosClaseTotal/15);
        double comprobacionTiempo = numeroClases * (minutosClaseTotal-10) + (numeroDescansos * 10); //aproveche todo el tiempo disponible
        if (comprobacionTiempo <= 600 && comprobacionTiempo >= 590){ // si el tiempo aprovechado es suficientemente bueno
            vecesOfertada=(int)numeroClases;
        } else{
            vecesOfertada= "Intenta otra duración";
        }

        // switch(totalInscritos){
        // case 'Y': inscritos=yoga;
        // break;
        // case 'P': inscritos=pilates;
        // break;
        // case 'S': inscritos=spinning;
        // break;

        // } 
        
    }
    
    {
        /**
        *  nº sala en la que hay más inscritos en yoga
        *   
         */
        public int getSala()   {
            return salaMaximoYoga; 

        }

        /**
         * Devuelve el nombre de la actividad con más inscritos 
         * independientemente de la sala  (puede haber coincidencias)
         *  
         */
        public String getActividadMaximasInscripciones()    {
            return loquesea;
        }
    }


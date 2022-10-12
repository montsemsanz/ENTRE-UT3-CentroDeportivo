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
        int y = 0;
        int p = 0;
        int s = 0;
        
        switch(tipo){
            case 'Y': y += inscritos;  
                break;
            case 'P': p += inscritos;     
                break;
            case 'S': s += inscritos;
                break;
        } 
        int totalInscritos = (y + p + s);

        int tiempoDisponible = 600; //en minutos (de las 10:30 am a las 8:30 pm)
        int horasEnMinutos = horas * 60; //(ejemplo con 2h:25mints)
        int horaPrimeraClaseMinutos = (HORA_PRIMERA_CLASE * 60) + MINUTOS_PRIMERA_CLASE; //la constante en minutos para operar después
        int duracionClaseMints = horasEnMinutos + minutos +10; //duracion clase + descansos (135)
        int duracionClaseSinDescanso = horasEnMinutos + minutos;
        int numeroClases = (int) Math.floor(tiempoDisponible / duracionClaseMints); //cociente de está división = veces puede ofertar una clase. (4)
        int duracionClaseMintsTotal = numeroClases * duracionClaseMints; //Tiempo total (540)
        int duracionTotalMinutos = horaPrimeraClaseMinutos + duracionClaseMintsTotal; //(1170) la hora y mints en que acaba la clase en formato minutos
        int horaAcabaClase24 = duracionTotalMinutos/60; // hora a la que finaliza la clase en formato 24hrs (19)
        int minutosRestantes = horaAcabaClase24 * 60; //(1140)        
        int minutosAcabaClase = duracionTotalMinutos - minutosRestantes; //(24)
        int horaAcabaClase12 = horaAcabaClase24 - 12; //(10)

        double precioClaseSala = PRECIO_BASE+PRECIO_QUINCE_MINUTOS*(duracionClaseMints/15);
        double importeTotal =  numeroClases * precioClaseSala * totalInscritos; 

        System.out.println("Sala Nº: " + sala + "  " + "Actividad: " + 'S'); 
        System.out.println("Longitud (Duración): " + duracionClaseSinDescanso + 
            "Descanso: " + DESCANSO + "min.");
        System.out.println("Clase ofertada en sala:" + numeroClases + "veces al día");
        System.out.println("La última clase termina a las: " + 
            horaAcabaClase24+"h" + "y" + minutosAcabaClase + "minutos");

        System.out.println("Total inscritos en la sala:");
        System.out.println("Pulse tecla para continuar");
    }

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
        int mayorPrimero = 0;
        int mayorMax = 0;
        if('Y' > 'P'){
            mayorPrimero = 'Y';
        }
        else {
            mayorPrimero = 'P';
        }
        if(mayorPrimero > 'S'){
            mayorMax = mayorPrimero;
        }
        else{
            mayorMax = mayorPrimero;
        }
    }
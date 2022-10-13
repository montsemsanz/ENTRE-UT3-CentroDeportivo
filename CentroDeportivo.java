/**
 * ENTREGA UT3
 * @author - Julen Baztarrica
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
    //CONSTANTES 
    private final int HORA_PRIMERA_CLASE = 10;
    private final int MINUTOS_PRIMERA_CLASE = 30;
    private final int HORA_ULTIMA_CLASE = 20;
    private final int MINUTOS_ULTIMA_CLASE = 30;
    private final int DESCANSO = 10;

    private final double PRECIO_BASE = 5.0;
    private final double PRECIO_QUINCE_MINUTOS = 0.40;

    private final char YOGA = 'Y';
    private final char PILATES= 'P';
    private final char SPINNING = 'S';

    //ATRIBUTOS
    private String nombre;

    private int yoga;
    private int pilates;
    private int spinning;

    private double totalAcumulado;

    private int salaMaximoYoga;
    private int maximoInscripcionesYoga;
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
    public void setNombre(String queNombre)    {
        nombre = queNombre;
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
        // saca las horas en minutos
        int horaEnMinutos = horas;
        horaEnMinutos = (horaEnMinutos * 60) + minutos;

        // saca los periodos completos de 15 minutos
        int totalMinutos = horaEnMinutos / 15;

        // calcula el precio de la sala (basandose en su duracion)
        double totalPrecio = PRECIO_BASE + PRECIO_QUINCE_MINUTOS * totalMinutos;

        // saca los minutos totales sumando el descanso
        int minutosConDescanso = horaEnMinutos + DESCANSO;

        // calcula la diferencia en minutos de la clase inicial y final    
        int difClases = (HORA_ULTIMA_CLASE * 60 + MINUTOS_ULTIMA_CLASE) - (HORA_PRIMERA_CLASE * 60 + MINUTOS_PRIMERA_CLASE);

        // calcula las horas disponibles
        int horasDisp = difClases / minutosConDescanso;

        switch (tipo) {
            case 'Y':
                yoga += inscritos;
                break;
            case 'P':
                pilates += inscritos;
                break;
            case 'S':
                spinning += inscritos;
                break;
        }

        int laHora = (difClases - (minutosConDescanso * horasDisp));
        int horaFinal = 0;      
        int nuevoMinFinal = 0;
        int minutosFinal = 0;
        int minFinal = 0;        

        totalAcumulado += totalPrecio * inscritos;

        System.out.println("Sala Nº: " + sala + "\tActividad: " + tipo);
        System.out.println("Longitud (Duración):" + horaEnMinutos + "min. DESCANSO: " + DESCANSO + "min.");
        System.out.println("Precio clase: " + totalPrecio + "€");
        System.out.println("Clases ofertadas en clase: " + horasDisp + " veces al día");

        if(tipo == 'Y' && inscritos >= maximoInscripcionesYoga){
            maximoInscripcionesYoga = inscritos;
            salaMaximoYoga = sala;
            System.out.println("Total inscritos en sala: " + yoga);
        }else if(tipo == 'P'){
            System.out.println("Total inscritos en sala: " + pilates);
        }else{
            System.out.println("Total inscritos en sala: " + spinning);
        }

        String str = "";
        if(laHora > 30){
            horaFinal = HORA_ULTIMA_CLASE - 1;
            nuevoMinFinal = laHora - MINUTOS_ULTIMA_CLASE;
            minutosFinal = 60 - nuevoMinFinal;
            str += "La última clase termina a las: " + horaFinal + "h. y " + minutosFinal + " minutos";
        }else{
            minFinal = MINUTOS_ULTIMA_CLASE - laHora;
            str += "La última clase termina a las: " + HORA_ULTIMA_CLASE + "h. y " + minFinal + " minutos";
        }
        System.out.println(str);

        System.out.println("Total importe entre todas las personas inscritas: " + totalAcumulado + "€");
        System.out.println("Actividad/es con más inscripciones: " + getActividadMaximasInscripciones());
        System.out.println("Sala de yoga con más personas inscritas: " + getSala());
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
        String maximaAct = "";
        if(yoga > pilates && yoga > spinning) {
            maximaAct += "YOGA";
        }
        else if(spinning > pilates && spinning > yoga){
            maximaAct += "Spinning";
        }
        else if(pilates > spinning && pilates > yoga){
            maximaAct += "PILATES";
        }
        else if(yoga == pilates){
            maximaAct += "YOGA  PILATES";
        }
        else if(pilates == spinning){
            maximaAct += "PILATES  SPINNING";
        }
        else if(yoga == spinning){
            maximaAct += "YOGA  SPINNING";
        }
        else{
            maximaAct += "YOGA  PILATES  SPINNING";
        }
        return maximaAct;
    }
}

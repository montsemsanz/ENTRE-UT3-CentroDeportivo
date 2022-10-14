
/**
 * ENTREGA UT3
 * @author - (Danna Cielo Cardenas Portugal) 
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
    // cinco constantes que indican la hora y minutos de inicio de la primera clase (las
    // 10,30a.m) y la hora y minutos tope fin de la última clase (8,30p.m) y la cantidad de
    // minutos de descanso entre clase y clase
    private final int HORA_PRIMERA_CLASE = 10;
    private final int MINUTOS_PRIMERA_CLASE = 30;
    private final int HORA_ULTIMA_CLASE = 8;
    private final int MINUTOS_ULTIMA_CLASE = 30;
    private final int DESCANSO = 10;
    // dos constantes que identifican el precio base de cada clase y la cantidad a añadir al
    // precio por cada 15 minutos completos
    private final double PRECIO_BASE = 5;
    private final double PRECIO_QUINCE_MINUTOS = 0.4;
    // tres constantes que identifican el tipo de actividad
    private final char YOGA = 'Y';
    private final char PILATES = 'P';
    private final char SPINNING = 'S';
    // un atributo nombre que guarda el nombre del centro deportivo
    private String nombre;
    // un atributo yoga en el que se contabiliza el nº de personas inscritas en yoga
    private int yoga;
    // un atributo pilates en el que se contabiliza el nº de personas inscritas en pilates 
    private int pilates;
    // un atributo spinning en el que se contabiliza el nº de personas inscritas en
    // spinning
    private int spinning;
    // un atributo totalAcumulado donde el centro acumula el importe total obtenido
    // entre todos los inscritos hasta el momento en las clases
    private double totalAcumulado;
    // un atributo salaMaximoYoga que guardará el nº de sala en la que hay más
    // inscripciones para yoga
    private int salaMaximoYoga;
    // un atributo maximoInscripcionesYoga en el que se guarda el nº máximo de
    // personas inscritas en yoga en dicha sala 
    private int maximoInscripcionesYoga;

    /**
     * Constructor  - 
     * Recibe un único parámetro, el nombre del centro deportivo
     * e inicializa el resto de atributos adecuadamente 
     */
    public CentroDeportivo(String queNombre)    {
        //TODO 
        // el constructor, recibe un parámetro, el nombre del centro deportivo. Inicializa además el
        // resto de atributos a 0
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
        //TODO 
        // un accesor getNombre() para el nombre del centro
        return nombre;
        
    }

    /**
     *  Mutador para el nombre del centro deportivo
     */
    public void setNombre(String queNombre)    {
       //TODO 
       // un mutador setNombre() para cambiar ese nombre
       nombre = queNombre;
       
    }

    /**
     *  accesor para el importe total acumulado 
     *  entre todos los inscritos en el centro
     *
     */
    public double  getImporteTotal()    {
        //TODO     
        // un accesor getImporteTotal() que devuelve el importe total acumulado entre todos los
        // inscritos en el centro
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
        //TODO 
        // el precio de la clase en la sala (basándose en su duración). En el ejemplo anterior la
        // clase de pilates duraba 1 hora y 5 minutos . Como el total de minutos de duración es
        // 65 su precio será: 5 + 0,40 * 4 = 6,6€ ya que son 4 los períodos completos de 15
        // minutos que hay. La clase de yoga duraba 2 horas y 0 minutos. Su duración total en
        // minutos es 120 así que su precio será 5 + 0,40 * 8 = 8,2€ ya que son 8 los períodos
        // completos de 15 minutos
        String tipoActividad = "";
        switch (tipo) {
            case YOGA : yoga += inscritos;
                        tipoActividad = "YOGA";
                        if (inscritos > maximoInscripcionesYoga) {
                            salaMaximoYoga = sala;
                            maximoInscripcionesYoga = inscritos;
                        }
                break;
            case PILATES : pilates += inscritos;
                           tipoActividad = "PILATES";
                break;
            case SPINNING : spinning += inscritos;
                            tipoActividad = "SPINNING";
                break;
        }
        // nº de veces que la clase se ofertará en la sala (dependerá de su duración. No olvidar
        // que entre clase y clase siempre hay un descanso)
        int duracionDeClase = horas * 60 + minutos;
        double precioDeClase = PRECIO_BASE + (duracionDeClase / 15) * PRECIO_QUINCE_MINUTOS;
        // la hora de finalización de la última clase (hora y minutos)
        int vecesOfertaClase = 600 / (duracionDeClase + DESCANSO);
        int auxTotalMinutos = (vecesOfertaClase * (duracionDeClase + DESCANSO));
        int horaUltimaClase = HORA_PRIMERA_CLASE + (auxTotalMinutos / 60);
        int minutosUltimaClase = MINUTOS_PRIMERA_CLASE + (auxTotalMinutos % 60);
        
        if (minutosUltimaClase >= 60) {
            minutosUltimaClase -= 60;
            horaUltimaClase++;
        }
        
        // el importe total que lleva acumulado el centro entre todas las personas inscritas
        totalAcumulado += precioDeClase * inscritos;
        
        System.out.println("Sala nº" + sala + "               Actividad: " + tipoActividad);
        System.out.println("--------------------------------------------");
        System.out.println("Longitud (Duración): " + duracionDeClase + " min. Descanso: 10 min.");
        System.out.println("Precio clase: " + precioDeClase + "€");
        System.out.println("Clase ofertada en la sala: " + vecesOfertaClase + " veces al día");
        System.out.println("La última clase termina a las: " + horaUltimaClase + "h. y " 
                           + minutosUltimaClase + " minutos");
        System.out.println("Total inscritos en la sala: " + inscritos);
        
    }

    /**
     *  nº sala en la que hay más inscritos en yoga
     *   
     */
    public int getSala()   {
        //TODO 
        // un método accesor getSala() para el nº de sala en la que hay más inscritos en yoga
        return salaMaximoYoga;
        
    }

    /**
     * Devuelve el nombre de la actividad con más inscritos 
     * independientemente de la sala  (puede haber coincidencias)
     *  
     */
    public String getActividadMaximasInscripciones()    {
        //TODO 
        // un método String getActividadMaximasInscripciones() que devuelve el nombre/s de la/s
        // actividad/es con más inscritos independientemente de la sala (puede haber coincidencias).
        int actMasInscripciones;
        String actMasInscritos = "";
        if (yoga > spinning && yoga > pilates) {
            actMasInscripciones = yoga;
                                                }
            else if (spinning > pilates) {
            actMasInscripciones = spinning;
                                        }
        else {
            actMasInscripciones = pilates;
            }
        if (yoga == actMasInscripciones) {
            actMasInscritos += "YOGA ";
                                        }
        if (spinning == actMasInscripciones) {
            actMasInscritos += "SPINNING ";
                                            }
        if (pilates == actMasInscripciones) {
            actMasInscritos += "PILATES ";
                                            }
        return actMasInscritos;
    
    }

}

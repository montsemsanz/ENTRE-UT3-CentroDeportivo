
/**
 * ENTREGA UT3
 * @CristinaLópez
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
    //CONSTANTES:
    private final int HORA_PRIMERA_CLASE = 10; //10:00 AM == 10:00 H
        private final int MINUTOS_PRIMERA_CLASE = 30; //30 MIN
    private final int HORA_ULTIMA_CLASE = 8; //8:00PM == 20:00 H
        private final int MINUTOS_ULTIMA_CLASE = 30; //30 MIN
    private final int DESCANSO = 10; //10 MINUTOS
    
    private final double PRECIO_BASE = 5.0; //precio base de cada clase
    private final double PRECIO_QUINCE_MINUTOS = 0.40; //incremento de precio cada 15 mins
    
    private final char YOGA = 'Y'; //tipo de actividad - yoga
    private final char PILATES = 'P'; //tipo de actividad - pilates
    private final char SPINNING = 'S'; //tipo de actividad - spinning
    
    //RESTO DE ATRIBUTOS:
    private String nombre; //nombre del centro deportivo
    
    private int yoga; //cantidad de personas inscritas en yoga
    private int pilates; //cantidad de personas inscritas en pilates
    private int spinning; //cantidad de personas inscritas en spinning
    
    private double totalAcumulado; //dinero total obtenido entre todos los 
                                    //inscritos de todas las clases
    
    private int salaMaximoYoga; //el numero de la sala con mas personas inscritas
        private int maximoInscripcionesYoga; //el numero de personas inscritas en la
                                              //sala de yoga con mas inscripciones
    /**
     * Constructor  - 
     * Recibe un único parámetro, el nombre del centro deportivo
     * e inicializa el resto de atributos adecuadamente (a cero)
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
     *  accesor para el importe (dinero) total acumulado 
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
        String nombreTipo = "";
        
        int totalInscritosEnActividadY = 0; 
        int totalInscritosEnActividadS = 0; 
        int totalInscritosEnActividadP = 0; 
        
        int totalInscritosEnSala = 0;
        
        int salasYoga = 0;
        
        //identificar el tipo de actividad con una sentencia switch:
        switch (tipo){
        
            case 'Y':   tipo = YOGA;
                        nombreTipo = "Yoga";
                        salasYoga += sala; //esto está mal porque en realidad sobreescribe el valor de 
                                           // las salas anteriores, no añade salas :'C
                        totalInscritosEnActividadY += inscritos;
                        totalInscritosEnSala += inscritos;
                        break;
                        
            case 'P':   tipo = PILATES;
                        nombreTipo = "Pilates";
                        totalInscritosEnActividadP += inscritos;
                        totalInscritosEnSala += inscritos;
                        break;
                        
            case 'S':   tipo = SPINNING;
                        nombreTipo = "Spinning";
                        totalInscritosEnActividadS += inscritos;
                        totalInscritosEnSala += inscritos;
                        break;
                  
            default:    System.out.println("Tipo de actividad no válido. Por favor, inserte otro caracter.");
                        break;
        }
        
        //--------------------------------------------------------
        
        salaMaximoYoga = Math.max(totalInscritosEnActividadY, inscritos); //this is surely wrong
        maximoInscripcionesYoga = totalInscritosEnActividadY; //lmao this is a HUGE mistake
        
        //-----------APARTADO A:--------------------------------------
            //definición de auxiliares:
            int duracion1Clase = (horas * 60 + minutos); //calcula la duración EN MINUTOS de UNA clase
            
        double precioDuracionClase = PRECIO_BASE + PRECIO_QUINCE_MINUTOS * (duracion1Clase / 15);
                    //divides la duraciónClase entre 15 porque cada 15 mins,
                    //se vuelve a sumar el PRECIO_QUINCE_MINUTOS al PRECIO_BASE
        
        //-----------APARTADO B:-------------------------------------------
            //definición de auxiliares:
            int horaFullEmpiezanClasesEnMinutos = (HORA_PRIMERA_CLASE * 60 + MINUTOS_PRIMERA_CLASE); 
                    //PASADA A MINUTOS
                    
            //int tiempoDisponible = (HORA_ULTIMA_CLASE * 60 + MINUTOS_ULTIMA_CLASE) - (HORA_PRIMERA_CLASE * 60 + MINUTOS_PRIMERA_CLASE); 
            int tiempoDisponible = 600; //MINUTOS entre el incio de las clases y el fin (aka, mins entre 10:30am y 8:30pm)
                    //tiempo total disponible en una sala (EN MINUTOS)
                          
        int vecesClaseOfertada = (int) Math.floor(tiempoDisponible / (duracion1Clase + DESCANSO)); 
                //numero de veces que se pueden dar clases en una sala en función de la duración de éstas 
                // teniendo en cuenta los descansos
                //(resultado redondeado hacia abajo porque no se pueden ofertar clases fuera de horario)
                
        //-----------APARTADO C:--------------------------------------------
            //definición de auxiliares:
            int duracionFullClasesEnMinutos = ((duracion1Clase + DESCANSO) * vecesClaseOfertada); 
                //PASADA A MINUTOS
                
            int horaFullFinClasesEnMinutos = horaFullEmpiezanClasesEnMinutos + duracionFullClasesEnMinutos; 
                //cantidad de MINUTOS que pasan desde las 00:00am hasta que termina la última clase del día  
        
            int horaFinClasesEn24Horas = (int) Math.floor(horaFullFinClasesEnMinutos / 60);
                //devuelve la hora que es (formato 24h) en el momento en el que termina la última clase
            
            int horaFinClasesEn12Horas = (horaFinClasesEn24Horas - 12);
                //transforma la hora a la que acaba la última clase a formato 12h
                //fórmula empleada: formato24h - 12h == formato12h
            
        int horaFinClasesMinutosRestantes = horaFullFinClasesEnMinutos - (horaFinClasesEn24Horas * 60); 
            //devuelve los minutos correspondientes a la hora en la que termina la última clase
            //fórmula: multiplicar número entero de horaFinClasesEn24Horas * 60 para pasarlo a minutos y, 
            //         después, restar esos minutos al total de minutos "horaFullFinClasesEnMinutos" para
            //         saber cuántos minutos sueltos sobran (tras restarle las X horas completas que dure)
        
        String horaFinUltimaClase = horaFinClasesEn12Horas + ":" + horaFinClasesMinutosRestantes + " PM";
        
        //-----------APARTADO D:-----------------------------------------------
            //definición de auxiliares:
            int totalInscritosCentro = totalInscritosEnActividadY + totalInscritosEnActividadP 
                                        + totalInscritosEnActividadS; 
                                        
        totalAcumulado = precioDuracionClase * vecesClaseOfertada * totalInscritosCentro;
        
        //-----------IMPRESIÓN:------------------------------------------------
        
        System.out.println("Sala Nº: " + sala + "                         Actividad: " + nombreTipo);
        System.out.println("----------------------------------------------");
        System.out.println("Longitud (duración): " + duracion1Clase + " min.      Descanso: " + DESCANSO + " min.");
        System.out.println("Precio clase: " + precioDuracionClase + "€");
        System.out.println("Clase ofertada en sala " + vecesClaseOfertada + " veces al día.");
            //System.out.println("La última clase termina a las " + horaFinUltimaClase + "."); //escribe la hora en formato 12h (SALE NEGATIVO????)
            System.out.println("La última clase termina a las " + horaFinClasesEn24Horas + "h. y " + horaFinClasesMinutosRestantes + "min.");
        System.out.println("Total de inscritos en sala: " + totalInscritosEnSala);

        
    }

    /**
     *  nº sala en la que hay más inscritos en yoga
     *   
     */
    public int getSala()   { //Nº DE SALA CON MAX DE INSCRIPCIONES EN YOGA
        return salaMaximoYoga;
    }

    
    /**
     * Devuelve el nombre de la actividad con más inscritos 
     * independientemente de la sala  (puede haber coincidencias)
     *  
     */
    public String getActividadMaximasInscripciones()    {
        String actividadMaximasInscripciones;
    
          if((yoga > pilates && pilates > spinning) || (yoga > spinning && spinning > pilates))
           {
              actividadMaximasInscripciones = "Yoga";
           } else if ((pilates > yoga && yoga > spinning) || (pilates > spinning && spinning > yoga)) 
                   {
                    actividadMaximasInscripciones = "Pilates";
                   } else 
                       {
                        actividadMaximasInscripciones = "Spinning";
                       }
    
        return actividadMaximasInscripciones;
     }

}

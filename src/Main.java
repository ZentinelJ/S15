import java.util.*;

public class Main{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>();

        System.out.println("---- Captura de personas ----");
        boolean continuar = true;
        while(continuar){
            System.out.println("Ingresa nombre(s) de la persona: ");
            String nombre = sc.nextLine();
            System.out.println("Ingresa los apellidos de la persona: ");
            String apellido = sc.nextLine();
            System.out.println("Ingresa el genero de la persona: ");
            String genero = sc.nextLine();
            System.out.println("Ingresa el cargo de la persona: ");
            String cargo = sc.nextLine();
            System.out.println("Ingresa la edad de la persona: ");
            byte edad = sc.nextByte();
            System.out.println("Ingresa la cantidad de horas trabajadas: ");
            byte horas = sc.nextByte();
            System.out.println("Ingresa el sueldo hora de la persona: ");
            double sueldo = sc.nextDouble();
            sc.nextLine();

            Persona nuevaPersona = new Persona(nombre, apellido, genero, cargo, edad, horas, sueldo);
            personas.add(nuevaPersona);

            System.out.print("¿Desea ingresar otra persona? (s/n): ");
            String respuesta = sc.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                continuar = false;
            }
            System.out.println("-------------------------");
        }

        System.out.println("---- Procesando datos con lambdas y stremas, por favor espere... ----");

        /*a. Calcule la cantidad de personas que hay almacenadas*/
        long cantidadPersonas = personas.stream().count();
        System.out.println("Cantidad de personas almacendas: " + cantidadPersonas);

        /*b. Calcule el promedio edades de personas (average)*/
        OptionalDouble promedioPersonas = personas.stream().mapToInt(Persona::getEdad).average();
        System.out.println("Promedio de edades de las personas: " + promedioPersonas);

        /*c. Muestre la cantidad de personas mayores de edad*/
        long mayoresEdad = personas.stream().filter(p -> p.getEdad() >= 18).count();
        System.out.println("Cantidad de personas mayores de edad: " + mayoresEdad);

        /*d. Muestre las personas cuyos nombres empiecen con “A” (usa startWith de String)*/
        long cantidadConA = personas.stream().filter(p -> p.getNombre().startsWith("A")).count();
        System.out.println("Cantidad de personas que empiezan con A: " + cantidadConA);

        /*e. Muestre las personas cuyos apellidos contengan (contains de String) la letra “M”*/
        long cantidadConMEnApellido = personas.stream().filter(p -> p.getApellido().toUpperCase().contains("M")).count();
        System.out.println("Cantidad de personas con letra 'M' en apellido: " + cantidadConMEnApellido);

        System.out.println("---- Datos procesados exitosamente ----");
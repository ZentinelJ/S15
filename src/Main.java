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

        System.out.println("---- Realizando operaciones avanzadas con lambdas y streams, por favor espere... ----");

        /*a. Sueldo de 8 horas de cada persona con cargo de director de género masculino (M)*/
        System.out.println("Sueldo de 8 horas para directores masculinos: ");
        personas.stream().filter(p -> p.getCargo().equalsIgnoreCase("Director")).filter(p -> p.getGenero().equalsIgnoreCase("Masculino") || p.getGenero().equalsIgnoreCase("M")).peek(p -> System.out.print("Nombre: " + p.getNombre() + " " + p.getApellido() + " ")) // Extra: peek
                .mapToDouble(p -> p.getSueldo() * 8).forEach(sueldo -> System.out.println("Sueldo por 8 horas: $" + String.format("%.2f", sueldo)));

        /*b. Primera persona que sea “desarrollador” y sea de género femenino*/
        System.out.println("Primera persona desarrolladora femenina: ");
        Optional<Persona> primeraDesarrolladoraFemenina = personas.stream().filter(p -> p.getCargo().equalsIgnoreCase("Desarrollador")).filter(p -> p.getGenero().equalsIgnoreCase("Femenino") || p.getGenero().equalsIgnoreCase("F")).findFirst();

        primeraDesarrolladoraFemenina.ifPresentOrElse(p -> System.out.println("- " + p.getNombre() + " " + p.getApellido() + " (Cargo: " + p.getCargo() + ", Género: " + p.getGenero() + ")"), () -> System.out.println("No se encontró ninguna desarrolladora femenina."));

        /*c. Persona con cargo de desarrollador que más gana por hora*/
        System.out.println("Desarrollador que más gana por hora: ");
        Optional<Persona> masGana = personas.stream().filter(p -> p.getCargo().equalsIgnoreCase("Desarrollador")).max(Comparator.comparingDouble(Persona::getSueldo)); // Asume getSueldo() es sueldo por hora

        if (masGana.isPresent()) {
            Persona desarrolladorMasGana = masGana.get();
            System.out.println("Nombre: " + desarrolladorMasGana.getNombre() + " " + desarrolladorMasGana.getApellido());
            System.out.println("Cargo: " + desarrolladorMasGana.getCargo());
            System.out.println("Sueldo por hora: $" + String.format("%.2f", desarrolladorMasGana.getSueldo()));
        } else {
            System.out.println("No se encontró ningún desarrollador o no hay datos para comparar.");
        }

        /*d. Todas las mujeres ordenadas por su nombre*/
        System.out.println("Mujeres ordenadas por nombre: ");
        personas.stream().filter(p -> p.getGenero().equalsIgnoreCase("Femenino") || p.getGenero().equalsIgnoreCase("F")).sorted(Comparator.comparing(Persona::getNombre)).forEach(p -> System.out.println("- " + p.getNombre() + " " + p.getApellido() + " (Edad: " + p.getEdad() + ", Cargo: " + p.getCargo() + ")"));

        sc.close();
    }
}
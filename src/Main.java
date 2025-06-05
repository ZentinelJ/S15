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
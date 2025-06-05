import java.util.*;

public class Menu{
    public static void main(String[] args){

        Map<String, List<Animal>> clasificacion = new HashMap<>();

        List<Animal> animales = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa cuantos animales quieres agregar: ");
        byte numAnimales = sc.nextByte();
        sc.nextLine();

        for(byte i = 0; i < numAnimales; i++){
            System.out.println("Ingresa el nombre del animal: ");
            String nombre = sc.nextLine();
            System.out.println("Ingresa el tipo de animal: ");
            String tipo = sc.nextLine();
            System.out.println("Ingresa el genero del animal: ");
            String genero = sc.nextLine();

            Animal animal = new Animal(nombre, tipo, genero);
            animales.add(animal);

            if(!clasificacion.containsKey(tipo)){
                clasificacion.put(tipo, new ArrayList<>());
            }
            clasificacion.get(tipo).add(animal);
        }

        System.out.println("Animales clasificados: ");
        for(Map.Entry<String, List<Animal>> entry : clasificacion.entrySet()){
            System.out.println("Tipo: " + entry.getKey());
            for(Animal animal : entry.getValue()){
                System.out.println(" - " + animal);
            }
        }
        sc.close();
    }
}
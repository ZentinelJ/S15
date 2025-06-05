public class Persona {
    //nombre, apellido, edad, genero, sueldo, hora, cargo
    private String nombre;
    private String apellido;
    private String genero;
    private String cargo;
    private byte edad;
    private byte hora;
    private double sueldo;

    public Persona(String nombre, String apellido, String genero, String cargo, byte edad, byte hora, double sueldo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.cargo = cargo;
        this.edad = edad;
        this.hora = hora;
        this.sueldo = sueldo;
    }
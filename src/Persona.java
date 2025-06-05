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

    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public String getGenero(){
        return genero;
    }
    public String getCargo(){
        return cargo;
    }
    public byte getEdad(){
        return edad;
    }
    public byte getHora(){
        return hora;
    }
    public double getSueldo(){
        return sueldo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public void setCargo(String cargo){
        this.cargo = cargo;
    }

    public void setEdad(byte edad){
        this.edad = edad;
    }

    public void setHora(byte hora){
        this.hora = hora;
    }

    public void setSueldo(double sueldo){
        this.sueldo = sueldo;
    }
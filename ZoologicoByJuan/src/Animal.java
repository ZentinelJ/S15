public class Animal {
    private String nombre;
    private String tipo;
    private String genero;

    public Animal(String nombre, String tipo, String genero){
        this.nombre = nombre;
        this.tipo = tipo;
        this.genero = genero;
    }

    public String getNombre(){
        return nombre;
    }

    public String getTipo(){
        return tipo;
    }

    public String getGenero(){
        return genero;
    }

    public void setNombre(String N){
        this.nombre = N;
    }

    public void setTipo(String T){
        this.tipo = T;
    }

    public void setGenero(String G){
        this.genero = G;
    }

    @Override
    public String toString(){
        return "Nombre: " + nombre +", Tipo: " + tipo + ", Genero: " + genero;
    }
}

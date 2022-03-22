package biblioteca;
import java.util.*;

public class Biblioteca {
    // Atributos
    
    private String nombre;
    private ArrayList<Libro> listaLibros;
    private ArrayList<Persona> personal;
    
    // Constructores
    
    public Biblioteca() {}
    public Biblioteca(String nombre, ArrayList<Libro> listaLibros, ArrayList<Persona> personal) {
        this.nombre = nombre.replace(nombre.charAt(0), nombre.toUpperCase().charAt(0));
        this.listaLibros = listaLibros;
        this.personal = personal;
    }
    public Biblioteca(Biblioteca biblioteca) {
        this(biblioteca.getNombre(), biblioteca.getListaLibros(), biblioteca.getPersonal());
    }
    
    // DTO
    
    public String getNombre() { return this.nombre; }
    public ArrayList<Libro> getListaLibros() { return this.listaLibros; }
    public ArrayList<Persona> getPersonal() { return this.personal; }
    
    public void setNombre(String nombre) {
        this.nombre= nombre.replace(nombre.charAt(0), nombre.toUpperCase().charAt(0));
    }
    public void setListaLibros(ArrayList<Libro> listaLibros) { this.listaLibros = listaLibros; }
    public void setPersonal(ArrayList<Persona> personal) { this.personal = personal; }
    @Override
    public String toString() { return "Biblioteca{nombre="+this.personal+", listaLibros="+this.listaLibros+", personal="+this.personal+'}'; }
    
    // Metodos
    
    public void mostrarLibros() {
        System.out.println("Hay "+listaLibros.get(0).getContador()+" titulos en la biblioteca");
        for(int i=0;i<this.listaLibros.size();i++) {
            System.out.println(listaLibros.get(i).toString());
        }
    }
    public void mostrarLibrosDisponibles() {
        for(int i=0;i<this.listaLibros.size();i++) {
            if(listaLibros.get(i).getCopiasDisponibles()>0) {
                System.out.println(listaLibros.get(i).toString());
            }
        }
    }
}

package biblioteca;
import java.util.*;
public class Persona {
    // Atributos
    
    protected String nombre;
    protected String apellidos;
    protected String NIF;
    protected String contraseña;
    
    // Constructores
    
    public Persona() {}
    public Persona(String nombre, String apellidos, String NIF, String contraseña) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.NIF = NIF;
        this.contraseña = contraseña;
    }
    public Persona(Persona persona) {
        this(persona.getNombre(), persona.getApellidos(), persona.getNIF(), persona.getContraseña());
    }
    
    // DTO
    
    public String getNombre() { return this.nombre; }
    public String getApellidos() { return this.apellidos; }
    public String getNIF() { return this.NIF; }
    public String getContraseña() { return this.contraseña; }
    
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public void setNIF(String NIF) { this.NIF = NIF; }
    public void setContraseña(String contraseña) {
        if (contraseña.length()<8) {
            System.out.println("Contraseña debe tener almenos 8 caracteres.");
        } else {
            this.contraseña = contraseña;
        }
    }
    @Override
    public String toString() { return "Persona{nombre="+this.nombre+", apellidos="+this.apellidos+", NIF="+this.NIF+", contraseña="+this.contraseña+'}'; }
    // Metodos
    
    public void añadirPersona(ArrayList<Persona> personal) {
        Persona persona = new Persona();
        Scanner teclado = new Scanner(System.in);
        String texto;
        System.out.println("Introduzca nombre:");
        texto=teclado.nextLine();
        persona.setNombre(texto);
        System.out.println("Introduzca apellidos:");
        texto=teclado.nextLine();
        persona.setApellidos(texto);
        System.out.println("Introduzca NIF:");
        texto=teclado.nextLine();
        persona.setNIF(texto);
        System.out.println("Introduzca contraseña:");
        texto=teclado.nextLine();
        persona.setContraseña(texto);
        personal.add(persona);
    }
    public void eliminarPersona(ArrayList<Persona> personal) {
        Scanner teclado=new Scanner(System.in);
        String NIF;
        System.out.println("Introduzca el NIF de la persona a eliminar:");
        NIF=teclado.nextLine();
        for(int i=0;i<personal.size();i++) {
            if (personal.get(i).getNIF().equals(NIF)) {
                personal.remove(i);
            }
        }
    }
    public void mostrarPersonal(ArrayList<Persona> personal) {
        for (int i = 0; i < personal.size(); i++) {
            System.out.println(personal.get(i).toString());
        }
    }
}

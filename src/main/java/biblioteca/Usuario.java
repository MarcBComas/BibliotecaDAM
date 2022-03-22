package biblioteca;
import java.util.*;

public class Usuario extends Persona{
    
    // Constructores
    
    public Usuario() {}
    public Usuario(String nombre, String apellidos, String NIF, String contraseña) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.NIF = NIF;
        this.contraseña = contraseña;
    }
    public Usuario(Usuario usuario) {
        this(usuario.getNombre(), usuario.getApellidos(), usuario.getNIF(), usuario.getContraseña());
    }
    
    // DTO
    
    @Override
    public String toString() { return "Usuario{nombre="+this.nombre+", apellidos="+this.apellidos+", NIF="+this.NIF+", contraseña="+this.contraseña+'}'; }
    
    // Metodos
    
    public void añadirUsuario(ArrayList<Usuario> listaUsuarios) {
        Usuario usuario = new Usuario();
        Scanner teclado = new Scanner(System.in);
        String texto;
        System.out.println("Introduzca nombre:");
        texto=teclado.nextLine();
        usuario.setNombre(texto);
        System.out.println("Introduzca apellidos:");
        texto=teclado.nextLine();
        usuario.setApellidos(texto);
        System.out.println("Introduzca NIF:");
        texto=teclado.nextLine();
        usuario.setNIF(texto);
        System.out.println("Introduzca contraseña:");
        texto=teclado.nextLine();
        usuario.setContraseña(texto);
        listaUsuarios.add(usuario);
    }
    public void eliminarUsuario(ArrayList<Usuario> listaUsuarios) {
        Scanner teclado=new Scanner(System.in);
        String NIF;
        System.out.println("Introduzca el NIF del usuario a eliminar:");
        NIF=teclado.nextLine();
        for(int i=0;i<listaUsuarios.size();i++) {
            if (listaUsuarios.get(i).getNIF().equals(NIF)) {
                listaUsuarios.remove(i);
            }
        }
    }
    public void mostrarUsuarios(ArrayList<Usuario> listaUsuarios) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            System.out.println(listaUsuarios.get(i).toString());
        }
    }
    public static int buscarListaUsuarios(ArrayList<Usuario> listaUsuarios, String NIF) {
        int i = 0;
        while (i < listaUsuarios.size()) {
            if (listaUsuarios.get(i).getNIF().equals(NIF)) {
                return i;
            }
            i++;
        }
        return -1;
    }
    public static int buscarListaReservas(ArrayList<Reservas> listaReservas, String NIF) {
        int i = 0;
        while (i < listaReservas.size()) {
            if (listaReservas.get(i).getUsuario().getNIF().equals(NIF)) {
                return i;
            }
            i++;
        }
        return -1;
    }
}

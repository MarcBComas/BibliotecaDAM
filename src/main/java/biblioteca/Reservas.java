package biblioteca;
import java.util.*;
public class Reservas {
    // Atributos
    
    private Usuario usuario;
    private ArrayList<Libro> libros;
    
    // Constructores
    
    public Reservas() {}
    public Reservas(Usuario usuario, ArrayList<Libro> libros) {
        this.usuario = usuario;
        this.libros = libros;
    }
    public Reservas(Reservas reserva){
        this(reserva.getUsuario(), reserva.getLibros());
    }
    
    // DTO
    
    public Usuario getUsuario() { return this.usuario; }
    public ArrayList<Libro> getLibros() { return this.libros; }
    
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public void setLibros(ArrayList<Libro> libros) { this.libros = libros; }
    @Override
    public String toString() { return "Reservas{persona="+this.usuario.toString()+", libros="+this.libros.toString()+'}'; }
    
    // Metodos
    
    public void mostrarReservas(ArrayList<Reservas> listaReservas) {
        for (int i = 0; i < listaReservas.size(); i++) {
            System.out.println(listaReservas.get(i).toString());
        }
    }
    public void crearReserva(ArrayList<Reservas> listaReservas, ArrayList<Usuario> listaUsuarios, ArrayList<Libro> listaLibros) {
        Scanner teclado = new Scanner(System.in);
        String texto;
        System.out.println("Introduce el NIF del usuario que va a reservar:");
        texto=teclado.nextLine();
        int indexReserva = Usuario.buscarListaReservas(listaReservas, texto);
        int indexUsuario = Usuario.buscarListaUsuarios(listaUsuarios, texto);
        
        // COMPROBACION USUARIO
        
        if (indexReserva == -1) {
            if (indexUsuario == -1) {
                System.out.println("Usuario con el NIF "+texto+" no encontrado.");
            } else {
                
                // USUARIO CREACION NUEVA RESERVA
                
                Reservas reserva = new Reservas();
                ArrayList<Libro> librosReserva = new ArrayList<Libro>();
                reserva.setUsuario(listaUsuarios.get(indexUsuario));
                while (librosReserva.size() <= 5 && !texto.isBlank()) {
                    System.out.println("Introduzca el ISBN del libro a reservar (Poner un 0 para finalizar):");
                    texto=teclado.nextLine();
                    if (texto.equals("0")) {
                        break;
                    } 
                    int indexLibro = Libro.buscarLibroISBN(listaLibros, texto);
                    if (indexLibro == -1 ) {
                        System.out.println("Libro con el ISBN "+texto+" no encontrado.");
                    } else if (listaLibros.get(indexLibro).getCopiasDisponibles() == 0) {
                        System.out.println("Este libro no tiene copias disponibles.");
                    } else {
                        librosReserva.add(listaLibros.get(indexLibro));
                        listaLibros.get(indexLibro).setCopiasDisponibles(listaLibros.get(indexLibro).getCopiasDisponibles() - 1);
                    }
                }
                reserva.setLibros(librosReserva);
                listaReservas.add(reserva);
                System.out.println("El usuario "+reserva.getUsuario().getNombre()+" ha reservado con éxito.");
            }
        } else {
            
            // USUARIO CON RESERVA
            
            if (listaReservas.get(indexReserva).getLibros().size() >= 5) {
                System.out.println("Este usuario no puede reservar más libros.");
            } else {
                System.out.println("El usuario "+listaReservas.get(indexReserva).getUsuario().getNombre()+" "+listaReservas.get(indexReserva).getUsuario().getApellidos()+" tiene reservado "+listaReservas.get(indexReserva).getLibros().size()+" libro/s. Puede reservar "+ (5 - listaReservas.get(indexReserva).getLibros().size())+ " libros más." );
                while (listaReservas.get(indexReserva).getLibros().size() <= 5 && !texto.isBlank()) {
                    System.out.println("Introduzca el ISBN del libro a reservar (Poner 0 para acabar):");
                    texto=teclado.nextLine();
                    if (texto.equals("0")) {
                        break;
                    }
                    int indexLibro = Libro.buscarLibroISBN(listaLibros, texto);
                    if (indexLibro == -1) {
                        System.out.println("Libro con el ISBN "+texto+" no encontrado.");
                    } else if (listaLibros.get(indexLibro).getCopiasDisponibles() == 0) {
                        System.out.println("Este libro no tiene copias disponibles.");
                    } else {
                        listaReservas.get(indexReserva).getLibros().add(listaLibros.get(indexLibro));
                        listaLibros.get(indexLibro).setCopiasDisponibles(listaLibros.get(indexLibro).getCopiasDisponibles() - 1);
                    }
                }
                System.out.println("El usuario "+listaReservas.get(indexReserva).getUsuario().getNombre()+" ha reservado con éxito.");
            }
            
        }
    }
    public void devolucionLibros(ArrayList<Usuario> listaUsuarios, ArrayList<Libro> listaLibros, ArrayList<Reservas> listaReservas) {
        Scanner teclado = new Scanner(System.in);
        String texto;
        System.out.println("Escriba el NIF del usuario:");
        texto = teclado.nextLine();
        int indexUsuario = Usuario.buscarListaReservas(listaReservas, texto);
        while (indexUsuario == -1) {
            System.out.println("NIF de usuario incorrecto o sin reserva, introduzca uno correcto (Para cancelar poner un 0)");
            texto = teclado.nextLine();
            if (texto.equals("0")) {
                return;
            } else {
                indexUsuario = Usuario.buscarListaReservas(listaReservas, texto);
            }
        }
        System.out.println("El usuario con el NIF "+texto+" tiene los siguientes libros reservados:");
        System.out.println(listaReservas.get(indexUsuario).getLibros().toString());
        System.out.println("Escriba el ISBN del libro a devolver:");
        texto = teclado.nextLine();
        int indexLibro = Libro.buscarLibroISBN(listaLibros, texto);
        while (indexLibro == -1) {
            System.out.println("ISBN de libro incorrecto, introduzca uno correcto (Para cancelar poner un 0)");
            texto = teclado.nextLine();
            if (texto.equals("0")) {
                return;
            } else {
                indexLibro = Libro.buscarLibroISBN(listaLibros, texto);
            }
        }
        int i = 0;
        boolean encontrado=false;
        while (i < listaReservas.get(indexUsuario).getLibros().size() && !encontrado) {
            if ( listaReservas.get(indexUsuario).getLibros().get(i).getISBN().equals(texto) ) {
                listaReservas.get(indexUsuario).getLibros().remove(i);
                listaLibros.get(indexLibro).setCopiasDisponibles(listaLibros.get(indexLibro).getCopiasDisponibles() + 1);
                System.out.println("Libro devuelto con exito.");
                encontrado = true;
            }
            i++;
        }
        if (listaReservas.get(indexUsuario).getLibros().size() == 0) {
                listaReservas.remove(indexUsuario);
            }
        if (encontrado == false) {
            System.out.println("Este libro no ha sido reservado por el usuario.");
        }
    }
}

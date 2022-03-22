package biblioteca;
import java.util.*;
public class Libro {
    
    // ATRIBUTOS
    
    private String ISBN;
    private String titulo;
    private String autor;
    private String editorial;
    private int copias;
    private int copiasDisponibles;
    private static int contador=0;
    
    // CONSTRUCTORES
    
    public Libro() { this.contador++; }
    public Libro(String ISBN, String titulo, String autor, String editorial, int copias, int copiasDisponibles) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.copias = copias;
        this.copiasDisponibles = copiasDisponibles;
        this.contador++;
    }
    public Libro(Libro libro) {
        this(libro.getISBN(), libro.getTitulo(), libro.getAutor(), libro.getEditorial(), libro.getCopias(), libro.getCopiasDisponibles());
    }
    
    // DTO
    
    public String getISBN() { return this.ISBN; }
    public String getTitulo() { return this.titulo; }
    public String getAutor() { return this.autor; }
    public String getEditorial() { return this.editorial; }
    public int getCopias() { return this.copias; }
    public int getCopiasDisponibles() { return this.copiasDisponibles; }
    public int getContador() { return this.contador; }
    
    public void setISBN(String ISBN) { this.ISBN = ISBN; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setEditorial(String editorial) { this.editorial = editorial; }
    public void setCopias(int copias) {
        if (copias < 1) {
            this.copias = 1;
        } else { this.copias = copias; }
    }
    public void setCopiasDisponibles(int copiasDisponibles) { this.copiasDisponibles = copiasDisponibles; }
    public void setContador(int contador) { this.contador = contador; }
    
    // TOSTRING
    @Override
    public String toString() { return "Libro{ISBN=" +this.ISBN+ ", titulo=" +this.titulo+ ", autor=" +this.autor+ ", editorial=" +this.editorial+ ", copias=" +this.copias+ ", copiasDisponibles=" +this.copiasDisponibles+ ", contador=" +this.contador+ '}'; }
    
    // METODOS
    
    public static void añadirLibro(ArrayList<Libro> listaLibros) {
        Libro libro = new Libro();
        Scanner teclado = new Scanner(System.in);
        String texto;
        int datos;
        System.out.println("Introduzca el ISBN:");
        texto=teclado.nextLine();
        libro.setISBN(texto);
        System.out.println("Introduzca el título:");
        texto=teclado.nextLine();
        libro.setTitulo(texto);
        System.out.println("Introduzca el autor:");
        texto=teclado.nextLine();
        libro.setAutor(texto);
        System.out.println("Introduzca la editorial:");
        texto=teclado.nextLine();
        libro.setEditorial(texto);
        System.out.println("Introduzca el numero de copias:");
        datos=teclado.nextInt();
        teclado.nextLine();
        libro.setCopias(datos);
        System.out.println("Introduzca el numero de copias disponibles:");
        datos=teclado.nextInt();
        teclado.nextLine();
        libro.setCopiasDisponibles(datos);
        listaLibros.add(libro);
    }
    public static void eliminarLibro(ArrayList<Libro> listaLibros,ArrayList<Reservas> listaReservas, String ISBN) {
        int indexLibro = Libro.buscarLibroISBN(listaLibros, ISBN);
        if (indexLibro == -1) {
            System.out.println("Este libro no existe.");
            return;
        } else {
            for (int i = 0; i < listaReservas.size() ; i++) {
            for (int j = 0; j < listaReservas.get(i).getLibros().size(); j++) {
                if (listaReservas.get(i).getLibros().get(j).getISBN().equals(ISBN)) {
                    System.out.println("Este libro no se puede borrar debido a que esta reservado.");
                    return;
                }
            }
        }
        System.out.println("El libro con el ISBN "+ISBN+" ha sido eliminado.");
        listaLibros.remove(indexLibro);
        }
        
//        for (int i = 0; i < listaLibros.size() ; i++) {
//            if (listaLibros.get(i).getISBN().equals(ISBN)) {
//                for (int j = 0; j < listaReservas.size() ; j++) {
//                    for (int k = 0; k < listaReservas.get(i).getLibros().size(); k++) {
//                        if (listaReservas.get(i).getLibros().get(j).getISBN().equals(ISBN)) {
//                            System.out.println("Este libro no se puede borrar debido a que esta reservado.");
//                            return;
//                        }
//                    }
//                }
//                listaLibros.remove(i);
//            }        
//        }
    }
    public static int buscarLibroISBN(ArrayList<Libro> listaLibros, String ISBN) {
        for(int i=0;i<listaLibros.size();i++){
            if (listaLibros.get(i).getISBN().equals(ISBN)) {
                return i;
            }
        }
        return -1;
    }
    public static String buscarLibroTitulo(ArrayList<Libro> listaLibros, String titulo) {
        ArrayList<String> librosTitulo= new ArrayList<String>();
        for(int i=0;i<listaLibros.size();i++) {
            if (listaLibros.get(i).getTitulo().contains(titulo)) {
                librosTitulo.add(listaLibros.get(i).toString());
            }
        }
        return librosTitulo.toString();
    }
}

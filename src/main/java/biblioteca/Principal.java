package biblioteca;
import java.util.*;
public class Principal {
    public static void main(String[] args) {
        
        // CREACION VARIABLES Y ARRAYLISTS
        
        boolean programa = true;
        Scanner teclado = new Scanner(System.in);
        int menuOpciones;
        String texto;
        Libro libro = new Libro();
        ArrayList<Libro> listaLibros = new ArrayList<Libro>();
        libro.setContador(0);
        Biblioteca biblioteca = new Biblioteca();
        Persona persona = new Persona();
        ArrayList<Persona> personal = new ArrayList<Persona>();
        Usuario usuario = new Usuario();
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        Reservas reserva = new Reservas();
        ArrayList<Reservas> listaReservas = new ArrayList<Reservas>();
        biblioteca.setListaLibros(listaLibros);
        biblioteca.setPersonal(personal);
        
        // OBJETOS TEST
        
        Usuario usuario1 = new Usuario("aasdad","sadasda","1","ssdsaasdasdasd");
        listaUsuarios.add(usuario1);
        Usuario usuario2 = new Usuario("sddfdd","sgdeeere","2","dsfsdkofmdlkdnfsdf");
        listaUsuarios.add(usuario2);
        Libro libro1 = new Libro("1","asdasdas","adsadasdsa","adsadsas",5,3);
        Libro libro2 = new Libro("2","asdasdas","adsadasdsa","adsadsas",3,0);
        Libro libro3 = new Libro("3","asdasdas","adsadasdsa","adsadsas",7,4);
        listaLibros.add(libro1);
        listaLibros.add(libro2);
        listaLibros.add(libro3);
        Persona persona1 = new Persona("asdada","adasdas","2","sdssdssdsdsds");
        personal.add(persona1);
        
        while (programa) {
            
            // MENU PRINCIPAL
            
            System.out.println("-- Menú principal --");
            System.out.println("Bienvenido, ¿que quiere hacer?");
            System.out.println("(1) Gestionar biblioteca");
            System.out.println("(2) Gestionar personal");
            System.out.println("(3) Gestionar usuarios");
            System.out.println("(4) Gestionar libros");
            System.out.println("(5) Gestionar reservas");
            System.out.println("Escriba su opcion:");
            menuOpciones=teclado.nextInt();
            teclado.nextLine();
            switch(menuOpciones) {
                case 1 :
                    
                    // GESTIONAR BIBLIOTECA
                    
                    System.out.println("-- Gestionar biblioteca --");
                    System.out.println("(1) Mostrar nombre de la biblioteca");
                    System.out.println("(2) Cambiar nombre de la biblioteca");
                    System.out.println("(3) Mostrar lista de libros");
                    System.out.println("(4) Mostrar lista de libros disponibles");
                    System.out.println("Escriba su opcion:");
                    menuOpciones=teclado.nextInt();
                    teclado.nextLine();
                    switch(menuOpciones) {
                        case 1 :
                            
                            // MOSTRAR NOMBRE BIBLIOTECA
                            
                            System.out.println("-- Mostrar nombre de la biblioteca --");
                            System.out.println("El nombre de la biblioteca es: "+biblioteca.getNombre());
                            System.out.println("¿Que quiere hacer ahora?");
                            System.out.println("(1) Volver al Menú principal");
                            System.out.println("(2) Salir del programa");
                            System.out.println("Escriba su opcion");
                            menuOpciones=teclado.nextInt();
                            teclado.nextLine();
                            if (menuOpciones == 1) {
                                break;
                            } else if (menuOpciones == 2) {
                                programa=false;
                                break;
                            } else {
                                break;
                            }
                        case 2 :
                            
                            // CAMBIAR NOMBRE BIBLIOTECA
                            
                            System.out.println("-- Cambiar nombre de la biblioteca --");
                            System.out.println("Escriba el nuevo nombre:");
                            texto = teclado.nextLine();
                            biblioteca.setNombre(texto);
                            System.out.println("¿Que quiere hacer ahora?");
                            System.out.println("(1) Volver al Menú principal");
                            System.out.println("(2) Salir del programa");
                            System.out.println("Escriba su opcion");
                            menuOpciones=teclado.nextInt();
                            teclado.nextLine();
                            if (menuOpciones == 1) {
                                break;
                            } else if (menuOpciones == 2) {
                                programa=false;
                                break;
                            } else {
                                break;
                            }
                        case 3 :
                            
                            // MOSTRAR LISTA LIBROS
                            
                            System.out.println("-- Mostrar lista de libros --");
                            biblioteca.mostrarLibros();
                            System.out.println("¿Que quiere hacer ahora?");
                            System.out.println("(1) Volver al Menú principal");
                            System.out.println("(2) Salir del programa");
                            System.out.println("Escriba su opcion:");
                            menuOpciones=teclado.nextInt();
                            teclado.nextLine();
                            if (menuOpciones == 1) {
                                break;
                            } else if (menuOpciones == 2) {
                                programa=false;
                                break;
                            } else {
                                break;
                            }
                        case 4 :
                            
                            // MOSTRAR LIBROS DISPONIBLES
                            
                            System.out.println("-- Mostrar lista de libros disponibles --");
                            biblioteca.mostrarLibrosDisponibles();
                            System.out.println("¿Que quiere hacer ahora?");
                            System.out.println("(1) Volver al Menú principal");
                            System.out.println("(2) Salir del programa");
                            System.out.println("Escriba su opcion:");
                            menuOpciones=teclado.nextInt();
                            teclado.nextLine();
                            if (menuOpciones == 1) {
                                break;
                            } else if (menuOpciones == 2) {
                                programa=false;
                                break;
                            } else {
                                break;
                            }
                        default :
                            System.out.println("Opcion incorrecta.");
                    }
                    break;
                case 2 :
                    
                    // GESTIONAR PERSONAL
                    
                    System.out.println("-- Gestionar personal --");
                    System.out.println("(1) Mostrar personal");
                    System.out.println("(2) Añadir personal");
                    System.out.println("(3) Eliminar personal");
                    System.out.println("Escriba su opcion");
                    menuOpciones=teclado.nextInt();
                    teclado.nextLine();
                    switch (menuOpciones) {
                        case 1:
                            
                            // MOSTRAR PERSONAL
                            
                            System.out.println("-- Mostrar personal --");
                            persona.mostrarPersonal(personal);
                            System.out.println("¿Que quiere hacer ahora?");
                            System.out.println("(1) Volver al Menú principal");
                            System.out.println("(2) Salir del programa");
                            System.out.println("Escriba su opcion:");
                            menuOpciones=teclado.nextInt();
                            teclado.nextLine();
                            if (menuOpciones == 1) {
                                break;
                            } else if (menuOpciones == 2) {
                                programa=false;
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            
                            // AÑADIR PERSONAL
                            
                            System.out.println("-- Añadir personal --");
                            persona.añadirPersona(personal);
                            System.out.println("¿Que quiere hacer ahora?");
                            System.out.println("(1) Volver al Menú principal");
                            System.out.println("(2) Salir del programa");
                            System.out.println("Escriba su opcion:");
                            menuOpciones=teclado.nextInt();
                            teclado.nextLine();
                            if (menuOpciones == 1) {
                                break;
                            } else if (menuOpciones == 2) {
                                programa=false;
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            
                            // ELIMINAR PERSONAL
                            
                            System.out.println("-- Eliminar personal --");
                            persona.eliminarPersona(personal);
                            System.out.println("¿Que quiere hacer ahora?");
                            System.out.println("(1) Volver al Menú principal");
                            System.out.println("(2) Salir del programa");
                            System.out.println("Escriba su opcion:");
                            menuOpciones=teclado.nextInt();
                            teclado.nextLine();
                            if (menuOpciones == 1) {
                                break;
                            } else if (menuOpciones == 2) {
                                programa=false;
                                break;
                            } else {
                                break;
                            }
                        default:
                            System.out.println("Opcion incorrecta.");
                    }
                    break;
                case 3 :
                    
                    // GESTIONAR USUARIOS
                    
                    System.out.println("-- Gestionar usuarios --");
                    System.out.println("(1) Mostrar lista usuarios");
                    System.out.println("(2) Añadir usuario");
                    System.out.println("(3) Eliminar usuario");
                    System.out.println("Escriba su opcion:");
                    menuOpciones = teclado.nextInt();
                    teclado.nextLine();
                    switch (menuOpciones) {
                        case 1 :
                            
                            // MOSTRAR LISTA USUARIOS
                            
                            System.out.println("-- Mostrar lista usuarios --");
                            usuario.mostrarUsuarios(listaUsuarios);
                            System.out.println("¿Que quiere hacer ahora?");
                            System.out.println("(1) Volver al Menú principal");
                            System.out.println("(2) Salir del programa");
                            System.out.println("Escriba su opcion:");
                            menuOpciones=teclado.nextInt();
                            teclado.nextLine();
                            if (menuOpciones == 1) {
                                break;
                            } else if (menuOpciones == 2) {
                                programa=false;
                                break;
                            } else {
                                break;
                            }
                        case 2 :
                            
                            // AÑADIR USUARIO
                            
                            System.out.println("-- Añadir usuario --");
                            usuario.añadirUsuario(listaUsuarios);
                            System.out.println("¿Que quiere hacer ahora?");
                            System.out.println("(1) Volver al Menú principal");
                            System.out.println("(2) Salir del programa");
                            System.out.println("Escriba su opcion:");
                            menuOpciones=teclado.nextInt();
                            teclado.nextLine();
                            if (menuOpciones == 1) {
                                break;
                            } else if (menuOpciones == 2) {
                                programa=false;
                                break;
                            } else {
                                break;
                            }
                        case 3 :
                            
                            // ELIMINAR USUARIO
                            
                            System.out.println("-- Eliminar usuario --");
                            usuario.eliminarUsuario(listaUsuarios);
                            System.out.println("¿Que quiere hacer ahora?");
                            System.out.println("(1) Volver al Menú principal");
                            System.out.println("(2) Salir del programa");
                            System.out.println("Escriba su opcion:");
                            menuOpciones=teclado.nextInt();
                            teclado.nextLine();
                            if (menuOpciones == 1) {
                                break;
                            } else if (menuOpciones == 2) {
                                programa=false;
                                break;
                            } else {
                                break;
                            }
                        default:
                            System.out.println("Opcion incorrecta.");
                    }
                    break;
                case 4 :
                    
                    // GESTIONAR LIBROS
                    
                    System.out.println("-- Gestionar libros --");
                    System.out.println("(1) Añadir libro");
                    System.out.println("(2) Eliminar libro");
                    System.out.println("(3) Buscar libro por ISBN");
                    System.out.println("(4) Buscar libro por titulo");
                    System.out.println("Escriba su opcion:");
                    menuOpciones=teclado.nextInt();
                    teclado.nextLine();
                    switch (menuOpciones) {
                        case 1:
                            
                            // AÑADIR LIBRO
                            
                            System.out.println("-- Añadir libro --");
                            libro.añadirLibro(listaLibros);
                            System.out.println("¿Que quiere hacer ahora?");
                            System.out.println("(1) Volver al Menú principal");
                            System.out.println("(2) Salir del programa");
                            System.out.println("Escriba su opcion:");
                            menuOpciones=teclado.nextInt();
                            teclado.nextLine();
                            if (menuOpciones == 1) {
                                break;
                            } else if (menuOpciones == 2) {
                                programa=false;
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            
                            // ELIMINAR LIBRO
                            
                            System.out.println("-- Eliminar libro --");
                            System.out.println("Escriba el ISBN del libro a eliminar:");
                            texto=teclado.nextLine();
                            libro.eliminarLibro(listaLibros, listaReservas, texto);
                            System.out.println("¿Que quiere hacer ahora?");
                            System.out.println("(1) Volver al Menú principal");
                            System.out.println("(2) Salir del programa");
                            System.out.println("Escriba su opcion:");
                            menuOpciones=teclado.nextInt();
                            teclado.nextLine();
                            if (menuOpciones == 1) {
                                break;
                            } else if (menuOpciones == 2) {
                                programa=false;
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            
                            // BUSCAR LIBRO ISBN
                            
                            System.out.println("-- Buscar libro por ISBN --");
                            System.out.println("Introduzca el ISBN del libro:");
                            texto=teclado.nextLine();
                            int indexLibro = Libro.buscarLibroISBN(listaLibros, texto);
                            if (indexLibro == -1) {
                                System.out.println("El libro con ISBN "+texto+" no existe");
                            } else {
                                System.out.println(listaLibros.get(indexLibro).toString());
                            }
                            System.out.println("¿Que quiere hacer ahora?");
                            System.out.println("(1) Volver al Menú principal");
                            System.out.println("(2) Salir del programa");
                            System.out.println("Escriba su opcion:");
                            menuOpciones=teclado.nextInt();
                            teclado.nextLine();
                            if (menuOpciones == 1) {
                                break;
                            } else if (menuOpciones == 2) {
                                programa=false;
                                break;
                            } else {
                                break;
                            }
                        case 4:
                            
                            // BUSCAR LIBRO TITULO
                            
                            System.out.println("-- Buscar libro por titulo --");
                            System.out.println("Introduzca el titulo del libro:");
                            texto=teclado.nextLine();
                            libro.buscarLibroTitulo(listaLibros, texto);
                            System.out.println("¿Que quiere hacer ahora?");
                            System.out.println("(1) Volver al Menú principal");
                            System.out.println("(2) Salir del programa");
                            System.out.println("Escriba su opcion:");
                            menuOpciones=teclado.nextInt();
                            teclado.nextLine();
                            if (menuOpciones == 1) {
                                break;
                            } else if (menuOpciones == 2) {
                                programa=false;
                                break;
                            } else {
                                break;
                            }
                        default:
                            System.out.println("Opcion incorrecta.");
                    }
                    break;
                case 5 :
                    
                    // GESTIONAR RESERVAS
                    
                    System.out.println("-- Gestionar reservas --");
                    System.out.println("(1) Mostrar lista reservas");
                    System.out.println("(2) Crear reserva");
                    System.out.println("(3) Devolución libros");
                    System.out.println("Escriba su opción:");
                    menuOpciones=teclado.nextInt();
                    teclado.nextLine();
                    switch(menuOpciones) {
                        case 1 :
                            
                            // MOSTRAR RESERVAS
                            
                            System.out.println("-- Mostrar lista reservas --");
                            reserva.mostrarReservas(listaReservas);
                            System.out.println("¿Que quiere hacer ahora?");
                            System.out.println("(1) Volver al Menú principal");
                            System.out.println("(2) Salir del programa");
                            System.out.println("Escriba su opcion:");
                            menuOpciones=teclado.nextInt();
                            teclado.nextLine();
                            if (menuOpciones == 1) {
                                break;
                            } else if (menuOpciones == 2) {
                                programa=false;
                                break;
                            } else {
                                break;
                            }
                        case 2 :
                            
                            // CREAR RESERVAS
                            
                            System.out.println("-- Crear reserva --");
                            reserva.crearReserva(listaReservas, listaUsuarios, listaLibros);
                            System.out.println("¿Que quiere hacer ahora?");
                            System.out.println("(1) Volver al Menú principal");
                            System.out.println("(2) Salir del programa");
                            System.out.println("Escriba su opcion:");
                            menuOpciones=teclado.nextInt();
                            teclado.nextLine();
                            if (menuOpciones == 1) {
                                break;
                            } else if (menuOpciones == 2) {
                                programa=false;
                                break;
                            } else {
                                break;
                            }
                        case 3 :
                            
                            // DEVOLUCION LIBROS
                            System.out.println("-- Devolución libros --");
                            reserva.devolucionLibros(listaUsuarios, listaLibros, listaReservas);
                            System.out.println("¿Que quiere hacer ahora?");
                            System.out.println("(1) Volver al Menú principal");
                            System.out.println("(2) Salir del programa");
                            System.out.println("Escriba su opcion:");
                            menuOpciones=teclado.nextInt();
                            teclado.nextLine();
                            if (menuOpciones == 1) {
                                break;
                            } else if (menuOpciones == 2) {
                                programa=false;
                                break;
                            } else {
                                break;
                            }
                        default :
                            System.out.println("Opcion incorrecta");
                    }
                    break;
                default :
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }
    }
 
}

package Ventana_Principal;

/**
 * @author Emersson
 */
public class Persona {
    
     private String nombre;
    private String apellido;
    private String id;
    

    public Persona(String nombre, String apellido, String id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
    }
    
    public Persona() {
        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nApellido: " + apellido + "\nId: " + id  + "\n";
    }
    
//     @Override
//    public String toString() {
//        return  nombre + " " + apellido;
//    }
}

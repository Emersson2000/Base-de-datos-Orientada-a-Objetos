package Ventana_Principal;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * @author Emersson
 */
public class Conexion {

//    private ObjectContainer oc =  Db4o.openFile("database.yap");
    private ObjectContainer oc;
    private Persona p;

    private void open() {
        oc = Db4o.openFile("C:\\Users\\lenovo\\Documents\\NetBeansProjects\\Base_de_Datos_Orientada_a_Objetos\\database.yap");
    }

    public boolean Insertar(Persona objeto) {
        try {
            open();
            oc.set(objeto);
            oc.close();
            return true;
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("bdoo.Controlador.insertarPersona() : " + e);
            return false;
        }
    }

    public ArrayList<Persona> consultarListaPersonas() {
        p = new Persona(null, null, null);
        String lista[] = new String[3];
        ArrayList<Persona> per = new ArrayList<Persona>();
        open();
        ObjectSet result = oc.get(p);
        while (result.hasNext()) {
            per.add((Persona) result.next());
        }
        oc.close();
        return per;
    }
    
    public void actualizarPersona(Persona persona, Persona editar) {
        open();
        Persona pers = new Persona(editar.getNombre(), editar.getApellido(), editar.getId());
        ObjectSet result = oc.get(pers);
        Persona per = (Persona) result.next();
        per.setNombre(persona.getNombre());
        per.setApellido(persona.getApellido());
        per.setId(persona.getId());
        oc.set(per);
        oc.close();
    }
    
    public void eliminarPersona(Persona editar) {
        open();
        Persona pers = new Persona(editar.getNombre(), editar.getApellido(), editar.getId());
        ObjectSet result = oc.get(pers);
        Persona per = (Persona) result.next();
        oc.delete(per);
        oc.close();
    }
}


package gestordearchivos.service;


import gestordearchivos.acciones.Accion;
import gestordearchivos.factory.FabricaAccion;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GestorAcciones {
    private final Map<String, FabricaAccion> fabricas = new ConcurrentHashMap<>();

    public void registrarFabrica(String tipo, FabricaAccion fabrica) {
        fabricas.put(tipo, fabrica);
    }

    public Accion crearAccion(String tipo, Object... params) {
        FabricaAccion f = fabricas.get(tipo);    
        Accion accion = f.crearAccion(params);      
        return accion;
    }

}

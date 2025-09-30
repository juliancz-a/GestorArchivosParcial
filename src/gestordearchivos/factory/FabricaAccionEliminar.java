
package gestordearchivos.factory;

import gestordearchivos.acciones.Accion;
import gestordearchivos.acciones.AccionEliminar;

public class FabricaAccionEliminar implements FabricaAccion{
    
    @Override
    public Accion crearAccion(Object... params) {
        if (params.length < 1) throw new IllegalArgumentException("Se requiere nombre de archivo");
        String nombre = (String) params[0];
        return new AccionEliminar(nombre);
    }
}

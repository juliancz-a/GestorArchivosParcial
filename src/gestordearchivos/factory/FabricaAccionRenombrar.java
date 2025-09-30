package gestordearchivos.factory;

import gestordearchivos.acciones.Accion;
import gestordearchivos.acciones.AccionRenombrar;

public class FabricaAccionRenombrar implements FabricaAccion{
    
    @Override
    public Accion crearAccion(Object... params) {
        if (params.length < 2) throw new IllegalArgumentException("Se requiere origen y nuevoNombre");
        String origen = (String) params[0];
        String nuevoNombre = (String) params[1];
        return new AccionRenombrar(origen, nuevoNombre);
    }
}

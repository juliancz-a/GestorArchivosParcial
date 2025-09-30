package gestordearchivos.factory;

import gestordearchivos.acciones.Accion;
import gestordearchivos.acciones.AccionCopiar;

public class FabricaAccionCopiar implements FabricaAccion {
    
    @Override
    public Accion crearAccion(Object... params) {
        if (params.length < 1) throw new IllegalArgumentException("Se requiere nombre del archivo a copiar");
        String nombreArchivo = (String) params[0];
        return new AccionCopiar(nombreArchivo);
    }
}

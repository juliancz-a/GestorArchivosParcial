
package gestordearchivos.factory;

import gestordearchivos.acciones.Accion;

public interface FabricaAccion {
    Accion crearAccion(Object... params);
}
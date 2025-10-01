
package gestordearchivos.acciones;

import gestordearchivos.GestorArchivos;

public abstract class Accion {
    private EstadoAccion estado = EstadoAccion.EN_ESPERA; // Estado Inicial
    protected final GestorArchivos gestor = GestorArchivos.getInstancia();
    
    public EstadoAccion getEstado() { return estado; }
    protected void setEstado(EstadoAccion e) { this.estado = e; }
    public abstract boolean ejecutar(); // true si ok
    public abstract String obtenerDescripcion();
}

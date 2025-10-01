package gestordearchivos.acciones;

public class AccionRenombrar extends Accion {
    private final String nombreActual;
    private final String nuevoNombre;

    public AccionRenombrar(String nombreActual, String nuevoNombre) {
        this.nombreActual = nombreActual;
        this.nuevoNombre = nuevoNombre;
    }

    @Override
    public boolean ejecutar() {
        setEstado(EstadoAccion.EN_PROCESO);
        try {
            boolean ok = gestor.renombrarArchivo(nombreActual, nuevoNombre);
            setEstado(ok ? EstadoAccion.FINALIZADA : EstadoAccion.ERROR);
            return ok;
        } catch (Exception ex) {
            setEstado(EstadoAccion.ERROR);
            return false;
        }
    }

    @Override
    public String obtenerDescripcion() {
        return "Renombrar " + nombreActual + " -> " + nuevoNombre;
    }
}
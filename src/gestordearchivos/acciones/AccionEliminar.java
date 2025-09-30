package gestordearchivos.acciones;

public class AccionEliminar extends Accion {
    private final String nombreArchivo;

    public AccionEliminar(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public boolean ejecutar() {
        setEstado(EstadoAccion.EN_PROCESO);
        try {
            boolean ok = gestor.eliminarArchivo(nombreArchivo);
            setEstado(ok ? EstadoAccion.FINALIZADA : EstadoAccion.ERROR);
            return ok;
        } catch (Exception ex) {
            setEstado(EstadoAccion.ERROR);
            return false;
        }
    }

    @Override
    public String obtenerDescripcion() {
        return "Eliminar archivo: " + nombreArchivo;
    }
}

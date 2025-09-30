package gestordearchivos.acciones;

public class AccionRenombrar extends Accion {
    private final String origen;
    private final String nuevoNombre;

    public AccionRenombrar(String origen, String nuevoNombre) {
        this.origen = origen;
        this.nuevoNombre = nuevoNombre;
    }

    @Override
    public boolean ejecutar() {
        setEstado(EstadoAccion.EN_PROCESO);
        try {
            boolean ok = gestor.renombrarArchivo(origen, nuevoNombre);
            setEstado(ok ? EstadoAccion.FINALIZADA : EstadoAccion.ERROR);
            return ok;
        } catch (Exception ex) {
            setEstado(EstadoAccion.ERROR);
            return false;
        }
    }

    @Override
    public String obtenerDescripcion() {
        return "Renombrar " + origen + " -> " + nuevoNombre;
    }
}
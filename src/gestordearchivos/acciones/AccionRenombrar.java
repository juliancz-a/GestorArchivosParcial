package gestordearchivos.acciones;

public class AccionRenombrar extends Accion {
    private final String viejoNombre;
    private final String nuevoNombre;

    public AccionRenombrar(String viejoNombre, String nuevoNombre) {
        this.viejoNombre = viejoNombre;
        this.nuevoNombre = nuevoNombre;
    }

    @Override
    public boolean ejecutar() {
        setEstado(EstadoAccion.EN_PROCESO);
        try {
            boolean ok = gestor.renombrarArchivo(viejoNombre, nuevoNombre);
            setEstado(ok ? EstadoAccion.FINALIZADA : EstadoAccion.ERROR);
            return ok;
        } catch (Exception ex) {
            setEstado(EstadoAccion.ERROR);
            return false;
        }
    }

    @Override
    public String obtenerDescripcion() {
        return "Renombrar " + viejoNombre + " -> " + nuevoNombre;
    }
}
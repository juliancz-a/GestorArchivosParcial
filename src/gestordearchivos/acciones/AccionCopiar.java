package gestordearchivos.acciones;
import gestordearchivos.model.Archivo;

public class AccionCopiar extends Accion {
    private final String nombreArchivo;

    public AccionCopiar(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public boolean ejecutar() {
        setEstado(EstadoAccion.EN_PROCESO);
        try {
            Archivo a = gestor.buscarArchivoPorNombre(nombreArchivo).orElse(null);
            if (a == null) { setEstado(EstadoAccion.ERROR); return false; }

            boolean ok = gestor.crearArchivo(nombreArchivo + "_copy", a.getPath(), a.getTamanio(), a.getTipo());
            setEstado(ok ? EstadoAccion.FINALIZADA : EstadoAccion.ERROR);

            return ok;

        } catch (Exception ex) {
            setEstado(EstadoAccion.ERROR);
            return false;
        }
    }

    @Override
    public String obtenerDescripcion() {
        return "Copiar " + nombreArchivo + " -> " + nombreArchivo + "_copy";
    }
}
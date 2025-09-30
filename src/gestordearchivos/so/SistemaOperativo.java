
package gestordearchivos.so;

import gestordearchivos.model.Archivo;
import gestordearchivos.repositorio.RepositorioArchivos;

import java.util.List;

public class SistemaOperativo {
    private RepositorioArchivos repo;
    private final long CAPACIDAD_TOTAL; // bytes
    private long capacidadUsada = 0;

    public SistemaOperativo(long capacidadTotal, RepositorioArchivos repo) {
        this.repo = repo;
        this.CAPACIDAD_TOTAL = capacidadTotal;
    }

    private boolean verificarEspacio(long tamanio) {
        return (capacidadUsada + tamanio) <= CAPACIDAD_TOTAL;
    }

    // cuando se "crea" un archivo en este SO, aumentamos capacidadUsada
    private boolean asignarEspacio(long tamanio) {
        if (verificarEspacio(tamanio)){
            capacidadUsada += tamanio;
            return true;
        }
        return false;
    }

    private void liberarEspacio(long tamanio) {
        capacidadUsada = Math.max(0, capacidadUsada - tamanio);
    }

    public boolean crearEstructuraArchivo(String nombre, String path, long tamanio, String tipo) {
        if (!this.asignarEspacio(tamanio)) {
            System.out.println("[SO] Espacio insuficiente para crear archivo en " + path);
            return false;
        }

        repo.crear(nombre, path, tamanio, tipo);
        System.out.println("[SO] Se creo el archivo en " + path);
        return true;
    }

    public void eliminarEstructuraArchivo(Archivo a) {
        System.out.println("[SO] Se elimino el archivo: " + a.getNombre());
        repo.eliminar(a);
        this.liberarEspacio(a.getTamanio());

    }

    public void renombrarEstructuraArchivo(Archivo a, String nuevoNombre) {
        System.out.println("[SO] Se renombró el archivo. Nuevo Path: " + nuevoNombre);
        repo.modificar(a, nuevoNombre, -1);
    }

    public List<Archivo> getArchivos() {
        return repo.getArchivos();
    }

    public long getCapacidadTotal() { return CAPACIDAD_TOTAL; }
    public long getEspacioUsado()  { return capacidadUsada; }
    public long getEspacioLibre() { return CAPACIDAD_TOTAL - capacidadUsada; }
}

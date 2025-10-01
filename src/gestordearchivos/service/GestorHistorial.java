
package gestordearchivos.service;

import gestordearchivos.model.Archivo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorHistorial {
    private final List<Archivo> archivosBorrados = Collections.synchronizedList(new ArrayList<>());

    public void agregarEliminado(Archivo a) {
        archivosBorrados.add(a);
    }

    public List<Archivo> listarEliminados() {
        return new ArrayList<>(archivosBorrados);
    }
}
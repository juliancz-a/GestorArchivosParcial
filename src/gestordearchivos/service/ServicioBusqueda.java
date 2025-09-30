
package gestordearchivos.service;

import gestordearchivos.model.Archivo;
import gestordearchivos.repositorio.RepositorioArchivos;
import gestordearchivos.so.SistemaOperativo;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ServicioBusqueda {
    private final SistemaOperativo so;

    public ServicioBusqueda(SistemaOperativo so) {
        this.so = so;
    }

    public List<Archivo> buscarPorTipo(String tipo) {
        return so.getArchivos().parallelStream()
                .filter(a -> a.getTipo().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }

    public List<Archivo> buscarPorNombre(String nombre) {
        return so.getArchivos().parallelStream()
                .filter(a -> a.getNombre().contains(nombre))
                .collect(Collectors.toList());
    }

    public List<Archivo> buscarPorFecha(LocalDate fecha) {
        return so.getArchivos().parallelStream()
                .filter(a -> a.getFechaCreacion().toLocalDate().equals(fecha))
                .collect(Collectors.toList());
    }
}

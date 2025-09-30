
package gestordearchivos.service;

import gestordearchivos.model.Archivo;
import gestordearchivos.repositorio.RepositorioArchivos;
import gestordearchivos.so.SistemaOperativo;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ServicioBusqueda {

    private final RepositorioArchivos repositorio;

    public ServicioBusqueda(RepositorioArchivos repositorio) {
        this.repositorio = repositorio;
    }

    public List<Archivo> buscarPorTipo(String tipo) {
        return repositorio.getArchivos().stream()
                .filter(a -> a.getTipo().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }

    public List<Archivo> buscarPorNombre(String nombre) {
        return repositorio.getArchivos().stream()
                .filter(a -> a.getNombre().contains(nombre))
                .collect(Collectors.toList());
    }

    public List<Archivo> buscarPorFecha(LocalDate fecha) {
        return repositorio.getArchivos().stream()
                .filter(a -> a.getFechaCreacion().toLocalDate().equals(fecha))
                .collect(Collectors.toList());
    }
}

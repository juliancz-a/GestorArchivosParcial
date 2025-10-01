
package gestordearchivos.service;

import gestordearchivos.model.Archivo;
import gestordearchivos.repositorio.RepositorioArchivos;
import gestordearchivos.so.SistemaOperativo;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ServicioBusqueda {

    private final RepositorioArchivos repo;

    public ServicioBusqueda(RepositorioArchivos repo) {
        this.repo = repo;
    }

    public List<Archivo> buscarPorTipo(String tipo) {
        return repo.getArchivos().stream()
                .filter(a -> a.getTipo().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }

    public List<Archivo> buscarPorNombre(String nombre) {
        return repo.getArchivos().stream()
                .filter(a -> a.getNombre().contains(nombre))
                .collect(Collectors.toList());
    }

    public List<Archivo> buscarPorFecha(LocalDate fecha) {
        return repo.getArchivos().stream()
                .filter(a -> a.getFechaCreacion().toLocalDate().equals(fecha))
                .collect(Collectors.toList());
    }
}

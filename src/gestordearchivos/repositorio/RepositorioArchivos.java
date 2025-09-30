
package gestordearchivos.repositorio;

import gestordearchivos.model.*;

import java.util.ArrayList;
import java.util.List;


public class RepositorioArchivos {
    private final List<Archivo> archivos = new ArrayList<>();

    public Archivo crear(String nombre, String path, long tamanio, String tipo) {
        Archivo archivo = switch (tipo.toUpperCase()) {
            case "IMAGEN" -> new Imagen(nombre, path, tamanio);
            case "VIDEO" -> new Video(nombre, path, tamanio);
            case "AUDIO" -> new Audio(nombre, path, tamanio);
            case "DOCUMENTO" -> new Documento(nombre, path, tamanio);
            default -> null;
        };

        if (archivo != null) { archivos.add(archivo); }

        return archivo;
    }

    public void eliminar(Archivo archivo) {
        archivos.remove(archivo);
    }

    public Archivo modificar(Archivo archivo, String nuevoNombre, long nuevoTamanio) {
        if (nuevoNombre != null) archivo.setNombre(nuevoNombre);
        if (nuevoTamanio >= 0) archivo.setTamanio(nuevoTamanio);
        
        return archivo;
    }

    public List<Archivo> getArchivos() {
        return archivos;
    }
}


package gestordearchivos;

import gestordearchivos.model.Archivo;
import gestordearchivos.repositorio.RepositorioArchivos;
import gestordearchivos.service.GestorHistorial;
import gestordearchivos.service.ServicioBusqueda;
import gestordearchivos.so.SistemaOperativo;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public class GestorArchivos {
    private static GestorArchivos instancia;

    private final SistemaOperativo so;
    private final ServicioBusqueda servicioBusqueda;
    private final GestorHistorial gestorHistorial;

    private GestorArchivos(SistemaOperativo so, ServicioBusqueda servicioBusqueda) {
        this.so = so;
        this.servicioBusqueda = servicioBusqueda;
        this.gestorHistorial = new GestorHistorial();
    }

    public static void init(SistemaOperativo so, ServicioBusqueda servicioBusqueda) {
        if (instancia == null) {
            instancia = new GestorArchivos(so, servicioBusqueda);
        }
    }

    public static GestorArchivos getInstancia() {
        if (instancia == null) throw new IllegalStateException("Gestor no inicializado. Llamar init() primero.");
        return instancia;
    }

    public boolean crearArchivo(String nombre, String path, long tamanio, String tipo) {
        return this.so.crearEstructuraArchivo(nombre, path, tamanio, tipo);
    }
    
    public boolean eliminarArchivo(String nombre) {
        System.out.println("Eliminando archivo");
        Optional<Archivo> opt = servicioBusqueda.buscarPorNombre(nombre).stream().findFirst();
        if (!opt.isPresent()) return false;

        Archivo a = opt.get();
        
        so.eliminarEstructuraArchivo(a);
        gestorHistorial.agregarEliminado(a);

        return true;
    }

    public boolean renombrarArchivo(String nombreActual, String nuevoNombre) {
        Optional<Archivo> opt = servicioBusqueda.buscarPorNombre(nombreActual).stream().findFirst();
        if (opt.isEmpty()) {
            return false;
        }
        Archivo a = opt.get();

        so.renombrarEstructuraArchivo(a, nuevoNombre);
        return true;
    }

    public List<Archivo> listarArchivos() {
        return so.getArchivos();
    }

    public List<Archivo> buscarArchivosPorNombre(String nombre) {
        return servicioBusqueda.buscarPorNombre(nombre);
    }

    public Optional<Archivo> buscarArchivoPorNombre(String nombre) {
        return servicioBusqueda.buscarPorNombre(nombre)
                               .stream()
                               .findFirst(); // el primero, si existe
    }

    public List<Archivo> buscarArchivosPorTipo(String tipo) {
        return servicioBusqueda.buscarPorTipo(tipo);
    }

    public List<Archivo> buscarArchivosPorFecha(LocalDate fecha) {
        return servicioBusqueda.buscarPorFecha(fecha);
    }

    public ServicioBusqueda getServicioBusqueda() { return servicioBusqueda; }
    public GestorHistorial getHistorial() { return gestorHistorial; }
}

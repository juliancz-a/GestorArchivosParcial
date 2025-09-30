package gestordearchivos;

import gestordearchivos.acciones.Accion;
import gestordearchivos.factory.*;
import gestordearchivos.model.*;
import gestordearchivos.repositorio.RepositorioArchivos;
import gestordearchivos.service.GestorAcciones;
import gestordearchivos.service.ServicioBusqueda;
import gestordearchivos.so.SistemaOperativo;


public class EntryPoint {

    public static void main(String[] args) {
        
         // init repositorio y SO con 1MB de capacidad
        RepositorioArchivos repo = new RepositorioArchivos();
        ServicioBusqueda servicioBusqueda = new ServicioBusqueda(repo);
        SistemaOperativo so = new SistemaOperativo(1_000_000, repo);

        // inicializar singleton -> le agregamos el SO y El servicio de Busqueda correspondiente
        GestorArchivos.init(so, servicioBusqueda);
        GestorArchivos gestor = GestorArchivos.getInstancia();

        // crear archivos
        gestor.crearArchivo("foto1.png", "root/images", 120_000, "IMAGEN");
        gestor.crearArchivo("doc1.pdf", "root/documents", 20_000, "DOCUMENTO");
        gestor.crearArchivo("video1.mp4", "root/videos", 50_000, "VIDEO");
        gestor.crearArchivo("audio1.mp3", "root/audio", 5_000, "AUDIO");


        System.out.println("==========================================================");
        System.out.println("Listando archivos:");
        gestor.listarArchivos().forEach(a -> System.out.println(" - " + a.obtenerInfo()));
        System.out.println("==========================================================");

        // configurar gestor de acciones y fábricas
        GestorAcciones gestorAcciones = new GestorAcciones();
        gestorAcciones.registrarFabrica("eliminar", new FabricaAccionEliminar());
        gestorAcciones.registrarFabrica("copiar", new FabricaAccionCopiar());
        gestorAcciones.registrarFabrica("renombrar", new FabricaAccionRenombrar());

        // crear y ejecutar acción eliminar
        System.out.println("==========================================================");
        System.out.println("ACCIONES DEL USUARIO");
        Accion act1 = gestorAcciones.crearAccion("eliminar", "doc1.pdf");
        gestorAcciones.ejecutarAccion(act1);
        System.out.println("Acción: " + act1.obtenerDescripcion() + " => " + act1.getEstado());

        // copiar foto1 -> foto1_copy
        Accion act2 = gestorAcciones.crearAccion("copiar", "foto1.png");
        gestorAcciones.ejecutarAccion(act2);
        System.out.println("Acción: " + act2.obtenerDescripcion() + " => " + act2.getEstado());

        // renombrar video1
        Accion act3 = gestorAcciones.crearAccion("renombrar", "video1.mp4", "video_grande.mp4");
        gestorAcciones.ejecutarAccion(act3);
        System.out.println("Acción: " + act3.obtenerDescripcion() + " => " + act3.getEstado());

        System.out.println("==========================================================");
        System.out.println("\nArchivos tras acciones:");
        gestor.listarArchivos().forEach(a -> System.out.println(" - " + a.obtenerInfo()));
        System.out.println("==========================================================");
        
        // búsquedas
        System.out.println("BUSQUEDAS");
        System.out.println("\nBuscar por tipo Imagen:");
        gestor.buscarArchivosPorTipo("IMAGEN").forEach(a -> System.out.println(" * " + a.obtenerInfo()));
        System.out.println("==========================================================");

        System.out.println("\nHistorial de eliminados:");
        gestor.getHistorial().listarEliminados().forEach(a -> System.out.println(" # " + a.obtenerInfo()));    
    }
    
}

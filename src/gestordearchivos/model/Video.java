
package gestordearchivos.model;

public class Video extends Archivo {
    public Video(String nombre, String path, long tamanio) {
        super(nombre, path , tamanio);
    }
    @Override public String getTipo() { return "Video"; }
}
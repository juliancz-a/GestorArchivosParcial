
package gestordearchivos.model;

public class Audio extends Archivo {

    public Audio(String nombre, String path, long tamanio) {
        super(nombre, path , tamanio);
    }
    @Override public String getTipo() { return "Audio"; }
}

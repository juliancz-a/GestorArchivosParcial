
package gestordearchivos.model;

    
public class Documento extends Archivo {
    
    public Documento(String nombre, String path, long tamanio) {
        super(nombre, path , tamanio);
    }
    @Override public String getTipo() { return "Documento"; }
    
}

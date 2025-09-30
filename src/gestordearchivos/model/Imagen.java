package gestordearchivos.model;

public class Imagen extends Archivo {
    
    public Imagen(String nombre, String path, long tamanio) {
        super(nombre, path , tamanio);
    }
    @Override public String getTipo() { return "Imagen"; }
    
}

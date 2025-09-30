package gestordearchivos.model;

import java.time.LocalDateTime;

public abstract class Archivo {
    private String nombre;
    private String path;
    private final LocalDateTime fechaCreacion;
    private long tamanio; // bytes
    private EstadoArchivo estado;

    public Archivo(String nombre, String path, long tamanio) {
        this.nombre = nombre;
        this.path = path;
        this.tamanio = tamanio;
        this.fechaCreacion = LocalDateTime.now();
        this.estado = EstadoArchivo.VISIBLE;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getPath() { return path; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public long getTamanio() { return tamanio; }
    public EstadoArchivo getEstado() { return estado; }

    //Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPath(String path) { this.path = path; }
    public void setTamanio(long tamanio) { this.tamanio = tamanio; }
    public void setEstado(EstadoArchivo estado) { this.estado = estado; }

    public String obtenerInfo() {
        return String.format("name = %s path = %s(tamaño=%d bytes, creado=%s, estado=%s)",
                nombre, path, tamanio, fechaCreacion, estado);
    }

    public abstract String getTipo(); // "Imagen", "Documento", ...
}

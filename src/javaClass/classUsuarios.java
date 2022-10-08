package javaClass;


public class classUsuarios {
    private Integer id;
    private String nombre;
    private String apellido;
    private String correo;
    private String fecha;
    private Integer genero;
    private String error;

    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getGenero() {
        return genero;
    }

    public void setGenero(Integer genero) {
        this.genero = genero;
    }
    
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    //</editor-fold>
    
    public boolean insert(){
        return methodsSQL.execute("INSERT INTO usuarios VALUES ( ?, ?, ?, ?, ?, ?, ?)", id, nombre, apellido, genero, fecha, null, correo);
    }
    
    public boolean delete(){
        return methodsSQL.execute("DELETE FROM usuarios WHERE id = ? ", id);
    }
    
    public boolean update(){
        return methodsSQL.execute("UPDATE usuarios SET nombre = ?, apellido = ?, id_genero = ?, fecha_nacimiento = ?, correo = ? WHERE id = ?", nombre, apellido, genero, fecha, correo, id);
    }
}

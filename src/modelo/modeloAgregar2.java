
package modelo;


public class modeloAgregar2 {
   
    private int idRegistro;
    private String codigo;
    private String nombre;
    private String apellido;
    private int edad;
    private String sexo;
    private String dpto;
    private String ciudad;
    private String barrio;
    private int relacionDpto;
    private int relacionCiudad;
    private int relacionBarrio;

    public int getRelacionBarrio() {
        return relacionBarrio;
    }

    public void setRelacionBarrio(int relacionBarrio) {
        this.relacionBarrio = relacionBarrio;
    }

    public int getRelacionDpto() {
        return relacionDpto;
    }

    public void setRelacionDpto(int relacionDpto) {
        this.relacionDpto = relacionDpto;
    }

    public int getRelacionCiudad() {
        return relacionCiudad;
    }

    public void setRelacionCiudad(int relacionCiudad) {
        this.relacionCiudad = relacionCiudad;
    }

    public int getRelacion() {
        return relacionDpto;
    }

    public void setRelacion(int relacion) {
        this.relacionDpto = relacion;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

}
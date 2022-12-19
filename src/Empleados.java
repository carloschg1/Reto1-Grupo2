public class Empleados {

    public int idDep;
    public String NIF;
    public String nombre;
    public String apellido1;
    public String apellido2;
    public String cuenta;
    public String antiguedad;
    public String nASeguridadSocial;
    public String catGProfesional;
    public int gCotizacion;
    public String email;

    public Empleados(String NIF, String nombre, String apellido1, String apellido2, String cuenta, String antiguedad, String nASeguridadSocial, String catGProfesional, int gCotizacion, String email, int idDep) {
        this.idDep = idDep;
        this.NIF = NIF;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.cuenta = cuenta;
        this.antiguedad = antiguedad;
        this.nASeguridadSocial = nASeguridadSocial;
        this.catGProfesional = catGProfesional;
        this.gCotizacion = gCotizacion;
        this.email = email;
    }

    
    public int getIdDep() {
        return idDep;
    }
    public String getNIF() {
        return NIF;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido1() {
        return apellido1;
    }
    public String getApellido2() {
        return apellido2;
    }
    public String getCuenta() {
        return cuenta;
    }
    public String getAntiguedad() {
        return antiguedad;
    }
    public String getNASeguridadSocial() {
        return nASeguridadSocial;
    }
    public String getCatGProfesional() {
        return catGProfesional;
    }
    public int getGCotizacion() {
        return gCotizacion;
    }
    public String getEmail() {
        return email;
    }
}

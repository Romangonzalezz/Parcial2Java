public class Cliente {
    private String apellido;
    private String email;
    private String DNI;


    public Cliente(String apellido, String email, String DNI) {
        this.apellido = apellido;
        this.email = email;
        this.DNI = DNI;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getDNI() {
        return DNI;
    }
}

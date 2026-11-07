package usuario;

public class Usuario {

    // ATRIBUTOS
    private String nombreUsuario = "Sin nombre";
    private String correo = "Sin correo";
    private String contrasena = "Sin contraseña";

    // CONSTRUCTOR
    // Crea un usuario con sus tres datos. Usa los set para que también se revisen las validaciones
    public Usuario(String nombreUsuario, String correo, String contrasena) {
        setNombreUsuario(nombreUsuario);
        setCorreo(correo);
        setContrasena(contrasena);
    }

    // Guarda el nombre de usuario. Si viene vacío, avisa del error y no lo guarda
    public void setNombreUsuario(String nombreUsuario) {
        if (nombreUsuario != null && !nombreUsuario.trim().isEmpty()) {
            this.nombreUsuario = nombreUsuario;
        } else {
            System.out.println("Error: El nombre de usuario no puede estar en blanco.");
        }
    }
    // Devuelve el nombre de usuario
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    // Guarda el correo. Si no tiene @, avisa del error y no lo guarda
    public void setCorreo(String correo) {
        if (correo != null && correo.contains("@")) {
            this.correo = correo;
        } else {
            System.out.println("Error: El correo debe tener un @.");
        }
    }
    // Devuelve el correo
    public String getCorreo() {
        return correo;
    }

    // Guarda la contraseña. Si tiene menos de 8 caracteres, muestra una advertencia y no la guarda
    public void setContrasena(String contrasena) {
        if (contrasena != null && contrasena.length() >= 8) {
            this.contrasena = contrasena;
        } else {
            System.out.println("Advertencia: La contraseña debe tener al menos 8 caracteres.");
        }
    }
    // Devuelve la contraseña
    public String getContrasena() {
        return contrasena;
    }

    // MÉTODOS
    // Muestra el nombre de usuario y el correo (la contraseña nunca se muestra)
    public void mostrarDatos() {
        System.out.println("Usuario: " + nombreUsuario);
        System.out.println("Correo: " + correo);
    }
}

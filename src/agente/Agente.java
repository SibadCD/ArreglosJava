package agente;

public class Agente {

    // ATRIBUTOS
    private String nombre = "Sin nombre";
    private int nivelEnergia;
    private String estado = "inactivo";

    // CONSTRUCTOR
    // Crea un agente con sus tres datos. Para la energía y el estado usa los set y así se revisan las validaciones
    public Agente(String nombre, int nivelEnergia, String estado) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            System.out.println("Error: El nombre no puede estar en blanco.");
        }
        setNivelEnergia(nivelEnergia);
        setEstado(estado);
    }

    // El nombre solo se da al crear el agente y no cambia después, por eso no tiene set
    // Devuelve el nombre del agente
    public String getNombre() {
        return nombre;
    }

    // Guarda la energía del agente. Solo acepta valores de 0 a 100; si no, avisa del error
    public void setNivelEnergia(int nivelEnergia) {
        if (nivelEnergia >= 0 && nivelEnergia <= 100) {
            this.nivelEnergia = nivelEnergia;
        } else {
            System.out.println("Error: El nivel de energía debe estar entre 0 y 100.");
        }
    }
    // Devuelve el nivel de energía
    public int getNivelEnergia() {
        return nivelEnergia;
    }

    // Guarda el estado del agente. Solo acepta activo o inactivo; si no, avisa del error
    public void setEstado(String estado) {
        if (estado != null && (estado.trim().equalsIgnoreCase("activo")
                || estado.trim().equalsIgnoreCase("inactivo"))) {
            this.estado = estado.trim().toLowerCase();
        } else {
            System.out.println("Error: El estado debe ser activo o inactivo.");
        }
    }
    // Devuelve el estado (activo o inactivo)
    public String getEstado() {
        return estado;
    }

    // MÉTODOS
    // Muestra el nombre, la energía y el estado del agente
    public void mostrarEstado() {
        System.out.println("Agente: " + nombre + " | Energía: " + nivelEnergia + "% | Estado: " + estado);
    }
}

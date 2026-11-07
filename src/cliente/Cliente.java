package cliente;

public class Cliente {

    // ATRIBUTOS
    private String nombre = "Sin nombre";
    private String tipoCliente = "estándar";
    private double totalCompra;

    // CONSTRUCTOR
    // Crea un cliente con sus tres datos. Usa los set para que también se revisen las validaciones
    public Cliente(String nombre, String tipoCliente, double totalCompra) {
        setNombre(nombre);
        setTipoCliente(tipoCliente);
        setTotalCompra(totalCompra);
    }

    // Guarda el nombre del cliente. Si viene vacío, avisa del error y no lo guarda
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            System.out.println("Error: El nombre no puede estar en blanco.");
        }
    }
    // Devuelve el nombre del cliente
    public String getNombre() {
        return nombre;
    }

    // Guarda el tipo de cliente. Solo acepta premium o estándar (con o sin tilde); si no, avisa del error
    public void setTipoCliente(String tipoCliente) {
        if (tipoCliente != null && tipoCliente.trim().equalsIgnoreCase("premium")) {
            this.tipoCliente = "premium";
        } else if (tipoCliente != null && (tipoCliente.trim().equalsIgnoreCase("estándar")
                || tipoCliente.trim().equalsIgnoreCase("estandar"))) {
            this.tipoCliente = "estándar";
        } else {
            System.out.println("Error: El tipo de cliente debe ser premium o estándar.");
        }
    }
    // Devuelve el tipo de cliente (premium o estándar)
    public String getTipoCliente() {
        return tipoCliente;
    }

    // Guarda el total de la compra. Si es negativo, avisa del error y no lo guarda
    public void setTotalCompra(double totalCompra) {
        if (totalCompra >= 0) {
            this.totalCompra = totalCompra;
        } else {
            System.out.println("Error: El total de la compra no puede ser negativo.");
        }
    }
    // Devuelve el total de la compra, sin descuento
    public double getTotalCompra() {
        return totalCompra;
    }

    // MÉTODOS
    // Calcula cuánto dinero se descuenta: 20% si es premium y 10% si es estándar
    public double calcularDescuento() {
        double porcentaje;
        if (tipoCliente.equals("premium")) {
            porcentaje = 0.20;
        } else {
            porcentaje = 0.10;
        }
        return totalCompra * porcentaje;
    }

    // Muestra el resumen del cliente: su compra, el descuento y el monto final que debe pagar
    public void mostrarResumen() {
        double descuento = calcularDescuento();
        double montoFinal = totalCompra - descuento;
        System.out.println("Cliente: " + nombre + " (" + tipoCliente + ")");
        System.out.println("Total de la compra: $" + redondear(totalCompra));
        System.out.println("Descuento: $" + redondear(descuento));
        System.out.println("Monto final: $" + redondear(montoFinal));
    }

    // Deja un número con solo 2 decimales para que los precios se vean bien
    private double redondear(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }
}

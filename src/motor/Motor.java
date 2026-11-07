package motor;

public class Motor {

    // ATRIBUTOS
    // estado vale true si el motor está encendido y false si está apagado
    private boolean estado;
    private int velocidad;

    // El estado y la velocidad se cambian con encender, apagar y ajustarVelocidad, por eso solo tienen get
    // Devuelve true si el motor está encendido
    public boolean isEstado() {
        return estado;
    }
    // Devuelve la velocidad actual del motor
    public int getVelocidad() {
        return velocidad;
    }

    // MÉTODOS
    // Enciende el motor. Si ya estaba encendido, avisa que no hace falta encenderlo otra vez
    public void encender() {
        if (estado == false) {
            estado = true;
            System.out.println("El motor ha sido encendido");
        } else {
            System.out.println("El motor ya estaba encendido");
        }
    }

    // Apaga el motor y lo deja con velocidad 0. Si ya estaba apagado, avisa que no hace falta apagarlo otra vez
    public void apagar() {
        if (estado == true) {
            estado = false;
            velocidad = 0;
            System.out.println("El motor ha sido apagado");
        } else {
            System.out.println("El motor ya estaba apagado");
        }
    }

    // Cambia la velocidad. Solo funciona si el motor está encendido y el valor está entre 0 y 100
    public void ajustarVelocidad(int nuevaVelocidad) {
        if (estado == false) {
            System.out.println("Error: Primero debe encender el motor.");
        } else if (nuevaVelocidad < 0 || nuevaVelocidad > 100) {
            System.out.println("Error: La velocidad debe estar entre 0 y 100.");
        } else {
            this.velocidad = nuevaVelocidad;
        }
    }

    // Dice en palabras si el motor está encendido o apagado y a qué velocidad va
    public void mostrarEstado() {
        String texto = estado ? "encendido" : "apagado";
        System.out.println("El motor está " + texto + " y su velocidad es " + velocidad);
    }
}

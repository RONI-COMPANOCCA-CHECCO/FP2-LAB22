public class Lancero extends Soldado {
    private int longitudLanza;
    private static int num = 0;

    public Lancero(String nombre, int ataque, int defensa, int vida, int longitudLanza) {
        super(nombre, ataque, defensa, vida);
        this.longitudLanza = longitudLanza;
        num++;
    }

    // Método específico para la acción "schiltrom"
    public void schiltrom() {
        if (getActitud().equals("defensa")) {
            // Aumentar el nivel de defensa en 1 cuando se realiza schiltrom
            setNivelDefensa(getNivelDefensa() + 1);
        }
    }

    // Sobrescribe el método serAtacado para personalizar la acción en caso de ataque
    @Override
    public void serAtacado() {
        // Realiza schiltrom antes de recibir el ataque
        schiltrom();
        // Llama al método de la superclase para aplicar el daño
        super.serAtacado();
    }

    public static int cuantos(){
        return num;
    }

    public static void resetearCantidad(){
        num =0;
    }

    // Sobrescribe el método toString para agregar información específica de Lancero
    @Override
    public String toString() {
        return super.toString() + " Longitud de lanza: " + longitudLanza;
    }
}
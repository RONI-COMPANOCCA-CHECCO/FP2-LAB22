public class Soldado {
	private String nombre;
    private int nivelAtaque;
    private int nivelDefensa;
    private int nivelVida;
    private int vidaActual;
    private int velocidad = 0;
    private String actitud = "defensa";
    private boolean vive = true;
    private static int num = 0;
	
    //COMSTRUCTORES
	public Soldado(String nomb, int ataque, int defensa, int vida) {
		nombre = nomb;
        nivelAtaque = ataque;
        nivelDefensa = defensa;
        nivelVida = vida;
        vidaActual = vida;
        num++;
	}

	// Otros métodos
    public void atacar() {
        actitud = "ataque";
        avanzar();
    }

    public void defender() {
        actitud = "defensa";
        velocidad = 0;
    }

    public void avanzar() {
        velocidad++;
    }

    public void retroceder() {
        velocidad--;
    }

    public void serAtacado() {
        vidaActual--;
        if (vidaActual == 0) 
            morir();
    }

    public void huir(){
        actitud = "fuga";
        velocidad++;
    }

    public void morir() {
        vive = false;
    }

    public String toString() {
        return nombre+ " " +nivelAtaque+ " "+nivelDefensa+ " " +nivelVida+ " " +vidaActual+ " " +velocidad+ " " +actitud+ " " +vive;
    }

    public static int cuantos(){
        return num;
    }

    public static void resetearCantidad(){
        num=0;
    }

    public int getVida(){
        return nivelVida;
    }

    public String getActitud(){
        return actitud;
    }

    public void setNivelDefensa(int nivelDefensa) {
        this.nivelDefensa = nivelDefensa;
    }

    public int getNivelDefensa(){
        return nivelDefensa;
    }
}
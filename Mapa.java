import java.util.Random;

public class Mapa {
    private String tipoTerritorio;
    private Soldado[][] tablero;

    // Constructor
    public Mapa(String tipoTerritorio) {
        this.tipoTerritorio = tipoTerritorio;
        this.tablero = new Soldado[10][10]; // Tamaño del tablero (puedes ajustarlo según tus necesidades)
        posicionarSoldadosAleatorios();
    }

    // Método para posicionar soldados aleatorios en el tablero
    private void posicionarSoldadosAleatorios() {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) { // Número arbitrario de soldados por ejército
            int fila = rand.nextInt(10);
            int columna = rand.nextInt(10);

            // Verificar si la posición está ocupada
            while (tablero[fila][columna] != null) {
                fila = rand.nextInt(10);
                columna = rand.nextInt(10);
            }

            // Crear un soldado aleatorio (puedes ajustar estos valores según tus necesidades)
            Soldado soldado = new Soldado("Soldado" + i, 8, 5, rand.nextInt(5) + 5);
            tablero[fila][columna] = soldado;
        }
    }

    // Método para mostrar el tablero
    public void mostrarTablero() {
        System.out.println("Mapa - Tipo de Territorio: " + tipoTerritorio);
        for (Soldado[] fila : tablero) {
            for (Soldado soldado : fila) {
                if (soldado != null) {
                    System.out.print(soldado.getNombre() + " ");
                } else {
                    System.out.print("Vacío ");
                }
            }
            System.out.println();
        }
    }
}
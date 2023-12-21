import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class JuegoInterfazAvanzada extends JFrame {

    private JButton botonIniciar;
    private JLabel etiquetaCultura;
    private JComboBox<String> listaCulturas;
    private JCheckBox checkBoxModoEstrategico;
    private JRadioButton radioTactico;
    private JRadioButton radioEstrategico;
    private ButtonGroup grupoRadio;
    private JTextArea areaTexto;
    private JPanel panelJuego;

    public JuegoInterfazAvanzada() {
        super("Juego de Estrategia");

        etiquetaCultura = new JLabel("Seleccione Territorio:");
        listaCulturas = new JComboBox<>(new String[]{"Bosque", "Campo abierto", "Montaña", "Desierto", "Playa"});
        checkBoxModoEstrategico = new JCheckBox("Modo Estratégico");

        radioTactico = new JRadioButton("Táctico");
        radioEstrategico = new JRadioButton("Estratégico");
        grupoRadio = new ButtonGroup();
        grupoRadio.add(radioTactico);
        grupoRadio.add(radioEstrategico);

        areaTexto = new JTextArea(10, 30);
        areaTexto.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTexto);

        botonIniciar = new JButton("Iniciar Juego");
        botonIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarJuego();
            }
        });

        panelJuego = new JPanel(new BorderLayout());
        add(panelJuego, BorderLayout.CENTER);

        JPanel panelSuperior = new JPanel(new FlowLayout());
        panelSuperior.add(etiquetaCultura);
        panelSuperior.add(listaCulturas);
        panelSuperior.add(checkBoxModoEstrategico);

        JPanel panelRadio = new JPanel();
        panelRadio.add(radioTactico);
        panelRadio.add(radioEstrategico);

        JPanel panelCentral = new JPanel(new BorderLayout());
        panelCentral.add(panelSuperior, BorderLayout.NORTH);
        panelCentral.add(panelRadio, BorderLayout.CENTER);
        panelCentral.add(scrollPane, BorderLayout.SOUTH);

        JPanel panelBoton = new JPanel();
        panelBoton.add(botonIniciar);

        add(panelCentral, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void iniciarJuego() {
        String selectedCultura = (String) listaCulturas.getSelectedItem();
        boolean modoEstrategico = checkBoxModoEstrategico.isSelected();
        String modoJuego = radioTactico.isSelected() ? "Táctico" : "Estratégico";

        String mensaje = "Iniciando juego con Cultura: " + selectedCultura + "\nModo de Juego: " + modoJuego;
        if (modoEstrategico) {
            mensaje += "\nModo Estratégico Activado";
            ejecutarJuegoEstrategico();
        } else {
            mensaje += "\nModo Táctico Activado";
            JOptionPane.showMessageDialog(this, "Ejecutando lógica del juego táctico...", "Modo Táctico", JOptionPane.INFORMATION_MESSAGE);
            reiniciarJuego();
        }

        areaTexto.setText(mensaje);
    }

    private void ejecutarJuegoEstrategico() {
        // Lógica específica del modo estratégico
        System.out.println("Ejecutando lógica del juego estratégico...");
    }

    private void mostrarResultado(Ejercito e1, Ejercito e2) {
        StringBuilder resultado = new StringBuilder();
        
        // Mostrar detalles del Ejército 1
        resultado.append("Ejercito 1: ").append(e1.getCultura()).append("\n");
        resultado.append("Cantidad total de Soldados: ").append(e1.misSoldados.size()).append("\n");
        resultado.append("Espadachines: ").append(Espadachin.cuantos()).append("\n");
        resultado.append("Arqueros: ").append(Arquero.cuantos()).append("\n");
        resultado.append("Lanceros: ").append(Lancero.cuantos()).append("\n");
        resultado.append("Caballeros: ").append(Caballero.cuantos()).append("\n\n");
    
        // Mostrar detalles del Ejército 2
        resultado.append("Ejercito 2: ").append(e2.getCultura()).append("\n");
        resultado.append("Cantidad total de Soldados: ").append(e2.misSoldados.size()).append("\n");
        resultado.append("Espadachines: ").append(Espadachin.cuantos()).append("\n");
        resultado.append("Arqueros: ").append(Arquero.cuantos()).append("\n");
        resultado.append("Lanceros: ").append(Lancero.cuantos()).append("\n");
        resultado.append("Caballeros: ").append(Caballero.cuantos()).append("\n\n");
    
        // Mostrar el nivel de poder de cada ejército
        resultado.append("Nivel de poder Ejercito 1: ").append(e1.poder()).append("\n");
        resultado.append("Nivel de poder Ejercito 2: ").append(e2.poder()).append("\n\n");

        // Mostrar el resumen del poder de ambos ejércitos
        resultado.append("El ganador es: ");
        if (e1.poder() > e2.poder()) {
            resultado.append("Ejercito 1 de : ").append(e1.getCultura());
        } else if (e1.poder() < e2.poder()) {
            resultado.append("Ejercito 2 de : ").append(e2.getCultura());
        } else {
            resultado.append("Sin ganador");
        }
    
        areaTexto.setText(resultado.toString());
    }

    private Ejercito generarEjercitoAleatorio() {
    // Generar una cultura aleatoria
    String[] culturas = {"Inglaterra", "Francia", "Sacro Imperio Romano Germanico", "Aragon", "Moros"};
    String culturaAleatoria = culturas[new Random().nextInt(culturas.length)];

    // Generar una cantidad aleatoria de soldados (entre 1 y 10)
    int cantidadSoldados = new Random().nextInt(10) + 1;

    // Crear un ejército con soldados aleatorios
    return new Ejercito(culturaAleatoria, cantidadSoldados);
    }

    private void reiniciarJuego() {
        // Volver a ejecutar la lógica del juego y actualizar el contenido en el panel
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                panelJuego.removeAll(); // Limpiar el panel actual

                // Generar ejércitos aleatorios
                Ejercito e1 = generarEjercitoAleatorio();
                Ejercito e2 = generarEjercitoAleatorio();

                // Mostrar el resultado del juego en el panel
                mostrarResultado(e1, e2);
                revalidate(); // Actualizar la interfaz
                repaint();    // Repintar la interfaz
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JuegoInterfazAvanzada();
            }
        });
    }

}
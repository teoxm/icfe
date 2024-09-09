package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame3 extends JFrame {
    public Lamina4 lamina4;

    public Frame3() {
        setVisible(true);
        setBounds(400, 150, 800, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //CREAR Y CONFOGURARLAS LAMINAS
        Frame3.Lamina3 lamina3 = new Frame3.Lamina3();
        Frame3.Lamina2 lamina2 = new Frame3.Lamina2();
        lamina2.setLayout(new BoxLayout(lamina2, BoxLayout.Y_AXIS));
        lamina4 = new Lamina4();

        //Agregar las laminas al frame
        add(lamina3,BorderLayout.NORTH);
        add(lamina2,BorderLayout.WEST);
        add(lamina4,BorderLayout.EAST);
        GranOyente miOyente = new GranOyente(this);


        }
    public class Lamina3 extends JPanel {
        public Lamina3() {
            setBackground(new Color(205,228,235));
            JLabel titulo = new JLabel("PANEL CONTROL DE INGRESOS");
            Font font = new Font("Helvetica", Font.BOLD, 18);
            titulo.setFont(font);
            add(titulo);
        }
    }
    class Lamina2 extends JPanel{
        private Frame3 frame3;
        public Lamina2() {
            setBackground(new Color(205,228,235));

            Button boton1 = new Button("Registrar Ingresos");
            Button boton2 = new Button("Historial de Ingresos");
            Button boton3 = new Button("Agendar Ingreso");
            Button boton4 = new Button("Cerrar sesion");
            add(boton1);
            add(boton2);
            add(boton3);
            add(boton4);
            GranOyente miOyente = new GranOyente(frame3);
            boton1.addActionListener(miOyente);
            boton2.addActionListener(miOyente);
            boton3.addActionListener(miOyente);
            boton4.addActionListener(miOyente);

        }

    }
    public class GranOyente implements ActionListener{
        private Frame3 frame3;
        public GranOyente(Frame3 frame3) {
            this.frame3 = frame3;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof Button) {
                Button botonPresionado = (Button) e.getSource();
                String textoBoton = botonPresionado.getLabel();

                switch (textoBoton){
                    case "Registrar Ingresos":
                        revalidate();
                        repaint();
                        lamina4.mostrarLamina(new LaminaRegistrarIngresos(Frame3.this));
                        break;
                    case "Historial de Ingresos":
                        lamina4.mostrarLamina(new LaminaHistorialIngresos());
                        break;
                    case "Agendar Ingreso":
                        lamina4.mostrarLamina(new LaminaAgendamientoIngresos());
                        break;
                    case"Cerrar sesion" :
                        dispose();
                        Frame1 frame1 = new Frame1(); // Crea una nueva instancia de Frame1
                        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura la operación de cierre
                        break;
                    default:
                        lamina4.mostrarLamina(new LaminaVacia());
                        break;

                }

            }
        }
    }
    class Lamina4 extends JPanel {
        private JPanel LaminaActual;

        public Lamina4() {

            LaminaActual = new LaminaVacia();
            add(LaminaActual);
        }

        public void mostrarLamina(JPanel nuevaLamina) {
            //Limpiar lamina actual
            remove(LaminaActual);

            //Mostrar la nueva lamina
            LaminaActual = nuevaLamina;
            add(LaminaActual);

            //Actualizar la GUI
            revalidate();
            repaint();

        }
    }
        public  class LaminaRegistrarIngresos extends JPanel {

            public LaminaRegistrarIngresos(Frame3 frame) {
              RegistroIngreso registroIngreso= new RegistroIngreso(frame);
              add(registroIngreso);
            }
        }
        public class LaminaHistorialIngresos extends JPanel {
            public LaminaHistorialIngresos() { JLabel titulo = new JLabel("Lamina Historiasl Ingresos");
                add(titulo);
            }
        }
        public class LaminaAgendamientoIngresos extends JPanel {
            public LaminaAgendamientoIngresos() {
                JLabel titulo = new JLabel("Lamina Agendamiento ingresos");
                add(titulo);
            }
        }
        public class LaminaVacia extends JPanel{
            public LaminaVacia() {
                JLabel titulo = new JLabel("Lamina vacia ");
                add(titulo);
            }
        }



}


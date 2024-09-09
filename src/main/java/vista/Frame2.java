package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame2 extends JFrame {
    private Lamina4 lamina4;
    public Frame2(){

        setVisible(true);
        setBounds(400, 150, 800, 500);
        setLayout(new BorderLayout());
        Lamina3 lamina3 = new Lamina3();
        Lamina2 lamina2 = new Lamina2();
        lamina4 = new Lamina4();
        lamina2.setLayout(new BoxLayout(lamina2, BoxLayout.Y_AXIS));
        add(lamina3,BorderLayout.NORTH);
        add(lamina2,BorderLayout.WEST);
        add(lamina4,BorderLayout.EAST);
    }
    class Lamina2 extends JPanel{
        public Lamina2() {
            setBackground(new Color(205,228,235));




            Button boton1 = new Button("Registrar Usuario");
            Button boton2 = new Button("Usuarios Registrados");
            Button boton3 = new Button("Ingresos Registrados");
            Button boton4 = new Button("Eliminar Usuario");
            Button boton5 = new Button("Actualizar Usuario");
            Button boton6 = new Button("Salir del Sistema");


            add(boton1);
            add(boton2);
            add(boton3);
            add(boton4);
            add(boton5);
            add(boton6);
            Oyente miOyente=new Oyente();
            boton1.addActionListener(miOyente);
            boton2.addActionListener(miOyente);
            boton3.addActionListener(miOyente);
            boton4.addActionListener(miOyente);
            boton5.addActionListener(miOyente);
            boton6.addActionListener(miOyente);
        }

    }
    public class Lamina3 extends JPanel {
        public Lamina3() {
            setBackground(new Color(205,228,235));
            JLabel titulo = new JLabel("PANEL ADMINISTRACION USUARIOS");
            Font font = new Font("Helvetica", Font.BOLD, 18);
            titulo.setFont(font);
            add(titulo);
        }
    }
    public class Oyente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof Button){
            Button botonPresionado = (Button) e.getSource();
            String textoBoton = botonPresionado.getLabel();

            //Cambiar lamina4 segun el boton  presionado
            switch (textoBoton){
                case "Registrar Usuario":
                    lamina4.mostrarLamina(new LaminaRegistrarUsuario());
                    break;
                case "Usuarios Registrados":
                    lamina4.mostrarLamina(new LaminaUsuariosRegistrados());
                    break;
                case "Ingresos Registrados":
                    lamina4.mostrarLamina(new LaminaIngresosRegistrados());
                    break;
                case "Eliminar Usuario":
                    lamina4.mostrarLamina(new LaminaEliminarUsuario());
                    break;
                case "Actualizar Usuario":
                    lamina4.mostrarLamina(new LaminaActualizarUsuario());
                    break;
                case "Salir del Sistema":
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
    public class Lamina4 extends JPanel {
        private JPanel laminaActual;
        public Lamina4() {
            laminaActual = new LaminaVacia();
            add(laminaActual);
        }
        public void mostrarLamina(JPanel nuevaLamina) {
            // Limpiar la lamina actual
            remove(laminaActual);

            // Mostrar la nueva lamina
            laminaActual = nuevaLamina;
            add(laminaActual);

            // Actualizar la GUI
            revalidate();
            repaint();
        }

    }
    public class LaminaRegistrarUsuario extends JPanel {
        public LaminaRegistrarUsuario() {
            JLabel titulo = new JLabel("Formulario Registro Usuarios");

            add(titulo);
        }
    }
    public class LaminaUsuariosRegistrados extends JPanel {
        public LaminaUsuariosRegistrados() {
            JLabel titulo = new JLabel("Usuarios Registrados");
            add(titulo);
        }
    }
    public class LaminaIngresosRegistrados extends JPanel {
        public LaminaIngresosRegistrados() {
            JLabel titulo = new JLabel("Lamina verificacion de ingresos a la unidad ");
            add(titulo);
        }
    }
    public class LaminaEliminarUsuario extends JPanel {
        public LaminaEliminarUsuario() {
            JLabel titulo = new JLabel("Lamina Eliminacion Usuarios");
            add(titulo);
        }
    }
    public class LaminaActualizarUsuario extends JPanel {
        public LaminaActualizarUsuario() {
            JLabel titulo = new JLabel("Actualizacion de Usuarios");
            add(titulo);
        }
    }
    public class LaminaVacia extends JPanel {
        public LaminaVacia() {
            // Esta lamina está vacía
            JLabel titulo = new JLabel("Lamina vacia ");
            add(titulo);
        }
    }

}

package vista;

<<<<<<< HEAD
import datos.Conexion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import static datos.Conexion.*;
=======
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
>>>>>>> 658a0c122249caf362cff3de3da95bc28ad7dadd

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

<<<<<<< HEAD

=======
>>>>>>> 658a0c122249caf362cff3de3da95bc28ad7dadd
        }
    }
        public  class LaminaRegistrarIngresos extends JPanel {

            public LaminaRegistrarIngresos(Frame3 frame) {
              RegistroIngreso registroIngreso= new RegistroIngreso(frame);
              add(registroIngreso);
            }
        }
        public class LaminaHistorialIngresos extends JPanel {
<<<<<<< HEAD

            JTextField ingresoCedula;
            public LaminaHistorialIngresos() {

                setLayout(null);
                setPreferredSize(new Dimension(650, 500));
                JLabel titulo = new JLabel("HISTRORIAL DE INGRESOS");
                titulo.setBounds(30,25,250, 40);
                titulo.setFont(new Font("Helvetica", Font.BOLD, 18));
                JLabel subTitulo = new JLabel("Ingrese numero de documento");
                Font subFond = new Font("Helvetica", Font.PLAIN, 15);
                subTitulo.setFont(subFond);
                subTitulo.setBounds(30, 90, 250,40);
                ingresoCedula = new JTextField();
                ingresoCedula.setBounds(35, 150, 150, 20);
                Button registrar = new Button("Mostrar Historial");
                registrar.setBounds(45, 280, 110, 30);

                registrar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        monstrarHistroialDeIngresos();
                    }
                });

                add(titulo);
                add(subTitulo);
                add(ingresoCedula);
                add(registrar);
            }
            private void monstrarHistroialDeIngresos(){
                try{
                    String numeroCedula = ingresoCedula.getText();

                    //Validar la cedula antes de continuar

                   if(validarVisitante(numeroCedula)){
                       boolean esVisit = Conexion.esVisi(numeroCedula);

                       if(esVisit){
                           List<Map<String, Object>> resultList = Conexion.obtenerInformacionVisitante(numeroCedula);
                           if(!resultList.isEmpty()) {
                               Map<String, Object> result = resultList.get(0);
                               int idVisitante = (int) result.get("id");
                               //llamar al metodo para actualizar el estado del ingreso

                               List<Map<String, Object>> historialIngresos = Conexion.obtenerInformacionIngresos(idVisitante);

                               if(historialIngresos.isEmpty()){
                                   JOptionPane.showMessageDialog(null, "No hay historial de ingresos para el visitante.", "Información", JOptionPane.INFORMATION_MESSAGE);
                               }else {
                                   //crear un modelo de tabla
                                   DefaultTableModel modeloTabla = new DefaultTableModel();
                                   modeloTabla.addColumn("ID");
                                   modeloTabla.addColumn("Fecha");
                                   modeloTabla.addColumn("Hora Ingreso");
                                   modeloTabla.addColumn("Hora salida");
                                   modeloTabla.addColumn("Estado");

                                   //llenar el modelo de tabla con los datos del historial
                                   for (Map<String, Object> ingreso : historialIngresos) {
                                       modeloTabla.addRow(new Object[]{
                                               ingreso.get("id"),
                                               ingreso.get("fechaIngreso"),
                                               ingreso.get("horaIngreso"),
                                               ingreso.get("HoraSalida"),
                                               ingreso.get("estado")
                                       });
                                   }
                                   //Crear y mostrar una tabla en el historial de ingresos
                                   JTable tablaHistorial = new JTable(modeloTabla);
                                   JScrollPane scrollPane = new JScrollPane(tablaHistorial);
                                   scrollPane.setPreferredSize(new Dimension(600, 300));
                                   JOptionPane.showMessageDialog(null, scrollPane, "Historial de Ingresos", JOptionPane.INFORMATION_MESSAGE);

                               }
                               }else {
                               JOptionPane.showMessageDialog(null, "Error al obtener información del visitante.", "Error", JOptionPane.ERROR_MESSAGE);
                           }



                           }else {
                           JOptionPane.showMessageDialog(null, "El número de cédula no pertenece a un visitante registrado.", "Error", JOptionPane.ERROR_MESSAGE);
                       }
                   }else {
                       JOptionPane.showMessageDialog(null, "El número de cédula no pertenece a un visitante registrado.", "Error", JOptionPane.ERROR_MESSAGE);
                   }
                }catch (Exception ex) {
                    ex.printStackTrace();
                    System.err.println("Error general: " + ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Error al registrar la salida. Detalles: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
=======
            public LaminaHistorialIngresos() { JLabel titulo = new JLabel("Lamina Historiasl Ingresos");
                add(titulo);
>>>>>>> 658a0c122249caf362cff3de3da95bc28ad7dadd
            }
        }
        public class LaminaAgendamientoIngresos extends JPanel {
            public LaminaAgendamientoIngresos() {
                JLabel titulo = new JLabel("Lamina Agendamiento ingresos");
                add(titulo);
            }
        }
<<<<<<< HEAD
        public static class LaminaVacia extends JPanel{
            public LaminaVacia() {
                setLayout(null);
                setPreferredSize(new Dimension(500,500));
                JLabel titulo = new JLabel("BIENVENIDOS AL SISTEMA");
                titulo.setBounds(20,25,450, 40);
                titulo.setFont(new Font("Helvetica", Font.PLAIN, 23));
                JLabel titulo2 = new JLabel("CONTROL DE INGRESO");
                titulo2.setBounds(20,62,450, 40);
                titulo2.setFont(new Font("Helvetica", Font.PLAIN, 23));
                JLabel titulo3 = new JLabel("ICFE");
                titulo3.setBounds(130,99,450, 40);
                titulo3.setFont(new Font("Helvetica", Font.PLAIN, 23));

                JLabel titulo4 = new JLabel("Seleccione la opcion a gestionar");
                titulo4.setBounds(20,200,450, 40);
                titulo4.setFont(new Font("Helvetica", Font.PLAIN, 23));


                add(titulo);
                add(titulo2);
                add(titulo3);
                add(titulo4);
=======
        public class LaminaVacia extends JPanel{
            public LaminaVacia() {
                JLabel titulo = new JLabel("Lamina vacia ");
                add(titulo);
>>>>>>> 658a0c122249caf362cff3de3da95bc28ad7dadd
            }
        }



}


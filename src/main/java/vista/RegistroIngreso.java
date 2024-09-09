package vista;

import datos.Conexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.Map;
import java.util.List;

import static datos.Conexion.actualzarEstadoIngreso;
=======

>>>>>>> 658a0c122249caf362cff3de3da95bc28ad7dadd
import static datos.Conexion.validarVisitante;

public class RegistroIngreso extends JPanel {
    JTextField ingresoCedula;
    Frame3 frame;
    public RegistroIngreso(Frame3 frame) {
        this.frame = frame;
         //asigna el valor de frame
        setLayout(null);
        setPreferredSize(new Dimension(650, 500));
        JLabel titulo = new JLabel("Lamina Registro ingresos");
        titulo.setBounds(30,25,250, 40);
        titulo.setFont(new Font("Helvetica", Font.BOLD, 18));
        JLabel subTitulo = new JLabel("Ingrese numero de documento");
        Font subFond = new Font("Helvetica", Font.PLAIN, 15);
        subTitulo.setFont(subFond);
        subTitulo.setBounds(30, 90, 250,40);
        ingresoCedula = new JTextField();
        ingresoCedula.setBounds(35, 150, 150, 20);
        Button registrar = new Button("Registrar Ingreso");
        registrar.setBounds(45, 280, 110, 30);

        Button salida = new Button("Registrar Salida");
        salida.setBounds(165, 280, 110, 30);

        add(titulo);
        add(subTitulo);
        add(ingresoCedula);
        add(registrar);
        add(salida);
        Oyente2 oyente2 = new Oyente2(this.frame);
        registrar.addActionListener(oyente2);

<<<<<<< HEAD
        OyenteSalida oyesteSalida = new OyenteSalida(this.frame);
        salida.addActionListener(oyesteSalida);

=======
>>>>>>> 658a0c122249caf362cff3de3da95bc28ad7dadd

    }

    public class Oyente2 implements ActionListener {
        private Frame3 frame;
        public Oyente2(Frame3 frame) {
            this.frame = frame;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            // Manejar la excepción de base de datos
            try {
                String numeroCedula = ingresoCedula.getText();
                System.out.println("Número de cédula: [" + numeroCedula + "]");

                if (validarVisitante(numeroCedula) ) {
                    System.out.println("Visitante validado correctamente.");

<<<<<<< HEAD


                    boolean esVisit = Conexion.esVisi(numeroCedula);
                    System.out.println("esVisit: " + esVisit);
                    if (esVisit) {

                        List<Map<String, Object>> resultList = Conexion.obtenerInformacionVisitante(numeroCedula);


                        if(!resultList.isEmpty()){
                            Map<String, Object> result = resultList.get(0); // Tomar el primer resultado
                            int idVisitante = (int) result.get("id");
                            String nombre = (String) result.get("primerNombre");
                            String segundoNombre = (String) result.get("segundoNombre");
                            String primerApellido = (String) result.get("primerApellido");
                            String segundoApellido = (String) result.get("segundoApellido");
                            String unidad = (String) result.get("unidad");
                            String cedula = (String) result.get("numeroDocumento");

                            Frame3 miFrame3 = new Frame3();
                            IngresoDefinitivo ingresoDefinito = new IngresoDefinitivo(miFrame3, nombre, segundoNombre, primerApellido, segundoApellido,unidad,idVisitante);

                            frame.lamina4.mostrarLamina(ingresoDefinito);
                            System.out.println(nombre);
                            System.out.println(idVisitante);

                        }









=======
                    ResultSet informacionVisitante = Conexion.obtenerInformacionVisitante(numeroCedula);

                    if (informacionVisitante != null && informacionVisitante.next()) {
                        //OPTENER LA INFORMACION DEL RESULTSET

                        String primerNombre = informacionVisitante.getString("primerNombre");
                        String segundoNombre = informacionVisitante.getString("segundoNombre");
                        String primerApellido = informacionVisitante.getString("primerApellido");
                        String segundoApellido = informacionVisitante.getString("segundoApellido");
                        String unidad = informacionVisitante.getString("unidad");
                        int idVisitante = informacionVisitante.getInt("id");

                        IngresoDefinitivo ingresoDefinito = new IngresoDefinitivo();
                        frame.lamina4.mostrarLamina(ingresoDefinito);
>>>>>>> 658a0c122249caf362cff3de3da95bc28ad7dadd

                    } else {

                        RegistroVisitante registroVisitante = new RegistroVisitante(frame);
                        frame.lamina4.mostrarLamina(registroVisitante);

                    }

                } else {

                    JOptionPane.showMessageDialog(null, "Error al validar el visitante", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                System.err.println("Error general: " + ex.getMessage());
                JOptionPane.showMessageDialog(null, "Error al validar el visitante. Detalles: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }



        }
    }
<<<<<<< HEAD
    public class OyenteSalida implements ActionListener {

        private Frame3 frame;
        public OyenteSalida(Frame3 frame) {
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String numeroCedula = ingresoCedula.getText();

                if (validarVisitante(numeroCedula)){

                    boolean esVisit = Conexion.esVisi(numeroCedula);

                    if(esVisit){
                        List<Map<String, Object>> resultList = Conexion.obtenerInformacionVisitante(numeroCedula);
                        if(!resultList.isEmpty()) {
                            Map<String, Object> result = resultList.get(0);
                            int idVisitante = (int) result.get("id");
                            //llamar al metodo para actualizar el estado del ingreso
                            actualzarEstadoIngreso(idVisitante);
                            JOptionPane.showMessageDialog(null, "Salida registrada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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

        }
    }
=======
>>>>>>> 658a0c122249caf362cff3de3da95bc28ad7dadd
}

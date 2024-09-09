package vista;

import datos.Conexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegistroVisitante extends JPanel {
    JTextField ingresoPrimerNombre;
    JTextField ingresoSegundoNombre;
    JTextField ingresoPrimerApellido;
    JTextField ingresoSegundoApellido;
    JTextField ingresoNumeroDocumento;
    JComboBox<String> comboBox;
    JTextField ingresoGrado;
    JTextField ingresoUnidad;
    Frame3 frame;

    public RegistroVisitante(Frame3 frame) {
        this.frame = frame;
        setLayout(null);
        setPreferredSize(new Dimension(650, 500));
        JLabel titulo = new JLabel("Lamina Registro visitante");
        titulo.setBounds(30, 10, 250, 40);
        titulo.setFont(new Font("Helvetica", Font.BOLD, 18));

        JLabel primerNombre = new JLabel("Ingrese el primer nombre");
        primerNombre.setBounds(1, 50, 250, 40);
        primerNombre.setFont(new Font("Helvetica", Font.BOLD, 12));

        ingresoPrimerNombre = new JTextField();
        ingresoPrimerNombre.setBounds(255, 60, 150, 20);

        JLabel segundoNombre = new JLabel("Ingrese el segundo nombre");
        segundoNombre.setBounds(1, 80, 250, 40);
        segundoNombre.setFont(new Font("Helvetica", Font.BOLD, 12));

        ingresoSegundoNombre = new JTextField();
        ingresoSegundoNombre.setBounds(255, 90, 150, 20);

        JLabel primerApellido = new JLabel("Ingrese el primer apellido");
        primerApellido.setBounds(1, 110, 250, 40);
        primerApellido.setFont(new Font("Helvetica", Font.BOLD, 12));

        ingresoPrimerApellido = new JTextField();
        ingresoPrimerApellido.setBounds(255, 120, 150, 20);

        JLabel segundoApellido = new JLabel("Ingrese el segundo apellido");
        segundoApellido.setBounds(1, 150, 190, 20);
        segundoApellido.setFont(new Font("Helvetica", Font.BOLD, 12));

        ingresoSegundoApellido = new JTextField();
        ingresoSegundoApellido.setBounds(255, 150, 150, 20);

        JLabel numeroDocumento = new JLabel("Ingrse numero de documento");
        numeroDocumento.setBounds(1, 180, 190, 20);
        numeroDocumento.setFont(new Font("Helvetica", Font.BOLD, 12));

        ingresoNumeroDocumento = new JTextField();
        ingresoNumeroDocumento.setBounds(255, 180, 150, 20);

        JLabel genero = new JLabel("Selccione el genero");
        genero.setBounds(1, 210, 190, 20);
        genero.setFont(new Font("Helvetica", Font.BOLD, 12));

        String[] opciones = {"masculino", "femenino"};
        comboBox = new JComboBox<>(opciones);
        comboBox.setBounds(255, 210, 150, 20);

        JLabel grado = new JLabel("Ingrese el grado");
        grado.setBounds(1, 240, 190, 20);
        grado.setFont(new Font("Helvetica", Font.BOLD, 12));

        ingresoGrado = new JTextField();
        ingresoGrado.setBounds(255, 240, 150, 20);

        JLabel unidad = new JLabel("Ingrese la unidad");
        unidad.setBounds(1, 270, 190, 20);
        unidad.setFont(new Font("Helvetica", Font.BOLD, 12));

        ingresoUnidad = new JTextField();
        ingresoUnidad.setBounds(255, 270, 150, 20);

        JButton guardar = new JButton("Guardar");
        guardar.setBounds(65, 360, 90, 30);


        add(titulo);
        add(primerNombre);
        add(ingresoPrimerNombre);
        add(segundoNombre);
        add(ingresoSegundoNombre);
        add(primerApellido);
        add(ingresoPrimerApellido);
        add(segundoApellido);
        add(ingresoSegundoApellido);
        add(numeroDocumento);
        add(ingresoNumeroDocumento);
        add(genero);
        add(comboBox);
        add(grado);
        add(ingresoGrado);
        add(unidad);
        add(ingresoUnidad);
        add(guardar);

        Oyente3 oyente = new Oyente3(this.frame);
        guardar.addActionListener(oyente);
    }

    public class Oyente3 implements ActionListener {
        private Frame3 frame;

        public Oyente3(Frame3 frame) {
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                //Obtener los datos del formulario
                String primerNombre = ingresoPrimerNombre.getText();
                String segundoNombre = ingresoSegundoNombre.getText();
                String primerApellido = ingresoPrimerApellido.getText();
                String segundoApellido = ingresoSegundoApellido.getText();
                String numeroDocumento = ingresoNumeroDocumento.getText();
                String genero = (String) comboBox.getSelectedItem();
                String grado = ingresoGrado.getText();
                String unidad = ingresoUnidad.getText();


                boolean registroExitoso = Conexion.registrarVisitante(primerNombre, segundoNombre, primerApellido, segundoApellido, numeroDocumento,
                        genero, grado, unidad);

                if (registroExitoso) {
                    JOptionPane.showMessageDialog(frame, "Registro exitoso", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Error en el registro", "Error", JOptionPane.ERROR_MESSAGE);
                }


            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error al procesar el registro. Detalles: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }
}
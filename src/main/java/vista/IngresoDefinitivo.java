package vista;

import datos.Conexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
import java.time.LocalDate;
import java.time.LocalTime;

public class IngresoDefinitivo extends JPanel {

    Frame3 frame3;

    private JLabel labelNombre;
    private JLabel labelCedula;
    private JLabel labelSegundoNombre;
    private JLabel labelPrimerApellido;
    private JLabel labelSegundoApellido;
    private JLabel labelUnidad;
    private int idVisitante;



=======
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class IngresoDefinitivo extends JPanel {
    JLabel infoNombreLabel;
    JTextField ingresoPrimerNombre;
    JTextField ingresoSegundoNombre;
    JTextField ingresoPrimerApellido;
    JTextField ingresoSegundoApellido;
    JTextField ingresoUnidad;
>>>>>>> 658a0c122249caf362cff3de3da95bc28ad7dadd
    JComboBox<String> comboBox;
    JTextField ingresoPlacaVehiculo;
    JTextField ingresoColorVehiculo;

<<<<<<< HEAD

    public IngresoDefinitivo(Frame3 frame3, String nombre, String segundoNombre, String primerApellido, String segundoApellido, String unidad, int idVisitante ) {

        this.frame3 = frame3;
        this.idVisitante = idVisitante;
        setLayout(null);
        setPreferredSize(new Dimension(500, 400));

=======
    public IngresoDefinitivo() {
        setLayout(null);
        setPreferredSize(new Dimension(500, 400));
>>>>>>> 658a0c122249caf362cff3de3da95bc28ad7dadd
        JLabel titulo = new JLabel("Lamina Registro ingresos");
        titulo.setBounds(30, 20, 250, 40);
        titulo.setFont(new Font("Helvetica", Font.BOLD, 18));

<<<<<<< HEAD

        labelCedula = new JLabel();


        JLabel Nombre = new JLabel("Primer Nombre:");
        Nombre.setBounds(1, 50, 250, 40);
        Nombre.setFont(new Font("Helvetica", Font.BOLD, 12));

        labelNombre = new JLabel(nombre);
        labelNombre.setBounds(255, 60, 150, 20);

        JLabel LsegundoNombre = new JLabel("Segundo nombre:");
        LsegundoNombre.setBounds(1, 80, 250, 40);
        LsegundoNombre.setFont(new Font("Helvetica", Font.BOLD, 12));

        labelSegundoNombre = new JLabel(segundoNombre);
        labelSegundoNombre.setBounds(255, 90, 150, 20);

        JLabel LprimerApellido = new JLabel("Primer apellido: ");
        LprimerApellido.setBounds(1, 110, 250, 40);
        LprimerApellido.setFont(new Font("Helvetica", Font.BOLD, 12));

        labelPrimerApellido = new JLabel(primerApellido);
        labelPrimerApellido.setBounds(255, 120, 150, 20);

        JLabel LsegundoApellido = new JLabel("Segundo apellido:");
        LsegundoApellido.setBounds(1, 150, 190, 20);
        LsegundoApellido.setFont(new Font("Helvetica", Font.BOLD, 12));

        labelSegundoApellido = new JLabel(segundoApellido);
        labelSegundoApellido.setBounds(255, 150, 150, 20);

        JLabel Lunidad = new JLabel("Unidad: ");
        Lunidad.setBounds(1, 180, 190, 20);
        Lunidad.setFont(new Font("Helvetica", Font.BOLD, 12));

        labelUnidad = new JLabel(unidad);
        labelUnidad.setBounds(255, 180, 150, 20);

        JLabel tipoVehiculo = new JLabel("Selccione el tipo de vehiculo");
=======
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

        JLabel unidad = new JLabel("Ingrese la unidad");
        unidad.setBounds(1, 180, 190, 20);
        unidad.setFont(new Font("Helvetica", Font.BOLD, 12));

        ingresoUnidad = new JTextField();
        ingresoUnidad.setBounds(255, 180, 150, 20);

        JLabel tipoVehiculo = new JLabel("Selccione el genero");
>>>>>>> 658a0c122249caf362cff3de3da95bc28ad7dadd
        tipoVehiculo.setBounds(1, 210, 190, 20);
        tipoVehiculo.setFont(new Font("Helvetica", Font.BOLD, 12));

        String[] opciones = {"motocicleta", "automovil", "Camion", "Bicicleta", "Patineta (E)", "peatonal"};
        comboBox = new JComboBox<>(opciones);
        comboBox.setBounds(255, 210, 150, 20);

        JLabel placaVehiculo = new JLabel("Ingrese la placa del vehiculo");
        placaVehiculo.setBounds(1, 240, 190, 20);
        placaVehiculo.setFont(new Font("Helvetica", Font.BOLD, 12));

        ingresoPlacaVehiculo = new JTextField();
        ingresoPlacaVehiculo.setBounds(255, 240, 150, 20);

        JLabel colorVehiculo = new JLabel("Ingrese el color del vehiculo");
        colorVehiculo.setBounds(1, 270, 190, 20);
        colorVehiculo.setFont(new Font("Helvetica", Font.BOLD, 12));

        ingresoColorVehiculo = new JTextField();
        ingresoColorVehiculo.setBounds(255, 270, 150, 20);

        Button registro = new Button("Guardar");
        registro.setBounds(65, 360, 90, 30);


        add(titulo);
<<<<<<< HEAD
        add(Nombre);
        add(labelNombre);
        add(LsegundoNombre);
        add(labelSegundoNombre);
        add(LprimerApellido);
        add(labelPrimerApellido);
        add(LsegundoApellido);
        add(labelSegundoApellido);
        add(Lunidad);
        add(labelUnidad);
=======
        add(primerNombre);
        add(ingresoPrimerNombre);
        add(segundoNombre);
        add(ingresoSegundoNombre);
        add(primerApellido);
        add(ingresoPrimerApellido);
        add(segundoApellido);
        add(ingresoSegundoApellido);
        add(unidad);
        add(ingresoUnidad);
>>>>>>> 658a0c122249caf362cff3de3da95bc28ad7dadd
        add(tipoVehiculo);
        add(comboBox);
        add(placaVehiculo);
        add(ingresoPlacaVehiculo);
        add(colorVehiculo);
        add(ingresoColorVehiculo);
        add(registro);
<<<<<<< HEAD
        Oyente4 oyente = new Oyente4(frame3);
=======
        Oyente4 oyente = new Oyente4();
>>>>>>> 658a0c122249caf362cff3de3da95bc28ad7dadd
        registro.addActionListener(oyente);


    }

<<<<<<< HEAD




    public class Oyente4 implements ActionListener {

        private Frame3 frame;
        public Oyente4(Frame3 frame) {
            this.frame = frame;
        }
=======
    public class Oyente4 implements ActionListener {

        private Frame3 frame;

>>>>>>> 658a0c122249caf362cff3de3da95bc28ad7dadd

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
<<<<<<< HEAD
                String primerNombre = labelNombre.getText();
                String segundoNombre = labelSegundoNombre.getText();
                String primerApellido = labelPrimerApellido.getText();
                String segundoApellido = labelSegundoApellido.getText();
                String unidad = labelUnidad.getText();
=======
                String primerNombre = ingresoPrimerNombre.getText();
                String segundoNombre = ingresoSegundoNombre.getText();
                String primerApellido = ingresoPrimerApellido.getText();
                String segundoApellido = ingresoSegundoApellido.getText();
                String unidad = ingresoUnidad.getText();
>>>>>>> 658a0c122249caf362cff3de3da95bc28ad7dadd
                String tipoVehiculo = (String) comboBox.getSelectedItem();
                String placaVehiculo = ingresoPlacaVehiculo.getText();
                String colorVehiculo = ingresoColorVehiculo.getText();
                LocalDate fechaIngreso = LocalDate.now();
                LocalDate fechaSalida = LocalDate.now();
                LocalTime horaIngreso = LocalTime.now();
                LocalTime horaSalida = LocalTime.now();
                boolean estado = true;

                boolean registroExitoso = Conexion.registrarIngreso(primerNombre, primerApellido, segundoApellido,unidad ,tipoVehiculo
                        , placaVehiculo,colorVehiculo ,fechaIngreso ,horaIngreso , horaSalida, segundoNombre,estado
<<<<<<< HEAD
                        , fechaSalida, idVisitante);
                if (registroExitoso) {
                    JOptionPane.showMessageDialog(frame, "Registro exitoso", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println(idVisitante);
                    Frame3.LaminaVacia laminaVacia = new Frame3.LaminaVacia();
                    frame.lamina4.mostrarLamina(laminaVacia);

                } else {
                    JOptionPane.showMessageDialog(frame, "Error en el registro", "Error", JOptionPane.ERROR_MESSAGE);

=======
                        , fechaSalida);
                if (registroExitoso) {
                    JOptionPane.showMessageDialog(frame, "Registro exitoso", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Error en el registro", "Error", JOptionPane.ERROR_MESSAGE);


                    System.out.println("Registro exitoso: " + registroExitoso);
>>>>>>> 658a0c122249caf362cff3de3da95bc28ad7dadd
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error al procesar el registro. Detalles: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
<<<<<<< HEAD

=======
    
>>>>>>> 658a0c122249caf362cff3de3da95bc28ad7dadd
}

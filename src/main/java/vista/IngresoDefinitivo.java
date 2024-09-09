package vista;

import datos.Conexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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



    JComboBox<String> comboBox;
    JTextField ingresoPlacaVehiculo;
    JTextField ingresoColorVehiculo;


    public IngresoDefinitivo(Frame3 frame3, String nombre, String segundoNombre, String primerApellido, String segundoApellido, String unidad, int idVisitante ) {

        this.frame3 = frame3;
        this.idVisitante = idVisitante;
        setLayout(null);
        setPreferredSize(new Dimension(500, 400));

        JLabel titulo = new JLabel("Lamina Registro ingresos");
        titulo.setBounds(30, 20, 250, 40);
        titulo.setFont(new Font("Helvetica", Font.BOLD, 18));


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
        add(tipoVehiculo);
        add(comboBox);
        add(placaVehiculo);
        add(ingresoPlacaVehiculo);
        add(colorVehiculo);
        add(ingresoColorVehiculo);
        add(registro);
        Oyente4 oyente = new Oyente4(frame3);
        registro.addActionListener(oyente);


    }





    public class Oyente4 implements ActionListener {

        private Frame3 frame;
        public Oyente4(Frame3 frame) {
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                String primerNombre = labelNombre.getText();
                String segundoNombre = labelSegundoNombre.getText();
                String primerApellido = labelPrimerApellido.getText();
                String segundoApellido = labelSegundoApellido.getText();
                String unidad = labelUnidad.getText();
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
                        , fechaSalida, idVisitante);
                if (registroExitoso) {
                    JOptionPane.showMessageDialog(frame, "Registro exitoso", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println(idVisitante);
                    Frame3.LaminaVacia laminaVacia = new Frame3.LaminaVacia();
                    frame.lamina4.mostrarLamina(laminaVacia);

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

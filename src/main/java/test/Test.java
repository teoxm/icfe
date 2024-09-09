package test;

import datos.Conexion;
import vista.Frame1;
import vista.Frame3;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        try {
            // Intenta obtener una conexión
            Conexion.getConection();
            System.out.println("Conexión exitosa a la base de datos");

            // Crea y muestra el frame
            Frame1 frame1 = new Frame1();
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (Exception e) {
            // Maneja cualquier excepción que pueda ocurrir durante la conexión
            JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

}

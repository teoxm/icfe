package vista;

import datos.Conexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static datos.Conexion.esAdmin;
import static datos.Conexion.validarUsuario;

public class Frame1 extends JFrame {
    Panel1 lamina = new Panel1();
    public Frame1(){
        setVisible(true);
        setBounds(400,150, 800,500);
        add(lamina);
    }
    class Panel1 extends JPanel{//FUENTE DEL EVENTO
        JTextField ingresoUsuario;
        JPasswordField ingresoContrasena;
        public Panel1() {
            setBackground(new Color(205,228,235));
            setLayout(null);
            JLabel titulo = new JLabel("Sistema Control De Acceso");
            add(titulo);
            titulo.setBounds(296, 42, 250, 40);
            Font font = new Font("Helvetica", Font.BOLD, 18);
            titulo.setFont(font);
            JLabel subTitulo = new JLabel("Ingresa tu usuario");
            subTitulo.setBounds(340,100, 220,35);
            Font subFond = new Font("Helvetica", Font.PLAIN, 15);
            subTitulo.setFont(subFond);
            add(subTitulo);
            ingresoUsuario = new JTextField();
            ingresoUsuario.setBounds(330, 150, 150, 20);
            add(ingresoUsuario);
            JLabel subTitulo2 = new JLabel("Ingresa La Contraseña");
            subTitulo2.setBounds(340,180,220,35);
            subTitulo2.setFont(subFond);
            add(subTitulo2);
            ingresoContrasena = new JPasswordField(15);
            ingresoContrasena.setBounds(330,230,150, 20);
            add(ingresoContrasena);
            Button ingresar = new Button("Ingresar");
            ingresar.setBounds(340, 300, 90, 30);
            add(ingresar);
            Oyente miOyente = new Oyente();
            ingresar.addActionListener(miOyente);



        }
        class Oyente implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = ingresoUsuario.getText();
                String contrasena = new String(ingresoContrasena.getPassword());

               if(validarUsuario(usuario,contrasena)){
                    dispose(); //cerrar el frame actual

                   boolean esAdmin = esAdmin(usuario);

                   if(esAdmin){
                       Frame2 interfazAdministrador = new Frame2();
                       interfazAdministrador.setDefaultCloseOperation(EXIT_ON_CLOSE);
                   }else {
                       // Usuario con rol de usuario
                       dispose(); // Cierra el Frame1
                       Frame3 interfazUsuario = new Frame3();
                       interfazUsuario.setDefaultCloseOperation(EXIT_ON_CLOSE);
                   }

               }else {
                   // Lógica para manejar credenciales incorrectas
                   JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
               }

            }
        }

    }
}




























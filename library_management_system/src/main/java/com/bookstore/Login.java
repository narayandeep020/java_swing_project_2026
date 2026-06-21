package com.bookstore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    private JPanel panel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton b1, b2, b3;

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
    public Login(){
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 300, 600, 400);

        panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(null);

        JLabel l1 = new JLabel("User Name : ");
        l1.setBounds(130, 89, 195, 24);
        panel.add(l1);

        JLabel l2 = new JLabel("Password : ");
        l2.setBounds(130, 124, 195, 24);
        panel.add(l2);

        textField = new JTextField();
        textField.setBounds(215, 93, 157, 20);
        panel.add(textField);

        passwordField = new JPasswordField();
        passwordField.setBounds(215, 128, 157, 20);
        panel.add(passwordField);

        b1 = new JButton("Login");
        b1.addActionListener(this);
        b1.setForeground(new Color(46, 139, 87));
        b1.setBackground(new Color(250, 250, 210));
        b1.setBounds(150, 181, 93, 30);
        panel.add(b1);

        b2 = new JButton("Sign Up");
        b2.addActionListener(this);
        b2.setForeground(new Color(139, 69, 19));
        b2.setBackground(new Color(255, 235, 205));
        b2.setBounds(290, 181, 93, 30);
        panel.add(b2);

        b3 = new JButton("Forgot Password");
        b3.addActionListener(this);
        b3.setBounds(200, 231, 142, 30);
        panel.add(b3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            Boolean status = false;
            try{
                Connect con = new Connect();
                String sql = "select * from account where username=? and password=?";
                PreparedStatement pstmt = con.c.prepareStatement(sql);

                pstmt.setString(1, textField.getText());
                pstmt.setString(2, new String(passwordField.getPassword()));

                ResultSet rs = pstmt.executeQuery();

                if(rs.next()){
                    this.setVisible(false);
                    new Loading().setVisible(true);
                }else
                    JOptionPane.showMessageDialog(null,"Invalid Login.....!");
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        if (e.getSource() == b2) {
            setVisible(false);
            Signup su = new Signup();
            su.setVisible(true);
        }
        if (e.getSource() == b3) {
            setVisible(false);
            Forgot forgot = new Forgot();
            forgot.setVisible(true);
        }
    }
}

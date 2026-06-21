package com.bookstore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class LibraryManagementSystem extends JFrame implements ActionListener {
    JLabel l1;

    public LibraryManagementSystem() {
        setTitle("Library Management System");

        setSize(1100, 550);
        setLocation(300, 300);
        getContentPane().setLayout(null);

        JButton b1 = new JButton("Next");
        b1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                Login login = new Login();
                login.setVisible(true);
            }
        });
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        b1.setBounds(770, 400, 156, 50);
        getContentPane().add(b1);

        JLabel newLabel = new JLabel("");
        java.net.URL img = getClass().getResource("/icons/first.png");

        if(img != null){
            newLabel.setIcon(new ImageIcon(img));
        }else{
            System.err.println("Could not find file on classpath: ");
        }
        newLabel.setBounds(40,0,1460,500);
        getContentPane().add(newLabel);
    }
    public void actionPerformed(ActionEvent ae) {
        new Login().setVisible(true);
        this.setVisible(false);

    }

    public static void main(String[] args) {
        LibraryManagementSystem window = new LibraryManagementSystem();
        window.setVisible(true);
    }
}

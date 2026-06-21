package com.bookstore;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class Loading extends JFrame implements Runnable {
    private JPanel contentPane;
    private JProgressBar progressBar;
    Connection conn;
    int n;
    Thread th;

    public static void main(String[] args) {
        new Loading().setVisible(true);
    }

    public void setUploading(){
        th.start();
    }

    @Override
    public void run() {
        try{
            for(int i=0; i<200; i++){
               n = n+1;
               int m = progressBar.getMaximum();
               int v = progressBar.getValue();
               if (v<m){
                   progressBar.setValue(progressBar.getValue()+1);
               }else{
                   i = 201;
                   setVisible(false);
                   new Home().setVisible(true);
               }
               Thread.sleep(50);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public Loading(){
        super("Loading");
        th = new Thread(this);

        setBounds(600,300,600,400);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel libraryManagement = new JLabel("Smart Library vz 2.1");
        libraryManagement.setForeground(new Color(72, 209, 204));
        libraryManagement.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
        libraryManagement.setBounds(130, 46, 500, 35);
        contentPane.add(libraryManagement);

        progressBar = new JProgressBar();
        progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(130, 135, 300, 25);
        contentPane.add(progressBar);

        JLabel lblNewLabel_2 = new JLabel("Please Wait....");
        lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lblNewLabel_2.setForeground(new Color(160, 82, 45));
        lblNewLabel_2.setBounds(200, 165, 150, 20);
        contentPane.add(lblNewLabel_2);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 590, 361);
        contentPane.add(panel);

        setUploading();
    }
}

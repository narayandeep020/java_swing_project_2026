package main.java.com.transit;

import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BusBooking extends JFrame {

    private JButton b1,b2,b3;
    private JComboBox c1,c2,c3;
    private com.toedter.calendar.JCalendar cal;
    private JLabel jLabel1,jLabel2,jLabel3,jLabel4,jLabel5,jLabel6,jLabel7,jLabel8,jLabel9;
    private JScrollPane jScrollPane1;
    public JTextField t;
    private JTextField t1,t3;
    private JTextArea t2;


    public BusBooking(){
        initComponents();
        Date date = new Date();
        cal.getDayChooser().setMinSelectableDate(date);
        connect();
    }
    Connection c;
    PreparedStatement pst;
    ResultSet rs;
    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            try{
                c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_booking_db","****","******");
            }catch (Exception e){
                Logger.getLogger(BusBooking.class.getName()).log(Level.SEVERE,null,e);
            }
        }catch (Exception ae){
            Logger.getLogger(BusBooking.class.getName()).log(Level.SEVERE,null,ae);
        }
    }
    public void initComponents(){

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        t1 = new JTextField();
        jLabel5 = new JLabel();
        cal = new JCalendar();
        jLabel6 = new JLabel();
        jScrollPane1 = new JScrollPane();
        t2 = new JTextArea();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        t3 = new JTextField();
        b3 = new JButton();
        b2 = new JButton();
        b1 = new JButton();
        jLabel9 = new JLabel();
        t = new JTextField();
        c1 = new JComboBox();
        c2 = new JComboBox();
        c3 = new JComboBox();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new Font("Times New Roman",1,36));
        jLabel1.setText("WELCOME TO BUS BOOKING SYSTEM");

        jLabel2.setFont(new Font("Times New Roman",1,24));
        jLabel2.setText("Source");

        jLabel3.setFont(new Font("Times New Roman",1,24));
        jLabel3.setText("Destination");

        jLabel4.setFont(new Font("Times New Roman",1,24));
        jLabel4.setText("No. of Passengers");

        t1.setFont(new Font("Times New Roman",1,24));

        jLabel5.setFont(new Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Time");

        jLabel6.setFont(new Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Departure Date");

        t2.setColumns(20);
        t2.setFont(new Font("Times New Roman", 1, 18)); // NOI18N
        t2.setRows(5);
        jScrollPane1.setViewportView(t2);

        jLabel7.setFont(new Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setText("Ticket Summary");

        jLabel8.setFont(new Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setText("Payable Amount");

        t3.setFont(new Font("Times New Roman", 1, 24));

        b3.setFont(new Font("Times New Roman", 1, 24)); // NOI18N
        b3.setText("BOOK");
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });
        b2.setFont(new Font("Times New Roman", 1, 24)); // NOI18N
        b2.setText("RESET");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
        b1.setFont(new Font("Times New Roman", 1, 24)); // NOI18N
        b1.setText("SUBMIT");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        jLabel9.setFont(new Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setText("Name of User");

        t.setFont(new Font("Times New Roman", 1, 24)); // NOI18N

        c1.setFont(new Font("Times New Roman", 1, 24));
        c1.setModel(new DefaultComboBoxModel(new String[] { "Pune", "Mumbai", "Nashik", "Delhi", "Nagpur", "Ahmednagar" }));

        c2.setFont(new Font("Times New Roman", 1, 24));
        c2.setModel(new DefaultComboBoxModel(new String[] { "Mumbai", "Pune", "Nashik", "Delhi", "Nagpur", "Ahmednagar" }));

        c3.setFont(new Font("Times New Roman", 1, 24));
        c3.setModel(new DefaultComboBoxModel(new String[] { "6:00 am", "8:00 am", "12:00 pm", "2:00 pm", "5:00 pm", "7:00 pm" }));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(121, 121, 121)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel9)
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(cal, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addGap(93, 93, 93)
                                                                                        .addComponent(jLabel2)
                                                                                        .addGap(33, 33, 33)
                                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(t1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(c1, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel6)
                                                                        .addComponent(jLabel4))
                                                                .addGap(204, 204, 204)))
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(87, 87, 87)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabel3))
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(c2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(c3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                                        .addComponent(jLabel7)
                                                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(47, 47, 47)
                                                                .addComponent(t, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(t3, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                                .addGap(280, 280, 280)))
                                .addGap(0, 154, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(188, 188, 188)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(392, 392, 392)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(31, 31, 31)
                                                                .addComponent(b2)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(b3))
                                                        .addComponent(jLabel8)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(472, 472, 472)
                                                .addComponent(b1)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(t, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addGap(18, 18, 18))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(c2)
                                                                .addGap(10, 10, 10)))
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(c3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(c1))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(t1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cal, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                                                .addGap(19, 19, 19)))
                                .addComponent(b1)
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(t3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(b2)
                                        .addComponent(b3))
                                .addGap(23, 23, 23))
        );
        pack();
    }
    private void b1ActionPerformed(ActionEvent evt){
        String na = t.getText();
        if (na.equals("")){
            JOptionPane.showMessageDialog(this,"Please Enter User Name");
        }
        int a,b,c;
        a = Integer.parseInt(t1.getText());
         b=200;
         c = a * b;
        String s=(String)t.getText();
        String s1=(String)c1.getSelectedItem();
        String s2=(String)c2.getSelectedItem();
        String s3=(String)t1.getText();
        String s4=(String)c3.getSelectedItem();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd");
        String s5 = date.format(cal.getDate());

        if(s1.equals(s2))
        {
            JOptionPane.showMessageDialog(this,"Source and destination Cannot be Same");
            t.setText(null);
            t1.setText(null);
            t2.setText(null);
            t3.setText(null);
            c1.setSelectedItem("Pune");
            c2.setSelectedItem("Mumbai");
            c3.setSelectedItem("Economy");
        }else{
            t3.setText(Integer.toString(c));
            String s6=(String)t3.getText();
            t2.setText("*****************************\nName of User: "+s+"\nTO: "+s1+"\nFrom: "+s2+"\nNo of Passenger: "+s3+"\nTime: "+s4+"\nDate of Journey: "+s5+"\nPayble Amount: "+s6+"\n***************************");
        }
    }
    private void b2ActionPerformed(ActionEvent evt){
        t.setText(null);
        t1.setText(null);
        t2.setText(null);
        t3.setText(null);
        c1.setSelectedItem("Pune");
        c2.setSelectedItem("Mumbai");
        c3.setSelectedItem("Economy");
    }
    private void b3ActionPerformed(ActionEvent evt){
        try{
            String s=(String)t.getText();
            String s1=(String)c1.getSelectedItem();
            String s2=(String)c2.getSelectedItem();
            String s3=(String)t1.getText();
            String s4=(String)c3.getSelectedItem();
            SimpleDateFormat date_form=new SimpleDateFormat("yyyy-MM-dd");
            String s5=date_form.format(cal.getDate());
            String s6=(String)t3.getText();

            pst=c.prepareStatement("insert into booking_detail(user_name,s_source,destination,no_of_passenger,bus_time,journey_date,paid_amt)values(?,?,?,?,?,?,?)");
            pst.setString(1,s);
            pst.setString(2,s1);
            pst.setString(3,s2);
            pst.setString(4,s3);
            pst.setString(5,s4);
            pst.setString(6,s5);
            pst.setString(7,s6);
            int k=pst.executeUpdate();

            if (k==1){
                try{
                    try (FileWriter w = new FileWriter("BusBooking.txt",true)) {
                        w.append("\n\nName of User: "+s+"\nTO: "+s1+"\nFrom: "+s2+"\nNo of Passenger: "+s3+"\nTime: "+s4+"\nDate of Journey: "+s5+"\nPayble Amount: "+s6);
                        w.write(System.getProperty("line.separator"));
                        w.close();

                    }catch (Exception e){
                        JOptionPane.showMessageDialog(this,"Error: "+e);
                    }

                    JOptionPane.showMessageDialog(this,"Booking Successfull");
                    t.setText(null);
                    t1.setText(null);
                    t2.setText(null);
                    t3.setText(null);
                    c1.setSelectedItem("Pune");
                    c2.setSelectedItem("Mumbai");
                    c3.setSelectedItem("Economy");
                }catch (Exception e){
                    JOptionPane.showMessageDialog(this,"Error: "+e);
                }
            }else {
                JOptionPane.showMessageDialog(this,"Something Wrong");
            }
        }catch (Exception ex){
            Logger.getLogger(BusBooking.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
    public static void main(String args[]) {

        new BusBooking().setVisible(true);

    }
}


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author mrmar
 */

public class Kalkulator extends JFrame implements ActionListener {
    JLabel labelTitle, labelPanjang, labelLebar, labelTinggi, labelHasil, labelHasilLuas, labelHasilKeliling, labelHasilVolume, labelHasilLP;
    final JTextField fieldPanjang, fieldLebar, fieldTinggi;
    JButton buttonHitung, buttonReset;
    public Kalkulator(){
        // label judul
        labelTitle = new JLabel("Kalkulator Balok");

        // label dan field panjang
        labelPanjang = new JLabel("Panjang");
        fieldPanjang = new JTextField(15);
        
        // label dan field lebar
        labelLebar = new JLabel("Lebar");
        fieldLebar = new JTextField(15);

        // label dan field tinggi
        labelTinggi = new JLabel("Tinggi");
        fieldTinggi = new JTextField(15);

        //label hasil
        labelHasil = new JLabel("Hasil");
        labelHasilLuas = new JLabel();
        labelHasilKeliling = new JLabel();
        labelHasilVolume = new JLabel();
        labelHasilLP = new JLabel();

        // button yang digunakan
        buttonHitung = new JButton("Hitung");
        buttonReset = new JButton("Reset");
        
        // mengatur ukuran dan inputan
        setSize(500, 500);
        setTitle("Kalkulator Balok");
        setLayout(null);

        buttonHitung.addActionListener(this);
        buttonReset.addActionListener(this);

        add(labelTitle);
        add(labelPanjang);
        add(fieldPanjang);
        add(labelLebar);
        add(fieldLebar);
        add(labelTinggi);
        add(fieldTinggi);
        add(labelHasil);
        add(labelHasilLuas);
        add(labelHasilKeliling);
        add(labelHasilVolume);
        add(labelHasilLP);
        add(buttonHitung);
        add(buttonReset);

        labelTitle.setBounds(200,10, 100, 20);
        
        labelPanjang.setBounds(50, 60, 150, 20);
        fieldPanjang.setBounds(200, 60, 150, 20);
        labelLebar.setBounds(50, 110, 150, 20);
        fieldLebar.setBounds(200, 110, 150, 20);
        labelTinggi.setBounds(50, 160, 150, 20);
        fieldTinggi.setBounds(200, 160, 150, 20);
        labelHasil.setBounds(50, 210, 150, 20);
        labelHasilLuas.setBounds(50, 240, 200, 20);
        labelHasilKeliling.setBounds(50, 270, 200, 20);
        labelHasilVolume.setBounds(50, 300, 200, 20);
        labelHasilLP.setBounds(50, 330, 200, 20);
        
        buttonHitung.setBounds(150,350,100,50);
        buttonReset.setBounds(350,350,100,50);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // rumus yang digunakan
    public void actionPerformed(ActionEvent e){
        try{
            int luas, keliling, volume, luaspermukaan;
            int p = Integer.parseInt(fieldPanjang.getText());
            int l = Integer.parseInt(fieldLebar.getText());
            int t = Integer.parseInt(fieldTinggi.getText());

            if(e.getSource()==buttonHitung){
                luas = p * l;
                labelHasilLuas.setText("Luas Persegi : " + luas);
                keliling = 2*p + 2*l;
                labelHasilKeliling.setText("Keliling Persegi : " + keliling);
                volume = p * l * t;
                labelHasilVolume.setText("Volume Balok : " + volume);
                luaspermukaan = (2*p*l)+(2*p*t)+(2*t*l);
                labelHasilLP.setText("Luas Permukaan Balok : " + luaspermukaan);

            } else if(e.getSource()==buttonReset){
                clearFields();
            }

            
        // error handling
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(null, "Error Input");
        }
    }

    private void clearFields(){
        fieldPanjang.setText("");
        fieldLebar.setText("");
        fieldTinggi.setText("");
        labelHasilLuas.setText("");
        labelHasilLP.setText("");
        labelHasilVolume.setText("");
        labelHasilKeliling.setText("");
    }
}
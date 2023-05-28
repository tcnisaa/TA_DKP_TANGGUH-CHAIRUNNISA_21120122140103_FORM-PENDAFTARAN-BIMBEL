import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class tugasakhir {

    public JPanel panel1;
    private JComboBox comboboxbulan;
    private JButton beliButton;
    private JLabel labelnama;
    private JLabel labelnomortelepon;
    private JLabel labelttl;
    private JLabel labelalamat;
    private JTextField textfieldnomortelepon;
    private JLabel labeljeniskelamin;
    private JTextField textfieldnama;
    private JRadioButton radiobuttonlaki;
    private JRadioButton radiobuttonperempuan;
    private JComboBox comboboxtahun;
    private JComboBox comboboxtanggal;
    private JRadioButton radiobuttonsyarat;
    private JTextArea textareahasil;
    private JButton buttonsubmit;
    private JButton buttonbatal;
    private JTextField textfieldemail;
    private JLabel labelemail;
    private JTextField textfieldtempat;
    private JLabel labeldata;
    private JComboBox comboboxpaket;
    private JLabel labeljadwal;
    private JLabel labelharga;
    private JLabel labeldatadiri;
    private JLabel labelbiayadanjadwal;
    private JComboBox comboboxjadwal;
    private JTextField textfieldharga;
    private JTextArea textarearincian;
    private JTextField textFieldAlamat;
    private JTextField textFieldNamaWali;
    private JTextField textFieldNomorwali;
    public String awalan;
    int harga;

    public void setAwalan(String awalan) {
        this.awalan = awalan;
    }

    public String getAwalan() {
        return awalan;
    }

    int cekemail(){
        String email = textfieldemail.getText();
        if(email.contains("@gmail.com")){
            textfieldemail.setEditable(true);
            return 1;
        }else{
            JOptionPane.showMessageDialog(panel1, "Masukkan email yang valid");
            return 0;
        }
    }

    public tugasakhir() {
        buttonsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonsubmit) {
                    if(textfieldnama.getText().equals("")){
                        JOptionPane.showMessageDialog(panel1, "Silakan masukkan nama");
                    }else if(textfieldnomortelepon.getText().equals("")){
                        JOptionPane.showMessageDialog(panel1, "Silakan masukkan nomor telepon");
                    }else if(textfieldemail.getText().equals("")){
                        JOptionPane.showMessageDialog(panel1, "Silakan masukkan email");
                    }else if(textFieldAlamat.getText().equals("")){
                        JOptionPane.showMessageDialog(panel1, "Silakan masukkan alamat");
                    }else if(textfieldtempat.getText().equals("")){
                        JOptionPane.showMessageDialog(panel1, "Silakan masukkan tempat lahir");
                    }else if(textFieldNamaWali.getText().equals("")){
                        JOptionPane.showMessageDialog(panel1, "Silakan masukkan nama wali");
                    }else if(textFieldNomorwali.getText().equals("")){
                        JOptionPane.showMessageDialog(panel1, "Silakan masukkan nomor telepon wali");
                    }else if(comboboxjadwal.getSelectedItem().equals("...")){
                        JOptionPane.showMessageDialog(panel1, "Silakan pilih jadwal yang tersedia");
                    }else if(comboboxpaket.getSelectedItem().equals("...")) {
                        JOptionPane.showMessageDialog(panel1, "Silakan pilih tipe yang tersedia");
                    }else{
                        if (radiobuttonsyarat.isSelected()) {
                            String data1 = null;
                            String data4 = null;
                            String data = "Nama : " + textfieldnama.getText() + "\n" + "Nomor telepon : " + textfieldnomortelepon.getText() + "\n";
                            if (cekemail() == 1) {
                                if (radiobuttonlaki.isSelected()){
                                    data1 = "Jenis kelamin : Laki-laki" + "\n";
                                }else if(radiobuttonperempuan.isSelected()){
                                    data1 = "Jenis kelamin : Perempuan" + "\n";
                                }

                                if(comboboxpaket.getSelectedItem().equals("Lulus")){
                                    data4 = "Paket : Lulus" + "\n" + "Harga : Rp 13.000.000,-" + "\n";
                                }else if(comboboxpaket.getSelectedItem().equals("A")){
                                    data4 = "Paket : A" + "\n" + "Harga : Rp 14.000.000,-" + "\n";
                                }else if(comboboxpaket.getSelectedItem().equals("B")){
                                    data4 = "Paket : B" + "\n" + "Harga : Rp 15.000.000,-" + "\n";
                                }else if(comboboxpaket.getSelectedItem().equals("C")){
                                    data4 = "Paket : c" + "\n" + "Harga : Rp 17.000.000,-" + "\n";
                                }

                                String data2 = "Tempat, tanggal lahir : " + textfieldtempat.getText() + ", " + (String) comboboxtanggal.getSelectedItem() + " "
                                        + (String) comboboxbulan.getSelectedItem() + " " + (String) comboboxtahun.getSelectedItem() + "\n";

                                String data3 = "Alamat : " + textFieldAlamat.getText() + "\n" + "Email : " + textfieldemail.getText() + "\n";

                                String data5 = "Jadwal : " + comboboxjadwal.getSelectedItem() + "\n";
                                String data6 = "Nama Wali :" + textFieldNamaWali.getText() + "\n";

                                textareahasil.setText(data + data1 + data2 + data3 + data6);
                                textarearincian.setText(data4 + data5);
                                textareahasil.setEditable(false);
                                textarearincian.setEditable(false);
                                JOptionPane.showMessageDialog(panel1, "Registrasi berhasil");
                            }else if(cekemail() == 0){
                                JOptionPane.showMessageDialog(panel1, "Masukkan email yang valid");
                            }
                        }else {
                            textareahasil.setText("");
                            JOptionPane.showMessageDialog(panel1, "Mohon tekan syarat dan ketentuan");
                        }
                    }
                }
            }
        });

        textfieldnomortelepon.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                String nomor = textfieldnomortelepon.getText();
                int length = nomor.length();
                char c = e.getKeyChar();
                if(e.getKeyChar()>='0' && e.getKeyChar()<='9') {
                    if(length<=13){
                        textfieldnomortelepon.setEditable(true);
                    }else{
                        textfieldnomortelepon.setEditable(false);
                    }
                }else{
                    if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||e.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
                        textfieldnomortelepon.setEditable(true);
                    }else{
                        textfieldnomortelepon.setEditable(false);
                    }
                }
            }
        });

        textFieldNomorwali.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                String nomor = textFieldNomorwali.getText();
                int length = nomor.length();
                char c = e.getKeyChar();
                if(e.getKeyChar()>='0' && e.getKeyChar()<='9') {
                    if(length<=13){
                        textFieldNomorwali.setEditable(true);
                    }else{
                        textFieldNomorwali.setEditable(false);
                    }
                }else{
                    if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||e.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
                        textFieldNomorwali.setEditable(true);
                    }else{
                        textFieldNomorwali.setEditable(false);
                    }
                }
            }
        });

        buttonbatal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textfieldnama.setText("");
                textFieldAlamat.setText("");
                textfieldnomortelepon.setText("");
                textareahasil.setText("");
                radiobuttonsyarat.setSelected(false);
                textfieldtempat.setText("");
                comboboxtanggal.setSelectedIndex(0);
                comboboxbulan.setSelectedIndex(0);
                comboboxtahun.setSelectedIndex(0);
                textfieldemail.setText("");
                textFieldNomorwali.setText("");
                textFieldNamaWali.setText("");
                comboboxpaket.setSelectedIndex(0);
                comboboxjadwal.setSelectedIndex(0);
                textarearincian.setText("");
                textfieldharga.setText("");
            }
        });

        comboboxpaket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String paket = (String) comboboxpaket.getSelectedItem();
                switch (paket) {
                    case "Lulus":
                        textareahasil.setText("");
                        harga = 13000000;
                        break;
                    case "A":
                        textareahasil.setText("");
                        harga = 14000000;
                        break;
                    case "B":
                        textareahasil.setText("");
                        harga = 15000000;
                        break;
                    case "C":
                        textareahasil.setText("");
                        harga = 16000000;
                        break;
                }
                textfieldharga.setText("Rp " + Integer.toString(harga));
                textfieldharga.setEditable(false);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Form Registrasi Prosus Abe");
        frame.setContentPane(new tugasakhir().panel1);
        frame.setExtendedState((int) JFrame.LEFT_ALIGNMENT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.pack();
        frame.setVisible(true);
        frame.setSize(2200, 900);
        frame.setResizable(false);
        frame.setUndecorated(true);

        tugasakhir obj = new tugasakhir();
        obj.setAwalan("Silakan isi data berikut");

        JOptionPane.showMessageDialog(frame, obj.getAwalan());
    }

}

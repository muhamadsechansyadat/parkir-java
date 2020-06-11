/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication20;

import java.awt.event.ActionEvent;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import static koneksi.koneksi.cn;
import static com.sun.webkit.perf.WCFontPerfLogger.reset;
import java.net.URL;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author User
 */
public class form_transaksi extends javax.swing.JFrame {
    
    public Statement st;
    public ResultSet rs;
    public ResultSet rs1;
    public ResultSet rs2;
    public DefaultTableModel tabModel;
    Connection cn = koneksi.koneksi.getKoneksi();
    String jam;
    String jk;
    String lp;
    java.util.Date tglsekarang = new java.util.Date();
    public long bayar;
    public long kembalian;
    private SimpleDateFormat smpdtfmt = new SimpleDateFormat("dd MMMMMMMMM yyyy", Locale.getDefault());
    private String tanggal = smpdtfmt.format(tglsekarang);
    /**
     * Creates new form form_transaksi
     */
    public form_transaksi() {
        initComponents();
        judul();
        tampilData();
        waktu();
        autokodetransaksi();
        setJam();
        laporan();
        ljam.setText(jam);
        ltanggal.setText(tanggal);
    }
    
    public void autokodetransaksi()
    {
        try {
            rs = cn.createStatement().executeQuery("SELECT * FROM tb_transaksi ORDER BY kd_transaksi DESC");
            if (rs.next()) {
                String kode = rs.getString("kd_transaksi").substring(3);
                String AN = "" + (Integer.parseInt(kode) + 1);
                String Nol = "";
                
                if (AN.length()==1) {
                    Nol = "000";
                }else if(AN.length()==2){
                    Nol = "00";
                }else if(AN.length()==3){
                    Nol = "0";
                }else if(AN.length()==4){
                    Nol = "";
                }tkodeauto.setText("KR" + Nol + AN);
            }else{
                tkodeauto.setText("KR0001");
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public final void setJam(){
        ActionListener taskPerformer = new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                String nol_jam = "", nol_menit="", nol_detik="";
                
                java.util.Date dateTime = new java.util.Date();
                int nilai_jam = dateTime.getHours();
                int nilai_menit = dateTime.getMinutes();
                int nilai_detik = dateTime.getSeconds();
                
                if(nilai_jam<=9) nol_jam="0";
                if(nilai_menit<=9) nol_menit="0";
                if(nilai_detik<=9) nol_detik="0";
                
                String jam = nol_jam + Integer.toString(nilai_jam);
                String menit = nol_menit + Integer.toString(nilai_menit);
                String detik = nol_detik + Integer.toString(nilai_detik);
                
                ljam.setText(jam+":"+menit+":"+detik+"");
            }
        };
        new Timer(1000, taskPerformer).start();
    }
    
    private void judul() {
        Object[] judul = {"kd_transaksi","kd_parkir","jenis_kendaraan","jam_keluar","jumlah_jam","harga","bayar","kembali","status","tanggal_parkir"};
        tabModel = new DefaultTableModel(null, judul);
        table1.setModel(tabModel);
    }
    
    private void tampilData() {
        try {
            st=cn.createStatement();
            tabModel.getDataVector().removeAllElements();
            tabModel.fireTableDataChanged();
            rs = st.executeQuery("SELECT * FROM tb_transaksi");
            while(rs.next()){
                Object[] data = {
                    rs.getString("kd_transaksi"),
                    rs.getString("kd_parkir"),
                    rs.getString("jenis_kendaraan"),
                    rs.getString("jam_keluar"),
                    rs.getString("jumlah_jam"),
                    rs.getString("harga"),
                    rs.getString("bayar"),
                    rs.getString("kembali"),
                    rs.getString("status"),
                    rs.getString("tanggal_parkir")
                };
                tabModel.addRow(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void waktu(){
        for(int i = 1; i < 24; i++){
            lama_parkir.addItem(""+i);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        kd_cari = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lama_parkir = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        tharga = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tbayar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tkembali = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tstatus = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnjk = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        btnbth = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        tkodeauto = new javax.swing.JTextField();
        ljam = new javax.swing.JLabel();
        ltanggal = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Parkiran Perasaan");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Kode Parkir");

        kd_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kd_cariKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Lama Parkir");

        lama_parkir.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        lama_parkir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lama_parkirActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Jam");

        tharga.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tharga.setText("-");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Bayar");

        tbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbayarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Kembali");

        tkembali.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("status");

        tstatus.setEditable(false);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Hitung");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Jenis Kendaraan");

        btnjk.setEditable(false);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table1);

        btnbth.setText("Back To Home");
        btnbth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbthActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Kode Transaksi");

        tkodeauto.setEditable(false);
        tkodeauto.setText("KT000");
        tkodeauto.setEnabled(false);

        ljam.setText(".....");

        ltanggal.setText("......");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Lihat Laporan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(50, 50, 50)
                                .addComponent(tbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(tkodeauto, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(lama_parkir, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(18, 18, 18)
                                            .addComponent(kd_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(30, 30, 30)
                                            .addComponent(tharga, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel4)
                                                .addGap(24, 24, 24)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(59, 59, 59)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(ltanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(btnjk, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(ljam, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(213, 213, 213))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jButton1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                    .addComponent(btnbth))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7))
                                    .addGap(39, 39, 39)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tstatus, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                        .addComponent(tkembali))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tkodeauto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ljam)
                    .addComponent(ltanggal))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(kd_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(btnjk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(lama_parkir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(tharga)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tbayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tkembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(btnbth)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(84, 84, 84))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbayarActionPerformed

    private void kd_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kd_cariKeyReleased
        try{
            st = cn.createStatement();
            rs = st.executeQuery("SELECT jenis_kendaraan FROM tb_pengendara WHERE kd_parkir ='"+ kd_cari.getText() +"'");
           
            if(rs.next()){
                btnjk.setText(rs.getString("jenis_kendaraan"));
            }else{
                btnjk.setText("");
            }
        }catch(Exception a){
            a.printStackTrace();
        }
        
        if(btnjk.getText().equals("")){
            btnjk.setText("");
        }
    }//GEN-LAST:event_kd_cariKeyReleased

    private void lama_parkirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lama_parkirActionPerformed
        // TODO add your handling code here:
        if(btnjk.getText().equals("Motor")){
            if(lama_parkir.getSelectedItem().equals("1")){
                tharga.setText("2000");
                tbayar.setText("");
                tstatus.setText("");
                tkembali.setText("");
            }else if(lama_parkir.getSelectedItem().equals("2")){
                tharga.setText("3000");
                tbayar.setText("");
                tstatus.setText("");
                tkembali.setText("");
            }else if(lama_parkir.getSelectedItem().equals("3")){
                tharga.setText("4000");
                tbayar.setText("");
                tstatus.setText("");
                tkembali.setText("");
            }else if(lama_parkir.getSelectedItem().equals("4")){
                tharga.setText("5000");
                tbayar.setText("");
                tstatus.setText("");
                tkembali.setText("");
            }else if(lama_parkir.getSelectedItem().equals("5")){
                tharga.setText("6000");
                tbayar.setText("");
                tstatus.setText("");
                tkembali.setText("");
            }else if(lama_parkir.getSelectedItem().equals("6")){
                tharga.setText("7000");
                tbayar.setText("");
                tstatus.setText("");
                tkembali.setText("");
            }else if(lama_parkir.getSelectedItem().equals("7")){
                tharga.setText("8000");
                tbayar.setText("");
                tstatus.setText("");
                tkembali.setText("");
            }else if(lama_parkir.getSelectedItem().equals("8")){
                tharga.setText("9000");
                tbayar.setText("");
                tstatus.setText("");
                tkembali.setText("");
            }
        }else if(btnjk.getText().equals("Mobil")){
            if(lama_parkir.getSelectedItem().equals("1")){
                tharga.setText("4000");
                tbayar.setText("");
                tstatus.setText("");
                tkembali.setText("");
            }else if(lama_parkir.getSelectedItem().equals("2")){
                tharga.setText("5000");
                tbayar.setText("");
                tstatus.setText("");
                tkembali.setText("");
            }else if(lama_parkir.getSelectedItem().equals("3")){
                tharga.setText("6000");
                tbayar.setText("");
                tstatus.setText("");
                tkembali.setText("");
            }else if(lama_parkir.getSelectedItem().equals("4")){
                tharga.setText("7000");
                tbayar.setText("");
                tstatus.setText("");
                tkembali.setText("");
            }else if(lama_parkir.getSelectedItem().equals("5")){
                tharga.setText("8000");
                tbayar.setText("");
                tstatus.setText("");
                tkembali.setText("");
            }else if(lama_parkir.getSelectedItem().equals("6")){
                tharga.setText("9000");
                tbayar.setText("");
                tstatus.setText("");
                tkembali.setText("");
            }else if(lama_parkir.getSelectedItem().equals("7")){
                tharga.setText("10000");
                tbayar.setText("");
                tstatus.setText("");
                tkembali.setText("");
            }else if(lama_parkir.getSelectedItem().equals("8")){
                tharga.setText("11000");
                tbayar.setText("");
                tstatus.setText("");
                tkembali.setText("");
            }
        }else if(btnjk.getText().equals("Lainnya")){
            if(lama_parkir.getSelectedItem().equals("1")){
                tharga.setText("5000");
                tbayar.setText("");
                tstatus.setText("");
                tkembali.setText("");
            }else if(lama_parkir.getSelectedItem().equals("2")){
                tharga.setText("6000");
                tbayar.setText("");
                tstatus.setText("");
                tkembali.setText("");
            }else if(lama_parkir.getSelectedItem().equals("3")){
                tharga.setText("7000");
                tbayar.setText("");
                tstatus.setText("");
                tkembali.setText("");
            }else if(lama_parkir.getSelectedItem().equals("4")){
                tharga.setText("8000");
                tbayar.setText("");
                tstatus.setText("");
                tkembali.setText("");
            }else if(lama_parkir.getSelectedItem().equals("5")){
                tharga.setText("9000");
                tbayar.setText("");
                tstatus.setText("");
                tkembali.setText("");
            }else if(lama_parkir.getSelectedItem().equals("6")){
                tharga.setText("10000");
                tbayar.setText("");
                tstatus.setText("");
                tkembali.setText("");
            }else if(lama_parkir.getSelectedItem().equals("7")){
                tharga.setText("11000");
                tbayar.setText("");
                tstatus.setText("");
                tkembali.setText("");
            }else if(lama_parkir.getSelectedItem().equals("8")){
                tharga.setText("12000");
                tbayar.setText("");
                tstatus.setText("");
                tkembali.setText("");
            }
        }
    }//GEN-LAST:event_lama_parkirActionPerformed

    private void btnbthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbthActionPerformed
        // TODO add your handling code here:
        this.dispose();
        form_input fi = new form_input();
        fi.show();
    }//GEN-LAST:event_btnbthActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(tharga.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap Isi Terlebih Dahulu Muslimin Muslimat");
        }else{
            bayar = Long.parseLong(tbayar.getText());

            if(btnjk.getText().equals("Motor")){
                if(lama_parkir.getSelectedItem().equals("1")){
                    if(bayar>=2000){
                        kembalian = bayar - 2000;
                        tkembali.setText(""+ kembalian +"");
                        tstatus.setText("Lunas");
                        
                        try {
                                st = cn.createStatement();
                                st.executeUpdate("UPDATE tb_pengendara set status='Tidak Ada' where kd_parkir='"+ kd_cari.getText() +"'");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        try {
                            st = cn.createStatement();
                            if(lama_parkir.getSelectedItem().equals("1")){
                                lp = "1";
                            }else if(lama_parkir.getSelectedItem().equals("2")){
                                lp = "2";
                            }else if(lama_parkir.getSelectedItem().equals("3")){
                                lp = "3";
                            }else if(lama_parkir.getSelectedItem().equals("4")){
                                lp = "4";
                            }if(lama_parkir.getSelectedItem().equals("5")){
                                lp = "5";
                            }else if(lama_parkir.getSelectedItem().equals("6")){
                                lp = "6";
                            }
                            
                            st.executeUpdate("INSERT INTO tb_transaksi set kd_transaksi='"+ tkodeauto.getText() +"',kd_parkir='"+ kd_cari.getText()+"',jenis_kendaraan='"+btnjk.getText()+"',jam_keluar='"+ljam.getText()+"',jumlah_jam='"+ lp +"', harga='"+ tharga.getText() +"', bayar='"+ tbayar.getText() +"', kembali='"+ tkembali.getText()+ "', status='" + tstatus.getText() +"', tanggal_parkir='" + ltanggal.getText() + "'");
                            tampilData();
                            JOptionPane.showMessageDialog(null, "Terima Kasih");
                            kd_cari.setText("");
                            btnjk.setText("");
                            tharga.setText("");
                            tbayar.setText("");
                            tkembali.setText("");
                            tstatus.setText("");
                            autokodetransaksi();
                            
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }else if(bayar<=2000){
                        kembalian = 2000 - bayar;
                        JOptionPane.showMessageDialog(null, "Uang Anda Kurang "+kembalian);
                        tkembali.setText("");
                        tstatus.setText("Belum Lunas");
                    }
                    
                }else if(lama_parkir.getSelectedItem().equals("2")){
                    if(bayar>=3000){
                        kembalian = bayar - 3000;
                        tkembali.setText(""+kembalian+"");
                        tstatus.setText("Lunas");
                        
                        try {
                                st = cn.createStatement();
                                st.executeUpdate("UPDATE tb_pengendara set status='Tidak Ada' where kd_parkir='"+ kd_cari.getText() +"'");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        try {
                            st = cn.createStatement();
                            if(lama_parkir.getSelectedItem().equals("1")){
                                lp = "1";
                            }else if(lama_parkir.getSelectedItem().equals("2")){
                                lp = "2";
                            }else if(lama_parkir.getSelectedItem().equals("3")){
                                lp = "3";
                            }else if(lama_parkir.getSelectedItem().equals("4")){
                                lp = "4";
                            }if(lama_parkir.getSelectedItem().equals("5")){
                                lp = "5";
                            }else if(lama_parkir.getSelectedItem().equals("6")){
                                lp = "6";
                            }
                            
                            st.executeUpdate("INSERT INTO tb_transaksi set kd_transaksi='"+ tkodeauto.getText() +"',kd_parkir='"+ kd_cari.getText()+"',jenis_kendaraan='"+btnjk.getText()+"',jam_keluar='"+ljam.getText()+"',jumlah_jam='"+ lp +"', harga='"+ tharga.getText() +"', bayar='"+ tbayar.getText() +"', kembali='"+ tkembali.getText()+ "', status='" + tstatus.getText() +"', tanggal_parkir='" + ltanggal.getText() + "'");
                            tampilData();
                            JOptionPane.showMessageDialog(null, "Terima Kasih");
                            kd_cari.setText("");
                            btnjk.setText("");
                            tharga.setText("");
                            tbayar.setText("");
                            tkembali.setText("");
                            tstatus.setText("");
                            autokodetransaksi();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }else if(bayar<=3000){
                        kembalian = 3000-bayar;
                        JOptionPane.showMessageDialog(null, "Uang Anda Kurang "+kembalian);
                        tkembali.setText("");
                        tstatus.setText("Belum Lunas");
                    }
                }
            }
            else if(btnjk.getText().equals("Mobil")){
                if(lama_parkir.getSelectedItem().equals("1")){
                    if(bayar>=4000){
                        kembalian = bayar - 4000;
                        tkembali.setText(""+ kembalian +"");
                        tstatus.setText("Lunas");
                        try {
                                st = cn.createStatement();
                                st.executeUpdate("UPDATE tb_pengendara set status='Tidak Ada' where kd_parkir='"+ kd_cari.getText() +"'");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        try {
                            st = cn.createStatement();
                            if(lama_parkir.getSelectedItem().equals("1")){
                                lp = "1";
                            }else if(lama_parkir.getSelectedItem().equals("2")){
                                lp = "2";
                            }else if(lama_parkir.getSelectedItem().equals("3")){
                                lp = "3";
                            }else if(lama_parkir.getSelectedItem().equals("4")){
                                lp = "4";
                            }if(lama_parkir.getSelectedItem().equals("5")){
                                lp = "5";
                            }else if(lama_parkir.getSelectedItem().equals("6")){
                                lp = "6";
                            }
                            
                            st.executeUpdate("INSERT INTO tb_transaksi set kd_transaksi='"+ tkodeauto.getText() +"',kd_parkir='"+ kd_cari.getText()+"',jenis_kendaraan='"+btnjk.getText()+"',jam_keluar='"+ljam.getText()+"',jumlah_jam='"+ lp +"', harga='"+ tharga.getText() +"', bayar='"+ tbayar.getText() +"', kembali='"+ tkembali.getText()+ "', status='" + tstatus.getText() +"', tanggal_parkir='" + ltanggal.getText() + "'");
                            tampilData();
                            JOptionPane.showMessageDialog(null, "Terima Kasih");
                            kd_cari.setText("");
                            btnjk.setText("");
                            tharga.setText("");
                            tbayar.setText("");
                            tkembali.setText("");
                            tstatus.setText("");
                            autokodetransaksi();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }else if(bayar<=4000){
                        kembalian = 4000 - bayar;
                        JOptionPane.showMessageDialog(null, "Uang Anda Kurang "+kembalian);
                        tkembali.setText("");
                        tstatus.setText("Belum Lunas");  
                    }
                    
                }else if(lama_parkir.getSelectedItem().equals("2")){
                    if(bayar>=5000){
                        kembalian = bayar - 5000;
                        tkembali.setText(""+kembalian+"");
                        tstatus.setText("Lunas");
                        
                        try {
                                st = cn.createStatement();
                                st.executeUpdate("UPDATE tb_pengendara set status='Tidak Ada' where kd_parkir='"+ kd_cari.getText() +"'");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        try {
                            st = cn.createStatement();
                            if(lama_parkir.getSelectedItem().equals("1")){
                                lp = "1";
                            }else if(lama_parkir.getSelectedItem().equals("2")){
                                lp = "2";
                            }else if(lama_parkir.getSelectedItem().equals("3")){
                                lp = "3";
                            }else if(lama_parkir.getSelectedItem().equals("4")){
                                lp = "4";
                            }if(lama_parkir.getSelectedItem().equals("5")){
                                lp = "5";
                            }else if(lama_parkir.getSelectedItem().equals("6")){
                                lp = "6";
                            }
                            
                            st.executeUpdate("INSERT INTO tb_transaksi set kd_transaksi='"+ tkodeauto.getText() +"',kd_parkir='"+ kd_cari.getText()+"',jenis_kendaraan='"+btnjk.getText()+"',jam_keluar='"+ljam.getText()+"',jumlah_jam='"+ lp +"', harga='"+ tharga.getText() +"', bayar='"+ tbayar.getText() +"', kembali='"+ tkembali.getText()+ "', status='" + tstatus.getText() +"', tanggal_parkir='" + ltanggal.getText() + "'");
                            tampilData();
                            JOptionPane.showMessageDialog(null, "Terima Kasih");
                            kd_cari.setText("");
                            btnjk.setText("");
                            tharga.setText("");
                            tbayar.setText("");
                            tkembali.setText("");
                            tstatus.setText("");
                            autokodetransaksi();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }else if(bayar<=5000){
                        kembalian = 3000-bayar;
                        JOptionPane.showMessageDialog(null, "Uang Anda Kurang "+kembalian);
                        tkembali.setText("");
                        tstatus.setText("Belum Lunas");
                    }
                }
            }
            else if(btnjk.getText().equals("Lainnya")){
                if(lama_parkir.getSelectedItem().equals("1")){
                    if(bayar>=5000){
                        kembalian = bayar-5000;
                        tkembali.setText(""+ kembalian +"");
                        tstatus.setText("Lunas");
                        
                        try {
                                st = cn.createStatement();
                                st.executeUpdate("UPDATE tb_pengendara set status='Tidak Ada' where kd_parkir='"+ kd_cari.getText() +"'");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        try {
                            st = cn.createStatement();
                            if(lama_parkir.getSelectedItem().equals("1")){
                                lp = "1";
                            }else if(lama_parkir.getSelectedItem().equals("2")){
                                lp = "2";
                            }else if(lama_parkir.getSelectedItem().equals("3")){
                                lp = "3";
                            }else if(lama_parkir.getSelectedItem().equals("4")){
                                lp = "4";
                            }if(lama_parkir.getSelectedItem().equals("5")){
                                lp = "5";
                            }else if(lama_parkir.getSelectedItem().equals("6")){
                                lp = "6";
                            }
                            
                            st.executeUpdate("INSERT INTO tb_transaksi set kd_transaksi='"+ tkodeauto.getText() +"',kd_parkir='"+ kd_cari.getText()+"',jenis_kendaraan='"+btnjk.getText()+"',jam_keluar='"+ljam.getText()+"',jumlah_jam='"+ lp +"', harga='"+ tharga.getText() +"', bayar='"+ tbayar.getText() +"', kembali='"+ tkembali.getText()+ "', status='" + tstatus.getText() +"', tanggal_parkir='" + ltanggal.getText() + "'");
                            tampilData();
                            JOptionPane.showMessageDialog(null, "Terima Kasih");
                            kd_cari.setText("");
                            btnjk.setText("");
                            tharga.setText("");
                            tbayar.setText("");
                            tkembali.setText("");
                            tstatus.setText("");
                            autokodetransaksi();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }else if(bayar<=5000){
                        kembalian = 5000 - bayar;
                        JOptionPane.showMessageDialog(null, "Uang Anda Kurang " +kembalian);
                        tkembali.setText("");
                        tstatus.setText("Belum Lunas");
                    }
                }if(lama_parkir.getSelectedItem().equals("2")){
                    if(bayar>=6000){
                        kembalian = bayar-6000;
                        tkembali.setText(""+ kembalian +"");
                        tstatus.setText("Lunas");
                        
                        try {
                                st = cn.createStatement();
                                st.executeUpdate("UPDATE tb_pengendara set status='Tidak Ada' where kd_parkir='"+ kd_cari.getText() +"'");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        try {
                            st = cn.createStatement();
                            if(lama_parkir.getSelectedItem().equals("1")){
                                lp = "1";
                            }else if(lama_parkir.getSelectedItem().equals("2")){
                                lp = "2";
                            }else if(lama_parkir.getSelectedItem().equals("3")){
                                lp = "3";
                            }else if(lama_parkir.getSelectedItem().equals("4")){
                                lp = "4";
                            }if(lama_parkir.getSelectedItem().equals("5")){
                                lp = "5";
                            }else if(lama_parkir.getSelectedItem().equals("6")){
                                lp = "6";
                            }
                            
                            st.executeUpdate("INSERT INTO tb_transaksi set kd_transaksi='"+ tkodeauto.getText() +"',kd_parkir='"+ kd_cari.getText()+"',jenis_kendaraan='"+btnjk.getText()+"',jam_keluar='"+ljam.getText()+"',jumlah_jam='"+ lp +"', harga='"+ tharga.getText() +"', bayar='"+ tbayar.getText() +"', kembali='"+ tkembali.getText()+ "', status='" + tstatus.getText() +"', tanggal_parkir='" + ltanggal.getText() + "'");
                            tampilData();
                            JOptionPane.showMessageDialog(null, "Terima Kasih");
                            kd_cari.setText("");
                            btnjk.setText("");
                            tharga.setText("");
                            tbayar.setText("");
                            tkembali.setText("");
                            tstatus.setText("");
                            autokodetransaksi();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }else if(bayar<=6000){
                        kembalian = 6000 - bayar;
                        JOptionPane.showMessageDialog(null, "Uang Anda Kurang " +kembalian);
                        tkembali.setText("");
                        tstatus.setText("Belum Lunas");
                    }
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        laporan();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(form_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbth;
    private javax.swing.JTextField btnjk;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kd_cari;
    private javax.swing.JComboBox<String> lama_parkir;
    private javax.swing.JLabel ljam;
    private javax.swing.JLabel ltanggal;
    private javax.swing.JTable table1;
    private javax.swing.JTextField tbayar;
    private javax.swing.JLabel tharga;
    private javax.swing.JTextField tkembali;
    private javax.swing.JTextField tkodeauto;
    private javax.swing.JTextField tstatus;
    // End of variables declaration//GEN-END:variables

    private void laporan() {
        String reportSource = null;
        String reportDest = null;
            try {
                String file="src/javaapplication20/report2.jasper";
                JasperPrint jp = JasperFillManager.fillReport(file, null, cn);
                JasperViewer jv = new JasperViewer(jp, false);
                jv.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem.laundry;

import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FormPenerimaanBarang extends javax.swing.JFrame {

    private static Connection koneksi;
    private DefaultTableModel model;
    private int harga, berat, total, bayar, kembali;
    private String m;
    
    public FormPenerimaanBarang(String m) {
        initComponents();
        model = new DefaultTableModel();
        daftarPelanggan();
        daftarJenisCucian();
        this.jTable_Penerimaan.setModel(model);
        model.addColumn("No Order");
        model.addColumn("ID");
        model.addColumn("Pelanggan");
        model.addColumn("Jenis Cucian");        
        model.addColumn("Total Bayar");
        model.addColumn("Bayar");
        model.addColumn("Kembalian");
        model.addColumn("Tanggal Masuk");
        model.addColumn("Tanggal Keluar");        
        model.addColumn("Status Cucian");
        this.m = m;
        ambil_data_tabel();
        this.setLocationRelativeTo(null);
    }

    public FormPenerimaanBarang() {
        initComponents();      
    }
    
    private void ambil_data_tabel() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try {
            buka_koneksi();
            Statement s = koneksi.createStatement();
            String sql = "Select * from penerimaan";
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                Object[] o = new Object[10];
                o[0] = r.getString("no_order");
                o[1] = r.getString("id_pelanggan"); 
                o[2] = r.getString("nama_pelanggan"); 
                o[3] = r.getString("jenis_cucian");
                o[4] = r.getInt("t_bayar");
                o[5] = r.getInt("bayar");
                o[6] = r.getInt("sisa");                
                o[7] = r.getDate("tgl_masuk");
                o[8] = r.getDate("tgl_keluar");
                o[9] = r.getString("status_cucian");
                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan " + e.getMessage());
        }
    }
    
    private static void buka_koneksi() {
        if (koneksi == null) {
            try {
                String url = "jdbc:mysql://localhost/sistem_laundry";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, user, password);
            } catch (SQLException t) {
                System.out.println("Error membuat koneksi");
            }
        }
    }
    
    public void daftarPelanggan() {
        cmbDaftarId.removeAllItems();
        cmbDaftarId.addItem("Pilih");
        
        try {
            buka_koneksi();
            String sql = "SELECT * FROM pelanggan";
            Statement s = koneksi.createStatement();
            ResultSet r = s.executeQuery(sql);
            
            while (r.next()) {                
                String ambilId = r.getString("id_pelanggan");
                cmbDaftarId.addItem(ambilId);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menampilkan ID Pelanggan \n" + e.getMessage());
        }
    }
    
    public void daftarJenisCucian() {
        cmbJenis.removeAllItems();
        cmbJenis.addItem("Pilih");
        
        try {
            buka_koneksi();
            String sql = "SELECT * FROM jenis_cucian";
            Statement s = koneksi.createStatement();
            ResultSet r = s.executeQuery(sql);
            
            while (r.next()) {                
                String jenisCucian = r.getString("id_jenis");
                cmbJenis.addItem(jenisCucian);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menampilkan jenis cucian \n" + e.getMessage());
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

        jTextField5 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Penerimaan = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtOrder = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtBayar = new javax.swing.JTextField();
        cmbJenis = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbStat = new javax.swing.JComboBox<>();
        cmbDaftarId = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        btnHitung = new javax.swing.JButton();
        txtBerat = new javax.swing.JTextField();
        btnBayar = new javax.swing.JButton();
        txtKembali = new javax.swing.JTextField();
        cmbDayMasuk = new javax.swing.JComboBox<>();
        cmbMonthMasuk = new javax.swing.JComboBox<>();
        cmbYearMasuk = new javax.swing.JComboBox<>();
        cmbDayKeluar = new javax.swing.JComboBox<>();
        cmbMonthKeluar = new javax.swing.JComboBox<>();
        cmbYearKeluar = new javax.swing.JComboBox<>();

        jTextField5.setText("jTextField5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");

        jTable_Penerimaan.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_Penerimaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_PenerimaanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_Penerimaan);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTambah)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus)
                        .addGap(18, 18, 18)
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKembali)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnKembali)
                    .addComponent(btnHapus)
                    .addComponent(btnRefresh))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setText("Form Penerimaan");

        jLabel2.setText("No. Order");

        jLabel3.setText("ID Pelanggan");

        jLabel5.setText("Nama Pelanggan");

        jLabel6.setText("Harga");

        jLabel7.setText("Berat");

        txtHarga.setText("0");

        jLabel8.setText("Total");

        jLabel9.setText("Bayar");

        jLabel10.setText("Kembalian");

        jLabel11.setText("Status Cucian");

        txtTotal.setText("0");

        cmbJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbJenis.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbJenisItemStateChanged(evt);
            }
        });

        jLabel12.setText("Tanggal Masuk");

        jLabel13.setText("Tanggal Keluar");

        jLabel4.setText("/Kg");

        cmbStat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Proses", "Selesai" }));
        cmbStat.setSelectedIndex(-1);

        cmbDaftarId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbDaftarId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDaftarIdItemStateChanged(evt);
            }
        });

        jLabel14.setText("Jenis Cucian");

        btnHitung.setText("Total");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });

        btnBayar.setText("Bayar");
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });

        cmbDayMasuk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
        cmbDayMasuk.setSelectedIndex(-1);

        cmbMonthMasuk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "October", "November", "Desember" }));
        cmbMonthMasuk.setSelectedIndex(-1);

        cmbYearMasuk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018", "2019", "2020" }));

        cmbDayKeluar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
        cmbDayKeluar.setSelectedIndex(-1);

        cmbMonthKeluar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "October", "November", "Desember" }));
        cmbMonthKeluar.setSelectedIndex(-1);

        cmbYearKeluar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018", "2019" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel14))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHitung)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtBerat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addComponent(cmbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbDaftarId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(113, 113, 113)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBayar))
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbStat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cmbDayKeluar, javax.swing.GroupLayout.Alignment.LEADING, 0, 49, Short.MAX_VALUE)
                                            .addComponent(cmbDayMasuk, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbMonthMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbMonthKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbYearMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbYearKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBayar))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbDaftarId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cmbStat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(cmbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(jLabel6))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbDayMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbMonthMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbYearMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(cmbDayKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbMonthKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbYearKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel7)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtBerat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)))
                .addComponent(btnHitung)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:        
        if (txtOrder.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "no Order harus diisi !");
        } else if (cmbDaftarId.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Harus memilih id pelanggan harus diisi !");
        } else if (cmbJenis.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Jenis cucian harus diisi !");
        } else if (txtBayar.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Pembayaran tidak boleh kosong !");
        } else {
            String bulanMasuk = "";
            switch(cmbMonthMasuk.getSelectedItem().toString()){
                case "Januari"  : bulanMasuk = "01"; break;
                case "Februari" : bulanMasuk = "02"; break;
                case "Maret"    : bulanMasuk = "03"; break;
                case "April"    : bulanMasuk = "04"; break;
                case "Mei"      : bulanMasuk = "05"; break;
                case "Juni"     : bulanMasuk = "06"; break;
                case "Juli"     : bulanMasuk = "07"; break;
                case "Agustus"  : bulanMasuk = "08"; break;
                case "September": bulanMasuk = "09"; break;
                case "Oktober"  : bulanMasuk = "10"; break;
                case "November" : bulanMasuk = "11"; break;
                case "Desember" : bulanMasuk = "12"; break;
            }
            
            String bulanKeluar = "";
            switch(cmbMonthMasuk.getSelectedItem().toString()){
                case "Januari"  : bulanKeluar = "01"; break;
                case "Februari" : bulanKeluar = "02"; break;
                case "Maret"    : bulanKeluar = "03"; break;
                case "April"    : bulanKeluar = "04"; break;
                case "Mei"      : bulanKeluar = "05"; break;
                case "Juni"     : bulanKeluar = "06"; break;
                case "Juli"     : bulanKeluar = "07"; break;
                case "Agustus"  : bulanKeluar = "08"; break;
                case "September": bulanKeluar = "09"; break;
                case "Oktober"  : bulanKeluar = "10"; break;
                case "November" : bulanKeluar = "11"; break;
                case "Desember" : bulanKeluar = "12"; break;
            }
            
            buka_koneksi();
            String sqlkode = "INSERT INTO penerimaan (no_order, id_pelanggan, nama_pelanggan, jenis_cucian, t_bayar, bayar, sisa, tgl_masuk, tgl_keluar, status_cucian) "
                    + "VALUES ('"
                    + this.txtOrder.getText() + "','"
                    + this.cmbDaftarId.getSelectedItem() + "','"
                    + this.txtNama.getText() + "','"
                    + this.cmbJenis.getSelectedItem()+ "',"
                    + Integer.parseInt(this.txtTotal.getText()) + ","
                    + Integer.parseInt(this.txtBayar.getText()) + ","
                    + Integer.parseInt(this.txtKembali.getText()) + ",'"                   
                    + cmbYearMasuk.getSelectedItem().toString() + "-" + bulanMasuk + "-" + cmbDayMasuk.getSelectedItem().toString() + "','"
                    + cmbYearKeluar.getSelectedItem().toString() + "-" + bulanKeluar + "-" + cmbDayKeluar.getSelectedItem().toString() + "','"
                    + this.cmbStat.getSelectedItem() + "')";            
            try {
                PreparedStatement mStatement = koneksi.prepareStatement(sqlkode);
                mStatement.executeUpdate();
                mStatement.close();
                JOptionPane.showMessageDialog(this, "Data berhasil ditambah");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Terjadi Kesalahan " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void cmbDaftarIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDaftarIdItemStateChanged
        // TODO add your handling code here:
        try {
            buka_koneksi();
            String sql = "SELECT * FROM pelanggan WHERE id_pelanggan = '" + cmbDaftarId.getSelectedItem() + "'";            
            Statement s = koneksi.createStatement();
            ResultSet r = s.executeQuery(sql);
            
            while (r.next()) {                
                txtNama.setText(r.getString("nama_pelanggan"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menampilkan nama pelanggan \n" + e.getMessage());
        }
    }//GEN-LAST:event_cmbDaftarIdItemStateChanged

    private void cmbJenisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbJenisItemStateChanged
        // TODO add your handling code here:
        try {
            buka_koneksi();
            String sql = "SELECT * FROM jenis_cucian WHERE id_jenis = '" + cmbJenis.getSelectedItem() + "'";            
            Statement s = koneksi.createStatement();
            ResultSet r = s.executeQuery(sql);
            
            while (r.next()) {                
//                txtHarga.setText(String.valueOf(r.getString("harga")));
                txtHarga.setText(r.getString("harga"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menampilkan nama pelanggan \n" + e.getMessage());
        }
    }//GEN-LAST:event_cmbJenisItemStateChanged

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        // TODO add your handling code here:
        harga = Integer.parseInt(txtHarga.getText());
        berat = Integer.parseInt(txtBerat.getText());
        
        total = harga * berat;
        
        txtTotal.setText(String.valueOf(total));
    }//GEN-LAST:event_btnHitungActionPerformed

    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
        // TODO add your handling code here:
        int a,b;
        a = Integer.parseInt(txtBayar.getText());
        b = Integer.parseInt(txtTotal.getText());
        if (a < b) {
            JOptionPane.showMessageDialog(null, "Uang Anda Kurang");
        } else {
            total = Integer.parseInt(txtTotal.getText());
            bayar = Integer.parseInt(txtBayar.getText());
        
            kembali = total - bayar;
            txtKembali.setText(String.valueOf(kembali));
        }                
    }//GEN-LAST:event_btnBayarActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        // TODO add your handling code here:
        if (m.equals("Admin")) {
            FormHomeAdmin fha = new FormHomeAdmin(m);
            fha.setVisible(true);
            this.setVisible(false);
        } else {
            FormHomeUser fhu = new FormHomeUser(m);
            fhu.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Yakin Mendelete record ini???", "Confirmation",
                JOptionPane.YES_NO_CANCEL_OPTION);

        if (ok == 0) {
            try {
                String sql = "DELETE FROM penerimaan where no_order='"
                        + txtOrder.getText() + "'";
                PreparedStatement st = koneksi.prepareStatement(sql);
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Delete Data Sukses");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Delete Data Gagal");
            }
        } 
    }//GEN-LAST:event_btnHapusActionPerformed

    private void jTable_PenerimaanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_PenerimaanMouseClicked
        
    }//GEN-LAST:event_jTable_PenerimaanMouseClicked

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
            java.util.logging.Logger.getLogger(FormPenerimaanBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPenerimaanBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPenerimaanBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPenerimaanBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPenerimaanBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBayar;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cmbDaftarId;
    private javax.swing.JComboBox<String> cmbDayKeluar;
    private javax.swing.JComboBox<String> cmbDayMasuk;
    private javax.swing.JComboBox<String> cmbJenis;
    private javax.swing.JComboBox<String> cmbMonthKeluar;
    private javax.swing.JComboBox<String> cmbMonthMasuk;
    private javax.swing.JComboBox<String> cmbStat;
    private javax.swing.JComboBox<String> cmbYearKeluar;
    private javax.swing.JComboBox<String> cmbYearMasuk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_Penerimaan;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtBerat;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtKembali;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtOrder;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}

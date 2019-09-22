/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem.laundry;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FormMaster extends javax.swing.JFrame {

    private static Connection koneksi;
    private DefaultTableModel model;
    private String m;

    public FormMaster(String m) {
        initComponents();
        model = new DefaultTableModel();
        this.jTable_Master.setModel(model);
        model.addColumn("ID");
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("Nama Lengkap");
        model.addColumn("Status");
        model.addColumn("No Telp");
        this.m = m;
        ambil_data_tabel();
        this.setLocationRelativeTo(null);
    }
    
    public FormMaster(){
        initComponents();
    }

    private void ambil_data_tabel() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try {
            buka_koneksi();
            Statement s = koneksi.createStatement();
            String sql = "Select * from petugas";
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                Object[] o = new Object[6];
                o[0] = r.getString("id_petugas");
                o[1] = r.getString("username");
                o[2] = r.getString("password");
                o[3] = r.getString("nama_petugas");
                o[4] = r.getString("status");
                o[5] = r.getString("no_telp");
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

//    public void dataLoad() {
//        idPetugas = id.getText();
//        username = user.getText();
//        password = pass.getText();
//        stat = (String) status.getSelectedItem();
//        namaLkp = namaLengkap.getText();
//        noTelp = notelp.getText();
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Master = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        BtnKembali = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtNamaLengkap = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNotelp = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Master.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jTable_Master.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_MasterMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Master);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 550, 90));

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel1.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

        BtnKembali.setText("Kembali");
        BtnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKembaliActionPerformed(evt);
            }
        });
        jPanel1.add(BtnKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, -1, -1));

        jLabel1.setText("Tabel Master");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 80, 20));

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel1.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, -1, -1));

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 640, 223));

        jPanel2.setBackground(new java.awt.Color(0, 255, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 75, 60, -1));

        jLabel3.setText("User ID");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 78, -1, -1));

        jLabel4.setText("Username");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 116, -1, -1));

        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        jPanel2.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 113, 92, -1));

        jLabel2.setText("Form Master");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jLabel5.setText("Password");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 154, -1, -1));
        jPanel2.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 151, 92, -1));

        jLabel6.setText("Status");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 192, -1, -1));

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin" }));
        cmbStatus.setSelectedIndex(-1);
        jPanel2.add(cmbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 189, 92, -1));

        jLabel7.setText("Nama Lengkap");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 230, -1, -1));
        jPanel2.add(txtNamaLengkap, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 227, 164, -1));

        jLabel8.setText("No. Telp");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 268, -1, -1));
        jPanel2.add(txtNotelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 265, 92, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 257, 600, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:

        if (txtId.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "ID harus diisi !");
        } else if (txtUser.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "User harus diisi !");
        } else if (txtPass.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Password harus diisi !");
        } else if (cmbStatus.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Status tidak boleh kosong !");
        } else if (txtNamaLengkap.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama harus diisi !");
        } else if (txtNotelp.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No. Telp harus diisi !");
        } else {
            buka_koneksi();
            String sqlkode = "INSERT INTO petugas (id_petugas, username, password, nama_petugas, status, no_telp) "
                    + "VALUES ('"
                    + this.txtId.getText() + "','"
                    + this.txtUser.getText() + "','"
                    + this.txtPass.getText() + "','"
                    + this.cmbStatus.getSelectedItem() + "','"
                    + this.txtNamaLengkap.getText() + "','"
                    + this.txtNotelp.getText() + "')";
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

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:

        int ok = JOptionPane.showConfirmDialog(null, "Apakah Yakin Mendelete record ini???", "Confirmation",
                JOptionPane.YES_NO_CANCEL_OPTION);

        if (ok == 0) {
            try {
                String sql = "DELETE FROM petugas where id_petugas='"
                        + txtId.getText() + "'";
                PreparedStatement st = koneksi.prepareStatement(sql);
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Delete Data Sukses");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Delete Data Gagal");
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        ambil_data_tabel();
        txtId.setText("");
        txtUser.setText("");
        txtPass.setText("");
        cmbStatus.setSelectedItem("");
        txtNamaLengkap.setText("");
        txtNotelp.setText("");
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void BtnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKembaliActionPerformed
        // TODO add your handling code here:
        FormHomeAdmin fha = new FormHomeAdmin(m);
        fha.setVisible(true);
        this.setVisible(false);                
    }//GEN-LAST:event_BtnKembaliActionPerformed

    private void jTable_MasterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_MasterMouseClicked
        // TODO add your handling code here:
        int i = jTable_Master.getSelectedRow();
        txtId.setText("" + model.getValueAt(i, 0));
        txtUser.setText("" + model.getValueAt(i, 1));
        txtPass.setText("" + model.getValueAt(i, 2));
        txtNamaLengkap.setText("" + model.getValueAt(i, 3));
        cmbStatus.setSelectedItem("" + model.getValueAt(i, 4));        
        txtNotelp.setText("" + model.getValueAt(i, 5));

    }//GEN-LAST:event_jTable_MasterMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
//        dataLoad();
        buka_koneksi();
        String sql = "UPDATE petugas SET id_petugas = '" + txtId.getText() + "',"
                + "username = '" + txtUser.getText() + "',"
                + "password = '" + txtPass.getText() + "',"
                + "status = '" + cmbStatus.getSelectedItem() + "',"
                + "nama_petugas = '" + txtNamaLengkap.getText() + "',"
                + "no_telp = '" + txtNotelp.getText() + "'"
                + "WHERE id_petugas = '" + txtId.getText() + "'";
        try {
            PreparedStatement st = koneksi.prepareStatement(sql);
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "Update Data Sukses");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ambil_data_tabel();
    }//GEN-LAST:event_btnEditActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

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
            java.util.logging.Logger.getLogger(FormMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMaster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnKembali;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Master;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNamaLengkap;
    private javax.swing.JTextField txtNotelp;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}

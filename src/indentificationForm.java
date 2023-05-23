
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.io.FileFilter;

import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;



public final class indentificationForm extends javax.swing.JFrame {

    public indentificationForm() {
        initComponents();
        Connect();
        LoadIdNo();
        Fetch();
    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/ronaldo_paul", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(indentificationForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(indentificationForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void LoadIdNo() {
        try {
            pst = con.prepareStatement("SELECT id FROM indentification");
            rs = pst.executeQuery();
            txtStd_No.removeAllItems();
            while (rs.next()) {
                txtStd_No.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(indentificationForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Fetch() {
         try {
        int q;
        pst = con.prepareStatement("SELECT * FROM indentification");
        rs = pst.executeQuery();
        ResultSetMetaData rss = rs.getMetaData();
        q = rss.getColumnCount();

        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
        df.setRowCount(0);
        while (rs.next()) {
            Vector<String> v2 = new Vector<>(); // Specify the generic type parameter as String
            for (int a = 1; a <= q; a++) {
                v2.add(rs.getString("name"));
                v2.add(rs.getString("contact"));
                v2.add(rs.getString("section"));
                v2.add(rs.getString("address"));
                v2.add(rs.getString("email"));
            }
            df.addRow(v2);
        }
    } catch (SQLException ex) {
        Logger.getLogger(indentificationForm.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPDF = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtContact = new javax.swing.JTextField();
        txtSection = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtStd_No = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btnExport = new javax.swing.JButton();

        btnPDF.setText("Export to PDF");
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Name:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Contact:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Section:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Address:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Email:");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtStd_No.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtStd_No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStd_NoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Student No:");

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnNew.setText("Export to PDF");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNew)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnNew)
                    .addComponent(btnAdd))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "Contact", "Section", "Address", "Email"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Student Information Database");

        btnExport.setText("Export to CSV");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtStd_No, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSection)
                                    .addComponent(txtContact)
                                    .addComponent(txtAddress)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSearch)
                                .addGap(57, 57, 57))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExport))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel7)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel7)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStd_No, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnExport))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(txtName.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Name is required!");
        }else if(txtContact.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Contact number is required!");
        }else if(txtSection.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Section is required!!");
        }else if(txtAddress.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Address is required!");
        }else if(txtEmail.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Email is required!!");
        }else{
        try {
            // TODO add your handling code here:
            String name = txtName.getText();
            String contact = txtContact.getText();
            String section = txtSection.getText();
            String address = txtAddress.getText();
            String email = txtEmail.getText();

            pst = con.prepareStatement("INSERT INTO indentification (name,contact,section,address,email)VALUES(?,?,?,?,?)");
            pst.setString(1, name);
            pst.setString(2, contact);
            pst.setString(3, section);
            pst.setString(4, address);
            pst.setString(5, email);

            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Record Added!! succesfully");
                txtName.setText("");
                txtContact.setText("");
                txtSection.setText("");
                txtAddress.setText("");
                txtEmail.setText("");
                Fetch();
                LoadIdNo();
            } else {
                JOptionPane.showMessageDialog(this, "Record failed to save!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(indentificationForm.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            String id = txtStd_No.getSelectedItem().toString();

            pst = con.prepareStatement("SELECT * FROM indentification WHERE id=?");
            pst.setString(1, id);
            rs = pst.executeQuery();

            if (rs.next() == true) {
                txtName.setText(rs.getString(2));
                txtContact.setText(rs.getString(3));
                txtSection.setText(rs.getString(4));
                txtAddress.setText(rs.getString(5));
                txtEmail.setText(rs.getString(6));
            } else {
                JOptionPane.showMessageDialog(this, "Record not found!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(indentificationForm.class.getName()).log(Level.SEVERE, null, ex);
            // TODO add your handling code here:
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if(txtName.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Name is required!");
        }else if(txtContact.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Contact number is required!");
        }else if(txtSection.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Section is required!!");
        }else if(txtAddress.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Address is required!");
        }else if(txtEmail.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Email is required!!");
        }else{
        try {
            // TODO add your handling code here:
            String name = txtName.getText();
            String contact = txtContact.getText();
            String section = txtSection.getText();
            String address = txtAddress.getText();
            String email = txtEmail.getText();
            String id = txtStd_No.getSelectedItem().toString();
            pst = con.prepareStatement("UPDATE indentification SET name=?,contact=?,section=?,address=?,email=? WHERE id=?");

            pst.setString(1, name);
            pst.setString(2, contact);
            pst.setString(3, section);
            pst.setString(4, address);
            pst.setString(5, email);
            pst.setString(6, id);

            int k = pst.executeUpdate();
            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Record has been successfully updated!!");
                txtName.setText("");
                txtContact.setText("");
                txtSection.setText("");
                txtAddress.setText("");
                txtEmail.setText("");
                txtName.requestFocus();
                Fetch();
                LoadIdNo();
            }
        } catch (SQLException ex) {
            Logger.getLogger(indentificationForm.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       
        try {
            // TODO add your handling code here:
            String id = txtStd_No.getSelectedItem().toString();
            pst = con.prepareStatement("DELETE FROM indentification WHERE id=?");
            pst.setString(1, id);

            int k = pst.executeUpdate();
            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Record has been successfully deleted!!");
                txtName.setText("");
                txtContact.setText("");
                txtSection.setText("");
                txtAddress.setText("");
                txtEmail.setText("");
                txtName.requestFocus();
                Fetch();
                LoadIdNo();
            } else {
                JOptionPane.showMessageDialog(this, "Record failed to delete!!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(indentificationForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        // TODO add your handling code here:

        String filename;
        filename = "C:\\Users\\Gen\\ExportedFileJava.csv";

       
        try {
            try (FileWriter fw = new FileWriter(filename)) {
                pst = con.prepareStatement("SELECT * FROM indentification");
                rs = pst.executeQuery();
                
                while(rs.next()) {
                    fw.append(rs.getString(1));
                    fw.append(',');
                    fw.append(rs.getString(2));
                    fw.append(',');
                    fw.append(rs.getString(3));
                    fw.append(',');
                    fw.append(rs.getString(4));
                    fw.append(',');
                    fw.append(rs.getString(5));
                    fw.append(',');
                    fw.append(rs.getString(6));
                    fw.append('\n');
                }
                JOptionPane.showMessageDialog(this, "Exported successfully!!");
                fw.flush();
                fw.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(indentificationForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(indentificationForm.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
      
    }//GEN-LAST:event_btnPDFActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        try {
        pst = con.prepareStatement("SELECT * FROM indentification");
        rs = pst.executeQuery();

        Document PDFreport = new Document();
        PdfWriter.getInstance(PDFreport, new FileOutputStream("C:\\Users\\Gen\\ExportedFile.pdf"));

        PDFreport.open();

        PdfPTable PDFTable = new PdfPTable(4); // Use PdfPTable instead of PdfTable
        PdfPCell table_cell;

        while (rs.next()) {
            String pid = rs.getString("id");
            table_cell = new PdfPCell(new Phrase(pid));
            PDFTable.addCell(table_cell);

            String sname = rs.getString("name");
            table_cell = new PdfPCell(new Phrase(sname));
            PDFTable.addCell(table_cell);

            String scont = rs.getString("contact");
            table_cell = new PdfPCell(new Phrase(scont));
            PDFTable.addCell(table_cell);

            String sec = rs.getString("section");
            table_cell = new PdfPCell(new Phrase(sec));
            PDFTable.addCell(table_cell);
        }
        JOptionPane.showMessageDialog(this, "PDF FILE is Exported successfully!!");

        PDFreport.add(PDFTable);
        PDFreport.close();

    } catch (IOException ex) {
        Logger.getLogger(indentificationForm.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(indentificationForm.class.getName()).log(Level.SEVERE, null, ex);
    }   catch (DocumentException ex) {
            Logger.getLogger(indentificationForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNewActionPerformed

    private void txtStd_NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStd_NoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStd_NoActionPerformed

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
            java.util.logging.Logger.getLogger(indentificationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(indentificationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(indentificationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(indentificationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSection;
    private javax.swing.JComboBox<String> txtStd_No;
    // End of variables declaration//GEN-END:variables

    private void LoadStudentNo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

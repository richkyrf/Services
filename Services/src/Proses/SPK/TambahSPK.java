/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proses.SPK;

import F.FLaporan;
import F.RunMultiUpd;
import F.RunSelct;
import F.RunSelct2;
import F.RunSelctOne;
import F.RunUpd;
import Proses.PS.Cek;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JACK
 */
public class TambahSPK extends javax.swing.JFrame {

    /**
     * Creates new form Serivice
     */
    public TambahSPK() {
        initComponents();
        setTitle("Tambah Perintah Kerja");
        setLocationRelativeTo(null);
        GetJcomPlat(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JTNoPerintahKerja.setText(F.GenNoPermintaan.GetNoPerintahKerja(JcPerbaikan.getSelectedIndex()));
        if (JTNoPermintaan.getSelectedItem() != null) {
            getdata(JTNoPermintaan.getSelectedItem().toString());
        }
        setVisible(true);
    }
    String QJcP1 = "SELECT `VarPar` FROM `tbseting` WHERE `KSet`=2 order by `NoCol`";
    String QJcP2 = "SELECT `VarPar` FROM `tbseting` WHERE `KSet`=3 order by `NoCol`";
    String QJcP3 = "SELECT `VarPar` FROM `tbseting` WHERE `KSet`=4 order by `NoCol`";

    private void GetJcomPlat(String Cari) {
        if (Cari == null) {
            JcPlat.setQuery("SELECT `NoPolisi` FROM `ttruck`");
            JcPlat.excute();
        } else {
            JcPlat.setQuery("SELECT `NoPolisi` FROM `ttruck` where `NoPolisi` like '%" + Cari + "%'");
            JcPlat.excute();
        }

    }

    void getSelectedData() {
        if (JTable.getSelectedRow() != -1) {
            int row = JTable.getSelectedRow();
            JCjenis.setSelectedItem(JTable.getValueAt(row, 1));
            JTKet.setText(JTable.getValueAt(row, 2).toString());
            JTBiaya.setInt(Integer.parseInt(JTable.getValueAt(row, 3).toString()));
        }
    }

    /**
     *
     * @param table
     * @return
     */
    public Object[][] getTableData(JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
        Object[][] tableData = new Object[nRow][nCol];
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                tableData[i][j] = dtm.getValueAt(i, j);
            }
        }
        return tableData;
    }

    void RefreshTbl() {
        JTable.clearSelection();
        JCjenis.setSelectedIndex(0);
        JTKet.setText("");
        JTBiaya.setInt(0);
        JtCariPermintaan.setText("");
    }

    private void getdata(String NoPermintaan) {
        String Plat = "";
        RunSelct2 runSelct2 = new F.RunSelct2();
        runSelct2.setQuery("SELECT `No`, `NoPermintaan`, `Tgl`, `Plat`, `Sopir`, `JPermintaan`, `JPekerjaan`, `TingkatPekerjaan`, `KMT`, `User`,`CatKhusus` FROM `tbpermintaan` WHERE `NoPermintaan` ='" + NoPermintaan + "'");
        try {
            ResultSet rs = runSelct2.excute();
            if (!rs.isBeforeFirst()) {
                JcPlat.setSelectedItem("");
                JtSopir.setText("");
                JcPemintaan.setSelectedIndex(0);
                JcPerbaikan.setSelectedIndex(0);
                JcPrioritas.setSelectedIndex(0);
                JTKMMobil.setInt(0);
                JTCatatanKhusus.setText("");
            }
            while (rs.next()) {
                JtSopir.setText(rs.getString("Sopir"));
                JcPemintaan.setSelectedIndex(rs.getInt("JPermintaan"));
                JcPerbaikan.setSelectedIndex(rs.getInt("JPekerjaan"));
                JcPrioritas.setSelectedIndex(rs.getInt("TingkatPekerjaan"));
                JTKMMobil.setInt(rs.getInt("KMT"));
                JTCatatanKhusus.setText(rs.getString("CatKhusus"));
                JcPlat.setSelectedItem(rs.getString("Plat"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "gagal Menampilkan Data");
            e.printStackTrace();
        } finally {
            runSelct2.closecon();
        }
        JTable.setQuery("SELECT `NoCol` as 'No', `JenisPermintaan` as 'Jenis Permintaan', `Keterangan` as 'Keterangan', `Ongkos` as 'Ongkos Servis' FROM `tbdetailpermintaan` WHERE `NoPermintaan` = '" + NoPermintaan + "' order by `No` Asc");
        JTable.tampilkan();
    }

    void setKMfromPlat(Object Plat) {
        RunSelct runSelct = new F.RunSelct();
        try {
            runSelct.setQuery("SELECT `KMO`FROM `ttruck` WHERE `NoPolisi`='" + Plat + "' limit 1");
            ResultSet rs = runSelct.excute();
            if (!rs.isBeforeFirst()) {
                JcKMO.setText("");
            }
            while (rs.next()) {
                JcKMO.setText(rs.getString("KMO"));
            }
        } catch (SQLException e) {
        } finally {
            runSelct.closecon();
        }
    }

    void setenabdisabtextkm() {
        if (!"".equals(JcPlat.getSelectedItem().toString())) {
            RunSelctOne runSelctOne = new F.RunSelctOne();
            runSelctOne.setQuery("SELECT `Stat` FROM `ttruck` WHERE `NoPolisi`= '" + JcPlat.getSelectedItem() + "'");
            String x = runSelctOne.excute();
            if (x.equals("1")) {
                JTKMMobil.setEnabled(false);
            } else {
                JTKMMobil.setEnabled(true);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents()
     {
          bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

          jLabel2 = new javax.swing.JLabel();
          jLabel3 = new javax.swing.JLabel();
          jLabel4 = new javax.swing.JLabel();
          JdTGL = new com.toedter.calendar.JDateChooser();
          jLabel12 = new javax.swing.JLabel();
          jLabel13 = new javax.swing.JLabel();
          jLabel14 = new javax.swing.JLabel();
          jLabel16 = new javax.swing.JLabel();
          jButton1 = new javax.swing.JButton();
          jLabel17 = new javax.swing.JLabel();
          jLabel18 = new javax.swing.JLabel();
          jLabel21 = new javax.swing.JLabel();
          jLabel22 = new javax.swing.JLabel();
          jLabel23 = new javax.swing.JLabel();
          jLabel24 = new javax.swing.JLabel();
          jButton2 = new javax.swing.JButton();
          jButton3 = new javax.swing.JButton();
          JcPlat = new F.JcomFromDb();
          JCjenis = new F.JcomFromDb();
          JTCari = new F.JackTextField();
          jLabel5 = new javax.swing.JLabel();
          JcKMO = new F.JNumberTextField();
          JcPemintaan = new F.JcomFromDb();
          JcPerbaikan = new F.JcomFromDb();
          JcPrioritas = new F.JcomFromDb();
          BtnUbah = new javax.swing.JButton();
          jButton5 = new javax.swing.JButton();
          jLabel6 = new javax.swing.JLabel();
          JTNoPermintaan = new F.JcomFromDb();
          JTNoPerintahKerja = new F.JackTextField();
          jLabel1 = new javax.swing.JLabel();
          jScrollPane2 = new javax.swing.JScrollPane();
          JTable = new F.Jktable();
          JTBiaya = new F.RibuanTextField();
          JTKMMobil = new F.RibuanTextField();
          jtUser = new F.JackTextField();
          JtCariPermintaan = new F.JackTextField();
          JtSopir = new F.JackTextField();
          JTKet = new F.JackTextField();
          JTTime = new javax.swing.JFormattedTextField();
          jLabel25 = new javax.swing.JLabel();
          JTCatatanKhusus = new F.JackTextField();
          jButton4 = new javax.swing.JButton();
          jButton6 = new javax.swing.JButton();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          addWindowListener(new java.awt.event.WindowAdapter()
          {
               public void windowClosing(java.awt.event.WindowEvent evt)
               {
                    formWindowClosing(evt);
               }
          });

          jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
          jLabel2.setText("Plat");

          jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
          jLabel3.setText("Waktu & Tanggal");

          jLabel4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
          jLabel4.setText("No Permintaan");

          JdTGL.setDate(new Date());
          JdTGL.setDateFormatString("dd-MM-yyyy");
          JdTGL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

          jLabel12.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
          jLabel12.setText("Keterangan");
          jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

          jLabel13.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
          jLabel13.setText("Jenis Pekerjaan");
          jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

          jLabel14.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
          jLabel14.setText("Ongkos Service");
          jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

          jLabel16.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
          jLabel16.setText("KM Ganti Oli");

          jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          jButton1.setText("SIMPAN");
          jButton1.setName(""); // NOI18N
          jButton1.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    jButton1ActionPerformed(evt);
               }
          });

          jLabel17.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
          jLabel17.setText("USER :");

          jLabel18.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

          jLabel21.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
          jLabel21.setText("Sopir");

          jLabel22.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
          jLabel22.setText("Jenis Permintaan");

          jLabel23.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
          jLabel23.setText("Jenis Perbaikan");

          jLabel24.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
          jLabel24.setText("Prioritas Perbaikan");

          jButton2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
          jButton2.setText("Tambah");
          jButton2.setFocusable(false);

          org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, JTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement == null}"), jButton2, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
          bindingGroup.addBinding(binding);

          jButton2.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    jButton2ActionPerformed(evt);
               }
          });

          jButton3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
          jButton3.setText("Hapus");
          jButton3.setFocusable(false);

          binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, JTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jButton3, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
          bindingGroup.addBinding(binding);

          jButton3.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    jButton3ActionPerformed(evt);
               }
          });

          JcPlat.setQuery("SELECT `NoPolisi`FROM `ttruck`");
          JcPlat.excute();
          JcPlat.setEnabled(false);
          JcPlat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          JcPlat.addItemListener(new java.awt.event.ItemListener()
          {
               public void itemStateChanged(java.awt.event.ItemEvent evt)
               {
                    JcPlatItemStateChanged(evt);
               }
          });
          JcPlat.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    JcPlatActionPerformed(evt);
               }
          });

          JCjenis.setQuery("SELECT `Jenis Service` FROM `tjenisservice` order by `No` asc");
          JCjenis.excute();
          JCjenis.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          JCjenis.addKeyListener(new java.awt.event.KeyAdapter()
          {
               public void keyReleased(java.awt.event.KeyEvent evt)
               {
                    JCjenisKeyReleased(evt);
               }
          });

          JTCari.setmaxtText(50);
          JTCari.setDisabledTextColor(new java.awt.Color(0, 0, 102));
          JTCari.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          JTCari.addKeyListener(new java.awt.event.KeyAdapter()
          {
               public void keyReleased(java.awt.event.KeyEvent evt)
               {
                    JTCariKeyReleased(evt);
               }
          });

          jLabel5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
          jLabel5.setText("KM Mobil");

          JcKMO.setDisabledTextColor(new java.awt.Color(0, 0, 102));
          JcKMO.setEnabled(false);
          JcKMO.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

          JcPemintaan.setQuery(QJcP1);
          JcPemintaan.setaawalkosong(false);
          JcPemintaan.excute();
          JcPemintaan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

          JcPerbaikan.setQuery(QJcP2);
          JcPerbaikan.setaawalkosong(false);
          JcPerbaikan.excute();
          JcPerbaikan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

          JcPrioritas.setQuery(QJcP3);
          JcPrioritas.setaawalkosong(false);
          JcPrioritas.excute();
          JcPrioritas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

          BtnUbah.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
          BtnUbah.setText("Ubah");
          BtnUbah.setFocusable(false);

          binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, JTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), BtnUbah, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
          bindingGroup.addBinding(binding);

          BtnUbah.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    BtnUbahActionPerformed(evt);
               }
          });

          jButton5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
          jButton5.setText("Refresh");
          jButton5.setFocusable(false);
          jButton5.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    jButton5ActionPerformed(evt);
               }
          });

          jLabel6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
          jLabel6.setText("No SPK");

          JTNoPermintaan.setQuery("SELECT a.`NoPermintaan` FROM `tbpermintaan` a left join `tbperintahkerja` b on a.`NoPermintaan`=b.`NoPermintaan` WHERE b.`NoPermintaan` is null");
          JTNoPermintaan.excute();
          JTNoPermintaan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
          JTNoPermintaan.addItemListener(new java.awt.event.ItemListener()
          {
               public void itemStateChanged(java.awt.event.ItemEvent evt)
               {
                    JTNoPermintaanItemStateChanged(evt);
               }
          });
          JTNoPermintaan.addActionListener(new java.awt.event.ActionListener()
          {
               public void actionPerformed(java.awt.event.ActionEvent evt)
               {
                    JTNoPermintaanActionPerformed(evt);
               }
          });

          JTNoPerintahKerja.setDisabledTextColor(new java.awt.Color(0, 0, 102));
          JTNoPerintahKerja.setEnabled(false);
          JTNoPerintahKerja.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

          jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
          jLabel1.setText("Cari");

          JTable.setModel(new javax.swing.table.DefaultTableModel(
               new Object [][]
               {

               },
               new String []
               {
                    "No", "Jenis Service", "Keterangan", "Ongkos Service"
               }
          )
          {
               boolean[] canEdit = new boolean []
               {
                    false, false, false, false
               };

               public boolean isCellEditable(int rowIndex, int columnIndex)
               {
                    return canEdit [columnIndex];
               }
          });
          JTable.getSelectionModel().addListSelectionListener(new
               ListSelectionListener()
               {
                    public void valueChanged(ListSelectionEvent e)
                    {
                         getSelectedData();
                    }
               });
               JTable.addKeyListener(new java.awt.event.KeyAdapter()
               {
                    public void keyReleased(java.awt.event.KeyEvent evt)
                    {
                         JTableKeyReleased(evt);
                    }
               });
               jScrollPane2.setViewportView(JTable);
               JTable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "startEditing");
               if (JTable.getColumnModel().getColumnCount() > 0)
               {
                    JTable.getColumnModel().getColumn(3).setResizable(false);
               }
               JTable.setrender(3,"Number");

               JTBiaya.setmaxnum(1000000000);
               JTBiaya.setDisabledTextColor(new java.awt.Color(0, 0, 102));
               JTBiaya.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
               JTBiaya.addKeyListener(new java.awt.event.KeyAdapter()
               {
                    public void keyReleased(java.awt.event.KeyEvent evt)
                    {
                         JTBiayaKeyReleased(evt);
                    }
               });

               JTKMMobil.setText("0");
               JTKMMobil.setDisabledTextColor(new java.awt.Color(0, 0, 102));
               JTKMMobil.setEnabled(false);
               JTKMMobil.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

               jtUser.setText(F.Variablebanking.SUsername);
               jtUser.setEnabled(false);
               jtUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

               JtCariPermintaan.setmaxtText(50);
               JtCariPermintaan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
               JtCariPermintaan.addKeyListener(new java.awt.event.KeyAdapter()
               {
                    public void keyReleased(java.awt.event.KeyEvent evt)
                    {
                         JtCariPermintaanKeyReleased(evt);
                    }
               });

               JtSopir.setmaxtText(50);
               JtSopir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

               JTKet.setmaxtText(100);
               JTKet.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
               JTKet.addKeyListener(new java.awt.event.KeyAdapter()
               {
                    public void keyReleased(java.awt.event.KeyEvent evt)
                    {
                         JTKetKeyReleased(evt);
                    }
               });

               JTTime.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("HH:mm"))));
               JTTime.setText(F.Datetostringwidthformat.getstringfromdate(new Date(),"HH:mm"));
               JTTime.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

               jLabel25.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
               jLabel25.setText("Catatatan Khsusus :");

               JTCatatanKhusus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

               jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
               jButton4.setText("SIMPAN DAN BARU");
               jButton4.addActionListener(new java.awt.event.ActionListener()
               {
                    public void actionPerformed(java.awt.event.ActionEvent evt)
                    {
                         jButton4ActionPerformed(evt);
                    }
               });

               jButton6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
               jButton6.setText("CETAK");
               jButton6.addActionListener(new java.awt.event.ActionListener()
               {
                    public void actionPerformed(java.awt.event.ActionEvent evt)
                    {
                         jButton6ActionPerformed(evt);
                    }
               });

               javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
               getContentPane().setLayout(layout);
               layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                         .addGap(200, 200, 200)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                              .addComponent(JTCatatanKhusus, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addGroup(layout.createSequentialGroup()
                                   .addComponent(jButton6)
                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                   .addComponent(jButton4)
                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                   .addComponent(jButton1)))
                         .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(layout.createSequentialGroup()
                                   .addGap(10, 10, 10)
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                             .addComponent(jLabel17)
                                             .addGap(4, 4, 4)
                                             .addComponent(jtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING)))
                              .addGroup(layout.createSequentialGroup()
                                   .addGap(985, 985, 985)
                                   .addComponent(jLabel18))
                              .addGroup(layout.createSequentialGroup()
                                   .addContainerGap()
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                             .addComponent(JTCari, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                             .addComponent(JCjenis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                             .addComponent(JTKet, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                             .addComponent(JTBiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                             .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                             .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                         .addGap(0, 21, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                         .addContainerGap()
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(layout.createSequentialGroup()
                                   .addComponent(jScrollPane2)
                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BtnUbah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton5)))
                              .addGroup(layout.createSequentialGroup()
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                             .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                             .addGap(4, 4, 4)
                                             .addComponent(JcPemintaan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                             .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                             .addGap(4, 4, 4)
                                             .addComponent(JcPerbaikan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                             .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                             .addGap(4, 4, 4)
                                             .addComponent(JcPrioritas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                  .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                  .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                  .addGroup(layout.createSequentialGroup()
                                                       .addGap(4, 4, 4)
                                                       .addComponent(JtSopir, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                  .addGroup(layout.createSequentialGroup()
                                                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                       .addComponent(JcPlat, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                  .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                  .addComponent(jLabel3))
                                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                  .addGroup(layout.createSequentialGroup()
                                                       .addComponent(jLabel1)
                                                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                       .addComponent(JtCariPermintaan, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                       .addComponent(JTNoPermintaan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                  .addGroup(layout.createSequentialGroup()
                                                       .addComponent(JdTGL, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                       .addGap(6, 6, 6)
                                                       .addComponent(JTTime, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(jLabel6)
                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                   .addComponent(JTNoPerintahKerja, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGroup(layout.createSequentialGroup()
                                   .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addGap(4, 4, 4)
                                   .addComponent(JcKMO, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                   .addComponent(jLabel5)
                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                   .addComponent(JTKMMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addGap(0, 0, Short.MAX_VALUE)))
                         .addContainerGap())
               );
               layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                         .addGap(11, 11, 11)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel6)
                                   .addComponent(JTNoPerintahKerja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGroup(layout.createSequentialGroup()
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel1)
                                        .addComponent(JtCariPermintaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JTNoPermintaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addGap(6, 6, 6)
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3)
                                        .addComponent(JTTime)
                                        .addComponent(JdTGL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                   .addGap(8, 8, 8)
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(JcPlat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addGap(10, 10, 10)
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                             .addGap(2, 2, 2)
                                             .addComponent(jLabel21))
                                        .addComponent(JtSopir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addGap(6, 6, 6)
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                             .addGap(2, 2, 2)
                                             .addComponent(jLabel22))
                                        .addComponent(JcPemintaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addGap(6, 6, 6)
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                             .addGap(2, 2, 2)
                                             .addComponent(jLabel23))
                                        .addComponent(JcPerbaikan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addGap(6, 6, 6)
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                             .addGap(2, 2, 2)
                                             .addComponent(jLabel24))
                                        .addComponent(JcPrioritas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addGap(8, 8, 8)
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel16)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                             .addComponent(JcKMO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                             .addComponent(jLabel5)
                                             .addComponent(JTKMMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addComponent(jLabel13)
                              .addComponent(jLabel12)
                              .addComponent(jLabel14))
                         .addGap(6, 6, 6)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addComponent(JTCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(JTKet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(JCjenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addComponent(JTBiaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addComponent(jLabel18)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(layout.createSequentialGroup()
                                   .addGap(6, 6, 6)
                                   .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                              .addGroup(layout.createSequentialGroup()
                                   .addGap(29, 29, 29)
                                   .addComponent(jButton2)
                                   .addGap(6, 6, 6)
                                   .addComponent(BtnUbah)
                                   .addGap(6, 6, 6)
                                   .addComponent(jButton3)
                                   .addGap(6, 6, 6)
                                   .addComponent(jButton5)
                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)))
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(layout.createSequentialGroup()
                                   .addGap(2, 2, 2)
                                   .addComponent(jLabel25))
                              .addComponent(JTCatatanKhusus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(layout.createSequentialGroup()
                                   .addGap(16, 16, 16)
                                   .addComponent(jLabel17))
                              .addGroup(layout.createSequentialGroup()
                                   .addGap(12, 12, 12)
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                             .addComponent(jButton1)
                                             .addComponent(jButton4)
                                             .addComponent(jButton6))
                                        .addComponent(jtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                         .addGap(11, 11, 11))
               );

               bindingGroup.bind();

               pack();
          }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        JTNoPerintahKerja.setText(F.GenNoPermintaan.GetNoPerintahKerja(JcPerbaikan.getSelectedIndex()));
        if (JTable.getRowCount() != 0) {

            int km = 0;
            if (JTKMMobil.isEnabled()) {
                km = JTKMMobil.getInt();
            } else if (JcKMO.isEnabled()) {
                km = JTKMMobil.getInt();
            }
            List<String> list = new ArrayList<>();
            list.add("INSERT INTO `tbperintahkerja`(`NoPerintahKerja`,`NoPermintaan`, `Tgl`, `Plat`, `Sopir`, `JPermintaan`, `JPekerjaan`, `TingkatPekerjaan`, `KMT`, `User`,`CatKhusus`) VALUES ("
                    + "'" + JTNoPerintahKerja.getText() + "','" + JTNoPermintaan.getSelectedItem().toString() + "','" + F.Datetostringwidthformat.getstringfromdate(JdTGL.getDate(), "yyyy-MM-dd") + " " + JTTime.getText()
                    + "','" + JcPlat.getSelectedItem() + "','" + JtSopir.getText() + "'," + JcPemintaan.getSelectedIndex()
                    + "," + JcPerbaikan.getSelectedIndex() + "," + JcPrioritas.getSelectedIndex()
                    + "," + km + ",'" + jtUser.getText() + "','" + JTCatatanKhusus.getText() + "')");
            Object[][] b = getTableData(JTable);
            for (int i = 0; i < b.length; i++) {
                String bb = "";
                for (int j = 0; j < b[i].length + 1; j++) {
                    if (j == b[i].length) {
                        bb += "'" + JTNoPerintahKerja.getText() + "'";
                    } else if ((j == b[i].length - 4) || (j == b[i].length - 1)) {
                        bb += "" + b[i][j] + ",";
                    } else {
                        bb += "'" + b[i][j] + "',";
                    }
                }
                list.add("INSERT INTO `tbdetailperintahkerja`(`NoCol`, `JenisPermintaan`, `Keterangan`, `Ongkos`,`NoPerintahKerja`) VALUES (" + bb + ")");
            }
            /*
             for (int i = 0; i < b.length; i++) {
             if (b[i][1].equals("GANTI OLI MESIN")) {
             list.add("UPDATE `ttruck` SET `KMO`='" + 0 + "' WHERE `NoPolisi` = '" + JcPlat.getSelectedItem() + "'");
             }
             }
             */
            RunMultiUpd runMultiUpd = new F.RunMultiUpd();
            runMultiUpd.setQuery(list);
            runMultiUpd.seterorm("Gagal Tambah Data !");
            int no = runMultiUpd.excute();
            if (no != 0) {
                JOptionPane.showMessageDialog(this, "Berhasil Tambah Data");
                F.History.STambah("Tambah Data SPK " + JTNoPerintahKerja.getText());
                F.VarJFrame.menuPerintahKerja.refresh();
                F.VarJFrame.tambahPerintahKerja.dispose();
                F.VarJFrame.tambahPerintahKerja = null;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Permintaan Kerja Tidak Boleh Kosong !");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (JCjenis.getSelectedItem().equals("GANTI OLI MESIN") && (Cek.JmlahKMO(JcPlat.getSelectedItem().toString()) < F.Variablebanking.MinGantiOli) && (Cek.JmlahKMO(JcPlat.getSelectedItem().toString()) != -1)) {
            JOptionPane.showMessageDialog(this, "Tidak Bisa Ganti Oli karena Kilometer Ganti Oli Belum Cukup");
        } else if (JCjenis.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Jenis Service Harus Di Pilih");
        } else {
            DefaultTableModel model = (DefaultTableModel) JTable.getModel();
            model.addRow(new Object[]{JTable.getRowCount() + 1, JCjenis.getSelectedItem(), JTKet.getText(), JTBiaya.getInt()});
            JOptionPane.showMessageDialog(this, "Berhasil Tambah Data");
            RefreshTbl();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (JTable.getSelectedRow() != -1) {
            ((DefaultTableModel) JTable.getModel()).removeRow(JTable.getSelectedRow());
            for (int a = 0; a < JTable.getRowCount(); a++) {
                JTable.setValueAt(a + 1, a, 0);
            }
            JOptionPane.showMessageDialog(this, "Berhasil Hapus Data");
            RefreshTbl();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void JTCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTCariKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            JCjenis.requestFocus();
            JCjenis.setSelectedIndex(0);
        } else if (evt.getKeyCode() == KeyEvent.VK_F5) {
            if (JTable.getSelectedRow() != -1) {
                JTable.clearSelection();
                JCjenis.setSelectedIndex(0);
                JTKet.setText("");
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER && JCjenis.getSelectedIndex() != -1) {
            JCjenis.hidePopup();
            JTKet.requestFocus();
        } else {
            JCjenis.setQuery("SELECT `Jenis Service`  FROM `tjenisservice` where `Jenis Service` like '%" + JTCari.getText() + "%'order by `No` asc");
            JCjenis.setaawalkosong(false);
            JCjenis.excute();
            JCjenis.showPopup();
        }
    }//GEN-LAST:event_JTCariKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        F.VarJFrame.tambahPerintahKerja = null;
        if (F.VarJFrame.menuPerintahKerja != null) {
            F.VarJFrame.menuPerintahKerja.refresh();
        }
    }//GEN-LAST:event_formWindowClosing

    private void BtnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUbahActionPerformed
        if (JCjenis.getSelectedItem().equals("GANTI OLI MESIN") && (Cek.JmlahKMO(JcPlat.getSelectedItem().toString()) < F.Variablebanking.MinGantiOli) && (Cek.JmlahKMO(JcPlat.getSelectedItem().toString()) != -1)) {
            JOptionPane.showMessageDialog(this, "Tidak Bisa Ganti Oli karena Kilometer Ganti Oli Belum Cukup");
        } else if (JCjenis.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Jenis Service Harus Di Pilih");
        } else if (JTable.getSelectedRow() != -1) {
            JTable.setValueAt(JCjenis.getSelectedItem(), JTable.getSelectedRow(), 1);
            JTable.setValueAt(JTKet.getText(), JTable.getSelectedRow(), 2);
            JTable.setValueAt(JTBiaya.getInt(), JTable.getSelectedRow(), 3);
            JOptionPane.showMessageDialog(this, "Berhasil Ubah Data");
            RefreshTbl();
        }
    }//GEN-LAST:event_BtnUbahActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JTable.clearSelection();
        JCjenis.setSelectedIndex(0);
        JTKet.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void JTNoPermintaanItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_JTNoPermintaanItemStateChanged
    {//GEN-HEADEREND:event_JTNoPermintaanItemStateChanged
        getdata(JTNoPermintaan.getSelectedItem().toString());
        JTNoPerintahKerja.setText(F.GenNoPermintaan.GetNoPerintahKerja(JcPerbaikan.getSelectedIndex()));
    }//GEN-LAST:event_JTNoPermintaanItemStateChanged

    private void JtCariPermintaanKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_JtCariPermintaanKeyReleased
    {//GEN-HEADEREND:event_JtCariPermintaanKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            JTNoPermintaan.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER && JcPlat.getSelectedIndex() != -1) {
            JTNoPermintaan.hidePopup();
            getdata(JTNoPermintaan.getSelectedItem().toString());
            JdTGL.requestFocusInWindow();
        } else {
            JTNoPermintaan.setQuery("SELECT a.`NoPermintaan` FROM `tbpermintaan` a left join `tbperintahkerja` b on a.`NoPermintaan`=b.`NoPermintaan` WHERE b.`NoPermintaan` is null and a.`NoPermintaan` like '%" + JtCariPermintaan.getText() + "%'");
            JTNoPermintaan.setaawalkosong(false);
            JTNoPermintaan.excute();
            JTNoPermintaan.showPopup();
        }
    }//GEN-LAST:event_JtCariPermintaanKeyReleased

    private void JcPlatItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_JcPlatItemStateChanged
    {//GEN-HEADEREND:event_JcPlatItemStateChanged

        setKMfromPlat(JcPlat.getSelectedItem());
        setenabdisabtextkm();
    }//GEN-LAST:event_JcPlatItemStateChanged

    private void JcPlatActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_JcPlatActionPerformed
    {//GEN-HEADEREND:event_JcPlatActionPerformed

        setKMfromPlat(JcPlat.getSelectedItem());
        setenabdisabtextkm();
    }//GEN-LAST:event_JcPlatActionPerformed

    private void JTNoPermintaanActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_JTNoPermintaanActionPerformed
    {//GEN-HEADEREND:event_JTNoPermintaanActionPerformed
        getdata(JTNoPermintaan.getSelectedItem().toString());
        JTNoPerintahKerja.setText(F.GenNoPermintaan.GetNoPerintahKerja(JcPerbaikan.getSelectedIndex()));        // TODO add your handling code here:
    }//GEN-LAST:event_JTNoPermintaanActionPerformed

     private void JTKetKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_JTKetKeyReleased
     {//GEN-HEADEREND:event_JTKetKeyReleased
         if (evt.getKeyCode() == KeyEvent.VK_F5) {
             if (JTable.getSelectedRow() != -1) {
                 JTable.clearSelection();
                 JCjenis.setSelectedIndex(0);
                 JTKet.setText("");
             }
         } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             JTBiaya.requestFocus();
         }          // TODO add your handling code here:
     }//GEN-LAST:event_JTKetKeyReleased

    void RefreshsJtable() {
        JTable.clearSelection();
        JCjenis.setSelectedIndex(0);
        JTKet.setText("");
        JTBiaya.setInt(0);
    }

     private void JTBiayaKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_JTBiayaKeyReleased
     {//GEN-HEADEREND:event_JTBiayaKeyReleased
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             if (BtnUbah.isEnabled() == false) {
                 if (JCjenis.getSelectedItem().equals("GANTI OLI MESIN") && (Cek.JmlahKMO(JcPlat.getSelectedItem().toString()) < F.Variablebanking.MinGantiOli) && (Cek.JmlahKMO(JcPlat.getSelectedItem().toString()) != -1)) {
                     JOptionPane.showMessageDialog(this, "Tidak Bisa Ganti Oli karena Kilometer Ganti Oli Belum Cukup");
                 } else if (JCjenis.getSelectedItem() == "") {
                     JOptionPane.showMessageDialog(this, "Jenis Service Harus Di Pilih");
                 } else {
                     DefaultTableModel model = (DefaultTableModel) JTable.getModel();
                     model.addRow(new Object[]{JTable.getRowCount() + 1, JCjenis.getSelectedItem(), JTKet.getText(), JTBiaya.getInt()});
                     JOptionPane.showMessageDialog(this, "Berhasil Tambah Permintaan");
                     RefreshsJtable();
                     JTCari.requestFocus();
                 }
             } else if (JCjenis.getSelectedItem().equals("GANTI OLI MESIN") && (Cek.JmlahKMO(JcPlat.getSelectedItem().toString()) < F.Variablebanking.MinGantiOli) && (Cek.JmlahKMO(JcPlat.getSelectedItem().toString()) != -1)) {
                 JOptionPane.showMessageDialog(this, "Tidak Bisa Ganti Oli karena Kilometer Ganti Oli Belum Cukup");
             } else if (JCjenis.getSelectedItem() == "") {
                 JOptionPane.showMessageDialog(this, "Jenis Service Harus Di Pilih");
             } else if (JTable.getSelectedRow() != -1) {
                 JTable.setValueAt(JCjenis.getSelectedItem(), JTable.getSelectedRow(), 1);
                 JTable.setValueAt(JTKet.getText(), JTable.getSelectedRow(), 2);
                 JTable.setValueAt(JTBiaya.getInt(), JTable.getSelectedRow(), 3);
                 JOptionPane.showMessageDialog(this, "Berhasil Ubah Permintaan");
                 RefreshsJtable();
                 JTCari.requestFocus();
             }
         }
         if (evt.getKeyCode() == KeyEvent.VK_F5) {
             if (JTable.getSelectedRow() != -1) {
                 JTable.clearSelection();
                 JCjenis.setSelectedIndex(0);
                 JTKet.setText("");
             }
         }
     }//GEN-LAST:event_JTBiayaKeyReleased

    void deleterowjtable(KeyEvent evt) {
        if (JTable.getSelectedRow() != -1) {
            if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
                if (JTable.getSelectedRow() != -1) {
                    ((DefaultTableModel) JTable.getModel()).removeRow(JTable.getSelectedRow());
                    for (int a = 0; a < JTable.getRowCount(); a++) {
                        JTable.setValueAt(a + 1, a, 0);
                    }
                    JOptionPane.showMessageDialog(this, "Berhasil Hapus Permintaan");
                    RefreshsJtable();
                    JTCari.requestFocus();
                }
            }
        }
    }
     private void JTableKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_JTableKeyReleased
     {//GEN-HEADEREND:event_JTableKeyReleased
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             if (JTable.getSelectedRow() != -1) {
                 JTCari.requestFocus();
             }
         } else if (evt.getKeyCode() == KeyEvent.VK_F5) {
             if (JTable.getSelectedRow() != -1) {
                 JTable.clearSelection();
                 JCjenis.setSelectedIndex(0);
                 JTKet.setText("");
             }
         }
         deleterowjtable(evt);          // TODO add your handling code here:
     }//GEN-LAST:event_JTableKeyReleased

     private void JCjenisKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_JCjenisKeyReleased
     {//GEN-HEADEREND:event_JCjenisKeyReleased
         if (evt.getKeyCode() == KeyEvent.VK_F5) {
             if (JTable.getSelectedRow() != -1) {
                 JTable.clearSelection();
                 JCjenis.setSelectedIndex(0);
                 JTKet.setText("");
             }
         } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             JTKet.requestFocus();
         }          // TODO add your handling code here:          // TODO add your handling code here:
     }//GEN-LAST:event_JCjenisKeyReleased

     private void jButton4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton4ActionPerformed
     {//GEN-HEADEREND:event_jButton4ActionPerformed

         JTNoPerintahKerja.setText(F.GenNoPermintaan.GetNoPerintahKerja(JcPerbaikan.getSelectedIndex()));
         if (JTable.getRowCount() != 0) {

             int km = 0;
             if (JTKMMobil.isEnabled()) {
                 km = JTKMMobil.getInt();
             } else if (JcKMO.isEnabled()) {
                 km = JTKMMobil.getInt();
             }
             List<String> list = new ArrayList<>();
             list.add("INSERT INTO `tbperintahkerja`(`NoPerintahKerja`,`NoPermintaan`, `Tgl`, `Plat`, `Sopir`, `JPermintaan`, `JPekerjaan`, `TingkatPekerjaan`, `KMT`, `User`,`CatKhusus`) VALUES ("
                     + "'" + JTNoPerintahKerja.getText() + "','" + JTNoPermintaan.getSelectedItem().toString() + "','" + F.Datetostringwidthformat.getstringfromdate(JdTGL.getDate(), "yyyy-MM-dd") + " " + JTTime.getText()
                     + "','" + JcPlat.getSelectedItem() + "','" + JtSopir.getText() + "'," + JcPemintaan.getSelectedIndex()
                     + "," + JcPerbaikan.getSelectedIndex() + "," + JcPrioritas.getSelectedIndex()
                     + "," + km + ",'" + jtUser.getText() + "','" + JTCatatanKhusus.getText() + "')");
             Object[][] b = getTableData(JTable);
             for (int i = 0; i < b.length; i++) {
                 String bb = "";
                 for (int j = 0; j < b[i].length + 1; j++) {
                     if (j == b[i].length) {
                         bb += "'" + JTNoPerintahKerja.getText() + "'";
                     } else if ((j == b[i].length - 4) || (j == b[i].length - 1)) {
                         bb += "" + b[i][j] + ",";
                     } else {
                         bb += "'" + b[i][j] + "',";
                     }
                 }
                 list.add("INSERT INTO `tbdetailperintahkerja`(`NoCol`, `JenisPermintaan`, `Keterangan`, `Ongkos`,`NoPerintahKerja`) VALUES (" + bb + ")");
             }
             /*
             for (int i = 0; i < b.length; i++) {
             if (b[i][1].equals("GANTI OLI MESIN")) {
             list.add("UPDATE `ttruck` SET `KMO`='" + 0 + "' WHERE `NoPolisi` = '" + JcPlat.getSelectedItem() + "'");
             }
             }
              */
             RunMultiUpd runMultiUpd = new F.RunMultiUpd();
             runMultiUpd.setQuery(list);
             runMultiUpd.seterorm("Gagal Tambah Data !");
             int no = runMultiUpd.excute();
             if (no != 0) {
                 JOptionPane.showMessageDialog(this, "Berhasil Tambah Data");
                 F.History.STambah("Tambah Data SPK " + JTNoPerintahKerja.getText());
                 F.VarJFrame.menuPerintahKerja.refresh();
                 F.VarJFrame.tambahPerintahKerja.dispose();
                 F.VarJFrame.tambahPerintahKerja = null;
                 if (F.VarJFrame.tambahPerintahKerja == null) {
                     F.VarJFrame.tambahPerintahKerja = new TambahSPK();
                 }
             }
         } else {
             JOptionPane.showMessageDialog(this, "Permintaan Kerja Tidak Boleh Kosong !");
         }          // TODO add your handling code here:
     }//GEN-LAST:event_jButton4ActionPerformed

     private void jButton6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton6ActionPerformed
     {//GEN-HEADEREND:event_jButton6ActionPerformed

         JTNoPerintahKerja.setText(F.GenNoPermintaan.GetNoPerintahKerja(JcPerbaikan.getSelectedIndex()));
         if (JTable.getRowCount() != 0) {

             int km = 0;
             if (JTKMMobil.isEnabled()) {
                 km = JTKMMobil.getInt();
             } else if (JcKMO.isEnabled()) {
                 km = JTKMMobil.getInt();
             }
             List<String> list = new ArrayList<>();
             list.add("INSERT INTO `tbperintahkerja`(`NoPerintahKerja`,`NoPermintaan`, `Tgl`, `Plat`, `Sopir`, `JPermintaan`, `JPekerjaan`, `TingkatPekerjaan`, `KMT`, `User`,`CatKhusus`) VALUES ("
                     + "'" + JTNoPerintahKerja.getText() + "','" + JTNoPermintaan.getSelectedItem().toString() + "','" + F.Datetostringwidthformat.getstringfromdate(JdTGL.getDate(), "yyyy-MM-dd") + " " + JTTime.getText()
                     + "','" + JcPlat.getSelectedItem() + "','" + JtSopir.getText() + "'," + JcPemintaan.getSelectedIndex()
                     + "," + JcPerbaikan.getSelectedIndex() + "," + JcPrioritas.getSelectedIndex()
                     + "," + km + ",'" + jtUser.getText() + "','" + JTCatatanKhusus.getText() + "')");
             Object[][] b = getTableData(JTable);
             for (int i = 0; i < b.length; i++) {
                 String bb = "";
                 for (int j = 0; j < b[i].length + 1; j++) {
                     if (j == b[i].length) {
                         bb += "'" + JTNoPerintahKerja.getText() + "'";
                     } else if ((j == b[i].length - 4) || (j == b[i].length - 1)) {
                         bb += "" + b[i][j] + ",";
                     } else {
                         bb += "'" + b[i][j] + "',";
                     }
                 }
                 list.add("INSERT INTO `tbdetailperintahkerja`(`NoCol`, `JenisPermintaan`, `Keterangan`, `Ongkos`,`NoPerintahKerja`) VALUES (" + bb + ")");
             }
             /*
             for (int i = 0; i < b.length; i++) {
             if (b[i][1].equals("GANTI OLI MESIN")) {
             list.add("UPDATE `ttruck` SET `KMO`='" + 0 + "' WHERE `NoPolisi` = '" + JcPlat.getSelectedItem() + "'");
             }
             }
              */
             RunMultiUpd runMultiUpd = new F.RunMultiUpd();
             runMultiUpd.setQuery(list);
             runMultiUpd.seterorm("Gagal Tambah Data !");
             int no = runMultiUpd.excute();
             if (no != 0) {
                 JOptionPane.showMessageDialog(this, "Berhasil Tambah Data");
                 F.History.STambah("Tambah Data SPK " + JTNoPerintahKerja.getText());
                 F.VarJFrame.tambahPerintahKerja.dispose();
                 F.VarJFrame.tambahPerintahKerja = null;
                 if (F.VarJFrame.tambahPerintahKerja == null) {
                     F.VarJFrame.tambahPerintahKerja = new TambahSPK();
                 }
                 HashMap hashs = new HashMap();
                 String Statusjcom;
                 String StatusOrder;
                 String Cari;
                 hashs.put("Title", "SURAT PERINTAH KERJA");
                 hashs.put("NoPerintahKerja", JTNoPerintahKerja.getText());
                 hashs.put("KaMekanik", F.Variablebanking.Mechanik);
                 hashs.put("Pimpinan", F.Variablebanking.Pimpinan);
                 hashs.put("PrintedBy", "Di Print Oleh " + F.Variablebanking.SUsername + " Pada " + F.Datetostringwidthformat.getstringfromdate(new Date(), "dd/MM/yyyy HH:mm"));
                 FLaporan fLaporan = new F.FLaporan();
                 fLaporan.sethashmap(hashs);
                 fLaporan.setfilename("PerintahKerja");
                 fLaporan.setErorm("Gagal Menampilkan Laporan " + this.getTitle());
                 fLaporan.excute();
                 RunUpd runUpd = new RunUpd();
                 runUpd.setQuery("UPDATE `tbperintahkerja` SET `Print`='Yes' WHERE `NoPerintahKerja`='" + JTNoPerintahKerja.getText() + "'");
                 runUpd.excute();
                 F.VarJFrame.menuPerintahKerja.refresh();
             }
         } else {
             JOptionPane.showMessageDialog(this, "Permintaan Kerja Tidak Boleh Kosong !");
         }          // TODO add your handling code here:
     }//GEN-LAST:event_jButton6ActionPerformed

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton BtnUbah;
     private F.JcomFromDb JCjenis;
     private F.RibuanTextField JTBiaya;
     private F.JackTextField JTCari;
     private F.JackTextField JTCatatanKhusus;
     private F.RibuanTextField JTKMMobil;
     private F.JackTextField JTKet;
     private F.JackTextField JTNoPerintahKerja;
     private F.JcomFromDb JTNoPermintaan;
     private javax.swing.JFormattedTextField JTTime;
     private F.Jktable JTable;
     private F.JNumberTextField JcKMO;
     private F.JcomFromDb JcPemintaan;
     private F.JcomFromDb JcPerbaikan;
     private F.JcomFromDb JcPlat;
     private F.JcomFromDb JcPrioritas;
     private com.toedter.calendar.JDateChooser JdTGL;
     private F.JackTextField JtCariPermintaan;
     private F.JackTextField JtSopir;
     private javax.swing.JButton jButton1;
     private javax.swing.JButton jButton2;
     private javax.swing.JButton jButton3;
     private javax.swing.JButton jButton4;
     private javax.swing.JButton jButton5;
     private javax.swing.JButton jButton6;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel12;
     private javax.swing.JLabel jLabel13;
     private javax.swing.JLabel jLabel14;
     private javax.swing.JLabel jLabel16;
     private javax.swing.JLabel jLabel17;
     private javax.swing.JLabel jLabel18;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel21;
     private javax.swing.JLabel jLabel22;
     private javax.swing.JLabel jLabel23;
     private javax.swing.JLabel jLabel24;
     private javax.swing.JLabel jLabel25;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JLabel jLabel5;
     private javax.swing.JLabel jLabel6;
     private javax.swing.JScrollPane jScrollPane2;
     private F.JackTextField jtUser;
     private org.jdesktop.beansbinding.BindingGroup bindingGroup;
     // End of variables declaration//GEN-END:variables
    private static final Logger LOG = Logger.getLogger(TambahSPK.class.getName());
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proses.XSPB;

import F.RunMultiUpd;
import F.RunSelct2;
import F.RunUpd;
import static F.VarJFrame.tambahPermintaanBarang;
import Koneksi.firebirdCon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author JACK
 */
public class TambahPB extends javax.swing.JFrame {

    /**
     * Creates new form Serivice
     */
    boolean istambah = false;

    public TambahPB() {
        istambah = true;
        initComponents();
        setTitle("Tambah Permintaan Barang");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getdata(JTNoPerintahKerja.getSelectedItem().toString());
        caribarang("");
        jButton4.setVisible(false);
        setVisible(true);
    }

    public TambahPB(String NoPB) {
        istambah = false;
        initComponents();
        setTitle("Ubah Permintaan Barang");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        GetPerminntaaanBarang(NoPB);
        JTNoPermintaanBarang.setText(NoPB);
        jButton1.setVisible(false);
        jButton6.setVisible(false);
        jButton7.setVisible(false);
        setVisible(true);
    }

    private void getdata(String NoPerintahKerja) {
        RunSelct2 runSelct2 = new F.RunSelct2();
        runSelct2.setQuery("SELECT `No`, `NoPerintahKerja`, `NoPermintaan`, `Tgl`, `Plat`, `Sopir`, `JPermintaan`, `JPekerjaan`, `TingkatPekerjaan`, `KMT`, `User` FROM `tbperintahkerja` WHERE  `NoPerintahKerja` = '" + NoPerintahKerja + "'");
        try {
            ResultSet rs = runSelct2.excute();
            if (!rs.isBeforeFirst()) {
                JcPlat.setSelectedItem("");
                JtSopir.setText("");
            }
            while (rs.next()) {
                JcPlat.setSelectedItem(rs.getString("Plat"));
                JtSopir.setText(rs.getString("Sopir"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "gagal Menampilkan Data");
        } finally {
            runSelct2.closecon();
        }
        JTable1.setQuery("SELECT `NoCol` as 'No', `JenisPermintaan` as 'Jenis Permintaan', `Keterangan` as 'Keterangan', `Ongkos` as 'OngkosServices' FROM `tbdetailperintahkerja` WHERE `NoPerintahKerja` = '" + NoPerintahKerja + "' order by `No` Asc");
        JTable1.tampilkan();
    }

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
        int row = JTable.getSelectedRow();
        if (row != -1) {
            JtKodeBarang.setText(JTable.getValueAt(row, 1).toString());
            JcariKodeBarang.setText(JTable.getValueAt(row, 2).toString());
            caribarang(JcariKodeBarang.getText());
            JcDeskripsiBarang.setSelectedItem(JTable.getValueAt(row, 2).toString());
            JtJumlah.setInt(JTable.getintC(row, 3));
            JtJumlahKoma.setint(JTable.getintcoma(row, 3));
            JcSatuan.setSelectedItem(JTable.getValueAt(row, 4));
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

    void RefreshJtable() {
        JTable.clearSelection();
        JtKodeBarang.setText("");
        JcariKodeBarang.setText("");
        caribarang(JcariKodeBarang.getText());
        JtJumlah.setInt(0);
        JtJumlahKoma.setint(0);
        JcSatuan.setModel(new DefaultComboBoxModel());
        JcSatuan.addItem("-");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JdTGL = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        JcariKodeBarang = new F.JackTextField();
        BtnUbah = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        JTNoPerintahKerja = new F.JcomFromDb();
        JTNoPermintaanBarang = new F.JackTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTable = new F.Jktable();
        JtJumlah = new F.RibuanTextField();
        jLabel16 = new javax.swing.JLabel();
        JtCariPermintaan = new F.JackTextField();
        JtSopir = new F.JackTextField();
        jtUser = new F.JackTextField();
        JTTime = new javax.swing.JFormattedTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        JcPlat = new F.JcomFromDb();
        jLabel15 = new javax.swing.JLabel();
        jtCPlat = new F.JackTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTable1 = new F.Jktable();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        JTKMMobil = new F.RibuanTextField();
        JcKaMekanik = new F.JcomFromDb();
        JcCariKaMekanik = new F.JKTextfield();
        jLabel7 = new javax.swing.JLabel();
        JtJumlahKoma = new F.RibuanTextField22();
        jLabel20 = new javax.swing.JLabel();
        JtKodeBarang = new F.JackTextField();
        jLabel23 = new javax.swing.JLabel();
        JcDeskripsiBarang = new javax.swing.JComboBox<>();
        JcSatuan = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        JtKeterangan = new F.JackTextField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Plat");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Waktu & Tanggal");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("No SPK");

        JdTGL.setDate(new Date());
        JdTGL.setDateFormatString("dd-MM-yyyy");
        JdTGL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Barang");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Jumlah");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton1.setText("SIMPAN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel17.setText("USER :");

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("Sopir/Mekanik");

        jButton2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton2.setText("Tambah");
        jButton2.setFocusable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, JTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement == null}"), jButton2, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton3.setText("Hapus");
        jButton3.setFocusable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, JTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jButton3, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        JcariKodeBarang.setmaxtText(75);
        JcariKodeBarang.setDisabledTextColor(new java.awt.Color(0, 0, 102));
        JcariKodeBarang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JcariKodeBarang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JcariKodeBarangFocusLost(evt);
            }
        });
        JcariKodeBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JcariKodeBarangKeyReleased(evt);
            }
        });

        BtnUbah.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        BtnUbah.setText("Ubah");
        BtnUbah.setFocusable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, JTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), BtnUbah, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        BtnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUbahActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton5.setText("Refresh");
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("No Permintaan Brg");

        JTNoPerintahKerja.setQuery("SELECT a.`NoPerintahKerja` FROM `tbperintahkerja` a left join `tbopnamespk` b on a.`NoPerintahKerja` = b.`NoPerintahKerja` where b.`NoPerintahKerja` is null ");
        JTNoPerintahKerja.excute();
        JTNoPerintahKerja.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JTNoPerintahKerja.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JTNoPerintahKerjaItemStateChanged(evt);
            }
        });
        JTNoPerintahKerja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTNoPerintahKerjaActionPerformed(evt);
            }
        });

        JTNoPermintaanBarang.setText(F.GenNoPermintaan.GenNoPermintaanBarang());
        JTNoPermintaanBarang.setDisabledTextColor(new java.awt.Color(0, 0, 102));
        JTNoPermintaanBarang.setEnabled(false);
        JTNoPermintaanBarang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cari");

        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Kode Barang", "Deskripsi Barang", "Jumlah", "Satuan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
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
            jScrollPane2.setViewportView(JTable);
            JTable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "startEditing");

            JTable.setrender(3,"Number");

            JtJumlah.setmaxnum(10000);
            JtJumlah.setDisabledTextColor(new java.awt.Color(0, 0, 102));
            JtJumlah.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            JtJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    JtJumlahKeyReleased(evt);
                }
            });

            jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            jLabel16.setText("Satuan");
            jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

            JtCariPermintaan.setmaxtText(50);
            JtCariPermintaan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            JtCariPermintaan.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    JtCariPermintaanKeyReleased(evt);
                }
            });

            JtSopir.setEnabled(false);
            JtSopir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

            jtUser.setText(F.Variablebanking.SUsername);
            jtUser.setEnabled(false);
            jtUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

            JTTime.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("HH:mm"))));
            JTTime.setText(F.Datetostringwidthformat.getstringfromdate(new Date(),"HH:mm"));
            JTTime.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

            jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            jCheckBox1.setText("Tanpa SPK");
            jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
                public void itemStateChanged(java.awt.event.ItemEvent evt) {
                    jCheckBox1ItemStateChanged(evt);
                }
            });

            jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            jLabel5.setText("Tanpa SPK");

            JcPlat.setQuery("SELECT `NoPolisi`FROM `ttruck`");
            JcPlat.excute();
            JcPlat.setEnabled(false);
            JcPlat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

            jLabel15.setVisible(false);
            jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            jLabel15.setText("Cari");

            jtCPlat.setmaxtText(50);
            jtCPlat.setEnabled(false);
            jtCPlat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            jtCPlat.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    jtCPlatKeyReleased(evt);
                }
            });

            JTable1.setEnabled(false);
            JTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "No", "Jenis Service", "Keterangan", "Ongkos Service", "Selesai"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
                };
                boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            JTable1.setEnabled(false);
            JTable.getSelectionModel().addListSelectionListener(new
                ListSelectionListener()
                {
                    public void valueChanged(ListSelectionEvent e)
                    {
                        getSelectedData();
                    }
                });
                jScrollPane3.setViewportView(JTable1);

                jButton6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
                jButton6.setText("SIMPAN DAN BARU");
                jButton6.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton6ActionPerformed(evt);
                    }
                });

                jButton7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
                jButton7.setText("CETAK");
                jButton7.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton7ActionPerformed(evt);
                    }
                });

                jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel22.setText("KM");

                JTKMMobil.setAllowNegative(true);
                JTKMMobil.setText("0");
                JTKMMobil.setDisabledTextColor(new java.awt.Color(0, 0, 102));
                JTKMMobil.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                JTKMMobil.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyReleased(java.awt.event.KeyEvent evt) {
                        JTKMMobilKeyReleased(evt);
                    }
                });

                JcKaMekanik.setQuery("SELECT `Nama` FROM `tbkamekanik` WHERE Status = 0");
                JcKaMekanik.excute();
                JcKaMekanik.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                JcKaMekanik.addItemListener(new java.awt.event.ItemListener() {
                    public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        JcKaMekanikItemStateChanged(evt);
                    }
                });
                JcKaMekanik.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        JcKaMekanikActionPerformed(evt);
                    }
                });

                JcCariKaMekanik.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                JcCariKaMekanik.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        JcCariKaMekanikActionPerformed(evt);
                    }
                });
                JcCariKaMekanik.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyReleased(java.awt.event.KeyEvent evt) {
                        JcCariKaMekanikKeyReleased(evt);
                    }
                });

                jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel7.setText("KA Mekanik");

                JtJumlahKoma.setText("00");
                JtJumlahKoma.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

                jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel20.setText("Kode Barang");
                jLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

                JtKodeBarang.setEnabled(false);
                JtKodeBarang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                JtKodeBarang.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyReleased(java.awt.event.KeyEvent evt) {
                        JtKodeBarangKeyReleased(evt);
                    }
                });

                jLabel15.setVisible(false);
                jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel23.setText("Cari");

                JTextComponent editor = (JTextComponent) JcDeskripsiBarang.getEditor().getEditorComponent();
                editor.addKeyListener(new KeyAdapter() {
                    public void keyReleased(KeyEvent evt) {
                        System.out.println(evt.getKeyCode());
                        if(evt.getKeyCode()== KeyEvent.VK_ENTER)
                        {
                            JtJumlah.requestFocus();
                            JcDeskripsiBarang.hidePopup();
                        }
                    }
                });
                JcDeskripsiBarang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                JcDeskripsiBarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "_________________________________________________________________________________________________________________" }));
                JcDeskripsiBarang.addFocusListener(new java.awt.event.FocusAdapter() {
                    public void focusLost(java.awt.event.FocusEvent evt) {
                        JcDeskripsiBarangFocusLost(evt);
                    }
                });
                JcDeskripsiBarang.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyReleased(java.awt.event.KeyEvent evt) {
                        JcDeskripsiBarangKeyReleased(evt);
                    }
                });

                JTextComponent editor2 = (JTextComponent) JcSatuan.getEditor().getEditorComponent();
                editor2.addKeyListener(new KeyAdapter() {
                    public void keyReleased(KeyEvent evt) {
                        System.out.println(evt.getKeyCode());
                        if(evt.getKeyCode()== KeyEvent.VK_ENTER)
                        {
                            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                                if(JTable.getSelectedRow()!=-1)
                                {
                                    ubahtable();
                                }
                                else
                                {
                                    tambahtable();
                                }
                            }
                        }
                    }
                });
                JcSatuan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                JcSatuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
                JcSatuan.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyReleased(java.awt.event.KeyEvent evt) {
                        JcSatuanKeyReleased(evt);
                    }
                });

                jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel24.setText("Keterangan");
                jLabel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

                JtKeterangan.setmaxtText(148);
                JtKeterangan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                JtKeterangan.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyReleased(java.awt.event.KeyEvent evt) {
                        JtKeteranganKeyReleased(evt);
                    }
                });

                jButton4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
                jButton4.setText("UBAH");
                jButton4.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton4ActionPerformed(evt);
                    }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JcCariKaMekanik, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JcKaMekanik, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1017, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel1)
                                        .addGap(4, 4, 4)
                                        .addComponent(JtCariPermintaan, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(JTNoPerintahKerja, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTNoPermintaanBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(4, 4, 4)
                                        .addComponent(jtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel20)
                                                    .addComponent(JtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(JcariKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(JcDeskripsiBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(JtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(JtJumlahKoma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(JcSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(26, 26, 26)
                                                    .addComponent(JTKMMobil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(26, 26, 26)
                                                    .addComponent(JtSopir, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(26, 26, 26)
                                                        .addComponent(jLabel23)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jtCPlat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(26, 26, 26)
                                                        .addComponent(JdTGL, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(6, 6, 6)
                                                        .addComponent(JTTime, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(JcPlat, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel24)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(JtKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 912, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1015, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jButton2)
                                                    .addComponent(BtnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jButton5))))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())))
                );

                layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnUbah, jButton2, jButton3, jButton5});

                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JtCariPermintaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JTNoPerintahKerja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTNoPermintaanBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1))))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jCheckBox1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(JdTGL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtCPlat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JcPlat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel23)))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel21))
                            .addComponent(JtSopir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(JcKaMekanik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JcCariKaMekanik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel22))
                            .addComponent(JTKMMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(JcariKodeBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(JtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(JcDeskripsiBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addGap(6, 6, 6)
                                        .addComponent(BtnUbah)
                                        .addGap(6, 6, 6)
                                        .addComponent(jButton3)
                                        .addGap(6, 6, 6)
                                        .addComponent(jButton5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel24)
                                            .addComponent(JtKeterangan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(jLabel17))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(jtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButton4)
                                            .addComponent(jButton1)
                                            .addComponent(jButton6)
                                            .addComponent(jButton7)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel16))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(JtJumlah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(JtJumlahKoma, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JcSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                );

                layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnUbah, JTKMMobil, JTNoPerintahKerja, JTTime, JcCariKaMekanik, JcKaMekanik, JcPlat, JcariKodeBarang, JdTGL, JtCariPermintaan, JtJumlah, JtSopir, jButton1, jButton2, jButton3, jButton5, jButton6, jButton7, jCheckBox1, jLabel1, jLabel13, jLabel14, jLabel15, jLabel16, jLabel17, jLabel2, jLabel21, jLabel22, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jtCPlat, jtUser});

                bindingGroup.bind();

                pack();
            }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JTNoPermintaanBarang.setText(F.GenNoPermintaan.GenNoPermintaanBarang());
        if (JTable.getRowCount() != 0) {
            List<String> list = new ArrayList<>();
            if (jCheckBox1.isSelected()) {
                list.add("INSERT INTO `tbpermintaanbarang`(`NoPermintaanBarang`, `NoPerintahKerja`, `Tgl`, `Plat`, `Sopir`, `User`,`KMT`,`KaMekanikb`,`Keteranganpb`) VALUES ("
                        + "'" + JTNoPermintaanBarang.getText() + "',null,'" + F.Datetostringwidthformat.getstringfromdate(JdTGL.getDate(), "yyyy-MM-dd") + " " + JTTime.getText()
                        + "','" + JcPlat.getSelectedItem() + "','" + JtSopir.getText() + "','" + jtUser.getText() + "'," + JTKMMobil.getInt() + ",'" + JcKaMekanik.getSelectedItem() + "','" + JtKeterangan.getText() + "')");
            } else {
                list.add("INSERT INTO `tbpermintaanbarang`(`NoPermintaanBarang`, `NoPerintahKerja`, `Tgl`, `Plat`, `Sopir`, `User`,`KMT`,`KaMekanikb`,`Keteranganpb`) VALUES ("
                        + "'" + JTNoPermintaanBarang.getText() + "','" + JTNoPerintahKerja.getSelectedItem().toString() + "','" + F.Datetostringwidthformat.getstringfromdate(JdTGL.getDate(), "yyyy-MM-dd") + " " + JTTime.getText()
                        + "','" + JcPlat.getSelectedItem() + "','" + JtSopir.getText() + "','" + jtUser.getText() + "'," + JTKMMobil.getInt() + ",'" + JcKaMekanik.getSelectedItem() + ",'" + JtKeterangan.getText() + "'')");
            }
            Object[][] b = getTableData(JTable);

            for (int i = 0; i < b.length; i++) {
                String bb = "";
                for (int j = 0; j < b[i].length + 1; j++) {
                    if (j == b[i].length) {
                        bb += "'" + JTNoPermintaanBarang.getText() + "'";
                    } else if ((j == b[i].length - 2) || (j == b[i].length - 5) ) {
                        bb += "" + b[i][j] + ",";
                    } else {
                        bb += "'" + b[i][j] + "',";
                    }
                }
                list.add("INSERT INTO `tbdetailpermintaanbarang`(`NoCol`, `KodeBarang`, `DeskripsiBarang`, `Jumlah`, `Satuan`,`NoPermintaanBarang`) VALUES (" + bb + ")");
            }
            RunMultiUpd runMultiUpd = new F.RunMultiUpd();
            runMultiUpd.setQuery(list);
            runMultiUpd.seterorm("Gagal Tambah Data !");
            int no = runMultiUpd.excute();
            if (no != 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil di simpan !!");
                F.History.STambah("Tambah Data permintaan Barang " + JTNoPermintaanBarang.getText());
                F.VarJFrame.menuPermintaanBarang.refresh();
                F.VarJFrame.tambahPermintaanBarang.dispose();
                F.VarJFrame.tambahPermintaanBarang = null;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Permintaan Barang Boleh Kosong !");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                
                tambahtable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        hapustable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        if (istambah) {
            F.VarJFrame.tambahPermintaanBarang = null;
            if (F.VarJFrame.menuPermintaanBarang != null) {
                F.VarJFrame.menuPermintaanBarang.Refresh();
            }
        } else {
            F.VarJFrame.ubahPermintaanBarang = null;
            if (F.VarJFrame.menuPermintaanBarang != null) {
                F.VarJFrame.menuPermintaanBarang.Refresh();
            }
        }
    }//GEN-LAST:event_formWindowClosing

    private void BtnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUbahActionPerformed
        ubahtable();
    }//GEN-LAST:event_BtnUbahActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JTable.clearSelection();
        JcariKodeBarang.setText("");
        JtJumlah.setInt(0);
        JtJumlahKoma.setText("00");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void JTNoPerintahKerjaItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_JTNoPerintahKerjaItemStateChanged
    {//GEN-HEADEREND:event_JTNoPerintahKerjaItemStateChanged
        getdata(JTNoPerintahKerja.getSelectedItem().toString());
    }//GEN-LAST:event_JTNoPerintahKerjaItemStateChanged

    private void JtCariPermintaanKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_JtCariPermintaanKeyReleased
    {//GEN-HEADEREND:event_JtCariPermintaanKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            JTNoPerintahKerja.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER && JTNoPerintahKerja.getSelectedIndex() != -1) {
            JTNoPerintahKerja.hidePopup();
            jCheckBox1.requestFocus();
        } else {
            JTNoPerintahKerja.setQuery("SELECT a.`NoPerintahKerja` FROM `tbperintahkerja` a left join `tbopnamespk` b on a.`NoPerintahKerja` = b.`NoPerintahKerja` where b.`NoPerintahKerja` is null  and a.`NoPerintahKerja` like '%" + JtCariPermintaan.getText() + "%'");
            JTNoPerintahKerja.setaawalkosong(false);
            JTNoPerintahKerja.excute();
            JTNoPerintahKerja.showPopup();
        }
    }//GEN-LAST:event_JtCariPermintaanKeyReleased

    private void JTNoPerintahKerjaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_JTNoPerintahKerjaActionPerformed
    {//GEN-HEADEREND:event_JTNoPerintahKerjaActionPerformed
        getdata(JTNoPerintahKerja.getSelectedItem().toString());
        // TODO add your handling code here:
    }//GEN-LAST:event_JTNoPerintahKerjaActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_jCheckBox1ItemStateChanged
    {//GEN-HEADEREND:event_jCheckBox1ItemStateChanged
        if (jCheckBox1.isSelected()) {
            jLabel4.setVisible(false);
            JTNoPerintahKerja.setVisible(false);
            jLabel1.setVisible(false);
            JtCariPermintaan.setVisible(false);
            JcPlat.setEnabled(true);
            JtSopir.setEnabled(true);
            JtSopir.setText("");
            jtCPlat.setVisible(true);
            jLabel15.setVisible(true);
            JTable1.setVisible(false);
            jtCPlat.setEnabled(true);
        } else {
            jLabel4.setVisible(true);
            JTNoPerintahKerja.setVisible(true);
            jLabel1.setVisible(true);
            JtCariPermintaan.setVisible(true);
            JcPlat.setEnabled(false);
            JtSopir.setEnabled(false);
            jtCPlat.setEnabled(false);
            GetJcomPlat(null);
            getdata(JTNoPerintahKerja.getSelectedItem().toString());
            jLabel15.setVisible(true);
            JTable1.setVisible(true);
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jtCPlatKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jtCPlatKeyReleased
    {//GEN-HEADEREND:event_jtCPlatKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            JcPlat.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER && JcPlat.getSelectedIndex() != -1) {
            JcPlat.hidePopup();
            JtSopir.requestFocus();
        } else {
            JcPlat.setaawalkosong(false);
            JcPlat.excute();
            GetJcomPlat(jtCPlat.getText());
            JcPlat.showPopup();
        }
    }//GEN-LAST:event_jtCPlatKeyReleased

     private void JcariKodeBarangKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_JcariKodeBarangKeyReleased
     {//GEN-HEADEREND:event_JcariKodeBarangKeyReleased
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) { 
             if ("BLL".equals(JcariKodeBarang.getText())) {
                 JcDeskripsiBarang.setEditable(true);
                 JcSatuan.setEditable(true);
                 JtKodeBarang.setText("-");
                 JcSatuan.removeAllItems();
                 JcSatuan.addItem("");
                 JcDeskripsiBarang.requestFocus();
             } else {
                 JcSatuan.setEditable(false);
                 JcDeskripsiBarang.setEditable(false);
                 JcDeskripsiBarang.requestFocus();
                 getvaluekdbarang(JcDeskripsiBarang.getSelectedItem());
             }
         } 
         else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
             JcDeskripsiBarang.requestFocus();
             getvaluekdbarang(JcDeskripsiBarang.getSelectedItem());
         }
         else {
             caribarang(JcariKodeBarang.getText());
             getvaluekdbarang(JcDeskripsiBarang.getSelectedItem());
             JcDeskripsiBarang.showPopup();
         }
     }//GEN-LAST:event_JcariKodeBarangKeyReleased

     private void JtJumlahKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_JtJumlahKeyReleased
     {//GEN-HEADEREND:event_JtJumlahKeyReleased
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             JcSatuan.requestFocus();
         }          // TODO add your handling code here:
     }//GEN-LAST:event_JtJumlahKeyReleased

     private void jButton7ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton7ActionPerformed
     {//GEN-HEADEREND:event_jButton7ActionPerformed
         simpandata(true);
     }//GEN-LAST:event_jButton7ActionPerformed

     private void jButton6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton6ActionPerformed
     {//GEN-HEADEREND:event_jButton6ActionPerformed
         simpandata(false);
     }//GEN-LAST:event_jButton6ActionPerformed

     private void JcKaMekanikItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_JcKaMekanikItemStateChanged
     {//GEN-HEADEREND:event_JcKaMekanikItemStateChanged
         // TODO add your handling code here:
     }//GEN-LAST:event_JcKaMekanikItemStateChanged

     private void JcKaMekanikActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_JcKaMekanikActionPerformed
     {//GEN-HEADEREND:event_JcKaMekanikActionPerformed
         // TODO add your handling code here:
     }//GEN-LAST:event_JcKaMekanikActionPerformed

     private void JcCariKaMekanikActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_JcCariKaMekanikActionPerformed
     {//GEN-HEADEREND:event_JcCariKaMekanikActionPerformed
         // TODO add your handling code here:
     }//GEN-LAST:event_JcCariKaMekanikActionPerformed

     private void JcCariKaMekanikKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_JcCariKaMekanikKeyReleased
     {//GEN-HEADEREND:event_JcCariKaMekanikKeyReleased
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             JcKaMekanik.hidePopup();
             JTKMMobil.requestFocus();
         } else {
             JcKaMekanik.setQuery("SELECT `Nama` FROM `tbkamekanik` WHERE Status = 0 and `Nama` Like '%" + JcCariKaMekanik.getText() + "%'");
             JcKaMekanik.setaawalkosong(false);
             JcKaMekanik.excute();
             JcKaMekanik.showPopup();// TODO add your handling code here:
         }
     }//GEN-LAST:event_JcCariKaMekanikKeyReleased

    private void JtKodeBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtKodeBarangKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_JtKodeBarangKeyReleased

    private void JcDeskripsiBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JcDeskripsiBarangKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JtJumlah.requestFocus();
            getvaluekdbarang(JcDeskripsiBarang.getSelectedItem());
            JcDeskripsiBarang.hidePopup();
        }
    }//GEN-LAST:event_JcDeskripsiBarangKeyReleased

    private void JcSatuanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JcSatuanKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        if(JTable.getSelectedRow()!=-1)
        {
ubahtable();
        }
        else
        {
tambahtable();
        }
        }
    }//GEN-LAST:event_JcSatuanKeyReleased

    private void JTKMMobilKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTKMMobilKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JcariKodeBarang.requestFocus();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_JTKMMobilKeyReleased

    private void JtKeteranganKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtKeteranganKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_JtKeteranganKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        update();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void JcariKodeBarangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JcariKodeBarangFocusLost
getvaluekdbarang(JcDeskripsiBarang.getSelectedItem());
    }//GEN-LAST:event_JcariKodeBarangFocusLost

    private void JcDeskripsiBarangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JcDeskripsiBarangFocusLost
getvaluekdbarang(JcDeskripsiBarang.getSelectedItem());
    }//GEN-LAST:event_JcDeskripsiBarangFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnUbah;
    private F.RibuanTextField JTKMMobil;
    private F.JcomFromDb JTNoPerintahKerja;
    private F.JackTextField JTNoPermintaanBarang;
    private javax.swing.JFormattedTextField JTTime;
    private F.Jktable JTable;
    private F.Jktable JTable1;
    private F.JKTextfield JcCariKaMekanik;
    private javax.swing.JComboBox<String> JcDeskripsiBarang;
    private F.JcomFromDb JcKaMekanik;
    private F.JcomFromDb JcPlat;
    private javax.swing.JComboBox<String> JcSatuan;
    private F.JackTextField JcariKodeBarang;
    private com.toedter.calendar.JDateChooser JdTGL;
    private F.JackTextField JtCariPermintaan;
    private F.RibuanTextField JtJumlah;
    private F.RibuanTextField22 JtJumlahKoma;
    private F.JackTextField JtKeterangan;
    private F.JackTextField JtKodeBarang;
    private F.JackTextField JtSopir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private F.JackTextField jtCPlat;
    private F.JackTextField jtUser;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    private static final Logger LOG = Logger.getLogger(TambahPB.class.getName());

    void caribarang(String Cari) {
        String Query = "SELECT a.ITEMDESCRIPTION\n"
                + "FROM ITEM a\n"
                + "where a.ITEMDESCRIPTION like '%" + Cari + "%' and SUSPENDED = 0 and ITEMTYPE = 0  "
                + "order by ITEMDESCRIPTION asc";
        DefaultComboBoxModel modelbaru = new DefaultComboBoxModel();
        JcDeskripsiBarang.setModel(modelbaru);
        ArrayList<String> groupNames = new ArrayList<>();
        PreparedStatement pstmt = null;
        try {
            int autono = 0;
            pstmt = firebirdCon.getfirebirdcon().prepareStatement(Query);
            ResultSet rs = pstmt.executeQuery();
            if ("".equals(Cari)) {
                groupNames.add("-");
            } else {
                while (rs.next()) {
                    groupNames.add(rs.getString(1));
                }
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(groupNames.toArray());
            JcDeskripsiBarang.setModel(model);
        } catch (SQLException e) {
            showMessageDialog(null, "Eror Koneksi Firebird Eror = " + e);
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println("Proses.XSPB.TambahPB.caribarang()" + ex);
            }
        }
    }

    public void getvaluekdbarang(Object DekskripsiBarang) {
        if (!"BLL".equals(JcariKodeBarang.getText())) {
            String Query = "SELECT a.ITEMNO,a.UNIT1, a.UNIT2, a.UNIT3\n"
                    + "FROM ITEM a\n"
                    + "where ITEMDESCRIPTION = '" + DekskripsiBarang + "'";
            JcSatuan.setModel(new DefaultComboBoxModel());
            if (JcDeskripsiBarang.getSelectedItem() == "-") {
                JtKodeBarang.setText("-");
                JcSatuan.addItem("-");
            } else {
                ArrayList<String> groupNames = new ArrayList<>();
                PreparedStatement pstmt = null;
                try {
                    int autono = 0;
                    pstmt = firebirdCon.getfirebirdcon().prepareStatement(Query);
                    ResultSet rs = pstmt.executeQuery();
                    if (!rs.isBeforeFirst()) {
                        JtKodeBarang.setText("-");
                        JcSatuan.addItem("-");
                    }
                    while (rs.next()) {
                        JtKodeBarang.setText(rs.getString(1));
                        if (rs.getString(2) != null) {
                            JcSatuan.addItem(rs.getString(2));
                        }
                        if (rs.getString(3) != null) {
                            JcSatuan.addItem(rs.getString(3));
                        }
                        if (rs.getString(4) != null) {
                            JcSatuan.addItem(rs.getString(4));
                        }
                    }
                } catch (SQLException e) {
                    showMessageDialog(null, "gagal ambil Kode Barang Eror :" + e);
                } finally {
                    try {
                        if (pstmt != null) {
                            pstmt.close();
                        }
                    } catch (SQLException ex) {
                        System.out.println("Proses.XSPB.TambahPB.getvaluekdbarang()" + ex);
                    }
                }
            }
        }
    }

    void tambahtable() {
        getvaluekdbarang(JcDeskripsiBarang.getSelectedItem());
        if (!"-".equals(JcDeskripsiBarang.getSelectedItem()) || !"".equals(JcDeskripsiBarang.getSelectedItem())) {
            DefaultTableModel model = (DefaultTableModel) JTable.getModel();
            model.addRow(new Object[]{JTable.getRowCount() + 1, JtKodeBarang.getText(), JcDeskripsiBarang.getSelectedItem(), JtJumlah.getInt() + "." + JtJumlahKoma.getText(), JcSatuan.getSelectedItem()});
            JOptionPane.showMessageDialog(this, "Berhasil Tambah Data");
            RefreshJtable();
        } else {
            JOptionPane.showMessageDialog(null, "Barang Harus Di Pilih");
        }
        JcariKodeBarang.requestFocus();
    }

    void ubahtable() {
        getvaluekdbarang(JcDeskripsiBarang.getSelectedItem());
        if (JTable.getSelectedRow() != -1) {
            JTable.setValueAt(JtKodeBarang.getText(), JTable.getSelectedRow(), 1);
            JTable.setValueAt(JcDeskripsiBarang.getSelectedItem(), JTable.getSelectedRow(), 2);
            JTable.setValueAt(JtJumlah.getInt() + "." + JtJumlahKoma.getText(), JTable.getSelectedRow(), 3);
            JTable.setValueAt(JcSatuan.getSelectedItem(), JTable.getSelectedRow(), 4);
            JOptionPane.showMessageDialog(this, "Berhasil Ubah Data");
            RefreshJtable();
        }
    }

    void hapustable() {
        if (JTable.getSelectedRow() != -1) {
            ((DefaultTableModel) JTable.getModel()).removeRow(JTable.getSelectedRow());
            for (int a = 0; a < JTable.getRowCount(); a++) {
                JTable.setValueAt(a + 1, a, 0);
            }
            JOptionPane.showMessageDialog(this, "Berhasil Hapus Data");
            RefreshJtable();
        }
    }

    private void GetPerminntaaanBarang(String NOPB) {
        String NoSPK = "";
        RunSelct2 runSelct2 = new F.RunSelct2();
        runSelct2.setQuery("SELECT `No`, `NoPerintahKerja`, `NoPermintaanBarang`, `Tgl`, `Plat`, `Sopir`, `User`,`KMT`,`KaMekanikb`,`Keteranganpb` FROM `tbpermintaanbarang` WHERE `NoPermintaanBarang` ='" + NOPB + "'");
        try {
            ResultSet rs = runSelct2.excute();
            while (rs.next()) {
                NoSPK = rs.getString("NoPerintahKerja");
                JTNoPerintahKerja.addItem(rs.getString("NoPerintahKerja"));
                if (rs.getString("NoPerintahKerja") == null) {
                    jCheckBox1.setSelected(true);
                    jLabel4.setVisible(false);
                    JTNoPerintahKerja.setVisible(false);
                    jLabel1.setVisible(false);
                    JtCariPermintaan.setVisible(false);
                    JcPlat.setEnabled(true);
                    JtSopir.setEnabled(true);
                    JtSopir.setText("");
                    jtCPlat.setVisible(true);
                    JcPlat.setVisible(true);
                    jLabel15.setVisible(true);
                    JTable1.setVisible(false);
                } else {
                    JTNoPerintahKerja.setSelectedItem(rs.getString("NoPerintahKerja"));
                    jLabel4.setVisible(true);
                    JTNoPerintahKerja.setVisible(true);
                    jLabel1.setVisible(true);
                    JtCariPermintaan.setVisible(true);
                    JcPlat.setEnabled(false);
                    JtSopir.setEnabled(false);
                    GetJcomPlat(null);
                    getdata(JTNoPerintahKerja.getSelectedItem().toString());
                    jtCPlat.setVisible(false);
                    jLabel15.setVisible(false);
                    JTable1.setVisible(true);
                }
                JTNoPermintaanBarang.setText(rs.getString("NoPermintaanBarang"));
                JdTGL.setDate(new Date());
                JTTime.setText(F.Datetostringwidthformat.getstringfromdate(new Date(), "HH:mm"));
                JcPlat.addItem(rs.getString("Plat"));
                JcPlat.setSelectedItem(rs.getString("Plat"));
                JtSopir.setText(rs.getString("Sopir"));
                JTKMMobil.setInt(rs.getInt("KMT"));
                if (JcKaMekanik.getSelectedItem().toString() == null ? rs.getString("KaMekanikb") != null : !JcKaMekanik.getSelectedItem().toString().equals(rs.getString("KaMekanikb"))) {
                    JcKaMekanik.addItem(rs.getString("KaMekanikb"));
                    JcKaMekanik.setSelectedItem(rs.getString("KaMekanikb"));
                }
                JtKeterangan.setText(rs.getString("Keteranganpb"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "gagal Menampilkan Data");
        } finally {
            runSelct2.closecon();
            JTable.setQuery("SELECT `NoCol`, `KodeBarang`, `DeskripsiBarang`, `Jumlah`, `Satuan` FROM `tbdetailpermintaanbarang` WHERE `NoPermintaanBarang` = '" + NOPB + "' order by `No` Asc");
            JTable.tampilkan();
            JTable1.setQuery("SELECT `NoCol` as 'No', `JenisPermintaan` as 'Jenis Permintaan', `Keterangan` as 'Keterangan', `Ongkos` as 'OngkosServices' FROM `tbdetailperintahkerja` WHERE `NoPerintahKerja` = '" + NoSPK + "' order by `No` Asc");
            JTable1.tampilkan();
        }
    }

    void update() {
        if (JTable.getRowCount() != 0) {
            List<String> list = new ArrayList<>();
            if (jCheckBox1.isSelected()) {
                list.add("UPDATE `tbpermintaanbarang` SET `NoPerintahKerja`= null,`Tgl`= '" + F.Datetostringwidthformat.getstringfromdate(JdTGL.getDate(), "yyyy-MM-dd") + " " + JTTime.getText() + "',"
                        + " `Plat` = '" + JcPlat.getSelectedItem() + "' , `Sopir` = '" + JtSopir.getText() + "',"
                        + " `User`= '" + jtUser.getText() + "',`KMT`= '" + JTKMMobil.getInt() + "',`KaMekanikb`='" + JcKaMekanik.getSelectedItem() + "',`Keteranganpb`='" + JtKeterangan.getText() + "' where `NoPermintaanBarang` = '" + JTNoPermintaanBarang.getText() + "'");
                list.add("DELETE FROM `tbdetailpermintaanbarang` WHERE `NoPermintaanBarang` = '" + JTNoPermintaanBarang.getText() + "'");
            } else {
                list.add("UPDATE `tbpermintaanbarang` SET `NoPerintahKerja`= '" + JTNoPerintahKerja.getSelectedItem() + "',`Tgl`= '" + F.Datetostringwidthformat.getstringfromdate(JdTGL.getDate(), "yyyy-MM-dd") + " " + JTTime.getText() + "',"
                        + " `Plat` = '" + JcPlat.getSelectedItem() + "' , `Sopir` = '" + JtSopir.getText() + "',"
                        + " `User`= '" + jtUser.getText() + "',`KMT`= '" + JTKMMobil.getInt() + "',`KaMekanikb`='" + JcKaMekanik.getSelectedItem() + "',`Keteranganpb`='" + JtKeterangan.getText() + "' where `NoPermintaanBarang` = '" + JTNoPermintaanBarang.getText() + "'");
                list.add("DELETE FROM `tbdetailpermintaanbarang` WHERE `NoPermintaanBarang` = '" + JTNoPermintaanBarang.getText() + "'");
            }
            Object[][] b = getTableData(JTable);

            for (int i = 0; i < b.length; i++) {
                String bb = "";
                for (int j = 0; j < b[i].length + 1; j++) {
                    if (j == b[i].length) {
                        bb += "'" + JTNoPermintaanBarang.getText() + "'";
                    } else if ((j == b[i].length - 2) || (j == b[i].length - 5)) {
                        bb += "" + b[i][j] + ",";
                    } else {
                        bb += "'" + b[i][j] + "',";
                    }
                }
                list.add("INSERT INTO `tbdetailpermintaanbarang`(`NoCol`, `KodeBarang`, `DeskripsiBarang`, `Jumlah`, `Satuan`,`NoPermintaanBarang`) VALUES (" + bb + ")");
            }
            ////system.out.printlnln(list);
            RunMultiUpd runMultiUpd = new F.RunMultiUpd();
            runMultiUpd.setQuery(list);
            runMultiUpd.seterorm("Gagal Ubah Data !");
            int no = runMultiUpd.excute();
            if (no != 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil di Ubah !!");
                F.History.STambah("Ubah Data permintaan Barang " + JTNoPermintaanBarang.getText());
                F.VarJFrame.menuPermintaanBarang.refresh();
                F.VarJFrame.ubahPermintaanBarang.dispose();
                F.VarJFrame.ubahPermintaanBarang = null;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Permintaan Barang Tidak Boleh Kosong !");
        }
    }

    void simpandata(boolean Cetak) {
        JTNoPermintaanBarang.setText(F.GenNoPermintaan.GenNoPermintaanBarang());
        if (JTable.getRowCount() != 0) {
            List<String> list = new ArrayList<>();
            if (jCheckBox1.isSelected()) {
                list.add("INSERT INTO `tbpermintaanbarang`(`NoPermintaanBarang`, `NoPerintahKerja`, `Tgl`, `Plat`, `Sopir`, `User`,`KMT`,`KaMekanikb`,`Keteranganpb`) VALUES ("
                        + "'" + JTNoPermintaanBarang.getText() + "',null,'" + F.Datetostringwidthformat.getstringfromdate(JdTGL.getDate(), "yyyy-MM-dd") + " " + JTTime.getText()
                        + "','" + JcPlat.getSelectedItem() + "','" + JtSopir.getText() + "','" + jtUser.getText() + "'," + JTKMMobil.getInt() + ",'" + JcKaMekanik.getSelectedItem() + "','" + JtKeterangan.getText() + "')");
            } else {
                list.add("INSERT INTO `tbpermintaanbarang`(`NoPermintaanBarang`, `NoPerintahKerja`, `Tgl`, `Plat`, `Sopir`, `User`,`KMT`,`KaMekanikb`,`Keteranganpb`) VALUES ("
                        + "'" + JTNoPermintaanBarang.getText() + "','" + JTNoPerintahKerja.getSelectedItem().toString() + "','" + F.Datetostringwidthformat.getstringfromdate(JdTGL.getDate(), "yyyy-MM-dd") + " " + JTTime.getText()
                        + "','" + JcPlat.getSelectedItem() + "','" + JtSopir.getText() + "','" + jtUser.getText() + "'," + JTKMMobil.getInt() + ",'" + JcKaMekanik.getSelectedItem() + "','" + JtKeterangan.getText() + "')");
            }
            Object[][] b = getTableData(JTable);

            for (int i = 0; i < b.length; i++) {
                String bb = "";
                for (int j = 0; j < b[i].length + 1; j++) {
                    if (j == b[i].length) {
                        bb += "'" + JTNoPermintaanBarang.getText() + "'";
                    } else if ((j == b[i].length - 2) || (j == b[i].length - 5)) {
                        bb += "" + b[i][j] + ",";
                    } else {
                        bb += "'" + b[i][j] + "',";
                    }
                }
                list.add("INSERT INTO `tbdetailpermintaanbarang`(`NoCol`, `KodeBarang`, `DeskripsiBarang`, `Jumlah`, `Satuan`,`NoPermintaanBarang`) VALUES (" + bb + ")");
            }
            RunMultiUpd runMultiUpd = new F.RunMultiUpd();
            runMultiUpd.setQuery(list);
            runMultiUpd.seterorm("Gagal Tambah Data !");
            int no = runMultiUpd.excute();
            if (no != 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil di simpan !!");
                F.History.STambah("Tambah Data permintaan Barang " + JTNoPermintaanBarang.getText());
                F.VarJFrame.tambahPermintaanBarang.dispose();
                F.VarJFrame.tambahPermintaanBarang = null;
                if (tambahPermintaanBarang == null) {
                    tambahPermintaanBarang = new TambahPB();
                }
                if (Cetak) {
                    directPrint.DirectPrint.directprinting(F.TestP.StPrint(JTNoPermintaanBarang.getText(), F.Variablebanking.Mechanik, F.Variablebanking.Pimpinan, "Di Print Oleh " + F.Variablebanking.SUsername + " Pada " + F.Datetostringwidthformat.getstringfromdate(new Date(), "dd/MM/yyyy HH:mm")));
                }
                if (!"admin".equals(F.Variablebanking.Slevel)) {
                    RunUpd runUpd = new RunUpd();
                    runUpd.setQuery("update tbpermintaanbarang set `print`='Yes' where NoPermintaanBarang='" + JTNoPermintaanBarang.getText() + "'");
                    runUpd.excute();
                }
                F.VarJFrame.menuPermintaanBarang.refresh();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Permintaan Barang Boleh Kosong !");
        }
    }
}

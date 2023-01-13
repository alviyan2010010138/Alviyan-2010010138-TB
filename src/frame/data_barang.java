/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import koneksi.koneksi; 

import java.awt.event.KeyEvent;

/**
 *
 * @author USER
 */
public final class data_barang extends javax.swing.JInternalFrame {

    /**
     * Creates new form data_kategori
     */
    
    public final Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    private Object tabmodeObject;
    private Object tabmode2;

    private void aktif() {
        txtKodeBarang.setEnabled(true);
        txtNamaBarang.setEnabled(true);
        txtKodeKategori.setEnabled(true);
        txtJumlahBarang.setEnabled(true);
        txtKeterangan.setEnabled(true);
    }

    protected void kosong() {
        tanggal();
        txtKodeBarang.setText(null);
        txtNamaBarang.setText(null);
        txtKodeKategori.setText(null);
        txtJumlahBarang.setText(null);
        txtKeterangan.setText(null);
    }

    public void noTable() {
        int Baris = tabmode.getRowCount();
        for (int a = 0; a < Baris; a++) {
            String nomor = String.valueOf(a + 1);
            tabmode.setValueAt(nomor + ".", a, 0);
        }
    }
    public void noTable2() {
        int Baris = tabmode.getRowCount();
        for (int a = 0; a < Baris; a++) {
            String nomor = String.valueOf(a + 1);
            tabmode.setValueAt(nomor + ".", a, 0);
        }
    }
    public void tanggal() {
        Date tgl = new Date();
        btnTanggal.setDate(tgl);
    }

    public void lebarKolom() {
        TableColumn kolom;
        tabelBarang.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        kolom = tabelBarang.getColumnModel().getColumn(0);
        kolom.setPreferredWidth(40);
        kolom = tabelBarang.getColumnModel().getColumn(1);
        kolom.setPreferredWidth(100);
        kolom = tabelBarang.getColumnModel().getColumn(2);
        kolom.setPreferredWidth(100);
        kolom = tabelBarang.getColumnModel().getColumn(3);
        kolom.setPreferredWidth(120);
        kolom = tabelBarang.getColumnModel().getColumn(4);
        kolom.setPreferredWidth(130);
    }

    public void lebarKolom2() {
        TableColumn column2;
        tabelKategori.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column2 = tabelKategori.getColumnModel().getColumn(0);
        column2.setPreferredWidth(40);
        column2 = tabelKategori.getColumnModel().getColumn(1);
        column2.setPreferredWidth(100);
        column2 = tabelKategori.getColumnModel().getColumn(2);
        column2.setPreferredWidth(100);
        column2 = tabelKategori.getColumnModel().getColumn(3);
        column2.setPreferredWidth(120);
        column2 = tabelKategori.getColumnModel().getColumn(4);
        column2.setPreferredWidth(130);
    }
    public void dataTable() {
        Object[] Baris = {"No", "Tanggal", "Kode Barang", "Nama Barang", "Kode Kategori", "Jumlah", "Keterangan"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelBarang.setModel(tabmode);
        String sql = "select * from tb_barang order by kode_barang asc";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String tanggal = hasil.getString("tanggal");
                String kode_barang = hasil.getString("kode_barang");
                String nama_barang = hasil.getString("nama_barang");
                String kode_kategori = hasil.getString("kode_kategori");
                String jumlah = hasil.getString("jumlah");
                String keterangan = hasil.getString("keterangan");
                String[] data = {"NO", tanggal, kode_barang, nama_barang, kode_kategori, jumlah, keterangan};
                tabmode.addRow(data);
                noTable();
                lebarKolom();
            }
        } catch (SQLException e) {
    }
    }
    public void pencarian(String sql) {
        Object[] Baris = {"No", "Tanggal", "Kode Barang", "Nama Barang", "Kode Kategori", "Jumlah", "Keterangan"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelBarang.setModel(tabmode);
        int brs = tabelBarang.getRowCount();
        for (int i = 0; 1 < brs; i++) {
            tabmode.removeRow(1);
        }
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String tanggal = hasil.getString("tanggal");
                String kode_barang = hasil.getString("kode_barang");
                String nama_barang = hasil.getString("nama_barang");
                String kode_kategori = hasil.getString("kode_kategori");
                String jumlah = hasil.getString("jumlah");
                String keterangan = hasil.getString("keterangan");
                String[] data = {"", tanggal, kode_barang, nama_barang, kode_kategori, jumlah, keterangan};
                tabmode.addRow(data);
                noTable();
            }
        } catch (SQLException e) {    
    }    
}
    public data_barang() {
        initComponents();
        dataTable();
        lebarKolom();
        aktif();
        tanggal();
        txtKodeBarang.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listKategori = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtCariKategori = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelKategori = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        dataUbah = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnTanggalUbah = new com.toedter.calendar.JDateChooser();
        txtKodeBarangUbah = new javax.swing.JTextField();
        txtNamaBarangUbah = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtKeteranganUbah = new javax.swing.JTextArea();
        btnTambahUbah = new javax.swing.JButton();
        btnCancelUbah = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        txtKodeKategoriUbah = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtJumlahBarangUbah = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnTanggal = new com.toedter.calendar.JDateChooser();
        txtKodeBarang = new javax.swing.JTextField();
        txtNamaBarang = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtKeterangan = new javax.swing.JTextArea();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnBersih = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtKodeKategori = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtJumlahBarang = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtCariBarang = new javax.swing.JTextField();
        btCari = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();

        listKategori.setTitle("List Data Kategori");

        jPanel6.setBackground(new java.awt.Color(204, 255, 204));

        jLabel13.setText("Cari Kategori");

        txtCariKategori.setName("pencarian2"); // NOI18N
        txtCariKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariKategoriActionPerformed(evt);
            }
        });
        txtCariKategori.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariKategoriKeyTyped(evt);
            }
        });

        tabelKategori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tabelKategori.setName("tabmode2"); // NOI18N
        tabelKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelKategoriMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabelKategori);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCariKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtCariKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout listKategoriLayout = new javax.swing.GroupLayout(listKategori.getContentPane());
        listKategori.getContentPane().setLayout(listKategoriLayout);
        listKategoriLayout.setHorizontalGroup(
            listKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        listKategoriLayout.setVerticalGroup(
            listKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dataUbah.setAlwaysOnTop(true);
        dataUbah.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dataUbah.setMinimumSize(new java.awt.Dimension(476, 547));
        dataUbah.setPreferredSize(new java.awt.Dimension(568, 396));
        dataUbah.setResizable(false);

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Kategori"));

        jLabel7.setText("Tanggal");

        jLabel8.setText("Kode Barang");

        jLabel9.setText("Nama Barang");

        jLabel10.setText("Keterangan");

        btnTanggalUbah.setDateFormatString("dd-MM-yyyy");

        txtKodeBarangUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodeBarangUbahActionPerformed(evt);
            }
        });
        txtKodeBarangUbah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKodeBarangUbahKeyPressed(evt);
            }
        });

        txtNamaBarangUbah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaBarangUbahKeyPressed(evt);
            }
        });

        txtKeteranganUbah.setColumns(20);
        txtKeteranganUbah.setRows(5);
        jScrollPane3.setViewportView(txtKeteranganUbah);

        btnTambahUbah.setText("Simpan");
        btnTambahUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahUbahActionPerformed(evt);
            }
        });
        btnTambahUbah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnTambahUbahKeyPressed(evt);
            }
        });

        btnCancelUbah.setText("Cancel");
        btnCancelUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelUbahActionPerformed(evt);
            }
        });

        jLabel20.setText("Kode Kategori");

        txtKodeKategoriUbah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKodeKategoriUbahKeyPressed(evt);
            }
        });

        jLabel21.setText("Jumlah");

        txtJumlahBarangUbah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtJumlahBarangUbahKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTanggalUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKodeBarangUbah)
                            .addComponent(txtNamaBarangUbah)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                            .addComponent(txtJumlahBarangUbah)
                            .addComponent(txtKodeKategoriUbah)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(btnTambahUbah)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel8))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnTanggalUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtKodeBarangUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNamaBarangUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKodeKategoriUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtJumlahBarangUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel10))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelUbah)
                    .addComponent(btnTambahUbah))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dataUbahLayout = new javax.swing.GroupLayout(dataUbah.getContentPane());
        dataUbah.getContentPane().setLayout(dataUbahLayout);
        dataUbahLayout.setHorizontalGroup(
            dataUbahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
            .addGroup(dataUbahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dataUbahLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        dataUbahLayout.setVerticalGroup(
            dataUbahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
            .addGroup(dataUbahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dataUbahLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Data Barang");

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setText("PENGOLAHAN DATA BARANG");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(402, 402, 402)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setForeground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Kategori"));

        jLabel2.setText("Tanggal");

        jLabel3.setText("Kode Barang");

        jLabel4.setText("Nama Barang");

        jLabel5.setText("Keterangan");

        btnTanggal.setDateFormatString("dd-MM-yyyy");

        txtKodeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodeBarangActionPerformed(evt);
            }
        });
        txtKodeBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKodeBarangKeyPressed(evt);
            }
        });

        txtNamaBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaBarangKeyPressed(evt);
            }
        });

        txtKeterangan.setColumns(20);
        txtKeterangan.setRows(5);
        jScrollPane1.setViewportView(txtKeterangan);

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnBersih.setText("Bersih");
        btnBersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBersihActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel11.setText("Kode Kategori");

        txtKodeKategori.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKodeKategoriKeyPressed(evt);
            }
        });

        jLabel12.setText("Jumlah");

        txtJumlahBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtJumlahBarangKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKodeBarang)
                            .addComponent(txtNamaBarang)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                            .addComponent(txtJumlahBarang)
                            .addComponent(txtKodeKategori)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBersih, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKodeKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtJumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUbah)
                    .addComponent(btnBersih)
                    .addComponent(btnHapus)
                    .addComponent(btnCancel)
                    .addComponent(btnTambah))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Kategori"));
        jPanel4.setPreferredSize(new java.awt.Dimension(451, 326));

        jLabel6.setText("Pencarian :");

        txtCariBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariBarangActionPerformed(evt);
            }
        });
        txtCariBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariBarangKeyTyped(evt);
            }
        });

        btCari.setText("Cari");
        btCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCariActionPerformed(evt);
            }
        });

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelBarang.setName("tabelBarang"); // NOI18N
        tabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBarangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelBarang);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtCariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btCari))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCari)
                    .addComponent(txtCariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtKodeBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKodeBarangKeyPressed
        // TODO add your handling code here:
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {    
        txtNamaBarang.requestFocus();
        }
    }//GEN-LAST:event_txtKodeBarangKeyPressed

    private void txtNamaBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaBarangKeyPressed
        // TODO add your handling code here:
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        txtKeterangan.requestFocus();
        }
    }//GEN-LAST:event_txtNamaBarangKeyPressed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        if (txtKodeBarang.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Barang tidak boleh kosong");
        } else if (txtNamaBarang.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Barang tidak boleh kosong");
        } else {
            String sql = "insert into tb_barang values (?,?,?,?,?,?)";
            String tampilan = "dd-MM-yyyy";
            SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            String tanggal = String.valueOf(fm.format(btnTanggal.getDate()));
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, tanggal);
                stat.setString(2, txtKodeBarang.getText());
                stat.setString(3, txtNamaBarang.getText());
                stat.setString(4, txtKodeKategori.getText());
                stat.setString(5, txtJumlahBarang.getText());
                stat.setString(6, txtKeterangan.getText());
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                kosong();
                dataTable();
                lebarKolom();
                txtKodeBarang.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan" + e);
            }
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMouseClicked
        // TODO add your handling code here:
        int bar = tabelBarang.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();

        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        Date dateValue = null;
        try {
            dateValue = date.parse((String) tabelBarang.getValueAt(bar, 1));
        } catch (ParseException ex) {
            Logger.getLogger(data_barang.class.getName()).log(Level.SEVERE, null, ex);
        }

        btnTanggal.setDate(dateValue);
        btnTanggalUbah.setDate(dateValue);
        txtKodeBarang.setText(c);
        txtKodeKategoriUbah.setText(c);
        txtNamaBarang.setText(d);
        txtNamaBarangUbah.setText(d);
        txtKeterangan.setText(e);
        txtKeteranganUbah.setText(e);
    }//GEN-LAST:event_tabelBarangMouseClicked

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        dataUbah.setLocationRelativeTo(this);
        txtKodeBarangUbah.setEditable(false);
        dataUbah.setVisible(true);
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnBersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBersihActionPerformed
        // TODO add your handling code here:
        tanggal();
        kosong();
    }//GEN-LAST:event_btnBersihActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, " Apakah Anda Yakin Ingin "
            + "Menghapus Data", "Konfirmasi Dialog", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String sql = "delete from tb_barang where kode_barang='" + txtKodeBarang.getText() + "'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                kosong();
                dataTable();
                lebarKolom();
                txtKodeBarang.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus" + e);
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtCariBarangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariBarangKeyTyped
        // TODO add your handling code here:
        String sqlPencarian = "select * from tb_barang where kode_barang like '%" + txtCariBarang.getText() + "%' or "
        + "nama_barang like '%" + txtCariBarang.getText() + "%' or "
        + "keterangan like '%" + txtCariBarang.getText() + "%'";
        pencarian(sqlPencarian);
        lebarKolom();
    }//GEN-LAST:event_txtCariBarangKeyTyped

    private void btCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCariActionPerformed
        // TODO add your handling code here:
        String sqlPencarian = "select * from tb_barang where kode_barang like '%" + txtCariBarang.getText() + "%' or "
        + "nama_barang like '%" + txtCariBarang.getText() + "%' or "
        + "keterangan like '%" + txtCariBarang.getText() + "%'";
        pencarian(sqlPencarian);
        lebarKolom();
    }//GEN-LAST:event_btCariActionPerformed

    private void txtKodeKategoriKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKodeKategoriKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeKategoriKeyPressed

    private void txtJumlahBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahBarangKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahBarangKeyPressed

    private void txtCariBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariBarangActionPerformed

    private void txtCariKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariKategoriActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtCariKategoriActionPerformed

    private void txtCariKategoriKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKategoriKeyTyped
        // TODO add your handling code here:
//            String sqlPencarian2 = "select * from tb_barang where kode_barang like '%" + txtCariBarang.getText() + "%' or "
//               + "nama_barang like '%" + txtCariBarang.getText() + "%'";
//                pencarian2(sqlPencarian2);
//                lebarKolom2();
//           }
    }//GEN-LAST:event_txtCariKategoriKeyTyped

    private void tabelKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKategoriMouseClicked
        // TODO add your handling code here:
        //int bar = tabelKategori.getSelectedRow();
        //String a = tabmode2.getValueAt(bar, 0).toString();
        //String b = tabmode2.getValueAt(bar, 1).toString();
        //String c = tabmode2.getValueAt(bar, 2).toString();

        //txtKodeKategori.setText(c);
        //listKategori.dispose();
        //txtJumlahBarang.requestFocus();
    }//GEN-LAST:event_tabelKategoriMouseClicked

    private void txtKodeBarangUbahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKodeBarangUbahKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeBarangUbahKeyPressed

    private void txtNamaBarangUbahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaBarangUbahKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaBarangUbahKeyPressed

    private void btnTambahUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahUbahActionPerformed
        // TODO add your handling code here:
        String sql = "update tb_barang set tanggal=?,kode_barang=?,nama_barang=?, kode_barang=?,jumlah=?,keterangan=? where kode_barang='" + txtKodeBarangUbah.getText() + "'";
        String tampilan = "dd-MM-yyyy";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(btnTanggalUbah.getDate()));
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, tanggal);
            stat.setString(2, txtKodeBarangUbah.getText());
            stat.setString(3, txtNamaBarangUbah.getText());
            stat.setString(4, txtKodeBarangUbah.getText());
            stat.setString(5, txtJumlahBarangUbah.getText());
            stat.setString(6, txtKeteranganUbah.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            kosong();
            dataTable();
            lebarKolom();
            txtKodeBarang.requestFocus();
            dataUbah.dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah" + e);
        }
    }//GEN-LAST:event_btnTambahUbahActionPerformed

    private void btnCancelUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelUbahActionPerformed
        // TODO add your handling code here:
        dataUbah.setVisible(false);
    }//GEN-LAST:event_btnCancelUbahActionPerformed

    private void txtKodeKategoriUbahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKodeKategoriUbahKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeKategoriUbahKeyPressed

    private void txtJumlahBarangUbahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahBarangUbahKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahBarangUbahKeyPressed

    private void txtKodeBarangUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodeBarangUbahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeBarangUbahActionPerformed

    private void btnTambahUbahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnTambahUbahKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTambahUbahKeyPressed

    private void txtKodeBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodeBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeBarangActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCari;
    private javax.swing.JButton btnBersih;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCancelUbah;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTambahUbah;
    private com.toedter.calendar.JDateChooser btnTanggal;
    private com.toedter.calendar.JDateChooser btnTanggalUbah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JDialog dataUbah;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JDialog listKategori;
    private javax.swing.JTable tabelBarang;
    private javax.swing.JTable tabelKategori;
    private javax.swing.JTextField txtCariBarang;
    private javax.swing.JTextField txtCariKategori;
    private javax.swing.JTextField txtJumlahBarang;
    private javax.swing.JTextField txtJumlahBarangUbah;
    private javax.swing.JTextArea txtKeterangan;
    private javax.swing.JTextArea txtKeteranganUbah;
    private javax.swing.JTextField txtKodeBarang;
    private javax.swing.JTextField txtKodeBarangUbah;
    private javax.swing.JTextField txtKodeKategori;
    private javax.swing.JTextField txtKodeKategoriUbah;
    private javax.swing.JTextField txtNamaBarang;
    private javax.swing.JTextField txtNamaBarangUbah;
    // End of variables declaration//GEN-END:variables
}
    

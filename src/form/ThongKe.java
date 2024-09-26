/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import DAO.*;
import static form.QuanLyMuon.choose;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import model.*;

/**
 *
 * @author minht
 */
public class ThongKe extends javax.swing.JFrame {
    DefaultTableModel tableModel = null;
    public int selectedIndex;
    /**
     * Creates new form ThongKe
     */
    public ThongKe() {
        initComponents();
        setTitle("Thống kê");
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new java.awt.Color(245,245,245));
        
        mainTabPanel.setSelectedIndex(0);
        
        if (selectedIndex == 0) {
           tableModel = (DefaultTableModel) tableSachDangMuon.getModel();
           tableSachDangMuon.setDefaultEditor(Object.class, null);
           showDataSachMuon();
        }
        
        inputAnotherChoose.setVisible(false);
        
        
        inputAnotherChoose.addPropertyChangeListener(new PropertyChangeListener (){
            @Override
            public void propertyChange(PropertyChangeEvent evt){
                if(selectedIndex == 0) {
                    if("date".equals(evt.getPropertyName())) {
                    Date selectedDate = (Date) evt.getNewValue();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String newDate = dateFormat.format(selectedDate.getTime());
                    // Thực hiện xử lý sau khi người dùng thay đổi ngày
                    tableModel = (DefaultTableModel) tableSachDangMuon.getModel();
                     tableModel.setRowCount(0); 
                   
        
                    ArrayList<SachMuonTK> listSach = SachMuonTKDAO.getInstance().selectByCondition(newDate,4);
                    tableModel.setRowCount(0);
                    listSach.forEach((sm) -> {
                    tableModel.addRow(new Object[] {sm.getMaM(), sm.getISBN(), sm.getMaSach(),sm.getNamXB(),sm.getNgayHetHan()});
                    });

                    
                    if (tableSachDangMuon.getRowCount() == 0) {
                        JOptionPane.showMessageDialog(null, "Không có dữ liệu"); 
                        showDataSachMuon();
                    }
                  }
                }
                 if(selectedIndex == 2) {
                    if("date".equals(evt.getPropertyName())) {
                    Date selectedDate = (Date) evt.getNewValue();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String newDate = dateFormat.format(selectedDate.getTime());
                    // Thực hiện xử lý sau khi người dùng thay đổi ngày
                    tableModel = (DefaultTableModel) tableMuonQuaHan.getModel();
                     tableModel.setRowCount(0); 
                   
        
                     ArrayList<PhieuMuonTK> listPM = PhieuMuonTKDAO.getInstance().selectByCondition(newDate, 4);
                       tableModel.setRowCount(0);
                       listPM.forEach((pm) -> {
                          tableModel.addRow(new Object[] {pm.getMaM(), pm.getMaDG(), pm.getMaTT(),pm.getNgayMuon(),pm.getNgayHetHan(),pm.getSoLuongMuon(),pm.getGhiChu(),pm.getSoNgayTre()});
                      });

                   if (tableMuonQuaHan.getRowCount() == 0) {
                       JOptionPane.showMessageDialog(null, "Không có dữ liệu");
                                       showDataPMTK();

                   }
                  }
                }
                if(selectedIndex == 3){
                  if("date".equals(evt.getPropertyName())) {
                    Date selectedDate = (Date) evt.getNewValue();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String newDate = dateFormat.format(selectedDate.getTime());
                     tableModel = (DefaultTableModel) tableDG.getModel();
            tableModel.setRowCount(0);
            
            ArrayList<DocGia> listDG = DocGiaDAO.getInstance().selectByCondition(newDate, 4);
            tableModel.setRowCount(0);
            listDG.forEach((DG) -> {
               tableModel.addRow(new Object[] {DG.getMaDG(), DG.getHoTenDG(), DG.getNgaySinhDG(),DG.getGioiTinhDG(),DG.getDienThoaiDG(),DG.getDiaChiDG(),DG.getDoiTuong()});
           });
            
             if (tableDG.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu");
                showDataDG();
                    }
                }
             }
//                else {
//                   if("date".equals(evt.getPropertyName())) {
//                    Date selectedDate = (Date) evt.getNewValue();
//                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                    String newDate = dateFormat.format(selectedDate.getTime());
//                    // Thực hiện xử lý sau khi người dùng thay đổi ngày
//                    tableModel = (DefaultTableModel) table.getModel();
//                     tableModel.setRowCount(0); 
//                   
//        
//                    listPM = PhieuMuonToHopDAO.getInstance().selectByCondition(newDate,3);
//                    tableModel.setRowCount(0);
//                    listPM.forEach((pm) -> {
//                        tableModel.addRow(new Object[] {pm.getMaM(), pm.getHoTen(), pm.getNgayMuon(),pm.getNgayHetHan(),pm.getSoLuong(),pm.getGhiChu()});
//                     });
//                    
//                    if (table.getRowCount() == 0) {
//                        JOptionPane.showMessageDialog(null, "Không có dữ liệu");  
//                        showData();
//
//                    }
//                    
//                    } 
//                }
            }
        });
        
        
         ChangeListener tabChangeListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                 selectedIndex = mainTabPanel.getSelectedIndex();
                 if (selectedIndex == 0) {
                     tableModel = (DefaultTableModel) tableSachDangMuon.getModel();
                  tableSachDangMuon.setDefaultEditor(Object.class, null);
                    showDataSachMuon();
                     defChoice();
                } else if (selectedIndex == 1) {
                    tableModel = (DefaultTableModel) tableSachMuon.getModel();
                  tableSachMuon.setDefaultEditor(Object.class, null);
                  showDataSachNotMuon();
                  setChoice();
                } else if (selectedIndex == 2) {
                    // Code to handle tab 3 selection
                   tableModel = (DefaultTableModel) tableMuonQuaHan.getModel();
                  tableMuonQuaHan.setDefaultEditor(Object.class, null);
                    showDataPMTK();
                    defChoice();
                    
                } else if(selectedIndex == 3) {
                  tableModel = (DefaultTableModel) tableDG.getModel();
                  tableDG.setDefaultEditor(Object.class, null);
                  showDataDG();
                   defChoice();

                }
                
                // Add your event handling code here for the selected tab.
                // For example, you can update UI components or perform actions specific to the tab.
            }
        };
         
          mainTabPanel.addChangeListener(tabChangeListener);

    }
    
    public void defChoice(){
                  monthChoose.setEnabled(true);
                  yearChoice.setEnabled(true);
                  lastyearChoice.setEnabled(true);
                  anotherChoose.setEnabled(true);
    }
    
    public void setChoice(){
                  monthChoose.setEnabled(false);
                  yearChoice.setEnabled(false);
                  lastyearChoice.setEnabled(false);
                  anotherChoose.setEnabled(false);
    }
    
    public void showDataSachNotMuon(){
         ArrayList<SachTK> listS = SachTKDAO.getInstance().selectAll();
         tableModel.setRowCount(0);
         listS.forEach((s) -> {
            tableModel.addRow(new Object[] {s.getISBN(), s.getMaSach(), s.getTenSach(),s.getTacGia(),s.getNXB(),s.getNamXB(),s.getThongTinSach()});
        });

    }
    
    public void showDataDG(){
         ArrayList<DocGia> listDG = DocGiaDAO.getInstance().selectAllForTK();
         tableModel.setRowCount(0);
         listDG.forEach((DG) -> {
            tableModel.addRow(new Object[] {DG.getMaDG(), DG.getHoTenDG(), DG.getNgaySinhDG(),DG.getGioiTinhDG(),DG.getDienThoaiDG(),DG.getDiaChiDG(),DG.getDoiTuong()});
        });

    }
    
    public void showDataPMTK(){
         ArrayList<PhieuMuonTK> listPM = PhieuMuonTKDAO.getInstance().selectAll();
         tableModel.setRowCount(0);
         listPM.forEach((pm) -> {
            tableModel.addRow(new Object[] {pm.getMaM(), pm.getMaDG(), pm.getMaTT(),pm.getNgayMuon(),pm.getNgayHetHan(),pm.getSoLuongMuon(),pm.getGhiChu(),pm.getSoNgayTre()});
        });
    }
    
    public void showDataSachMuon(){
       ArrayList<SachMuonTK> listPM = SachMuonTKDAO.getInstance().selectAll();
         tableModel.setRowCount(0);
         listPM.forEach((sm) -> {
            tableModel.addRow(new Object[] {sm.getMaM(), sm.getISBN(), sm.getMaSach(),sm.getNamXB(),sm.getNgayHetHan()});
        }); 
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        filterPanel = new javax.swing.JPanel();
        monthChoose = new javax.swing.JRadioButton();
        anotherChoose = new javax.swing.JRadioButton();
        yearChoice = new javax.swing.JRadioButton();
        lastyearChoice = new javax.swing.JRadioButton();
        inputAnotherChoose = new com.toedter.calendar.JDateChooser();
        mainTabPanel = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSachDangMuon = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableSachMuon = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableMuonQuaHan = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDG = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        mainBtn = new javax.swing.JButton();
        thoatBtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuMain = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuDG = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        menuTheDG = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuQuanLyTT = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuQuanLyDauSach = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        menuNhapSach = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        menuThemPN = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        menuNhaCC = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        menuQuanLyMuon = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        menuThemPhieuMuon = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuQuanLyPhieuTra = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        menuQuanLyThemPT = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        menuThongKe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel6.setBackground(new java.awt.Color(27, 70, 139));
        jPanel6.setPreferredSize(new java.awt.Dimension(0, 20));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(252, 252, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(27, 70, 139));
        jLabel10.setText("TRƯỜNG ĐẠI HỌC TÀI CHÍNH MARKETING");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(27, 70, 139));
        jLabel11.setText("THƯ VIỆN");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(70, 67));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thuvien/img/miniLogo.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jPanel8.setBackground(new java.awt.Color(27, 70, 139));
        jPanel8.setPreferredSize(new java.awt.Dimension(0, 20));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(27, 70, 139));
        jLabel12.setText("Lọc theo ngày");

        filterPanel.setBackground(new java.awt.Color(245, 245, 245));
        filterPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        filterPanel.setPreferredSize(new java.awt.Dimension(310, 200));

        buttonGroup1.add(monthChoose);
        monthChoose.setText("Tháng hiện tại");
        monthChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthChooseActionPerformed(evt);
            }
        });

        buttonGroup1.add(anotherChoose);
        anotherChoose.setText("Lựa chọn khác");
        anotherChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anotherChooseActionPerformed(evt);
            }
        });

        buttonGroup1.add(yearChoice);
        yearChoice.setText("Năm hiện tại");
        yearChoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearChoiceActionPerformed(evt);
            }
        });

        buttonGroup1.add(lastyearChoice);
        lastyearChoice.setText("Năm trước");
        lastyearChoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastyearChoiceActionPerformed(evt);
            }
        });

        inputAnotherChoose.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout filterPanelLayout = new javax.swing.GroupLayout(filterPanel);
        filterPanel.setLayout(filterPanelLayout);
        filterPanelLayout.setHorizontalGroup(
            filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterPanelLayout.createSequentialGroup()
                .addGroup(filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filterPanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(inputAnotherChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(filterPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(monthChoose, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(yearChoice, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(anotherChoose, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastyearChoice, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        filterPanelLayout.setVerticalGroup(
            filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(monthChoose)
                .addGap(18, 18, 18)
                .addComponent(yearChoice)
                .addGap(18, 18, 18)
                .addComponent(lastyearChoice)
                .addGap(18, 18, 18)
                .addComponent(anotherChoose)
                .addGap(18, 18, 18)
                .addComponent(inputAnotherChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainTabPanel.setBackground(new java.awt.Color(27, 70, 139));
        mainTabPanel.setForeground(new java.awt.Color(255, 255, 255));
        mainTabPanel.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tableSachDangMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Mượn", "ISBN", "Mã Sách", "Năm Xuất Bản", "Ngày Hết Hạn"
            }
        ));
        tableSachDangMuon.setRowHeight(40);
        jScrollPane1.setViewportView(tableSachDangMuon);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        mainTabPanel.addTab("Sách đang mượn", jPanel2);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tableSachMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ISBN", "Mã Sách", "Tên Sách", "Tác Giả", "Nhà Xuất Bản", "Năm Xuất Bản", "Thông Tin Sách"
            }
        ));
        tableSachMuon.setRowHeight(40);
        jScrollPane4.setViewportView(tableSachMuon);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        mainTabPanel.addTab("Sách chưa mượn", jPanel5);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tableMuonQuaHan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Mượn", "Mã Độc Giả", "Mã Thủ Thư", "Ngày Mượn", "Ngày Hết Hạn", "Số Lượng Mượn", "Ghi Chú", "Số Ngày Trễ"
            }
        ));
        tableMuonQuaHan.setRowHeight(40);
        jScrollPane3.setViewportView(tableMuonQuaHan);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        mainTabPanel.addTab("Mượn quá hạn", jPanel4);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tableDG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Độc Giả", "Họ Tên ", "Ngày Sinh", "Giới Tính", "Điện Thoại ", "Địa Chỉ", "Đối Tượng"
            }
        ));
        tableDG.setRowHeight(40);
        jScrollPane2.setViewportView(tableDG);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        mainTabPanel.addTab("Độc giả đang mượn", jPanel3);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(27, 70, 139));
        jLabel2.setText("THỐNG KÊ");

        mainBtn.setText("Trang chủ");
        mainBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainBtnActionPerformed(evt);
            }
        });

        thoatBtn.setText("Thoát");
        thoatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thoatBtnActionPerformed(evt);
            }
        });

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setOpaque(true);

        jMenu1.setText("Tiện ích");
        jMenu1.setMargin(new java.awt.Insets(3, 12, 3, 12));

        menuMain.setText("Trang chủ");
        menuMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMainActionPerformed(evt);
            }
        });
        jMenu1.add(menuMain);
        jMenu1.add(jSeparator2);

        jMenuItem8.setText("Giới thiệu");
        jMenu1.add(jMenuItem8);
        jMenu1.add(jSeparator3);

        jMenuItem9.setText("Thông tin liên hệ");
        jMenu1.add(jMenuItem9);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Quản lý độc giả");
        jMenu2.setMargin(new java.awt.Insets(3, 12, 3, 12));

        menuDG.setText("Danh sách độc giả");
        menuDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDGActionPerformed(evt);
            }
        });
        jMenu2.add(menuDG);
        jMenu2.add(jSeparator4);

        menuTheDG.setText("Danh sách thẻ độc giả");
        menuTheDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTheDGActionPerformed(evt);
            }
        });
        jMenu2.add(menuTheDG);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Quản lý thu thư");
        jMenu3.setMargin(new java.awt.Insets(3, 12, 3, 12));

        menuQuanLyTT.setText("Danh mục thủ thư");
        menuQuanLyTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuQuanLyTTActionPerformed(evt);
            }
        });
        jMenu3.add(menuQuanLyTT);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Quản lý sách");
        jMenu4.setMargin(new java.awt.Insets(3, 12, 3, 12));

        menuQuanLyDauSach.setText("Danh mục đầu sách");
        menuQuanLyDauSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuQuanLyDauSachActionPerformed(evt);
            }
        });
        jMenu4.add(menuQuanLyDauSach);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Quản lý nhập sách");
        jMenu5.setMargin(new java.awt.Insets(3, 12, 3, 12));

        menuNhapSach.setText("Danh mục nhập sách");
        menuNhapSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNhapSachActionPerformed(evt);
            }
        });
        jMenu5.add(menuNhapSach);
        jMenu5.add(jSeparator6);

        menuThemPN.setText("Thêm Phiếu nhập");
        menuThemPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuThemPNActionPerformed(evt);
            }
        });
        jMenu5.add(menuThemPN);
        jMenu5.add(jSeparator5);

        menuNhaCC.setText("Danh mục nhà cung cấp");
        menuNhaCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNhaCCActionPerformed(evt);
            }
        });
        jMenu5.add(menuNhaCC);

        jMenuBar1.add(jMenu5);

        jMenu7.setText("Quản lý mượn - trả");
        jMenu7.setMargin(new java.awt.Insets(3, 12, 3, 12));

        menuQuanLyMuon.setText("Danh sách mượn");
        menuQuanLyMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuQuanLyMuonActionPerformed(evt);
            }
        });
        jMenu7.add(menuQuanLyMuon);
        jMenu7.add(jSeparator7);

        menuThemPhieuMuon.setText("Thêm phiếu mượn");
        menuThemPhieuMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuThemPhieuMuonActionPerformed(evt);
            }
        });
        jMenu7.add(menuThemPhieuMuon);
        jMenu7.add(jSeparator1);

        menuQuanLyPhieuTra.setText("Danh sách trả");
        menuQuanLyPhieuTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuQuanLyPhieuTraActionPerformed(evt);
            }
        });
        jMenu7.add(menuQuanLyPhieuTra);
        jMenu7.add(jSeparator8);

        menuQuanLyThemPT.setText("Thêm phiếu trả");
        menuQuanLyThemPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuQuanLyThemPTActionPerformed(evt);
            }
        });
        jMenu7.add(menuQuanLyThemPT);

        jMenuBar1.add(jMenu7);

        jMenu8.setText("Tổng thống kê");
        jMenu8.setMargin(new java.awt.Insets(3, 12, 3, 12));

        menuThongKe.setText("Thống kê");
        menuThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuThongKeActionPerformed(evt);
            }
        });
        jMenu8.add(menuThongKe);

        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mainTabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12)))
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainBtn)
                .addGap(26, 26, 26)
                .addComponent(thoatBtn)
                .addGap(63, 63, 63))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mainTabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(thoatBtn)
                    .addComponent(mainBtn))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void monthChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthChooseActionPerformed
        // TODO add your handling code here:
        inputAnotherChoose.setVisible(false);

        if(monthChoose.isSelected() && selectedIndex == 0){
            tableModel = (DefaultTableModel) tableSachDangMuon.getModel();
            tableModel.setRowCount(0);
            ArrayList<SachMuonTK> listSach = SachMuonTKDAO.getInstance().selectByCondition("",1);
            tableModel.setRowCount(0);
            listSach.forEach((sm) -> {
            tableModel.addRow(new Object[] {sm.getMaM(), sm.getISBN(), sm.getMaSach(),sm.getNamXB(),sm.getNgayHetHan()});
            });

            if (tableSachDangMuon.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu");
                showDataSachMuon();
            }
        }
        if (monthChoose.isSelected() && selectedIndex ==2) {
            tableModel = (DefaultTableModel) tableMuonQuaHan.getModel();
            tableModel.setRowCount(0);
            ArrayList<PhieuMuonTK> listPM = PhieuMuonTKDAO.getInstance().selectByCondition("", 1);
                tableModel.setRowCount(0);
                listPM.forEach((pm) -> {
                   tableModel.addRow(new Object[] {pm.getMaM(), pm.getMaDG(), pm.getMaTT(),pm.getNgayMuon(),pm.getNgayHetHan(),pm.getSoLuongMuon(),pm.getGhiChu(),pm.getSoNgayTre()});
               });

            if (tableMuonQuaHan.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu");
                showDataPMTK();
            }
        }
        
        if(monthChoose.isSelected() && selectedIndex == 3){
            tableModel = (DefaultTableModel) tableDG.getModel();
            tableModel.setRowCount(0);
            
            ArrayList<DocGia> listDG = DocGiaDAO.getInstance().selectByCondition("", 1);
            tableModel.setRowCount(0);
            listDG.forEach((DG) -> {
               tableModel.addRow(new Object[] {DG.getMaDG(), DG.getHoTenDG(), DG.getNgaySinhDG(),DG.getGioiTinhDG(),DG.getDienThoaiDG(),DG.getDiaChiDG(),DG.getDoiTuong()});
           });
            
             if (tableDG.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu");
                showDataDG();
            }
        }

    }//GEN-LAST:event_monthChooseActionPerformed

    private void anotherChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anotherChooseActionPerformed
        // TODO add your handling code here:
        if(anotherChoose.isSelected()){
            inputAnotherChoose.setVisible(true);
        }
    }//GEN-LAST:event_anotherChooseActionPerformed

    private void yearChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearChoiceActionPerformed
        // TODO add your handling code here:
        inputAnotherChoose.setVisible(false);

        if(yearChoice.isSelected() && selectedIndex == 0){
            tableModel = (DefaultTableModel) tableSachDangMuon.getModel();
            tableModel.setRowCount(0);
            ArrayList<SachMuonTK> listSach = SachMuonTKDAO.getInstance().selectByCondition("",2);
            tableModel.setRowCount(0);
            listSach.forEach((sm) -> {
                tableModel.addRow(new Object[] {sm.getMaM(), sm.getISBN(), sm.getMaSach(),sm.getNamXB(),sm.getNgayHetHan()});
            });

            if (tableSachDangMuon.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu");
                showDataSachMuon();
            }
        }
        
        if (yearChoice.isSelected() && selectedIndex ==2) {
            tableModel = (DefaultTableModel) tableMuonQuaHan.getModel();
            tableModel.setRowCount(0);
            ArrayList<PhieuMuonTK> listPM = PhieuMuonTKDAO.getInstance().selectByCondition("", 2);
                tableModel.setRowCount(0);
                listPM.forEach((pm) -> {
                   tableModel.addRow(new Object[] {pm.getMaM(), pm.getMaDG(), pm.getMaTT(),pm.getNgayMuon(),pm.getNgayHetHan(),pm.getSoLuongMuon(),pm.getGhiChu(),pm.getSoNgayTre()});
               });

            if (tableMuonQuaHan.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu");
                                showDataPMTK();

            }
        }
        
        if(yearChoice.isSelected() && selectedIndex == 3){
            tableModel = (DefaultTableModel) tableDG.getModel();
            tableModel.setRowCount(0);
            
            ArrayList<DocGia> listDG = DocGiaDAO.getInstance().selectByCondition("", 2);
            tableModel.setRowCount(0);
            listDG.forEach((DG) -> {
               tableModel.addRow(new Object[] {DG.getMaDG(), DG.getHoTenDG(), DG.getNgaySinhDG(),DG.getGioiTinhDG(),DG.getDienThoaiDG(),DG.getDiaChiDG(),DG.getDoiTuong()});
           });
            
             if (tableDG.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu");
                showDataDG();
            }
        }
        
    }//GEN-LAST:event_yearChoiceActionPerformed

    private void lastyearChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastyearChoiceActionPerformed
        // TODO add your handling code here:
        inputAnotherChoose.setVisible(false);

        if(lastyearChoice.isSelected() && selectedIndex == 0){
            tableModel = (DefaultTableModel) tableSachDangMuon.getModel();
            tableModel.setRowCount(0);
            ArrayList<SachMuonTK> listSach = SachMuonTKDAO.getInstance().selectByCondition("",3);
            tableModel.setRowCount(0);
            listSach.forEach((sm) -> {
                tableModel.addRow(new Object[] {sm.getMaM(), sm.getISBN(), sm.getMaSach(),sm.getNamXB(),sm.getNgayHetHan()});
            });

            if (tableSachDangMuon.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu");
                showDataSachMuon();
            }
        }
        
         if (lastyearChoice.isSelected() && selectedIndex ==2) {
            tableModel = (DefaultTableModel) tableMuonQuaHan.getModel();
            tableModel.setRowCount(0);
            ArrayList<PhieuMuonTK> listPM = PhieuMuonTKDAO.getInstance().selectByCondition("", 3);
                tableModel.setRowCount(0);
                listPM.forEach((pm) -> {
                   tableModel.addRow(new Object[] {pm.getMaM(), pm.getMaDG(), pm.getMaTT(),pm.getNgayMuon(),pm.getNgayHetHan(),pm.getSoLuongMuon(),pm.getGhiChu(),pm.getSoNgayTre()});
               });

            if (tableMuonQuaHan.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu");
                               showDataPMTK();

            }
        }
         
         if(lastyearChoice.isSelected() && selectedIndex == 3){
            tableModel = (DefaultTableModel) tableDG.getModel();
            tableModel.setRowCount(0);
            
            ArrayList<DocGia> listDG = DocGiaDAO.getInstance().selectByCondition("", 3);
            tableModel.setRowCount(0);
            listDG.forEach((DG) -> {
               tableModel.addRow(new Object[] {DG.getMaDG(), DG.getHoTenDG(), DG.getNgaySinhDG(),DG.getGioiTinhDG(),DG.getDienThoaiDG(),DG.getDiaChiDG(),DG.getDoiTuong()});
           });
            
             if (tableDG.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu");
                showDataDG();
            }
        }
    }//GEN-LAST:event_lastyearChoiceActionPerformed

    private void mainBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainBtnActionPerformed
        // TODO add your handling code here:
        Main main = new Main();
        setVisible(false);
    }//GEN-LAST:event_mainBtnActionPerformed

    private void thoatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thoatBtnActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_thoatBtnActionPerformed

    private void menuMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMainActionPerformed
        // TODO add your handling code here:
        Main main = new Main();
        setVisible(false);
    }//GEN-LAST:event_menuMainActionPerformed

    private void menuDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDGActionPerformed
        // TODO add your handling code here:
        QuanLyDG mainDG = new QuanLyDG();
        setVisible(false);
    }//GEN-LAST:event_menuDGActionPerformed

    private void menuTheDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTheDGActionPerformed
        // TODO add your handling code here:
        QuanLyThe mainThe = new QuanLyThe();
        setVisible(false);
    }//GEN-LAST:event_menuTheDGActionPerformed

    private void menuQuanLyTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuQuanLyTTActionPerformed
        // TODO add your handling code here:
        QuanLyThuThu mainTT = new QuanLyThuThu();
        setVisible(false);
    }//GEN-LAST:event_menuQuanLyTTActionPerformed

    private void menuQuanLyDauSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuQuanLyDauSachActionPerformed
        // TODO add your handling code here:
        QuanLyDauSach mainQuanLyDauSach = new QuanLyDauSach();
        setVisible(false);
    }//GEN-LAST:event_menuQuanLyDauSachActionPerformed

    private void menuNhapSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNhapSachActionPerformed
        // TODO add your handling code here:
        QuanLyPhieuNhap mainLyPhieuNhap = new QuanLyPhieuNhap();
        setVisible(false);
    }//GEN-LAST:event_menuNhapSachActionPerformed

    private void menuThemPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuThemPNActionPerformed
        // TODO add your handling code here:
        QuanLyThemPN menQuanLyThemPN = new QuanLyThemPN();
        setVisible(false);
    }//GEN-LAST:event_menuThemPNActionPerformed

    private void menuNhaCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNhaCCActionPerformed
        // TODO add your handling code here:
        QuanLyNhaCungCap mainNCC = new QuanLyNhaCungCap();
        setVisible(false);
    }//GEN-LAST:event_menuNhaCCActionPerformed

    private void menuQuanLyMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuQuanLyMuonActionPerformed
        // TODO add your handling code here:
        QuanLyMuon mainMuon = new QuanLyMuon();
        setVisible(false);
    }//GEN-LAST:event_menuQuanLyMuonActionPerformed

    private void menuThemPhieuMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuThemPhieuMuonActionPerformed
        // TODO add your handling code here:
        QuanLyThemPM mainThemPM = new QuanLyThemPM();
        setVisible(false);
    }//GEN-LAST:event_menuThemPhieuMuonActionPerformed

    private void menuQuanLyPhieuTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuQuanLyPhieuTraActionPerformed
        // TODO add your handling code here:
        QuanLyPhieuTra mainQuanLyPhieuTra = new QuanLyPhieuTra();
        setVisible(false);
    }//GEN-LAST:event_menuQuanLyPhieuTraActionPerformed

    private void menuQuanLyThemPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuQuanLyThemPTActionPerformed
        // TODO add your handling code here:
        QuanLyThemPT mainThemPT = new QuanLyThemPT();
        setVisible(false);
    }//GEN-LAST:event_menuQuanLyThemPTActionPerformed

    private void menuThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuThongKeActionPerformed
        // TODO add your handling code here:
        ThongKe mainTk = new ThongKe();
        setVisible(false);
    }//GEN-LAST:event_menuThongKeActionPerformed

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
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton anotherChoose;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel filterPanel;
    private com.toedter.calendar.JDateChooser inputAnotherChoose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JRadioButton lastyearChoice;
    private javax.swing.JButton mainBtn;
    private javax.swing.JTabbedPane mainTabPanel;
    private javax.swing.JMenuItem menuDG;
    private javax.swing.JMenuItem menuMain;
    private javax.swing.JMenuItem menuNhaCC;
    private javax.swing.JMenuItem menuNhapSach;
    private javax.swing.JMenuItem menuQuanLyDauSach;
    private javax.swing.JMenuItem menuQuanLyMuon;
    private javax.swing.JMenuItem menuQuanLyPhieuTra;
    private javax.swing.JMenuItem menuQuanLyTT;
    private javax.swing.JMenuItem menuQuanLyThemPT;
    private javax.swing.JMenuItem menuTheDG;
    private javax.swing.JMenuItem menuThemPN;
    private javax.swing.JMenuItem menuThemPhieuMuon;
    private javax.swing.JMenuItem menuThongKe;
    private javax.swing.JRadioButton monthChoose;
    private javax.swing.JTable tableDG;
    private javax.swing.JTable tableMuonQuaHan;
    private javax.swing.JTable tableSachDangMuon;
    private javax.swing.JTable tableSachMuon;
    private javax.swing.JButton thoatBtn;
    private javax.swing.JRadioButton yearChoice;
    // End of variables declaration//GEN-END:variables
}

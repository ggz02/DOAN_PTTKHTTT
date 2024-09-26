/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

//import DAO.CTPhieuNhapDAO;
//import DAO.DocGiaDAO;
//import DAO.NhaCungCapDAO;
//import DAO.PhieuNhapDAO;
//import DAO.PhieuNhapToHopDAO;
//import DAO.TheThuVienDAO;
//import com.toedter.calendar.JDateChooser;
//import java.awt.BorderLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.SwingUtilities;
//import javax.swing.table.DefaultTableModel;
//import model.CTPhieuNhap;
//import model.DocGia;
//import model.NhaCungCap;
//import model.PhieuNhap;
//import model.PhieuNhapToHop;
//import model.TheThuVien;
import DAO.CTPhieuNhapDAO;
import DAO.DauSachDAO;
import DAO.PhieuMuonDAO;
import DAO.PhieuMuonToHopDAO;
import DAO.SachDAO;
import DAO.TheLoaiDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.CTPhieuNhap;
import model.DauSach;
import model.PhieuMuon;
import model.PhieuMuonToHop;
import model.Sach;
import model.TheLoai;

/**
 *
 * @author minht
 */
public class NewClass {
    public static void main(String[] args) {
//        TheThuVien ttv = new TheThuVien("TTV21", "DG021", "2027-12-30");
//        TheThuVienDAO.getInstance().delete(ttv);



//Calendar cal = Calendar.getInstance();
//SimpleDateFormat dateOnly = new SimpleDateFormat("yyyy-MM-dd");
//String date = dateOnly.format(cal.getTime());
////
//            ArrayList<Sach> listPN = SachDAO.getInstance().selectByConditionNamXB("08667");
//            for (Sach ncc : listPN) {
//                System.out.println(ncc.getNamXB());
//            }
            
//            String MaSach ="";
//            ArrayList<PhieuMuonToHop> listMM = PhieuMuonToHopDAO.getInstance().selectNameDGNotInPT();
//        for (PhieuMuonToHop pm : listMM) {
//            System.out.print(pm.getHoTen());
//        }

        ArrayList<TheLoai> listTl = TheLoaiDAO.getInstance().selectTenLoaiSach("",1);
        for (TheLoai theLoai : listTl) {
            System.out.println(theLoai.getTenLoai());

        }
//       

//            LocalDate today = LocalDate.now();
//            int month = today.getMonthValue();
//            System.out.println(month);



        
        
//                String msDG = "";
//                String splitMaDG ="";
//                int newMaDGInt;
//                String newMaDGString ="";
//                ArrayList<DocGia> listNewMaDG = DocGiaDAO.getInstance().selectNewMaDG();
//                for (DocGia docGia : listNewMaDG) {
//                    msDG = docGia.getMaDG();
//                    System.out.println(msDG);
//                }
//                splitMaDG = msDG.substring(2);
//                newMaDGInt = Integer.valueOf(splitMaDG) +1;
//                                    System.out.println(newMaDGInt);
//
//                if (newMaDGInt > 10) {
//                   newMaDGString = "DG0" + Integer.toString(newMaDGInt);
//                } else if (newMaDGInt > 100) {
//                   newMaDGString = "DG" + Integer.toString(newMaDGInt);
//                }

//            String maNCC = "";
//            String splitMaNCC ="";
//            int newMaNCCInt;
//            String newMaNCCString ="";
//            ArrayList<NhaCungCap> listNewMaNCC = NhaCungCapDAO.getInstance().selectNewMaNCC();
//            for (NhaCungCap ncc : listNewMaNCC) {
//                maNCC = ncc.getMaNCC();
//            }
//            splitMaNCC = maNCC.substring(3);
//            newMaNCCInt = Integer.valueOf(splitMaNCC) +1;
//            if (newMaNCCInt > 10) {
//                newMaNCCString = "NCC0" + Integer.toString(newMaNCCInt);
//            } else if (newMaNCCInt > 100) {
//                newMaNCCString = "NCC" + Integer.toString(newMaNCCInt);
//            } else {
//                newMaNCCString = "NCC00" + Integer.toString(newMaNCCInt);
//            }
//            System.out.println(newMaNCCString);
    
//            DateFormat dateFormatNgayTao = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
//            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//            Date date = new Date();
//            String NgayTao = dateFormat.format(date);
//            System.out.println(NgayTao);

//            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//            String newYear = Integer.toString(Calendar.getInstance().get(Calendar.YEAR) + 4);
//            LocalDate myDate = LocalDate.parse(newYear + "-12-30");
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//            String formattedString = myDate.format(formatter);
//            System.out.println(formattedString);public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            JFrame frame = new JFrame("JTable Add Row Example");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            
//            DefaultTableModel tableModel = new DefaultTableModel();
//            tableModel.addColumn("STT");
//            tableModel.addColumn("Tên");
//            tableModel.addColumn("Số lượng");
//            
//            JTable table = new JTable(tableModel);
//            
//            JButton addButton = new JButton("Thêm dòng");
//            addButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    int rowCount = tableModel.getRowCount();
//                    Object[] newRow = {rowCount + 1, "Sản phẩm mới", 0};
//                    tableModel.addRow(newRow);
//                }
//            });
//            
//            frame.setLayout(new BorderLayout());
//            frame.add(new JScrollPane(table), BorderLayout.CENTER);
//            frame.add(addButton, BorderLayout.SOUTH);
//            
//            frame.pack();
//            frame.setVisible(true);
//        });
//    }
    
//      public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            JFrame frame = new JFrame("JTable Quantity Button Example");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//            DefaultTableModel tableModel = new DefaultTableModel();
//            tableModel.addColumn("STT");
//            tableModel.addColumn("Tên");
//            tableModel.addColumn("Số lượng");
//
//            JTable table = new JTable(tableModel);
//            table.getColumn("Số lượng").setCellRenderer(new QuantityButtonRenderer());
//            table.getColumn("Số lượng").setCellEditor(new QuantityButtonEditor(tableModel));
//
//            JButton addButton = new JButton("Thêm dòng");
//            addButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    int rowCount = tableModel.getRowCount();
//                    Object[] newRow = {rowCount + 1, "Sản phẩm mới", 0};
//                    tableModel.addRow(newRow);
//                }
//            });
//
//            frame.setLayout(new BorderLayout());
//            frame.add(new JScrollPane(table), BorderLayout.CENTER);
//            frame.add(addButton, BorderLayout.SOUTH);
//
//            frame.pack();
//            frame.setVisible(true);
//        });
//    }

//    static class QuantityButtonRenderer extends JButton implements TableCellRenderer {
//        public QuantityButtonRenderer() {
//            setOpaque(true);
//        }
//
//        @Override
//        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//            setText(value.toString());
//            return this;
//        }
//    }
//
//    static class QuantityButtonEditor extends AbstractCellEditor implements TableCellEditor {
//        private JButton button;
//        private DefaultTableModel tableModel;
//        private int editingRow;
//
//        public QuantityButtonEditor(DefaultTableModel model) {
//            button = new JButton();
//            button.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    int quantity = (int) tableModel.getValueAt(editingRow, 2);
//                    if (e.getActionCommand().equals("+")) {
//                        quantity++;
//                    } else if (e.getActionCommand().equals("-")) {
//                        quantity = Math.max(0, quantity - 1);
//                    }
//                    tableModel.setValueAt(quantity, editingRow, 2);
//                    stopCellEditing();
//                }
//            });
//            tableModel = model;
//        }
//
//        @Override
//        public Object getCellEditorValue() {
//            return null;
//        }
//
//        @Override
//        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
//            editingRow = row;
//            button.setText("+");
//            return button;
//        }
//    }
    }
    }
    


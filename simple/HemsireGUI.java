import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HemsireGUI {

    public void showWindow() {
        JFrame f = new JFrame("Hemşire İşlemleri");
        f.setSize(700, 450);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLayout(new BorderLayout());

        // TABLO VE MODEL YAPISI
        String[] kolonlar = {"Ad", "Soyad", "TC", "Bölüm", "Çalışma Saati"};
        DefaultTableModel model = new DefaultTableModel(kolonlar, 0);
        JTable tablo = new JTable(model);
        JScrollPane scroll = new JScrollPane(tablo);

        // --- VERİ YÜKLEME (AÇILIŞTA) ---
        try {
            List<String[]> yuklenenVeriler = DosyaYonetimi.verileriYukle("hemsireler.txt");
            if (yuklenenVeriler != null) {
                for (String[] veri : yuklenenVeriler) {
                    model.addRow(veri);
                }
            }
        } catch (Exception e) {
            System.out.println("Henüz kayıtlı hemşire verisi bulunamadı.");
        }

        // FORM PANELİ
        JPanel form = new JPanel(new GridLayout(7, 2, 5, 5));

        JTextField txtAd = new JTextField();
        JTextField txtSoyad = new JTextField();
        JTextField txtTC = new JTextField();
        JTextField txtBolum = new JTextField();
        JTextField txtSaat = new JTextField();

        JButton btnEkle = new JButton("Ekle");
        JButton btnSil = new JButton("Sil");
        JButton btnGuncelle = new JButton("Güncelle");

        form.add(new JLabel(" Ad:")); form.add(txtAd);
        form.add(new JLabel(" Soyad:")); form.add(txtSoyad);
        form.add(new JLabel(" TC:")); form.add(txtTC);
        form.add(new JLabel(" Bölüm:")); form.add(txtBolum);
        form.add(new JLabel(" Çalışma Saati:")); form.add(txtSaat);
        form.add(btnEkle); form.add(btnSil); form.add(btnGuncelle);

        // EKLE BUTONU AKSİYONU
        btnEkle.addActionListener(e -> {
            if(!txtAd.getText().isEmpty() && !txtSoyad.getText().isEmpty()) {
                model.addRow(new String[]{
                    txtAd.getText(),
                    txtSoyad.getText(),
                    txtTC.getText(),
                    txtBolum.getText(),
                    txtSaat.getText()
                });
                // Alanları Temizle
                txtAd.setText(""); txtSoyad.setText(""); txtTC.setText(""); 
                txtBolum.setText(""); txtSaat.setText("");
            } else {
                JOptionPane.showMessageDialog(f, "Lütfen en az Ad ve Soyad giriniz!");
            }
        });

        // SİL BUTONU AKSİYONU
        btnSil.addActionListener(e -> {
            int secili = tablo.getSelectedRow();
            if (secili != -1) {
                model.removeRow(secili);
            } else {
                JOptionPane.showMessageDialog(f, "Silmek için bir satır seçiniz.");
            }
        });

        // GÜNCELLE BUTONU AKSİYONU
        btnGuncelle.addActionListener(e -> {
            int secili = tablo.getSelectedRow();
            if (secili != -1) {
                model.setValueAt(txtAd.getText(), secili, 0);
                model.setValueAt(txtSoyad.getText(), secili, 1);
                model.setValueAt(txtTC.getText(), secili, 2);
                model.setValueAt(txtBolum.getText(), secili, 3);
                model.setValueAt(txtSaat.getText(), secili, 4);
            } else {
                JOptionPane.showMessageDialog(f, "Güncellemek için tablodan seçim yapınız.");
            }
        });

        // --- VERİ KAYDETME (PENCERE KAPANIRKEN) ---
        f.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                List<String[]> tabloVerileri = new ArrayList<>();
                for (int i = 0; i < model.getRowCount(); i++) {
                    String[] satir = new String[model.getColumnCount()];
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        Object hucre = model.getValueAt(i, j);
                        satir[j] = (hucre != null) ? hucre.toString() : "";
                    }
                    tabloVerileri.add(satir);
                }
                DosyaYonetimi.verileriKaydet("hemsireler.txt", tabloVerileri);
            }
        });

        f.add(scroll, BorderLayout.CENTER);
        f.add(form, BorderLayout.SOUTH);
        f.setVisible(true);
    }
}
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList; // Veri listeleme için gerekli
import java.util.List;      // Liste yapısı için gerekli

public class HastaGUI {

    public static void showWindow() {
        ac();
    }

    public static void ac() {
        JFrame f = new JFrame("Hasta İşlemleri");
        f.setSize(700, 450);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLayout(new BorderLayout());

        // Tablo Yapısı
        String[] kolonlar = {"Ad", "Soyad", "TC", "Yaş"};
        DefaultTableModel model = new DefaultTableModel(kolonlar, 0);
        JTable tablo = new JTable(model);
        JScrollPane scroll = new JScrollPane(tablo);

        // Form Paneli
        JPanel form = new JPanel(new GridLayout(6, 2));

        JTextField txtAd = new JTextField();
        JTextField txtSoyad = new JTextField();
        JTextField txtTC = new JTextField();
        JTextField txtYas = new JTextField();

        JButton btnEkle = new JButton("Ekle");
        JButton btnSil = new JButton("Sil");
        JButton btnGuncelle = new JButton("Güncelle");

        form.add(new JLabel("Ad:")); form.add(txtAd);
        form.add(new JLabel("Soyad:")); form.add(txtSoyad);
        form.add(new JLabel("TC:")); form.add(txtTC);
        form.add(new JLabel("Yaş:")); form.add(txtYas);
        form.add(btnEkle); form.add(btnSil); form.add(btnGuncelle);

        // --- BUTON İŞLEMLERİ ---

        btnEkle.addActionListener(e -> {
            model.addRow(new String[]{
                    txtAd.getText(),
                    txtSoyad.getText(),
                    txtTC.getText(),
                    txtYas.getText()
            });
            txtAd.setText(""); txtSoyad.setText(""); txtTC.setText(""); txtYas.setText("");
        });

        btnSil.addActionListener(e -> {
            int secili = tablo.getSelectedRow();
            if (secili != -1) {
                model.removeRow(secili);
            }
        });

        btnGuncelle.addActionListener(e -> {
            int secili = tablo.getSelectedRow();
            if (secili != -1) {
                model.setValueAt(txtAd.getText(), secili, 0);
                model.setValueAt(txtSoyad.getText(), secili, 1);
                model.setValueAt(txtTC.getText(), secili, 2);
                model.setValueAt(txtYas.getText(), secili, 3);
            }
        });

        // --- VERİ YÜKLEME (AÇILIŞTA) ---
        try {
            List<String[]> yuklenenVeriler = DosyaYonetimi.verileriYukle("hastalar.txt");
            for (String[] veri : yuklenenVeriler) {
                model.addRow(veri);
            }
        } catch (Exception e) {
            System.out.println("Dosyadan veri yüklenirken hata oluştu veya dosya boş.");
        }

        // --- VERİ KAYDETME (PENCERE KAPANIRKEN) ---
        f.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                List<String[]> tabloVerileri = new ArrayList<>();
                for (int i = 0; i < model.getRowCount(); i++) {
                    String[] satir = new String[model.getColumnCount()];
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        satir[j] = model.getValueAt(i, j).toString();
                    }
                    tabloVerileri.add(satir);
                }
                DosyaYonetimi.verileriKaydet("hastalar.txt", tabloVerileri);
            }
        });

        f.add(scroll, BorderLayout.CENTER);
        f.add(form, BorderLayout.SOUTH);
        f.setVisible(true);
    }
}
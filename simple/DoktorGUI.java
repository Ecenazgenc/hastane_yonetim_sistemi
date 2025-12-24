import javax.swing.*;
import java.awt.*;
import java.util.ArrayList; // Veri listeleme için gerekli
import java.util.List;      // Liste yapısı için gerekli

public class DoktorGUI {

    private JFrame frame;
    private DefaultListModel<String> model;

    public DoktorGUI() {
        frame = new JFrame("Doktor İşlemleri");
        frame.setSize(450, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        model = new DefaultListModel<>();

        // --- VERİ YÜKLEME (AÇILIŞTA) ---
        try {
            // DosyaYonetimi sınıfını kullanarak verileri yüklüyoruz
            List<String[]> yuklenenVeriler = DosyaYonetimi.verileriYukle("doktorlar.txt");
            if (yuklenenVeriler != null && !yuklenenVeriler.isEmpty()) {
                for (String[] veri : yuklenenVeriler) {
                    // Listede her satır tek bir String olduğu için ilk indeksi alıyoruz
                    model.addElement(veri[0]);
                }
            } else {
                // Eğer dosya yoksa veya boşsa varsayılan örnek verileri ekle
                model.addElement("Dr. Ali Yilmaz (ID:201) - İç Hastalıkları");
                model.addElement("Dr. Ayşe Kara (ID:202) - Kardiyoloji");
            }
        } catch (Exception e) {
            System.out.println("Doktor verileri yüklenirken bir hata oluştu.");
        }

        JList<String> list = new JList<>(model);
        JScrollPane scroll = new JScrollPane(list);

        JTextField tfAd = new JTextField(10);
        JTextField tfSoyad = new JTextField(10);
        JTextField tfUzmanlik = new JTextField(10);
        JTextField tfId = new JTextField(5);

        JButton btnEkle = new JButton("Ekle");
        JButton btnSil = new JButton("Sil");

        // EKLEME İŞLEMİ
        btnEkle.addActionListener(e -> {
            String ad = tfAd.getText().trim();
            String soyad = tfSoyad.getText().trim();
            String uz = tfUzmanlik.getText().trim();
            String id = tfId.getText().trim();
            
            if(ad.isEmpty() || soyad.isEmpty() || id.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Ad, soyad ve ID gerekli.", "Uyarı", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            model.addElement("Dr. " + ad + " " + soyad + " (ID:" + id + ") - " + uz);
            tfAd.setText(""); tfSoyad.setText(""); tfUzmanlik.setText(""); tfId.setText("");
        });

        // SİLME İŞLEMİ
        btnSil.addActionListener(e -> {
            int sel = list.getSelectedIndex();
            if(sel >= 0) {
                model.remove(sel);
            } else {
                JOptionPane.showMessageDialog(frame, "Silinecek öğeyi seçin.", "Uyarı", JOptionPane.WARNING_MESSAGE);
            }
        });

        // --- VERİ KAYDETME (PENCERE KAPANIRKEN) ---
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                List<String[]> kaydedilecekVeriler = new ArrayList<>();
                for (int i = 0; i < model.size(); i++) {
                    // Listedeki her bir String'i tek elemanlı dizi olarak kaydediyoruz
                    kaydedilecekVeriler.add(new String[]{ model.getElementAt(i) });
                }
                DosyaYonetimi.verileriKaydet("doktorlar.txt", kaydedilecekVeriler);
            }
        });

        // PANEL YERLEŞİMİ
        JPanel input = new JPanel();
        input.add(new JLabel("Ad:")); input.add(tfAd);
        input.add(new JLabel("Soyad:")); input.add(tfSoyad);
        input.add(new JLabel("Uzmanlık:")); input.add(tfUzmanlik);
        input.add(new JLabel("ID:")); input.add(tfId);
        input.add(btnEkle);
        input.add(btnSil);

        frame.setLayout(new BorderLayout());
        frame.add(scroll, BorderLayout.CENTER);
        frame.add(input, BorderLayout.SOUTH);
    }

    public void showWindow() {
        frame.setVisible(true);
    }
}

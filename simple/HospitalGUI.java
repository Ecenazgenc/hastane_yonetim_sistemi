import javax.swing.*;
import java.awt.*;
//Sistemin merkezidir. "Hemşire İşlemleri", "Doktor İşlemleri" ve "Hasta İşlemleri" olmak üzere üç ana butona sahiptir. Her bir buton, ilgili sınıfın showWindow() metodunu çağırarak yeni bir pencere açar.
public class HospitalGUI {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Hastane Yönetim Sistemi");
            frame.setSize(500, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));

            JLabel label = new JLabel("Hastane Yönetim Sistemine Hoşgeldin");
            label.setFont(label.getFont().deriveFont(Font.BOLD, 14f));

            JButton btnHemsire = new JButton("Hemşire İşlemleri");
            JButton btnDoktor = new JButton("Doktor İşlemleri");
            JButton btnHasta = new JButton("Hasta İşlemleri");

            // Hemşire butonu
            btnHemsire.addActionListener(e -> {
                new HemsireGUI().showWindow();
            });

            // Doktor butonu
            btnDoktor.addActionListener(e -> {
                new DoktorGUI().showWindow();
            });

            // Hasta butonu
            btnHasta.addActionListener(e -> {
                new HastaGUI().showWindow();
            });

            JPanel top = new JPanel(new BorderLayout());
            top.add(label, BorderLayout.CENTER);

            panel.add(btnHemsire);
            panel.add(btnDoktor);
            panel.add(btnHasta);

            frame.setLayout(new BorderLayout());
            frame.add(top, BorderLayout.NORTH);
            frame.add(panel, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }
}

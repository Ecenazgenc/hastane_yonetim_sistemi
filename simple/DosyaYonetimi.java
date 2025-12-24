import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DosyaYonetimi {
    
    // Verileri dosyaya kaydeder
    public static void verileriKaydet(String dosyaAdi, List<String[]> veriler) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi))) {
            for (String[] satir : veriler) {
                // Verileri virgül (,) yerine noktalı virgül (;) ile ayırmak daha güvenlidir
                writer.write(String.join(";", satir));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Hata: Veriler kaydedilemedi! " + e.getMessage());
        }
    }

    // Dosyadaki verileri okur
    public static List<String[]> verileriYukle(String dosyaAdi) {
        List<String[]> veriler = new ArrayList<>();
        File dosya = new File(dosyaAdi);
        
        if (!dosya.exists()) return veriler; // Dosya yoksa boş liste dön

        try (BufferedReader reader = new BufferedReader(new FileReader(dosya))) {
            String satir;
            while ((satir = reader.readLine()) != null) {
                if (!satir.trim().isEmpty()) {
                    veriler.add(satir.split(";"));
                }
            }
        } catch (IOException e) {
            System.err.println("Hata: Veriler okunamadı! " + e.getMessage());
        }
        return veriler;
    }
}
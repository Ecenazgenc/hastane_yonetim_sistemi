import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hemsire {

    public int hemsireId;
    public String ad;
    public String soyad;
    public String tcNo;
    public LocalDate dogumTarih;
//Hemşire bilgilerini tutar ve kendisine atanan randevuların veya reçetelerin takibini yapmak için List yapılarını kullanır.
    private List<Randevu> randevular;
    private List<Recete> receteler;

    public Hemsire(int hemsireId, String ad, String soyad, String tcNo, LocalDate dogumTarih) {
        this.hemsireId = hemsireId;
        this.ad = ad;
        this.soyad = soyad;
        this.tcNo = tcNo;
        this.dogumTarih = dogumTarih;
        this.randevular = new ArrayList<>();
        this.receteler = new ArrayList<>();
    }

    public void randevuEkle(Randevu randevu) {
        this.randevular.add(randevu);
        System.out.println("Randevu No: " + randevu.getRandevuId() 
            + " Hemşire " + this.soyad + " listesine eklendi.");
    }

    public void receteEkle(Recete recete) {
        this.receteler.add(recete);
        System.out.println("Yeni reçete hemşire " + this.soyad + " listesine eklendi.");
    }

    public int getHemsireId() { return hemsireId; }
    public String getAd() { return ad; }
    public String getSoyad() { return soyad; }
    public List<Randevu> getRandevular() { return randevular; }
}

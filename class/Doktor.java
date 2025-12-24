import java.time.LocalDate;
import java.time.LocalTime;
//Sadece veri tutmaz, aynı zamanda randevuOlustur() metodu ile bir "davranış" sergiler. Bir doktorun bir servisi vardır (İlişki: Has-A).
public class Doktor {

    private int doktorId;
    private String ad;
    private String soyad;
    private String uzmanlik;
    private Servis servis;

    private static int randevuCounter = 1;

    public Doktor(int doktorId, String ad, String soyad, String uzmanlik) {
        this.doktorId = doktorId;
        this.ad = ad;
        this.soyad = soyad;
        this.uzmanlik = uzmanlik;
    }

    public Randevu randevuOlustur(Hasta hasta, LocalDate tarih, LocalTime saat) {
        System.out.println("Dr. " + this.soyad + " için " + hasta.getTamAd() + " hastasina randevu oluşturuldu.");
        return new Randevu(randevuCounter++, tarih, saat, "Planlandi", this, hasta);
    }

    public void setServis(Servis servis) {
        this.servis = servis;
    }

    public int getDoktorId() { return doktorId; }
    public String getAd() { return ad; }
    public String getSoyad() { return soyad; }
    public String getUzmanlik() { return uzmanlik; }
    public Servis getServis() { return servis; }
}

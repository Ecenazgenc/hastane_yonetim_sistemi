import java.time.LocalDate;
//hasatnın kimilik bilgilerini ,dogum tarihini ve adresini tutar
public class Hasta {

    private int hastaId;
    private String ad;
    private String soyad;
    private String tcNo;
    private LocalDate dogumTarihi;
    private String adres;

    public Hasta(int hastaId, String ad, String soyad, String tcNo, LocalDate dogumTarihi, String adres) {
        this.hastaId = hastaId;
        this.ad = ad;
        this.soyad = soyad;
        this.tcNo = tcNo;
        this.dogumTarihi = dogumTarihi;
        this.adres = adres;
    }

    public int getHastaId() { return hastaId; }
    public String getAd() { return ad; }
    public String getSoyad() { return soyad; }
    public String getTcNo() { return tcNo; }
    public LocalDate getDogumTarihi() { return dogumTarihi; }
    public String getAdres() { return adres; }

    public void setAdres(String adres) {
        this.adres = adres;
        System.out.println(this.ad + " " + this.soyad + " için adres güncellendi.");
    }
// ad sosyad birlestirmesi yaparak kod tekrarını onler
    public String getTamAd() {
        return this.ad + " " + this.soyad;
    }
}

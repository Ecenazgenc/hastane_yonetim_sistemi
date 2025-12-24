import java.time.LocalDate;
import java.time.LocalTime;

public class Randevu {

    private int randevuId;
    private LocalDate tarih;
    private LocalTime saat;
    private String durum;
    private Doktor doktor;
    private Hasta hasta;

    public Randevu(int randevuId, LocalDate tarih, LocalTime saat, 
                   String durum, Doktor doktor, Hasta hasta) {

        this.randevuId = randevuId;
        this.tarih = tarih;
        this.saat = saat;
        this.durum = durum;
        this.doktor = doktor;
        this.hasta = hasta;
    }

    public void durumGuncelle(String yeniDurum) {
        this.durum = yeniDurum;
        System.out.println("Randevu No " + this.randevuId + " durumu güncellendi: " + yeniDurum);
    }

    public int getRandevuId() { return randevuId; }
    public LocalDate getTarih() { return tarih; }
    public LocalTime getSaat() { return saat; }
    public String getDurum() { return durum; }
    public Doktor getDoktor() { return doktor; }
    public Hasta getHasta() { return hasta; }
}

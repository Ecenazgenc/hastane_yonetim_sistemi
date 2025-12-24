import java.util.ArrayList;
import java.util.List;
//Hastanenin bölümlerini (Dahiliye, vb.) temsil eder. İçinde o servise bağlı doktorları ve hemşireleri barındırır.
public class Servis {

    private int servisId;
    private String konum;
    private String ad;
    private List<Doktor> doktorlar;
    private List<Hemsire> hemsireler;

    public Servis(int servisId, String ad, String konum) {
        this.servisId = servisId;
        this.ad = ad;
        this.konum = konum;
        this.doktorlar = new ArrayList<>();
        this.hemsireler = new ArrayList<>();
    }

    public void doktorEkle(Doktor doktor) {
        doktorlar.add(doktor);
        System.out.println("Dr. " + doktor.getSoyad() + " " + this.ad + " servisine atandı.");
    }

    public void hemsireEkle(Hemsire hemsire) {
        hemsireler.add(hemsire);
        System.out.println("Hemşire " + hemsire.getSoyad() + " " + this.ad + " servisine atandı.");
    }

    public int getServisId() { return servisId; }
    public String getKonum() { return konum; }
    public String getAd() { return ad; }
    public List<Doktor> getDoktorlar() { return doktorlar; }
    public List<Hemsire> getHemsireler() { return hemsireler; }
}

import java.util.ArrayList;
import java.util.List;
//Sistemin ana deposudur. Tüm servisleri, doktorları ve hastaları listeler (ArrayList). Yeni bir doktor veya hasta geldiğinde sisteme kaydedilmesini sağlar.
public class Hastane {

    private String hastaneAdi;
    private List<Servis> servisler;
    private List<Doktor> doktorlar;
    private List<Hasta> hastalar;

    public Hastane(String hastaneAdi) {
        this.hastaneAdi = hastaneAdi;
        this.servisler = new ArrayList<>();
        this.doktorlar = new ArrayList<>();
        this.hastalar = new ArrayList<>();
    }

    public void doktorEkle(Doktor doktor) {
        this.doktorlar.add(doktor);
        System.out.println(doktor.getAd() + " " + doktor.getSoyad() + " hastaneye eklendi.");
    }

    public void hastaEkle(Hasta hasta) {
        this.hastalar.add(hasta);
        System.out.println(hasta.getTamAd() + " hastalar listesine eklendi.");
    }

    public void servisEkle(Servis servis) {
        this.servisler.add(servis);
        System.out.println(servis.getAd() + " servisi hastaneye eklendi.");
    }

    public String getHastaneAdi() { return hastaneAdi; }
    public List<Servis> getServisler() { return servisler; }
    public List<Doktor> getDoktorlar() { return doktorlar; }
    public List<Hasta> getHastalar() { return hastalar; }
}

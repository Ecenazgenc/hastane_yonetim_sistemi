import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Recete {

    private int receteId;
    private LocalDate tarih;
    private Doktor doktor;
    private Hasta hasta;
    private List<String> ilaclar;

    public Recete(int receteId, LocalDate tarih, Doktor doktor, Hasta hasta) {
        this.receteId = receteId;
        this.tarih = tarih;
        this.doktor = doktor;
        this.hasta = hasta;
        this.ilaclar = new ArrayList<>();
    }

    public void ilacEkle(String ilac) {
        ilaclar.add(ilac);
        System.out.println(ilac + " reçeteye eklendi.");
    }

    public int getReceteId() { return receteId; }
    public LocalDate getTarih() { return tarih; }
    public Doktor getDoktor() { return doktor; }
    public Hasta getHasta() { return hasta; }
    public List<String> getIlaclar() { return ilaclar; }
}

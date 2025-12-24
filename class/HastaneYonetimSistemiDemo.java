import java.time.LocalDate;
import java.time.LocalTime;
//Uygulamanın main metodudur. Burada nesneler yaratılır, birbirlerine bağlanır (örneğin: doktora servis atanır) ve bir randevu akışı simüle edilir.
public class HastaneYonetimSistemiDemo {

    public static void main(String[] args) {

        Hastane batiHastanesi = new Hastane("Bati Bölge Hastanesi");
        System.out.println("1. Hastane Adi: " + batiHastanesi.getHastaneAdi());

        Servis dahiliyeServis = new Servis(101, "Dahiliye", "3. Kat Bati Kanadi");
        batiHastanesi.servisEkle(dahiliyeServis);

        Doktor drYilmaz = new Doktor(201, "Ali", "Yilmaz", "İç Hastaliklari");

        LocalDate dogumTarihiHemsire = LocalDate.of(1990, 6, 15);
        Hemsire hemsireCan = new Hemsire(301, "Ayşe", "Can", "1234567890", dogumTarihiHemsire);

        drYilmaz.setServis(dahiliyeServis);
        dahiliyeServis.doktorEkle(drYilmaz);
        dahiliyeServis.hemsireEkle(hemsireCan);
        batiHastanesi.doktorEkle(drYilmaz);

        LocalDate dogumTarihiHasta = LocalDate.of(1985, 3, 20);
        Hasta hasta1 = new Hasta(501, "Mehmet", "Demir", "9876543210", dogumTarihiHasta, "Ankara");

        batiHastanesi.hastaEkle(hasta1);

        LocalDate randevuTarihi = LocalDate.of(2025, 11, 27);
        LocalTime randevuSaati = LocalTime.of(10, 0);

        Randevu ilkRandevu = drYilmaz.randevuOlustur(hasta1, randevuTarihi, randevuSaati);
        hemsireCan.randevuEkle(ilkRandevu);

        ilkRandevu.durumGuncelle("Tamamlandi");

        LocalDate receteTarihi = LocalDate.now();
        Recete ilkRecete = new Recete(401, receteTarihi, drYilmaz, hasta1);
        ilkRecete.ilacEkle("Parol 500mg");
        ilkRecete.ilacEkle("Ibuprofen 400mg");

    }
}

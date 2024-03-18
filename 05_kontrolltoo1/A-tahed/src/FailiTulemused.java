import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FailiTulemused {
    private int kokkuATahed = 0;
    private int kokkuSonad = 0;
    private Map<Integer, Map<Integer, Integer>> tulemused = new HashMap<>();

    public void analyysiRida(String rida) {
        String[] sonad = rida.split("\\s+");
        for (String sona : sonad) {
            int aTahtedeArvSonas = 0;
            for (int i = 0; i < sona.length(); i++) {
                if (sona.charAt(i) == 'a' || sona.charAt(i) == 'A') {
                    aTahtedeArvSonas++;
                }
            }
            kokkuATahed += aTahtedeArvSonas;
            kokkuSonad++;
            int pikkus = sona.length();
            if (!tulemused.containsKey(pikkus)) {
                tulemused.put(pikkus, new HashMap<>());
            }
            Map<Integer, Integer> aTahtedeArv = tulemused.get(pikkus);
            aTahtedeArv.put(aTahtedeArvSonas, aTahtedeArv.getOrDefault(aTahtedeArvSonas, 0) + 1);
        }
    }

    public void kuvaTulemused() {
        double keskmineATahtedes = (double) kokkuATahed / kokkuSonad;
        double suhtarv = (double) kokkuATahed / (kokkuATahed + kokkuSonad);

        System.out.println("Kokku on tekstifailis " + kokkuATahed + " a-tähte.");
        System.out.println("Keskmiselt on ühes sõnas " + keskmineATahtedes + " a-tähte.");
        System.out.println("Suhtarv a-tähtede arvu ja sõnade arvu suhtes on " + suhtarv);
    }

    public void salvestaTulemTekstifaili(String failiNimi) {
        try {
            FileWriter kirjutaja = new FileWriter(failiNimi);
            kirjutaja.write("Kokku on tekstifailis " + kokkuATahed + " a-tähte.\n");
            kirjutaja.write("Keskmiselt on ühes sõnas " + ((double) kokkuATahed / kokkuSonad) + " a-tähte.\n");
            kirjutaja.write("Suhtarv a-tähtede arvu ja sõnade arvu suhtes on " + ((double) kokkuATahed / (kokkuATahed + kokkuSonad)) + "\n\n");
            kirjutaja.write("Tekstifaili tabel:\n");
            for (Map.Entry<Integer, Map<Integer, Integer>> entry : tulemused.entrySet()) {
                int pikkus = entry.getKey();
                kirjutaja.write("Sõnade pikkus: " + pikkus + "\n");
                kirjutaja.write("A-tähtede arv sõnas:\n");
                Map<Integer, Integer> aTahtedeArv = entry.getValue();
                for (Map.Entry<Integer, Integer> innerEntry : aTahtedeArv.entrySet()) {
                    int aTahtedeArvSonas = innerEntry.getKey();
                    int s6nadeArv = innerEntry.getValue();
                    kirjutaja.write(aTahtedeArvSonas + " a-tähega: " + s6nadeArv + " sõna\n");
                }
                kirjutaja.write("\n");
            }
            kirjutaja.close();
            System.out.println("Tulemused on salvestatud faili " + failiNimi);
        } catch (IOException e) {
            System.out.println("Viga tulemuste salvestamisel faili " + failiNimi);
            e.printStackTrace();
        }
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class FailiLugeja {
    public void loeFailistJaAnalyysi(String failiNimi) {
        FailiTulemused analyys = new FailiTulemused();
        try {
            File fail = new File(failiNimi);
            Scanner skanner = new Scanner(fail);

            while (skanner.hasNextLine()) {
                String rida = skanner.nextLine();
                analyys.analyysiRida(rida);
            }

            skanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Faili ei leitud: " + failiNimi);
            e.printStackTrace();
        }

        analyys.kuvaTulemused();
        analyys.salvestaTulemTekstifaili("tulemused.txt");
    }
}

import java.io.BufferedReader;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lugemine.txt"));
        String rida = br.readLine();
        while (rida != null) {
            System.out.println(rida);
            String[] s6nad = rida.split(" ");
            // @4c873330 <-- kui tekib konsooli, siis see on mälukoht
            System.out.println(Arrays.toString(s6nad));
            System.out.println("rida läbi!");

            double ruutu = Math.pow(s6nad.length, 2);
            System.out.println(ruutu);

            double ruutjuur = Math.sqrt(s6nad.length);
            System.out.println(ruutjuur);

            rida = br.readLine();
        }
    }
}
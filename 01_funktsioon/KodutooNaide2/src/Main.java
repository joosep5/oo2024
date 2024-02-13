//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        // KODUS: 3 funktsiooni, milles on kasutatud vähemalt:
            // 4 erinevat tüüpi:
                // void, String, int, char, long, double, float, boolean
        // Näiteks:
            // tagastab int    parameetriks boolean
            // tagastab void   parameetriks boolean, int
            // tagastab String parameetriks String
        // Teha igast funktsioonist 2 erineva sisendiga väljakutset

        // Näitekood:
        double kogumaksumus1 = arvutaTaksoMaksumus(3);
        System.out.println(kogumaksumus1);
        double kogumaksumus2 = arvutaTaksoMaksumus(1);
        System.out.println(kogumaksumus2);

        System.out.println();

        String temperatuur1 = temperatuuriHinnang(-1.2);
        System.out.println(kogumaksumus1);
        String temperatuur2 = temperatuuriHinnang(23);
        System.out.println(kogumaksumus2);

        System.out.println();

        prindiForTsykkel("Pikk sõna");
        System.out.println();
        prindiForTsykkel("Sõna");
    }

    // Näitekoodid:
    private static double arvutaTaksoMaksumus(int tunnid) {
        return 3 + 0.9*tunnid;
    }

    private static String temperatuuriHinnang(double temp) {
        if (temp < 0) {
            return "Vesi on jääs";
        } else if (temp > 20) {
            return "Vesi on soe";
        } else {
            return "Vesi on meh";
        }
    }

    private static void prindiForTsykkel(String tahtedeArv) {
        for (int i = 0; i < tahtedeArv.length(); i++) {
            System.out.print(i);
        }
    }
}
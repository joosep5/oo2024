public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");

        //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
        // click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
        // KODUS: 3 funktsiooni, milles on kasutatud vähemalt:
        // 4 erinevat tüüpi:
        // void, String, int, char, long, double, float, boolean
        // Näiteks:
        // tagastab int    parameetriks boolean
        // tagastab void   parameetriks boolean, int
        // tagastab String parameetriks String
        // Teha igast funktsioonist 2 erineva sisendiga väljakutset


        // Näitekood:

        System.out.println("Tere rahvas!");

        double kogumaksumus1 = tooMaksumus(3);
        System.out.println(kogumaksumus1);
        double kogumaksumus2 = tooMaksumus(1);
        System.out.println(kogumaksumus2);

        System.out.println();

        prindiNimed("Tomm");
        prindiNimed("Kalle");

        System.out.println();

        prindiLoomad("kiisuke");
        System.out.println();
        prindiLoomad("kuts");
    }

    // Näitekoodid:
    private static double tooMaksumus(int tunnid) {
        return 5 + 0.9 * tunnid;
    }


    private static void prindiLoomad(String tahtedeArv) {
        for (int i = 0; i < tahtedeArv.length(); i++) {
            System.out.print(i);
        }
    }

    private static void prindiNimed(String nimi) {
        System.out.println("Tere " + nimi+ "!");
    }
}

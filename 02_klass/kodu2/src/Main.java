public class Main {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Tere kõigile!");

        tooline Tooline = new tooline("Madis", false, 25, 'M', 100.0);
        tooline Tooline2 = new tooline("Kalle", false, 30, 'K', 50.0);
        tooline Tooline3 = new tooline("Taavi", true, 35, 'T', 150.0);
        System.out.println();

        System.out.println(Tooline.nimi);

        Tooline.muudaAktiivne();
        System.out.println(Tooline3.aktiivne);

        double Tooline2Raha = Tooline2.lisaRaha(800.0);
        System.out.println(Tooline2Raha);
    }

}
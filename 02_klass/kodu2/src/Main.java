public class Main {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Tere kõigile!");

        tooline Tooline = new tooline("Madis", false, 25, 100.0);
        tooline Tooline2 = new tooline("Kalle", false, 30, 50.0);
        tooline Tooline3 = new tooline("Taavi", true, 35, 150.0);
        System.out.println();

        System.out.println(Tooline.nimi+" "+Tooline2.nimi+" "+Tooline3.nimi);
        System.out.println("mees on aktiivne = true ");
        Tooline.Aktiivsus();
        System.out.println(Tooline3.nimi+" "+Tooline3.aktiivne);

        double Tooline3Raha = Tooline3.tooMaksumus(500);
        System.out.println(Tooline3Raha+"€ töö maksumus");

        double Tooline2Raha = Tooline2.lisaRaha(800.0);
        System.out.println(Tooline2Raha+"€ töölise raha");
    }

}
public class tooline {
    String nimi;
    boolean aktiivne;
    int vanus;
    double raha;

    public tooline(String nimi, boolean aktiivne, int vanus, double raha) {
        this.nimi = nimi;
        this.aktiivne = aktiivne;
        this.vanus = vanus;
        this.raha = raha;

    }
    public void Aktiivsus() {
        aktiivne = !aktiivne;
    }
    public double tooMaksumus(int raha) {
        return 400 + raha;
    }

    public double lisaRaha(double summa) {
        raha = raha + summa;
        return raha;
    }
}

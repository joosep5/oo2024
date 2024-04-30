public class Auto {
    Info info; // klassikomplekt
    int maksumus;
    String pood;

    // parem klõps -> Generate -> Constructor
    public Auto(Info info, int maksumus, String pood) {
        this.info = info;
        this.maksumus = maksumus;
        this.pood = pood;
    }

    public void muudaPoodi(String pood) {
        this.pood = pood;
    }

    public void paneAllahindlus(int allahindlus) {
        this.maksumus = this.maksumus - allahindlus;
    }
}

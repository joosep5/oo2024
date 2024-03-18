//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Info info = new Info(" White Swan " ,280, "manuaal");
        Auto auto = new Auto(info, 25000, "ESAUTOD");
        auto.muudaPoodi("auto24");
        auto.info.muudaNimetus(" Dodge Challenger ");

        Auto auto2 = new Auto(
                new Info(" NISSAN ALMERA ", 60, "manuaal"),
                1300, "ESAUTOD");
        auto2.paneAllahindlus(100);

        System.out.println("Auto1 on"+info.nimetus+auto.maksumus+"€ ja pood on "+auto.pood);
        System.out.println("Auto2 on"+auto2.info.nimetus+auto2.maksumus+"€ ja pood on "+auto2.pood);

    }
}
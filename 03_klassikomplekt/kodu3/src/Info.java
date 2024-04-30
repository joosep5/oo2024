public class Info {
    String nimetus;
    int mootor;
    String kaigukast;

    public Info(String nimetus, int mootor, String kaigukast) {
        this.nimetus = nimetus;
        this.mootor = mootor;
        this.kaigukast = kaigukast;
    }

    public void muudaNimetus(String uusNimetus) {
        nimetus = uusNimetus;
    }
}

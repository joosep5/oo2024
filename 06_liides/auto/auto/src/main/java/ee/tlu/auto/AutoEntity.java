package ee.tlu.auto;

import lombok.Getter;

@Getter
public class AutoEntity {
    String nimetus;
    int maksumus;
    int mootor;
    int aasta;

    // parem klõps -> Generate -> Constructor -> valida kõik
    public AutoEntity(String nimetus, int hind, int mootor, int aasta) {
        this.nimetus = nimetus;
        this.maksumus = hind;
        this.mootor = mootor;
        this.aasta = aasta;
    }
}
package ee.tlu.auto;

// Mis koosneb autodest ja temaga seotud kogusest auto sees
// Klassikomplekt -> Kartul+omadused ja mitu grammi

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Entity
public class Autokomponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    AutoEntity auto;

    //@ManyToMany
    //List<AutoEntity> autod;
    int kogus;

    // {id: 5, auto: {nimetus: "Vorst"}, kogus: 100}
    // 5   |   "Vorst  |    100
}

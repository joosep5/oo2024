package ee.tlu.kt2;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Table(name = "poed")
@jakarta.persistence.Entity // andmebaasi panekuks
@NoArgsConstructor
public class StoreEntity {
    @Id
    private Long id; // Automaatselt genereeritud ID
    private String nimi;
    private int avamine;
    private int sulgemine;
    private int kulastamine;

}
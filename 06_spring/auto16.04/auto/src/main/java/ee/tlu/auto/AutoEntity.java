package ee.tlu.auto;

// jpa moodulist pärinev. Hibernate.
// Kui räägite ChatGPT-ga
// import javax.persistence.Table
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Table(name = "Autod") // vabatahtlik - nime vahetuseks
@Entity // andmebaasipanekuks
@NoArgsConstructor // andmebaasipanekuks
public class AutoEntity {
    @Id
    String nimetus;
    int maksumus;
    int mootor;
    int aasta;

}
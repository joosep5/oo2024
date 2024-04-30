package ee.tlu.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class AutokomponentController {

    @Autowired
    AutokomponentRepository autokomponentRepository;

    // Bean ---> automaatselt loodav klass kui rakendus käivitub (new Class();)
    // @Autowired ---> samaväärne kui allolev constructor, tõmbab Repository siia sisse

    //public AutokomponentController(AutokomponentRepository autokomponentRepository) {
    //    this.autokomponentRepository = autokomponentRepository;
    //}

    // Saaks andmebaasist päringuid teha.
    // INSERT INTO Toidukomponent VALUES("") --->  repository.save("");
    // DELETE FROM Toidukomponent WHERE id = 5  ---> repository.deleteById(5);
    // SELECT * FROM Toidukomponent  ---> repository.findAll();

    // http://localhost:8080/autokomponendid
    @GetMapping("autokomponendid")
    public List<Autokomponent> getAutokomponents() {
        return autokomponentRepository.findAll();
    }

    // --> PathVariable: http://localhost:8080/autokomponendid/4
    // RequestParam: http://localhost:8080/autokomponendid?id=4
    @DeleteMapping("autokomponendid/{id}")
    public List<Autokomponent> deleteAutokomponent(@PathVariable Long id) {
        autokomponentRepository.deleteById(id);
        return autokomponentRepository.findAll();
    }

    @PostMapping("autokomponendid")
    public List<Autokomponent> addAutokomponent(@RequestBody Autokomponent autokomponent) {
        autokomponentRepository.save(autokomponent);
        return autokomponentRepository.findAll();
    }

}
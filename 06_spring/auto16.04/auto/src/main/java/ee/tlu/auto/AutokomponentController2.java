package ee.tlu.auto;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AutokomponentController2 {
    List<Autokomponent> autokomponendid = new ArrayList<>();

    @PostMapping("autokomponent")
    public List<Autokomponent> lisaAutokomponent(@RequestBody Autokomponent komponent) {
        autokomponendid.add(komponent);
        return autokomponendid;
    }

    @PutMapping("autokomponent/{index}")
    public List<Autokomponent> muudaAutokomponent(@PathVariable int index, @RequestBody Autokomponent komponent) {
        autokomponendid.set(index, komponent);
        return autokomponendid;
    }
}
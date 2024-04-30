package ee.tlu.auto;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class AutoController {
    List<String> autod = new ArrayList<>(); // imiteerime andmebaasi

    // localhost:8080/saa-autod --->  []
    @GetMapping("autod")
    public List<String> saaAutod() {
        return autod;
    }

    // PostMappingut ei saa brauser teha
    // localhost:8080/autod/Dodge Challenger POST
    @PostMapping("autod/{auto}")
    public List<String> lisaAuto(@PathVariable String auto) {
        autod.add(auto);
        return autod;
    }

    // DeleteMappingut ei saa brauser teha
    // localhost:8080/autod/0 DELETE
    @DeleteMapping("autod/{index}")
    public List<String> kustutaAuto(@PathVariable int index) {
        autod.remove(index);
        return autod;
    }

    // PutMappingut ei saa brauser teha
    // localhost:8080/autod/0/Sink    PUT
    @PutMapping("autod/{index}/{newValue}")
    public List<String> muudaAuto(@PathVariable int index,
                                       @PathVariable String newValue) {
        autod.set(index, newValue);
        return autod;
    }

    @GetMapping("autod/{index}/saaYks")
    public String saaYksAuto(@PathVariable int index) {
        return autod.get(index);
    }

    // CRUD --> Create, Read, Update, Delete


}

// 404 - URL ehk API otspunkt on vale
// 4xx - Front-endi viga


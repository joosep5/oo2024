package ee.tlu.auto;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RequestMapping("/api")

@RestController
public class AutoEntityController {
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
    // localhost:8080/autod/0/Dodge    PUT
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

    // localhost:8080/tere/M
    @GetMapping("tere/{nimi}")
    public String hello(@PathVariable String nimi) {
        return "Tere " + nimi;
    }

    // localhost:8080/korruta/1/3
    @GetMapping("korruta/{arv1}/{arv2}")
    public int multiply(@PathVariable int arv1, @PathVariable int arv2) {
        return arv1 * arv2;
    }
}

// 404 - URL ehk API otspunkt on vale
// 4xx - Front-endi viga


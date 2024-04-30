package ee.tlu.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")

public class AutoEntityController {
    @Autowired
    AutoRepository autoRepository;

    public AutoEntityController(AutoRepository AutoRepository) {
        this.autoRepository = AutoRepository;
    }


    @GetMapping("autod")
    public List<AutoEntity> saaAutod() {
        return autoRepository.findAll();
    }


    //localhost:8080/api/autod/mustang/1500/5/2000
    @PostMapping("autod/{nimetus}/{maksumus}/{mootor}/{aasta}")
    public List<AutoEntity> lisaAuto(
            @PathVariable String nimetus,
            @PathVariable int maksumus,
            @PathVariable int mootor,
            @PathVariable int aasta
    ) {

        AutoEntity auto = new AutoEntity(nimetus, maksumus, mootor, aasta);
        autoRepository.save(auto);
        return autoRepository.findAll();
    }

    @PostMapping("autod")
    public List<AutoEntity> lisaAuto(@RequestBody AutoEntity autoEntity) {

        autoRepository.save(autoEntity);
        return autoRepository.findAll();
    }

    @DeleteMapping("autod/{nimi}")
    public List<AutoEntity> kustutaAuto(@PathVariable String nimi) {
        autoRepository.deleteById(nimi);
        return autoRepository.findAll();
    }


    @PutMapping("autod")
    public List<AutoEntity> muudaAuto(
            //@RequestParam int index,
            @RequestParam String nimetus,
            @RequestParam int maksumus,
            @RequestParam int mootor,
            @RequestParam int aasta
    ) {
        AutoEntity auto = new AutoEntity(nimetus, maksumus, mootor, aasta);
        autoRepository.save(auto); // täpselt sama mis POST
        // Hibernate kontrollib, kas on juba sellise primaarvõtmega element andmebaasis
        return autoRepository.findAll();
    }

    @GetMapping("autod/{nimi}")
    public AutoEntity saaYksAuto(@PathVariable String nimi) {
        return autoRepository.findById(nimi).get();
    }

    @GetMapping("autod-koguarv")
    public int autodeKoguarv() {
        return autoRepository.findAll().size();
    }

}

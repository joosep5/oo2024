package ee.tlu.salat.controller;

import ee.tlu.salat.entity.ToiduaineEntity;
import ee.tlu.salat.repository.ToiduaineRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // kontroller EHK frontend saab siit ligi
@RequestMapping("/api") // saan igale API otspunktile eesliidese panna
@CrossOrigin(origins = "http://localhost:3000/") // see ütleb, mis rakendus mulle ligi pääseb
public class ToiduaineEntityController {

    // Üks võimalus:
    // @Autowired
    // ToiduaineRepository toiduaineRepository;

    // Teine võimalus:
    ToiduaineRepository toiduaineRepository; // ühendan Repository, et saaks ligi andmebaasi päringutele
    public ToiduaineEntityController(ToiduaineRepository toiduaineRepository){
        this.toiduaineRepository = toiduaineRepository;
    }


    // List<ToiduaineEntity> toiduained = new ArrayList<>(); // imiteerime andmebaasi

    // localhost:8080/api/toiduained  ---> []
    @GetMapping("toiduained")
    public List<ToiduaineEntity> saaToiduained() {
        return toiduaineRepository.findAll();
    }

    // PostMapping'ut ei saa brauser teha, saab kasutada POSTMAN'i
    // localhost:8080/api/toiduained/Kartul/10/5/5 POST
    @PostMapping("toiduained/{nimi}/{valk}/{rasv}/{sysivesik}")
    public List<ToiduaineEntity> lisaToiduaine(
            @PathVariable String nimi,
            @PathVariable int valk,
            @PathVariable int rasv,
            @PathVariable int sysivesik
    ) {
        if (valk + rasv + sysivesik > 100) {
            return toiduaineRepository.findAll();
        }
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduaineRepository.save(toiduaine);
        return toiduaineRepository.findAll();
    }

    @PostMapping("toiduained")
    public List<ToiduaineEntity> lisaToiduaine(@RequestBody ToiduaineEntity toiduaineEntity) {
        if (toiduaineEntity.getValk() + toiduaineEntity.getRasv() + toiduaineEntity.getSysivesik() > 100) {
            return toiduaineRepository.findAll();
        }
        // ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduaineRepository.save(toiduaineEntity);
        return toiduaineRepository.findAll();
    }

    // DeleteMapping'ut ei saa brauser teha, saab kasutada POSTMAN'i
    // localhost:8080/api/toiduained/0 DELETE
    @DeleteMapping("toiduained/{nimi}")
    public List<ToiduaineEntity> kustutaToiduaine(
            @PathVariable String nimi
    ) {
        toiduaineRepository.deleteById(nimi);
        return toiduaineRepository.findAll();
    }

    // PutMapping'ut ei saa brauser teha, saab kasutada POSTMAN'i
    // localhost:8080/api/toiduained/Vorst/15/5/1   <-- @PathVariable'iga tehtes
    // localhost:8080/api/toiduained?index=0&nimi=Vorst&valk=15&rasv=5&sysivesik=1  <-- @RequestParam'iga tehtes, saab tühjaks jätta mingid asjad
    @PutMapping("toiduained")
    public List<ToiduaineEntity> muudaToiduaine(
            @RequestParam int index,
            @RequestParam String nimi,
            @RequestParam int valk,
            @RequestParam int rasv,
            @RequestParam int sysivesik
    ) {
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduaineRepository.save(toiduaine); // täpselt sama mis POST
        // Hibernate kontrollib, kas on juba sellise primaarivõtmega element andmebaasis
        return toiduaineRepository.findAll();
    }

    @GetMapping("toiduained/{nimi}")
    public ToiduaineEntity saaYksToiduaine(
            @PathVariable String nimi
    ) {
        return toiduaineRepository.findById(nimi).get();
    }

    @GetMapping("toiduained-koguarv")
    public int toiduaineteKoguarv() {
        return toiduaineRepository.findAll().size();
    }



    /*@GetMapping("toiduained-valk-min/{minValk}")
    public List<ToiduaineEntity> toiduainedMinValk(@PathVariable int minValk){
        List<ToiduaineEntity> toiduained = toiduaineRepository.findAll();
        List<ToiduaineEntity> tingimuseleVastavadToiduained = new ArrayList<>();
        for (ToiduaineEntity t: toiduained) {
            if (t.valk >= minValk) {
                tingimuseleVastavadToiduained.add(t);
            }
        }
        return tingimuseleVastavadToiduained;
    }*/

    // ülemine aga palju lühem:
    @GetMapping("toiduained-valk-min/{minValk}")
    public List<ToiduaineEntity> toiduainedMinValk(@PathVariable int minValk) {
        return toiduaineRepository.findAllByValkGreaterThan(minValk);
    }


    @GetMapping("toiduained-sysivesik/{min}/{max}")
    public List<ToiduaineEntity> toiduainedMinValk(@PathVariable int min, @PathVariable int max) {
        return toiduaineRepository.findAllBySysivesikBetween(min, max);
    }
}

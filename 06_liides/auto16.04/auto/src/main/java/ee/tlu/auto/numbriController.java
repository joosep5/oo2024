package ee.tlu.auto;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

public class numbriController {
    List<Integer> numbrid = new ArrayList<>(); // imiteerime andmebaasi

    // localhost:8080/saa-numbrid --->  []
    @GetMapping("numbrid")
    public List<Integer> saaNumbrid() {
        return numbrid;
    }

    // PostMappingut ei saa brauser teha
    // localhost:8080/numbrid/5 POST
    @PostMapping("numbrid/{number}")
    public List<Integer> lisaNumber(@PathVariable Integer number) {
        numbrid.add(number);
        return numbrid;
    }

    // DeleteMappingut ei saa brauser teha
    // localhost:8080/numbrid/0 DELETE
    @DeleteMapping("numbrid/{index}")
    public List<Integer> kustutaNumber(@PathVariable int index) {
        numbrid.remove(index);
        return numbrid;
    }

    // PutMappingut ei saa brauser teha
    // localhost:8080/numbrid/0/5    PUT
    @PutMapping("numbrid/{index}/{newValue}")
    public List<Integer> muudaNumber(@PathVariable int index,
                                  @PathVariable Integer newValue) {
        numbrid.set(index, newValue);
        return numbrid;
    }

    @GetMapping("numbrid/kogus")
    public Integer saaNumbriKogus() {
        return numbrid.size();
    }
    @GetMapping("numbrid/summa")
    public Integer saaNumbriSumma() {
        int summa=0;
        for (int i = 0; i < numbrid.size(); i++) {
            summa +=numbrid.get(i);

        }
        return summa;
    }

    @GetMapping("numbrid/keskmine")
    public Integer saaNumbriKeskmine() {
        int summa=0;
        for (int i = 0; i < numbrid.size(); i++) {
            summa +=numbrid.get(i);

        }
        float keskmine = (float) summa/numbrid.size();
        return (int) keskmine;
    }
}
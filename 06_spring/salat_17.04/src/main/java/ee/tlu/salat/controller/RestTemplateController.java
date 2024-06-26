package ee.tlu.salat.controller;


import ee.tlu.salat.model.Games;
import ee.tlu.salat.model.Omniva;
import ee.tlu.salat.model.Post;
import ee.tlu.salat.model.nordpool.Nordpool;
import ee.tlu.salat.model.nordpool.TimestampPrice;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RestTemplateController {

    // https://jsonplaceholder.typicode.com/posts
    @GetMapping("saa-postitused")
    public List<Post> getPosts() {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts";

        // 1. aadress kuhu
        // 2. meetod mida teeme (meie teeme alati GET)
        // 3. mida kaasa saadan (Body, Headerid)
        // 4. mis objekti kujuma saame andmbeid
        ResponseEntity<Post[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Post[].class);


        return List.of(response.getBody());
    }

    @GetMapping("saa-postitused/{kasutajaId}")
    public List<Post> getUserPosts(@PathVariable int kasutajaId) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts";

        // 1. aadress kuhu
        // 2. meetod mida teeme (meie teeme alati GET)
        // 3. mida kaasa saadan (Body, Headerid)
        // 4. mis objekti kujuma saame andmbeid
        ResponseEntity<Post[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Post[].class);

        List<Post> kasutajaPostitused = new ArrayList<>();
        for (Post p : response.getBody()) {
            if (p.getUserId() == kasutajaId) {
                kasutajaPostitused.add(p);
            }
        }

        return kasutajaPostitused;
    }


    @GetMapping("omniva")
    public List<Omniva> getOmnivaPMs() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.omniva.ee/locations.json";
        ResponseEntity<Omniva[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Omniva[].class);
        return List.of(response.getBody());
    }

    @GetMapping("omniva/{country}")
    public List<Omniva> getOmnivaPMsByCountry(@PathVariable String country) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.omniva.ee/locations.json";
        ResponseEntity<Omniva[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Omniva[].class);

        List<Omniva> omnivaPakiautomaadid = new ArrayList<>();
        for (Omniva o : response.getBody()) {
            if (o.getA0_NAME().equals(country)) {
                omnivaPakiautomaadid.add(o);
            }
        }

        return omnivaPakiautomaadid;
    }


    @GetMapping("saa-nordpooli-hinnad")
    public Nordpool getNordpiiliHinnad() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://dashboard.elering.ee/api/nps/price";
        ResponseEntity<Nordpool> response = restTemplate.exchange(url, HttpMethod.GET, null, Nordpool.class);
        return response.getBody();
    }

    @GetMapping("saa-nordpooli-hinnad/{country}")
    public List<TimestampPrice> getNordpiiliHinnadByCountry(@PathVariable String country) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://dashboard.elering.ee/api/nps/price";
        ResponseEntity<Nordpool> response = restTemplate.exchange(url, HttpMethod.GET, null, Nordpool.class);

        List<TimestampPrice> timestampPrices = new ArrayList<>();
        if (country.equals("ee")) {
            timestampPrices = response.getBody().getData().getEe();
        } else if (country.equals("lv")) {
            timestampPrices = response.getBody().getData().getLv();
        } else if (country.equals("lt")) {
            timestampPrices = response.getBody().getData().getLt();
        } else if (country.equals("fi")) {
            timestampPrices = response.getBody().getData().getFi();
        }

        return timestampPrices;
    }
    @GetMapping("Games")
    public List<Games> getGames() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.freetogame.com/api/games";
        ResponseEntity<Games[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Games[].class);
        return List.of(response.getBody());
    }

//    @GetMapping("Games/{genre}")
//    public List<Games> getGamesByGenre(@PathVariable String genre) {
//        RestTemplate restTemplate = new RestTemplate();
//       String url = "https://www.freetogame.com/api/games";
//        ResponseEntity<Games[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Games[].class);
//
//        List<Games> games = new ArrayList<>();
//        for (Games x : response.getBody()) {
//            if (x.getGenre().equals(genre)) {
//                games.add(x);
//            }
//        }
//
//        return games;
//    }
    @GetMapping("Games/{developer}")
    public List<Games> getGamesByDeveloper(@PathVariable String developer) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.freetogame.com/api/games";
        ResponseEntity<Games[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Games[].class);

        List<Games> games = new ArrayList<>();
        for (Games d : response.getBody()) {
            if (d.getDeveloper().equals(developer)) {
                games.add(d);
            }
        }

        return games;
    }

}

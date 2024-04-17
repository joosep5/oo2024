package ee.tlu.salat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Games {
    public int id;
    public String title;
    public String thumbnail;
    public String short_description;
    public String game_url;
    public String genre;
    public String platform;
    public String publisher;
    public String developer;
    public String release_date;
    public String freetogame_profile_url;

}

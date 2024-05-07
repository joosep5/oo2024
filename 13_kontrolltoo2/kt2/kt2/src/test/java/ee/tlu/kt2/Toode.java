package ee.tlu.kt2;

import jdk.jfr.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
@Getter
@NoArgsConstructor
public class Toode {
    public int id;
    public String title;
    public int price;
    public String description;
    public ArrayList<String> images;
    public Date creationAt;
    public Date updatedAt;
    public Category category;
}
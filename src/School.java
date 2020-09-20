/* Created by 3935415 Abdullah Adam on 2020/09/19
 * www.github.com/anneKsiy
 * School class which allows School Objects to be created
 * School(name, lat lng, rating) * All Strings *
 * Method createSchool(metadata) which accepts a String[] Array created in "CSVParser.java" at line 19
 * All accessors and mutators (setters and getters) are present, in case they need to be used in future iterations of the code
 */
public class School {
    private String name;
    private String lat;
    private String lng;
    private String rating;

    public School(String name, String lat, String lng, String rating) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "[" + name;
    }

    public static School createSchool(String[] metadata) {
        String name = metadata[0];
        String lat = metadata[1];
        String lng = metadata[2];
        String rating = metadata[3];
        return new School(name, lat, lng, rating);
    }
}

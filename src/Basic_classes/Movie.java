package Basic_classes;

public class Movie {
    private final String movie_name;
    private final String movie_id;

    public Movie(String movie_name, String movie_id){
        this.movie_id=movie_id;
        this.movie_name=movie_name;
    }

    public String getId(){
        return movie_id;
    }

}

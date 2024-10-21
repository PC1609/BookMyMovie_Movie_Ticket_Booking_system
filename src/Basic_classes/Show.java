package Basic_classes;

import java.util.Date;

public class Show {
    private final String id;
    private final Movie movie;
    private final Integer timeDuration;
    private final Date startTime;
    private final Screen screen;

    public Show(String id,Screen screen,Movie movie,Integer timeDuration, Date startTime){
        this.id=id;
        this.screen = screen;
        this.movie=movie;
        this.timeDuration=timeDuration;
        this.startTime=startTime;
    }
    public Screen getScreen(){
        return this.screen;
    }
    public String getId(){
        return id;
    }
}

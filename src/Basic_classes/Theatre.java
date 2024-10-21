package Basic_classes;

import java.util.List;

public class Theatre {
    String id;
    String name;
    List<Screen> screens;

    public Theatre(String id,String name, List<Screen> screens){
        this.id=id;
        this.name=name;
        this.screens=screens;
    }

    public void addScreen(Screen screen){
        screens.add(screen);
    }
    public String getId(){
        return id;
    }
}

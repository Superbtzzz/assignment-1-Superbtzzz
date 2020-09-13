public class NimPlayer {
    private String name;
    private int total_game_played;


    public NimPlayer(String name){
        this.name = name;
    }

/*    public NimPlayer(NimPlayer obj){
        this.name = obj.name;
    }


    public String getName() {return name;}
    public void setName(String name) {this.name = name;}*/

    @Override
    public String toString() {
        return name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase() ;
    }

/*    public void exit(){
    }
    public void help(){
        System.out.println("Hi, Type 'commands' to display a list of all the available commands ");
    }
    public void commandList(){*/
}




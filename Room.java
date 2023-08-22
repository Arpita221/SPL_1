import java.util.ArrayList;
import java.util.HashMap;

public class Room extends Location {
    private String name;
    private String desc;
    private String weather;
    private ArrayList<Thing> contents;
    private int numberOfThings;
    public ArrayList<String> neighborNames;
    private HashMap<String, String> neighbors;

    public Room() {
        contents = new ArrayList<>();
        neighborNames = new ArrayList<>();
        neighbors = new HashMap<>();
        setType("Room");
    }

    public Room(String name, String desc,String weather) {
        this.name = name;
        this.desc = desc;
        this.weather = weather;
        contents = new ArrayList<>();
        neighborNames = new ArrayList<>();
        neighbors = new HashMap<>();
        setType("Room");
    }

    public ArrayList<Thing> getContents() {
        return contents;
    }

    public void addObject(Thing item) {
        contents.add(item);
    }

    public void dropObject(Thing item) {
        contents.remove(item);
    }

    public void setContents(ArrayList<Thing> contents) {
        this.contents = contents;
    }

    public int getNumberOfThings() {
        numberOfThings = contents.size();
        return numberOfThings;
    }

    public String getName() {
        return name;
    }
    public String getWeather(){
        return weather;
    }
    public void setWeather(String weather){
        this.weather = weather;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String setLocationType() {
        return "Room";
    }

    public void viewRoomContent() {
        System.out.println("Room Contents");
        System.out.println();
        if (contents.size() == 0)
            System.out.println("No Item in Room");
        else {
            for (int i = 0; i < contents.size(); i++)
                System.out.println(i + "  " + contents.get(i));
        }
        System.out.println();
    }

    public String toString() {
        return "Room [name=" + name + ", desc=" + desc + ", contents=" + contents
                + ", numberOfThings=" + getNumberOfThings() +"]" + "\nWether="+getWeather();
    }

    public Thing getRoomItem(int takeThing) {
        Thing t = contents.get(takeThing);
        dropObject(t);
        return t;
    }

    public ArrayList<String> getNeighborNames() {
        return neighborNames;
    }

    public void addNeighborName(String neighborName) {
        neighborNames.add(neighborName);
    }

    public void removeNeighborName(String neighborName) {
        neighborNames.remove(neighborName);
    }

    public boolean hasNeighbor(String neighborName) {
        return neighborNames.contains(neighborName);
    }

    public HashMap<String, String> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(HashMap<String, String> neighbors) {
        this.neighbors = neighbors;
    }

    public String getNeighborRoomName(String direction) {
        return neighbors.get(direction);
    }

    private static Room currentRoom;

    public static Room getCurrentRoom() {
        return currentRoom;
    }

    public static void setCurrentRoom(Room room) {
        currentRoom = room;
    }
}

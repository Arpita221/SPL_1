import java.util.ArrayList;

public class Wall extends Location {

   public String name;
   public String desc;
   public ArrayList<String> neighborNames;
   public ArrayList<Room> neighbors;

    public Wall() {
        neighborNames = new ArrayList<>();
        neighbors = new ArrayList<>();
        setType("Wall");
    }

    public Wall(String name, String desc) {
        this.name = name;
        this.desc = desc;
        neighborNames = new ArrayList<>();
        neighbors = new ArrayList<>();
        setType("Wall");
    }

    public ArrayList<String> getNeighborNames() {
        return neighborNames;
    }

    public void addNeighbor(String direction, Room neighbor) {
        neighborNames.add(direction);
        neighbors.add(neighbor);
    }

    public Room getNeighborByName(String direction) {
        int index = neighborNames.indexOf(direction);
        if (index != -1) {
            return neighbors.get(index);
        } else {
            return null;
        }
    }

    public String getName() {
        return name;
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
        return "Wall";
    }

    public String toString() {
        return "Wall [name=" + name + ", desc=" + desc + ", neighborNames=" + neighborNames + "]";
    }
}

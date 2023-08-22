import java.util.HashMap;

public class Location {
    private String type;
    private HashMap<String, Location> roomDir;
    private HashMap<String, Room> roomMap;

    public Location() {
        roomDir = new HashMap<String, Location>();
        roomMap = new HashMap<String, Room>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void addDirection(String dir, Location location) {
        roomDir.put(dir, location);
    }

    public HashMap<String, Location> getRoomDir() {
        return roomDir;
    }

    public void setRoomDir(HashMap<String, Location> roomDir) {
        this.roomDir = roomDir;
    }

    
    public String toString() {
        return "Location [type=" + type + ", roomDir=" + roomDir + "]";
    }

    public void addRoom(String roomName, Room room) {
        roomMap.put(roomName, room);
    }

    public Room getRoomByName(String roomName) {
        return roomMap.get(roomName);
    }
}

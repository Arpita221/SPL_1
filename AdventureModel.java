import java.util.HashMap;
import java.util.Scanner;

public class AdventureModel {
    public Room rooms[];
    public Thing things[];

    public Wall walls[];
    public Water waters[];

    public AdventureModel() {
    }

    public void initGame() {
        things = new Thing[8];
        walls = new Wall[4];
        waters = new Water[10];
        rooms = new Room[16];

        for (int i = 0; i < 4; i++)
            walls[i] = new Wall();

        for (int i = 0; i < 10; i++)
            waters[i] = new Water();

        things[0] = new Thing("Treasure", "Treasure is hidden ");
        things[1] = new Thing("Zombie", "A Zombie is coming");
        things[2] = new Thing("Canned Food", "A canned food is placed ");
        things[3] = new Thing("Body armour", "Body armour to protect");
        things[4] = new Thing("Pistol", "A pistol is placed");
        things[5] = new Thing("Hammmer", "A hammer is placed");
        things[6] = new Thing("Meds", "Meds for protection");

        rooms[0] = new Room("Living room", "A big empty living room","Rainy");
        rooms[0].addObject(things[0]);
        rooms[0].addObject(things[0]);

        rooms[1] = new Room("Abandoned Office",
                " A dilapidated office space with crumbling walls and broken furniture :","Sunny");
        rooms[2] = new Room("Garage Workshop", " A cluttered workspace with tools and machinery.","Rainy");
        rooms[3] = new Room("Abandon bedroom ", " A dusty bedroom with a worn-out bed and tattered curtains !!!!","Cloudy");

        rooms[4] = new Room("Armory", "A secure room filled with weapons and ammunition  :0","Rainy");
        rooms[4].addObject(things[4]);

        rooms[5] = new Room("Library", "A quiet room with rows of bookshelves and reading tables >>>>","Sunny");
        rooms[5].addObject(things[1]);

        rooms[6] = new Room("Garage Workshop", "A cluttered workspace with tools and machinery!!","Sunny");
        rooms[6].addObject(things[2]);
        rooms[6].addObject(things[4]);

        rooms[7] = new Room("Gymnasium", "A spacious room with exercise equipment and gym mats!!","Windy");
        rooms[7].addObject(things[1]);
        rooms[7].addObject(things[4]);

        rooms[8] = new Room("Kitchen Pantry", "A small storage room filled with shelves and various food items !!!","Rainy");
        rooms[8].addObject(things[3]);
        rooms[8].addObject(things[2]);

        rooms[9] = new Room("Medical Clinic", "A sterile medical facility with examination tables and cabinets","Cloudy");
        rooms[9].addObject(things[6]);
        rooms[9].addObject(things[4]);
        rooms[9].addObject(things[1]);

        rooms[10] = new Room("Garden", "A garden with dead flowers and tress |||","Cloudy");
        rooms[10].addObject(things[1]);

        rooms[11] = new Room("Panic Room", "A fortified chamber designed for emergency situations. ","Sunny");
        rooms[11].addObject(things[1]);
        rooms[11].addObject(things[3]);

        rooms[12] = new Room("Abandoned bathroom", "A bathroom with broken toilet seat :P","Windy");
        rooms[12].addObject(things[0]);

        rooms[13] = new Room("Treasure Vault",
                "A heavily secured room filled with valuable treasures and artifacts $$$","Cloudy");
        rooms[13].addObject(things[0]);

        rooms[14] = new Room(" Greenhouse", "A glass-enclosed space with plants and gardening equipment ****","Sunny");
        rooms[14].addObject(things[1]);
        rooms[14].addObject(things[4]);

        rooms[15] = new Room("Escape room", "A door to escape from the city","Rainy");
        rooms[15].addObject(things[1]);
        rooms[15].addObject(things[3]);
        rooms[15].addObject(things[4]);

        walls[0].addDirection("north", walls[1]);
        walls[0].addDirection("east", rooms[0]);

        walls[1].addDirection("south", walls[2]);
        walls[1].addDirection("south", rooms[1]);
        walls[1].addDirection("west", walls[0]);

        walls[2].addDirection("east", walls[3]);
        walls[2].addDirection("north", waters[2]);
        walls[2].addDirection("east", walls[1]);

        walls[3].addDirection("east", waters[4]);
        walls[3].addDirection("south", waters[3]);
        walls[3].addDirection("west", walls[2]);

        waters[0].addDirection("east", waters[1]);
        waters[0].addDirection("north", waters[4]);
        waters[0].addDirection("west", walls[3]);

        waters[1].addDirection("south", rooms[2]);
        waters[1].addDirection("east", waters[0]);

        waters[2].addDirection("east", waters[3]);
        waters[2].addDirection("west", rooms[1]);
        waters[2].addDirection("north", walls[2]);
        waters[2].addDirection("south", rooms[5]);

        waters[3].addDirection("north", waters[4]);
        waters[3].addDirection("east", waters[2]);
        waters[3].addDirection("north", walls[3]);
        waters[3].addDirection("south", waters[5]);

        waters[4].addDirection("east", rooms[2]);
        waters[4].addDirection("west", waters[3]);
        waters[4].addDirection("north", waters[0]);
        waters[4].addDirection("south", rooms[6]);

        waters[5].addDirection("east", rooms[6]);
        waters[5].addDirection("west", rooms[5]);
        waters[5].addDirection("north", waters[3]);
        waters[5].addDirection("south", rooms[10]);

        waters[6].addDirection("east", rooms[10]);
        waters[6].addDirection("west", rooms[9]);
        waters[6].addDirection("north", rooms[5]);
        waters[6].addDirection("south", waters[7]);

        waters[7].addDirection("east", rooms[15]);
        waters[7].addDirection("west", rooms[14]);
        waters[7].addDirection("north", waters[6]);

        waters[8].addDirection("east", waters[9]);
        waters[8].addDirection("west", rooms[15]);
        waters[8].addDirection("north", rooms[11]);

        waters[9].addDirection("west", waters[8]);
        waters[9].addDirection("north", rooms[12]);

        rooms[0].addDirection("east", rooms[1]);
        rooms[0].addDirection("north", walls[0]);
        rooms[0].addDirection("south", rooms[3]);

        rooms[1].addDirection("east", waters[2]);
        rooms[1].addDirection("west", rooms[0]);
        rooms[1].addDirection("north", walls[1]);
        rooms[1].addDirection("south", rooms[4]);

        rooms[2].addDirection("west", waters[4]);
        rooms[2].addDirection("north", waters[1]);
        rooms[2].addDirection("south", rooms[7]);

        rooms[3].addDirection("east", rooms[4]);
        rooms[3].addDirection("north", rooms[0]);
        rooms[3].addDirection("south", rooms[8]);

        rooms[4].addDirection("east", rooms[5]);
        rooms[4].addDirection("west", rooms[3]);
        rooms[4].addDirection("north", rooms[1]);
        rooms[4].addDirection("south", rooms[9]);

        rooms[5].addDirection("east", waters[5]);
        rooms[5].addDirection("west", rooms[4]);
        rooms[5].addDirection("north", waters[2]);
        rooms[5].addDirection("south", waters[6]);

        rooms[6].addDirection("east", rooms[7]);
        rooms[6].addDirection("west", waters[5]);
        rooms[6].addDirection("north", waters[4]);
        rooms[6].addDirection("south", rooms[11]);

        rooms[7].addDirection("west", rooms[6]);
        rooms[7].addDirection("north", rooms[2]);
        rooms[7].addDirection("south", rooms[12]);

        rooms[8].addDirection("east", rooms[9]);
        rooms[8].addDirection("north", rooms[3]);
        rooms[8].addDirection("south", rooms[13]);

        rooms[9].addDirection("east", waters[6]);
        rooms[9].addDirection("west", rooms[8]);
        rooms[9].addDirection("north", rooms[4]);
        rooms[9].addDirection("south", rooms[14]);

        rooms[10].addDirection("east", rooms[11]);
        rooms[10].addDirection("west", waters[5]);
        rooms[10].addDirection("north", waters[6]);
        rooms[10].addDirection("south", rooms[15]);

        rooms[11].addDirection("east", rooms[12]);
        rooms[11].addDirection("west", rooms[6]);
        rooms[11].addDirection("north", rooms[10]);
        rooms[11].addDirection("south", waters[8]);

        rooms[12].addDirection("west", rooms[11]);
        rooms[12].addDirection("north", rooms[7]);
        rooms[12].addDirection("south", waters[9]);

        rooms[13].addDirection("east", rooms[14]);
        rooms[13].addDirection("north", rooms[8]);

        rooms[14].addDirection("east", waters[7]);
        rooms[14].addDirection("west", rooms[13]);
        rooms[14].addDirection("north", rooms[9]);

        rooms[15].addDirection("east", waters[8]);
        rooms[15].addDirection("west", waters[7]);
        rooms[15].addDirection("north", rooms[10]);

    }


    public void startGame() {
        
        initGame();
        Player P = new Player(rooms[6], null, 0);
        Scanner input = new Scanner(System.in);
        String cmd;
        Location currentLoc, newLoc = null;
        int takeThing;

        boolean b = false;
        do {
            currentLoc = P.getLocation();
            showHelpMenu();
            cmd = input.nextLine();
            if (cmd.equalsIgnoreCase("G")) {
                
                    System.out.println("Current Location : " + currentLoc);
                    System.out.println("Choose direction:");
                    System.out.println("one of north, south, east, west");
                    String direc = input.next();

                    b = checkPathExist(direc, currentLoc);
                    if (b) {
                        newLoc = LocationPNextLocation(direc, currentLoc);
                        P.setLocation((Room) newLoc);
                    }

                    else {
                        System.out.println("Here is Water or Wall");
                        System.out.println("You can't Move to this direction");
                    }
                
            } else if (cmd.equalsIgnoreCase("L")) {
                if (currentLoc instanceof Room)
                    ((Room) currentLoc).viewRoomContent();
                P.viewPlayerInventory();
            } else if (cmd.equalsIgnoreCase("T")) {
                if (currentLoc instanceof Room) {
                    ((Room) currentLoc).viewRoomContent();
                    System.out.println("Take the thing 0/1/2/3 .. from the room : ");
                    takeThing = Integer.parseInt(input.next());
                    Thing t = ((Room) currentLoc).getRoomItem(takeThing);
                    P.take(t);
                    P.viewPlayerInventory();
                }

            } else if (cmd.equalsIgnoreCase("D")) {
                P.viewPlayerInventory();
                System.out.println("Drop the thing 0/1/2/3 .. from the Inventory to room : ");
                takeThing = Integer.parseInt(input.next());
                if (currentLoc instanceof Room) {
                    Thing t = P.getInventoryItem(takeThing);
                    ((Room) currentLoc).addObject(t);
                    ((Room) currentLoc).viewRoomContent();
                }

            } else if (cmd.equalsIgnoreCase("U")) {
                P.viewPlayerInventory();
                System.out.println("Use the thing 0/1/2/3 .. from the Inventory : ");
                takeThing = Integer.parseInt(input.next());
                Thing t = P.getInventoryItem(takeThing);
                P.drop(t);
            } else if (cmd.equalsIgnoreCase("Exit")) {
                System.exit(0);
            } else {
                System.out.println("Invalid command");
            }

        } while (true);

    }

    public void showHelpMenu() {
        System.out.println("Choose command: ");
        System.out.println("Type G for Go");
        System.out.println("Type L to Look inventory");
        System.out.println("Type T to take from inventory");
        System.out.println("Type D to Drop");
        System.out.println("Type U to Use");
        System.out.println("Exit ");
        System.out.println();
    }

    public boolean checkPathExist(String path, Location loc) {

        HashMap<String, Location> hm = loc.getRoomDir();
        if (hm.containsKey(path)) {
            if (hm.get(path) instanceof Room)
                return true;
        }
        return false;
    }

    public Location LocationPNextLocation(String path, Location loc) {
        HashMap<String, Location> hm = loc.getRoomDir();
        if (hm.containsKey(path) && hm.get(path) instanceof Room) {
            return hm.get(path);
        } else {
            System.out.println("Invalid direction or path not found.");
            return loc;
        }
    }
}

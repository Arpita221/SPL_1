import java.util.ArrayList;

import java.util.HashMap;

import java.util.LinkedList;

import java.util.Queue;

import java.util.Scanner;

public class AdventureModel 
{

    public Room rooms[];

    public Thing things[];

    public Wall walls[];
    
    public Water waters[];
    int treasureVaultIndex;

    

    public void initGame() {
        things = new Thing[8];
        walls = new Wall[4];
        waters = new Water[10];
        rooms = new Room[16];

        for (int i =0;i<4;i++)

            walls[i] = new Wall();

        for (int i=0;i<10;i++)
            waters[i]=new Water();

        things[0]=new Thing("Treasure", "Treasure is hidden ");

        things[1]=new Thing("Zombie", "A Zombie is in the room....");

        things[2] = new Thing("Zombie", "Zombie is comming...");

        things[3]=new Thing("Body armour", "Body armour is placed");

        things[4]=new Thing("Pistol", "A pistol is placed");

        things[5]=new Thing("Coins", "Coin is placed !!!");

        things[6]=new Thing("Meds", "Meds for protection !!");


        rooms[0]=new Room(0, "Living room", "A big empty living room", "Rainy");

        rooms[0].addObject(things[6]);

        rooms[0].addObject(things[1]);

        rooms[0].addObject(things[5]);

        rooms[1]=new Room(1, "Abandoned Office",

                " A dilapidated office space with crumbling walls and broken furniture :", "Sunny");

        rooms[1].addObject(things[5]);

        rooms[0].addObject(things[4]);

        rooms[2] = new Room(2, "Garage Workshop", " A cluttered workspace with tools and machinery.", "Rainy");
        rooms[2].addObject(things[6]);
         rooms[2].addObject(things[1]);
          rooms[2].addObject(things[4]);


        rooms[3] = new Room(3, "Abandon bedroom ", " A dusty bedroom with a worn-out bed and tattered curtains !!!!",
                "Cloudy");
        rooms[3].addObject(things[5]);
        rooms[3].addObject(things[6]);


        rooms[4] = new Room(4, "Armory", "A secure room filled with weapons and ammunition  ", "Rainy");
        rooms[4].addObject(things[5]);
        rooms[4].addObject(things[3]);

        rooms[5] = new Room(5, "Library", "A quiet room with rows of bookshelves and reading tables >>>>", "Sunny");
        rooms[5].addObject(things[1]);
        rooms[5].addObject(things[4]);

        rooms[6] = new Room(6, "Hall Room", "A big room filled with lots of broken chairs and tables!!", "Sunny");
        rooms[6].addObject(things[5]);
        rooms[6].addObject(things[1]);

        rooms[7] = new Room(7, "Gymnasium", "A spacious room with exercise equipment and gym mats!!", "Windy");
        rooms[7].addObject(things[5]);
        rooms[7].addObject(things[2]);

        rooms[8] = new Room(8, "Kitchen Pantry", "A small storage room filled with shelves and various food items !!!",
                "Rainy");
        rooms[8].addObject(things[3]);
        rooms[8].addObject(things[2]);

        rooms[9] = new Room(9, "Medical Clinic", "A sterile medical facility with examination tables and cabinets",
                "Cloudy");
        rooms[9].addObject(things[6]);
        rooms[9].addObject(things[5]);
        rooms[9].addObject(things[1]);

        rooms[10] = new Room(10, "Garden", "A garden with dead flowers and tress |||", "Cloudy");
        rooms[10].addObject(things[1]);

        rooms[11] = new Room(11, "Panic Room", "A fortified chamber designed for emergency situations. ", "Sunny");
        rooms[11].addObject(things[1]);
        rooms[11].addObject(things[2]);

        rooms[12] = new Room(12, "Abandoned bathroom", "A bathroom with broken toilet seat :P", "Windy");
        rooms[12].addObject(things[1]);

        rooms[13] = new Room(13, "IIT Lab",
                "A room filled with broken Computers ", "Cloudy");
        rooms[13].addObject(things[6]);

        rooms[14] = new Room(14, "Greenhouse", "A glass-enclosed space with plants and gardening equipment ****",
                "Sunny");
        rooms[14].addObject(things[2]);
        rooms[14].addObject(things[4]);

        rooms[15] = new Room(15, "Escape room", "A door to escape from the city", "Rainy");
        rooms[15].addObject(things[1]);
        rooms[15].addObject(things[3]);
        rooms[15].addObject(things[4]);
        
        treasureVaultIndex = (int) (Math.random() * rooms.length);
        rooms[treasureVaultIndex].addObject(things[0]);

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
        rooms[5].addDirection("north", rooms[2]);
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
        rooms[11].addDirection("west", rooms[10]);
        rooms[11].addDirection("north", rooms[6]);
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

        Player P = new Player(rooms[0], null, 0);


        Scanner input = new Scanner(System.in);
        
        String cmd;

        Location currentLoc, newLoc = null;
        int takeThing;

        boolean b = false;
        do {
            currentLoc = P.getLocation();

            System.out.println("You have " + P.getCoins() + " Coins");

  System.out.println("You have: " + P.getHealth() + " Healths");

     if (currentLoc.equals(rooms[treasureVaultIndex]))
             {

                System.out.println("Congratulations!!! You found the treasure room .....!!! :) ");

                System.exit(0);
            }
            if (P.getHealth() <= 0)
             {

                System.out.println("You lost!Good luck next time  :( ");
                System.exit(0);
            }

            showHelpMenu();

            cmd = input.nextLine();

  if (cmd.equalsIgnoreCase("G"))
             {

                System.out.println("Current Location : " + currentLoc);

                if (((Room) currentLoc).hasZombie()) 
                {
                    if (P.hasItem("Pistol"))
                     {
                        System.out.println("There's a zombie in the room! You have a pistol, so you can shoot it.");

                        P.viewPlayerInventory();

                        System.out.println("Use the thing 0/1/2/3 .. from the Inventory : ");

                        int useThingIndex = Integer.parseInt(input.nextLine());

                        Thing usedThing = P.getInventoryItem(useThingIndex);

                        System.out.println("You shoot a bullet!");

                        int damage = (int) (Math.random() * 11) + 20;

                        P.decreaseHealth(damage);

                        System.out.println("You successfully shot the zombie!");
                        Thing zombie = ((Room) currentLoc).getThingByName("Zombie");
                        ((Room) currentLoc).removeThing(zombie);
                        
                        if (P.getHealth() <= 0) 
                        {
                            System.out.println("You lost!Good luck next time.");
                            System.exit(0);
                        }
                    } 
                    
                    else
                    
                    {
                        System.out
                                .println("There's a zombie in the room! You don't have a pistol, so you take damage.");
                        int damage = (int) (Math.random() * 11) + 30;

                        P.decreaseHealth(damage);
                        
                        System.out.println("You took " + damage + " damage. Remaining health: " + P.getHealth());

                        if (P.getHealth() <= 0) {

                            System.out.println("Game Over");

                            System.exit(0);
                        }
                    }
                }
                System.out.println("Choose direction:");

                System.out.println("one of north, south, east, west");

                String direc = input.nextLine();

                b = checkPathExist(direc, currentLoc);
                if (b) {
                    newLoc = LocationPNextLocation(direc, currentLoc);
                    P.setLocation((Room) newLoc);
                } else {
                    System.out.println("Here is Water or Wall");
                    System.out.println("You can't Move to this direction");
                }
            }

             else if (cmd.equalsIgnoreCase("L")) {
                if (currentLoc instanceof Room)
                    ((Room) currentLoc).viewRoomContent();
                P.viewPlayerInventory();
                // System.out.println("You have " + P.getCoins() + " Coins");
            }
            
 else if (cmd.equalsIgnoreCase("T")) {
                if (currentLoc instanceof Room) {
                    Room currentRoom = (Room) currentLoc;
                    currentRoom.viewRoomContent();

                    ArrayList<Thing> roomContents = currentRoom.getContents();

                    if (roomContents.isEmpty()) {
                        System.out.println("There are no items left in this room.");
                    } else {
                        System.out.println("Take the thing 0/1/2.... from the room except the zombie: ");
                        takeThing = Integer.parseInt(input.nextLine());
            

                        if (takeThing >= 0 && takeThing < roomContents.size()) {
                            Thing t = roomContents.get(takeThing);

                            if (t.getName().equals("Coins")) {
                                P.collectCoin();

                            } else if (!t.getName().equals("Zombie")) {

                                P.take(t);
                            }

                            P.viewPlayerInventory();

                            if(t.getName()!="Zombie") currentRoom.removeThing(t);
                        } else {
                            System.out.println("Invalid item selection.");
                        }
                    }
                }
            } else if (cmd.equalsIgnoreCase("D")) {
                P.viewPlayerInventory();
                System.out.println("Drop the thing 0/1/2/3 .. from the Inventory to room : ");
                takeThing = input.nextInt();
                if (currentLoc instanceof Room) {
                    Thing t = P.getInventoryItem(takeThing);
                    ((Room) currentLoc).addObject(t);
                    ((Room) currentLoc).viewRoomContent();
                }

            } 
            
            else if (cmd.equalsIgnoreCase("U")) {
                P.viewPlayerInventory();
                System.out.println("Use the thing 0/1/2/3 .. from the Inventory : ");
                int useThingIndex = Integer.parseInt(input.nextLine());
                
                if (useThingIndex >= 0 && useThingIndex < P.getInventory().size()) {
                    Thing usedThing = P.getInventoryItem(useThingIndex);
                    System.out.println("Using " + usedThing.getName() + "...");
                    handleItemUsage(usedThing, P);
                } else {
                    System.out.println("Invalid item selection.");
                }
            } else if (cmd.equalsIgnoreCase("Exit")) {
                System.exit(0);
            } else if (cmd.equalsIgnoreCase("See")) {
                System.out.println("Current Location : " + currentLoc);
            } else if (cmd.equalsIgnoreCase("Search")) {
                if (P.getCoins() >= 3) {
                    Room startRoom = P.getLocation();
                    Room targetRoom = rooms[treasureVaultIndex];
                    System.out.println(treasureVaultIndex);
                    searchRoomsBFS(startRoom, targetRoom);
                } else
                    System.out.println("You dont have enough coins.");
            } else {
                System.out.println("Invalid command");
            }



        } while (true);
    }

    private void handleItemUsage(Thing item, Player player) {
        String itemName = item.getName();

        if (itemName.equalsIgnoreCase("Meds")) {
            int health = (int) (Math.random() * 11) + 10;
            System.out.println("Ypur health increased by: " + health);
            player.increaseHealth(health);
            System.out.println("Current health: " + player.getHealth());
            System.out.println("You feel healthier!");
        } else if (itemName.equalsIgnoreCase("Pistol")) {
            System.out.println("You shoot a bullet!");
            Room currentRoom = (Room) player.getLocation();
            Thing zombie = currentRoom.getThingByName("Zombie");
            
            if (player.getHealth() <=0 ) {
                System.out.println("Game Over");
                System.exit(0);
            }
            if (zombie != null) {
                int damage = (int) (Math.random() * 11) + 20;
            player.decreaseHealth(damage);
                 System.out.println("You successfully shot the zombie!");
                currentRoom.removeThing(zombie);
                System.out.println("Remaining health: " + player.getHealth());
            } else {
                System.out.println("There is no zombie to shoot.");
            }
        } else if (itemName.equalsIgnoreCase("Body armour")) {
            player.increaseHealth(30);
            System.out.println("Your health increased by 30");

            System.out.println("Remaining health: " + player.getHealth());
        } else {
            System.out.println("You can't use this item.");
        }

        player.drop(item);
    }

    public void showHelpMenu() {
        System.out.println("Choose command: ");
        System.out.println("Type G for Go");
        System.out.println("Type L to Look inventory");
        System.out.println("Type T to take from inventory");
        System.out.println("Type D to Drop");
        System.out.println("Type U to Use");
        System.out.println("Type See to see the current location");
        System.out.println("Type Search to search");
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

    private String getDirection(Room fromRoom, Room toRoom) {
        for (String direction : fromRoom.getRoomDir().keySet()) {
            if (fromRoom.getRoomDir().get(direction).equals(toRoom)) {
                return direction;
            }
        }
        return "";
    }

    public void searchRoomsBFS(Room startRoom, Room targetRoom) {
        Queue<Room> queue = new LinkedList<>();
        HashMap<Room, Room> parentMap = new HashMap<>();
        queue.add(startRoom);
        parentMap.put(startRoom, null);

        while (!queue.isEmpty()) {
            Room currentRoom = queue.poll();

            if (currentRoom.equals(targetRoom)) {
                System.out.println("Path found using BFS:");
                printPathUsingParentMap(parentMap, targetRoom);
                return;
            }

            for (String direction : currentRoom.getRoomDir().keySet()) {
                Location nextLocation = currentRoom.getRoomDir().get(direction);

                if (nextLocation instanceof Room && !parentMap.containsKey(nextLocation)) {
                    queue.add((Room) nextLocation);
                    parentMap.put((Room) nextLocation, currentRoom); 
                }
            }
        }

        System.out.println("No path found using BFS.");
    }

    private void printPathUsingParentMap(HashMap<Room, Room> parentMap, Room targetRoom) {
        LinkedList<String> path = new LinkedList<>();
        Room currentRoom = targetRoom;
        Room parentRoom;

        while (currentRoom != null) {
            parentRoom = parentMap.get(currentRoom);
            if (parentRoom != null) {
                String direction = getDirection(parentRoom, currentRoom);
                path.addFirst(direction);
            }
            currentRoom = parentRoom;
        }

        for (String dir : path) {
            System.out.print(dir + " ");
        }
        System.out.println();
    }

}


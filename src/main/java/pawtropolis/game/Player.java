package pawtropolis.game;


import pawtropolis.game.commands.DirectionEnum;

public class Player {

    private String name;
    private int lifePoints;
    private final Bag bag;
    private  Room currentRoom;

    public Player(String name, int lifePoints, Room startingRoom) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.bag = new Bag(30);
        this.currentRoom = startingRoom;
    }

    public Bag getBag() {
        return bag;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void goRoom(DirectionEnum direction) {
        if (getCurrentRoom().getAdjacents().containsKey(direction)) {
            Room nextRoom = getCurrentRoom().getAdjacents().get(direction);
            setCurrentRoom(nextRoom);
            System.out.println("You have entered " + nextRoom.getName());
            lookRoom();
        } else {
            System.out.println("Invalid direction. Try again.");
        }
    }

    public void pickItem(String itemName) {
        if (currentRoom.getAvailableItems()//il player non deve entrare nella currentroom
                .stream()
                .anyMatch(item -> item.getName().equals(itemName))) { //non fare due stream separate

            Item item = currentRoom.getAvailableItems()
                    .stream()
                    .filter(i -> i.getName().equals(itemName))
                    .findFirst()
                    .get(); //orElse = null

            bag.addItem(item);
            currentRoom.dropItem(item);
        } else {
            System.out.println("Item not found in the room.");
        }
    }

    public void dropItem(String itemName) {
        if (bag.getItemList()
                .stream()
                .anyMatch(item -> item.getName().equals(itemName))) {

            Item item = bag.getItemList()
                    .stream()
                    .filter(i -> i.getName().equals(itemName))
                    .findFirst()
                    .get();

            bag.dropItem(itemName);
            currentRoom.addItem(item);
        } else {
            System.out.println("Item not found in the bag.");
        }
    }

    public void viewBag() {
        if (bag.bagUsedSlots() != 0) {
            bag.getItemList()
                    .forEach(item -> System.out.println(" " + item.getName() + " description: " + item.getDescription()));
        } else {
            System.out.println("No items found in the bag");
        }
    }

    public void lookRoom() {
        System.out.println("You're in the room: " + currentRoom.getName());
        System.out.println("Available directions: " + getAvailableDirections(currentRoom));

        if (!currentRoom.getAvailableItems().isEmpty()) {
            System.out.println("Available items:");
            currentRoom.getAvailableItems().forEach(item ->
                    System.out.println("- " + item.getName() + ": " + item.getDescription()));
        } else {
            System.out.println("There are no items in this room");
        }

        if (!currentRoom.getAvailableAnimals().isEmpty()) {
            System.out.println("NPC:");
            currentRoom.getAvailableAnimals().forEach(animal ->
                    System.out.println("- " + animal.getNickname() + " (" +
                            animal.getClass().getSimpleName() + ")"));
        } else {
            System.out.println("There are no NPCs in this room");
        }
    }



    private String getAvailableDirections(Room room) {
        return room.getAdjacents().keySet().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

}



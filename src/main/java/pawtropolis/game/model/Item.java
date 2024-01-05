<<<<<<<< Updated upstream:src/main/java/projectzoo/game/Item.java
package projectzoo.game;
========
package pawtropolis.game.model;
>>>>>>>> Stashed changes:src/main/java/pawtropolis/game/model/Item.java

public class Item {

    private String nameItem;
    private String description;
    private int slotRequired;

    public Item(String nameItem, String description, int slotRequired) {
        this.nameItem = nameItem;
        this.description = description;
        this.slotRequired = slotRequired;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSlotRequired() {
        return slotRequired;
    }

    public void setSlotRequired(int slotRequired) {
        this.slotRequired = slotRequired;
    }


}

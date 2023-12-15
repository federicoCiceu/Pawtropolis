package pawtropolis.game;

public class Item {

    private String name;
    private String description;
    private int slotRequired;

    public Item(String nameItem, String description, int slotRequired) {
        this.name = nameItem;
        this.description = description;
        this.slotRequired = slotRequired;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getSlotRequired() {
        return slotRequired;
    }

    public void setSlotRequired(int slotRequired) {
        this.slotRequired = slotRequired;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }
}

import java.util.HashMap;
import java.util.Iterator;

public class Player {
    private Graph.Node current = null;
    private HashMap<String, Item> inventory;
    private String name = "Player";

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public void move(Graph.Node n) {
        setCurrentNode(n);
    }

    public void setCurrentNode(Graph.Node n) {
        current = n;
    }

    public void getCurrentNode(Graph.Node n) {
        current = n;
    }

    public String look() {
        return "The neighrbors are " + current.getNeighborNames() + System.lineSeparator() + "You are currently in a " + current.getDescription();
    }

    public String getInventory() {
        String inventoryList = "";
        for (Item i : this.inventory.values()) {
            inventoryList += i.getName() + " ";
        }

        return inventoryList;
    }

    private void addItem(Item i){
        inventory.put(i.getName(), i);
    }

    private Item removeItem(Item i){
        return inventory.remove(i.getName());
    }

    public void pickup(Item i){
        addItem(current.removeItem(i));
    }

    public void drop(Item i){
        current.addItem(removeItem(i));
    }

    public void remove(Item i){
        removeItem(i);
    }
}

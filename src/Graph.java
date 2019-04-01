import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {

    private HashMap<String, Node> nodes;

    public Graph() {
        nodes = new HashMap<String, Node>();
    }

    public void addNode(Node n) {
        nodes.put(n.getName(), n);
    }

    public void addNode(String name) {
        nodes.put(name, new Node(name));
    }

    public void addNode(String name, String description) {
        nodes.put(name, new Node(name, description));
    }

    public void addDirectedEdge(String name1, String name2) {
        getNode(name1).addNeighbor(getNode(name2));
        getNode(name2).addNeighbor(getNode(name1));
    }

    public void addUndirectedEdge(String name1, String name2) {
        getNode(name1).addNeighbor(getNode(name2));
    }

    public Node getNode(String name) {
        return nodes.get(name);
    }

    public class Node {
        private String name;
        private String description;
        private HashMap<String, Node> neighbors;
        ArrayList<Item> itemList;

        private Node(String name) {
            neighbors = new HashMap<String, Node>();
            this.name = name;
            itemList = new ArrayList<Item>();
        }

        private Node(String name, String description) {
            neighbors = new HashMap<String, Node>();
            this.name = name;
            this.description = description;
            itemList = new ArrayList<Item>();
        }

        private void addNeighbor(Node n) {
            neighbors.put(n.getName(), n);
        }

        public String getNeighborNames() {

            String names = "";

            for (Node n : neighbors.values()) {
                names += n.getName();
            }
            return names;
        }

        public Node getNeighbor(String name) {
            return neighbors.get(name);
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Item removeItem(Item i) {
            if (itemList.remove(i)) {
                return i;
            }
            return null;
        }

        public Item removeItem(String itemName) {
            for (Item i : itemList){
                if (i.getName().equalsIgnoreCase(itemName)){
                    itemList.remove(i);
                    break;
                }
            }
            return null;
        }


        public void addItem(Item i) {
            itemList.add(i);
        }

        public String getItems() {
            return itemList.toString();
        }
    }

}

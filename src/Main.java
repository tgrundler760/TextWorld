import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Graph g = new Graph();
        g.addNode("test1", "test 1 description");
        g.addNode("test2");
        g.addDirectedEdge("test1", "test2");
        Graph.Node current = g.getNode("test2");

        String response = "";
        Scanner s = new Scanner(System.in);

        System.out.println("You can go to a new room, look to see the possible rooms, add room to create a new room, and quit to exit.");

        do {
            System.out.println("You are in the " + current.getName());
            System.out.println("What do you want to do?");
            response = s.nextLine();

            if (response.substring(response.indexOf(" ")).equalsIgnoreCase("go")) {
                if (g.getNode(response.substring(response.indexOf(" "))) != null) {
                    current = g.getNode(response.substring(response.indexOf(" ")));
                }

            } else if (response.equalsIgnoreCase("look")) {
                System.out.println(current.getNeighborNames());
                System.out.println(current.getDescription());

            } else if (response.indexOf("add room") == 0) {
                g.addNode(response.split(" ")[2]);
            } else if (response.substring(response.indexOf(" ")).equalsIgnoreCase("quit")) {

            } else {
                System.out.println("You can go to a new room, look to see the possible rooms, add room to create a new room, and quit to exit.");
            }

        } while (!response.equals("quit"));
    }
}


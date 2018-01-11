import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String node;
    private List<String> neighbors;

    public Vertex(String node, ArrayList<String> neighbors){
        this.node = node;
        this.neighbors = neighbors;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public List<String> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<String> neighbors) {
        this.neighbors = neighbors;
    }
}

import java.util.Comparator;

public class VertexComparator implements Comparator<Vertex> {

    @Override
    public int compare(Vertex a, Vertex b) {
        return a.getNeighbors().size() < b.getNeighbors().size() ? 1 : a.getNeighbors().size() == b.getNeighbors().size() ? 0 : -1;
    }
}

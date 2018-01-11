import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Graph {
    private List<Vertex> vertices;
    private Map<String, String> vertex_color_index;

    public Graph(String pathFile) {
        vertices = new ArrayList<>();
        ArrayList<String> lines = (ArrayList<String>) readGraphData(pathFile);

        if (lines != null) {
            initializeGraph(lines);
        }
    }

    /**
     * Create graph from data
     * @param lines Data
     */
    private void initializeGraph(ArrayList<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            String node = lines.get(i).split(":")[0];
            String[] adj = lines.get(i).split(":")[1].split(" ");

            List<String> neighbors = new ArrayList<>();
            for (int j = 0; j < adj.length; j++) {
                neighbors.add(adj[j]);
            }
            vertices.add(new Vertex(node, new ArrayList<>(neighbors)));
        }
    }

    /**
     * Implementation of the Welsh-Powell Algorithm
     */
    public void colourVertices() {
        Collections.sort(vertices, new VertexComparator()); // arrange vertices in order of descending valence
       vertex_color_index = new HashMap<>(); // create Map<Vertex, Color>
        for (int i = 0; i < vertices.size(); i++) {
            if ((vertex_color_index.containsKey(vertices.get(i).getNode()))) {
                continue;
            }
            else {
                setColor(i, i); // color first vertex in list with color 1
                for (int j = i+1; j < vertices.size(); j++) {
                    if (!(vertices.get(i).getNeighbors().contains(vertices.get(j).getNode()))
                            && !(vertex_color_index.containsKey(vertices.get(j).getNode()))) {
                        setColor(j, i);
                    }
                    else {
                        continue;
                    }
                }
            }
        }
        System.out.println(vertex_color_index);
    }

    /**
     * Attribute color from enum
     * @param index Index node
     * @param color Index color
     */
    private void setColor(int index, int color) {
        vertex_color_index.put(vertices.get(index).getNode(), "Colour " + Colors.values()[color]);
    }

    /**
     * Get graph from extern file
     * @param pathFile Path file
     * @return List
     */
    private List<String> readGraphData(String pathFile) {
        Path path = FileSystems.getDefault().getPath(pathFile, "");
        try {
            return Files.readAllLines(path, Charset.defaultCharset());
        } catch (IOException e) {
            System.err.println("ERROR: " + e.getMessage());
            return null;
        }
    }
}

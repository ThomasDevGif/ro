public class Main {

    public static void main(String[] args){
        String pathFile = "D:\\Documents\\Thomas\\EPSI\\I4\\web services\\cours 3\\spring-cloud-eureka-master\\ro\\assets\\data.txt";
        Graph graph = new Graph(pathFile);
        graph.colourVertices();
    }

}

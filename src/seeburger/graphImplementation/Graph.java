package seeburger.graphImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class Graph {
    private Vertex[] adjList;
    private List<Vertex> listOfVerteces;
    private boolean directed;

    Graph(String fileName) {
        Path filePaht = Paths.get("src\\seeburger\\graphImplementation\\resources\\" + fileName);
        try (BufferedReader reader = Files.newBufferedReader(filePaht)) {
            String graphType = reader.readLine();
            setDirection(graphType);

            int countOfVertexes = Integer.parseInt(reader.readLine());
            adjList = new Vertex[countOfVertexes];

            for (int i = 0; i < adjList.length; i++) {
                adjList[i] = new Vertex(reader.readLine(), null);
            }

            String edge = reader.readLine();
            while (edge != null) {
                String[] tokens = edge.split(" ");
                
                switch (tokens.length){
                    case 1:
                        listOfVerteces.add(new Vertex(tokens[0], null));
                        break;
                        default:
                            //tuka trqbva da palnim gadniq spisak ot sasedi!
                            int vertexIndex = getIndexFromArray(tokens[0]);
                            for (int i = 1; i < tokens.length; i++) {
                                int edgeIndex = getIndexFromArray(tokens[i]);
                                adjList[vertexIndex].adjList = new Neighbour(edgeIndex, adjList[vertexIndex].adjList);
                                if (!directed) {
                                    adjList[edgeIndex].adjList = new Neighbour(vertexIndex, adjList[edgeIndex].adjList);
                                }
                            }
                            break;
                }

                int vertexIndex = getIndexFromArray(tokens[0]);
                for (int i = 1; i < tokens.length; i++) {
                    int edgeIndex = getIndexFromArray(tokens[i]);


                    adjList[vertexIndex].adjList = new Neighbour(edgeIndex, adjList[vertexIndex].adjList);
                    if (!directed) {
                        adjList[edgeIndex].adjList = new Neighbour(vertexIndex, adjList[edgeIndex].adjList);
                    }
                }
                edge = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setDirection(String graphType) {
        switch (graphType) {
            case "directed":
                this.directed = true;
                break;
            case "undirected":
                this.directed = false;
                break;
            default:
                this.directed = false;
                break;
        }
    }

    private int getIndexFromArray(String nameOfCurrentVertex) {
        for (int i = 0; i < adjList.length; i++) {
            if (adjList[i].name.equals(nameOfCurrentVertex)) {
                return i;
            }
        }
        return -1;
    }

    private void dfs(int v, boolean[] visited) {
        visited[v] = true;
        System.out.println(adjList[v]);

        for (Neighbour neighbour = adjList[v].adjList;
             neighbour != null;
             neighbour = neighbour.next) {
            if (!visited[neighbour.vertexNum]) {
                System.out.println(
                        adjList[v].name + "--" +
                                adjList[neighbour.vertexNum].name);
                dfs(neighbour.vertexNum, visited);
            }
        }
    }

    void dfs() {
        boolean[] visited = new boolean[adjList.length];
        for (int v = 0; v < visited.length; v++) {
            if (!visited[v]) {
                dfs(v, visited);
            }
        }
    }
}

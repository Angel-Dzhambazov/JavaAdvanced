package seeburger.graphImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

class Graph {
    private Vertex[] adjList;
    private List<Vertex> listOfVerteces;
    private boolean directed;
    StringBuilder output = new StringBuilder();

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

                int vertexIndex = getIndexFromArray(tokens[0]);
                for (int i = 1; i < tokens.length; i++) {
                    int edgeIndex = getIndexFromArray(tokens[i]);


                    adjList[vertexIndex].svarzanKamNego = new Neighbour(edgeIndex, adjList[vertexIndex].svarzanKamNego);
                    if (!directed) {
                        adjList[edgeIndex].svarzanKamNego = new Neighbour(vertexIndex, adjList[edgeIndex].svarzanKamNego);
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

    private void dfs(int i, boolean[] visited) {
        visited[i] = true;
        System.out.println("Poseshtavame tochka: " + adjList[i].name);
        for (Neighbour neighbour = adjList[i].svarzanKamNego;
             neighbour != null;
             neighbour = neighbour.next) {

            if (!visited[neighbour.vertexNum]) {
                System.out.println();
                System.out.println(
                        adjList[i].name + " => sochi kam =>  " +
                                adjList[neighbour.vertexNum].name);
                output.append(adjList[neighbour.vertexNum].name).append(" => ");
                dfs(neighbour.vertexNum, visited);
            }
        }
    }

    void dfs() {
        boolean[] visited = new boolean[adjList.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                System.out.println("Startirame ot " + adjList[i].name);
                output.append(adjList[i].name).append(" => ");
                dfs(i, visited);
            }
            output.append(System.lineSeparator());
        }
        System.out.println();
        System.out.println("krasiv izhod na obhojdaneto");
        String toPrint = output.toString().replaceAll("(?m)^[ \t]*\r?\n", "");
        System.out.println(toPrint.substring(0, toPrint.length() - 6));
    }

    void dfs(int startingIndex) {
        boolean[] visited = new boolean[adjList.length];

        for (int i = startingIndex; i < visited.length; i++) {
            if (!visited[i]) {
                System.out.println("Startirame ot " + adjList[i].name);
                output.append(adjList[i].name).append(" => ");
                dfs(i, visited);
            }
            output.append(System.lineSeparator());
        }

        for (int i = 0; i < startingIndex; i++) {
            if (!visited[i]) {
                System.out.println("Startirame ot " + adjList[i].name);
                output.append(adjList[i].name).append(" => ");
                dfs(i, visited);
            }
            output.append(System.lineSeparator());
        }
        System.out.println();
        System.out.println("krasiv izhod na obhojdaneto");
        String toPrint = output.toString().replaceAll("(?m)^[ \t]*\r?\n", "");
        System.out.println(toPrint.substring(0, toPrint.length() - 6));
    }

    private void bfs(int start, boolean[] visited, Deque<Integer> queue) {
        visited[start] = true;
        System.out.println("Startirame ot " + adjList[start].name);
        queue.addLast(start);

        while (!queue.isEmpty()) {
            int i = queue.pollFirst();

            for (Neighbour neighbour = adjList[i].svarzanKamNego; neighbour != null; neighbour = neighbour.next) {
                int vertexNumber = neighbour.vertexNum;
                if (!visited[vertexNumber]) {
                    System.out.println("Poseshtavame tochka: " + adjList[vertexNumber].name);
                    visited[vertexNumber] = true;
                    output.append(adjList[vertexNumber].name).append(" => ");
                    queue.addLast(vertexNumber);
                }

            }

        }

    }

    void bfs() {
        output = new StringBuilder();
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[adjList.length];


        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                output.append(adjList[i].name).append(" => ");
                bfs(i, visited, queue);
            }
            output.append(System.lineSeparator());
        }

        System.out.println();
        System.out.println("krasiv izhod na obhojdaneto");
        String toPrint = output.toString().replaceAll("(?m)^[ \t]*\r?\n", "");
        System.out.println(toPrint.substring(0, toPrint.length() - 6));
    }


    void bfs(int index) {
        output = new StringBuilder();
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[adjList.length];


        for (int i = index; i < visited.length; i++) {
            if (!visited[i]) {
                output.append(adjList[i].name).append(" => ");
                bfs(i, visited, queue);
            }
            output.append(System.lineSeparator());
        }


        for (int i = 0; i < index; i++) {
            if (!visited[i]) {
                output.append(adjList[i].name).append(" => ");
                bfs(i, visited, queue);
            }
            output.append(System.lineSeparator());
        }

        System.out.println();
        System.out.println("krasiv izhod na obhojdaneto");
        String toPrint = output.toString().replaceAll("(?m)^[ \t]*\r?\n", "");
        System.out.println(toPrint.substring(0, toPrint.length() - 6));
    }

}

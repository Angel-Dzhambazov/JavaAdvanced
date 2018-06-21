package seeburger.graphImplementation;


class Vertex {
    String name;
    Neighbour adjList;

    Vertex(String name, Neighbour neighbours) {
        this.name = name;
        this.adjList = neighbours;
    }
}

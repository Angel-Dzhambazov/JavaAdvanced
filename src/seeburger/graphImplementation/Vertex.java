package seeburger.graphImplementation;


class Vertex {
    String name;
    Neighbour svarzanKamNego;

    Vertex(String name, Neighbour neighbours) {
        this.name = name;
        this.svarzanKamNego = neighbours;
    }
}

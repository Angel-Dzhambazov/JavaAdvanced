package seeburger.inhouseTasks20th;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Vertex {
    private int uniqueLabel;

    public Vertex(int uniqueLabel) {
        super();
        this.uniqueLabel = uniqueLabel;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vertex)) return false;

        Vertex _obj = (Vertex) obj;
        return _obj.uniqueLabel == uniqueLabel;
    }

    @Override
    public int hashCode() {
        return uniqueLabel;
    }

    public int getLabel() {
        return uniqueLabel;
    }

    public void setLabel(int uniqueLabel) {
        this.uniqueLabel = uniqueLabel;
    }
}

class Edge {
    private static final int DEFAULT_WEIGHT = 1;

    Vertex v1, v2;
    int weight;

    public Edge(Vertex v1, Vertex v2) {
        this(v1, v2, DEFAULT_WEIGHT);
    }

    public Edge(Vertex v1, Vertex v2, int weight) {
        super();
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Edge)) return false;

        Edge _obj = (Edge) obj;
        return _obj.v1.equals(v1) && _obj.v2.equals(v2) &&
               _obj.weight == weight;
    }

    @Override
    public int hashCode() {
        int result = v1.hashCode();
        result = 31 * result + v2.hashCode();
        result = 31 * result + weight;
        return result;
    }
}

class Graph {
    private Set<Vertex> vertices;
    private Set<Edge> edges;
    private Map<Vertex, Set<Edge>> adjList;

    public Graph() {
        vertices = new HashSet<>();
        edges = new HashSet<>();
        adjList = new HashMap<>();
    }

    public boolean addVertex(int label) {
        return vertices.add(new Vertex(label));
    }

    public boolean addVertex(Vertex v) {
        return vertices.add(v);
    }

    public boolean addVertices(Collection<Vertex> vertices) {
        return this.vertices.addAll(vertices);
    }

    public boolean removeVertex(int label) {
        return vertices.remove(new Vertex(label));
    }

    public boolean removeVertex(Vertex v) {
        return vertices.remove(v);
    }

    public boolean addEdge(Edge e) {
        if (!edges.add(e)) return false;

        adjList.putIfAbsent(e.v1, new HashSet<>());
        adjList.putIfAbsent(e.v2, new HashSet<>());

        adjList.get(e.v1).add(e);
        adjList.get(e.v2).add(e);

        return true;
    }

    public boolean addEdge(int vertexLabel1, int vertexLabel2) {
        return addEdge(new Edge(new Vertex(vertexLabel1),
                                new Vertex(vertexLabel2)));
    }

    public boolean removeEdge(Edge e) {
        if (!edges.remove(e)) return false;
        Set<Edge> edgesOfV1 = adjList.get(e.v1);
        Set<Edge> edgesOfV2 = adjList.get(e.v2);

        if (edgesOfV1 != null) edgesOfV1.remove(e);
        if (edgesOfV2 != null) edgesOfV2.remove(e);

        return true;
    }

    public boolean removeEdge(int vertexLabel1, int vertexLabel2) {
        return removeEdge(new Edge(new Vertex(vertexLabel1),
                                   new Vertex(vertexLabel2)));
    }

    public Set<Vertex> getAdjVertices(Vertex v) {
        return adjList.get(v).stream()
                      .map(e -> e.v1.equals(v) ? e.v2 : e.v1)
                      .collect(Collectors.toSet());
    }

    public Set<Vertex> getVertices() {
        return Collections.unmodifiableSet(vertices);
    }

    public Set<Edge> getEdges() {
        return Collections.unmodifiableSet(edges);
    }

    public Map<Vertex, Set<Edge>> getAdjList() {
        return Collections.unmodifiableMap(adjList);
    }
}
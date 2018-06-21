package seeburger.graphImplementation;



class Neighbour {
    public int vertexNum;
    public Neighbour next;

    public  Neighbour(int vertexNum, Neighbour neighbour){
        this.vertexNum = vertexNum;
        this.next = neighbour;


    }

}

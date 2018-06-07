package Lectures.L05_Files_and_Streams.p09_SerializeCustomObject;


import java.io.Serializable;

public class Cube implements Serializable {

    private String colour;
    private Double width;
    private Double heigth;
    private Double depth;

    public Cube(String colour, Double width, Double heigth, Double depth) {
        this.colour = colour;
        this.width = width;
        this.heigth = heigth;
        this.depth = depth;
    }


}

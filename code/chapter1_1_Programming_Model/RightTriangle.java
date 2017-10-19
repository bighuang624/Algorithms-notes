package chapter1_1_Programming_Model;

import algs4.StdDraw;

public class RightTriangle {

    public static void main(String[] args) {
        StdDraw.square(.5,  .5,  .5);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.line(.5, .5, .9, .5);
        StdDraw.line(.9, .5, .5, .8);
        StdDraw.line(.5, .5, .5, .8);
        StdDraw.circle(.7, .65, .25);

    }

}

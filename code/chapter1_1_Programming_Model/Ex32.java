package chapter1_1_Programming_Model;

import java.util.ArrayList;
import java.util.Scanner;

import algs4.StdDraw;

public class Ex32 {

    public static void main(String[] args) {
        
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> list = new ArrayList<>();
        while (scanner.hasNextDouble()) {
            list.add(scanner.nextDouble());
        }
        
        int N = Integer.parseInt(args[0]);
        double l = Double.parseDouble(args[1]),
               r = Double.parseDouble(args[2]);
        
        double length = (r - l) / N,
               start = l;
        
        while(start < r) {
            int height = 0;
            for(int i = 0; i < list.size(); i++) { 
                if(start <= list.indexOf(i) && list.indexOf(i) < start + length) {
                    height++;
                }
            }
            StdDraw.filledRectangle(start, height, length / 2, height);
            start += length;
        }

    }

}

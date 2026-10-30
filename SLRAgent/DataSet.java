package examples.SAgents.SLRAgent;

import java.util.Arrays;

public class DataSet {
    private int[] x;
    private int[] y;

    public DataSet() {

        this.x = new int[]{1, 2, 3, 4, 5};
        this.y = new int[]{3, 5, 7, 9, 11};
    }

        int[] getX() {return this.x;}
        int[] getY() {return this.y;}



    public void typeX(int []X){
        System.out.println(" X Set :" + Arrays.toString(X));
    }
    public void typeY(int []Y){
        System.out.println(" Y Set :" + Arrays.toString(Y));
    }
    }


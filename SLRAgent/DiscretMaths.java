package examples.SAgents.SLRAgent;

public class DiscretMaths {

    public DiscretMaths() {
    }

    public int sumX(int[] x) {
        int sumaX = 0;
        for (int i = 0; i < x.length; i++) {
            sumaX += x[i];
        }
        return sumaX;
    }

    public int sumY(int[] Y) {

        int sumaY = 0;
        for (int i = 0; i < Y.length; i++) {
            sumaY += Y[i];
        }
        return sumaY;
    }

    public int sumXY(int[] X, int[] Y) {

        int sumaXY = 0;
        int posX = X.length;
        int posY = Y.length;
        int i = 0;

        while (i < posX) {
            sumaXY += X[i] * Y[i];
            i++;
        }

        return sumaXY;

    }

    public int sumXsquared(int[] X) {
        int sumaXsd = 0;
        int posX = X.length;
        int i = 0;
        while (i < posX) {
            sumaXsd += Math.pow(X[i], 2);
            i++;
        }
        return sumaXsd;


    }

    public double simpleRegression(int[] X, int[] Y) {
        int sx = sumX(X);
        int sy = sumY(Y);
        int sxy = sumXY(X,Y);
        int sxSq = sumXsquared(X);
        int n = X.length;
        double upperLine = ((n * sxy) - (sx * sy));
        double  lowerLine = ((n * sxSq) - (Math.pow(sx, 2)));
double res = upperLine / lowerLine;
    return res;
    }

    double b0(int [] X, int [] Y) {

        double m = simpleRegression(X,Y);
        int sy = sumY(Y);
        int sx = sumX(X);
        int n = X.length;
        double res = (sy - (m * sx)) / n ;
return res;
    }

}


package examples.regression;

public class PolynomialRegression {

    double[] x;
    double[] y;
    int n;

    double b0;
    double b1;
    double b2;
    double r2;

    // Constructor que recibe los datos desde DataSet
    public PolynomialRegression(double[] xData, double[] yData) {
        this.x = xData;
        this.y = yData;
        this.n = xData.length;
    }

    public void fit() {
        double sx = 0, sx2 = 0, sx3 = 0, sx4 = 0;
        double sy = 0, sxy = 0, sx2y = 0;

        for (int i = 0; i < n; i++) {
            double xi = x[i];
            double yi = y[i];
            double x2 = xi * xi;

            sx += xi;
            sx2 += x2;
            sx3 += x2 * xi;
            sx4 += x2 * x2;

            sy += yi;
            sxy += xi * yi;
            sx2y += x2 * yi;
        }

        double[][] m = {
            { (double)n, sx, sx2 },
            { sx, sx2, sx3 },
            { sx2, sx3, sx4 }
        };

        double d = det(m);

        double[][] m0 = {
            { sy, sx, sx2 },
            { sxy, sx2, sx3 },
            { sx2y, sx3, sx4 }
        };

        double[][] m1 = {
            { (double)n, sy, sx2 },
            { sx, sxy, sx3 },
            { sx2, sx2y, sx4 }
        };

        double[][] m2 = {
            { (double)n, sx, sy },
            { sx, sx2, sxy },
            { sx2, sx3, sx2y }
        };

        b0 = det(m0) / d;
        b1 = det(m1) / d;
        b2 = det(m2) / d;

        calcularR2();
    }

    private double det(double[][] a) {
        return a[0][0] * (a[1][1] * a[2][2] - a[1][2] * a[2][1])
             - a[0][1] * (a[1][0] * a[2][2] - a[1][2] * a[2][0])
             + a[0][2] * (a[1][0] * a[2][1] - a[1][1] * a[2][0]);
    }

    public double predict(double val) {
        return b0 + (b1 * val) + (b2 * Math.pow(val, 2));
    }

    private void calcularR2() {
        double sumaY = 0;
        for (int i = 0; i < n; i++) {
            sumaY += y[i];
        }
        double mediaY = sumaY / n;

        double st = 0;
        double sr = 0;
        for (int i = 0; i < n; i++) {
            double yp = predict(x[i]);
            st += Math.pow(y[i] - mediaY, 2);
            sr += Math.pow(y[i] - yp, 2);
        }
        r2 = 1.0 - (sr / st);
    }

    // Getters para coincidir con la lámina
    public double getBeta0() { return b0; }
    public double getBeta1() { return b1; }
    public double getBeta2() { return b2; }
    public double calculateRSquared() { return r2; }
}
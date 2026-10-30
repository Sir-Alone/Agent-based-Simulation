public class MultipleLinearRegression {

    double[] x1, x2, y;
    double b0, b1, b2;

    public MultipleLinearRegression(double[] x1, double[] x2, double[] y) {
        this.x1 = x1;
        this.x2 = x2;
        this.y = y;
        calcular();
    }

    void calcular() {
        double n = y.length;
        double s1 = 0, s2 = 0, s11 = 0, s22 = 0, s12 = 0, sy = 0, s1y = 0, s2y = 0;

        for (int i = 0; i < y.length; i++) {
            s1 += x1[i];
            s2 += x2[i];
            s11 += x1[i] * x1[i];
            s22 += x2[i] * x2[i];
            s12 += x1[i] * x2[i];
            sy += y[i];
            s1y += x1[i] * y[i];
            s2y += x2[i] * y[i];
        }

        double[][] a = {
                {n, s1, s2},
                {s1, s11, s12},
                {s2, s12, s22}
        };
        double[] b = {sy, s1y, s2y};

        double d = det(a);
        b0 = det(cambiar(a, b, 0)) / d;
        b1 = det(cambiar(a, b, 1)) / d;
        b2 = det(cambiar(a, b, 2)) / d;
    }

    double[][] cambiar(double[][] a, double[] b, int col) {
        double[][] m = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m[i][j] = a[i][j];
            }
            m[i][col] = b[i];
        }
        return m;
    }

    double det(double[][] m) {
        return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
                - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
                + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
    }

    public double predict(double a, double b) {
        return b0 + b1 * a + b2 * b;
    }

    public double calculateRSquared() {
        double media = 0;
        for (double v : y) media += v;
        media = media / y.length;

        double sse = 0, sst = 0;
        for (int i = 0; i < y.length; i++) {
            double e = y[i] - predict(x1[i], x2[i]);
            sse += e * e;
            sst += (y[i] - media) * (y[i] - media);
        }
        return 1 - sse / sst;
    }
}
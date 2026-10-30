package examples.regression;

public class DataSet {

    private double[] x;
    private double[] y;

    public DataSet() {
        // Six Sigma: Batch Size (x) vs Machine Efficiency (y)
        this.x = new double[]{15.0, 18.0, 20.0, 25.0, 30.0, 35.0, 40.0, 45.0, 50.0, 55.0};
        this.y = new double[]{22.5, 27.8, 31.2, 38.0, 44.5, 49.2, 53.1, 56.0, 57.5, 58.0};
    }

    public double[] getX() {
        return x;
    }

    public double[] getY() {
        return y;
    }
}
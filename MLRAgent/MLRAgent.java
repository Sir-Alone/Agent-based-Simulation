public class MLRAgent {

    public static void main(String[] args) {
        DataSet ds = new DataSet();
        MultipleLinearRegression mlr = new MultipleLinearRegression(ds.x1, ds.x2, ds.y);

        System.out.println("y = " + mlr.b0 + " + " + mlr.b1 + "x1 + " + mlr.b2 + "x2 - MLR");

        System.out.println("y = " + mlr.predict(3, 5));
        System.out.println("y = " + mlr.predict(9, 8));
        System.out.println("y = " + mlr.predict(10, 12));

        System.out.println("R2 = " + mlr.calculateRSquared());

        System.out.println("Agente finalizado");
    }
}
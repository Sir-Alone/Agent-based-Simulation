package examples.regression;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class PRAgent extends Agent {

    @Override
    protected void setup() {
        System.out.println("Iniciando agente " + getLocalName() + "...");
        addBehaviour(new PRBehaviour());
    }

    @Override
    protected void takeDown() {
        System.out.println("Agente " + getLocalName() + " finalizado y eliminado de la plataforma.");
    }

    private class PRBehaviour extends OneShotBehaviour {
        @Override
        public void action() {
    
            DataSet ds = new DataSet();

            PolynomialRegression pr = new PolynomialRegression(ds.getX(), ds.getY());
            pr.fit();

            double beta0 = pr.getBeta0();
            double beta1 = pr.getBeta1();
            double beta2 = pr.getBeta2();

            System.out.println("\nEcuacion de regresion calculada:");
            System.out.println("y = " + beta0 + " + (" + beta1 + " * x) + (" + beta2 + " * x^2)");
            System.out.println("Parametros: beta_0 = " + beta0 + ", beta_1 = " + beta1 + ", beta_2 = " + beta2);

            double[] pruebas = {22.0, 38.0, 60.0};
            System.out.println("\nPredicciones:");
            for (int i = 0; i < pruebas.length; i++) {
                double xVal = pruebas[i];
                double yPred = pr.predict(xVal);
                System.out.println("Prediccion " + (i + 1) + " (x=" + xVal + "): y = " + yPred);
            }

            double rSquared = pr.calculateRSquared();
            System.out.println("\nCoeficiente R^2: " + rSquared);

            // 6. Fin de la ejecucion: el agente muere
            doDelete();
        }
    }
}

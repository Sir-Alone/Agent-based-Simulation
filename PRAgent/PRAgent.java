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
            // 1. Abstracción del DataSet
            DataSet ds = new DataSet();

            // 2. Instanciar la Regresión Polinomial pasando los datos
            PolynomialRegression pr = new PolynomialRegression(ds.getX(), ds.getY());
            pr.fit();

            // 3. Obtener parámetros óptimos
            double beta0 = pr.getBeta0();
            double beta1 = pr.getBeta1();
            double beta2 = pr.getBeta2();

            System.out.println("\nEcuacion de regresion calculada:");
            System.out.println("y = " + beta0 + " + (" + beta1 + " * x) + (" + beta2 + " * x^2)");
            System.out.println("Parametros: beta_0 = " + beta0 + ", beta_1 = " + beta1 + ", beta_2 = " + beta2);

            // 4. Realizar y mostrar tres predicciones
            double[] pruebas = {22.0, 38.0, 60.0};
            System.out.println("\nPredicciones:");
            for (int i = 0; i < pruebas.length; i++) {
                double xVal = pruebas[i];
                double yPred = pr.predict(xVal);
                System.out.println("Prediccion " + (i + 1) + " (x=" + xVal + "): y = " + yPred);
            }

            // 5. Calcular R^2
            double rSquared = pr.calculateRSquared();
            System.out.println("\nCoeficiente R^2: " + rSquared);

            // 6. Fin de la ejecucion: el agente muere
            doDelete();
        }
    }
}
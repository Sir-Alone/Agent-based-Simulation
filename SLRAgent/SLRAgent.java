package examples.SAgents.SLRAgent;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class SLRAgent extends Agent {

  @Override
  protected void setup() {
    System.out.println("Agente SLR iniciado: " + getLocalName());
    addBehaviour(new SLRBehaviour());
  }

  private class SLRBehaviour extends OneShotBehaviour {

    @Override
    public void action() {
      DataSet dataSet = new DataSet();
      DiscretMaths maths = new DiscretMaths();

      int[] x = dataSet.getX();
      int[] y = dataSet.getY();

      double beta1 = maths.simpleRegression(x, y);
      double beta0 = maths.b0(x, y);

      System.out.println("X = " + java.util.Arrays.toString(x));
      System.out.println("Y = " + java.util.Arrays.toString(y));
      System.out.println("Beta 0 = " + beta0);
      System.out.println("Beta 1 = " + beta1);

      System.out.println("Prediction for x = 15: " + (beta0 + beta1 * 15));
      System.out.println("Prediction for x = 8: " + (beta0 + beta1 * 8));

      double promedioY = 0;
      for (int valor : y) {
        promedioY += valor;
      }
      promedioY /= y.length;

      double sumaErroresCuadrados = 0;
      double sumaTotalCuadrados = 0;

      for (int i = 0; i < y.length; i++) {
        double prediccion = beta0 + beta1 * x[i];
        sumaErroresCuadrados += Math.pow(y[i] - prediccion, 2);
        sumaTotalCuadrados += Math.pow(y[i] - promedioY, 2);
      }

      double rSquared = 1 - (sumaErroresCuadrados / sumaTotalCuadrados);
      System.out.println("R^2 = " + rSquared);

      // El agente termina después de mostrar los resultados.
      myAgent.doDelete();
    }
  }

  @Override
  protected void takeDown() {
    System.out.println("The SLR Agent has concluded.");
  }
}
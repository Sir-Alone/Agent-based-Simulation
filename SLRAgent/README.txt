Para compilacion en caso de modificacion:

javac -cp "C:\Users\braul\jade\lib\jade.jar" -d "C:\Users\braul\jade\classes" "C:\Users\braul\jade\classes\examples\SAgents\SLRAgent\DataSet.java" "C:\Users\braul\jade\classes\examples\SAgents\SLRAgent\DiscretMaths.java" "C:\Users\braul\jade\classes\examples\SAgents\SLRAgent\SLRAgent.java"

Para Inicializacion:

java -cp "C:\Users\braul\jade\lib\jade.jar;C:\Users\braul\jade\classes" jade.Boot -gui -agents "slr:examples.SAgents.SLRAgent.SLRAgent"
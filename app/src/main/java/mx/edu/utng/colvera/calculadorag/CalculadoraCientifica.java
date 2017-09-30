package mx.edu.utng.colvera.calculadorag;

/**
 * Created by Ganzo on 29/09/2017.
 */


public class CalculadoraCientifica implements Calculadora {

    @Override
    public double sumar(double num1, double num2) {

        return num1+num2;
    }

    @Override
    public double restar(double num1, double num2) {
        return num1-num2;
    }

    public double factorial(double num1){ //Método recursivo
        if(num1==0){
            return 1;
        }else{
            return num1*factorial(num1-1);
        }
    }

}

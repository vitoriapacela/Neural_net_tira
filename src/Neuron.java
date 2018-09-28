import java.util.*;

/**
 * @author Vitoria Barin Pacela <vitoria.barinpacela@helsinki.fi>
 */

public class Neuron {
    // learning rate
    double LR = 0.01; 

    Neuron[] n_inputs;
    double[] n_weights;
    double n_output;
    double error;
    double[] sig = new double[200];

    Neuron() {
        error = 0.0;
    }

    Neuron(Neuron[] previous_n_inputs) {
        n_inputs = new Neuron[previous_n_inputs.length];
        n_weights = new double[previous_n_inputs.length];
        error = 0.0;

        Random randomno = new Random();

        for (int i = 0; i < n_inputs.length; i++) {
            n_inputs[i] = previous_n_inputs[i];
            n_weights[i] = 2 * radomno.nextDouble() - 1;   ;
        }
    }

    /**
     * Neuron's response to the input.
     */
    void respond() {
        double input = 0.0;

        for (int i = 0; i < n_inputs.length; i++) {
            input += n_inputs[i].n_output * n_weights[i];
        }
        n_output = lookupSigmoid(input);
        error = 0.0;
    }

    /**
     * Sets training error.
     * @param desired_error output error.
     */
    void setError(double desired_error) {
        error = desired_error - n_output;
    }

    /**
     * Trains neuron.
     */
    void train() {
        double delta = (1.0 - n_output)*(1.0 + n_output) * error * LR;

        for (int i = 0; i < n_inputs.length; i++) {
            n_inputs[i].error += n_weights[i] * error;
            n_weights[i] += n_inputs[i].n_output * delta;
        }
    }

    /**
     * Accesses value of the sigmoid function.
     * @param x value desired for obtaining sigmoid(x).
     */ 
    double lookupSigmoid(double x) {
        // to implement: constrain
        return sig[(int) Math.floor((x + 5.0) * 20.0)];
        }

    /**
     * Initializes g_sigmoid array with values of the sigmoid function for each index.
     */
    void setupSigmoid() {
        for (int i = 0; i < 200; i++) {
        double x = (i / 20.0) - 5.0;
        sig[i] = 2.0 / (1.0 + Math.exp(-2.0 * x)) - 1.0;
        }
    }
}
import java.util.*;

public class Neuron {
    double LR = 0.01; // learning rate

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

        for (int i = 0; i < n_inputs.length; i++) {
            n_inputs[i] = previous_n_inputs[i];
            n_weights[i] = random(-1.0, 1.0);
        }
    }

    void respond() {
        // responds to the image
        double input = 0.0;

        for (int i = 0; i < n_inputs.length; i++) {
            input += n_inputs[i].n_output * n_weights[i];
        }
        n_output = lookupSigmoid(input);
        error = 0.0;
    }

    void setError(double desired_error) {
        error = desired_error - n_output;
    }

    void train() {
        double delta = (1.0 - n_output)*(1.0 + n_output) * error * LR;

        for (int i = 0; i < n_inputs.length; i++) {
            n_inputs[i].error += n_weights[i] * error;
            n_weights[i] += n_inputs[i].n_output * delta;
        }
    }
}
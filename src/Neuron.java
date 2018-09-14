public class Neuron {
    // learning rate
    float LR = 0.01;

    Neuron[] n_inputs;
    float[] n_weights;
    float n_output;
    float error;
    float[] sig = new float[200];

    Neuron() {
        error = 0.0;
    }

    Neuron(Neuron[] previous_n_inputs) {
        n_inputs = new Neuron[previous_n_inputs.length];
        n_weights = new float[previous_n_inputs.length];
        error = 0.0;

        for (int i = 0; i < n_inputs.length; i++) {
            n_inputs[i] = previous_n_inputs[i];
            n_weights[i] = random(-1.0, 1.0);
        }
    }

    void setupSigmoid() {
        for (int i = 0; i < 200; i++) {
            float x = (i / 20.0) - 5.0;
            sig[i] = 2.0 / (1.0 + exp(-2.0 * x) - 1.0);
        }
    }

    float lookupSigmoid(float x) {
        return sig[constrain((int) floor((x + 5.0)*20.0), 0, 199)];
    }

    void respond() {
        // responds to the image
        float input = 0.0;

        for (int i = 0; i < n_inputs.length; i++) {
            input += n_inputs[i].n_output * n_weights[i];
        }
        n_output = lookupSigmoid(input);
        error = 0.0;
    }

    void setError(float desired_error) {
        error = desired_error - n_output;
    }

    void train() {
        float delta = (1.0 - n_output)*(1.0 + n_output) * error * LR;

        for (int i = 0; i < n_inputs.length; i++) {
            n_inputs[i].error += n_weights[i] * error;
            n_weights[i] += n_inputs[i].n_output * delta;
        }
    }

    void display() {
        stroke(200);
        fill(128 * (1 - n_output)); // scales value from [-1, 1] to [0, 255]
        ellipse(0, 0, 16, 16);
    }

}
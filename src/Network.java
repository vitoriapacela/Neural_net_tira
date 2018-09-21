import java.util.*;

/**
 * @author Vitoria Barin Pacela <vitoria.barinpacela@helsinki.fi>
 */

public class Network {

    Neuron[] inp_layer;
    Neuron[] hidden_layer;
    Neuron[] output_layer;
    int index = 0;

    Network(int inputs, int hidden, int out) {
        inp_layer = new Neuron[inputs];
        hidden_layer = new Neuron[hidden];
        output_layer = new Neuron[out];

        for (int i = 0; i < inp_layer.length; i++) {
            inp_layer[i] = new Neuron();
        }

        for (int j = 0; j < hidden_layer.length; j++) {
            hidden_layer[j] = new Neuron(inp_layer);
        }

        for (int k = 0; k < output_layer.length; k++) {
            output_layer[k] = new Neuron(hidden_layer);
        }
    }

    /**
     * Every layer of the network responds to its input.
     * @param image input image.
     */
    void respond(Image image) {
        for (int i = 0; i < inp_layer.length; i++) {
            inp_layer[i].n_output = image.features[i];
        }

        for (int j = 0; j < hidden_layer.length; j++) {
            hidden_layer[j].respond();
        }

        for (int k = 0; k < output_layer.length; k++) {
            output_layer[k].respond();
        }
    }
    
    /**
     * Trains every neuron of every layer of the network.
     * Backpropagation implemented.
     * @param outputs output response from respond() over the input.
     */
    void train(double[] outputs) {
        for (int a = 0; a < output_layer.length; a++) {
            output_layer[a].setError(outputs[a]);
            output_layer[a].train();
        }

        double best = -1.0;
        for (int b = 0; b < output_layer.length; b++) {
            if (output_layer[b].n_output > best) {
                index = b;
            }
        }

        for (int c = 0; c < hidden_layer.length; c++) {
            hidden_layer[c].train();
        } 
    }
}
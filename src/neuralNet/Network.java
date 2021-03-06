/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralNet;


/**
 * Build the neural network layer by layer (input, hidden, and output) and train it.
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
    void respond(MnistMatrix image) {
        for (int i = 0; i < inp_layer.length; i++) {
            inp_layer[i].n_output = (double) image.features[i];
            //System.out.println(inp_layer[i].n_output); seems to be working, prints pixels
        }

        for (Neuron hidden_layer1 : hidden_layer) {
            hidden_layer1.layerRespond();
        }

        for (Neuron output_layer1 : output_layer) {
            output_layer1.layerRespond();
        }
    }
    
    /**
     * Trains the network layer by layer.
     * Backpropagation.
     * @param outputs one-hot encoded label.
     */
    void train(double[] outputs) {
        for (int a = 0; a < output_layer.length; a++) {
            output_layer[a].setError(outputs[a]);
            output_layer[a].trainLayer();
        }

        double best = -1.0;
        for (int b = 0; b < output_layer.length; b++) {
            if (output_layer[b].n_output > best) {
                index = b;
            }
        }

        for (Neuron hidden_layer1 : hidden_layer) {
            hidden_layer1.trainLayer();
        } 
    }
    
    public double[] getNetworkOutput() {
        double[] outputs = new double[this.output_layer.length];
        for (int k = 0; k < output_layer.length; k++) {
            double out = this.output_layer[k].getNeuronOutput();
            outputs[k] = out;
        }
        return outputs;
    }
    
    public int printOutput() {
        double max = 0;
        int digit = -1;
        double[] outputs = this.getNetworkOutput();
        for (int k = 0; k < output_layer.length; k++) {
            //System.out.println(outputs[k]);
            if (outputs[k] > max) {
                max = outputs[k];
                digit = k;
            }
        }
        return digit;
    }   

}
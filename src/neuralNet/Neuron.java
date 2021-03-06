/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralNet;

import java.util.*;

/**
 * Initialize and train perceptron (neuron).
 * @author Vitoria Barin Pacela <vitoria.barinpacela@helsinki.fi>
 */

public class Neuron {
    // learning rate
    double LR = 0.01; 

    Neuron[] layer_inputs;
    double[] layer_weights;
    double n_output;
    double error;

    Neuron() {
        error = 0.0;
    }

    Neuron(Neuron[] previous_n_inputs) {
        layer_inputs = new Neuron[previous_n_inputs.length];
        layer_weights = new double[previous_n_inputs.length];
        error = 0.0;        
        
        Random randomno = new Random();
        
        for (int i = 0; i < layer_inputs.length; i++) {
            layer_inputs[i] = previous_n_inputs[i];
            layer_weights[i] = 2 * randomno.nextDouble() - 1;
            //System.out.println(n_weights[i]); works, makes random weights
            //System.out.println(n_inputs[i].n_output); everything will be 0, works
        }
    }

    /**
     * Layer of Neurons' response to the input.
     */
    void layerRespond() {
        double inputSum = 0.0;

        for (int i = 0; i < layer_inputs.length; i++) {
            inputSum += layer_inputs[i].n_output * layer_weights[i];
            //System.out.println(inputSum);
        }
        //System.out.println(inputSum);
        n_output = getSigmoid(inputSum);
        //System.out.println(n_output);
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
    void trainLayer() {
        double delta = (1.0 - n_output) * (1.0 + n_output) * error * LR;

        for (int i = 0; i < layer_inputs.length; i++) {
            layer_inputs[i].error += layer_weights[i] * error;
            layer_weights[i] += layer_inputs[i].n_output * delta;
            //System.out.println(n_weights[i]); seems to be working
        }
    }
    
    public double getSigmoid(double x) {
        return 1.0 / (1.0 + Math.exp(-1.0 * x));
    }
    
    public double getNeuronOutput() {
        return this.n_output;
    }
    
    public double getError() {
        return this.error;
    }
    
    public void printInputs() {
        for (Neuron n_input : this.layer_inputs) {
            System.out.println(n_input.getNeuronOutput());
        }
    }

}


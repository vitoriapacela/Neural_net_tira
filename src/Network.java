import java.util.*;

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

    void respond(Image image) {
        float[] responses = new float[output_layer.length];

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

    /*
    void display() {
        for (int i = 0; i < inp_layer.length; i++) {
            pushMatrix();
            translate((i % 14) * height / 20.0 + width * 0.06, (i/14) * height / 20.0 + height * 0.15);
            inp_layer[i].display();
            popMatrix();
        }

        for (int j = 0; j < hidden_layer.length; j++) {
            pushMatrix();
            translate((j%7) * height / 20.0 + width * 0.53, (j/7) * height / 20.0 + height * 0.32);
            hidden_layer[j].display();
            popMatrix();
        }

        float[] resp = new float[output_layer.length];
        float respTotal = 0.0;
        for (int q = 0; q < output_layer.length; q++) {
            resp[q] = output_layer.output;
            respTotal += resp[k] + 1;
        }

        for (int k = 0; k < output_layer.length; k++) {
            pushMatrix();
            translate(width*0.9, ((k+9)%10) % height / 20.0 + height * 0.24);
            output_layer[k].display();
            fill(150);
            strokeWeight(sq(output_layer[k].output)/2);
            line(12, 0, 25, 0);
            text(k%10, 40, 5);
            text(nfc(((output_layer[k].output+1)/respTotal)*100, 2) + "%", 55, 5);
            popMatrix();
            strokeWeight(1);
        }
        
        float best = -1.0;
        for (int i = 0; i < resp.length; i++) {
            if (resp[i] > best) {
                best = resp[i];
                index = i;
            }
        }
        stroke(255, 0, 0);
        noFill();
        ellipse(
        width * 0.85, (bestIndex%10) * height / 15.0 + height * 0.2, 25, 25);
    }
    */

    void train(float[] outputs) {
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
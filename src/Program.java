/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


/**
 * @author Vitoria Barin Pacela <vitoria.barinpacela@helsinki.fi>
 */

public final class Program {
    Network nn;
    
    double[] g_sigmoid = new double[200];
    
    MnistMatrix[] train_set;
    MnistMatrix[] test_set;

    int test_card = 0;
    int train_card = 0;
    
    void setup() {
        setupSigmoid();
        nn = new Network(196, 49, 10);
    }

    public Program() throws IOException {
        this.train_set = new MnistDataReader().readData("resources/train-images.idx3-ubyte", "resources/train-labels.idx1-ubyte");
        this.test_set = new MnistDataReader().readData("resources/t10k-images.idx3-ubyte", "resources/t10k-labels.idx1-ubyte");
        printMnistMatrix(train_set[0]);
        //printMnistMatrix(test_set[0]);
        setup();

        // Train
        for (int i = 0; i < 500; i++) {
            train_card = (int) Math.floor(Math.random() * train_set.length);
            nn.respond(train_set[train_card]);
            nn.train(train_set[train_card].outputs);
          }

        // Test
        test_card = (int) Math.floor(Math.random()*test_set.length);
        nn.respond(test_set[test_card]);
    }

    private static void printMnistMatrix(final MnistMatrix matrix) {
        System.out.println("label: " + matrix.getLabel());
        for (int r = 0; r < matrix.getNumberOfRows(); r++ ) {
            for (int c = 0; c < matrix.getNumberOfColumns(); c++) {
                System.out.print(matrix.getValue(r, c) + " ");
            }
            System.out.println();
        }
    }
    
/**
 * Initializes g_sigmoid array with values of the sigmoid function for each index.
 */
public void setupSigmoid() {
    for (int i = 0; i < 200; i++) {
      double x = (i / 20.0) - 5.0;
      g_sigmoid[i] = 2.0 / (1.0 + Math.exp(-2.0 * x)) - 1.0;
    }
  }

  
/**
 * Accesses value of the sigmoid function.
 * @param x value desired for obtaining sigmoid(x).
     * @return value of sigmoid(x)
 */  
public double lookupSigmoid(double x) {
    // to implement: constrain
    return g_sigmoid[(int) Math.floor((x + 5.0) * 20.0)];
    }
}


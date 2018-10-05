/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralNet;

import java.io.IOException;

/**
 * Main program run. Read the data into training and test sets, initialize the neural network, and train it.
 * @author Vitoria Barin Pacela <vitoria.barinpacela@helsinki.fi>
 */

public final class Program {
    Network nn;
    
    MnistMatrix[] train_set;
    MnistMatrix[] test_set;

    int test_card = 0;
    int train_card = 0;
    
    /**
     * Build neural network.
     */
    void setup() {
        nn = new Network(784, 49, 10);
    }

    /**
     * Read MNIST data and put it into train and test sets.
     * @throws IOException 
     */
    public Program() throws IOException {
        this.train_set = new MnistDataReader().readData("resources/train-images.idx3-ubyte", "resources/train-labels.idx1-ubyte");
        this.test_set = new MnistDataReader().readData("resources/t10k-images.idx3-ubyte", "resources/t10k-labels.idx1-ubyte");
        //printMnistMatrix(train_set[0]);
        //printMnistMatrix(test_set[0]);
        setup();

        // Train set
        for (int i = 0; i < 500; i++) {
            train_card = (int) Math.floor(Math.random() * train_set.length);
            nn.respond(train_set[train_card]);
            nn.train(train_set[train_card].outputs);
          }

        // Test set
        test_card = (int) Math.floor(Math.random() * test_set.length);
        nn.respond(test_set[test_card]);
    }

    /**
     * Print MNIST Matrix details, such as label and values.
     * @param matrix 
     */
    private static void printMnistMatrix(final MnistMatrix matrix) {
        System.out.println("label: " + matrix.getLabel());
        for (int r = 0; r < matrix.getNumberOfRows(); r++ ) {
            for (int c = 0; c < matrix.getNumberOfColumns(); c++) {
                System.out.print(matrix.getValue(r, c) + " ");
            }
            System.out.println();
        }
    }
}


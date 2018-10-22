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
    
    // data loading time in minutes
    double dLMin;
    // training time in minutes
    double tMin;
    // inference time on the test set in minutes
    double iMin;
    // error rate on the test set
    double errorRate;
    
    /**
     * Build neural network.
     */
    void setup(int numberHidden) {
        nn = new Network(784, numberHidden, 10);
    }

    /**
     * Read MNIST data and put it into train and test sets.
     * @param numberHidden number of neurons in the hidden layer.
     * @throws IOException 
     */
    public Program(int numberHidden) throws IOException {
        final long startTime = System.currentTimeMillis();
        
        this.train_set = new MnistDataReader().readData("resources/train-images.idx3-ubyte", "resources/train-labels.idx1-ubyte");
        this.test_set = new MnistDataReader().readData("resources/t10k-images.idx3-ubyte", "resources/t10k-labels.idx1-ubyte");
        
        final long dataLoadTime = System.currentTimeMillis() - startTime;
        System.out.println("Data Loading time (min):");
        dLMin = ((double)dataLoadTime) / (1000.0 * 60.0);
        System.out.println(dLMin);
        
        setup(numberHidden);

        // Train set
        for (int i = 0; i < 60000; i++) {
            train_card = (int) Math.floor(Math.random() * train_set.length);
            nn.respond(train_set[train_card]);
            nn.train(train_set[train_card].multiLabel);
          }
        
        final long trainTime = System.currentTimeMillis() - startTime;
        tMin = ((double)trainTime) / (1000.0 * 60.0) - dLMin;
        System.out.println("Training time (min):");
        System.out.println(tMin);

        // Test set
        test_card = (int) Math.floor(Math.random() * test_set.length);
        nn.respond(test_set[test_card]);
        
        System.out.println("prediction:");
        int pred = nn.printOutput();
        System.out.println(pred);
        
        System.out.println("true value:");
        System.out.println(test_set[test_card].label);
        
        double errorSum = 0;
        int test_iterations = 1000;
        for (int i = 0; i < test_iterations; i++) {
            test_card = (int) Math.floor(Math.random() * test_set.length);
            nn.respond(test_set[test_card]);
            int prediction = nn.printOutput();
            if (prediction != test_set[test_card].label) {
                errorSum++;
            } 
        }
        this.errorRate = errorSum / (double) test_iterations;
        
        System.out.println("error rate:");
        System.out.println(errorRate);
        
        final long inferTime = System.currentTimeMillis() - startTime;
        iMin = ((double)inferTime) / (1000.0 * 60.0) - tMin - dLMin;
        System.out.println("Test set inference time (s)");
        System.out.println(iMin*60);
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


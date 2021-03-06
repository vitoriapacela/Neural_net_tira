package neuralNet;

/**
 * Auxiliar data structure to hold in a matrix the MNIST data read with MnistDataReader.
 * Adapted from https://github.com/turkdogan/mnist-data-reader
 * @author barimpac
 */

public final class MnistMatrix {

    public int [][] data;

    public int nRows;
    public int nCols;

    public int label;
    public double[] multiLabel;
    
    public double[] features;
    //public double[] outputs;

    public MnistMatrix(int nRows, int nCols) {
        this.nRows = nRows;
        this.nCols = nCols;

        data = new int[nRows][nCols];
        multiLabel = new double[10];
        features = new double[nRows * nCols]; 
    }
    
    public int getValue(int r, int c) {
        return data[r][c];
    }
    
    public void setFeatures() {
        int idx = 0;
        for (int col = 0; col < nCols; col++) {
            for (int row = 0; row < nRows; row++) {
                features[idx] = (double) data[row][col];
                //System.out.println(data[row][col]);
                //System.out.println(features[idx]);
                idx++;
            }
        }
    }
    
    public void normalizeFeatures() {
        double max = 0;
        for (double feature : features) {
            if (feature > max) {
                max = feature;
            }
        }
        for (int i = 0; i < features.length; i++) {
            features[i] = features[i]/max;
        }
    }

    /**
     * Set values of the image matrix containing one digit from MNIST.
     * @param row row pixel
     * @param col column pixel
     * @param value pixel value
     */
    public void setValue(int row, int col, int value) {
        data[row][col] = value;
    }

    /**
     * Get the ground truth value of the image (between 0 and 9).
     * @return label value.
     */
    public int getLabel() {
        return label;
    }

    /**
     * Set the label value.
     * @param label 
     */
    public void setLabel(int label) {
        this.label = label;
    }

    /**
     * Number of rows in the image matrix.
     * @return number of rows.
     */
    public int getNumberOfRows() {
        return nRows;
    }

    /**
     * Number of columns in image matrix.
     * @return number of columns.
     */
    public int getNumberOfColumns() {
        return nCols;
    }
    
    public void setLabel() {
        for (int i = 0; i < 10; i++) {
            if (this.label == i) {
                this.multiLabel[i] = 1.0;
            }
            else {
                this.multiLabel[i] = 0.0;
            }
        }
    }
}
package neuralNet;

public final class MnistMatrix {

    public int [][] data;

    public int nRows;
    public int nCols;

    public int label;
    
    public int[] features;
    public double[] outputs;

    public MnistMatrix(int nRows, int nCols) {
        this.nRows = nRows;
        this.nCols = nCols;

        data = new int[nRows][nCols];
        
        features = new int[nRows * nCols];
        this.setFeatures();
        
        outputs = new double[10];
        this.setOutputs();
    }
    
    

    public int getValue(int r, int c) {
        return data[r][c];
    }
    
    public void setFeatures() {
        int idx = 0;
        for (int col = 0; col < nCols; col++) {
            for (int row = 0; row < nRows; row++) {
                features[idx] = data[row][col];
                idx++;
            }
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

    /**
     * Set the correct index in output[] to +1 if it corresponds to the ouput and -1 if not.
     */
    public void setOutputs() {
      for (int i = 0; i < 10; i++) {
        if (i == label) {
          outputs[i] = 1.0;
        } else {
          outputs[i] = -1.0;
        }
      }
    }
}
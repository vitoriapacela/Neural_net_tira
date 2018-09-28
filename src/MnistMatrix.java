package javaapplication1;

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

    public void setValue(int row, int col, int value) {
        data[row][col] = value;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public int getNumberOfRows() {
        return nRows;
    }

    public int getNumberOfColumns() {
        return nCols;
    }

    public void setOutputs() {
      for (int i = 0; i < 10; i++) {  // We then set the correct index in output[] to +1 if it corresponds to the ouput and -1 if not
        if (i == label) {
          outputs[i] = 1.0;
        } else {
          outputs[i] = -1.0;
        }
      }
    }
}
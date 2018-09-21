import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author Vitoria Barin Pacela <vitoria.barinpacela@helsinki.fi>
 */

public class Main {
    Network nn;
    
    double[] g_sigmoid = new double[200];
    
    Image[] test_set;
    Image[] train_set;

    int test_card = 0;
    int train_card = 0;
    
    void setup() {
        setupSigmoid();
        loadData();
        nn = new Network(196, 49, 10);
    }

    public void main(String[] args) {
        setup();

        // Train
        for (int i = 0; i < 500; i++) {
            train_card = (int) Math.floor(Math.random()*train_set.length);
            nn.respond(train_set[train_card]);
            nn.train(train_set[train_card].targets);
          }

        // Test
        test_card = (int) Math.floor(Math.random()*test_set.length);
        nn.respond(test_set[test_card]);
    }

    /**
     * Loads MNIST data in train and test set arrays.
     * Expects files with names "t10k-images-14x14-idx3-ubyte" and
     * "t10k-labels-idx1-ubyte" in the same src/ directory.
     */
    void loadData(){
        File images_file = new File("t10k-images-14x14-idx3-ubyte");
        File labels_file = new File("t10k-labels-idx1-ubyte");
        byte[] images = null;
        byte[] labels = null;

        try{
            images = Files.readAllBytes(images_file.toPath());
        }catch(IOException e) {
            e.printStackTrace();
        }

        try{
            labels = Files.readAllBytes(labels_file.toPath());
        }catch(IOException ex) {
            ex.printStackTrace();
        }
        
        train_set = new Image[8000];
        int tr = 0;
        
        test_set = new Image[2000];
        int test = 0;
    
        for (int i = 0; i < 10000; i++) {
            if ( i % 5 != 0) {
                train_set[tr] = new Image();
                train_set[tr].loadImg(images, 16 + 196*i);
                train_set[tr].loadLabel(labels, 8 + i);
                tr++;
            }
            else {
                test_set[test] = new Image();
                test_set[test].loadImg(images, 16 + 196*i);
                test_set[test].loadLabel(labels, 8 + i);
                test++;
            } 
        }  
    }

/**
 * Initializes g_sigmoid array with values of the sigmoid function for each index.
 */
void setupSigmoid() {
    for (int i = 0; i < 200; i++) {
      double x = (i / 20.0) - 5.0;
      g_sigmoid[i] = 2.0 / (1.0 + Math.exp(-2.0 * x)) - 1.0;
    }
  }

  
/**
 * Accesses value of the sigmoid function.
 * @param x value desired for obtaining sigmoid(x).
 */  
double lookupSigmoid(double x) {
    // to implement: constrain
    return g_sigmoid[(int) Math.floor((x + 5.0) * 20.0)];
    }
}

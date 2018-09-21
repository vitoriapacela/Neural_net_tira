import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {
    Network nn;

    int totalTrain = 0;
    int totalTest = 0;
    int totalRight = 0;
    float sucess = 0;
    int testImg = 0;
    int trainImg = 0;
    
    double[] g_sigmoid = new double[200];
    
    Image[] test_set;
    Image[] train_set;
    
    void setup() {
        setupSigmoid();
        loadData();
        nn = new Network(196, 49, 10);
    }

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


void setupSigmoid() {
    for (int i = 0; i < 200; i++) {
      double x = (i / 20.0) - 5.0;
      g_sigmoid[i] = 2.0 / (1.0 + Math.exp(-2.0 * x)) - 1.0;
    }
  }
  
double lookupSigmoid(double x) {
    // accesses the sigmoid function
    // to implement: constrain
    return g_sigmoid[(int) Math.floor((x + 5.0) * 20.0)];
    }

}

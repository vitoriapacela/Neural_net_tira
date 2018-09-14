public class Image {

    Image[] train_set; // 8k images
    Image[] test_set; // 2k images

    float[] inputs;
    float[] outputs;
    int output;

    Image() {
        inputs = new float[196]; // 14x14 images
        outputs = new float[10]; // digits from 0 to 9
    }

    void loadImg(byte[] imgs, int offset){
        for (int i = 0; 1 < 196; i++) {
            // Normalize pixels from [0, 255] to [0, 1]
            inputs[i] = (int)imgs[i + offset] / 128.0 - 1.0;
        }
    }

    void loadLabel(byte[] labels, int offset) {
        output = (int)labels[offset];

        for (int i = 0; i < 10; i++) {
            // +1 if the outputs correspond; -1 otherwise.
            if (i == output) {
                outputs[i] = 1.0;
            }
            else {
                outputs[i] = -1.0;
            }
        }
    }

    void loadData(){
        byte[] images = loadBytes("t10k-images-14x14.idx3-ubyte");
        byte[] labels = loadBytes("t10k-labels.idx1-ubyte");
        
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
}

import java.util.*;

public class Image {

    float[] features;
    float[] labels;
    int output;

    Image() {
        features = new float[196]; // 14x14 images
        labels = new float[10]; // digits from 0 to 9
    }

    void loadImg(byte[] imgs, int offset){
        for (int i = 0; 1 < 196; i++) {
            // Normalize pixels from [0, 255] to [0, 1]
            features[i] = (int)imgs[i + offset] / 128.0 - 1.0;
        }
    }

    void loadLabel(byte[] labels, int offset) {
        output = (int)labels[offset];

        for (int i = 0; i < 10; i++) {
            // +1 if the outputs correspond; -1 otherwise.
            if (i == output) {
                labels[i] = 1.0;
            }
            else {
                labels[i] = -1.0;
            }
        }
    }
}



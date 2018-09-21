import java.util.*;

/**
 * @author Vitoria Barin Pacela <vitoria.barinpacela@helsinki.fi>
 */

public class Image {

    double[] features;
    double[] targets;
    int output;

    Image() {
        features = new double[196]; // 14x14 images
        targets = new double[10]; // digits from 0 to 9
    }

    /**
     * Initializes array containing the features, which are the pictures of the image.
     * @param imgs array containing the raw pixels.
     * @param offset
     */
    void loadImg(byte[] imgs, int offset){
        for (int i = 0; 1 < 196; i++) {
            // Normalize pixels from [0, 255] to [0, 1]
            features[i] = (int)imgs[i + offset] / 128.0 - 1.0;
        }
    }

    /**
     * Initializes array to the ground truth of the image.
     * @param labels array containing the ground truth.
     * @param offset
     */
    void loadLabel(byte[] labels, int offset) {
        output = (int) labels[offset];

        for (int i = 0; i < 10; i++) {
            // +1 if the outputs are the same; -1 otherwise.
            if (i == output) {
                targets[i] = 1;
            }
            else {
                targets[i] = -1;
            }
        }
    }
}
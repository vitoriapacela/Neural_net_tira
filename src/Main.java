public class Main {
    Network nn;

    int totalTrain = 0;
    int totalTest = 0;
    int totalRight = 0;
    float sucess = 0;
    int testImg = 0;
    int trainImg = 0;
    
    Button trainB, testB;
    
    void setup() {
        size(1000, 400);
        setupSigmoid();
        loadData();
        nn = new Network(196, 49, 10);
        test_set = new Image();
        train_set = new Image();
        smooth();
        stroke(150);
    
        trainB = new Button(width*0.06, height*0.9, "Train");
        testB = new Button(width*011, height*0.9, "Test");
    }
    
    void draw() {
        //nn.respond(test_set[imgNum]);
        background(255);
        nn.display();
    
        fill(100);
        text("Test image: #" + testImg, width*0.18, height*0.89);
        text("Train image: " + trainImg, width*0.18, height*0.93);
        
        text("Total train: " + totalTrain, width*0.32, height*0.89);
        text("Total test: " + totalTest, width*0.32, height*0.93);
        
        if (totalTest > 0) {
            sucess = (float)totalRight / (float)totalTest;
        }
        text("Success rate: " + nfc(sucess, 2), width*0.44, height*0.89);
        text("Image label: " + test_set[testImg].output, width*0.44, height*0.93);
    
        trainB.display();
        testB.display();
    }
    
    void mousePressed() {
        if (trainB.hover()) {
            for (int i = 0; i < 500; i++) {
                trainImg = (int) floor(random(0, train_set.length));
                nn.respond(train_set[trainImg]);
                nn.train(train_set[trainImg].outputs);
                totalTrain++;
            }
        }
    
        else if (testB.hover()) {
            testImg = (int) floor(random(0, test_set.length));
            nn.respond(test_set[testImg]);
            nn.display();
    
            if (nn.index == test_set[testImg].output) {
                totalRight++;
            }
    
            println(testImg + " " + nn.index + " " + test_set[testImg].output);
            totalTest++;
        }
        redraw();
    }
}

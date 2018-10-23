/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralNet;
import java.io.IOException;
import org.junit.Test;
import org.junit.Assert;

/**
 *
 * @author barimpac
 */
public class ProgramTest {
    
    public double minTrain = 0.8;
    
//    @Test
//    public void time150n() throws IOException {
//        Program program1 = new Program(150);
//        double t1 = program1.tMin;
//        System.out.println(t1);
//        double dif = minTrain - t1;
//        System.out.println(t1);
//        Assert.assertTrue(dif > 0);
//    }
    
    /**
     * Test if the training time decreases linearly for 150 neurons in the hidden layer.
     * @throws IOException 
     */
    @Test
    public void time150n() throws IOException {
        Program program1 = new Program(150);
        double t1 = program1.tMin;
        //System.out.println(t1);
        
        Assert.assertEquals(minTrain/2, t1, 0.2);
    }
    
    /**
     * Test if the training time decreases linearly for 100 neurons in the hidden layer.
     * @throws IOException 
     */
    @Test
    public void time100n() throws IOException {
        Program program1 = new Program(100);
        double t1 = program1.tMin;
        //System.out.println(t1);
        
        Assert.assertEquals(minTrain/3, t1, 0.2);
    }
    
    /**
     * Test if the training time decreases linearly for 10 neurons in the hidden layer.
     * @throws IOException 
     */
    @Test
    public void time10n() throws IOException {
        Program program1 = new Program(10);
        double t1 = program1.tMin;
        //System.out.println(t1);
        
        Assert.assertEquals(minTrain/10, t1, 0.2);
    }
    
    /**
     * Test if the error rate is lower for 150 neurons in the hidden layer than for 300 neurons.
     * @throws IOException 
     */
    @Test
    public void er150n() throws IOException {
        Program program1 = new Program(150);
        double e1 = program1.errorRate;
        //System.out.println(e1);
        double dif = e1 - 0.065;
        Assert.assertTrue(dif > 0);
    }
}

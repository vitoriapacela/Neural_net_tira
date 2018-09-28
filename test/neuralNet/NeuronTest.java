/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author barimpac
 */

package neuralNet;

import org.junit.Test;
import org.junit.Assert;


public class NeuronTest {
    
    public void sigIsEqual(double x, double expected) { 
        // Act
        Neuron neuron = new Neuron();
        double y = neuron.lookupSigmoid(x);
        // Assert
        Assert.assertEquals(expected, y, 0.008);
    }
    
    /**
     * Test if sigmoid(6)=1 (should be true for any number greater than 6 at least)
     */
    @Test
    public void sigSix() {
        sigIsEqual(6.0, 1.0);
    }
    
    /**
     * Test if sigmoid(0)=0.5
     */
    @Test
    public void sigZero() {
        sigIsEqual(0.0, 0.5);
    }

     /**
     * Test if sigmoid(-6)=0 (should be true for any number less than -6 too)
     */
    @Test
    public void sigMSix() {        
        sigIsEqual(-6.0, 0.0);
    }
}
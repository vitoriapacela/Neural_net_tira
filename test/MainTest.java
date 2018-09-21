import java.util.*;
import org.junit.Test;
import org.junit.Assert;

/**
 * @author Vitoria Barin Pacela <vitoria.barinpacela@helsinki.fi>
 */

public class MainTest {

    /**
     * Test if setupSigmoid() has modified the array.
     */
    @Test
    public void sigmoidNotZero() {
        // Arrange
        notZero = false;
        array = false;
    
        //Act
        double[] g_sigmoid = new double[200];
        setupSigmoid();
    
        
        for (int i = 0; i < 200; i++) {
            if (g_sigmoid[i].isNull) {
                array = true;
            }
          }
    
        // Assert
        Assert.assertEquals(array, notZero);
    }
    
    /**
     * Test if sigmoid(0)=0.5
     */
    @Test
    public void sigZero() {
        // Arrange
        s_0 = 0.5;
        double x = 0.0;
    
        // Act
        y = lookupSigmoid(x);
        
        // Assert
        Assert.assertEquals(y, s_0);
    }
    

    /**
     * Test if sigmoid(6)=1 (should be true for any number greater than 6 at least)
     */
    @Test
    public void sigSix() {
        // Arrange
        s_0 = 1;
        double x = 6.0;
    
        // Act
        y = lookupSigmoid(x);
        
        // Assert
        Assert.assertEquals(y, s_0);
    }
    
    /**
     * Test if sigmoid(-6)=0 (should be true for any number less than -6 too)
     */
    @Test
    public void sigMSix() {        
        // Arrange
        s_0 = 0;
        double x = -6.0;
    
        // Act
        y = lookupSigmoid(x);
        
        // Assert
        Assert.assertEquals(y, s_0);
    }
    
    @Test
    public void setErrorToOne() {
        double correctError = 0.0;
    
        double error = 0.0;
        double out = 0.0;
        
        setError(1.0);
    
        Assert.assertEquals(error, correctError);
    }

    /*
// TO IMPLEMENT!!!
@Test
public void nonZeroSets() {

    // test if loadData() has modified the arrays.

    // Act
    Image[] test_set;
    Image[] train_set;
    loadData();
    
    for (int i = 0; i < test_set.length; i++) {
        if (test_set[])
    }

    // Assert

}
*/
}


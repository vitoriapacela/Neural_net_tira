# Testing document

## Performance
The most important test to evaluate the performance of the neural network is the error rate. It depends on the number of training and test samples, as well as the size of the neural network.

Using the default configuration, the neural network achieves an error rate of 0.06 on average, which is even less than the one described in the original paper by LeCun, which describes an error rate of 0.12.

Furthermore, I also evaluated how the number of neurons in the hidden layer affects the training time and the error rate.

In the figure below there is a plot of training time X number of neurons in the hidden layer. We can see that the linear relationship is in accordance with the time complexity explained in the Specification document.

![](neurons_trainTime.png?raw=true)

In the figure below there is a plot of error rate X number of neurons in the hidden layer. This mathematical relationship is not formally studied, but it is expected that the error rate decreases as the number of neurons increases.

![](neurons_errorRate.png?raw=true)

## NeuronTest
- Tests if the sigmoid function is set up correctly for the edge cases: 0, 6, and -6.

- Tests if the error is correctly set.

- Tests if the error is set to 0 when a neuron is constructed.

## ProgramTest
- Tests if the training time decreases linearly as the number of neurons in the hidden layer decreases.
- Tests if the error rate is lower for less neurons in the hidden layer.

## Other tests
In general I tested the functionality of my program during development with print statements, instead of test-driven development. For me it was a faster alternative, and due to time limitations I did not implement more tests for the other classes.


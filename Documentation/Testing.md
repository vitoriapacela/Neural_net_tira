# Testing document

## Performance
The most important test to evaluate the performance of the neural network is the error rate. It depends on the number of training and test samples, as well as the size of the neural network.

Using the default configuration, the neural network achieves an error rate of 0.06 on average, which is even less than the one described in the original paper by LeCun, which describes an error rate of 0.12.

![](neurons_trainTime.png?raw=true)

## NeuronTest
- Tests if the sigmoid function is set up correctly for the edge cases: 0, 6, and -6.

- Tests if the error is correctly set.

- Tests if the error is set to 0 when a neuron is constructed.


# Implementation document

## Main structure of the program
* The Main class initializes and runs the Program.
* The Program class currently initializes a neural network with three layers: input, hidden, and output.
  - the input layer contains 784 neurons, which is the number of pixels in a 28 x 28 image from the MNIST dataset.
  - the hidden layer contains 49 neurons.
  - the output layer contains 10 neurons. Each neuron represents one of the classes (digits from 0 to 9).

  The program class also reads the MNIST data into training and test sets.
It feeds the neural network with 500 images from the training set randomly sorted, and the neural network trains.
Then an image from the test set is randomly sorted so that the neural network predicts its output.
* The Network class builds the neural network layer by layer (input, hidden, and output) and contains methods to respond to the input and train it using backpropagation.
* The Neuron class initializes a single neuron and contains functions to initialize it and train it. It also contains methods to define the sigmoid function for a range of inputs, which is used when the neuron responds to its input.
* The MnistMatrix is an auxiliar data structure to hold in a matrix the MNIST data read with MnistDataReader.
* The MnistDataReader class reads MNIST data from -ubyte files and sets array of image matrixes.

## Achieved run-times
The program runs in 2 minutes and 38 seconds in total, out of which 1.88 min was spent loading the dataset, 0.75 min training, and 0.39 s classifying the test set.
Thus, the inference time is 0.39 x 10<sup>-3</sup> s/image, and the training time is 7.5 x 10<sup>-4</sup> s/image. The details of how the number of neurons in the hidden layer influence the training time are described in the Testing document.

The training time and inference time agree with the time complexity of O(n<sup>4</sup>) for forward propagation, and O(n<sup>5</sup>) for back-propagation.

In forward propagation, the activation function is computed elementwise in every layer. The matrix multiplication has a run-time of O(n<sup>3</sup>), so for all the layers we are going to have a run-time of O(n<sup>4</sup>). The activations are computed in O(n) for each layer, resulting in O(n<sup>2</sup>). Therefore, the run-time for forward propagation is O(n<sup>4</sup> + n<sup>2</sup>) = O(n<sup>4</sup>).

In back-propagation, the run-time for the delta error in gradient descent is O(n<sup>3</sup>), which is run for each (n) layer, thus resulting in O(n<sup>4</sup>). This is also the run-time for finding all the weights between a layer. Finally, the run-time of gradient descent is this run-time multiplied by the number (n) of gradient iterations. Therefore, the total run-time for back-propagation is O(n<sup>5</sup>).

## Future improvements
There are no missing features on my implementation. A visualization of the neural network could be desired, but that falls out of the scope of this project. Furthermore, if it was possible to execute the code in a GPU, we could train the model per epochs and have multiple passes through the training set. In that case, a validation set would be needed to make sure that the model does not overfit.

This program is lacking more tests, due to time limitations. However, the lack of tests does not harm the program's functionality, as explained also in the Testing document and in the Week 7 report.

## References
[Computational Complexity Of Neural Networks](https://kasperfred.com/posts/computational-complexity-of-neural-networks)



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

## Achieved run times
Not available yet.

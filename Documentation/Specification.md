# Week 1

## Brief description of the project
In this project I aim to implement artifical neural networks to identify handwritten digits from the [MNIST](http://yann.lecun.com/exdb/mnist/) dataset.

## Dataset
The dataset has a training set of 60,000 examples, and a test set of 10,000 examples.

I don't know yet if I will use all of them in my project due to limitations in processing capabilities.

## References
1. [LeCun et al., "Gradient-Based Learning Applied to Document Recognition", 1998](http://yann.lecun.com/exdb/publis/pdf/lecun-98.pdf)

2. [LeCun et al., "A Theoretical Framework for Back-Propagation", 1988](http://yann.lecun.com/exdb/publis/pdf/lecun-88.pdf)

## Models
I aim to train two models: a linear classifier (1-layer NN), and a 2-layer NN with 300 hidden units using mean square error as the loss function.

I don't know yet the difficulty in implementing those from scratch in Java, therefore these goals might change.

It has been shown that a 1-layer NN has bad performance on the MNIST dataset compared to other methods. However, since I will be training in my own CPU it would be unfeasible to implement a model of higher complexity, such a deep convolutional neural network. However, if get ahead of schedule and learn how to run Java models in a cluster, I can try to implement those for my own educational purpose.

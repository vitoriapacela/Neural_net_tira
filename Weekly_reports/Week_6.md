# Week 6
## Achievements and learnings
- Fixed bugs and now the neural network finally works.
- I learned a lot about multi-label classification as I digged deep into the bugs. Main points: 
 -- There are 10 separate classificators, which are represented by each neuron output of the output layer.
 -- As a result, the weights are a matrix of features x classifier.
 -- The labels are used in nn.train() through sgd.
 -- It is really, really dreadful to implement all these matrix operations with for-loops in Java.
- Implemented method that returns test error rate for evaluation.
- I also spent a lot of time reading LeCun's paper, so that I am able to do fair comparisons regarding how I built the neural network and about its performance.
- My linear classifier has a lower error rate than the one in LeCun's paper. And I am very proud of it!

## Challenges

## Time track
- On the weekend, debugging the code until it worked: 8h.
- Tuesday (debugging until it's bug-free): 6.5h

## Goals for Week 7

Programming Assignment: Image Classification: Part 2


/**********************************************************************
 * Approximate number of hours to complete this assignment            *
 **********************************************************************/

Number of hours:
20 hours

/**********************************************************************
 * Analysis: 
 * 1. What digit is misclassified the most frequently? 
 * 2. For this digit, what are the top two digits that your 
 *    MultiPerceptron incorrectly predicts?
 * 3. Examine some of these misclassified images. Provide an
      explanation for what might have caused these misclassifications.
 **********************************************************************/

1. Most frequently misclassified digit:

My test results are shown below. The most frequently misclassified digit using my own written MultiPerceptron ADT is 1. 
test error rate = 805.0 / 1000.0 = 0.805
There are 96 misclassified 0
There are 119 misclassified 1
There are 99 misclassified 2
There are 105 misclassified 3
There are 88 misclassified 4
There are 86 misclassified 5
There are 102 misclassified 6
There are 101 misclassified 7
There are 1 misclassified 8
There are 8 misclassified 9


2. Top two digits misclassified are:

The top two are number 1 and number 6. 

3. Explanation:

Number 1 is frequently misclassified as 8 or 9. I investigated a few testing images, including 
jar:file:digits.jar!/testing/1/1885.png label: 1 predicted: 8
jar:file:digits.jar!/testing/1/9388.png label: 1 predicted: 8
jar:file:digits.jar!/testing/1/8427.png label: 1 predicted: 8
jar:file:digits.jar!/testing/1/8459.png label: 1 predicted: 8
jar:file:digits.jar!/testing/1/1988.png label: 1 predicted: 9
jar:file:digits.jar!/testing/1/4651.png label: 1 predicted: 9
jar:file:digits.jar!/testing/1/3641.png label: 1 predicted: 9
jar:file:digits.jar!/testing/1/2965.png label: 1 predicted: 9

These numbers look like number 1 and the high misclassification rate should be mainly due to something wrong in my MultiPerceptron ADT which caused 
the perceptrons not properly trained. 1988.png has an extra stroke on the top of the digit 1 sticking out to the left which makes 1 look like 9. 
This could cause confusion in training perceptrons and result in misclassfication errors. One way to avoid this is to add more training samples like
this special 1 and train the perceptrons again.  



/**********************************************************************
 *  Did you receive help from classmates, past students, or
 *  anyone else? If so, please list their names.  ("A Sunday lab TA"
 *  or "Office hours on Thursday" is ok if you don't know their name.)
 **********************************************************************/

Yes or no?
Yes. Thursday Professor office hour, TA Office hour,  Piazza. 

/**********************************************************************
 *  Did you encounter any serious problems? If so, please describe.
 **********************************************************************/

Yes or no?
No

/**********************************************************************
 *  List any other comments here.                                     
 **********************************************************************/
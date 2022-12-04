public class MultiPerceptron {
    private int mclasses; // number of classes
    private int ninputs; // number of inputs
    private Perceptron[] perceptrons; // array of perceptron objects

    // Creates a multi-perceptron object with m classes and n inputs.
    public MultiPerceptron(int m, int n) {
        this.mclasses = m; // set up m
        this.ninputs = n; // set up n
        this.perceptrons = new Perceptron[m]; // set up perceptrons
        for (int i = 0; i < m; i++) {
            perceptrons[i] = new Perceptron(n);
        }
    }

    // Returns the number of classes m.
    public int numberOfClasses() {
        return mclasses;
    }

    // Returns the number of inputs n (length of the feature vector).
    public int numberOfInputs() {
        return ninputs;
    }

    // Returns the predicted label (between 0 and m-1) for the given input.
    // keep track of 2 values: what is the best accuracy you scored yet, the higher the sum,
    // the more likely the correct answer. & which perceptron has the highest accuracy
    // and set the initial value to -1.
    // Double.NEGATIVE_INFINITY: lowest possible java can store. In that way you cannot find
    // any number lower than that.
    public int predictMulti(double[] x) {
        double[] sum = new double[mclasses];
        for (int i = 0; i < mclasses; i++) {
            sum[i] = 0.0;
            sum[i] = perceptrons[i].weightedSum(x);
        }

        // find the max of sums and the index of the max.
        // Arrays.sort(sum); // should not sort the array and use binary search because
        // that disrupted the original order.
        double summax = Double.NEGATIVE_INFINITY;
        for (int i = 0; i + 1 < mclasses; i++) {
            summax = Math.max(sum[i], sum[i + 1]);
        }
        int index = -1;
        double sumcheckzero = 0.0;
        for (int i = 0; i < mclasses; i++) {
            sumcheckzero += sum[i];
        }
        if (sumcheckzero == 0) {
            index = 0;
        }
        else {
            for (int i = 0; i < mclasses; i++) {
                if (summax == sum[i]) {
                    index = i;
                }
            }
        }
        return index;
        // return (int) summax;
        // return (int) sum[0];
        // return (int) sum[1];
    }

    // Trains this multi-perceptron on the labeled (between 0 and m-1) input.
    public void trainMulti(double[] x, int label) {
        for (int i = 0; i < mclasses; i++) {
            if (label == i) {
                perceptrons[i].train(x, +1);
            }
            else {
                perceptrons[i].train(x, -1);
            }
        }
    }

    // Returns a string representation of this MultiPerceptron.
    public String toString() {
        String s = new String("");
        for (int i = 0; i < mclasses - 1; i++) {
            s += perceptrons[i].toString() + ", ";
        }
        s = s + perceptrons[mclasses - 1];
        return "(" + s + ")";
    }
    
    public static void main(String[] args) {
        // int m = 2;
        int m = 2;
        int n = 3;

        double[] training1 = { 5.0, -4.0, 3.0 };  // 1
        double[] training2 = { 2.0, 3.0, -2.0 };  // 0
        double[] training3 = { 4.0, 3.0, 2.0 };   // 1
        double[] training4 = { -6.0, -5.0, 7.0 }; // 0

        MultiPerceptron multip = new MultiPerceptron(m, n);
        // StdOut.println("weighted sum: " + multip.predictMulti(training1));
        // multip.trainMulti(training1, 1);
        // StdOut.println("weighted sum: " + multip.predictMulti(training2));
        // multip.trainMulti(training2, 0);
        // StdOut.println("weighted sum: " + multip.predictMulti(training3));
        // multip.trainMulti(training3, 1);
        // StdOut.println("weighted sum: " + multip.predictMulti(training4));
        // multip.trainMulti(training4, 0);
        multip.trainMulti(training1, 4);
        StdOut.println(multip);
        multip.trainMulti(training1, 1);
        StdOut.println(multip);
        multip.trainMulti(training2, 0);
        StdOut.println(multip);
        multip.trainMulti(training3, 1);
        StdOut.println(multip);
        multip.trainMulti(training4, 0);
        StdOut.println(multip);
    }
}


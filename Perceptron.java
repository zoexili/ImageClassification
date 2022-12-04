public class Perceptron {
    // declare two instance variables.
    private int n;
    private double[] weights; // weighted vector

    // Creates a perceptron with n inputs.
    // create an array of n weights and initialize them to 0.
    public Perceptron(int n) {
        this.n = n; // set n up.
        this.weights = new double[n];
        for (int i = 0; i < n; i++) {
            weights[i] = 0.0;
        }
    }

    // Returns the number of inputs n.
    public int numberOfInputs() {
        return n;
    }

    // Returns the weighted sum of the weight vector and x.
    public double weightedSum(double[] x) {
        double sum = 0.0;
        for (int j = 0; j < n; j++) {
            sum += weights[j] * x[j];
            // StdOut.println(weights[j] + "*" + x[j]);
        }
        return sum;
    }

    // Predict the label (+1 or -1) of input x.
    public int predict(double[] x) {
        int predictlabel = 0;
        if (weightedSum(x) > 0) {
            predictlabel = +1;
        }
        else { // if weightedSum(x) <= 0
            predictlabel = -1;
        }
        return predictlabel;
    }

    // Trains this perceptron on the labeled (+1 or -1) input x.
    public void train(double[] x, int label) {
        // if (label == predict(x)), weights unchanged.
        if (label == -1 && predict(x) == +1) {
            for (int i = 0; i < weights.length; i++) {
                weights[i] = weights[i] - x[i];
            }
        }
        else if (label == +1 && predict(x) == -1) {
            for (int j = 0; j < weights.length; j++) {
                weights[j] = weights[j] + x[j];
            }
        }
    }

    // Returns a string representation of this perceptron.
    public String toString() {
        String s = new String("");
        for (int i = 0; i < weights.length - 1; i++) {
            s += weights[i] + ", ";
        }
        s = s + weights[weights.length - 1];
        return "(" + s + ")";
    }

    // Tests this class by directly calling all instance methods.
    public static void main(String[] args) {
        double[] training1 = { 5.0, -4.0, 3.0 }; // yes
        double[] training2 = { 2.0, 3.0, -2.0 }; // no
        double[] training3 = { 4.0, 3.0, 2.0 }; // yes
        double[] training4 = { -6.0, -5.0, 7.0 }; // no

        int n = 3;
        Perceptron p = new Perceptron(n);
        StdOut.println("sum: " + p.weightedSum(training1));
        p.train(training1, +1);
        StdOut.println("sum: " + p.weightedSum(training2));
        p.train(training2, -1);
        StdOut.println("sum: " + p.weightedSum(training3));
        p.train(training3, +1);
        StdOut.println("sum: " + p.weightedSum(training4));
        p.train(training4, -1);
        // StdOut.println(p);
        // p.train(training1, +1);
        // StdOut.println(p);
        // p.train(training2, -1);
        // StdOut.println(p);
        // p.train(training3, +1);
        // StdOut.println(p);
        // p.train(training4, -1);
        // StdOut.println(p);
    }
}

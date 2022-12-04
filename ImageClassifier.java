import java.awt.Color;

public class ImageClassifier {
    // create a feature vector (1D array) from the given greyscale picture
    public static double[] extractFeatures(Picture picture) {
        // Picture pic = new Picture("49785.png");
        double[][] graymatrix = new double[picture.width()][picture.height()];
        for (int col = 0; col < picture.width(); col++) {
            for (int row = 0; row < picture.height(); row++) {
                Color color = picture.get(col, row);
                // convert gray scale image to matrix
                graymatrix[col][row] = color.getRed(); // getGreen() or getBlue() also works.
            }
        }
        // convert gray scale matrix to 1D array.
        double[] list = new double[picture.width() * picture.height()];
        int index = 0;
        for (int col = 0; col < graymatrix.length; col++) {
            for (int row = 0; row < graymatrix[col].length; row++) { // row < 1 always.
                list[index] = graymatrix[row][col];
                index += 1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        In train = new In(args[0]); // read training file
        In test = new In(args[1]); // read test file
        int[] pretraining = new int[3];
        // the while loop after the for loop will continue from the for loop.
        for (int i = 0; i < 3; i++) {
            if (!train.isEmpty()) {
                pretraining[i] = train.readInt();
                // StdOut.println(pretraining[i]);
            }
        }
        int m = pretraining[0];
        int n = pretraining[1] * pretraining[2];
        // create object.
        MultiPerceptron trainmodel = new MultiPerceptron(m, n);
        while (!train.isEmpty()) {
            String imgname = train.readString();
            // StdOut.println(imgname);
            int imgnum = train.readInt();
            // StdOut.println(imgnum);
            Picture picture = new Picture(imgname);
            // convert picture into a 1D array
            double[] picvec = extractFeatures(picture);
            trainmodel.trainMulti(picvec, imgnum);
            // for (int j = 0; j < picvec.length; j++) {
            // StdOut.print(picvec[j]);
        }

        // predict
        double count = 0;
        double total = 0;
        int countwronglabel0 = 0;
        int countwronglabel1 = 0;
        int countwronglabel2 = 0;
        int countwronglabel3 = 0;
        int countwronglabel4 = 0;
        int countwronglabel5 = 0;
        int countwronglabel6 = 0;
        int countwronglabel7 = 0;
        int countwronglabel8 = 0;
        int countwronglabel9 = 0;
        // throw away the first two lines.
        test.readLine();
        test.readLine();
        while (!test.isEmpty()) {
            String testimgname = test.readString();
            // StdOut.println(testimgname);
            int testimgnum = test.readInt();
            // StdOut.println(testimgnum);
            Picture picture = new Picture(testimgname);
            double[] picvec = extractFeatures(picture);
            int prediction = trainmodel.predictMulti(picvec);
            total += 1;
            if (prediction != testimgnum) {
                if (testimgnum == 0) {
                    countwronglabel0 += 1;
                }
                else if (testimgnum == 1) {
                    countwronglabel1 += 1;
                }
                else if (testimgnum == 2) {
                    countwronglabel2 += 1;
                }
                else if (testimgnum == 3) {
                    countwronglabel3 += 1;
                }
                else if (testimgnum == 4) {
                    countwronglabel4 += 1;
                }
                else if (testimgnum == 5) {
                    countwronglabel5 += 1;
                }
                else if (testimgnum == 6) {
                    countwronglabel6 += 1;
                }
                else if (testimgnum == 7) {
                    countwronglabel7 += 1;
                }
                else if (testimgnum == 8) {
                    countwronglabel8 += 1;
                }
                else if (testimgnum == 9) {
                    countwronglabel9 += 1;
                }
                StdOut.println(testimgname + " label: " + testimgnum + " predicted: " + prediction);
                count += 1;
            }
        }
        double rate = count / total;
        StdOut.println("test error rate = " + count + " / " + total + " = " + rate);
        StdOut.println("There are " + countwronglabel0 + " misclassified 0");
        StdOut.println("There are " + countwronglabel1 + " misclassified 1");
        StdOut.println("There are " + countwronglabel2 + " misclassified 2");
        StdOut.println("There are " + countwronglabel3 + " misclassified 3");
        StdOut.println("There are " + countwronglabel4 + " misclassified 4");
        StdOut.println("There are " + countwronglabel5 + " misclassified 5");
        StdOut.println("There are " + countwronglabel6 + " misclassified 6");
        StdOut.println("There are " + countwronglabel7 + " misclassified 7");
        StdOut.println("There are " + countwronglabel8 + " misclassified 8");
        StdOut.println("There are " + countwronglabel9 + " misclassified 9");
        // StdOut.println("test error rate = " + rate); // round to 1 decimal place.
    }
}



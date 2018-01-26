package tests;

import com.company.utils.MathUtils;

import static com.company.utils.IoUtils.showMatrix;


public class MathTests {

    public static void main(String[] args) {
        // test for sum - done
        testSumMatrix();

        // test for revert - done
        testRevertVector();

        //test for multiple - done
        testMultipleMatrix();

        //test for initialize vector - done
        testInitializeVector();

        //test for initialize matrix - done
        testInitializeMatrix();

        //test for revert matrix to vector
        testMatrixToVector();

        //test for hemming distance
        testHemmingDistanceCalculating();
    }

    /**
     * check
     */
    private static void testSumMatrix() {
        System.out.println("------------  Test sum  --------------");

        int a[][] = {
                {-1, -1, 1, -1},
                {1, 1, -1, 1},
                {-1, -1, 1, -1},
                {1, 1, -1, 1},
                {-1, -1, 1, -1},
                {-1, -1, 1, -1}
        };

        int b[][] = {
                {-1, 1, -1, 1},
                {-1, 1, -1, 1},
                {1, -1, 1, -1},
                {1, -1, 1, -1},
                {-1, 1, -1, 1},
                {1, -1, 1, -1}
        };

        int expectedResult[][] = {
                {-2, 0, 0, 0},
                {0, 2, -2, 2},
                {0, -2, 2, -2},
                {2, 0, 0, 0},
                {-2, 0, 0, 0},
                {0, -2, 2, -2}
        };

        int result[][] = MathUtils.sumMatrix(a, b);

        System.out.println("========== result matrix ==============");

        showMatrix(result);

        System.out.println("========== expected matrix ============");

        showMatrix(expectedResult);

        System.out.println("------------  -----------  --------------");
    }


    /**
     * check
     */
    private static void testRevertVector() {

        int[] vector = {1, -1, 1, -1, 1, 1};

        int[][] revertVector = MathUtils.revertVector(vector);

        showMatrix(revertVector);
    }

    /**
     * check
     */
    private static void testMultipleMatrix() {

        int[][] expectedResult = {
                {-1, -1, 1, -1},
                {1, 1, -1, 1},
                {-1, -1, 1, -1},
                {1, 1, -1, 1},
                {-1, -1, 1, -1},
                {-1, -1, 1, -1}
        };

        int[][] a = MathUtils.revertVector(new int[]{1, -1, 1, -1, 1, 1});
        int[][] b = {{-1, -1, 1, -1}};

        int[][] result = MathUtils.multipleMatrix(a, b);

        System.out.println("========== result matrix ==============");

        showMatrix(result);

        System.out.println("========== expected matrix ============");

        showMatrix(expectedResult);
    }


    /**
     * test initalizing of vectors
     */
    private static void testInitializeVector() {
        int[] vector = {1, 0, 1, 0, 1, 1};

        System.out.println("============= before =================");
        showMatrix(new int[][]{vector});

        int[] result = MathUtils.initalizeVector(vector);

        System.out.println("============= after =================");
        showMatrix(new int[][]{result});
    }

    /**
     * test initializing of matrix
     */
    private static void testInitializeMatrix() {
        int[] vector = {1, -1, 1, -1, 1, 1};

        int[][] revertVector = MathUtils.revertVector(vector);


        System.out.println("============= before =================");
        showMatrix(revertVector);


        int[][] result = MathUtils.initializeMatrix(revertVector);

        System.out.println("============= after =================");
        showMatrix(result);
    }

    private static void testMatrixToVector() {
        int[] vector = {1, -1, 1, -1, 1, 1};
        int[][] revertVector = MathUtils.revertVector(vector);

        System.out.println("============= before =================");
        showMatrix(revertVector);


        int[] result = MathUtils.matrixToVector(revertVector);

        System.out.println("============= after =================");
        showMatrix(new int[][]{result});
    }

    private static void testHemmingDistanceCalculating() {
        int[] a = {2, 2, 2, 2};

        int[] b = {1, 1, 1, 1};

        int resultA = MathUtils.findHemmingDistance(a, b);

        int resultB = MathUtils.findHemmingDistance(b, a);

        System.out.println("Hemming distance with a and b is " + resultA);

        System.out.println("Hemming distance with b and a is " + resultB);
    }
}

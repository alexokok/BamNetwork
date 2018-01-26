package com.company.network;


import com.company.exceptions.VectorNotRecognizedException;
import com.company.model.Input;
import com.company.utils.IoUtils;
import com.company.utils.MathUtils;

import java.util.List;

/** Нейронная сеть BAM */
public class BamNetwork {

    /** образы системы */
    private List<Input> inputs;

    /** весовые коэфициентв системы */
    private int[][] w;

    public BamNetwork(List<Input> inputs) {
        this.inputs = inputs;

    }


    private int findRecognizedVector(int[] vector) {
        int index = -1;

        int hemmingDistance = -1;

        for (Input input : inputs) {
            int temp = MathUtils.findHemmingDistance(input.getShape(), vector);

            if (hemmingDistance == -1 || temp < hemmingDistance) {
                hemmingDistance = temp;
                index = inputs.indexOf(input);
            }
        }

        return index;
    }

    /** алгоритм обучения сети */
    private void trainNetwork() {
        w = new int[inputs.get(0).getShape().length][inputs.get(0).getDescription().length]; //инициализируем матрицу
        //весовых коэфициентов

        for (Input input: inputs) {
            w = MathUtils.sumMatrix(w, input.getMatrix()); //формируем матрицу весовых коэфициентов, как сумму
            //произведения входного образа на его описание
        }

        System.out.println("-------------- Result matrix -------------------");
        IoUtils.showMatrix(w);
        System.out.println("------------------------------------------------");
    }

    /**
     * алгоритм распознвания по образу
     */
    public Input recognizeByShape(int[] shapeVector) throws VectorNotRecognizedException {
        int[][] recVectorMatrix = {shapeVector};

        int[][] matrix = MathUtils.multipleMatrix(w, recVectorMatrix); //перемножаем матрицу весовых коэфициентов на
        //входной образ

        matrix = MathUtils.initializeMatrix(matrix); //активируем получившееся состояние

        int[] resultVector = MathUtils.matrixToVector(matrix);

        System.out.println("-------------- We have a winner -------------------");
        IoUtils.showVector(shapeVector);
        System.out.println("---------------------------------------------------");

        int index = findRecognizedVector(resultVector); //находим получившийся вектор в "базе" известных векторов

        System.out.println("It's seems what it's input like " + index);

        if (index == -1) {
            throw new VectorNotRecognizedException();
        }

        return inputs.get(index);
    }


    public static BamNetwork getInstance(List<Input> inputs) {
        BamNetwork bamNetwork = new BamNetwork(inputs);

        bamNetwork.trainNetwork();

        return bamNetwork;
    }
}

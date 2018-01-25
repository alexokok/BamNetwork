package com.company.network;


import com.company.model.Input;
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

        trainNetwork();
    }

    /** алгоритм обучения сети */
    private void trainNetwork() {
        w = new int[inputs.get(0).getShape().length][inputs.get(0).getDescription().length];

        for (Input input: inputs) {
            w = MathUtils.sumMatrix(w, input.getMatrix());
        }
    }

    /** алгоритм распознвания */
    public Input recognize(int[] recVector) {
        int[][] recVectorMatrix = { recVector };

        int[][] matrix = MathUtils.multipleMatrix(w, recVectorMatrix);

        matrix = MathUtils.initializeMatrix(matrix);

        return new Input(new int[] { 1 }, new int[] { 1 });
    }
}

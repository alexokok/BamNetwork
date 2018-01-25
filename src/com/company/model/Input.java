package com.company.model;

import com.company.utils.MathUtils;

/** Входная информация нейронной сети */
public class Input {

    /** образ*/
    private int[] shape;

    /** сопряженный образ*/
    private int[] description;


    public int[] getShape() { return  shape; }

    public int[] getDescription() { return description; }


    public Input(int[] shape, int[] description) {
        this.shape = shape;
        this.description = description;
    }


    /** получает матрицу путем перемножения образа на описание */
    public int[][] getMatrix() {
        int[] shapeReady = MathUtils.initalizeVector(shape);
        int[] descriptionReady = MathUtils.initalizeVector(description);


        int[][] newShape = MathUtils.revertVector(shapeReady);

        int[][] newDescription = { descriptionReady };


        return MathUtils.multipleMatrix(newShape, newDescription);
    }



}

package com.company;

import com.company.exceptions.VectorNotRecognizedException;
import com.company.model.Input;
import com.company.network.BamNetwork;
import com.company.utils.IoUtils;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        BamNetwork network = BamNetwork.getInstance(generateSample());

        try {
            Input result = network.recognizeByShape(new int[]{1, 0, 1, 0, 1, 1});

            System.out.println("--------------- Result ----------------");

            IoUtils.showVector(result.getDescription());

        } catch (VectorNotRecognizedException ex) {
            ex.printStackTrace();
        }
    }

    private static List<Input> generateSample() {
        List<Input> sampleList = new ArrayList<>();
        sampleList.add(new Input(new int[]{1, 0, 1, 0, 1, 1}, new int[]{0, 0, 1, 0}));
        sampleList.add(new Input(new int[]{1, 1, 0, 0, 1, 0}, new int[]{0, 1, 0, 1}));

        return sampleList;
    }


}

package otherproblems;

import org.junit.Test;

public class ZerosAndOnesTest {

    @Test
    public void test() {

        ZerosAndOnes zerosAndOnes = new ZerosAndOnes();
        int[] input1 = new int[] { 1, 0, 1, 0 };
        zerosAndOnes.solution(input1);
        Utils.printIntArray(input1);

        int[] input2 = new int[] { 0, 0, 0, 1 };
        zerosAndOnes.solution(input2);
        Utils.printIntArray(input2);

        int[] input3 = new int[] { 1, 0, 0 };
        zerosAndOnes.solution(input3);
        Utils.printIntArray(input3);

        int[] input4 = new int[] { 0, 1 };
        zerosAndOnes.solution(input4);
        Utils.printIntArray(input4);

        int[] input5 = new int[] { 1, 1 };
        zerosAndOnes.solution(input5);
        Utils.printIntArray(input5);

        int[] input6 = new int[] { 0, 1, 0, 0, 1, 0 };
        zerosAndOnes.solution(input6);
        Utils.printIntArray(input6);

        int[] input7 = new int[] { 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1 };
        zerosAndOnes.solution(input7);
        Utils.printIntArray(input7);

        int[] input8 = new int[] { 1, 1, 1 };
        zerosAndOnes.solution(input8);
        Utils.printIntArray(input8);

        int[] input9 = new int[] { 0, 0 };
        zerosAndOnes.solution(input9);
        Utils.printIntArray(input9);

        int[] input10 = new int[] { 0 };
        zerosAndOnes.solution(input10);
        Utils.printIntArray(input10);
    }

}

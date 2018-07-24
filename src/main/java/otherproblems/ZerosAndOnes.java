package otherproblems;

public class ZerosAndOnes {

    /**
     * Put all the ones to the left and all the zeros to the right
     *
     * @param input
     */
    public void solution(int[] input) {

        int zPtr = -1;

        for (int i = 0; i < input.length; i++) {

            int element = input[i];

            if (element == 0 && zPtr < 0) {
                zPtr = i;
            }

            if (element == 1 && zPtr >= 0) {
                input[i] = 0;
                input[zPtr] = 1;
                zPtr++;
            }
        }

    }
}

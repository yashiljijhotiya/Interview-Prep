package interview_question;

public class YashilAcko {

    public static void main(String args[]) {
        System.out.println("Hello Acko");
        System.out.println(
                solve(
                        5,
                        new int[]{0, 1, 0, 1},
                        new int[]{1, 1, 0, 3},
                        new int[]{3, 2, 4, 4},
                        4
                )
        );
    }

    private static int solve(int numberOfBits, int type[], int left[], int right[], int queryLength) {
        int setBitCount = 0;
        boolean bitMask[] = new boolean[numberOfBits];

        for (int i=0; i<queryLength; i++) {
            switch (type[i]) {
                case 0:
                    updateBitMask(bitMask, left[i], right[i]);
                    break;
                default:
                    setBitCount += getSetBitCount(bitMask, left[i], right[i]);
            }
            System.out.println("index: " + i);
        }
        return setBitCount;
    }

    private static void updateBitMask(boolean bitMask[], int leftIndex, int rightIndex) {
        boolean operationBit = true;
        for (int i=leftIndex; i<=rightIndex; i++) {
            bitMask[i] ^= operationBit;
        }
    }

    private static int getSetBitCount(boolean bitMask[], int leftIndex, int rightIndex) {
        int setBitCount = 0;
        for (int i=leftIndex; i<=rightIndex; i++) {
            if (bitMask[i]) {
                setBitCount++;
            }
        }
        return setBitCount;
    }
}

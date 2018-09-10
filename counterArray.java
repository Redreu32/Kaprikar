package kap;

/**
 * @author Reuben Dack
 * @since 27/08/2018 14:06
 */

public class counterArray {

            public int[] counter(int base, String element) {
                int[] count = new int[base];
                String[] strElementArray = element.split("");
                Integer[] elementArray = new Integer[strElementArray.length];

                for (int i = 0; i < strElementArray.length; i++) {
                    elementArray[i] = Integer.valueOf(strElementArray[i]);
                }


                for (int i = 0; i < base; i++) {
                    for (int j = 0; j < elementArray.length; j++) {
                        if (elementArray[i] == i) {
                            count[i]++;
                        }
                    }
                }
                return count;
    }
}


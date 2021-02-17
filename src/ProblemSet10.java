import java.util.*;

public class ProblemSet10 {

    public static void main(String[] args) {

        ProblemSet10 stuff = new ProblemSet10();

        int[] input1 = new int[]{1, 1, 1, 1, 1};
        int[] input2 = new int[]{5, 4};

        //System.out.println(Arrays.toString(stuff.seriesUp(2)));
        System.out.println(stuff.countClumps(input1));

    }

    public String[] fizzBuzz(int start, int end) {

        if (start >= end) {
            return null;
        }

        String[] answer = new String[end - start];
        int value = 0;

        for (int i = start; i < end; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                answer[value] = "FizzBuzz";
                value++;
            } else if (i % 3 == 0) {
                answer[value] = "Fizz";
                value++;
            } else if (i % 5 == 0) {
                answer[value] = "Buzz";
                value++;
            } else {
                answer[value] = Integer.toString(i);
                value++;
            }
        }

        return answer;

    }

    public int maxSpan(int[] numbers) {

        if (numbers == null) {
            return -1;
        }
        if (numbers.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> firstAppearance = new HashMap<Integer, Integer>();
        int span = 1;
        int maxSpan = 1;

        for (int i = 0; i < numbers.length; i++) {
            Integer s = firstAppearance.get(numbers[i]);
            if (s == null) {
                firstAppearance.put(numbers[i], i);
            } else {
                span = i - s + 1;
                if (span > maxSpan) {
                    maxSpan = span;
                }
            }
        }

        return maxSpan;

    }

    public int[] fix34(int[] numbers) {

        if (numbers == null) {
            return null;
        }

        int threeValues = 0;
        int fourValues = 0;
        int firstThreeIndex = -1;
        int firstFourIndex = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 3) {
                if (firstThreeIndex == -1) {
                    firstThreeIndex = i;
                } if (i != numbers.length-1 && numbers[i+1] == 3) {
                    return null;
                }
                threeValues++;
            } else if (numbers[i] == 4) {
                if (firstFourIndex == -1) {
                    firstFourIndex = i;
                }
                fourValues++;
            }
        }

        if (threeValues != fourValues) {
            return null;
        }

        for (int k = firstThreeIndex; k < numbers.length; k++) {

            if (numbers[k] == 4) {
                for (int j = 0; j < numbers.length; j++) {
                    if ((numbers[j] == 3)) {
                        int t = numbers[j+1];
                        numbers[j+1] = numbers[k];
                        numbers[k] = t;
                    }
                }
            }

        }

        return numbers;


    }

//    public int[] fix45(int[] numbers) {
//
//        if (numbers == null) {
//            return null;
//        }
//
//        int fourValues = 0;
//        int fiveValues = 0;
//        boolean foursAreAlone = true;
//
//        for (int i = 0; i < numbers.length; i++) {
//            if (numbers[i] == 3) {
//                if (firstThreeIndex == -1) {
//                    firstThreeIndex = i;
//                } if (i != numbers.length-1 && numbers[i+1] == 3) {
//                    return null;
//                }
//                threeValues++;
//            } else if (numbers[i] == 4) {
//                if (firstFourIndex == -1) {
//                    firstFourIndex = i;
//                }
//                fourValues++;
//            }
//        }
//
//        if (fourValues == 0 && fiveValues == 0) {
//            return null;
//        }
//        for (int i = 0; i < numbers.length; i++) {
//            if ((numbers[i] == 4 && i == numbers.length - 1) || (numbers[i] == 4 && numbers[i+1] == 4)) {
//                foursAreAlone = false;
//            }
//        }
//        if (fourValues != fiveValues || !foursAreAlone) {
//            return null;
//        }
//        for (int i = 0; i < numbers.length; i++) {
//            if (numbers[i] == 5) {
//                for (int j = 0; j < numbers.length; j++) {
//                    if (numbers[j] == 4 && numbers[j + 1] != 5) {
//                        int temp = numbers[j+1];
//                        numbers[j+1] = numbers[i];
//                        numbers[i] = temp;
//                    }
//                }
//            }
//        }
//        return numbers;
//    }

    public boolean canBalance(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return false;
        }

        int leftBalance = 0;
        int rightBalance = 0;



        for (int i = 0; i < numbers.length; i++) {


            for (int j = i; j >= 0; j--) {
                leftBalance += numbers[j];
            }
            for (int k = i+1; k < numbers.length; k++) {
                rightBalance += numbers[k];
            }
            if (rightBalance == leftBalance) {
                return true;
            }

            leftBalance = 0;
            rightBalance = 0;
        }

        return false;

    }

    public boolean linearIn(int[] outer, int[] inner) {

        if (outer == null || inner == null || outer.length == 0 || inner.length == 0) {
            return false;
        }

        for (int i = 0; i< outer.length-1; i++) {
            if (outer[i] > outer[i+1]) {
                return false;
            }
        }

        for (int k = 1; k < inner.length; k++) {
            if (inner[k] > inner[k+1]) {
                return false;
            }
        }

        int innerIndex = 0;
        int numberOfMatches = 0;

        for (int i = 0; i < outer.length && innerIndex < inner.length; i++) {
            if (outer[i] > inner[innerIndex]) {
                break;
            }

            if ((outer[i] == inner[innerIndex]) && (innerIndex != inner.length - 1) && (inner[innerIndex + 1] != inner[innerIndex])) {
                numberOfMatches++;
                innerIndex++;
            } else if ((outer[i] == inner[innerIndex]) && (innerIndex != inner.length - 1) && (inner[innerIndex + 1] == inner[innerIndex])) {
                numberOfMatches++;
                i--;
                innerIndex++;
            } else if (outer[i] == inner[innerIndex] && innerIndex == inner.length - 1) {
                numberOfMatches++;
                break;
            }
        }

        if (numberOfMatches >= inner.length) {
            return true;
        } else {
            return false;
        }
    }

    public int[] squareUp(int n) {

        if (n < 0) {
            return null;
        }

        int[] answer = new int[n*n];

        for (int i = 1; i <= n; i++ ) {
            for (int k = 1; k <= n; k++) {

                if (k > n-i) {
                    answer[(i-1)*n+k-1] = n-k+1;
                }

            }
        }



        return answer;



    }

    public int[] seriesUp(int n) {

        if (n < 0) {
            return null;
        }

        int answerLength = 0;

        for (int k = 1; k <= n; k++) {
            answerLength += k;
        }

        int[] answer = new int[answerLength];
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            for (int h = 0; h < i; h++) {
                answer[idx] = h + 1;
                idx++;
            }
        }

        return answer;

    }

    public int maxMirror(int[] numbers) {

        if (numbers == null) {
            return -1;
        }

        int lowIdx = 0;
        int highIdx = 0;
        int currentMirror = 0;
        int maxMirror = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int k = numbers.length - 1; k >= 0; k--) {
                if (numbers[i] == numbers[k]) {
                    currentMirror = 1;
                    lowIdx = i + 1;
                    highIdx = k - 1;

                    while
                    ((lowIdx <= numbers.length - 1 && highIdx >= 0) &&
                            (numbers[lowIdx] == numbers[highIdx])) {
                        highIdx-=1;

                        lowIdx+=1;

                        currentMirror+=1;
                    }

                    if (currentMirror > maxMirror) {
                        maxMirror = currentMirror;
                    }
                }
            }
        }

        return maxMirror;

    }

    public int countClumps(int[] numbers) {

        if (numbers == null) {
            return -1;
        }
        int clumps = 0;

        boolean inClump = false;

        for (int i = 0; i < numbers.length-1; i++) {

            if ((numbers[i] == numbers[i + 1]) && !inClump) {
                clumps+=1;
                inClump = true;
            }
            else if (inClump && (numbers[i] != numbers[i - 1])) {
                inClump = false;
            }
        }
        return clumps;
    }

    }


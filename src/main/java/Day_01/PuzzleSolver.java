package Day_01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.Math.abs;

public class PuzzleSolver {
    public static int getResultDistance(String input) {
        int result = 0;
        Pair splitList = splitInput(input);

        splitList.getFirst().sort(Comparator.comparingInt(Integer::intValue));
        splitList.getSecond().sort(Comparator.comparingInt(Integer::intValue));

        System.out.println("Liste 1: " + splitList.getFirst());
        System.out.println("Liste 2: " + splitList.getSecond());

        for (Integer currentLeft : splitList.getFirst()) {
            Integer currentRight = splitList.getSecond().get(splitList.getFirst().indexOf(currentLeft));

            System.out.println("Links: " + currentLeft + " Rechts: " + currentRight + " Abstand: " + abs(currentLeft - currentRight));

            result += abs(currentLeft - currentRight);
        }

        return result;
    }


    private static Pair splitInput(String input) {
        List<Integer> listLeft = new ArrayList<>();
        List<Integer> listRight = new ArrayList<>();

        String[] lines = input.strip().split("\n");

        for (String line : lines) {
            String[] parts = line.trim().split("\\s+");
            if (parts.length == 2) {
                listLeft.add(Integer.parseInt(parts[0]));
                listRight.add(Integer.parseInt(parts[1]));
            }
        }

        return new Pair(listLeft, listRight);
    }

    private static class Pair {
        List<Integer> first;
        List<Integer> second;

        private Pair(List<Integer> first, List<Integer> second) {
            this.first = first;
            this.second = second;
        }

        private List<Integer> getFirst() {
            return first;
        }
        private List<Integer> getSecond() {
            return second;
        }
    }
}

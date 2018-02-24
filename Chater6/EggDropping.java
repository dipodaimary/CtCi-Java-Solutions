package Chapter6;

public class EggDropping {
    public static int breakingPoint = 89;
    public static int countDrops = 0;

    public static void main(String[] args) {
        int max = 0;
        for (int i = 1; i <= 100; i++) {
            countDrops = 0;
            breakingPoint = i;
            int bp = findBreakingPoint(100);

            if (bp == breakingPoint) {
                System.out.println("SUCCESS: " + i + " -> " + bp + " -> " + countDrops);
            } else {
                System.out.println("ERROR: " + i + " -> " + bp + " vs " + breakingPoint);
                break;
            }
            max = countDrops > max ? countDrops : max;
        }
        System.out.println(max);
    }

    public static boolean willBreak(int floor) {
        countDrops++;
        return floor >= breakingPoint;
    }

    public static int findBreakingPoint(int floors) {
        int interval = 14;
        int previousFloor = 0;
        int egg1 = interval;
        while (!willBreak(egg1) && egg1 <= floors) {
            interval -= 1;
            previousFloor = egg1;
            egg1 += interval;
        }
        int egg2 = previousFloor + 1;
        while (egg2 < egg1 && egg2 <= floors && !willBreak(egg2)) {
            egg2 += 1;
        }
        return egg2 > floors ? -1 : egg2;
    }
}

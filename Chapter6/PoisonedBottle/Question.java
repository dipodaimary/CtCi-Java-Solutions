package Chapter6.PoisonedBottle;

import java.util.ArrayList;
import java.util.Random;

public class Question {
    public static void main(String[] args) {
        int nBottles = 1000;
        int nTestStrips = 10;
        for (int poisoned = 0; poisoned < nBottles; poisoned++) {
            ArrayList<Bottle> bottles = createBottles(nBottles, poisoned);
            ArrayList<TestStrip> testStrips = createTestStrips(nTestStrips);
            int poisonId = findPoisonBottle(bottles, testStrips);
            System.out.println("Suspected Bottle: " + poisonId);
            if (poisonId != poisoned) {
                System.out.println("ERROR");
                break;
            }
        }
    }

    public static ArrayList<Bottle> createBottles(int nBottles, int poisoned) {
        ArrayList<Bottle> bottles = new ArrayList<>();
        for (int i = 0; i < nBottles; i++) {
            bottles.add(new Bottle(i));
        }
        if (poisoned == -1) {
            Random r = new Random();
            poisoned = r.nextInt(nBottles);
        }
        bottles.get(poisoned).setPoisoned();
        System.out.println("Added poison to the bottle " + poisoned);
        return bottles;
    }

    public static int findPoisonBottle(ArrayList<Bottle> bottles, ArrayList<TestStrip> strips) {
        runTests(bottles, strips);
        ArrayList<Integer> positive = getPositiveOnDay(strips, 7);
        return setBits(positive);
    }

    private static ArrayList<Integer> getPositiveOnDay(ArrayList<TestStrip> testStrips, int day) {
        ArrayList<Integer> positive = new ArrayList<>();
        for (TestStrip testStrip : testStrips) {
            int id = testStrip.getId();
            if (testStrip.isPositiveOnDay(day)) {
                positive.add(id);
            }
        }
        return positive;
    }

    private static void runTests(ArrayList<Bottle> bottles, ArrayList<TestStrip> testStrips) {
        for (Bottle bottle : bottles) {
            int id = bottle.getId();
            int bitIndex = 0;
            while (id > 0) {
                if ((id & 1) == 1) {
                    testStrips.get(bitIndex).addDropsOnDay(0, bottle);
                }
                bitIndex++;
                id >>= 1;
            }
        }
    }

    public static int setBits(ArrayList<Integer> positive) {
        int id = 0;
        for (Integer bitIndex : positive) {
            id |= 1 << bitIndex;
        }
        return id;
    }

    public static ArrayList<TestStrip> createTestStrips(int nTestStrips) {
        ArrayList<TestStrip> testStrips = new ArrayList<>();
        for (int i = 0; i < nTestStrips; i++) {
            testStrips.add(new TestStrip(i));
        }
        return testStrips;
    }
}

package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Q13_StackOfBoxes {
    public static void main(String[] args) {

    }
}

class QuestionA {
    public static int createStack(ArrayList<Box> boxes) {
        Collections.sort(boxes, new BoxComparator());
        int maxHeight = 0;
        for (int i = 0; i < boxes.size(); i++) {
            int height = createStack(boxes, i);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight;
    }

    public static int createStack(ArrayList<Box> boxes, int bottomIndex) {
        Box bottom = boxes.get(bottomIndex);
        int maxHeight = 0;
        for (int i = bottomIndex + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeAbove(bottom)) {
                int height = createStack(boxes, i);
                maxHeight = Math.max(height, maxHeight);
            }
        }
        maxHeight += bottom.height;
        return maxHeight;
    }


    public static void main(String[] args) {
        Box[] boxList = {new Box(6, 4, 4), new Box(8, 6, 2), new Box(5, 3, 3), new Box(7, 8, 3), new Box(4, 2, 2), new Box(9, 7, 3)};
        ArrayList<Box> boxes = new ArrayList<Box>();
        for (Box b : boxList) {
            boxes.add(b);
        }

        int height = createStack(boxes);
        System.out.println(height);
    }

}

class Box {
    public int width;
    public int height;
    public int depth;

    public Box(int w, int h, int d) {
        this.width = w;
        this.height = h;
        this.depth = d;
    }

    public boolean canBeUnder(Box b) {
        if (width > b.width && height > b.height && depth > b.depth) {
            return true;
        }
        return false;
    }

    public boolean canBeAbove(Box b) {
        if (width < b.width && height < b.height && depth < b.depth) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Box(" + width + ", " + height + ", " + depth + ")";
    }
}

class BoxComparator implements Comparator<Box> {
    @Override
    public int compare(Box x, Box y) {
        return y.height - x.height;
    }
}

class QuestionB {
    public static int createStack(ArrayList<Box> boxes) {
        Collections.sort(boxes, new BoxComparator());
        int maxHeight = 0;
        int[] stackMap = new int[boxes.size()];
        for (int i = 0; i < boxes.size(); i++) {
            int height = createStack(boxes, i, stackMap);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight;
    }

    public static int createStack(ArrayList<Box> boxes, int bottomIndex, int[] stackMap) {
        if (bottomIndex < boxes.size() && stackMap[bottomIndex] > 0) {
            return stackMap[bottomIndex];
        }

        Box bottom = boxes.get(bottomIndex);
        int maxHeight = 0;
        for (int i = bottomIndex + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeAbove(bottom)) {
                int height = createStack(boxes, i, stackMap);
                maxHeight = Math.max(height, maxHeight);
            }
        }
        maxHeight += bottom.height;
        stackMap[bottomIndex] = maxHeight;
        return maxHeight;
    }


    public static void main(String[] args) {
        Box[] boxList = {new Box(6, 4, 4), new Box(8, 6, 2), new Box(5, 3, 3), new Box(7, 8, 3), new Box(4, 2, 2), new Box(9, 7, 3)};
        ArrayList<Box> boxes = new ArrayList<Box>();
        for (Box b : boxList) {
            boxes.add(b);
        }

        int height = createStack(boxes);
        System.out.println(height);
    }

}

class QuestionC {
    public static int createStack(ArrayList<Box> boxes) {
        Collections.sort(boxes, new BoxComparator());
        int[] stackMap = new int[boxes.size()];
        return createStack(boxes, null, 0, stackMap);
    }

    public static int createStack(ArrayList<Box> boxes, Box bottom, int offset, int[] stackMap) {
        if (offset >= boxes.size()) {
            return 0;
        }

        /* height with this bottom */
        Box newBottom = boxes.get(offset);
        int heightWithBottom = 0;
        if (bottom == null || newBottom.canBeAbove(bottom)) {
            if (stackMap[offset] == 0) {
                stackMap[offset] = createStack(boxes, newBottom, offset + 1, stackMap);
                stackMap[offset] += newBottom.height;
            }
            heightWithBottom = stackMap[offset];
        }

        /* without this bottom */
        int heightWithoutBottom = createStack(boxes, bottom, offset + 1, stackMap);

        return Math.max(heightWithBottom, heightWithoutBottom);
    }


    public static void main(String[] args) {
        Box[] boxList = {new Box(6, 4, 4), new Box(8, 6, 2), new Box(5, 3, 3), new Box(7, 8, 3), new Box(4, 2, 2), new Box(9, 7, 3)};
        ArrayList<Box> boxes = new ArrayList<Box>();
        for (Box b : boxList) {
            boxes.add(b);
        }

        int height = createStack(boxes);
        System.out.println(height);
    }

}
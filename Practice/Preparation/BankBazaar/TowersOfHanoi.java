package Preparation.BankBazaar;

import java.util.Stack;

public class TowersOfHanoi {
    public static void main(String[] args) {
        // Set up code.
        int n = 5;
        Tower[] towers = new Tower[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            towers[0].addDisk(i);
        }

        // Copy and paste output into a .XML file and open it with internet explorer.
        //towers[0].print();
        towers[0].moveDisks(n, towers[2], towers[1]);
        //towers[2].print();
    }
}

class Tower {
    private Stack<Integer> disks;
    private int index;

    public Tower(int i) {
        disks = new Stack<>();
        index = i;
    }

    public void addDisk(int d) {
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            disks.push(d);
        }
    }

    public void moveTopTo(Tower t) {
        int top = disks.pop();
        t.addDisk(top);
    }

    public void moveDisks(int n, Tower destination, Tower buffer) {
        if (n > 0) {
            moveDisks(n - 1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(n - 1, destination, this);
        }

    }

    public void print() {
        System.out.println("Contents of Tower " + getIndex() + ": " + disks.toString());
    }

    public int getIndex() {
        return index;
    }
}

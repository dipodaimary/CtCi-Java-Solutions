package Recursion;

public class Q10_PaintFill {
    enum Color {Black, White, Red, Yellow, Green}

    public static void main(String[] args) {
        
    }

    public static boolean PaintFill(Color[][] screen, int r, int c, Color ncolor) {
        if (screen[r][c] == ncolor) return false;
        return PaintFill(screen, r, c, screen[r][c], ncolor);
    }

    private static boolean PaintFill(Color[][] screen, int r, int c, Color ocolor, Color ncolor) {
        if (r < 0 || r >= screen.length || c < 0 || c >= screen[0].length) {
            return false;
        }
        if (screen[r][c] == ocolor) {
            screen[r][c] = ncolor;
            PaintFill(screen, r - 1, c, ocolor, ncolor);//up
            PaintFill(screen, r + 1, c, ocolor, ncolor);//down
            PaintFill(screen, r, c - 1, ocolor, ncolor);//left
            PaintFill(screen, r, c + 1, ocolor, ncolor);//right
        }
        return true;
    }
}

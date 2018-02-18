package JavaBasics;

public class MultiArrayTest {
    public static void main(String[] args) {
        String[][] states = new String[3][2];
        states[0][0] = "California";
        states[0][1] = "Sacremento";
        states[1][0] = "Oregon";
        states[1][1] = "Salem";
        states[2][0] = "Washington";
        states[2][1] = "Olympia";
        for (int i = 0; i < states.length; ++i) {
            StringBuilder sb = new StringBuilder();
            sb.append("The capital of ");
            sb.append(states[i][0]);
            sb.append(" is ");
            sb.append(states[i][1]);
            System.out.println(sb.toString());
        }
    }
}

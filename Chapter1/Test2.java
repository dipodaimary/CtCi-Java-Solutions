package Chapter1;

public class Test2 {
    public static void main(String[] args) {
        //str = "Mr John Smith       ";
        System.out.println(urlify("Mr John Smith       "));
    }

    public static String urlify(String str) {
        int truelength = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                if (str.charAt(i - 1) != ' ') {
                    truelength++;
                } else {
                    break;
                }
            } else {
                truelength++;
            }
        }
        System.out.println(truelength);
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < truelength - 1; j++) {
            if (str.charAt(j) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(j));
            }
        }
        System.out.println(sb.toString());
        String ans = sb.toString();
        return ans;
    }
}

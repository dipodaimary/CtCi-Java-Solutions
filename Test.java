public class Test {
    private static int findLastCharacter(char[] s) {
        for (int i = s.length - 1; i >= 0; i--) {
            if (s[i] != ' ') {
                return i;
            }
        }
        return -1;
    }

    private static void replaceSpaces(char[] arr, int trueLength) {
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < trueLength; ++i) {
            if (arr[i] == ' ') {
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;
        if (trueLength < arr.length) {
            arr[trueLength] = '\0';
        }
        for (i = trueLength - 1; i >= 0; i--) {
            if (arr[i] == ' ') {
                arr[index - 1] = '0';
                arr[index - 2] = '2';
                arr[index - 3] = '%';
                index = index - 3;
            } else {
                arr[index - 1] = arr[i];
                index--;
            }
        }
    }

    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        char[] arr = str.toCharArray();
        int trueLength = findLastCharacter(arr) + 1;
        System.out.println(trueLength);
        replaceSpaces(arr, trueLength);
        System.out.println(arr);
    }
}

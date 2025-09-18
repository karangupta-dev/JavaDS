package DataStructures.Arrays.Medium;

public class EncodeDecodeString {

    private static String encode(String[] strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str.length()).append(':').append(str);
        }
        return encoded.toString();
    }

    private static String[] decode(String s) {
        java.util.List<String> decoded = new java.util.ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != ':') {
                j++;
            }
            int length = Integer.parseInt(s.substring(i, j));
            decoded.add(s.substring(j + 1, j + 1 + length));
            i = j + 1 + length;
        }
        return decoded.toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] strs = {"Hello", "this_is_more_than_ten_leters", ":"};
        String encoded = encode(strs);
        System.out.println("Encoded: " + encoded);
        String[] decoded = decode(encoded);
        System.out.print("Decoded: ");
        for (String str : decoded) {
            System.out.print(str + " ");
        }
    }
}

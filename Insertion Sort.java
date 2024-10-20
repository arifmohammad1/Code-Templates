import java.util.*;

public class insertion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        while (a-- > 0) {
            int b = sc.nextInt();
            int[] c = new int[b];
            for (int i = 0; i < b; i++) {
                c[i] = sc.nextInt();
            }
            for (int i = 1; i < b; i++) {
                int temp = c[i], j = i - 1;
                while (j >= 0 && temp < c[j]) {
                    c[j + 1] = c[j];
                    j--;
                }
                c[j + 1] = temp;
            }
            for (int i = 0; i < b; i++) {
                System.out.print(c[i] + " ");
            }
            System.out.println();
        }
    }
}
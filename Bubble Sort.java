import java.util.*;

public class sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        while (a-- > 0) {
            int b = sc.nextInt();
            int[] c = new int[b];
            for (int i = 0; i < b; i++) {
                c[i] = sc.nextInt();
            }
            for (int i = 0; i < b; i++) {
                for (int j = 0; j < b - i - 1; j++) {
                    if (c[j] > c[j + 1]) {
                        int temp = c[j];
                        c[j] = c[j + 1];
                        c[j + 1] = temp;
                    }
                }
            }
            for (int i = 0; i < b; i++) {
                System.out.print(c[i] + " ");
            }
            System.out.println();
        }
    }
}

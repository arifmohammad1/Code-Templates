import java.util.*;

public class merges {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        while (a-- > 0) {
            int b = sc.nextInt();
            int[] c = new int[b];
            for (int i = 0; i < b; i++) {
                c[i] = sc.nextInt();
            }
            int low = 0, high = b - 1;
            check(c, low, high);
            for (int i = 0; i < b; i++) {
                System.out.print(c[i] + " ");
            }
            System.out.println();

        }
    }

    public static void check(int arr[], int low, int high) {
        if (low >= high)
            return;
        int mid = (low + high) / 2;
        check(arr, low, mid);
        check(arr, mid + 1, high);
        mergesort(arr, low, mid, high);
    }

    public static void mergesort(int arr[], int low, int mid, int high) {
        int left = low, right = mid + 1;
        List<Integer> list = new ArrayList<>();
        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) {
                list.add(arr[left]);
                left++;
            } else {
                list.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            list.add(arr[left]);
            left++;
        }
        while (right <= high) {
            list.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = list.get(i - low);
        }
    }

}
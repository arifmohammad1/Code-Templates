import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
      Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        while(a-- > 0) {
            int b = sc.nextInt();
            long[] arr = new long[b];
            long[] seg = new long[4 * b + 1];
            for(int i = 0; i < b; i++) {
                arr[i] = sc.nextLong();
            }
            build(arr,seg,0,b-1,0);
            int q = sc.nextInt();
            while(q-- > 0) {
                int type = sc.nextInt();
                int m = sc.nextInt();
                int n = sc.nextInt();
                if(type == 1) {
                    long k = check(arr,seg,m-1,n-1,0,b-1,0);
                    System.out.println(k);
                }
                else if(type == 2) {
                    arr[m-1] = n;
                    update(arr,seg,m-1,n,0,b-1,0);
                }
            }
            System.out.println();
        }
    }
    public static void build(long[] arr,long[] seg,int low,int high,int ind) {
        if(low == high) {
            seg[ind] = arr[low];
            return ;
        }
        int mid = (low + high)/2;
        build(arr,seg,low,mid,2*ind+1);
        build(arr,seg,mid+1,high,2*ind+2);
        seg[ind] = Math.max(seg[2*ind+1],seg[2*ind+2]);
    }
    public static long check(long[] arr,long[] seg,int i,int j,int low,int high,int ind) {
        if(j < low || high < i) return Long.MIN_VALUE; // no overlapping
        if(low >= i && j >= high) return seg[ind]; // full overlapping
        // partial overlapping
        int mid = (low + high) / 2;                
        long left = check(arr,seg,i,j,low,mid,2*ind+1);
        long right = check(arr,seg,i,j,mid+1,high,2*ind+2);
        return Math.max(left,right);
    }
    public static void update(long[] arr,long[] seg,int i,int val,int low,int high,int ind) {
        if(low == high) {
            seg[ind] = val;
            return;
        }
        int mid = (low+high)/2;
        if(i <= mid) {
            update(arr,seg,i,val,low,mid,2*ind+1);
        }
        else update(arr,seg,i,val,mid+1,high,2*ind+2);
        seg[ind] = Math.max(seg[2*ind+1],seg[2*ind+2]);
    }
}

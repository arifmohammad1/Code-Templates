/*
modulo division : 
  (a/b)%m = mul(a%m * inverse(b)%m)%m
  inverse(b)%m = pow(b, m-2) % m;
 



*/
import java.util.*;

public class ModuloArithematic {
    public static void main(String[] args) {
        
        int a = 5, b = 3, m = 7;
        System.out.println("Addition: " + mod_add(a, b, m));
        System.out.println("Subtraction: " + mod_sub(a, b, m));
        System.out.println("Multiplication: " + mod_mul(a, b, m));
        System.out.println("Division: " + mod_div(a, b, m));
        System.out.println("LCM: " + lcm(a, b));
    }

    public static int mod_add(int a, int b, int m) {
        return (a % m + b % m) % m;
    }

    public static int mod_sub(int a, int b, int m) {
        return (a % m - b % m + m) % m;
    }

    public static int mod_mul(int a, int b, int m) {
        return (int)(((long)a % m * (long)b % m) % m); 
    }

    public static int mod_div(int a, int b, int m) {
        if (gcd(b, m) != 1) {
            throw new IllegalArgumentException("b and m must be coprime for modular division.");
        }
        return mod_mul(a, mod_inv(b, m), m);
    }

    public static int mod_inv(int b, int m) {
        return mod_exp(b, m - 2, m); 
    }

    public static int mod_exp(int a, int b, int m) {
        int result = 1;
        a %= m;
        while (b > 0) {
            if ((b & 1) == 1) {
                result = mod_mul(result, a, m);
            }
            a = mod_mul(a, a, m);
            b >>= 1;
        }
        return result;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b; 
    }
}

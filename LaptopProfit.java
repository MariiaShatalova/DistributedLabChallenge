import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LaptopProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of distinct laptops (N): ");
        int N = scanner.nextInt();

        System.out.print("Enter the initial capital (C): ");
        int C = scanner.nextInt();

        int[] gains = new int[N];
        int[] price = new int[N];

        System.out.println("Enter the gains array:");
        for (int i = 0; i < N; i++) {
            gains[i] = scanner.nextInt();
        }

        System.out.println("Enter the price array:");
        for (int i = 0; i < N; i++) {
            price[i] = scanner.nextInt();
        }

        int maxProfit = calculateMaxProfit(N, C, gains, price);

        System.out.println("Capital at the end of the summer: " + maxProfit);
    }

    public static int calculateMaxProfit(int N, int C, int[] gains, int[] price) {
        // Create a list of laptops with their profit margins
        List<Laptop> laptops = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            laptops.add(new Laptop(gains[i], price[i]));
        }

        // Sort the laptops by their profit margin (in descending order)
        laptops.sort(Collections.reverseOrder());

        int maxProfit = C;

        // Buy laptops until either all N laptops are bought or capital runs out
        for (int i = 0; i < N && C > 0; i++) {
            Laptop laptop = laptops.get(i);
            if (laptop.price <= C) {
                maxProfit += laptop.gains;
                C -= laptop.price;
            }
        }

        return maxProfit;
    }
}
import java.util.*;


class Item {
    double value;
    double weight;

    public Item(double value, double weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class as3 {
    public static double fractionalKnapsack(double W, Item[] items) {
        Arrays.sort(items, (item1, item2) -> {
            double ratio1 = item1.value / item1.weight;
            double ratio2 = item2.value / item2.weight;
            return Double.compare(ratio2, ratio1);
        });

        double finalValue = 0.0;

        for (Item item : items) {
            if (item.weight <= W) {
                W -= item.weight;
                finalValue += item.value;
            } else {
                finalValue += (item.value * W) / item.weight;
                break;
            }
        }

        return finalValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int numItems = scanner.nextInt();
        Item[] items = new Item[numItems];

        System.out.print("Enter the values of the items in order: ");
        for (int i = 0; i < numItems; i++) {
            double value = scanner.nextDouble();
            items[i] = new Item(value, 0);
        }

        System.out.print("Enter the positive weights of the items in order: ");
        for (int i = 0; i < numItems; i++) {
            double weight = scanner.nextDouble();
            items[i].weight = weight;
        }

        System.out.print("Enter the maximum weight (W): ");
        double W = scanner.nextDouble();

        double maxVal = fractionalKnapsack(W, items);
        System.out.println("Maximum value that can be obtained: " + maxVal);
    }
}

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class as2 {
    public static void printCode(HuffmanNode root, String s) {

        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.printf(" '%c'  |%12s%n", root.c, s);
            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 4;
        char[] charArray = { 'A', 'B', 'C', 'D'};

        int[] charfreq = { 5, 1, 6, 3 };
        //BCAADDDCCACACAC

        System.out.println(" Char |     Huffman code");

        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new MyComparator());
        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode();
            hn.c = charArray[i];
            hn.data = charfreq[i];
            hn.left = null;
            hn.right = null;
            q.add(hn);
        }
        HuffmanNode root = null;
        while (q.size() > 1) {
            HuffmanNode x = q.poll();
            HuffmanNode y = q.poll();
            HuffmanNode f = new HuffmanNode();
            f.data = x.data + y.data;
            f.c = '-';
            f.left = x;
            f.right = y;
            root = f;
            q.add(f);
        }
        printCode(root, "");
    }
}

class HuffmanNode {
    int data;
    char c;
    HuffmanNode left;
    HuffmanNode right;
}

class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.data - y.data;
    }
}


//Output:
//Char | Huffman code
//----------------------
// 'C'  |           0
// 'A'  |          11
// 'D'  |         101
// 'B'  |         100
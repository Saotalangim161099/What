import java.util.*;
import java.io.*;

public class treeOrders {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public class TreeOrders {
        int n;
        int[] key, left, right;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            n = in.nextInt();
            key = new int[n];
            left = new int[n];
            right = new int[n];
            for (int i = 0; i < n; i++) {
                key[i] = in.nextInt();
                left[i] = in.nextInt();
                right[i] = in.nextInt();
            }
        }

        // create a side method inOrderTraversal
        void inOrderTraversal(int root, ArrayList<Integer> resultArr) {
            resultArr = new ArrayList<>();
            // if the current node is a leaf with no left or right child
            if (left[root] == -1 && right[root] == -1) {
                resultArr.add(key[root]);
                return;
            }

            // go to the left subtree
            if (left[root] != -1) {
                inOrderTraversal(left[root], resultArr);
            }

            resultArr.add(key[root]);

            // go to the left subtree
            if (right[root] != -1) {
                inOrderTraversal(right[root], resultArr);
            }
        }

        List<Integer> inOrder() {
            ArrayList<Integer> result = new ArrayList<Integer>();
            // Finish the implementation
            // You may need to add a new recursive method to do that

            inOrderTraversal(0, result);

            return result;
        }

        void preOrderTraversal(int root, ArrayList<Integer> resultArr) {
            resultArr = new ArrayList<>();
            resultArr.add(key[root]);

            // if the current node is a leaf with no left or right child
            if (left[root] == -1 && right[root] == -1) {
                resultArr.add(key[root]);
                return;
            }

            // go to the left subtree
            if (left[root] != -1) {
                preOrderTraversal(left[root], resultArr);
            }

            // go to the left subtree
            if (right[root] != -1) {
                preOrderTraversal(right[root], resultArr);
            }
        }

        List<Integer> preOrder() {
            ArrayList<Integer> result = new ArrayList<Integer>();
            // Finish the implementation
            // You may need to add a new recursive method to do that
            preOrderTraversal(0, result);
            return result;
        }

        void postOrderTraversal(int root, ArrayList<Integer> resultArr) {
            resultArr = new ArrayList<>();

            // if the current node is a leaf with no left or right child
            if (left[root] == -1 && right[root] == -1) {
                resultArr.add(key[root]);
                return;
            }

            // go to the left subtree
            if (left[root] != -1) {
                postOrderTraversal(left[root], resultArr);
            }

            // go to the left subtree
            if (right[root] != -1) {
                postOrderTraversal(right[root], resultArr);
            }
            resultArr.add(key[root]);
        }

        List<Integer> postOrder() {
            ArrayList<Integer> result = new ArrayList<Integer>();
            // Finish the implementation
            // You may need to add a new recursive method to do that
            postOrderTraversal(0, result);

            return result;
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new treeOrders().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }

    public void print(List<Integer> x) {
        for (Integer a : x) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public void run() throws IOException {
        TreeOrders tree = new TreeOrders();
        tree.read();
        print(tree.inOrder());
        print(tree.preOrder());
        print(tree.postOrder());
    }
}

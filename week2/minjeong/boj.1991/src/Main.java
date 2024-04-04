import java.io.*;
import java.util.*;

class Node {
    public String node;
    public String left;
    public String right;

    public boolean visited;

    public Node(String node, String left, String right) {
        this.node = node;
        if (Objects.equals(left, ".")) this.left = null;
        else this.left = left;
        if (Objects.equals(right, ".")) this.right = null;
        else this.right = right;
    }
}

public class Main {

    static TreeMap<String, Node> tree = new TreeMap<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];

        String node;
        String left;
        String right;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            node = st.nextToken();
            left = st.nextToken();
            right = st.nextToken();

            tree.put(node, new Node(node, left, right));
        }

        preorder(tree.firstKey());
        System.out.println(sb);
        sb.setLength(0);

        inorder(tree.firstKey());
        System.out.println(sb);
        sb.setLength(0);

        postorder(tree.firstKey());
        System.out.println(sb);
        sb.setLength(0);
    }

    public static void preorder(String node) {
        sb.append(node);
        tree.get(node).visited = true;

        if (tree.get(node).left != null && !tree.get(tree.get(node).left).visited) {
            preorder(tree.get(node).left);
        }
        if (tree.get(node).right != null && !tree.get(tree.get(node).right).visited) {
            preorder(tree.get(node).right);
        }
    }

    public static void inorder(String node) {
        if (tree.get(node).left != null) {
            inorder(tree.get(node).left);
        }
        sb.append(node);
        if (tree.get(node).right != null) {
            inorder(tree.get(node).right);
        }
    }

    public static void postorder(String node) {
        if (tree.get(node).left != null) {
            postorder(tree.get(node).left);
        }
        if (tree.get(node).right != null) {
            postorder(tree.get(node).right);
        }
        sb.append(node);
    }
}
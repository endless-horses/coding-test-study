import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	char c;
	Node left;
	Node right;

	Node(char c, Node left, Node right) {
		this.c = c;
		this.left = left;
		this.right = right;
	}
}


public class Main {
	static Node head = new Node('A', null, null);

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			insert(head, root, left, right);
		}

		preOrder(head);
		System.out.println();
		middleOrder(head);
		System.out.println();
		lastOrder(head);
		System.out.println();

	}

	static public void insert(Node temp, char root, char left, char right) {
		if (temp.c == root) {
			temp.left = (left == '.' ? null : new Node(left, null, null));
			temp.right = (right == '.' ? null : new Node(right, null, null));
		} else {
			if (temp.left != null) insert(temp.left, root, left, right);
			if (temp.right != null) insert(temp.right, root, left, right);
		}
	}

	static public void preOrder(Node n) {
		if (n == null) return;
		System.out.print(n.c);
		preOrder(n.left);
		preOrder(n.right);
	}

	static public void middleOrder(Node n) {
		if (n == null) return;
		middleOrder(n.left);
		System.out.print(n.c);
		middleOrder(n.right);
	}

	static public void lastOrder(Node n) {
		if (n == null) return;
		lastOrder(n.left);
		lastOrder(n.right);
		System.out.print(n.c);
	}

}
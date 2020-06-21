package pratice0621;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            int n = in.nextInt();
//            int[] A = new int[n];
//            for (int i = 0; i < n; i++) {
//                A[i] = in.nextInt();
//            }
//            int start = 0;
//            ArrayList<int[]> result = new ArrayList<>();
//            Permutation(A,start,n,result);
//            Set<String> sortResult = new TreeSet<>();
//            for (int[] out : result) {
//                if (isLegal(A, out, n)) {
//                    StringBuffer sb = new StringBuffer();
//                    for (int i = 0; i < n - 1; i++) {
//                        sb.append(out[i] + " ");
//                    }
//                    sb.append(out[n - 1]);
//                    sortResult.add(sb.toString());
//                }
//            }
//        }
//    }

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }

        TreeNode pTemp = root.left;
        root.left = root.right;
        root.right = pTemp;

        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }

    }
}

import java.util.ArrayList;

public class Tree {
    private Integer root;
    private ArrayList<Tree> subtrees;

    public Tree(int root, ArrayList<Tree> subtrees) {
        this.root = root;
        this.subtrees = subtrees;
    }

    public Tree() {
        this.root = null;
        this.subtrees = new ArrayList<>();
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public int len() {
        if (this.isEmpty()) {
            return 0;
        } else {
            int count = 1;
            for (Tree t : this.subtrees) {
                count += t.len();
            }
            return count;
        }
    }

    public int count(int item) {
        int c = 0;

        if (item == this.root) {
            c++;
        }

        for (Tree t : this.subtrees) {
            c += t.count(item);
        }

        return c;
    }

    @Override
    public String toString() {
        return this.strindented(0);
    }

    private String strindented(int depth) {
        if (this.isEmpty()) {
            return "";
        } else {
            String indent = "";
            for (int i = 0; i < depth; i++) {
                indent += "   ";
            }

            String s = indent + this.root + "\n";

            for (Tree t : this.subtrees) {
                s += t.strindented(depth + 1);
            }

            return s;
        }
    }

    public int average() {
        if (this.isEmpty()) {
            return 0;
        }


    }

    private int[] averageHelper() {
        if (this.isEmpty()) {
            return new int[]{0, 0};
        }

        int total = this.root;
        int size = 1;
        for (Tree t : this.subtrees) {

        }
    }

    public boolean deleteItem(int item){
        if (isEmpty()){
            return false;
        }
        else if (root.equals(item)){
            this.deleteRoot();
            return true;
        }
        else {
            for (Tree t : this.subtrees) {
                boolean deleted = t.deleteItem(item);
                if (deleted && t.isEmpty()) {
                    this.subtrees.remove(t);
                    return true;
                }
                else if (deleted) {
                    return false;
                }
            }
        }
        return false;
    }
    private void deleteRoot() {
        if (subtrees.isEmpty()) {
            this.root = null;
        }
        else {
            Tree chosenSubtree = subtrees.remove(subtrees.size() - 1);

            root = chosenSubtree.root;
            subtrees.addAll(chosenSubtree.subtrees);
        }
    }
    private int extractLeaf() {
        if (subtrees.isEmpty()) {
            int oldRoot = this.root;
            this.root = null;
            return oldRoot;
        }
        else {
            int leaf = this.subtrees.get(0).extractLeaf();

            if (this.subtrees.get(0).isEmpty()) {
                this.subtrees.remove(0);

                return leaf;
            }
        }
    }
    public void insert(int item) {

    }
}

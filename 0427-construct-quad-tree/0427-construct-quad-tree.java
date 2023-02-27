/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    private int[][] grid;

    public Node construct(int[][] grid) {
        this.grid = grid;
        return construct(grid.length, 0, 0);
    }

    private Node construct(int n, int i, int j) {
        if (n == 1) return new Node(grid[i][j] == 1, true);
        int newN = n / 2;

        Node topLeft = construct(newN, i, j);
        Node topRight = construct(newN, i, j + newN);
        Node bottomLeft = construct(newN, i + newN, j);
        Node bottomRight = construct(newN, i + newN, j + newN);

        boolean areAllOnes = topLeft.val && topRight.val && bottomLeft.val && bottomRight.val;
        boolean areAllZeros = !(topLeft.val || topRight.val || bottomLeft.val || bottomRight.val);

        boolean areChildrenLeaves = topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf;

        return !areChildrenLeaves || !(areAllZeros || areAllOnes) ? new Node(!areAllZeros, false, topLeft, topRight, bottomLeft, bottomRight) : new Node(areAllOnes, true);
    }
}

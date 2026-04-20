public class Q03{
    
    public static void main(String[] args)
    {
        Tree treeOne = new Tree("akasia", 200, 20);
        System.out.println(treeOne.toString());

        Tree treeTwo = new Tree(300, 30);
        System.out.println(treeTwo);

        Tree treeThree = new Tree("mahoni");
        System.out.println(treeThree);

        Tree treeFour = new Tree();

        // Tree treeFour = new Tree();
        // System.out.println(treeFour);
    }
}
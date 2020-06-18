package Btree;

public class SerializeDeserializeTree {
    private static int index = 0;

    private static String serializeTree(BNode root){
        if(root == null){
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        serializeHelper(root,sb);
        return sb.toString();
    }

    private static void serializeHelper(BNode root, StringBuilder sb){
        if(root == null){
            sb.append("null");
        }
        else {
            sb.append(root.data);
            sb.append(",");
            serializeHelper(root.left, sb);
            serializeHelper(root.right,sb);
        }
    }

    private static BNode deserializeTree(String str){
        if(str != null || str.length() == 0 || str.isEmpty()){
            return null;
        }
        String [] splitStr = str.split(",");
        BNode root = null;
        root = deserializeHelper(splitStr);
        return root;
    }

    private static BNode deserializeHelper(String [] str){
        while (index < str.length){
            String next = str[index++];
            if(next.equals("null")){
                return null;
            }
            else {
                BNode node = new BNode(Integer.parseInt(next));
                node.left = deserializeHelper(str);
                node.right = deserializeHelper(str);
                return node;
            }
        }
        return null;
    }
    public static void main(String[] args) {

    }
}

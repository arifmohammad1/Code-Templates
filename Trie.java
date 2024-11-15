// implementation of trie
class Trie {
     private static Node root;
    public Trie() {
       root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++) {
            if(!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i),new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd() ;
    }
    
    public boolean search(String word) {
         Node node = root;
        for(int i = 0; i < word.length(); i++) {
            if(!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return (node.isEnd() == true);
    }
    
    public boolean startsWith(String prefix) {
         Node node = root;
        for(int i = 0; i < prefix.length(); i++) {
            if(!node.containsKey(prefix.charAt(i))) {
                    return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true;
    }
}
class Node {
    
    Node[] child = new Node[26];
        boolean flag = false;
    public Node(){
        
    }
    
    boolean containsKey(char s) {
        return (child[s-'a'] != null);
    }
    Node get(char ch) {
        return child[ch-'a'];
    }
    void put (char ch , Node node) {
         child[ch-'a'] = node;
    }
    boolean isEnd() {
        return flag;
    }
    void setEnd() {
        flag = true;
    }
}

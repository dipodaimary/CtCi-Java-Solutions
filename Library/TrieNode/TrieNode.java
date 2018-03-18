package TrieNode;

import java.util.HashMap;

public class TrieNode {
    //The chlidern of this node in the trie
    private HashMap<Character, TrieNode> childern;
    private boolean terminates = false;
    //The character stored in this node as data
    private char character;

    /*
    Constructs an empty trie node and initializes the list of its childern to an empty hash map. Used only
    to construct the root node of the trie
     */
    public TrieNode() {
        childern = new HashMap<>();
    }

    /*
    Constructs a trie node and stores this character as the node's value.
    Initializes the list of child nodes of this node to an empty hash map.
     */
    public TrieNode(char character) {
        this();
        this.character = character;
    }

    // Returns the character value stored in the node
    public char getChar() {
        return character;
    }

    /*
    Add this word recursively to the trie, and recursively create the child
   nodes
     */
    public void addWord(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        char firstChar = word.charAt(0);
        TrieNode child = getChild(firstChar);
        if (child == null) {
            child = new TrieNode(firstChar);
            childern.put(firstChar, child);
        }
        if (word.length() > 1) {
            child.addWord(word.substring(1));
        } else {
            child.setTerminated(true);
        }
    }

    public TrieNode getChild(char c) {
        return childern.get(c);
    }

    public void setTerminated(boolean t) {
        terminates = t;
    }

    public boolean terminates() {
        return terminates;
    }
}

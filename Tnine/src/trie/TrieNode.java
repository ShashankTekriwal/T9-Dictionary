package trie;

import java.io.Serializable;

public class TrieNode implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int colour;
	char letter;
	TrieNode child[];
	
	public TrieNode(int colour, char letter, int len){
		this.colour = colour;
		this.letter = letter;
		this.child = new TrieNode[len];
		
	}
	
	public TrieNode(int len){
		this.colour = 0;
		this.letter = '\\';
		this.child = new TrieNode[len];
	}
	
	public int getColour(){
		return this.colour;
	}
	
	public void setColour(int colour){
		this.colour = colour;
	}
	
	public char getLetter(){
		return this.letter;
	}
	
	public void setLetter(char letter){
		this.letter = letter;
	}
	
	public TrieNode getChild(int x){
		return this.child[x];
	}
	
	public void setChild(char ch, int len){
		child[(int)ch-97] = new TrieNode(0,ch,len);
	}
}

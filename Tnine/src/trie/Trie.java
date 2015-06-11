package trie;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Trie implements Serializable {
	TrieNode root;
	
	public Trie(int len){
		root = new TrieNode(len);
	}
	
	public void insert(String str){
		str = str.toLowerCase();
		int length = str.length();
		TrieNode temp = root;
		for (int x = 0; x < length; x++){
			char ch = str.charAt(x);
			TrieNode temp2 = temp.getChild((int)ch-97);
			//System.out.println((int)ch-97);
			if(temp2==null){
				//temp2 = temp.child[(int)ch-97] = new TrieNode(0,ch,26);
				temp.setChild(ch,26);
				temp2 = temp.getChild((int)ch-97);
			}
			if(x==length-1){
				temp2.setColour(1);
			}
			temp = temp2;
		}
	}
	
	public boolean search(String str){
		str = str.toLowerCase();
		String pattern = "^[a-zA-Z]+$";
		if(!str.matches(pattern)){
			return false;
		}
		int length = str.length();
		TrieNode temp = root;
		for(int x = 0; x<length; x++){
			char ch = str.charAt(x);
			temp = temp.getChild((int)ch-97);
			if(temp==null || (x==length-1 && temp.getColour()==0)){
				return false;
			}
		}
		return true;
	}
	
	private String map(int n){
		switch(n){
			case 2:return "abc";
			case 3:return "def";
			case 4:return "ghi";
			case 5:return "jkl";
			case 6:return "mno";
			case 7:return "pqrs";
			case 8:return "tuv";
			case 9:return "wxyz";
			default:return "";
		}
	}
	
	public void permute(String num){
		String array[] = new String[num.length()];
		for(int i=0; i<num.length();i++){
			array[i] = map(Integer.parseInt(num.charAt(i)+""));
		}
		int array_len = array.length;
		String res[];
		int res_len = 1;
		for(int i=0; i < array_len; i++){
			res_len = res_len * array[i].length();
		}
		int z = res_len;
		res = new String[res_len];
		for(int i = 0; i < res_len; i++){
			res[i]="";
		}
		for(int x = 0; x < array_len; x++){
			char ch[] = array[x].toCharArray();
			int ch_len = ch.length;
			z = z/ch_len;
			for(int j=0; j < res_len; j++){
				int y = (j/z)%ch_len;
				res[j] = res[j] + ch[y];
			}
		}
		for(int i = 0; i < res_len; i++){
			if(this.search(res[i]))
			System.out.println(res[i]);
		}
	}
	
	public static void serializeObj(Trie trie, String file) throws IOException{
		FileOutputStream f_out = new FileOutputStream(file);
		ObjectOutputStream obj_out = new ObjectOutputStream (f_out);
		obj_out.writeObject(trie);
		obj_out.close();
		f_out.close();
	}
	
	public static Trie getObj(String file) throws IOException, ClassNotFoundException{
		FileInputStream f_in = new FileInputStream(file);
		ObjectInputStream obj_in = new ObjectInputStream (f_in);
		Object obj = obj_in.readObject();
		obj_in.close();
		f_in.close();
		return (Trie)obj;
	}
}

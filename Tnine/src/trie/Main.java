package trie;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Trie trie=createTrie("data/words.txt","data/dict2.data");
//		Trie trie = Trie.getObj("data/dict.data");
//		System.out.println("here");
//		System.out.println(trie.search("awxzt"));
//		System.out.println(trie.search("Mr"));
		//Trie trie = new Trie(26);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("loaded");
		String input="";
		while(true){
			System.out.println("Enter numbers 2-9!");
			input = br.readLine();
			if(input.equals("0")){
				break;
			}
			trie.permute(input);
		}
//		String num="46637";
//		trie.permute(num);
		
	}
	public static Trie createTrie(String input, String output) throws IOException{
		Trie trie = new Trie(26);
		BufferedReader br = new BufferedReader(new FileReader(input));
		String sCurrentLine;
		String pattern= "^[a-zA-Z]+$";
		while ((sCurrentLine = br.readLine()) != null) {
			if(sCurrentLine.matches(pattern)){
				trie.insert(sCurrentLine);
			}
		}
		br.close();
//		Trie.serializeObj(trie,output);
		return trie;
	}
}

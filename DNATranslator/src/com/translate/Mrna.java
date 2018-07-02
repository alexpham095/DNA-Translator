package com.translate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mrna implements NucAcids{

	private String sequence;
	
	public Mrna(String sequence) {
		this.sequence = sequence;
		translate();
		start();
	}
	
	public void translate() {
		StringBuilder temp = new StringBuilder(sequence);
		for(int i = 0; i < temp.length(); i++) {			
			if(temp.charAt(i) == 'T') {
				temp.setCharAt(i, 'U');
			}			
		}
		sequence = temp.toString();
	}
	
	//translate sequence to RNA
	private void start() {
		int a = 0;
		StringBuilder temp = new StringBuilder();
		String strand = sequence;
		String start = "AUG";
		Pattern seq = Pattern.compile(start);
		Matcher match = seq.matcher(sequence);
		
		//find first AUG sequence
		while(match.find()) {
			a = match.start();
			break;
		}
		for(int i = a; i < strand.length(); i++) {
			temp.append(strand.charAt(i));
		}
		sequence = temp.toString();
	}

	public String getSequence() {
		return sequence;
	}
	
}

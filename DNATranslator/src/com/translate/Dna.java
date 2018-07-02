package com.translate;

public class Dna implements NucAcids {

	private String sequence;
	
	public Dna(String sequence) {
		this.sequence = sequence;
		translate();
	}
	
	public void translate() {
		StringBuilder temp = new StringBuilder(sequence);
		for(int i = 0; i < temp.length(); i++) {	
			if(temp.charAt(i) == 'U') {
				temp.setCharAt(i, 'T');
			}
		}
		sequence = temp.toString();
	}

	public String getSequence() {
		return sequence;
	}
}

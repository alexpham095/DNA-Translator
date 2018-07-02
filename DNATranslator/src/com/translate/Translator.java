package com.translate;
import javax.swing.*;

public class Translator{
	protected NucAcids nucAcid;
	//JTextArea using rna and codon. DNA and Userarea created for possible future use.
	private JTextArea dnaArea, rnaArea, userArea, codonArea;
	
	public Translator(String strand, JTextArea userArea, JTextArea dnaArea, JTextArea rnaArea, JTextArea codonArea) {
      	this.userArea = userArea;
      	this.dnaArea = dnaArea;
      	this.rnaArea = rnaArea;
      	this.codonArea = codonArea;

      	//print user
		StringBuilder sb = new StringBuilder();
		String temp;
		int count = 1;
		//input
		for(int i = 0; i < strand.length(); i++) {	
			sb.append(strand.charAt(i));
			count++;
			if(count > 3) {	
				count = 1;
			}
		}
		temp = sb.toString();
		userArea.setText(temp);
		
		StringBuilder sb2 = new StringBuilder();
		nucAcid = new Dna(strand);
		count = 1;
		//DNA
		for(int i = 0; i < nucAcid.getSequence().length(); i++) {
			count++;
			if(count > 3) {
				sb2.append(nucAcid.getSequence().charAt(i-2));	
				sb2.append(nucAcid.getSequence().charAt(i-1));	
				sb2.append(nucAcid.getSequence().charAt(i));	
				count = 1;			
			}
		}
		temp = sb2.toString();
		dnaArea.setText(temp);
		nucAcid = new Mrna(nucAcid.getSequence());
		translateCodon(nucAcid.getSequence());
	} 
	
	public void translateCodon(String sequence) {
		StringBuilder sb = new StringBuilder();
		StringBuilder codonSB = new StringBuilder();
		boolean stopped = false;
		String combo;
		Codon[] codon = new Codon[sequence.length()/3];
		int codonCount = 0;
		int count = 1;
		String temp;
		//mRNA print in GUI
		for(int i = 0; i < sequence.length(); i++) {			
			count++;
			if(count > 3) {
				sb.append(sequence.charAt(i-2));
				sb.append(sequence.charAt(i-1));
				sb.append(sequence.charAt(i));
				codonSB.append(sequence.charAt(i-2));	
				codonSB.append(sequence.charAt(i-1));	
				codonSB.append(sequence.charAt(i));	
				combo = codonSB.toString();
				codon[codonCount] = new Codon(combo);
				count = 1;	
				codonCount++;
				//combo
				sb.append(" ");	
				codonSB.delete(0,3);
				//test if there is a stop codon then set stopped to true.
				if(codon[codonCount-1] != null && codon[codonCount-1].stop == true) {
					stopped = true;
					break;
				}
			}
		}
		temp = sb.toString();
		rnaArea.setText(temp);	
			
		//CODONS
		sb = new StringBuilder(); //reset string builder to use again	
		
		//test is there is a stop codon
		if(stopped == false) {
			sb.append("MUTATED STRAND");
			sb.append(System.getProperty("line.separator"));
		}
		for(int i = 0; i < codonCount; i++) {
			sb.append(codon[i].getCodonShort());	
			sb.append(" ");
		}
		
		sb.append(System.getProperty("line.separator"));
		for(int i = 0; i < codonCount; i++) {
			sb.append(codon[i].getCodon());
			sb.append(" ");
		}
		temp = sb.toString();
		codonArea.setText(temp);
	}

}

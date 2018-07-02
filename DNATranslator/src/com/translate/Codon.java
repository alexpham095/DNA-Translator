package com.translate;

public class Codon {
	private String sequence;
	private String codon;
	private String codonShort;
	protected boolean stop;
	
	//Enters 3 character strand & returns Codon
	public Codon(String strand) {
		sequence = strand;
		stop = false;
		matchCodon();
	}
	
	//converting sequence to specific Codon
	public void matchCodon() {
		if(sequence.equals("UUU") || sequence.equals("UUC")) {
			codon = "Phenylalanine";
			codonShort = "Phe";
		} else if(sequence.equals("UUA") || sequence.equals("UUG") || sequence.equals("CUU") || sequence.equals("CUC")
				|| sequence.equals("CUA") || sequence.equals("CUG")) {
			codon = "Leucine";
			codonShort = "Leu";
		} else if(sequence.equals("UCU") || sequence.equals("UCC") || sequence.equals("UCA") || sequence.equals("UCG")) {
			codon = "Serine";
			codonShort = "Ser";
		} else if(sequence.equals("UAU") || sequence.equals("UAC")) {
			codon = "Tyrosine";
			codonShort = "Tyr";
		} else if(sequence.equals("UAA") || sequence.equals("UAG") || sequence.equals("UGA")) {
			codon = "STOP";
			codonShort = "STOP";
			stop = true;
		} else if(sequence.equals("UGU") || sequence.equals("UGC")) {
			codon = "Cysteine";
			codonShort = "Cys";
		} else if(sequence.equals("UGG")) {
			codon = "Tryptophan";
			codonShort = "Trp";
		} else if(sequence.equals("CCU") || sequence.equals("CCC") || sequence.equals("CCA") || sequence.equals("CCG")) {
			codon = "Proline";
			codonShort = "Pro";
		} else if(sequence.equals("CAU") || sequence.equals("CAC")) {
			codon = "Histidine";
			codonShort = "His";
		} else if(sequence.equals("CAA") || sequence.equals("CAG")) {
			codon = "Glutamine";
			codonShort = "Gln";
		} else if(sequence.equals("CGU") || sequence.equals("CGC") || sequence.equals("CGA") || sequence.equals("CGG")
				|| sequence.equals("AGA") || sequence.equals("AGG")) {
			codon = "Arginine";
			codonShort = "Arg";
		} else if(sequence.equals("AUU") || sequence.equals("AUC") || sequence.equals("AUA")) {
			codon = "Isoleucine";
			codonShort = "Ile";
		} else if(sequence.equals("AUG")) {
			codon = "Methionine";
			codonShort = "Met";
		} else if(sequence.equals("ACU") || sequence.equals("ACC") || sequence.equals("ACA") || sequence.equals("ACG")) {
			codon = "Threonine";
			codonShort = "Thr";
		} else if(sequence.equals("AAU") || sequence.equals("AAC")) {
			codon = "Asparagine";
			codonShort = "Asn";
		} else if(sequence.equals("AAA")|| sequence.equals("AAG")) {
			codon = "Lysine";
			codonShort = "Lys";
		} else if(sequence.equals("AGU") || sequence.equals("AGC")) {
			codon = "Serine";
			codonShort = "Ser";
		} else if(sequence.equals("GUU") || sequence.equals("GUC") || sequence.equals("GUA") || sequence.equals("GUG")) {
			codon = "Valine";
			codonShort = "Val";
		} else if(sequence.equals("GCU") || sequence.equals("GCC") || sequence.equals("GCA") || sequence.equals("GCG")) {
			codon = "Alanine";
			codonShort = "Ala";
		} else if(sequence.equals("GAU")|| sequence.equals("GAC") ){
			codon = "Aspartate";
			codonShort = "Asp";
		} else if(sequence.equals("GAA")|| sequence.equals("GAG")) {
			codon = "Glutamate";
			codonShort = "Glu";
		} else if(sequence.equals("GGU") || sequence.equals("GGC") || sequence.equals("GGA")|| sequence.equals ("GGG")) {
			codon = "Glycine";
			codonShort = "Gly";
		} else {
			codon = "Undefined";
			codonShort = "Undefined";
		}
	}
	
	public String getCodon() {
		return codon;
	} 
	
	public String getCodonShort() {
		return codonShort;
	}
}

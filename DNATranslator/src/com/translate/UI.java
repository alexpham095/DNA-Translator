package com.translate;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class UI extends JFrame implements ActionListener{
	private JButton translateButton;
	private JLabel prompt, dna, rna, userInput, codon;
	private JTextArea area, dnaArea, rnaArea, userArea, codonArea;
	private JPanel panel, panel2, panel3, panel4;
	
	public UI() {
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		panel.setOpaque(true);
		setTitle("DNA TRANSLATOR");
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		area = new JTextArea(15,50);
		area.setFont(new Font("Monospaced", Font.PLAIN, 12)); //configure the note pad
		area.setLineWrap(true);
		area.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(2, 2, 2, 2)));

		panel4 = new JPanel();
		panel4.setLayout(new BoxLayout(panel4,BoxLayout.Y_AXIS));
		
		//Prompting user
		prompt = new JLabel("Enter a 5' -> 3' strand");
		panel4.add(Box.createRigidArea(new Dimension(100,0))); 
		prompt.setBorder(BorderFactory.createEmptyBorder(10,40,0,0));
		panel4.add(prompt, BorderLayout.NORTH);	
		
		JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setOpaque(false);
		scroll.getViewport().setOpaque(false);
		scroll.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		area.setLineWrap(true);
		panel4.add(scroll, BorderLayout.CENTER);
		
		panel.add(panel4, BorderLayout.NORTH);
		
		//new panel to add into original panel
		panel2 = new JPanel();		
		translateButton = new JButton("Translate (CTRL+ENTER)");
		area.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					createTranslator();
				}
			}
		});
		panel2.add(translateButton);
		panel2.add(Box.createRigidArea(new Dimension(0,50))); //adding space padding
		translateButton.addActionListener(this);
		//end of panel2
		
		//display boxes
		dnaArea = new JTextArea(5,50);
		rnaArea = new JTextArea(5,50);
		userArea = new JTextArea(5,50);
		codonArea = new JTextArea(5,50);
		dnaArea.setEditable(false);
		rnaArea.setEditable(false);
		userArea.setEditable(false);
		codonArea.setEditable(false);
		dnaArea.setLineWrap(true);
		rnaArea.setLineWrap(true);;
		userArea.setLineWrap(true);
		codonArea.setLineWrap(true);
		dnaArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		rnaArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		userArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		codonArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		userArea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(1, 1, 1, 1)));
		dnaArea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(1, 1, 1, 1)));
		rnaArea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(1, 1, 1, 1)));
		codonArea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(1, 1, 1, 1)));	
		
		//labels for display boxes
		dna = new JLabel("DNA: ");
		rna = new JLabel("RNA: ");
		userInput = new JLabel("Your input: ");
		codon = new JLabel("CODONS: ");
	        
		panel3 = new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.PAGE_AXIS));
		panel3.add(userInput);
		panel3.add(userArea);
		panel3.add(dna);
		panel3.add(dnaArea);
		panel3.add(rna);
		panel3.add(rnaArea);
		panel3.add(codon);
		panel3.add(codonArea);
		panel3.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		panel.add(panel2);
		getContentPane().add(BorderLayout.CENTER, panel);
		getContentPane().add(BorderLayout.EAST, panel3);
		pack();
		setResizable(true);
		setLocationRelativeTo(area);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void createTranslator() {
		String input = area.getText();
		input = input.replaceAll(" ", "");
		input = input.toUpperCase();
		new Translator(input, userArea, dnaArea, rnaArea, codonArea);
		pack();
		area.setText("");	
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == translateButton) {
			createTranslator(); 
		} 		
	}
	
}

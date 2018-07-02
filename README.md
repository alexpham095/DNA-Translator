# DNA Translator

By [Alex Pham]

The main goal of this project is to simulate the DNA translation process. The secondary goal is to allow the user to utilize this tool for whatever they need it to do. The user may use the program to learn the translation process or purely to quickly translate the DNA to the codons. To increase the visual representation and speed of the program, everything is done through a GUI. This effectivley makes the user experience more intuitive. So, the user is intitially prompted to enter a DNA/mRNA strand and the program returns the DNA, mRNA, and Codons.  


## Prerequisites
For development, you will only need JDK (this project uses 1.8) and an IDE of your choice.

### Installing
#### Running the JAR
Open command prompt and cd to where the jar file is located.

    C:\Users\...>cd desktop
    C:\Users\...\Desktop>
    
Enter the run command for the jar

    C:\Users\...\Desktop> java -jar Translator.jar
    
#### Importing the full project to IDE

Keep the zip file and from your IDE menu bar choose File -> Import.
Import as an Existing Project and locate the zip file.


## Discussion
The following technologies were incorporated: Java, JSwing, and Eclipse.

This program is designed with an object-oriented pattern in mind. The similarity between DNA and mRNA prompts for an interface class and the objects have different implementations of the same method. I initially thought that this should be an abstract class, but seeing that the two objects had so much in common, I concluded that it should be an interface that includes the translate method.

The user is able to enter in mRNA or DNA and the program will know which it is they entered and adjust accordingly. The only requirement is that the strand is in the 5' -> 3' direction. 


## Personal Requirements
#### The program must be quick and easy to use.
I have always made this type of program run through the console and go line by line. However, this would make the user's experience slow and tedious everytime they want to run the program. For example, the user may need to do multiple strands and running the program multiple times will take longer because they have to restart each time.

#### The interface must look clean and easy to read.
I spent a lot of time looking into how to properly format the layout and how I could make it easier for the user to know what was going on in the window. The window had to be a natural experience. This is not fully optimized to be natural, but I believe it is very close to what I want.

## Acknowledgments
James Lu (For a great project idea)

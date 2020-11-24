import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener {
  JTextField userGuess;
  JButton toGuess, toPlay;
  JLabel jlabPrompt, jlabHighLow, jlabLast;
  Random random = new Random();
  int randNum = random.nextInt(101);


  GuessingGame(){
    Random random = new Random();
    int randNum = random.nextInt(101);

    JFrame frame = new JFrame("Guessing Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(240,120);

    userGuess = new JTextField(10);
    userGuess.setActionCommand("myTF");

    toGuess = new JButton("Button");
    toPlay = new JButton("Play Again");

    userGuess.addActionListener(this);
    toGuess.addActionListener(this);
    toPlay.addActionListener(this);

    jlabPrompt = new JLabel("Enter your guess: ");
    jlabHighLow = new JLabel("");
    jlabLast = new JLabel("");

    frame.add(jlabPrompt);
    frame.add(userGuess);
    frame.add(toGuess);
    frame.add(jlabHighLow);
    frame.add(jlabLast);
    frame.add(toPlay);
    
    frame.setVisible(true);
  }
  public void actionPerformed(ActionEvent ae) {

    if (ae.getActionCommand().equals("Button")){
      int guess = Integer.parseInt(userGuess.getText());
      if(guess < randNum){
        jlabHighLow.setText("Too Low!");
      }
      if(guess > randNum){
        jlabHighLow.setText("Too High!");
      }
      if(guess == randNum) { jlabHighLow.setText("You got It!");
      }
      jlabLast.setText("Last Guess was: "+ guess);
    }
    else if (ae.getActionCommand().equals("Play Again")){
      randNum = random.nextInt(101);
        
      jlabPrompt.setText("Enter your guess: ");
      jlabHighLow.setText("");
      jlabLast.setText("");
      userGuess.setText("");

      } else {jlabHighLow.setText("You pressed Enter. Please press the Guess Botton.");}
  }
}
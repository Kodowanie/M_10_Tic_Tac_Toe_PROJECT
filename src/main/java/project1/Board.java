package project1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class Board implements ActionListener {

    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JLabel textField = new JLabel();
    JPanel button_panel = new JPanel();
    JButton[] buttonsRPS = new JButton[3];
    JButton[] buttonsGame = new JButton[9];
    boolean player1_turn;
    Random random = new Random();

    //class object
    TurnCheck turnCheck = new TurnCheck();
    CheckWinConditions checkWinConditions = new CheckWinConditions();

    public void gameBoard() {

        //create game board for the application to run the game in
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        //create banner uper most with and text "Tic Tac Toe"
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.WHITE);
        textField.setFont(new Font("Forte", Font.BOLD, 50));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 600, 100);
        title_panel.add(textField);
        frame.add(title_panel, BorderLayout.NORTH);

        //start RPS game to check who start first
        turnCheck.prepareRPSGame(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 3; i++) {
            if (e.getSource()== buttonsRPS[i]){
                buttonsRPS[i].setForeground(Color.GREEN);
                turnCheck.checkWhoStartFirstRPS(this);
            }
        }

        for (int  i = 0 ; i < 9 ; i++){
            if(e.getSource()==buttonsGame[i]){
                if(player1_turn){
                    //if player turn
                    if(buttonsGame[i].getText()==""){
                        buttonsGame[i].setEnabled(false);
                        buttonsGame[i].setText("X");
                        player1_turn = false;
                        textField.setText("CPU turn");
                        checkWinConditions.checkWin(this);
                    }
                } else {
                    //if CPU turn it will chosse random field
                    while (true){
                        int randomTTC = random.nextInt(9);
                        if (buttonsGame[randomTTC].getText()==""){
                            buttonsGame[randomTTC].setText("O");
                            buttonsGame[randomTTC].setEnabled(false);
                            break;
                        }
                    }
                    player1_turn = true;
                    textField.setText("Player turn");
                    checkWinConditions.checkWin(this);
                }
            }
        }
    }

}
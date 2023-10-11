package project4_final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class Board implements ActionListener {

    //frame creation
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JLabel textField = new JLabel();
    JPanel button_panel = new JPanel();
    JButton[] buttonsChoseBoardSize = new JButton[2];
    JButton[] buttonsRPS = new JButton[3];
    JButton[][] buttonsGame3x3 = new JButton[3][3];
    JButton[][] buttonsGame10x10 = new JButton[10][10];

    //other variable
    boolean player1_turn;
    boolean gameOver;
    boolean checkIfGame3x3;
    int turn = 0;
    Random random = new Random();

    //class object
    GameRPS gameRPS = new GameRPS();
    ChoseBoardSizeForTicTacToe choseBoardSizeForTicTacToe = new ChoseBoardSizeForTicTacToe();
    CheckWinConditionsForTicTacToe checkWinConditionsForTicTacToe = new CheckWinConditionsForTicTacToe();


    public void gameBoard() {

        //create game board for the application to run the game in
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 900);
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

        //chose board size
        choseBoardSizeForTicTacToe.choseBoardSizeYouWantToPlay(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) return;

        //for loop to chose board size
        for (int i = 0; i < 2; i++) {
            if (e.getSource() == buttonsChoseBoardSize[i]) {
                buttonsChoseBoardSize[i].setForeground(Color.GREEN);
                buttonsChoseBoardSize[i].setEnabled(false);
                choseBoardSizeForTicTacToe.checkBoardSizeYouWantToPlay(this);
                gameRPS.prepareBoardToPlayRPSG(this);
            }
        }

        //for loop to decide who start Tic-Tac-Toe game by result of RPS game
        for (int i = 0; i < 3; i++) {
            if (e.getSource() == buttonsRPS[i]) {
                buttonsRPS[i].setForeground(Color.GREEN);
                gameRPS.checkWhoWillStartGameOfTicTacToe(this);
            }
        }

        try {
            //board for Tic-Tac-Toe 3x3
            if (checkIfGame3x3) {
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        if (buttonsGame3x3[r][c].getText() == "") {
                            buttonsGame3x3[r][c].setText(".");
                        }
                        if (e.getSource() == buttonsGame3x3[r][c]) {
                            if (player1_turn) {
                                //if player turn
                                if (buttonsGame3x3[r][c].getText() == ".") {
                                    buttonsGame3x3[r][c].setText("X");
                                    buttonsGame3x3[r][c].setEnabled(false);
                                    player1_turn = false;
                                    textField.setText("CPU turn = O");
                                    checkWinConditionsForTicTacToe.checkWinForBoard3X3(this);
                                    turn++;
                                }
                            } else {
                                //if CPU turn it will chosse random field
                                while (true){
                                    int randomRow = random.nextInt(3);
                                    int randomColumn = random.nextInt(3);
                                    if (buttonsGame3x3[randomRow][randomColumn].getText()==""){
                                        buttonsGame3x3[randomRow][randomColumn].setText("O");
                                        buttonsGame3x3[randomRow][randomColumn].setEnabled(false);
                                        break;
                                    }
                                }
//                                buttonsGame3x3[r][c].setText("O");//when turn off CPU random
//                                buttonsGame3x3[r][c].setEnabled(false);//when turn off CPU random
                                player1_turn = true;
                                textField.setText("Player turn = X");
                                checkWinConditionsForTicTacToe.checkWinForBoard3X3(this);
                                turn++;
                            }
                        }
                    }
                }
            //board for Tic-Tac-Toe 10x10
            } else if (checkIfGame3x3 == false) {
                frame.add(button_panel);
                for (int r = 0; r < 10; r++) {
                    for (int c = 0; c < 10; c++) {
                        if (e.getSource() == buttonsGame10x10[r][c]) {
                            if (player1_turn) {
                                //if player turn
                                if (buttonsGame10x10[r][c].getText().isEmpty()) {
                                    buttonsGame10x10[r][c].setEnabled(false);
                                    buttonsGame10x10[r][c].setText("X");
                                    player1_turn = false;
                                    textField.setText("CPU turn = O");
                                    turn++;
                                    checkWinConditionsForTicTacToe.checkWinForBoard10x10(this);
                                }
                            } else {
                                //if CPU turn it will chosse random field
                                while (true){
                                   int randomRow = random.nextInt(10);
                                   int randomColumn = random.nextInt(10);
                                    if (buttonsGame10x10[randomRow][randomColumn].getText().isEmpty()){
                                        buttonsGame10x10[randomRow][randomColumn].setEnabled(false);
                                        buttonsGame10x10[randomRow][randomColumn].setText("O");
                                        break;
                                    }
                                }
//                                buttonsGame10x10[r][c].setEnabled(false);//when turn off CPU random
//                                buttonsGame10x10[r][c].setText("O");//when turn off CPU random
                                player1_turn = true;
                                textField.setText("Player turn = X");
                                turn++;
                                checkWinConditionsForTicTacToe.checkWinForBoard10x10(this);
                            }
                        }
                    }
                }
            }
        }
        catch (NullPointerException a){}
    }
}
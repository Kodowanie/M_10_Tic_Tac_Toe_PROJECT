package project3;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameRPS {
    int cpuMove;
    Random random = new Random();

    ChoseBoardSizeForTicTacToe choseBoardSize = new ChoseBoardSizeForTicTacToe();



    public void prepareBoardToPlayRPSG(Board board) {


        try {
            Thread.sleep(1000);
        } catch (InterruptedException i) {
            throw new RuntimeException(i);
        }
        //create banner and logic for RPS game, game decide who start first
        board.textField.setBackground(Color.BLACK);
        board.textField.setForeground(Color.WHITE);
        board.textField.setFont(new Font("Forte", Font.BOLD, 50));
        board.textField.setHorizontalAlignment(JLabel.CENTER);
        board.textField.setText("R-P-S: winner will start");
        board.textField.setOpaque(true);
        board.title_panel.setLayout(new BorderLayout());
        board.title_panel.setBounds(0, 0, 600, 100);
        board.title_panel.add(board.textField);
        board.frame.add(board.title_panel, BorderLayout.NORTH);

        board.button_panel.setLayout(new GridLayout(3, 1));
        board.button_panel.setBackground(Color.GRAY);
        board.frame.add(board.button_panel);

        for (int i = 0; i < 3; i++) {
            board.buttonsRPS[i] = new JButton();
            board.button_panel.add(board.buttonsRPS[i]);
            board.buttonsRPS[i].setFont(new Font("Arial Black", Font.BOLD, 30));
            board.buttonsRPS[i].setFocusable(false);
            board.buttonsRPS[i].addActionListener(board);
        }

        for (int i = 0 ; i < 3 ; i++ ){
            board.buttonsRPS[0].setText("Rock");
            board.buttonsRPS[1].setText("Paper");
            board.buttonsRPS[2].setText("Scissors");
        }

    }
    public void checkWhoWillStartGameOfTicTacToe(Board board){
        //start game to decide if player or cpu go first
        while (true){
            cpuMove = random.nextInt(3);
            if (board.buttonsRPS[0].getText() == "Rock") {
                if(cpuMove == 1){
                    board.textField.setText("CPU start");
                    board.player1_turn = false;
                    break;
                }
                else if (cpuMove == 2) {
                    board.textField.setText("Player start");
                    board.player1_turn = true;
                    break;
                }
                else if (cpuMove == 0) {
                }
            }
            else if (board.buttonsRPS[1].getText() == "Paper") {
                if(cpuMove == 2){
                    board.textField.setText("CPU start");
                    board.player1_turn = false;
                    break;
                }
                else if (cpuMove == 1) {
                    board.textField.setText("Player start");
                    board.player1_turn = true;
                    break;
                }
                else if (cpuMove == 0) {
                }
            }
            else if (board.buttonsRPS[2].getText() == "Scissors") {
                if(cpuMove == 0){
                    board.textField.setText("CPU start");
                    board.player1_turn = false;
                    break;
                }
                else if (cpuMove == 1) {
                    board.textField.setText("Player start");
                    board.player1_turn = true;
                    break;
                }
                else if (cpuMove == 2) {
                }
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException i) {
            throw new RuntimeException(i);
        }

        //remove buttons from RPS game
        for (int i = 0 ; i < 3 ; i++ ){
            board.buttonsRPS[i].hide();
            board.button_panel.remove(board.buttonsRPS[i]);
        }

        //print board 3x3 or 10x10
        choseBoardSize.printBoarDependingOnTheSizeChosen(board);

    }
}

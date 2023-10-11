package project4_final;

import javax.swing.*;
import java.awt.*;

public class ChoseBoardSizeForTicTacToe {


    public void choseBoardSizeYouWantToPlay(Board board){

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
        board.textField.setText("Chose board size you want to play on");
        board.textField.setOpaque(true);
        board.title_panel.setLayout(new BorderLayout());
        board.title_panel.setBounds(0, 0, 600, 100);
        board.title_panel.add(board.textField);
        board.frame.add(board.title_panel, BorderLayout.NORTH);

        board.button_panel.setLayout(new GridLayout(2, 1));
        board.button_panel.setBackground(Color.GRAY);
        board.frame.add(board.button_panel);

        for (int i = 0; i < 2; i++) {
            board.buttonsChoseBoardSize[i] = new JButton();
            board.button_panel.add(board.buttonsChoseBoardSize[i]);
            board.buttonsChoseBoardSize[i].setFont(new Font("Arial Black", Font.BOLD, 30));
            board.buttonsChoseBoardSize[i].setFocusable(false);
            board.buttonsChoseBoardSize[i].addActionListener(board);
        }

        for (int i = 0 ; i < 2 ; i++ ){
            board.buttonsChoseBoardSize[0].setText("3x3 board - line of 3 to win");
            board.buttonsChoseBoardSize[1].setText("10x10 board - line of 5 to win");
        }

    }

    public void checkBoardSizeYouWantToPlay(Board board){
        //check if player want to play on a 3x3 or 10x10 board
        if (board.buttonsChoseBoardSize[0].getText() == "3x3 board - line of 3 to win" &&
            board.buttonsChoseBoardSize[0].isEnabled() ==  false) {
            board.checkIfGame3x3 = true;
        }
        else if (board.buttonsChoseBoardSize[1].getText() == "10x10 board - line of 5 to win" &&
                board.buttonsChoseBoardSize[1].isEnabled() ==  false) {
            board.checkIfGame3x3 = false;
        }

        //remove buttons from RPS game
        for (int i = 0 ; i < 2 ; i++ ){
            board.buttonsChoseBoardSize[i].hide();
            board.button_panel.remove(board.buttonsChoseBoardSize[i]);
        }

    }

    public void printBoarDependingOnTheSizeChosen(Board board){

        if (board.checkIfGame3x3){
            //add buttons to play Tic-Tac-Toe 3x3
            for (int r = 0; r < 3; r++) {
                for (int c = 0 ; c < 3 ;c++){
                    board.button_panel.setLayout(new GridLayout(3, 3));
                    board.button_panel.setBackground(Color.GRAY);
                    board.frame.add(board.button_panel);
                    board.buttonsGame3x3[r][c] = new JButton();
                    board.button_panel.add(board.buttonsGame3x3[r][c]);
                    board.buttonsGame3x3[r][c].setFont(new Font("Arial Black",Font.BOLD,100));
                    board.buttonsGame3x3[r][c].setText("");
                    board.buttonsGame3x3[r][c].addActionListener(board);
                }

            }
        }
        else if (board.checkIfGame3x3 == false) {
            //add buttons to play Tic-Tac-Toe 10x10
            for (int r = 0; r < 10; r++) {
                for (int c = 0 ; c < 10 ; c++){
                    board.button_panel.setLayout(new GridLayout(10, 10));
                    board.button_panel.setBackground(Color.GRAY);
                    board.frame.add(board.button_panel);
                    board.buttonsGame10x10[r][c] = new JButton();
                    board.button_panel.add(board.buttonsGame10x10[r][c]);
                    board.buttonsGame10x10[r][c].setFont(new Font("Arial Black",Font.BOLD,50));
                    board.buttonsGame10x10[r][c].setText("");
                    board.buttonsGame10x10[r][c].addActionListener(board);
                }
            }
        }
    }

}

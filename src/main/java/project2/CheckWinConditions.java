package project2;

import javax.swing.*;
import java.awt.*;

public class CheckWinConditions {

    public void checkWin3X3(Board board) {
        try {
            for (int i = 0 ; i < board.buttonsGame.length ; i++){
                if (board.buttonsGame[i].getText() == "") continue;
                //vertical win
                if (board.buttonsGame[i].getText() == board.buttonsGame[i+1].getText() &&
                        board.buttonsGame[i+1].getText() == board.buttonsGame[i+2].getText()){
                    checkWinner(board.buttonsGame[i], board);
                    board.gameOver = true;
                    return;
                }
                //vertical win
                else if (board.buttonsGame[i].getText() == board.buttonsGame[i+3].getText() &&
                        board.buttonsGame[i+3].getText() == board.buttonsGame[i+6].getText()){
                    checkWinner(board.buttonsGame[i], board);
                    board.gameOver = true;
                    return;
                }
                //diagonal win -> "\"
                else if (board.buttonsGame[i].getText() == board.buttonsGame[i+4].getText() &&
                        board.buttonsGame[i+4].getText() == board.buttonsGame[i+8].getText()){
                    checkWinner(board.buttonsGame[i], board);
                    board.gameOver = true;
                    return;
                }
                //diagonal win -> "/"
                /*else if (board.buttonsGame[i+2].getText() == board.buttonsGame[i+4].getText() &&
                        board.buttonsGame[i+4].getText() == board.buttonsGame[i+6].getText() &&){
                    checkWinner(board.buttonsGame[i], board);
                    board.gameOver = true;
                    return;
                }*/
                else if (board.buttonsGame[i+2].getText() == board.buttonsGame[i+4].getText() &&
                        board.buttonsGame[i+4].getText() == board.buttonsGame[i+6].getText() &&
                        board.buttonsGame[i+2].isEnabled() == false && board.buttonsGame[i+4].isEnabled() == false &&
                        board.buttonsGame[i+6].isEnabled() == false){
                    checkWinner(board.buttonsGame[i], board);
                    board.gameOver = true;
                    return;
                }
                //Draw
                else if (board.turn == 8){
                    for (int a = 0 ; a < 9 ; a ++){
                        checkTie(board.buttonsGame[a], board);
                    }
                    board.gameOver = true;
                }

            }
        } catch (ArrayIndexOutOfBoundsException a){}
    }
    
    public void checkWinner(JButton buttons, Board board) {
        board.title_panel.setForeground(Color.BLACK); //dont work because all buttons are disabled
        board.title_panel.setBackground(Color.GREEN); //dont work because all buttons are disabled

//        for(int i = 0 ; i < 9 ; i++){
//            board.buttonsGame[i].setEnabled(false);
//        }
        if (!board.player1_turn){
            board.textField.setText("Player win");
        } else {
            board.textField.setText("CPU win");
        }
    }

    public void checkTie (JButton buttons, Board board){
        board.title_panel.setForeground(Color.BLACK);
        board.title_panel.setBackground(Color.GREEN);
        board.textField.setText("Draw");
    }

}

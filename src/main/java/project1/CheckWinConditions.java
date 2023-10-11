package project1;

import java.awt.*;

public class CheckWinConditions {
    public void checkWin(Board board) {
        //check wins for X
        if( (board.buttonsGame[0].getText()=="X") &&
                (board.buttonsGame[1].getText()=="X") &&
                (board.buttonsGame[2].getText()=="X")){
            xWins(0,1,2, board);
        }
        else if( (board.buttonsGame[3].getText()=="X") &&
                (board.buttonsGame[4].getText()=="X") &&
                (board.buttonsGame[5].getText()=="X")){
            xWins(3,4,5, board);
        }
        else if( (board.buttonsGame[6].getText()=="X") &&
                (board.buttonsGame[7].getText()=="X") &&
                (board.buttonsGame[8].getText()=="X")){
            xWins(3,7,8, board);
        }
        else if( (board.buttonsGame[0].getText()=="X") &&
                (board.buttonsGame[3].getText()=="X") &&
                (board.buttonsGame[6].getText()=="X")){
            xWins(0,3,6, board);
        }
        else if( (board.buttonsGame[1].getText()=="X") &&
                (board.buttonsGame[4].getText()=="X") &&
                (board.buttonsGame[7].getText()=="X")){
            xWins(1,4,7, board);
        }
        else if( (board.buttonsGame[2].getText()=="X") &&
                (board.buttonsGame[5].getText()=="X") &&
                (board.buttonsGame[8].getText()=="X")){
            xWins(2,5,8, board);
        }
        else if( (board.buttonsGame[0].getText()=="X") &&
                (board.buttonsGame[4].getText()=="X") &&
                (board.buttonsGame[8].getText()=="X")){
            xWins(0,4,8, board);
        }
        else if( (board.buttonsGame[2].getText()=="X") &&
                (board.buttonsGame[4].getText()=="X") &&
                (board.buttonsGame[6].getText()=="X")){
            xWins(2,4,6, board);
        }

        //check wins for O
        else if( (board.buttonsGame[0].getText()=="O") &&
                (board.buttonsGame[1].getText()=="O") &&
                (board.buttonsGame[2].getText()=="O")){
            oWins(0,1,2, board);
        }
        else if( (board.buttonsGame[3].getText()=="O") &&
                (board.buttonsGame[4].getText()=="O") &&
                (board.buttonsGame[5].getText()=="O")){
            oWins(3,4,5, board);
        }
        else if( (board.buttonsGame[6].getText()=="O") &&
                (board.buttonsGame[7].getText()=="O") &&
                (board.buttonsGame[8].getText()=="O")){
            oWins(3,7,8, board);
        }
        else if( (board.buttonsGame[0].getText()=="O") &&
                (board.buttonsGame[3].getText()=="O") &&
                (board.buttonsGame[6].getText()=="O")){
            oWins(0,3,6, board);
        }
        else if( (board.buttonsGame[1].getText()=="O") &&
                (board.buttonsGame[4].getText()=="O") &&
                (board.buttonsGame[7].getText()=="O")){
            oWins(1,4,7, board);
        }
        else if( (board.buttonsGame[2].getText()=="O") &&
                (board.buttonsGame[5].getText()=="O") &&
                (board.buttonsGame[8].getText()=="O")){
            oWins(2,5,8, board);
        }
        else if( (board.buttonsGame[0].getText()=="O") &&
                (board.buttonsGame[4].getText()=="O") &&
                (board.buttonsGame[8].getText()=="O")){
            oWins(0,4,8, board);
        }
        else if( (board.buttonsGame[2].getText()=="O") &&
                (board.buttonsGame[4].getText()=="O") &&
                (board.buttonsGame[6].getText()=="O")){
            oWins(2,4,6, board);
        }

        //check draw
        else if (    (board.buttonsGame[0].getText() == "" || board.buttonsGame[1].getText() == "" ||
                board.buttonsGame[2].getText() == "" || board.buttonsGame[3].getText() == "" ||
                board.buttonsGame[4].getText() == "" || board.buttonsGame[5].getText() == "" ||
                board.buttonsGame[6].getText() == "" || board.buttonsGame[7].getText() == "" ||
                board.buttonsGame[8].getText() == "") == false){
            board.textField.setText("Draw");
            for (int i = 0 ; i < 9 ; i++){
                board.buttonsGame[i].setEnabled(false);
            }
        }
    }
    
    public void xWins(int a, int b, int c, Board board) {
        board.buttonsGame[a].setBackground(Color.GREEN);
        board.buttonsGame[b].setBackground(Color.GREEN);
        board.buttonsGame[c].setBackground(Color.GREEN);

        for(int i = 0 ; i < 9 ; i++){
            board.buttonsGame[i].setEnabled(false);
        }
        board.textField.setText("Player wins");
    }

    public void oWins(int a, int b, int c, Board board) {
        board.buttonsGame[a].setBackground(Color.GREEN);
        board.buttonsGame[b].setBackground(Color.GREEN);
        board.buttonsGame[c].setBackground(Color.GREEN);

        for(int i = 0 ; i < 9 ; i++){
            board.buttonsGame[i].setEnabled(false);
        }
        board.textField.setText("CPU wins");
    }
}

package project3;

import java.awt.*;

public class CheckWinConditionsForTicTacToe {

    public void checkWinForBoard3X3(Board board) {
        try {
            for (int r = 0 ; r < 3 ; r++){
                for (int c = 0 ; c < 3 ; c++){
                    if (board.buttonsGame3x3[r][c].getText() == "") continue;
                    //VERSION 1.0
                    //horizontal win - ok
                    if (board.buttonsGame3x3[r][c].getText() == board.buttonsGame3x3[r][c+1].getText() &&
                            board.buttonsGame3x3[r][c+1].getText() == board.buttonsGame3x3[r][c+2].getText()){
                        checkWinnerPrintResult(board);
                        board.gameOver = true;
                        return;
                    }
                    //vertical win - not working
                    else if (board.buttonsGame3x3[r][c].getText() == board.buttonsGame3x3[r+1][c].getText() &&
                            board.buttonsGame3x3[r+1][c].getText() == board.buttonsGame3x3[r+2][c].getText()){
                        checkWinnerPrintResult(board);
                        board.gameOver = true;
                        return;
                    }
                    //diagonal win -> "\" - ok
                    else if (board.buttonsGame3x3[r][c].getText() == board.buttonsGame3x3[r+1][c+1].getText() &&
                            board.buttonsGame3x3[r+1][c+1].getText() == board.buttonsGame3x3[r+2][c+2].getText()){
                        checkWinnerPrintResult(board);
                        board.gameOver = true;
                        return;
                    }
                    //Draw
                    else if (board.turn == 8){
                        checkForDraw(board);
                        board.gameOver = true;
                    }
                }
                System.out.println();
            }
        } catch (ArrayIndexOutOfBoundsException a){}
    }

    public void checkWinForBoard10x10(Board board)  {
        try {
            for (int r = 0 ; r < 10 ; r++){
                for (int c = 0 ; c < 10 ; c++){
                    if (board.buttonsGame10x10[r][c].getText() == "") continue;
                    //horizontal win
                    if ((board.buttonsGame10x10[r][c].getText() == board.buttonsGame10x10[r][c+1].getText() &&
                            board.buttonsGame10x10[r][c+1].getText() == board.buttonsGame10x10[r][c+2].getText() &&
                            board.buttonsGame10x10[r][c+2].getText() == board.buttonsGame10x10[r][c+3].getText() &&
                            board.buttonsGame10x10[r][c+3].getText() == board.buttonsGame10x10[r][c+4].getText()) &&
                            (!board.buttonsGame10x10[r][c].isEnabled()  &&
                            !board.buttonsGame10x10[r][c+1].isEnabled()  &&
                            !board.buttonsGame10x10[r][c+2].isEnabled()  &&
                            !board.buttonsGame10x10[r][c+3].isEnabled()  &&
                            !board.buttonsGame10x10[r][c+4].isEnabled())){
                        checkWinnerPrintResult(board);
                        board.gameOver = true;
                        return;
                    }
                    //vertical win
                    else if ((board.buttonsGame10x10[r][c].getText() == board.buttonsGame10x10[r+1][c].getText() &&
                            board.buttonsGame10x10[r+1][c].getText() == board.buttonsGame10x10[r+2][c].getText() &&
                            board.buttonsGame10x10[r+2][c].getText() == board.buttonsGame10x10[r+3][c].getText() &&
                            board.buttonsGame10x10[r+3][c].getText() == board.buttonsGame10x10[r+4][c].getText()) &&
                            (!board.buttonsGame10x10[r][c].isEnabled() &&
                            !board.buttonsGame10x10[r+1][c].isEnabled() &&
                            !board.buttonsGame10x10[r+2][c].isEnabled() &&
                            !board.buttonsGame10x10[r+3][c].isEnabled() &&
                            !board.buttonsGame10x10[r+4][c].isEnabled())){
                        checkWinnerPrintResult(board);
                        board.gameOver = true;
                        return;
                    }
                    //diagonal win -> "\"
                    else if ((board.buttonsGame10x10[r][c].getText() == board.buttonsGame10x10[r+1][c+1].getText() &&
                            board.buttonsGame10x10[r+1][c+1].getText() == board.buttonsGame10x10[r+2][c+2].getText() &&
                            board.buttonsGame10x10[r+2][c+2].getText() == board.buttonsGame10x10[r+3][c+3].getText() &&
                            board.buttonsGame10x10[r+3][c+3].getText() == board.buttonsGame10x10[r+4][c+4].getText()) &&
                            (!board.buttonsGame10x10[r][c].isEnabled() &&
                            !board.buttonsGame10x10[r+1][c+1].isEnabled() &&
                            !board.buttonsGame10x10[r+2][c+2].isEnabled() &&
                            !board.buttonsGame10x10[r+3][c+3].isEnabled() &&
                            !board.buttonsGame10x10[r+4][c+4].isEnabled())){
                        checkWinnerPrintResult(board);
                        board.gameOver = true;
                        return;
                    }
                    //diagonal win -> "/"
//                  else if ((board.buttonsGame10x10[r][c+4].getText() == board.buttonsGame10x10[r+1][c+3].getText() &&
//                            board.buttonsGame10x10[r+1][c+3].getText() == board.buttonsGame10x10[r+2][c+2].getText() &&
//                            board.buttonsGame10x10[r+2][c+2].getText() == board.buttonsGame10x10[r+3][c+1].getText() &&
//                            board.buttonsGame10x10[r+3][c+1].getText() == board.buttonsGame10x10[r+4][c].getText()) &&
//                            (board.buttonsGame10x10[r][c+4].isEnabled() == false &&
//                            board.buttonsGame10x10[r+1][c+3].isEnabled() == false &&
//                            board.buttonsGame10x10[r+2][c+2].isEnabled() == false &&
//                            board.buttonsGame10x10[r+3][c+1].isEnabled() == false &&
//                            board.buttonsGame10x10[r+4][c].isEnabled() == false)){
//                        checkWinnerPrintResult(board);
//                        board.gameOver = true;
//                        return;
                    //Draw
                    if (board.turn == 99){
                        checkForDraw(board);
                        board.gameOver = true;
                    }
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException a){}

    }
    
    public void checkWinnerPrintResult(Board board) {
        board.title_panel.setForeground(Color.BLACK); //dont work because all buttons are disabled
        board.title_panel.setBackground(Color.GREEN); //dont work because all buttons are disabled

        if (!board.player1_turn){
            board.textField.setText("Player win! ~ Well played");
        } else {
            board.textField.setText("CPU win! ~ You lose");
        }
    }

    public void checkForDraw (Board board){
        board.title_panel.setForeground(Color.BLACK);
        board.title_panel.setBackground(Color.GREEN);
        board.textField.setText("Draw");
    }

}

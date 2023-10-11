package project4_final;

import java.awt.*;

public class CheckWinConditionsForTicTacToe {
    public void checkWinForBoard3X3(Board board) {
        try {
            for (int r = 0 ; r < 3 ; r++){
                    //check if the board is filled and print correctly
                    System.out.print(board.buttonsGame3x3[0][0].getText());
                    System.out.print(board.buttonsGame3x3[0][1].getText());
                    System.out.println(board.buttonsGame3x3[0][2].getText());
                    System.out.print(board.buttonsGame3x3[1][0].getText());
                    System.out.print(board.buttonsGame3x3[1][1].getText());
                    System.out.println(board.buttonsGame3x3[1][2].getText());
                    System.out.print(board.buttonsGame3x3[2][0].getText());
                    System.out.print(board.buttonsGame3x3[2][1].getText());
                    System.out.println(board.buttonsGame3x3[2][2].getText());
                    if (board.buttonsGame3x3[r][r].getText() == ".") continue;
                    //VERSION 1.0
                    //horizontal win -
                    if ((board.buttonsGame3x3[r][0].getText() == board.buttonsGame3x3[r][1].getText() &&
                            board.buttonsGame3x3[r][1].getText() == board.buttonsGame3x3[r][2].getText()) &&
                            (board.buttonsGame3x3[r][0].getText() == "X" &&
                            board.buttonsGame3x3[r][1].getText() == "X" &&
                            board.buttonsGame3x3[r][2].getText() == "X") ||
                            (board.buttonsGame3x3[r][0].getText() == "O" &&
                            board.buttonsGame3x3[r][1].getText() == "O" &&
                            board.buttonsGame3x3[r][2].getText() == "O")
                                    ){
                        checkWinnerPrintResult(board);
                        board.gameOver = true;
                        return;
                    }
                    //vertical win - not working
                    else if (board.buttonsGame3x3[0][r].getText() == board.buttonsGame3x3[1][r].getText() &&
                            board.buttonsGame3x3[1][r].getText() == board.buttonsGame3x3[2][r].getText() &&
                            (board.buttonsGame3x3[0][r].getText() == "X" &&
                            board.buttonsGame3x3[1][r].getText() == "X" &&
                            board.buttonsGame3x3[2][r].getText() == "X") ||
                            (board.buttonsGame3x3[0][r].getText() == "O" &&
                            board.buttonsGame3x3[1][r].getText() == "O" &&
                            board.buttonsGame3x3[2][r].getText() == "O")
                    ){
                        checkWinnerPrintResult(board);
                        board.gameOver = true;
                        return;
                    }
                    //diagonal win -> "\" - ok
                    else if (board.buttonsGame3x3[0][0].getText() == board.buttonsGame3x3[1][1].getText() &&
                            board.buttonsGame3x3[1][1].getText() == board.buttonsGame3x3[2][2].getText() &&
                            (board.buttonsGame3x3[0][0].getText() == "X" &&
                            board.buttonsGame3x3[1][1].getText() == "X" &&
                            board.buttonsGame3x3[2][2].getText() == "X") ||
                            (board.buttonsGame3x3[0][0].getText() == "O" &&
                            board.buttonsGame3x3[1][1].getText() == "O" &&
                            board.buttonsGame3x3[2][2].getText() == "O")){
                        checkWinnerPrintResult(board);
                        board.gameOver = true;
                        return;
                    }
                    //diagonal win -> "/" - ok
                    else if (board.buttonsGame3x3[2][0].getText() == board.buttonsGame3x3[1][1].getText() &&
                            board.buttonsGame3x3[1][1].getText() == board.buttonsGame3x3[0][2].getText() &&
                            (board.buttonsGame3x3[2][0].getText() == "X" &&
                            board.buttonsGame3x3[1][1].getText() == "X" &&
                            board.buttonsGame3x3[0][2].getText() == "X") ||
                            (board.buttonsGame3x3[2][0].getText() == "O" &&
                            board.buttonsGame3x3[1][1].getText() == "O" &&
                            board.buttonsGame3x3[0][2].getText() == "O")){
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
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){}
    }
    public void checkWinForBoard10x10(Board board) {
        try {
           //horizontal win
           String tempArrayButtonsGame10x10;
           for (int r = 0 ; r < 10 ; r++) {
                for (int c = 0 ; c < 6 ; c++){
                    tempArrayButtonsGame10x10 = board.buttonsGame10x10[r][c].getText();
                    if (tempArrayButtonsGame10x10 == "") continue;
                    if ((tempArrayButtonsGame10x10 == board.buttonsGame10x10[r][c+1].getText() &&
                            tempArrayButtonsGame10x10 == board.buttonsGame10x10[r][c+2].getText() &&
                            tempArrayButtonsGame10x10 == board.buttonsGame10x10[r][c+3].getText() &&
                            tempArrayButtonsGame10x10 == board.buttonsGame10x10[r][c+4].getText()) &&
                            (!board.buttonsGame10x10[r][c].isEnabled()  &&
                                    !board.buttonsGame10x10[r][c+1].isEnabled()  &&
                                    !board.buttonsGame10x10[r][c+2].isEnabled()  &&
                                    !board.buttonsGame10x10[r][c+3].isEnabled()  &&
                                    !board.buttonsGame10x10[r][c+4].isEnabled())){
                        board.buttonsGame10x10[r][c].isEnabled();
                        board.buttonsGame10x10[r][c].setBackground(Color.GREEN);
                        board.buttonsGame10x10[r][c+1].isEnabled();
                        board.buttonsGame10x10[r][c+1].setBackground(Color.GREEN);
                        board.buttonsGame10x10[r][c+2].isEnabled();
                        board.buttonsGame10x10[r][c+2].setBackground(Color.GREEN);
                        board.buttonsGame10x10[r][c+3].isEnabled();
                        board.buttonsGame10x10[r][c+3].setBackground(Color.GREEN);
                        board.buttonsGame10x10[r][c+4].isEnabled();
                        board.buttonsGame10x10[r][c+4].setBackground(Color.GREEN);
                        checkWinnerPrintResult(board);
                        board.gameOver = true;
                        return;
                    }
                }
           }
           //vertical win
           for (int r = 0 ; r < 6 ; r++) {
                for (int c = 0; c < 10; c++) {
                    tempArrayButtonsGame10x10 = board.buttonsGame10x10[r][c].getText();
                    if (tempArrayButtonsGame10x10 == "") continue;
                    if ((tempArrayButtonsGame10x10 == board.buttonsGame10x10[r+1][c].getText() &&
                            tempArrayButtonsGame10x10 == board.buttonsGame10x10[r+2][c].getText() &&
                            tempArrayButtonsGame10x10 == board.buttonsGame10x10[r+3][c].getText() &&
                            tempArrayButtonsGame10x10 == board.buttonsGame10x10[r+4][c].getText()) &&
                        (!board.buttonsGame10x10[r][c].isEnabled() &&
                            !board.buttonsGame10x10[r+1][c].isEnabled() &&
                            !board.buttonsGame10x10[r+2][c].isEnabled() &&
                            !board.buttonsGame10x10[r+3][c].isEnabled() &&
                            !board.buttonsGame10x10[r+4][c].isEnabled())){
                        board.buttonsGame10x10[r][c].isEnabled();
                        board.buttonsGame10x10[r][c].setBackground(Color.GREEN);
                        board.buttonsGame10x10[r+1][c].isEnabled();
                        board.buttonsGame10x10[r+1][c].setBackground(Color.GREEN);
                        board.buttonsGame10x10[r+2][c].isEnabled();
                        board.buttonsGame10x10[r+2][c].setBackground(Color.GREEN);
                        board.buttonsGame10x10[r+3][c].isEnabled();
                        board.buttonsGame10x10[r+3][c].setBackground(Color.GREEN);
                        board.buttonsGame10x10[r+4][c].isEnabled();
                        board.buttonsGame10x10[r+4][c].setBackground(Color.GREEN);
                        checkWinnerPrintResult(board);
                        board.gameOver = true;
                        return;
                    }
                }
           }
           //diagonal win -> "\"
           for (int r = 0 ; r < 6 ; r++) {
                for (int c = 0; c < 6; c++) {
                    tempArrayButtonsGame10x10 = board.buttonsGame10x10[r][c].getText();
                    if (tempArrayButtonsGame10x10 == "") continue;
                    if ((tempArrayButtonsGame10x10 == board.buttonsGame10x10[r+1][c+1].getText() &&
                            tempArrayButtonsGame10x10 == board.buttonsGame10x10[r+2][c+2].getText() &&
                            tempArrayButtonsGame10x10 == board.buttonsGame10x10[r+3][c+3].getText() &&
                            tempArrayButtonsGame10x10 == board.buttonsGame10x10[r+4][c+4].getText()) &&
                        (!board.buttonsGame10x10[r][c].isEnabled() &&
                            !board.buttonsGame10x10[r+1][c+1].isEnabled() &&
                            !board.buttonsGame10x10[r+2][c+2].isEnabled() &&
                            !board.buttonsGame10x10[r+3][c+3].isEnabled() &&
                            !board.buttonsGame10x10[r+4][c+4].isEnabled())){
                        board.buttonsGame10x10[r][c].isEnabled();
                        board.buttonsGame10x10[r][c].setBackground(Color.GREEN);
                        board.buttonsGame10x10[r+1][c+1].isEnabled();
                        board.buttonsGame10x10[r+1][c+1].setBackground(Color.GREEN);
                        board.buttonsGame10x10[r+2][c+2].isEnabled();
                        board.buttonsGame10x10[r+2][c+2].setBackground(Color.GREEN);
                        board.buttonsGame10x10[r+3][c+3].isEnabled();
                        board.buttonsGame10x10[r+3][c+3].setBackground(Color.GREEN);
                        board.buttonsGame10x10[r+4][c+4].isEnabled();
                        board.buttonsGame10x10[r+4][c+4].setBackground(Color.GREEN);
                        checkWinnerPrintResult(board);
                        board.gameOver = true;
                        return;
                    }
                }
           }
           //anti-diagonal win -> "/"
           for (int r = 9 ; r > 3  ; r--) {
                for (int c = 0; c < 6; c++) {
                    tempArrayButtonsGame10x10 = board.buttonsGame10x10[r][c].getText();
                    if (tempArrayButtonsGame10x10 == "") continue;
                    if ((tempArrayButtonsGame10x10 == board.buttonsGame10x10[r-1][c+1].getText() &&
                            tempArrayButtonsGame10x10 == board.buttonsGame10x10[r-2][c+2].getText() &&
                            tempArrayButtonsGame10x10 == board.buttonsGame10x10[r-3][c+3].getText() &&
                            tempArrayButtonsGame10x10 == board.buttonsGame10x10[r-4][c+4].getText()) &&
                        (!board.buttonsGame10x10[r][c].isEnabled() &&
                            !board.buttonsGame10x10[r-1][c+1].isEnabled() &&
                            !board.buttonsGame10x10[r-2][c+2].isEnabled() &&
                            !board.buttonsGame10x10[r-3][c+3].isEnabled() &&
                            !board.buttonsGame10x10[r-4][c+4].isEnabled())){
                        board.buttonsGame10x10[r][c].isEnabled();
                        board.buttonsGame10x10[r][c].setBackground(Color.GREEN);
                        board.buttonsGame10x10[r-1][c+1].isEnabled();
                        board.buttonsGame10x10[r-1][c+1].setBackground(Color.GREEN);
                        board.buttonsGame10x10[r-2][c+2].isEnabled();
                        board.buttonsGame10x10[r-2][c+2].setBackground(Color.GREEN);
                        board.buttonsGame10x10[r-3][c+3].isEnabled();
                        board.buttonsGame10x10[r-3][c+3].setBackground(Color.GREEN);
                        board.buttonsGame10x10[r-4][c+4].isEnabled();
                        board.buttonsGame10x10[r-4][c+4].setBackground(Color.GREEN);
                        checkWinnerPrintResult(board);
                        board.gameOver = true;
                        return;
                    }
                }
           }
           //Draw
           if (board.turn == 99){
                checkForDraw(board);
                board.gameOver = true;
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

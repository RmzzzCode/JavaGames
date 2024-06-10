import java.util.Scanner;

public class TicTacToe {
    // Игровое поле 3x3
    private static char[][] board = new char[3][3];
    // Текущий игрок ('X' или 'O')
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard(); // Инициализация игрового поля
        printBoard(); // Печать игрового поля
        while (true) {
            playerMove(); // Ход игрока
            printBoard(); // Печать игрового поля после хода
            if (checkWin()) { // Проверка победы
                System.out.println("Игрок " + currentPlayer + " победил!");
                break; // Завершение игры
            }
            if (isBoardFull()) { // Проверка на ничью
                System.out.println("Ничья!");
                break; // Завершение игры
            }
            switchPlayer(); // Смена игрока
        }
    }

    // Инициализация игрового поля символами '-'
    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Печать игрового поля
    private static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Обработка хода игрока
    private static void playerMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        while (true) {
            System.out.println("Игрок " + currentPlayer + ", введите строку (0-2) и столбец (0-2):");
            row = scanner.nextInt(); // Чтение строки
            col = scanner.nextInt(); // Чтение столбца
            // Проверка допустимости хода
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
                board[row][col] = currentPlayer; // Обновление поля
                break;
            } else {
                System.out.println("Этот ход недопустим. Попробуйте снова.");
            }
        }
    }

    // Проверка победы
    private static boolean checkWin() {
        // Проверка строк
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }
        // Проверка столбцов
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        // Проверка диагоналей
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }
        return false;
    }

    // Проверка заполненности поля
    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    // Смена текущего игрока
    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}

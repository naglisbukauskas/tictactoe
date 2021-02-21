import java.lang.NullPointerException

lateinit var gameState: GameState
lateinit var gameBoard: CharArray
var playerChar: Char = ' '
var computerChar: Char = ' '

fun main() {


    //initialize game state and game board
    gameState = GameState.GAME_STARTING
    gameBoard = charArrayOf(' ',' ',' ',' ',' ',' ',' ',' ',' ')

    println("Welcome to Naglis' Tic Tac Toe")

    var answer: String = ""

    while (answer == "") {
        println("Would like to be X or O?")
        answer = readLine().toString()
        if (answer == "X") {
            playerChar = 'X'
            computerChar = 'O'
        } else if (answer == "O") {
            playerChar = 'O'
            computerChar = 'X'
        } else {
            answer = ""
        }
    }


    printBoard()

    gameState = GameState.GAME_PLAYING

    //Primary Game Loop
    if(playerChar == 'X') {
        while (gameState == GameState.GAME_PLAYING) {

            var position: Int = -1

            while (position == -1) {
                print("Enter a position: ")
                val string1 = readLine() ?: ""
                val temp = string1.toIntOrNull() ?: -1
                if (temp in 1..9 && (gameBoard[temp - 1] == ' ')) {
                    position = temp
                }
            }

            gameBoard[position - 1] = 'X'
            updateBoard()

            if(gameState == GameState.GAME_PLAYING) {

                computerMove()
                updateBoard()
            }

        }
    } else if (playerChar == 'O') {
        while (gameState == GameState.GAME_PLAYING) {

            computerMove()
            updateBoard()

            var position: Int = -1

            while (position == -1) {
                print("Enter a position: ")
                val string1 = readLine() ?: ""
                val temp = string1.toIntOrNull() ?: -1
                if (temp in 1..9 && (gameBoard[temp - 1] == ' ')) {
                    position = temp
                }
            }

            gameBoard[position - 1] = 'O'
            updateBoard()

        }
    }


}

//Hyper-Advanced Tic Tac Toe AI
fun computerMove() {
    when {
        gameBoard[4] == ' ' -> {
            gameBoard[4] = computerChar
        }
        gameBoard[0] == ' ' -> {
            gameBoard[0] = computerChar
        }
        gameBoard[2] == ' ' -> {
            gameBoard[2] = computerChar
        }
        gameBoard[8] == ' ' -> {
            gameBoard[8] = computerChar
        }
        gameBoard[6] == ' ' -> {
            gameBoard[6] = computerChar
        }
        gameBoard[1] == ' ' -> {
            gameBoard[6] = computerChar
        }
        gameBoard[3] == ' ' -> {
            gameBoard[3] = computerChar
        }
        gameBoard[5] == ' ' -> {
            gameBoard[5] = computerChar
        }
        gameBoard[7] == ' ' -> {
            gameBoard[7] = computerChar
        }
    }
}

fun updateBoard() {
    printBoard()
    //check for win conditions
    if(gameBoard[0] == gameBoard[1] && gameBoard[1] == gameBoard[2] && (gameBoard[0] == 'X' || gameBoard[0] == 'O')) {
        if(gameBoard[0] == 'X') {
            println("X Wins!")
        } else {
            println("O Wins!")
        }
        gameState = GameState.GAME_ENDED
    } else if (gameBoard[3] == gameBoard[4] && gameBoard[4] == gameBoard[5] && (gameBoard[3] == 'X' || gameBoard[3] == 'O')) {
        if(gameBoard[3] == 'X') {
            println("X Wins!")
        } else {
            println("O Wins!")
        }
        gameState = GameState.GAME_ENDED
    } else if (gameBoard[6] == gameBoard[7] && gameBoard[7] == gameBoard[8] && (gameBoard[6] == 'X' || gameBoard[6] == 'O')) {
        if(gameBoard[6] == 'X') {
            println("X Wins!")
        } else {
            println("O Wins!")
        }
        gameState = GameState.GAME_ENDED
    } else if (gameBoard[0] == gameBoard[4] && gameBoard[4] == gameBoard[8] && (gameBoard[0] == 'X' || gameBoard[0] == 'O')) {
        if(gameBoard[0] == 'X') {
            println("X Wins!")
        } else {
            println("O Wins!")
        }
        gameState = GameState.GAME_ENDED
    } else if (gameBoard[2] == gameBoard[4] && gameBoard[4] == gameBoard[6] && (gameBoard[2] == 'X' || gameBoard[2] == 'O')) {
        if(gameBoard[2] == 'X') {
            println("X Wins!")
        } else {
            println("O Wins!")
        }
        gameState = GameState.GAME_ENDED
    } else if (gameBoard[0] == gameBoard[3] && gameBoard[3] == gameBoard[6] && (gameBoard[0] == 'X' || gameBoard[0] == 'O')) {
        if(gameBoard[0] == 'X') {
            println("X Wins!")
        } else {
            println("O Wins!")
        }
        gameState = GameState.GAME_ENDED
    } else if (gameBoard[1] == gameBoard[4] && gameBoard[4] == gameBoard[7] && (gameBoard[1] == 'X' || gameBoard[1] == 'O')) {
        if(gameBoard[1] == 'X') {
            println("X Wins!")
        } else {
            println("O Wins!")
        }
        gameState = GameState.GAME_ENDED
    } else if (gameBoard[2] == gameBoard[5] && gameBoard[5] == gameBoard[8] && (gameBoard[2] == 'X' || gameBoard[2] == 'O')) {
        if(gameBoard[2] == 'X') {
            println("X Wins!")
        } else {
            println("O Wins!")
        }
        gameState = GameState.GAME_ENDED
    }
}

fun printBoard() {
    println("--------------")
    for(i in 1..9) {
        print("|")
        print(" ${gameBoard[i-1]} ")
        if ((i) % 3 == 0) {
            print("|")
            println()
            println("--------------")
        }
    }
    println()
}

enum class GameState {
    GAME_STARTING, GAME_PLAYING, GAME_ENDED
}
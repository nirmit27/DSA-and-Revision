""" Solution to the N-Queen problem using Backtracking """

config_count = 0


def print_board(board):
    global config_count
    config_count += 1
    print(f"CONFIGURATION #{config_count}\n")

    queen_count = 1
    for row in board:
        for i in range(len(row)):
            if row[i] == 1:
                print(f"Q{queen_count}\t", end="")
                queen_count += 1
            else:
                print(f"{row[i]}\t", end="")
        print()
    print()


def is_safe(row, col, board, columns):
    x, y = row, col

    # Checking along rows
    while y >= 0:
        if board[x][y] == 1:
            return False
        y -= 1

    # Refresh the values
    x, y = row, col

    # Checking for the upper-left diagonal
    while x >= 0 and y >= 0:
        if board[x][y] == 1:
            return False
        x -= 1
        y -= 1

    # Refresh the values
    x, y = row, col

    # Checking for the lower-left diagonal
    while x < columns and y >= 0:
        if board[x][y] == 1:
            return False
        x += 1
        y -= 1

    return True


def n_queens_util(col, board, columns):
    if col == n:
        print_board(board)
        return

    for row in range(n):
        if is_safe(row, col, board, columns):
            board[row][col] = 1
            n_queens_util(col + 1, board, n)
            board[row][col] = 0


def n_queens(queens):
    board = [[0] * n for _ in range(queens)]
    n_queens_util(0, board, queens)


if __name__ == "__main__":
    n = int(input("Enter the number of Queens: "))
    print(f"\nThe possible configurations for the {n}-Queen problem are:\n")

    n_queens(n)

    print(f"Total number of configurations = {config_count}")

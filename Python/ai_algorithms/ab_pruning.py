"""
--- Implementation of the Alpha-Beta Pruning algorithm ---
Detailed explanation : https://www.geeksforgeeks.org/minimax-algorithm-in-game-theory-set-4-alpha-beta-pruning/
"""

from math import log
from json import loads, JSONDecodeError


MAX, MIN = int(1e9), int(-1e9)  # Simulating the values of positive and negative infinity


def ab_pruning_demo(
    depth: int,
    node_index: int,
    is_maxi: bool,
    scores: list[int],
    height: int,
    alpha: float,
    beta: float,
) -> int:
    if depth == height:
        return scores[node_index]

    if is_maxi:
        best = MIN  # Case : MAXIMIZER

        for i in range(2):
            child_value = ab_pruning_demo(
                depth + 1, node_index * 2 + i, False, scores, height, alpha, beta
            )

            best = max(best, child_value)
            alpha = max(alpha, best)

            if alpha >= beta:  # PRUNING condition
                break

        return best

    best = MAX  # Case : MINIMIZER

    for i in range(2):
        child_value = ab_pruning_demo(
            depth + 1, node_index * 2 + i, True, scores, height, alpha, beta
        )

        best = min(best, child_value)
        beta = min(beta, best)

        if alpha >= beta:  # PRUNING condition
            break

    return best


def read_input() -> list[int]:
    user_input: str = ""
    input_scores: list[int] = []

    print(__doc__)

    try:
        user_input = input("Enter the scores : ")
        input_scores = loads(user_input)

        if not isinstance(input_scores, list) or not all(
            isinstance(i, int) for i in input_scores
        ):
            raise ValueError("Input must be a list of integers.")

    except (JSONDecodeError, ValueError):
        print(
            f"\nError : Invalid input. Please enter a valid list of integers in this format : {[i for i in range(1, 6)]}\n"
        )
        exit(1)

    return input_scores


def find_optimal_value(scores: list[int]) -> int:
    height: int = round(log(len(scores), 2))

    # Start as the MAXIMIZER
    optimal_value: int = ab_pruning_demo(0, 0, True, scores, height, MIN, MAX)

    return optimal_value


def main() -> None:
    sample_scores: list[int] = read_input() or []  # [3, 5, 6, 9, 1, 2, 0, -1]
    print(f"\nOptimal value : {find_optimal_value(sample_scores)}\n")  # 5


if __name__ == "__main__":
    main()

"""
--- Implementation of the Min-Max algorithm ---
Detailed explanation : https://www.geeksforgeeks.org/minimax-algorithm-in-game-theory-set-1-introduction/
"""

from math import log
from json import loads, JSONDecodeError


def mini_max_demo(
    depth: int, node_index: int, is_maxi: bool, scores: list[int], height: int
) -> int:
    if depth == height:
        return scores[node_index]

    if is_maxi:
        return max(
            mini_max_demo(depth + 1, node_index * 2, False, scores, height),
            mini_max_demo(depth + 1, node_index * 2 + 1, False, scores, height),
        )
    return min(
        mini_max_demo(depth + 1, node_index * 2, True, scores, height),
        mini_max_demo(depth + 1, node_index * 2 + 1, True, scores, height),
    )


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

    # Start as the MINIMIZER
    optimal_value: int = mini_max_demo(0, 0, False, scores, height)

    return optimal_value


def main() -> None:
    sample_scores: list[int] = read_input() or []  # [3, 5, 2, 9, 12, 5, 23, 23]
    print(f"\nOptimal value : {find_optimal_value(sample_scores)}\n")  # 3


if __name__ == "__main__":
    main()

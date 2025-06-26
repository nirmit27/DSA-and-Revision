"""
Unit Tests
"""

import unittest
from administratum.mini_max import find_optimal_value as minimax
from administratum.ab_pruning import find_optimal_value as alphabeta


class TestAIAlgorithms(unittest.TestCase):
    def test_mini_max(self):
        """For testing the Mini-Max algorithm implementation."""
        scores = [3, 5, 2, 9, 12, 5, 23, 23]
        expected = 3

        result = minimax(scores)
        self.assertEqual(result, expected, f"Expected {expected}, but got {result}.")

    def test_alpha_beta_pruning(self):
        """For testing the Alpha-Beta Pruning algorithm implementation."""
        scores = [3, 5, 6, 9, 1, 2, 0, -1]
        expected = 5

        result = alphabeta(scores)
        self.assertEqual(result, expected, f"Expected {expected}, but got {result}.")


if __name__ == "__main__":
    unittest.main()

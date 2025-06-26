"""Solution to the Travelling Salesman Problem using Dynamic Programming"""

import sys


def tsp(mask, pos, dist, memo, cities, all_visited):
    if mask == all_visited:
        return dist[pos][0]

    if memo[pos][mask] != -1:
        return memo[pos][mask]

    ans = sys.maxsize

    for city in range(cities):
        if (mask & (1 << city)) == 0:
            new_ans = dist[pos][city] + tsp(
                (mask | (1 << city)), city, dist, dp, n, all_visited
            )
            ans = min(ans, new_ans)

    memo[pos][mask] = ans
    return ans


if __name__ == "__main__":
    n = int(input("Enter the number of cities/nodes: "))

    adj_matrix = []
    for _ in range(n):
        row = list(map(int, input(f"Enter row #{_ + 1}: ").split()))
        adj_matrix.append(row)

    visited_all = (1 << n) - 1
    dp = [[-1 for _ in range(1 << n)] for _ in range(n)]

    print(
        "\nCost of the MOST efficient tour:", tsp(1, 0, adj_matrix, dp, n, visited_all)
    )

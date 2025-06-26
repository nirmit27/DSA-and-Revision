"""Implementation of the Knapsack Problem - Greedy Solution"""


class Item:
    """Representing each item in the Knapsack"""

    def __init__(self, profit, weight):
        self.profit = profit
        self.weight = weight

    def __repr__(self) -> str:
        return f"( Profit : {self.profit}, Weight: {self.weight} )"


def fractional_knapsack(capacity, array):
    finalvalue = 0.0

    # Step 1 : Sorting items on the basis of Profit/Weight ratio in REVERSE order.
    array.sort(key=lambda x: (x.profit / x.weight), reverse=True)

    # Step 2 : Iterating through the array of items.
    for item in array:

        # if item.weight doesn't overflow ...
        if item.weight <= capacity:
            capacity -= item.weight
            finalvalue += item.profit

        # if item.weight does overflow ...
        else:
            finalvalue += item.profit * (capacity / item.weight)
            break

    return finalvalue


if __name__ == "__main__":
    arr = []

    w = int(input("Enter the Knapsack capacity (in kg): "))

    for _ in range(n := int(input("Enter the number of items : "))):
        (pt, wt) = list(map(int, input("Enter the profit and weight : ").split()))
        arr.append(Item(pt, wt))

    print(f"\nFinal profit : {round(fractional_knapsack(w, arr), 2)}")

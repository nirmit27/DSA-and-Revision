"""Combinatorics ... stuff"""

from pprint import pprint


class PnC:
    """Combinatorics"""

    def __init__(self):
        # Counters for ... 'counting', ofc
        self.pc = 0
        self.cc = 0

    def permutations(self, arr: list[int], r: int) -> list[list[int]]:
        """Computes all the possible permutations of a given list of integers."""
        if r > len(arr):
            r = len(arr)  # Capping

        print(f"\nnPr({arr}) (r = {r})\n")
        perms: list[list[int]] = []

        def permute(temp: list[int], viz: list[bool]) -> None:
            """Backtracking function for finding the permutations."""
            if len(temp) == r:
                perms.append(temp[:])
                self.pc += 1
                return

            for i in range(len(arr)):
                if not viz[i]:
                    temp.append(arr[i])
                    viz[i] = True

                    permute(temp, viz)

                    temp.pop()
                    viz[i] = False

        permute([], [False] * len(arr))
        pprint(perms)
        print(f"\nNumber of permutations = {self.pc}\n")

        return perms

    def combinations(self, arr: list[int], r: int) -> list[list[int]]:
        """Computes all the possible combinations of a given list of integers."""
        if r > len(arr):
            r = len(arr)  # Capping, again

        print(f"\nnCr({arr}) (r = {r})\n")
        combos: list[list[int]] = []

        def combo(idx: int, temp: list[int]) -> None:
            """Backtracking function for finding the combinations."""
            if len(temp) == r:
                combos.append(temp[:])
                self.cc += 1
                return

            for i in range(idx, len(arr)):
                temp.append(arr[i])
                combo(i + 1, temp)
                temp.pop()

        combo(0, [])
        pprint(combos)
        print(f"\nNumber of combinations = {self.cc}\n")

        return combos


def main() -> None:
    try:
        l: str = input("Enter the upper limit : ")
        if not l.isdigit() or l.startswith("-"):
            raise ValueError("The upper limit should be a positive integer.")

        r: str = input("Enter the number of choices : ")
        if not r.isdigit() or r.startswith("-"):
            raise ValueError("The number of choices should be a positive integer.")

    except ValueError as ve:
        print(f"\nError : {ve}\n")
        exit(1)

    sample: list[int] = [i for i in range(1, int(l) + 1)]
    pnc: PnC = PnC()

    # TODO: I am not quite sure what I am gonna do with these...
    res_p: list[list[int]] = pnc.permutations(sample, int(r))
    res_c: list[list[int]] = pnc.combinations(sample, int(r))


if __name__ == "__main__":
    # "Old habits ..."
    main()

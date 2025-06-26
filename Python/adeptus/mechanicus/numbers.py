"""Some FAQs related to numbers."""


def prime_factors(a: int) -> list[int]:
    """Returns an array of prime factors (if any) of a given integer."""
    if a <= 1:
        # Edge cases : Please make sure that your code addresses them.
        return []

    res: list[int] = []
    for i in range(2, a + 1):
        if a % i == 0:
            res.append(i)

        while a % i == 0:
            a //= i

    return res


def harshad_niven(a: int) -> bool:
    """Checks whether or not a given integer is a Harshad/Niven number or not."""
    s: int = sum([int(i) for i in str(a)])
    return True if a % s == 0 else False


def automorph(a: int) -> bool:
    """Checks whether or not a given integer is an Automorphic number or not."""
    if a <= 1:
        # Edge cases : Please make sure that your code addresses them.
        return True

    sq: int = a * a
    while a > 0:
        if a % 10 != sq % 10:
            return False

        a //= 10
        sq //= 10

    return True


def gcd(a: int, b: int) -> int:
    """Computes the GCD of two integers using a recursive implementation of the Euclidean algorithm."""
    return b if a == 0 else gcd(b % a, a)


def lcm(a: int, b: int) -> int:
    """Computes the LCM of two integers using a recursive implementation of the Euclidean algorithm."""
    return (a * b) // gcd(a, b)


def main() -> None:
    sample: list[int] = [20, 15, 25, 378, 379]

    print(f"GCD of {sample[0]} and {sample[1]} : {gcd(sample[0], sample[1])}")
    print(f"LCM of {sample[0]} and {sample[1]} : {lcm(sample[0], sample[1])}")

    print(
        f"\n{sample[2]} {"is" if automorph(sample[2]) else "is NOT"} an Automorphic number."
    )

    print(
        f"\n{sample[3]} {"is" if harshad_niven(sample[3]) else "is NOT"} a Harshad/Niven number."
    )
    print(
        f"{sample[4]} {"is" if harshad_niven(sample[4]) else "is NOT"} a Harshad/Niven number."
    )

    print(f"\nPrime factors of {1} are : {prime_factors(1)}")


if __name__ == "__main__":
    main()

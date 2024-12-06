""" Understanding the intuition behind Chi-Square Test of Association """

import pandas as pd
from scipy.stats import chi2_contingency as chi2_test

# High Association
features_1: list[str] = [
    "cat",
    "cat",
    "cat",
    "cat",
    "mouse",
    "mouse",
    "mouse",
    "dog",
    "dog",
    "dog",
    "dog",
]

target_1: list[str] = ["c1", "c1", "c1", "c1", "c2", "c2", "c2", "c3", "c3", "c3", "c3"]

# Low Association
features_2: list[str] = [
    "cat",
    "cat",
    "cat",
    "cat",
    "mouse",
    "mouse",
    "mouse",
    "dog",
    "dog",
    "dog",
    "dog",
]

target_2: list[str] = ["c1", "c2", "c3", "c1", "c2", "c3", "c1", "c1", "c1", "c1", "c1"]


def find_f_score(features: list[str], target: list[str]) -> None:
    df: pd.DataFrame = pd.DataFrame({"features": features, "categories": target})

    chi2, pval, _, _ = chi2_test(pd.crosstab(df["features"], df["categories"]))

    (
        print(f"\nP-value for High association data : {pval}")
        if pval <= 0.05  # type: ignore
        else print(f"\nP-value for Low association data : {pval}")
    )


if __name__ == "__main__":
    find_f_score(features_1, target_1)
    find_f_score(features_2, target_2)

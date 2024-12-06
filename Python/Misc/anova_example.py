""" Understanding the intuition behind ANOVA to determine association between numerical features and a categorical target """

from scipy.stats import f_oneway as anova

# Strong Association
features_1: list[int] = [10, 10, 10, 10, 10, 20, 20, 20, 30, 30, 30]

target_1: list[str] = ["c1", "c1", "c1", "c1", "c2", "c2", "c3", "c3", "c3", "c3", "c3"]

# Weak Association
features_2: list[int] = [20, 10, 20, 30, 20, 10, 20, 30, 20, 10, 20]

target_2: list[str] = ["c1", "c2", "c3", "c1", "c2", "c3", "c1", "c1", "c1", "c1", "c1"]


def find_f_score(features: list[int], target: list[str]) -> None:
    group_values: list[list[int]] = []
    group_targets: list[str] = list(set(target))

    for i in range(len(group_targets)):
        group_values.append(
            [
                feature
                for feature, group in zip(features, target)
                if group == group_targets[i]
            ]
        )

    f_score, p_value = anova(group_values[0], group_values[1], group_values[2])
    (
        print(f"\nFor STRONG association, p-value = {p_value}")
        if p_value <= 0.05
        else print(f"\nFor WEAK association, p-value = {p_value}")
    )


if __name__ == "__main__":
    find_f_score(features_1, target_1)
    find_f_score(features_2, target_2)

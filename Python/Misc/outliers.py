import numpy as np
import matplotlib.pyplot as plt


def box(arr):
    plt.figure(figsize=(8, 8))
    plt.boxplot(sample, vert=False)
    plt.title("Horizontal Box Plot")
    plt.xlabel("Sample Distribution")
    plt.show()


if __name__ == "__main__":
    sample = np.linspace(1, 10, num=10, endpoint=True)
    sample = np.append(sample, [23, -12])
    box(sample)

    q1 = np.percentile(sample, 25)
    q3 = np.percentile(sample, 75)

    iqr = q3 - q1

    lower_bound = q1 * (1.5) - iqr
    upper_bound = q3 * (1.5) + iqr

    outliers = []

    for point in sample:
        if point < lower_bound or point > upper_bound:
            outliers.append(point)

    print("Observed outliers in sample : ")
    for outlier in outliers:
        print(outlier)

    p10 = np.percentile(sample, 10)
    p90 = np.percentile(sample, 90)

    x = np.where(sample < p10, p10, sample)
    sample = np.where(x > p90, p90, x)

    box(sample)

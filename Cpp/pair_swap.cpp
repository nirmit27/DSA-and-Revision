// Program to swap the pair container values
#include <bits/stdc++.h>

std::pair<int, int> swap_fun(std::pair<int, int> sample)
{
    int c = sample.first;
    sample.first = sample.second;
    sample.second = c;
    return sample;
}

int main()
{
    std::pair<int, int> sample;
    std::cout << "Enter the pair values: ";
    std::cin >> sample.first >> sample.second;

    sample = swap_fun(sample);
    std::cout << "Values have been swapped." << std::endl;
    std::cout << sample.first << " " << sample.second << std::endl;

    return 0;
}
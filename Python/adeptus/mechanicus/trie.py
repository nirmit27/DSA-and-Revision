"""
[Leetcode] #208 Implement Trie (Prefix Tree)
Link: https://leetcode.com/problems/implement-trie-prefix-tree/
"""


class TrieNode:

    def __init__(self):
        self.children = [None] * 26
        self.eow = False


class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr: TrieNode = self.root

        for ch in word:
            idx: int = ord(ch) - ord("a")

            if curr.children[idx] is None:
                curr.children[idx] = TrieNode()  # type:ignore

            curr = curr.children[idx]  # type:ignore
        curr.eow = True

    def search(self, word: str) -> bool:
        curr: TrieNode = self.root

        for ch in word:
            idx: int = ord(ch) - ord("a")

            if curr.children[idx] is None:
                return False

            curr = curr.children[idx]  # type:ignore
        return curr.eow

    def startsWith(self, prefix: str) -> bool:
        curr: TrieNode = self.root

        for ch in prefix:
            idx: int = ord(ch) - ord("a")

            if curr.children[idx] is None:
                return False

            curr = curr.children[idx]  # type:ignore
        return True


if __name__ == "__main__":
    print("\n--- Trie Implementation ---\n")

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        if(words.length <= 1) return List.of();
        Trie root = new Trie();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            root.put(word).index = i;
        }
        List<List<Integer>> resultList = new ArrayList<>();
        for (int j = 0; j < words.length; j++) {
            String word = words[j];
            Trie trie = root;
            if (word.isEmpty()) {
                for (Integer integer : trie.collectPalindrome()) {
                    resultList.add(List.of(integer, j));
                    resultList.add(List.of(j, integer));
                }
            } else {
                // end with this word, find the peer
                for (int i = word.length() - 1; i >= 0; i--) {
                    trie = trie.children[word.charAt(i) - 'a'];
                    if (trie == null) {
                        break;
                    }
                    if (trie.index != null && trie.index != j && isPalindrome(word.substring(0, i))) {
                        // It's ok if the rest of this word, which would form the middle part of the palindrome, is also a palindrome
                        resultList.add(List.of(trie.index, j));
                    }
                }
                if (trie == null) continue;
                // The peers might be longer than this word. Then the rest part of the peer would make up the middle part, which should also be palindrome.
                for (Integer integer : trie.collectPalindrome()) {
                    resultList.add(List.of(integer, j));
                }
            }
        }
        return resultList;
    }

    private static boolean isPalindrome(String cArr) {
        int i = 0, j = cArr.length() - 1;
        while (i < j && cArr.charAt(i) == cArr.charAt(j)) {
            i++;
            j--;
        }
        return i >= j;
    }

    class Trie {
        private final Trie[] children = new Trie[26];
        Integer index;

        Trie put(String s) {
            return put(s, 0);
        }

        private Trie put(String s, int index) {
            if (index == s.length()) {
                return this;
            }
            Trie child = children[s.charAt(index) - 'a'];
            if (child == null) child = children[s.charAt(index) - 'a'] = new Trie();
            return child.put(s, index + 1);
        }

        List<Integer> collectPalindrome() {
            ArrayList<Integer> list = new ArrayList<>();
            collectPalindrome(new StringBuilder(), list);
            return list;
        }

        private void collectPalindrome(StringBuilder sb, List<Integer> list) {
            if (index != null && !sb.isEmpty()) {
                if (isPalindrome(sb.toString())) {
                    list.add(index);
                }
            }
            for (int i = 0; i < children.length; i++) {
                Trie child = children[i];
                if (child != null) {
                    sb.append((char) ('a' + i));
                    child.collectPalindrome(sb, list);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
}
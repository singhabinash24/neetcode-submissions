class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 1) {
            res.add(Arrays.asList(strs[0]));
            return res;
        }
        boolean[] grouped = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (!grouped[i]) {
                List<String> anagrams = new ArrayList<>();
                res.add(anagrams);
                anagrams.add(strs[i]);
                for (int j = i + 1; j < strs.length; j++) {
                    if (!grouped[j]) {
                        boolean isAnagram = isAnagram(strs[i], strs[j]);
                        if (isAnagram) {
                            anagrams.add(strs[j]);
                            grouped[j] = true;
                        }
                    }
                }
            }
        }
        return res;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        for (char c : t.toCharArray()) {
            count[c]--;
        }
        for (int n : count) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }
}

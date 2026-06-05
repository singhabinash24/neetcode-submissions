class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> store = new HashMap<>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String st = new String(ch);
            if (!store.containsKey(st)) {
                store.put(st, new ArrayList(List.of(str)));
            } else {
                store.get(st).add(str);
            }
        }
        return new ArrayList(store.values());
    }
}

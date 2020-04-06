/*

Reference: https://leetcode.com/problems/group-anagrams/

49. Group Anagrams

Given an array of strings, group anagrams together.

Example:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note:
    All inputs will be in lowercase.
    The order of your output does not matter.

*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        if(strs == null || strs.length < 1)
            return new ArrayList<List<String>>(map.values());
        
        for(int i=0; i<strs.length; i++) {
            char[] charArr = new char[26];
            for(char c: strs[i].toCharArray()) {
                charArr[c-'a']++;
            }
            String str = String.valueOf(charArr);
            //System.out.println(strs[i] + ":" + str);
            if(map.containsKey(str))
                map.get(str).add(strs[i]);
            else {
                List list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(str, list);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}

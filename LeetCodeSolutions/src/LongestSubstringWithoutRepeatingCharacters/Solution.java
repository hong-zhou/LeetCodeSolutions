

package LongestSubstringWithoutRepeatingCharacters;

/********************************************************
 * Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

Subscribe to see which companies asked this question
***********************************************************/



/*public class Solution {
public int lengthOfLongestSubstring(String s) {
    int n = s.length();
    int ans = 0;
    for (int i = 0; i < n; ++i)
        for (int j = i + 1; j <= n; ++j)
            if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
    return ans;
}

public boolean allUnique(String s, int start, int end) {
    Set<Character> set = new HashSet<>();
    for (int i = start; i < end; ++i) {
        Character ch = s.charAt(start);
        if (set.contains(ch)) return false;
        set.add(ch);
    }
    return true;
}
}*/


/*public class Solution {
public int lengthOfLongestSubstring(String s) {
    int n = s.length();
    Set<Character> set = new HashSet<>();
    int ans = 0, i = 0, j = 0;
    while (i < n && j < n){
        if (!set.contains(s.charAt(j))){
            set.add(s.charAt(j++));
            ans = Math.max(ans, j - i);
        }else{
            set.remove(s.charAt(i++));
        }
    }
    return ans;
}
}*/

/*public class Solution {
public int lengthOfLongestSubstring(String s) {
    int n = s.length(), ans = 0;
    Map<Character, Integer> map = new HashMap<>();
    
    for (int j = 0, i = 0; j < n; j++){
        if (map.containsKey(s.charAt(j))){
            i = Math.max(map.get(s.charAt(j)), i);
        }
        ans = Math.max(ans, j - i + 1);
        map.put(s.charAt(j), j + 1);
    }
    
    return ans;
}

}*/

public class Solution {
public int lengthOfLongestSubstring(String s) {
    int n = s.length(), ans = 0;
    int[] index = new int[128];
    
    for (int j = 0, i = 0; j < n; j++){
        i = Math.max(index[s.charAt(j)], i);
        ans = Math.max(ans, j - i + 1);
        index[s.charAt(j)] = j + 1;
    }
    
    return ans;
}
}

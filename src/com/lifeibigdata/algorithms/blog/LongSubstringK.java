package com.lifeibigdata.algorithms.blog;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lifei on 16/8/3.
 *
 */
public class LongSubstringK {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("eceba",3));
    }
    static int lengthOfLongestSubstringKDistinct(String s,int k){
        int maxLen = 0;
        int i,j = 0;
        Map<Character,Integer> map = new HashMap<>();
        char c;
        for (i = 0; i <s.length();i++){
            while (j < s.length()){
                c = s.charAt(j);
                if (map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                } else {
                    if (map.size() == k)
                        break;
                    map.put(c,1);
                }
            j++;
            }
            maxLen = Math.max(maxLen,j - i);
            c = s.charAt(i);
            if (map.containsKey(c)){
                int count = map.get(c);
                if (count > 1){
                    map.put(c,count -1);
                } else {
                    map.remove(c);
                }
            }
        }
        return maxLen;
    }
}

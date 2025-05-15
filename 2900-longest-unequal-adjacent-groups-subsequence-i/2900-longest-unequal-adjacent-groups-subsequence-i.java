class Solution {
    private void rec(int i,int prev,String[] words, int[] groups,List<String> ans)
    {
        if(i==words.length) return;
        if(prev != groups[i]) ans.add(words[i]);
        rec(i+1,groups[i],words,groups,ans);
        return;
    }
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        rec(0,-1,words,groups,ans);
        return ans;
    }
}
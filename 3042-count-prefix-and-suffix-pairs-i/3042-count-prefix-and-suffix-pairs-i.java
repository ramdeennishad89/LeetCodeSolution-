class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for(int i = 0; i < words.length; i++)
        {
            for(int j = i+1; j < words.length; j++)
            {
                if(words[j].indexOf(words[i]) == 0 && words[j].lastIndexOf(words[i]) == (words[j].length() - words[i].length()))
                {
                    count++;
                }
            }
        }
        return count;
    }
}
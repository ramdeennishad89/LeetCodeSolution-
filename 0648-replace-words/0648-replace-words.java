class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> roots = new HashSet<>();

        for(String root: dictionary){
            roots.add(root);
        }

        StringBuilder result = new StringBuilder();
        String [] words= sentence.split(" ");

        for(String word : words){
            String shortestRoot= word;
            for(int i=1; i<=word.length(); i++){
                String substring= word.substring(0,i);
            if(roots.contains(substring)){
                shortestRoot = substring;
                break;
            }
            }
            result.append(shortestRoot).append(" ");

        }
        return result.toString().trim();
    }

}
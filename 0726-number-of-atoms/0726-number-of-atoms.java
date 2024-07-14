class Solution {
    Map<String, Integer> res = new TreeMap<>();
    Stack<Integer> stack = new Stack<>();
    int multiplier = 1;
    
    public String countOfAtoms(String formula) {
        int end = formula.length() - 1, i = formula.length() - 1;
        
        while (i >= 0) {
            if (formula.charAt(i) == '(') {
                multiplier /= stack.pop();
                i--;
                continue;
            }
            
            end = i;
            int val = 1;
            
            if (Character.isDigit(formula.charAt(i))) {
                while (Character.isDigit(formula.charAt(i))) i--;
                val = Integer.parseInt(formula.substring(i+1, end+1));
            } 
            stack.push(val);
            multiplier *= val;
            
            end = i;
            if (Character.isLetter(formula.charAt(i))) {
                while(Character.isLowerCase(formula.charAt(i))) i--;
                updateMap(formula.substring(i, end+1));
            }
            i--;
        }
        
        StringBuilder rs = new StringBuilder();
        for (Map.Entry<String, Integer> entry : res.entrySet()) {
            rs.append(entry.getKey());
            if (entry.getValue() > 1) rs.append(entry.getValue());
        }
        return rs.toString();
    }
    
    private void updateMap(String key) {
        if (res.get(key) == null) {
            res.put(key, multiplier);
        } else {
            res.put(key, multiplier + res.get(key));
        }

        multiplier /= stack.pop();
    }
}
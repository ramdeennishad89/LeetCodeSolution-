class MyCalendarTwo {

    TreeMap<Integer, Integer> tree;
    public MyCalendarTwo() {
        tree = new TreeMap<>();
    }

    public boolean book(int start, int end) {

        tree.put(start, tree.getOrDefault(start, 0) + 1);
        tree.put(end, tree.getOrDefault(end, 0) - 1);
        int val = 0;
        boolean flag = true;
        for(int key : tree.keySet()){
            val += tree.get(key);
            if(val > 2){
                tree.put(start, tree.get(start) - 1);
                tree.put(end, tree.get(end) + 1);
                flag = false;
                break;
            }
        }
        if(flag == false){
            return false;
        }else{
            return true;
        }
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
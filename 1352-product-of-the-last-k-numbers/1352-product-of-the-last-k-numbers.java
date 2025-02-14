class ProductOfNumbers {
private List<Integer> prefixProducts;
    private int lastProduct;

    public ProductOfNumbers() {
        prefixProducts = new ArrayList<>();
        prefixProducts.add(1);
        lastProduct = 1;
    }

    public void add(int num) {
        if (num == 0) {
            prefixProducts = new ArrayList<>();
            prefixProducts.add(1);
            lastProduct = 1;
        } else {
            lastProduct *= num;
            prefixProducts.add(lastProduct);
        }
    }

    public int getProduct(int k) {
        int n = prefixProducts.size();
        if (k >= n) {
            return 0;
        }
        return lastProduct / prefixProducts.get(n - k - 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
class KthLargest {
    private PriorityQueue<Integer> store;
    private int k;


    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.store = new PriorityQueue<>();
        for (int n : nums) {
            store.offer(n);
            if (store.size() > k) {
                store.poll();
            }
        }
    }

    public int add(int val) {
        store.offer(val);
        if(store.size() > k) {
            store.poll();
        }
        return store.peek();
    }
}

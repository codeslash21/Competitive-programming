// https://leetcode.com/problems/stock-price-fluctuation/description/
// t.c.=O(nlogn), s.c.=O(n)
class StockPrice {
    Map<Integer, Integer> priceMap;
    TreeMap<Integer, Integer> priceCount;
    int latestTimestamp;
    public StockPrice() {
        priceMap=new HashMap<>();
        priceCount=new TreeMap<>();
        latestTimestamp=0;
    }
    
    public void update(int timestamp, int price) {
        // correcting an existing price
        if(priceMap.containsKey(timestamp)) {
            int oldPrice=priceMap.get(timestamp);
            priceCount.put(oldPrice, priceCount.get(oldPrice)-1);
            if(priceCount.get(oldPrice)==0)
                priceCount.remove(oldPrice);
        }
        priceMap.put(timestamp, price);
        priceCount.put(price, priceCount.getOrDefault(price, 0)+1);
        latestTimestamp=Math.max(latestTimestamp, timestamp);
    }
    
    public int current() {
        return priceMap.get(latestTimestamp);
    }
    
    public int maximum() {
        return priceCount.lastKey();
    }
    
    public int minimum() {
        return priceCount.firstKey();
    }
}

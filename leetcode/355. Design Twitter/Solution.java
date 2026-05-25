// https://leetcode.com/problems/design-twitter/description/
// using bruteforce
class Twitter {
    private Map<Integer, List<int[]>> tweets;
    private Map<Integer, Set<Integer>> followers;
    private int timestamp;
    public Twitter() {
        tweets=new HashMap<>();
        followers=new HashMap<>();
        timestamp=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k->new ArrayList<>()).add(new int[]{timestamp++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<int[]> allTweets=new ArrayList<>();
        List<Integer> feed=new ArrayList<>();
        allTweets.addAll(tweets.getOrDefault(userId, new ArrayList<>()));
        for(int followeeId:followers.getOrDefault(userId, new HashSet<>()))
            allTweets.addAll(tweets.getOrDefault(followeeId, new ArrayList<>()));
        allTweets.sort((a,b)->b[0]-a[0]);
        for(int i=0;i<Math.min(allTweets.size(), 10);i++)
            feed.add(allTweets.get(i)[1]);
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        followers.computeIfAbsent(followerId, k->new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees=followers.get(followerId);
        if(followees!=null) followees.remove(followeeId);
    }
}

// using max heap
class Twitter {
    private Map<Integer, List<int[]>> tweets;
    private Map<Integer, Set<Integer>> followers;
    private int timestamp;
    public Twitter() {
        tweets=new HashMap<>();
        followers=new HashMap<>();
        timestamp=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k->new ArrayList<>()).add(new int[]{timestamp++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed=new ArrayList<>();
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((a,b)->b[0]-a[0]);
        addMostRecentTweets(maxHeap, userId);   // add recent tweet of the user
        // add recent tweet from all its followees
        for(int followee:followers.getOrDefault(userId, new HashSet<>()))
            addMostRecentTweets(maxHeap, followee);
        // extract upto 10 recent tweets
        while(!maxHeap.isEmpty() && feed.size()<10) {
            int[] top=maxHeap.poll();
            feed.add(top[1]);   // add tweetId
            int nextIdx=top[3]-1;
            if(nextIdx>=0) {
                List<int[]> userTweets=tweets.get(top[2]);
                int[] nextTweet=userTweets.get(nextIdx);
                maxHeap.offer(new int[]{nextTweet[0], nextTweet[1], top[2], nextIdx});
            }
        }
        return feed;
    }
    private void addMostRecentTweets(PriorityQueue<int[]> maxHeap, int userId) {
        List<int[]> userTweets=tweets.get(userId);
        if(userTweets!=null && !userTweets.isEmpty()) {
            int latestTweetIdx=userTweets.size()-1;
            int[] latestTweet=userTweets.get(latestTweetIdx);
            maxHeap.offer(new int[]{latestTweet[0], latestTweet[1], userId, latestTweetIdx});
        }
    }
    
    public void follow(int followerId, int followeeId) {
        followers.computeIfAbsent(followerId, k->new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees=followers.get(followerId);
        if(followees!=null) followees.remove(followeeId);
    }
}

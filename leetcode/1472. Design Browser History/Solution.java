// https://leetcode.com/problems/design-browser-history/description/
class Node {
    String url;
    Node prev, next;
    Node(String url) {
        this.url=url;
    }
}
class BrowserHistory {
    Node historyStack, curr;
    public BrowserHistory(String homepage) {
        historyStack=new Node(homepage);
        curr=historyStack;
    }
    
    public void visit(String url) {
        Node nextPage=new Node(url);
        curr.next=nextPage;
        nextPage.prev=curr;
        curr=curr.next;
    }
    
    public String back(int steps) {
        while(steps-->0 && curr!=historyStack)
            curr=curr.prev;
        return curr.url;
    }
    
    public String forward(int steps) {
        while(steps-->0 && curr.next!=null)
            curr=curr.next;
        return curr.url;
    }
}

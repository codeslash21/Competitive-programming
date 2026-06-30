// https://leetcode.com/problems/accounts-merge/description/
// using DFS
// t.c.=O(NKlogNK), s.c.=O(NK), N=total number of accounts, K=max number of emails in an account
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> graph=new HashMap<>();
        Map<String, String> emailToName=new HashMap<>();
        Set<String> visited=new HashSet<>();
        List<List<String>> result=new ArrayList<>();
        // build the graph and emailToName map
        for(List<String> account:accounts) {
            String name=account.get(0), firstEmail=account.get(1);
            for(int i=1;i<account.size();i++) {
                String email=account.get(i);
                emailToName.put(email, name);
                graph.computeIfAbsent(firstEmail, k->new HashSet<>()).add(email);
                graph.computeIfAbsent(email, k->new HashSet<>()).add(firstEmail);
            }
        }
        for(String email:emailToName.keySet()) {
            if(visited.contains(email)) continue;
            List<String> component=new ArrayList<>();
            Deque<String> stack=new ArrayDeque<>();
            stack.push(email);
            while(!stack.isEmpty()) {
                String node=stack.pop();
                if(visited.contains(node))  continue;
                visited.add(node);
                component.add(node);
                for(String neighbor:graph.get(node))
                    if(!visited.contains(neighbor))
                        stack.push(neighbor);
            }
            Collections.sort(component);
            component.add(0, emailToName.get(email));
            result.add(component);
        }
        return result;
    }
}

// using Union Find
// t.c.=O(NKlogNK), s.c.=O(NK)
class Solution {
    private int[] parent, rank;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int nodes=accounts.size();
        parent=new int[nodes];
        rank=new int[nodes];
        for(int i=0;i<nodes;i++)    parent[i]=i;
        Map<String, Integer> emailToAccount=new HashMap<>();
        List<List<String>> result=new ArrayList<>();
        Map<Integer, List<String>> groups=new HashMap<>();
        for(int i=0;i<nodes;i++) {
            for(int j=1;j<accounts.get(i).size();j++) {
                String email=accounts.get(i).get(j);
                Integer owner=emailToAccount.get(email);
                if(owner==null)
                    emailToAccount.put(email, i);
                else
                    union(i, owner);
            }
        }
        for(Map.Entry<String, Integer> entry:emailToAccount.entrySet()) {
            int root=findParent(entry.getValue());
            groups.computeIfAbsent(root, k->new ArrayList<>()).add(entry.getKey());
        }
        for(Map.Entry<Integer, List<String>> entry:groups.entrySet()) {
            int accountId=entry.getKey();
            List<String> emails=entry.getValue();
            Collections.sort(emails);
            emails.add(0, accounts.get(accountId).get(0));
            result.add(emails);
        }
        return result;
    }
    private int findParent(int x) {
        if(parent[x]!=x)
            parent[x]=findParent(parent[x]);
        return parent[x];
    }
    private void union(int x, int y) {
        int rootX=findParent(x), rootY=findParent(y);
        if(rootX==rootY)    return;
        if(rank[rootX]<rank[rootY])
            parent[rootX]=rootY;
        else if(rank[rootX]>rank[rootY])
            parent[rootY]=rootX;
        else {
            parent[rootX]=rootY;
            rank[rootY]++;
        }
    }
}

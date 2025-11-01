// https://leetcode.com/problems/search-suggestions-system/description/
// using sorting + binary search
// t.c.=O((n+m)logn), s.c.=O(logn)
class Solution {
    public int findFirstProduct(String[] products, int start, String word) {
        int left=start, right=products.length;
        while(left<right) {
            int mid=left+(right-left)/2;
            if(products[mid].compareTo(word)>=0)
                right=mid;
            else
                left=mid+1;
        }
        return left;
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        int productLen=products.length, wordLen=searchWord.length(), start=0, bsStart=0;
        List<List<String>> res=new ArrayList<>();
        String prefix=new String();
        Arrays.sort(products);
        for(int i=0;i<wordLen;i++) {
            prefix+=searchWord.charAt(i);
            start=findFirstProduct(products, bsStart, prefix);
            res.add(new ArrayList<>());
            for(int j=start;j<Math.min(start+3, productLen);j++) {
                if(products[j].length()<prefix.length() || !products[j].substring(0, prefix.length()).equals(prefix))
                    break;
                res.get(res.size()-1).add(products[j]);
            }
            bsStart=start;
        }
        return res;
    }
}


// using sorting and linear scan
// t.c.=O(nlogn + n + m), s.c.=O(logn)
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        int productLen=products.length, wordLen=searchWord.length(), left=0, right=productLen-1;
        List<List<String>> res=new ArrayList<>();
        Arrays.sort(products);
        for(int i=0;i<wordLen;i++) {
            List<String> currMatch=new ArrayList<>();
            char charToMatch=searchWord.charAt(i);
            while(left<=right && (products[left].length()<=i || products[left].charAt(i)!=charToMatch))
                left++;
            while(left<=right && (products[right].length()<=i || products[right].charAt(i)!=charToMatch))
                right--;
            for(int j=left;j<Math.min(left+3, right+1);j++)
                currMatch.add(products[j]);
            res.add(currMatch);
        }
        return res;
    }
}

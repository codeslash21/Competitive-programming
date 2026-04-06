// https://leetcode.com/problems/encode-and-decode-tinyurl/description/
// using hashCode()
// t.c.=O(1), s.c.=O(n)
public class Codec {
    Map<Integer, String> codeToUrl=new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int key=longUrl.hashCode();
        while(codeToUrl.containsKey(key) && codeToUrl.get(key)!=longUrl)
            key++;
        codeToUrl.put(key, longUrl);
        return "http://tinyurl.com/"+key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int key=Integer.parseInt(shortUrl.replace("http://tinyurl.com/", ""));
        return codeToUrl.getOrDefault(key, null);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));

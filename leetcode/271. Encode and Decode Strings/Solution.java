// https://leetcode.com/problems/encode-and-decode-strings/description/
// using unicode char as delimeter
// t.c.=O(n), s.c.=O(n), n=total number of characters across all string
public class Codec {
    StringBuilder encodedString=new StringBuilder();
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        for(String str:strs) {
            encodedString.append(str);
            encodedString.append("π");
        }
        return encodedString.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String[] decodedStrings=s.split("π", -1);
        return new ArrayList<>(Arrays.asList(decodedStrings).subList(0, decodedStrings.length-1));
    }
}

// using escaping character
// t.c.=O(n), s.c.=O(n)
public class Codec {
    StringBuilder encodedString=new StringBuilder();
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        for(String str:strs) {
            encodedString.append(str.replace("/", "//")).append("/:");
        }
        return encodedString.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decodedStrings=new ArrayList<>();
        StringBuilder currentStr=new StringBuilder();
        int len=s.length();
        for(int i=0;i<len;i++) {
            if(i+1<len && s.charAt(i)=='/') {
                if(s.charAt(i+1)==':') {
                    decodedStrings.add(currentStr.toString());
                    currentStr=new StringBuilder();
                } else 
                    currentStr.append('/');
                i++;
            } else 
                currentStr.append(s.charAt(i));
        }
        return decodedStrings;
    }
}

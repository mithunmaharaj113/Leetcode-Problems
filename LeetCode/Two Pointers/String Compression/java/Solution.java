class Solution {
    public int compress(char[] c) {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < c.length; i++) {
            if (c[i - 1] == c[i]) {
                count++;
            } else {
                if (count == 1) {
                    sb.append(c[i - 1]);
                } else {
                    sb.append(c[i - 1]).append(count + "");
                    count = 1;
                }
            }
        }
        if(count == 1) sb.append(c[c.length-1]);
        else sb.append(c[c.length-1]).append(count);
        for(int i=0;i< sb.length();i++){
            c[i]=sb.charAt(i);
        }
        return sb.length();
    }
}
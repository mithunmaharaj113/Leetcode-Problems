class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> listexp=new ArrayList<>();
        evaluate(listexp,num,target,0,new StringBuilder(),0,0);
        return listexp;
    }
    void evaluate(List<String> listexp,String num,int target,int start,StringBuilder expression,long cal,long prev) {
        if(start==num.length()){
            if(cal==target) listexp.add(expression.toString());
            return;
        }
        for(int i=start;i<num.length();i++){
            if(i>start && num.charAt(start)=='0') break;
            long curr=Long.valueOf(num.substring(start,i+1));
            int len=expression.length();
            //firstDigit
            if(start==0) {
                expression.append(num.substring(start,i+1));
                evaluate(listexp,num,target,i+1,expression,cal+curr,curr);
                expression.setLength(len);
            }
            else {
                //'+'operator
                expression.append('+').append(num.substring(start,i+1));
                evaluate(listexp,num,target,i+1,expression,cal+curr,curr);
                expression.setLength(len);
                //'-'operator 
                expression.append('-').append(num.substring(start,i+1));
                evaluate(listexp,num,target,i+1,expression,cal-curr,-curr);
                expression.setLength(len);
                //'*'operator 
                expression.append('*').append(num.substring(start,i+1));
                evaluate(listexp,num,target,i+1,expression,cal-prev+prev*curr,prev*curr);
                expression.setLength(len);
            }
        }
    }
}
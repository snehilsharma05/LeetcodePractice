class Solution {
    //minimum partitions required = Maxnimum digit of this number n,
    //for 829--> use 111, remaining 718, use 111, remaining 607, use 101, remaning 506,...similarly we'll reach 000
    //min steps required are equal to converting max digit in n to 0
    public int minPartitions(String n) {
        int steps = 0;
        for(int i=0;i<n.length();i++){
            steps = Math.max(steps,n.charAt(i)-'0');
        }
        return steps;
    }
}
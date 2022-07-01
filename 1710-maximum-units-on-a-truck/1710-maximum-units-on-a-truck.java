class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(t1,t2)->-(t1[1] - t2[1]));
        
        int index = 0,n = boxTypes.length;
        int totalUnits = 0;
        
        while(index<n && truckSize>0){
            totalUnits += Math.min(truckSize,boxTypes[index][0])*boxTypes[index][1];
            truckSize -= Math.min(truckSize,boxTypes[index][0]);
            index++;
        }
        return totalUnits;
    }
}
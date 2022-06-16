class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int index = 1;
        int peakEle = arr[1];
        for(int i=1;i<arr.length-1;i++){
            if(arr[i]>peakEle){
                peakEle = arr[i];
                index = i;
            }
        }
        return index;
    }
}
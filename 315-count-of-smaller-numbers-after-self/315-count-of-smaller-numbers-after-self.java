class Solution {
    private class ArrayValWithOrigIdx{
        int val;
        int index;
        ArrayValWithOrigIdx(int val,int index){
            this.val = val;
            this.index = index;
        }
        
        public String toString(){
            return val+" "+index;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        ArrayValWithOrigIdx[] arr = new ArrayValWithOrigIdx[n];
        for(int i=0;i<n;i++){
            arr[i] = new ArrayValWithOrigIdx(nums[i],i);
        }
        // for(ArrayValWithOrigIdx a:arr){
        //     System.out.println(a);
        // }
        
        int[] res = new int[n];
        mergeSort(0,n-1,arr,res);
        
        List<Integer> ans = new ArrayList<>();
        for(int count: res){
            ans.add(count);
        }
        return ans;
    }
    
    private void mergeSort(int start,int end,ArrayValWithOrigIdx[] arr,int[] res){
        if(start<end){
            int mid = (start+end)>>1;
            mergeSort(start,mid,arr,res);
            mergeSort(mid+1,end,arr,res);
            merge(start,mid,end,arr,res);
        }
    }
    
    private void merge(int start,int mid,int end,ArrayValWithOrigIdx[] arr,int[] res){
        int leftPos = start,rightPos = mid+1, k = start;
        List<ArrayValWithOrigIdx> merged = new ArrayList<>();
        
        int numElemsRightArrayLessThanLeftArray = 0;
        // for(ArrayValWithOrigIdx a:arr){
        //     System.out.println("In merge method-->"+a +" Start Val-->"+start+" Mid Val-->"+mid+" End Val-->"+end);
        // }
        while(leftPos<=mid && rightPos<=end){
            if(arr[leftPos].val > arr[rightPos].val){//what ques is asking
                numElemsRightArrayLessThanLeftArray++;
                merged.add(arr[rightPos]);
                rightPos++;
            }else{
                res[arr[leftPos].index] += numElemsRightArrayLessThanLeftArray;
                merged.add(arr[leftPos]);
                leftPos++;
            }
        }
        
        while(leftPos<=mid){
            res[arr[leftPos].index] += numElemsRightArrayLessThanLeftArray;
            merged.add(arr[leftPos]);
            leftPos++;
        }
        
        while(rightPos<=end){
            merged.add(arr[rightPos]);
            k++;
            rightPos++;
        }
        
        //put back merged array into original array
        k = start;
        for(ArrayValWithOrigIdx m:merged){
            arr[k++] = m;
        }
    }
}
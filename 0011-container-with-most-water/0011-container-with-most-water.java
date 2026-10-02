class Solution {
    public int maxArea(int[] height) {
        
        int mw = Integer.MIN_VALUE;
        int i=0,j=height.length-1;
        while(i<j){
            int cw = (Math.min(height[i],height[j]))*(j-i);
            if(cw>mw){
                mw = cw;
            }

             if(height[i]<height[j]){
                    i++;
                }else{
                    j--;
                }
        }
        return mw;    
         }
    }

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        //Min of higher attribute, Max of lower attribute (Overlap size)
        int lenX = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int lenY = Math.min(ay2, by2) - Math.max(ay1, by1);
        int P_overlap=0;
        if(lenX>0 && lenY >0)   //Else: no overlap
            P_overlap=lenX*lenY;
        return (ax2-ax1)*(ay2-ay1) + (bx2-bx1)*(by2-by1) - P_overlap;
    }
}
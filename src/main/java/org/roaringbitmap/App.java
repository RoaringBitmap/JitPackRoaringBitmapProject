package org.roaringbitmap;

/**
 * Hello world!
 *
 */
import org.roaringbitmap.RoaringBitmap;
import org.roaringbitmap.bsi.RoaringBitmapSliceIndex;
public class App 
{
    public void setup() {
      RoaringBitmapSliceIndex bsi = new RoaringBitmapSliceIndex(1, 99);
    }
    public static void main(String[] args) {
        RoaringBitmap rr = RoaringBitmap.bitmapOf(1,2,3,1000);
        RoaringBitmap rr2 = new RoaringBitmap();
        rr2.add(4000L,4255L);

        RoaringBitmap rror = RoaringBitmap.or(rr, rr2);// new bitmap
        rr.or(rr2); //in-place computation
        boolean equals = rror.equals(rr);// true
        if(!equals) throw new RuntimeException("bug");
        // number of values stored?
        long cardinality = rr.getLongCardinality();
        System.out.println(cardinality);
        // a "forEach" is faster than this loop, but a loop is possible:
        for(int i : rr) {
          System.out.println(i);
        }
    }
}

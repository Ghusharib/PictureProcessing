package Filters;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Set;

public class PixelArtFilter {

  /* Takes an image and applies helper methods to pixelate the image */
  public static BufferedImage PixelArtFilter(BufferedImage img){
    int width = img.getWidth();
    int height = img.getHeight();
    int longestDim = Math.max(height, width);
    int sqrSize = longestDim / 100;
    for(int i = 0; i < width; i += sqrSize){
      for(int j = 0; j < height; j += sqrSize) {
        SquarePixelArtHelper(img, i, j, sqrSize);
      }
    }
    return img;
  }

  /* First helper method takes a square of pixels at a time based on a given square size
     and uses this to find the mode for a square of pixels. Uses this
     to edit the pixels and pixelate the image
   */
  private static void SquarePixelArtHelper(BufferedImage img, int x, int y, int sqrSize){
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    int value;
    for(int j = y; j < (y + sqrSize); j++){
      for(int i = x; i < (x + sqrSize); i++){
        if(Utils.isValidPixel(i, j, img.getWidth(), img.getHeight())){
          int RGB = img.getRGB(i, j);
          if(hashMap.containsKey(RGB)){
            value = hashMap.get(RGB);
            hashMap.put(RGB, value + 1);
          } else {
            hashMap.put(RGB, 1);
          }
        } else {
          break;
        }
      }
    }

    Set<Integer> keys = hashMap.keySet();
    //0xffffff is white
    int maxCount = 0, maxRGB = 0xffffff;
    for(Integer key : keys){
      if(hashMap.get(key) > maxCount) {
        maxCount = hashMap.get(key);
        maxRGB = key;
      }
    }

    for(int j = y; j < (y + sqrSize); j++){
      for(int i = x; i < (x + sqrSize); i++){
        if(Utils.isValidPixel(i, j, img.getWidth(), img.getHeight())){
          img.setRGB(i, j, maxRGB);
        } else {
          break;
        }
      }
    }

  }
}

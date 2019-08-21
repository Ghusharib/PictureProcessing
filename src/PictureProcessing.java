import Filters.*;

import java.awt.image.BufferedImage;

public class PictureProcessing {
  public static void main(String[] args) {

    BufferedImage img = OpenSaveImage.openImage(args[0]);
    img = ChangeBrightnessFilter.BrightnessFilter(img, 0.7);
    OpenSaveImage.SaveImage(img, args[1]);
  }
}
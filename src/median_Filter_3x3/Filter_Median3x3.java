package median_Filter_3x3;

import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Color;

import javax.imageio.ImageIO;

import java.util.Arrays;

public class Filter_Median3x3 {
	final static int K = 4;
	
	 public static void main(String[] a)throws Throwable{
		 File f=new File("blocks_color.jpg");   
		 File output=new File("output.jpg");
		 BufferedImage img=ImageIO.read(f);
		 int w = img.getWidth();
		 int h = img.getHeight();
		 
		 int[] P = new int[2*K+2];
		 
		 for (int v = 1; v<= h-2; v++) {
			 for(int u = 1; u <= w-2; u++) {
				 int k = 0;
				 for(int j = -1; j <= 1; j++) {
					 for(int i = -1; i <= 1; i++) {
						 P[k] = img.getRGB(u+i, v+j);
						 k++;
					 }
				 }
				 Arrays.sort(P);
				 img.setRGB(u, v, P[k]);
			 }
		 }
		 ImageIO.write(img,"jpg",output);
	 }
	 
}

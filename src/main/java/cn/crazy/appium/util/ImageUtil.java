package cn.crazy.appium.util;import javax.imageio.*;import java.awt.image.*;import java.awt.*;//Colorimport java.io.*;public class ImageUtil{    public static void main(String[] args)throws Exception{//        float percent = compare(getData("images/actImage2.png"),getData("images/actImageByDetail2.png"));//        System.out.println("相似度"+percent+"%");        System.out.println(System.getProperty("user.dir"));        System.out.println(compareImg("images/加载失败.png","images/hym.png"));    }    public static int[] getData(String name)throws Exception{        BufferedImage img = ImageIO.read(new File(name));        BufferedImage slt = new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);        slt.getGraphics().drawImage(img,0,0,100,100,null);                int[] data = new int[256];        for(int x = 0;x<slt.getWidth();x++){            for(int y = 0;y<slt.getHeight();y++){                int rgb = slt.getRGB(x,y);                Color myColor = new Color(rgb);                int r = myColor.getRed();                int g = myColor.getGreen();                int b = myColor.getBlue();                data[(r+g+b)/3]++;            }        }        return data;    }    public static float compare(int[] s,int[] t){        float result = 0F;        for(int i = 0;i<256;i++){            int abs = Math.abs(s[i]-t[i]);            int max = Math.max(s[i],t[i]);                        result += (1-((float)abs/(max==0?1:max)));                    }        System.out.println((result/256)*100);        return (result/256)*100;    }    public static boolean compareImg(String srcName,String desName) throws Exception{    	if(compare(getData(srcName), getData(desName))>87f){    		return true;    	}else{    		return false;    	}    }}
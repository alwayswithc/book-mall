package util;
import java.awt.Color;  
import java.awt.Font;  
import java.awt.Graphics2D;  
import java.awt.LinearGradientPaint;  
import java.awt.Paint;  
import java.awt.geom.AffineTransform;  
import java.awt.image.BufferedImage;  
import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.OutputStream;  
import java.util.Arrays;  
import java.util.Random;  
  
import javax.imageio.ImageIO;  
  
public class VerifyCodeUtils{  
    // ���Զ�����֤���ַ�Դ
    public static final String VERIFY_CODES = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";  
  
  
    /** 
     * ʹ��ϵͳĬ���ַ�Դ������֤�� 
     * @param verifySize ��֤�볤�� 
     * @return 
     */  
    public static String generateVerifyCode(int verifySize){  
        return generateVerifyCode(verifySize, VERIFY_CODES);  
    }  
    /** 
     * ʹ��ָ��Դ������֤�� 
     * @param verifySize ��֤�볤�� 
     * @param sources   ��֤���ַ�Դ 
     * @return 
     */  
    public static String generateVerifyCode(int verifySize, String sources){  
        if(sources == null || sources.length() == 0){  
            sources = VERIFY_CODES;  
        }  
        int codesLen = sources.length();  
        Random rand = new Random(System.currentTimeMillis());  
        StringBuilder verifyCode = new StringBuilder(verifySize);  
        for(int i = 0; i < verifySize; i++){  
            verifyCode.append(sources.charAt(rand.nextInt(codesLen-1)));  
        }  
        return verifyCode.toString();  
    }  
      
    /** 
     * ���������֤���ļ�,��������֤��ֵ 
     * @param w ͼƬ��(����)
     * @param h ͼƬ��(����)
     * @param outputFile 
     * @param verifySize 
     * @return 
     * @throws IOException 
     */  
    public static String outputVerifyImage(int w, int h, File outputFile, int verifySize) throws IOException{  
        String verifyCode = generateVerifyCode(verifySize);  
        outputImage(w, h, outputFile, verifyCode);  
        return verifyCode;  
    }  
      
    /** 
     * ��������֤��ͼƬ��,��������֤��ֵ 
     * @param w 
     * @param h 
     * @param os 
     * @param verifySize 
     * @return 
     * @throws IOException 
     */  
    public static String outputVerifyImage(int w, int h, OutputStream os, int verifySize) throws IOException{  
        String verifyCode = generateVerifyCode(verifySize);  
        outputImage(w, h, os, verifyCode);  
        return verifyCode;  
    }  
      
    /** 
     * ����ָ����֤��ͼ���ļ� 
     * @param w 
     * @param h 
     * @param outputFile 
     * @param code 
     * @throws IOException 
     */  
    public static void outputImage(int w, int h, File outputFile, String code) throws IOException{  
        if(outputFile == null){  
            return;  
        }  
        File dir = outputFile.getParentFile();  
        if(!dir.exists()){  
            dir.mkdirs();  
        }  
        try{  
            outputFile.createNewFile();  
            FileOutputStream fos = new FileOutputStream(outputFile);  
            outputImage(w, h, fos, code);  
            fos.close();  
        } catch(IOException e){  
            throw e;  
        }  
    }  
      
    /** 
     * ���ָ����֤��ͼƬ�� 
     * @param w 
     * @param h 
     * @param os 
     * @param code 
     * @throws IOException 
     */  
    public static void outputImage(int w,  
                            int h,  
                            OutputStream os,  
                            String code) throws IOException{  
        int verifySize = code.length();  
        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);  
        Random rand = new Random();  
        Graphics2D g2 = image.createGraphics();  
        Color[] colors = new Color[5];  
        Color[] colorSpaces = new Color[] { Color.WHITE, Color.CYAN,  
                Color.GRAY, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,  
                Color.PINK, Color.YELLOW };  
        float[] fractions = new float[colors.length];  
        for(int i = 0; i < colors.length; i++){  
            colors[i] = colorSpaces[rand.nextInt(colorSpaces.length)];  
            fractions[i] = rand.nextFloat();  
        }  
        Arrays.sort(fractions);  
        Paint linearPaint = new LinearGradientPaint(0, 0, w, h, fractions, colors);  
        Paint linearPaint2 = new LinearGradientPaint(0, 0, w, h, new float[]{0.3f, .6f, .8f, .9f}, new Color[]{Color.BLUE, Color.BLACK, Color.GREEN, Color.BLUE});  
        //����ͼƬ����Ϊ��ɫ  
        g2.setPaint(Color.WHITE);  
        g2.fillRect(0, 0, w, h);  
        //����ͼƬ���䱳��  
        g2.setPaint(linearPaint);  
        g2.fillRoundRect(0, 0, w, h, 5, 5);  
          
        g2.setPaint(linearPaint2);  
        int fontSize = (int) (Math.min(w/verifySize, h));  
        Font font = new Font("΢���ź�", Font.BOLD, fontSize);  
        g2.setFont(font);  
        char[] chars = code.toCharArray();  
        for(int i = 0; i < verifySize; i++){  
            AffineTransform affine = new AffineTransform();  
            affine.setToRotation(Math.PI / 4 * rand.nextDouble() * (rand.nextBoolean() ? 1 : -1), (w / verifySize) * i + fontSize/2, h/2);  
            g2.setTransform(affine);  
            g2.drawChars(chars, i, 1, (w / verifySize) * i, h/2 + fontSize /2);  
        }  
        g2.dispose();  
        ImageIO.write(image, "jpg", os);  
    }  
  
    public static void main(String[] args) throws IOException{  
        File dir = new File("F:/verifies");  
        int w = 200, h = 80;  
        for(int i = 0; i < 100; i++){  
            String verifyCode = generateVerifyCode(4);  
            File file = new File(dir, verifyCode + ".jpg");  
            outputImage(w, h, file, verifyCode);  
        }  
    }  
}  


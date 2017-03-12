package com.jackyting.code.qrcode;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.data.QRCodeImage;

/**
 * 利用qrcode方式读取二維碼
 * 
 * @author jackyting1025
 *
 */
public class ParseQRCode {

	public static void main(String[] args) throws Exception {
		File file = new File("/home/jackyting1025/Desktop/code.jpg");
		BufferedImage bufferedImage = ImageIO.read(file);

		QRCodeDecoder decoder = new QRCodeDecoder();
		String result = new String(decoder.decode(new MyQRCodeImage(
				bufferedImage)), "utf-8");

		System.out.println("解析结果：" + result);

	}

}

class MyQRCodeImage implements QRCodeImage {

	BufferedImage bufferedImage;

	public MyQRCodeImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}

	@Override
	public int getHeight() {
		return bufferedImage.getHeight();
	}

	@Override
	public int getPixel(int arg0, int arg1) {
		return bufferedImage.getRGB(arg0, arg1);
	}

	@Override
	public int getWidth() {
		return bufferedImage.getWidth();
	}

}

package com.jackyting.code.zxing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

/**
 * 利用google的zxing讀取二維碼
 * 
 * @author jackyting1025
 *
 */
public class ParseQRCode {

	public static void main(String[] args) {

		try {
			MultiFormatReader reader = new MultiFormatReader();
			File file = new File("/home/jackyting1025/Desktop/code.png");
			BufferedImage image = ImageIO.read(file);
			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
					new BufferedImageLuminanceSource(image)));
			// 定义二维码的参数
			HashMap hints = new HashMap();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");

			Result result = reader.decode(binaryBitmap, hints);

			System.out.println("解析結果：" + result.toString());
			System.out.println("二維碼格式：" + result.getBarcodeFormat());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

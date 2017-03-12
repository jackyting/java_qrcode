package com.jackyting.code.qrcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

/**
 * 利用qrcode方式生成二維碼
 * 
 * @author jackyting1025
 *
 */
public class CreateQRCode {

	public static void main(String[] args) {
		Qrcode x = new Qrcode();
		x.setQrcodeEncodeMode('B');// N代表数字，A代表a-Z,B代表其他字符
		x.setQrcodeErrorCorrect('M');// 纠错等级
		x.setQrcodeVersion(7);// 版本

		int width = 67 + 12 * (7 - 1); // 宽高的固定公式
		int height = 67 + 12 * (7 - 1);// 宽高的固定公式
		String qrData = "www.baizhongyun.cn";
		BufferedImage bufferedImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D gs = bufferedImage.createGraphics();
		gs.setBackground(Color.WHITE);
		gs.setColor(Color.BLACK);
		gs.clearRect(0, 0, width, height);

		int pixoff = 2;// 偏移量

		byte[] d = qrData.getBytes();
		if (d.length > 0 && d.length < 120) {
			boolean[][] s = x.calQrcode(d);
			for (int i = 0; i < s.length; i++) {
				for (int j = 0; j < s.length; j++) {
					if (s[j][i]) {
						gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
					}
				}
			}
		}
		gs.dispose();
		bufferedImage.flush();
		try {
			ImageIO.write(bufferedImage, "jpg", new File(
					"/home/jackyting1025/Desktop/code.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

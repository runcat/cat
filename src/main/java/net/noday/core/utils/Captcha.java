package net.noday.core.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.shiro.session.Session;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

public class Captcha {

	private static final Random random = new Random();
	private static final String CAPTCHAKEY = "_key_of_captch";
	
	public static boolean validate(Session s, String captcha) {
		String text = (String) s.getAttribute(CAPTCHAKEY);
		return StringUtils.equalsIgnoreCase(text, captcha);
	}
	
	public static ByteArrayInputStream captch(Session s, int width, int height) throws IOException {
		String text = randText();
		s.setAttribute(CAPTCHAKEY, text);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ImageIO.write(gen(text, width, height), "png", out);
		return new ByteArrayInputStream(out.toByteArray());
	}
	public static BufferedImage gen(String text, int width, int height) throws IOException {
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		Graphics2D g = (Graphics2D) bi.getGraphics();
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, width, height);
		for (int i = 0; i < 10; i++) {
			g.setColor(randColor(150, 250));
			g.drawOval(random.nextInt(110), random.nextInt(24), 5+random.nextInt(10), 5+random.nextInt(10));
			Font f = new Font("Arial", Font.ITALIC, 20);
			g.setFont(f);
			g.setColor(randColor(10, 240));
			g.drawString(text, 4, 24);
		}
		return bi;
	}
	
	private static Color randColor(int fc, int bc) {
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
	
	private static String randText() {
		String text = RandomStringUtils.randomAlphanumeric(4)
			.toUpperCase()
			.replace('0', 'A').replace('O', 'E')
			.replace('1', 'V').replace('I', 'R');
		return text;
	}
	
}

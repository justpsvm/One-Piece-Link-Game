package com.knwohowinfo.page;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import com.knowhowinfo.interfece.MainInterface;

/**
 * @author Administrator
 * 
 *         ��Ϸ��ͣ��
 */
public class GameStop {

	private int select;
	private BufferedImage img = null;

	private static ArrayList<Rectangle> list = new ArrayList<Rectangle>();

	private int fontSize = 20;

	private int time;

	public GameStop() {
		init();
	}

	private void init() {
		try {
			img = ImageIO.read(new File("stop/image.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ����
	public void updata(int select) {
		this.select = select;
	}

	public static ArrayList<Rectangle> getRectangle() {
		return list;
	}

	// ����
	public void paint(Graphics g) {

		time++;

		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(img, 0, 0, null);

		switch (select) {
		case -1:
			fontSize = 20;
			break;
		case 0:
			fontSize = 25;
			break;
		}

		g2d.setColor(Color.RED.brighter());

		g2d.setFont(new Font(MainInterface.FONT, Font.BOLD, 25));

		if (time == 5) {
			g2d.drawString("��Ϸ��ͣ��....", 350, 420);
			time = 0;
		} else {
			g2d.drawString("��Ϸ��ͣ��...", 350, 420);
		}

		g2d.setColor(Color.white.brighter());

		Shape sh = new Font(MainInterface.FONT, Font.BOLD, fontSize)
				.createGlyphVector(g2d.getFontRenderContext(), "����")
				.getOutline(460, 500);

		Rectangle resh = sh.getBounds();

		g2d.fill(sh);

		if (list.isEmpty()) {
			list.add(resh);
		}
	}
}

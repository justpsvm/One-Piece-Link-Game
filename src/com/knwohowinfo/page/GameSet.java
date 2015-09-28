package com.knwohowinfo.page;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.knowhowinfo.interfece.MainInterface;

/**
 * @author Administrator ��Ϸ������
 */
public class GameSet {

	private static ArrayList<Rectangle> list = new ArrayList<Rectangle>();
	private BufferedImage img;
	private int fontSize = 20;
	private int fontSize2 = 20;
	private boolean isDown = true;
	private boolean isDown2 = true;

	public GameSet() {
		init();
	}

	private void init() {

		try {
			img = ImageIO.read(new File("set/image.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Rectangle> getRectangle() {
		return list;
	}

	// ������Ϸ���²���
	public void updata(int select) {
		switch (select) {
		case 0:// ȷ��
			fontSize = 25;
			break;
		case 1:// ����
			fontSize2 = 25;
			break;
		default:
			fontSize = 20;
			fontSize2 = 20;
			break;
		}
	}

	public void Updata(int select) {
		switch (select) {
		case 2:// ������Ч
			if (isDown) {
				isDown = false;
			} else {
				isDown = true;
			}
			break;
		case 3:// ����������
			if (isDown2) {
				isDown2 = false;
			} else {
				isDown2 = true;
			}
			break;
		}
	}

	// ��ÿ�����Ч
	public boolean getIsDown() {
		return isDown;
	}

	// ��ÿ���������
	public boolean getIsDown2() {
		return isDown2;
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		// �򿪿����ģʽ
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		// ������ͼ
		g2d.drawImage(img, 0, 0, null);

		// ���ƹ��ܱ߿�
		Color c = new Color(255, 255, 255, 60);

		g2d.setColor(c);

		g2d.setStroke(new BasicStroke(2.0f));// ���û��ʴ�С

		g2d.fillRoundRect(90, 120, 600, 300, 30, 40);

		g2d.setColor(Color.RED);

		g2d.setFont(new Font(MainInterface.FONT, Font.BOLD, 20));

		g2d.drawString("������Ч", 320, 200);

		g2d.drawString("������������", 320, 260);

		// ������Ч
		g2d.drawRect(290, 185, 15, 15);

		// ������������
		g2d.drawRect(290, 245, 15, 15);

		Shape sh = new Font(MainInterface.FONT, Font.BOLD, fontSize)
				.createGlyphVector(g2d.getFontRenderContext(), "ȷ��")
				.getOutline(290, 380);
		Rectangle resh = sh.getBounds();

		Shape sh2 = new Font(MainInterface.FONT, Font.BOLD, fontSize2)
				.createGlyphVector(g2d.getFontRenderContext(), "����")
				.getOutline(430, 380);
		Rectangle resh2 = sh2.getBounds();

		g2d.fill(sh);
		g2d.fill(sh2);

		if (isDown) {
			g2d.setFont(new Font(MainInterface.FONT, Font.BOLD, 30));
			g2d.drawString("��", 280, 203);
		}
		if (isDown2) {
			g2d.setFont(new Font(MainInterface.FONT, Font.BOLD, 30));
			g2d.drawString("��", 280, 263);
		}

		// ����
		if (list.isEmpty()) {
			list.add(resh);
			list.add(resh2);

			list.add(new Rectangle(290, 185, 15 + 4, 15 + 10));// ������Ч

			list.add(new Rectangle(290, 245, 15 + 4, 15 + 10));// ������������

		}

	}

	public boolean isDown() {
		return isDown;
	}

	public void setDown(boolean isDown) {
		this.isDown = isDown;
	}

	public boolean isDown2() {
		return isDown2;
	}

	public void setDown2(boolean isDown2) {
		this.isDown2 = isDown2;
	}

}

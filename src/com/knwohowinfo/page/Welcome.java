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
 * @author admin ��Ϸ��ӭ����
 */
public class Welcome {
	private ArrayList<BufferedImage> imgs = new ArrayList<BufferedImage>();

	public static ArrayList<Rectangle> list = new ArrayList<Rectangle>();

	private int select = -1;

	private int x = 830;

	private int lx = 1300;

	private int y = 40;

	private int speed = 3;// ͼƬ�ƶ��ٶ�

	public Welcome() {
		init();

	}

	private void init() {
		try {

			imgs.add(ImageIO.read(new File("welcome/image.jpg")));

			imgs.add(ImageIO.read(new File("welcome/image2.png")));

			// ǰ��ͼƬ
			imgs.add(ImageIO.read(new File("welcome/image3.png")));

			imgs.add(ImageIO.read(new File("welcome/image4.png")));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void updata(int select) {
		this.select = select;
	}

	public static ArrayList<Rectangle> getRectangles() {
		return list;
	}

	// ��������
	public void paint(Graphics g) {

		g.drawImage(imgs.get(0), 0, 0, null);

		// ��ʾǰ��ͼƬ

		x -= speed;// ͼƬ�ٶ�

		lx -= speed;

		if (x == -500) {// ׼���ط�
			x = 830;
		}

		if (lx == -500) {
			lx = 1500;
		}
		g.drawImage(imgs.get(2), x, y, null);

		g.drawImage(imgs.get(3), lx, y, null);

		Graphics2D g2d = (Graphics2D) g;

		// �򿪿����ģʽ
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		// �߿�
		g2d.setColor(MainInterface.BORDER_COLOR);
		g2d.setStroke(new BasicStroke(3.0f));
		g2d.drawRoundRect(270, 150, 260, 290, 40, 40);

		// ��ȡ��������

		g2d.setColor(Color.WHITE.brighter());

		g2d.setStroke(new BasicStroke());// ��ԭ����

		Shape sh = new Font(MainInterface.FONT, Font.BOLD, 30)
				.createGlyphVector(g2d.getFontRenderContext(), "������Ϸ")
				.getOutline(320, 210);

		Rectangle px = sh.getBounds();// �õ���ǰ�Ŀ��

		Shape sh1 = new Font(MainInterface.FONT, Font.BOLD, 30)
				.createGlyphVector(g2d.getFontRenderContext(), "�µ��ó�")
				.getOutline(320, (float) 210 + (float) px.getHeight() + 20);

		Rectangle px1 = sh1.getBounds();// �õ���ǰ�Ŀ��

		Shape sh2 = new Font(MainInterface.FONT, Font.BOLD, 30)
				.createGlyphVector(g2d.getFontRenderContext(), "��Ϸ����")
				.getOutline(320, (float) 210 + (float) px1.getHeight() + 75);

		Rectangle px2 = sh2.getBounds();// �õ���ǰ�Ŀ��

		Shape sh3 = new Font(MainInterface.FONT, Font.BOLD, 30)
				.createGlyphVector(g2d.getFontRenderContext(), "������Ϸ")
				.getOutline(320, (float) 210 + (float) px2.getHeight() + 130);

		Rectangle px3 = sh3.getBounds();// �õ���ǰ�Ŀ��

		Shape sh4 = new Font(MainInterface.FONT, Font.BOLD, 30)
				.createGlyphVector(g2d.getFontRenderContext(), "�˳���Ϸ")
				.getOutline(320, (float) 210 + (float) px3.getHeight() + 190);

		Rectangle px4 = sh4.getBounds();// �õ���ǰ�Ŀ��

		g2d.draw(sh);

		g2d.draw(sh1);

		g2d.draw(sh2);

		g2d.draw(sh3);

		g2d.draw(sh4);

		// ����ͼƬ
		switch (select) {
		case 0:
			Shape sht = new Font(MainInterface.FONT, Font.BOLD, 30)
					.createGlyphVector(g2d.getFontRenderContext(), "������Ϸ")
					.getOutline(320, 210);

			g2d.fill(sht);

			g2d.drawImage(imgs.get(1), sht.getBounds().x - 30,
					sht.getBounds().y + 5, null);

			g2d.drawImage(imgs.get(1), sht.getBounds().x + 142,
					sht.getBounds().y + 5, null);

			break;
		case 1:
			Shape sh1t = new Font(MainInterface.FONT, Font.BOLD, 30)
					.createGlyphVector(g2d.getFontRenderContext(), "�µ��ó�")
					.getOutline(320, (float) 210 + (float) px.getHeight() + 20);

			g2d.fill(sh1t);

			g2d.drawImage(imgs.get(1), 323 - 30, sh1t.getBounds().y + 5, null);

			g2d.drawImage(imgs.get(1), 323 + 142, sh1t.getBounds().y + 5, null);

			break;
		case 2:
			Shape sh2t = new Font(MainInterface.FONT, Font.BOLD, 30)
					.createGlyphVector(g2d.getFontRenderContext(), "��Ϸ����")
					.getOutline(320, (float) 210 + (float) px1.getHeight() + 75);

			g2d.fill(sh2t);

			g2d.drawImage(imgs.get(1), 323 - 30, sh2t.getBounds().y + 5, null);

			g2d.drawImage(imgs.get(1), 323 + 142, sh2t.getBounds().y + 5, null);

			break;
		case 3:
			Shape sh3t = new Font(MainInterface.FONT, Font.BOLD, 30)
					.createGlyphVector(g2d.getFontRenderContext(), "������Ϸ")
					.getOutline(320,
							(float) 210 + (float) px2.getHeight() + 130);

			g2d.fill(sh3t);

			g2d.drawImage(imgs.get(1), 323 - 30, sh3t.getBounds().y + 5, null);

			g2d.drawImage(imgs.get(1), 323 + 142, sh3t.getBounds().y + 5, null);

			break;
		case 4:
			Shape sh4t = new Font(MainInterface.FONT, Font.BOLD, 30)
					.createGlyphVector(g2d.getFontRenderContext(), "�˳���Ϸ")
					.getOutline(320,
							(float) 210 + (float) px3.getHeight() + 190);

			g2d.fill(sh4t);

			g2d.drawImage(imgs.get(1), 323 - 30, sh4t.getBounds().y + 5, null);

			g2d.drawImage(imgs.get(1), 323 + 142, sh4t.getBounds().y + 5, null);

			break;
		}

		if (list.isEmpty()) {// ����
			list.add(px);
			list.add(px1);
			list.add(px2);
			list.add(px3);
			list.add(px4);
		}
	}

}

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
 * @author Administrator ��Ϸ����
 */
public class GameAbout {
	private static ArrayList<Rectangle> list = new ArrayList<Rectangle>();
	private int fontSize = 30;
	private File f = new File("image/image10.jpg");
	private BufferedImage img;

	public GameAbout() {
		init();
	}

	private void init() {
		try {
			img = ImageIO.read(f);// ��ȡ������Ϸ����ͼƬ
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Rectangle> getRectangle() {
		return list;
	}

	public void updata(int select) {
		switch (select) {
		case -1:
			fontSize = 30;
			break;
		case 0:
			fontSize = 35;
			break;
		}

	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		// �򿪿����ģʽ
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(Color.black);// ��ɫ����
		g2d.fillRect(0, 0, MainInterface.GAMEMAP_SC_WIDTH,
				MainInterface.GAMEMAP_SC_HEIGHT);

		g.drawImage(img, 190, 0, null);

		// ����������ɫ
		g2d.setColor(Color.WHITE.brighter());// ��������

		Shape about = new Font(MainInterface.FONT, Font.BOLD, 35)
				.createGlyphVector(g2d.getFontRenderContext(), "������Ϸ")
				.getOutline(300, 100);

		Rectangle reAbout = about.getBounds();// ��ȡ����Ŀ��

		Shape back = new Font(MainInterface.FONT, Font.BOLD, fontSize)
				.createGlyphVector(g2d.getFontRenderContext(), "Return")
				.getOutline(340, 490);

		Rectangle reback = back.getBounds();

		g2d.fill(about);

		g2d.fill(back);

		Color c = new Color(255, 255, 255, 60);

		g2d.setColor(c);

		g2d.setStroke(new BasicStroke(2.0f));// ���û��ʴ�С

		g2d.fillRoundRect(90, 120, 600, 300, 30, 40);

		// ��Ϸ����

		g2d.setFont(MainInterface.F);
		g2d.setColor(Color.RED);

		g2d.drawString("��Ϸ����:", 200, 150);

		g2d.drawString("��Ϸ����:", 200, 180);

		g2d.drawString("��Ϸ���:", 200, 210);

		g2d.setColor(Color.white);
		// ��Ϸ����:
		g2d.drawString("��������������", 280, 150);

		// ��Ϸ����:
		g2d.drawString("��������", 280, 180);

		// ��Ϸ���:
		g2d.drawString("����������?��ϲ��ð����?", 280, 210);

		g2d.drawString("ϣ�������Ϸ���԰���ʵ�����Ը��,��Ϸ��;", 200, 235);

		g2d.drawString("���ܹ�Ҫ����7������,�������������ֻ���", 200, 260);

		g2d.drawString("����,���ܸ�������������Ȥ", 200, 285);

		g2d.drawString("ףԸ��������ʵ���Լ�������!", 200, 330);

		// ��Ӧ�Ŀ�ߴ���䳤����
		if (list.isEmpty()) {
			list.add(reback);// return
			// list.add(reAbout);
		}
	}

}

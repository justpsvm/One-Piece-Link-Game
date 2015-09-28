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
import com.knowhowinfo.util.ReadDataUtil;

/**
 * @author admin ��Ϸ���а�
 */
public class GameList {
	public int mark;// ��ҷ���

	private BufferedImage img;

	private String str;

	private String str2;

	private String str3;

	private static ArrayList<Rectangle> list = new ArrayList<Rectangle>();

	private int fontSize = 30;

	private int select;

	public GameList() {
		init();
		getData();
	}

	private void init() {
		try {
			img = ImageIO.read(new File("list/image.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public static ArrayList<Rectangle> getRectangle() {
		return list;
	}

	public void Updata(int select) {
		switch (select) {
		case 0:// return
			fontSize = 35;
			break;
		default:
			fontSize = 30;
			break;
		}
	}

	public void getData() {
		// ���ݿ����а�ȡ��
		ArrayList<Integer> marks = ReadDataUtil.getMark();
		// ����������������
		switch (marks.size()) {
		case 0:
			str = "��ȱ";
			str2 = "��ȱ";
			str3 = "��ȱ";
			break;
		case 1:
			str = String.valueOf(marks.get(0) + "��");
			str2 = "��ȱ";
			str3 = "��ȱ";
			break;
		case 2:
			str = String.valueOf(marks.get(1) + "��");
			str2 = String.valueOf(marks.get(0) + "��");
			str3 = "��ȱ";
			break;
		case 3:
			str = String.valueOf(marks.get(2) + "��");
			str2 = String.valueOf(marks.get(1) + "��");
			str3 = String.valueOf(marks.get(0) + "��");
			break;
		}

	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		getData();

		// �򿪿����
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		// ���а񱳾�ͼ
		g2d.drawImage(img, 0, 0, null);

		// ���а��
		Color c = new Color(255, 255, 255, 60);

		g2d.setColor(c);

		g2d.setStroke(new BasicStroke(2.0f));// ���û��ʴ�С

		g2d.fillRoundRect(90, 120, 600, 300, 30, 40);

		g2d.setColor(Color.RED.brighter());

		g2d.setFont(new Font(MainInterface.FONT, Font.BOLD, 30));

		g2d.drawString("���а�", 335, 100);

		g2d.drawString("��һ��:", 160, 180);

		g2d.drawString("�ڶ���:", 160, 255);

		g2d.drawString("������:", 160, 330);

		g2d.setColor(Color.BLACK);

		// 1
		g2d.drawString(str, 310, 180);

		// 2
		g2d.drawString(str2, 310, 255);

		// 3
		g2d.drawString(str3, 310, 330);

		g2d.setColor(Color.RED.brighter());

		Shape back = new Font(MainInterface.FONT, Font.BOLD, fontSize)
				.createGlyphVector(g2d.getFontRenderContext(), "Return")
				.getOutline(340, 490);

		Rectangle reback = back.getBounds();

		g2d.draw(back);

		if (list.isEmpty()) {
			list.add(reback);
		}
	}
}

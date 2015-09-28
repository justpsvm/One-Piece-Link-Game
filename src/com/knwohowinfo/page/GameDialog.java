package com.knwohowinfo.page;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;

import com.knowhowinfo.interfece.MainInterface;

/**
 * @author Administrator ��Ϸ�еĶԻ���
 */
public class GameDialog {

	private static ArrayList<Rectangle> list = new ArrayList<Rectangle>();

	private String str = "";

	private int fontSize = 15;

	private int fontSize2 = 15;

	private int select;

	private int option;

	private int x = 360;
	private int y = 280;

	public GameDialog() {

	}

	public static ArrayList<Rectangle> getRectangle() {
		return list;
	}

	public void setCommand(int select) {
		switch (select) {
		case -1://
			fontSize = 15;
			fontSize2 = 15;
			break;
		case 0:// ȷ��
			fontSize = 20;
			break;
		case 1:// ȡ��
			fontSize2 = 20;
			break;
		case 2:// �������˵�
			str = "����ǰ������Ϸ,ȷ�Ϸ��ص����˵���??";
			break;
		case 3:// �������
			str = "������!";
			x = 360;
			y = 280;
			break;
		case 4:// ���Ӯ��
			str = "��Ӯ��!";
			x = 360;
			y = 280;
			break;
		case 5:
			str = "�����������Ϸ��¼,ȷ�ϼ�����?";
			break;
		}
	}

	public void setDia(int option) {
		this.option = option;
	}

	// ���ص�ǰ�Ի�����ʾ�ĸ�����
	public int getSelect() {
		return option;
	}

	public void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		// �Ի���
		g2d.setColor(MainInterface.BORDER_COLOR_HYALINE);// ��ɫ��͸��
		g2d.fillRoundRect(260, 200, 320, 170, 30, 40);

		// �Ի�����
		g2d.setColor(Color.RED.brighter());

		g2d.setFont(new Font(MainInterface.FONT, Font.BOLD, 20));

		if (str.length() > 13) {// ��׼������
			g2d.drawString(str.substring(0, 13), 270, 230);
			g2d.drawString(str.substring(13, str.length()), 270, 256);
		} else {
			g2d.drawString(str, x, y);
		}

		g2d.setColor(Color.WHITE.brighter());

		Shape sh2 = new Font(MainInterface.FONT, Font.BOLD, fontSize)
				.createGlyphVector(g2d.getFontRenderContext(), "ȷ��")
				.getOutline(300, 350);

		Rectangle resh2 = sh2.getBounds();

		Shape sh3 = new Font(MainInterface.FONT, Font.BOLD, fontSize2)
				.createGlyphVector(g2d.getFontRenderContext(), "ȡ��")
				.getOutline(470, 350);

		Rectangle resh3 = sh3.getBounds();

		g2d.fill(sh2);
		g2d.fill(sh3);

		if (list.isEmpty()) {
			list.add(resh2);// 0
			list.add(resh3);// 1
		}
	}

}

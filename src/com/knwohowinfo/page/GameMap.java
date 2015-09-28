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
import com.knowhowinfo.ui.MainPanel;
import com.knowhowinfo.util.ReadDataUtil;

/**
 * @author admin ��Ϸ��ͼ
 * 
 *         ��Ҫ��ȡ���ݿ����
 */
public class GameMap {
	private static ArrayList<Rectangle> list = new ArrayList<Rectangle>();
	private String command;
	private ArrayList<BufferedImage> imgs = new ArrayList<BufferedImage>();
	private int fontSize1 = 20;
	private int fontSize2 = 20;
	private int flag;// ������Ϸ ���ز˵� ����button�Ĳ���
	private Rectangle re = new Rectangle(30, 35, 160, 120);
	private MainPanel panel = MainPanel.getInstance();

	// ͼƬ�޸ĵ��±�
	private int imIndex1;
	private int imIndex2;
	private int imIndex3;
	private int imIndex4;
	private int imIndex5;
	private int imIndex6;
	private int imIndex7;

	public GameMap() {
		init();
		inire();
	}

	// �������ñ߿�
	public void inire() {
		re = new Rectangle(30, 35, 160, 120);// ���ñ߿�
	}

	// ʵ����
	{
	}

	private void init() {
		try {
			imgs.add(ImageIO.read(new File("map/image3.jpg")));

			// 1
			imgs.add(ImageIO.read(new File("pass/fcc.jpg")));// 1

			// 2
			imgs.add(ImageIO.read(new File("pass/jyqd.jpg")));// 2
			imgs.add(ImageIO.read(new File("pass/jyqd2.jpg")));// 3

			// 3
			imgs.add(ImageIO.read(new File("pass/kkyxc.jpg")));// 4
			imgs.add(ImageIO.read(new File("pass/kkyxc2.jpg")));// 5

			// 4
			imgs.add(ImageIO.read(new File("pass/lgz.jpg")));// 6
			imgs.add(ImageIO.read(new File("pass/lgz2.jpg")));// 7

			// 5
			imgs.add(ImageIO.read(new File("pass/mzh.jpg")));// 8
			imgs.add(ImageIO.read(new File("pass/mzh2.jpg")));// 9

			// 6
			imgs.add(ImageIO.read(new File("pass/mlqy.jpg")));// 10
			imgs.add(ImageIO.read(new File("pass/mlqy2.jpg")));// 11

			// 7
			imgs.add(ImageIO.read(new File("pass/lfdl.jpg")));// 12
			imgs.add(ImageIO.read(new File("pass/lfdl2.jpg")));// 13

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void updata(int select) {
		switch (select) {
		case -1:
			command = MainInterface.COMMAND9;
			flag = 0;
			break;
		case 1:
			command = MainInterface.COMMAND1;
			break;
		case 2:
			command = MainInterface.COMMAND2;
			break;
		case 3:
			command = MainInterface.COMMAND3;
			break;
		case 4:
			command = MainInterface.COMMAND4;
			break;
		case 5:
			command = MainInterface.COMMAND5;
			break;
		case 6:
			command = MainInterface.COMMAND6;
			break;
		case 7:
			command = MainInterface.COMMAND7;
			break;
		case 8:// ������Ϸ
			flag = 1;
			if (panel == null) {
				panel = MainPanel.getInstance();
			}
			panel.coreDefault();// ������������������
			break;
		case 9:// ���ز˵�
			flag = 2;
			break;
		case 520:// ���ڻ�δ�����Ĺؿ���˵��
			command = MainInterface.COMMAND8;
			break;
		}
	}

	public static ArrayList<Rectangle> getRectangles() {
		return list;
	}

	// �������ѡ����
	public void setDraw(int i) {
		int in = ReadDataUtil.getPass();

		// ��ͼ������±�
		if (i > in) {
			return;
		}

		switch (i) {
		case 1:
			re = new Rectangle(30, 35, 160, 120);
			break;
		case 2:
			re = new Rectangle(120, 215, 160, 120);
			break;
		case 3:
			re = new Rectangle(70, 395, 160, 120);
			break;
		case 4:
			re = new Rectangle(360, 355, 160, 120);
			break;
		case 5:
			re = new Rectangle(390, 85, 160, 120);
			break;
		case 6:
			re = new Rectangle(590, 225, 160, 120);
			break;
		case 7:
			re = new Rectangle(630, 435, 160, 120);
			break;
		}
	}

	public void paint(Graphics e) {

		// ���ݿ��ѯ����
		int in = ReadDataUtil.getPass();

		automatic(in);

		Graphics2D p2d = (Graphics2D) e;// ��ͼƬ����ת��Ϊ2d����

		p2d.setColor(Color.black);
		p2d.fillRect(0, 0, MainInterface.GAMEMAP_SC_WIDTH,
				MainInterface.GAMEMAP_SC_HEIGHT);
		p2d.setFont(new Font(MainInterface.FONT2, Font.LAYOUT_NO_START_CONTEXT,
				12));

		p2d.drawImage(imgs.get(0), 50, 30, null);

		// �򿪿����ģʽ
		p2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		p2d.setColor(MainInterface.BORDER_COLOR_HYALINE);// ��͸��

		p2d.setStroke(new BasicStroke(2.0f));

		// ״̬��(��)

		// 0

		p2d.fillRoundRect(8, 545, 530, 40, 30, 80);

		// ��ͼ��

		// 1
		p2d.drawRoundRect(30, 35, 160, 120, 40, 30); // ��Ϸ ��1�� �糵��

		// �糵��ͼƬ
		p2d.drawImage(imgs.get(imIndex1), 40, 43, 140, 105, null);

		// 2
		p2d.drawRoundRect(120, 215, 160, 120, 40, 30);// �� 2 ��

		// 3
		p2d.drawRoundRect(70, 395, 160, 120, 40, 30);

		// 4
		p2d.drawRoundRect(360, 355, 160, 120, 40, 30);

		// 5
		p2d.drawRoundRect(390, 85, 160, 120, 40, 30);

		// 6
		p2d.drawRoundRect(590, 225, 160, 120, 40, 30);

		// 7
		p2d.setColor(Color.RED);

		p2d.drawRoundRect(630, 435, 160, 120, 40, 30);

		p2d.setColor(Color.black);

		// 2���
		p2d.fillRoundRect(121, 217, 158, 118, 40, 30);

		// ���ŵ�
		p2d.drawImage(imgs.get(imIndex2), 130, 225, 140, 105, null);

		// 3���
		p2d.fillRoundRect(71, 397, 158, 118, 40, 30);

		// �ɿ�������
		p2d.drawImage(imgs.get(imIndex3), 80, 405, 140, 105, null);

		// 4���
		p2d.fillRoundRect(361, 357, 158, 118, 40, 30);

		// �޸���
		p2d.drawImage(imgs.get(imIndex4), 370, 365, 140, 105, null);

		// 5���
		p2d.fillRoundRect(391, 87, 158, 118, 40, 30);

		// ħ֮��
		p2d.drawImage(imgs.get(imIndex5), 400, 95, 140, 105, null);

		// 6���
		p2d.fillRoundRect(591, 227, 158, 118, 40, 30);

		// ʥ��
		p2d.drawImage(imgs.get(imIndex6), 600, 233, 140, 105, null);

		// 7���
		p2d.fillRoundRect(631, 437, 158, 118, 40, 30);

		// 7���
		p2d.fillRoundRect(631, 437, 158, 118, 40, 30);

		// ����֮��!

		p2d.drawImage(imgs.get(imIndex7), 640, 443, 140, 105, null);

		//
		// p2d.drawImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8,
		// arg9)

		// 8 One

		// �������ѡ���
		if (re != null) {

			p2d.setColor(Color.green.brighter());

			p2d.drawRoundRect(re.x, re.y, re.width, re.height, 40, 30);// ����
		}

		p2d.setColor(Color.WHITE.brighter());// �������İ�ɫ

		if (command != null) {
			String str = "";

			if (command.length() > 45) {// ׼��������
				str = command.substring(0, 45);
				p2d.drawString(str, 12, 563);
				p2d.drawString(command.substring(45, command.length()), 12, 580);
			} else {

				if (command.equals(MainInterface.COMMAND8)) {// �����ǰ�ǻ�δ�����ĵ�ͼ
					p2d.setColor(Color.RED.brighter());
					p2d.setFont(new Font(MainInterface.FONT, Font.BOLD, 20));
					p2d.drawString(command, 160, 575);
				} else if (command.equals(MainInterface.COMMAND9)) {// ���δ�ڵ�ͼ��Χ֮��
					p2d.setColor(Color.RED.brighter());
					p2d.setFont(new Font(MainInterface.FONT, Font.BOLD, 20));
					p2d.drawString(command, 160, 575);
				} else {
					p2d.drawString(command, 12, 570);
				}
			}
		}

		p2d.setStroke(new BasicStroke());// ��ԭ���ʴ�С

		switch (flag) {
		case 1:
			fontSize1 = 25;
			break;
		case 2:
			fontSize2 = 25;
			break;
		default:
			fontSize1 = 20;
			fontSize2 = 20;
			break;
		}

		p2d.setColor(Color.WHITE.brighter());// �������İ�ɫ

		Shape gameContinue = new Font(MainInterface.FONT, Font.BOLD, fontSize1)
				.createGlyphVector(p2d.getFontRenderContext(), "������Ϸ")
				.getOutline(580, 40);

		Rectangle gContinue = gameContinue.getBounds();// ��ȡ������

		Shape gameBack = new Font(MainInterface.FONT, Font.BOLD, fontSize2)
				.createGlyphVector(p2d.getFontRenderContext(), "���ز˵�")
				.getOutline(580, 80);

		Rectangle gBack = gameBack.getBounds();// ��ȡ������

		p2d.fill(gameContinue);

		p2d.fill(gameBack);

		if (list.isEmpty()) {// ����

			// 0
			list.add(new Rectangle(8, 545, 530, 40));

			// 1
			list.add(new Rectangle(30 + 10, 35, 160, 120));// x y w h

			// 2
			list.add(new Rectangle(120 + 10, 215, 160, 120));

			// 3
			list.add(new Rectangle(70 + 10, 395, 160, 120));

			// 4
			list.add(new Rectangle(360 + 10, 355, 160, 120));

			// 5
			list.add(new Rectangle(390 + 10, 85, 160, 120));

			// 6
			list.add(new Rectangle(590 + 10, 225, 160, 120));

			// 7
			list.add(new Rectangle(630 + 10, 435, 160, 120));

			// ����

			// 8 --> ������Ϸ
			list.add(gContinue);

			// 9 --> ���ز˵�
			list.add(gBack);

		}
	}

	private void automatic(int in) {

		switch (in) {
		case 1:
			imIndex1 = 1;
			imIndex2 = 3;
			imIndex3 = 5;
			imIndex4 = 7;
			imIndex5 = 9;
			imIndex6 = 11;
			imIndex7 = 13;
			break;
		case 2:
			imIndex1 = 1;
			imIndex2 = 2;
			imIndex3 = 5;
			imIndex4 = 7;
			imIndex5 = 9;
			imIndex6 = 11;
			imIndex7 = 13;
			break;
		case 3:
			imIndex1 = 1;
			imIndex2 = 2;
			imIndex3 = 4;
			imIndex4 = 7;
			imIndex5 = 9;
			imIndex6 = 11;
			imIndex7 = 13;
			break;
		case 4:
			imIndex1 = 1;
			imIndex2 = 2;
			imIndex3 = 4;
			imIndex4 = 6;
			imIndex5 = 9;
			imIndex6 = 11;
			imIndex7 = 13;
			break;
		case 5:
			imIndex1 = 1;
			imIndex2 = 2;
			imIndex3 = 4;
			imIndex4 = 6;
			imIndex5 = 8;
			imIndex6 = 11;
			imIndex7 = 13;
			break;
		case 6:
			imIndex1 = 1;
			imIndex2 = 2;
			imIndex3 = 4;
			imIndex4 = 6;
			imIndex5 = 8;
			imIndex6 = 10;
			imIndex7 = 13;
			break;
		case 7:
			imIndex1 = 1;
			imIndex2 = 2;
			imIndex3 = 4;
			imIndex4 = 6;
			imIndex5 = 8;
			imIndex6 = 10;
			imIndex7 = 12;
			break;
		}
	}
}

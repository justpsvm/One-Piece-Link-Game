package com.knwohowinfo.page;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.util.ArrayList;
import com.knowhowinfo.interfece.MainInterface;
import com.knowhowinfo.ui.MainPanel;

/**
 * @author Administrator
 * 
 *         ��Ϸ��ʼ
 */
public class GameStart {

	private MainPanel panel = MainPanel.getInstance();

	private static ArrayList<Rectangle> list = new ArrayList<Rectangle>();

	private int select;

	private int width = 600;
	private int time;
	private int fontSize0 = 15;
	private int fontSize1 = 15;
	private int fontSize2 = 15;
	private int fontSize3 = 15;
	private int fontSize4 = 15;
	private int fontSize5 = 15;
	private int fontSize6 = 15;

	private int promptNum = 3;

	private int upsetNum = 3;

	private static int mark = 0;// ��ҷ���

	// ���췽��
	public GameStart() {
		init();
	}

	private void init() {

	}

	public static ArrayList<Rectangle> getRectangle() {
		return list;
	}

	public void updata(int select) {
		this.select = select;
	}

	// ���÷���
	public static void setMark(int number) {
		GameStart.mark += number;
	}

	// ������ʾ����
	public void setPromptNum() {
		this.promptNum--;
	}

	// ���ٴ��һ���
	public void setUpNum() {
		this.upsetNum--;
	}

	// �����ʾ�������
	public int getPromptNum() {
		return promptNum;
	}

	// ��ô��һ������
	public int getUpNum() {
		return upsetNum;
	}

	// ��÷���
	public int getMark() {
		return mark;
	}

	// ����Ĭ��
	public void setDefault() {
		width = 600;// Ĭ�Ͻ�����
		mark = 0;// Ĭ�Ϸ���
		time = 0;
		promptNum = 3;
		upsetNum = 3;
	}

	// ����
	public void paint(Graphics g) {
		time++;
		Graphics2D g2d = (Graphics2D) g;

		// �򿪿����ģʽ
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		// ���ñ���
		g2d.setColor(MainInterface.BORDER_COLOR);

		g2d.fillRect(0, 0, MainInterface.GAMEMAP_SC_WIDTH,
				MainInterface.GAMEMAP_SC_HEIGHT);

		// ��Ϸ������

		if (width != 0) {
			g2d.setColor(new Color(51, 153, 255));
			g2d.fill3DRect(10, 50, width, 15, true);// ��Ϸ��ʼ���� ���ϳ��� Ĭ��ʱ����3����
			if (time == 20) {
				width -= 3;
				time = 0;
			}
		} else {
			// �������
			if (panel == null) {
				panel = MainPanel.getInstance();
			}

			panel.dialogUpdata(3);
			panel.diaSet(3);
			panel.control(6);
		}

		// ��Ϸ�˵�:

		g2d.setColor(Color.black);
		g2d.fillRect(0, 0, MainInterface.GAMEMAP_SC_WIDTH, 35);

		Font font = new Font(MainInterface.FONT, Font.BOLD, 15);

		g2d.setColor(Color.WHITE);

		g2d.setFont(font);

		// ��Ϸ����
		switch (select) {
		case 0:
			fontSize0 = 20;
			break;
		case 1:
			fontSize1 = 20;
			break;
		case 2:
			fontSize2 = 20;
			break;
		case 3:
			fontSize3 = 20;
			break;
		case 4:
			fontSize4 = 20;
			break;
		case 5:
			fontSize5 = 20;
			break;
		case 6:
			fontSize6 = 20;
		default:
			fontSize0 = 15;
			fontSize1 = 15;
			fontSize2 = 15;
			fontSize3 = 15;
			fontSize4 = 15;
			fontSize5 = 15;
			fontSize6 = 15;
			break;
		}
		Shape stop = new Font(MainInterface.FONT, Font.BOLD, fontSize0)
				.createGlyphVector(g2d.getFontRenderContext(), "��ͣ")
				.getOutline(200, 25);

		Rectangle stopRe = stop.getBounds();// ��ȡ����Ŀ��

		Shape mainMenu = new Font(MainInterface.FONT, Font.BOLD, fontSize1)
				.createGlyphVector(g2d.getFontRenderContext(), "���˵�")
				.getOutline(280, 25);

		Rectangle mainMenuRe = mainMenu.getBounds();

		Shape systemSet = new Font(MainInterface.FONT, Font.BOLD, fontSize2)
				.createGlyphVector(g2d.getFontRenderContext(), "ϵͳ����")
				.getOutline(370, 25);

		Rectangle systemSetRe = systemSet.getBounds();

		Shape gameList = new Font(MainInterface.FONT, Font.BOLD, fontSize3)
				.createGlyphVector(g2d.getFontRenderContext(), "���а�")
				.getOutline(490, 25);

		Rectangle gameListRe = gameList.getBounds();

		Shape about = new Font(MainInterface.FONT, Font.BOLD, fontSize4)
				.createGlyphVector(g2d.getFontRenderContext(), "����")
				.getOutline(600, 25);

		Rectangle aboutRe = about.getBounds();

		g2d.fill(stop);

		g2d.fill(mainMenu);

		g2d.fill(systemSet);

		g2d.fill(gameList);

		g2d.fill(about);

		g2d.setFont(new Font(MainInterface.FONT, Font.BOLD, fontSize5));

		g2d.drawString("��ʾ", 750, 60);

		g2d.setFont(new Font(MainInterface.FONT, Font.BOLD, fontSize6));

		g2d.drawString("����", 700, 60);

		if (mark != 0) {
			g2d.setFont(new Font(MainInterface.FONT, Font.BOLD, 15));
			g2d.drawString(String.valueOf(mark), 650, 65);// ��ҷ���
		}

		g2d.setColor(Color.RED);

		g2d.setFont(new Font("����", Font.BOLD, 15));

		g2d.drawString(String.valueOf(promptNum), 760, 78);// ��ʾ����

		g2d.drawString(String.valueOf(upsetNum), 710, 78);// ���һ���

		if (list.isEmpty()) {
			list.add(stopRe);
			list.add(mainMenuRe);
			list.add(systemSetRe);
			list.add(gameListRe);
			list.add(aboutRe);// ����

			// ��Ϸ����
			list.add(new Rectangle(750, 60 - 30, 43, 33));
			list.add(new Rectangle(700, 60 - 30, 42, 33));
		}
	}
}

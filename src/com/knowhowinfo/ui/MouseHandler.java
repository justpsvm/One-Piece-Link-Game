package com.knowhowinfo.ui;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import com.knowhowinfo.util.DbUtil;
import com.knowhowinfo.util.Plan;
import com.knwohowinfo.page.GameAbout;
import com.knwohowinfo.page.GameCoreMap;
import com.knwohowinfo.page.GameDialog;
import com.knwohowinfo.page.GameList;
import com.knwohowinfo.page.GameMap;
import com.knwohowinfo.page.GameSet;
import com.knwohowinfo.page.GameStart;
import com.knwohowinfo.page.GameStop;
import com.knwohowinfo.page.Welcome;

/**
 * @author Administrator
 * 
 *         ������
 */
public class MouseHandler extends MouseAdapter {

	private MainPanel panel = MainPanel.getInstance();

	private ArrayList<Rectangle> wlList = Welcome.getRectangles();

	private ArrayList<Rectangle> maList = GameMap.getRectangles();

	private ArrayList<Rectangle> abList = GameAbout.getRectangle();

	private ArrayList<Rectangle> stList = GameStart.getRectangle();

	private ArrayList<Rectangle> soList = GameStop.getRectangle();// ��Ϸ��ͣ

	private ArrayList<Rectangle> coreList = GameCoreMap.getRectangle();

	private ArrayList<Rectangle> diaList = GameDialog.getRectangle();

	private ArrayList<Rectangle> liList = GameList.getRectangle();

	private ArrayList<Rectangle> seList = GameSet.getRectangle();

	// ��Ϸ��ʼ�� ����ĵ�
	private ArrayList<Point> po = new ArrayList<Point>();

	private int pass;// ��¼�ؿ�

	private boolean option;

	private boolean option3;

	public MouseHandler() {
		init();
	}

	private void init() {

	}

	// ����
	@Override
	public void mousePressed(MouseEvent e) {

		// ����ֻ�ж���Ϸ��ʼ
		if (panel.flag == 1) {
			core(e.getX(), e.getY());
		}

	}

	// �ͷ�
	@Override
	public void mouseReleased(MouseEvent e) {

		// ��Ӧÿһ�εİ��²��� ��Ӧ��ͬ�Ļ���
		switch (panel.flag) {
		case -1:// ��ӭ����
			isBounds(e.getX(), e.getY());
			break;
		case 0:// ��Ϸ��ͼ����
			map(e.getX(), e.getY());
			break;
		case 1:// ��Ϸ����
				// ��Ϸ�������
			start(e.getX(), e.getY());
			size();
			break;
		case 2:
			break;
		case 3:// ������Ϸ
			about(e.getX(), e.getY());
			break;
		case 5:// ��ͣ
			stop(e.getX(), e.getY());
			break;
		case 6:// ��Ϸ�Ի���
			dialog(e.getX(), e.getY());
			break;
		case 8:// ���а�
			list(e.getX(), e.getY());
			break;
		case 9:// ��Ϸ����
			set(e.getX(), e.getY());
			break;
		}
	}

	// ��Ϸ����
	private void set(int x, int y) {
		int index = -1;
		for (int i = 0; i < seList.size(); i++) {
			Rectangle r = seList.get(i);
			if (r.contains(x, y - 30)) {
				index = i;
			}
		}
		// 0 ȷ�� //1 ����

		// 2������Ч 3 ����������

		switch (index) {
		case 0:// ȷ��
			panel.setGame();
			panel.control(1);
			break;
		case 1:
			panel.control(1);
			break;
		case 2:
			panel.gameSetUpdata(index);
			break;
		case 3:
			panel.gameSetUpdata(index);
			break;
		}
	}

	private void stop(int x, int y) {
		int index = -1;
		for (int i = 0; i < soList.size(); i++) {
			Rectangle r = soList.get(i);
			if (r.contains(x, y - 30)) {
				index = i;
			}
		}

		if (index != -1) {
			panel.control(1);
		}
	}

	private void list(int x, int y) {

		int index = -1;
		for (int i = 0; i < liList.size(); i++) {
			Rectangle r = liList.get(i);
			if (r.contains(x, y - 30)) {
				index = i;
			}
		}
		if (index != -1) {
			if (option3) {
				panel.control(1);
				option3 = false;
			} else {
				panel.control(-1);
			}
		}
	}

	// ��Ϸ�Ի���
	private void dialog(int x, int y) {
		int index = -2;
		for (int i = 0; i < diaList.size(); i++) {
			Rectangle r = diaList.get(i);
			if (r.contains(x, y - 30)) {
				index = i;
			}
		}
		switch (index) {
		case 0:// ȷ��
			index = getDiaNum(true);
			break;
		case 1:
			index = getDiaNum(false);
			break;// ȡ��
		default:
			return;
		}
		panel.control(index);
		if (index != 1) {
			panel.coreDefault();// ����Ĭ��
		}

	}

	private int getDiaNum(boolean boo) {
		int index = 0;
		if (boo) {// ���ȷ��
			switch (panel.getDiaNum()) {
			case 2:// ���˵�
				index = -1;
				break;
			case 3:// ����
				index = 0;// ������Ϸ��ͼ
				break;
			case 4:// Ӯ��
				index = 0;
				break;
			case 5:// �µ��ó�()
				DbUtil.getInstance().storePass(new Plan(0));// ���¶����ݿ��������
				index = 0;// ������Ϸ��ͼ����
				// ������Ϸ��ͼ���������ҲҪ���
				panel.mapBorder();
				break;
			}
		} else {// ���ȡ��
			switch (panel.getDiaNum()) {
			case 2:// ���˵�
				index = 1;
				break;
			case 3:// ����
				index = 0;
				break;
			case 4:// Ӯ��
				index = 0;
				break;
			case 5:// �µ���Ϸ
				index = -1;
				break;
			}
		}

		return index;
	}

	// �жϵ�ǰ�ĵ��Ƿ񳬹�����
	private void size() {
		if (po.size() == 2) {
			po.clear();
		}
	}

	// ��Ϸ�㷨
	private void core(int x, int y) {
		for (int i = 0; i < coreList.size(); i++) {
			Rectangle r = coreList.get(i);

			if (r.contains(x, y - 30)) {
				Point p = new Point(r.x, r.y);

				// ֻ�ܴ��벻��ͬx y ��ͼƬ
				if (po.indexOf(p) == -1) {
					po.add(new Point(p));
				}
				panel.coreUpdata(po);
			}
		}
	}

	private void start(int x, int y) {
		int index = -1;
		for (int i = 0; i < stList.size(); i++) {
			Rectangle r = stList.get(i);
			if (r.contains(x, y - 30)) {
				index = i;// ��ǰ����ڴ˷�Χ֮��
			}
		}
		if (index == -1) {
			return;
		}

		switch (index) {
		// ��Ϸ��ʼ����
		case 0:
			index = 5;// ��ͣ
			break;
		case 1:
			index = 6;// ���˵�
			panel.dialogUpdata(2);
			panel.diaSet(2);
			break;
		case 2:// ��Ϸ����
			index = 9;
			break;
		case 3:// ����
			index = 8;
			option3 = true;
			break;
		case 4:// ����
			index = 3;
			option = true;
			break;
		case 5:// ����
			panel.corePrompt();
			return;
		case 6:// ��ʾ
			panel.coreUpNum();
			return;
		}
		panel.control(index);
	}

	// ��Ϸ����
	private void about(int x, int y) {
		int index = -1;
		for (int i = 0; i < abList.size(); i++) {
			Rectangle r = abList.get(i);
			if (r.contains(x, y - 30)) {
				index = i;
			}
		}
		if (index != -1) {
			if (option) {
				panel.control(1);
				option = false;
			} else {
				panel.control(-1);
			}
		}
	}

	private void map(int x, int y) {

		int index = -1;

		for (int i = 0; i < maList.size(); i++) {
			Rectangle p = maList.get(i);
			if (p.contains(x, y - 30)) {
				index = i;// ��ǰ����ڴ˷�Χ֮��
			}
		}

		switch (index) {
		case -1:
			pass = 1;
			break;
		case 1:// �ؿ�
			pass = 1;
			panel.gameMap(1);// ���ƿ��
			break;
		case 2:
			pass = 2;
			panel.gameMap(2);
			break;
		case 3:
			pass = 3;
			panel.gameMap(3);
			break;
		case 4:
			pass = 4;
			panel.gameMap(4);
			break;
		case 5:
			pass = 5;
			panel.gameMap(5);
			break;
		case 6:
			pass = 6;
			panel.gameMap(6);
			break;
		case 7:
			pass = 7;
			panel.gameMap(7);
			break;

		case 8:// ������Ϸ
				// ���ѡ��ؿ���

			switch (pass) {
			case 0:// �����ѡ�� Ĭ�Ϸ糵��
			case 1:// �糵��
				panel.coreMap(0);
				break;
			case 2:// ���ŵ�
				panel.coreMap(1);
				break;
			case 3:// �ɿ�������
				panel.coreMap(2);
				break;
			case 4:// �޸���
				panel.coreMap(3);
				break;
			case 5:// ħ֮��
				panel.coreMap(4);
				break;
			case 6:
				panel.coreMap(5);
				break;
			case 7:
				panel.coreMap(6);
				break;
			}

			panel.control(1);
			break;
		case 9:// ���ز˵�
			panel.control(-1);
			break;
		}
	}

	private void isBounds(int x, int y) {
		// ��귶Χ�ж�
		int index = -1;
		for (int i = 0; i < wlList.size(); i++) {
			Rectangle p = wlList.get(i);
			if (p.contains(x, y - 30)) {
				index = i;
			}
		}
		if (index == -1) {
			return;
		}

		switch (index) {
		case 1:
			index = 2;
			break;
		case 2:
			index = 8;
			break;
		}
		panel.control(index);
	}

}
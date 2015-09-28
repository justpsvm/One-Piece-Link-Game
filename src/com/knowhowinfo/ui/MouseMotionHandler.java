package com.knowhowinfo.ui;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import com.knowhowinfo.util.ReadDataUtil;
import com.knwohowinfo.page.GameAbout;
import com.knwohowinfo.page.GameDialog;
import com.knwohowinfo.page.GameList;
import com.knwohowinfo.page.GameMap;
import com.knwohowinfo.page.GameSet;
import com.knwohowinfo.page.GameStart;
import com.knwohowinfo.page.GameStop;
import com.knwohowinfo.page.Welcome;

/**
 * @author admin
 * 
 *         ��궯������
 */
public class MouseMotionHandler extends MouseMotionAdapter {

	private MainPanel panel = MainPanel.getInstance();

	private ArrayList<Rectangle> weList = Welcome.getRectangles();

	private ArrayList<Rectangle> maList = GameMap.getRectangles();

	private ArrayList<Rectangle> stList = GameStart.getRectangle();

	private ArrayList<Rectangle> abList = GameAbout.getRectangle();

	private ArrayList<Rectangle> soList = GameStop.getRectangle();// ��Ϸ��ͣ

	private ArrayList<Rectangle> diaList = GameDialog.getRectangle();

	private ArrayList<Rectangle> liList = GameList.getRectangle();

	private ArrayList<Rectangle> seList = GameSet.getRectangle();

	private Integer num;

	public MouseMotionHandler() {
		init();
	}

	private void init() {

	}

	// �϶�
	@Override
	public void mouseDragged(MouseEvent e) {

	}

	// �ƶ�
	@Override
	public void mouseMoved(MouseEvent e) {
		// �õ���굱ǰ��x y ����
		int x = e.getX();
		int y = e.getY();
		switch (panel.flag) {
		case -1:
			welcome(x, y);// ��Ϸ��ӭ����
			break;
		case 0:
			map(x, y);
			break;
		case 1:// ��Ϸ��ʼ
			start(x, y);
			break;
		case 2:// �µ��ó�
			break;
		case 3:// ������Ϸ
			about(x, y);
		case 5:// ��ͣ��Ϸ
			stop(x, y);
			break;
		case 6:// ��Ϸ�Ի���
			dialog(x, y);
			break;
		case 7:// ���а�
			list(x, y);
			break;
		case 8:// ����
			list(x, y);
			break;
		case 9:// ��Ϸ����
			set(x, y);
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
		if (index != 2 || index != 3) {
			panel.gameSet(index);
		}
	}

	// ��Ϸ���а�
	private void list(int x, int y) {
		int index = -1;
		for (int i = 0; i < liList.size(); i++) {
			Rectangle r = liList.get(i);
			if (r.contains(x, y - 30)) {
				index = i;
			}
		}
		panel.listUpdata(index);
	}

	// ��Ϸ�Ի���
	private void dialog(int x, int y) {
		int index = -1;
		for (int i = 0; i < diaList.size(); i++) {
			Rectangle r = diaList.get(i);
			if (r.contains(x, y - 30)) {
				index = i;
			}
		}
		panel.dialogUpdata(index);
	}

	private void stop(int x, int y) {
		int index = -1;
		for (int i = 0; i < soList.size(); i++) {
			Rectangle r = soList.get(i);
			if (r.contains(x, y - 30)) {
				index = i;
			}
		}
		panel.stopUpdata(index);
	}

	private void about(int x, int y) {
		int index = -1;
		for (int i = 0; i < abList.size(); i++) {
			Rectangle r = abList.get(i);
			if (r.contains(x, y - 30)) {
				index = i;
			}
		}
		panel.aboutUpdata(index);
	}

	private void start(int x, int y) {
		int index = -1;
		for (int i = 0; i < stList.size(); i++) {
			Rectangle r = stList.get(i);
			if (r.contains(x, y - 30)) {
				index = i;
			}
		}
		panel.startUpdata(index);
	}

	private void map(int x, int y) {

		int index = -1;

		int number = shift();

		for (int i = 0; i < maList.size(); i++) {
			Rectangle r = maList.get(i);
			if (r.contains(x, y - 30)) {
				index = i;
			}
		}

		if (index <= number || index == 8 || index == 9 || index == -1) {
			panel.mapUpdata(index);
		} else {
			panel.mapUpdata(520);
		}

	}

	private int shift() {
		// ���ݿ�Ķ�ȡ
		return ReadDataUtil.getPass();
	}

	// ��귶Χ�ж�
	private void welcome(int x, int y) {
		int index = -1;
		for (int i = 0; i < weList.size(); i++) {
			Rectangle r = weList.get(i);
			if (r.contains(x, y - 30)) {
				index = i;
			}
		}
		if (num == null) {
			num = index;
			panel.welcomeUpdata(index);
		} else {
			if (num != index) {
				panel.welcomeUpdata(index);
				num = index;
			}
		}
	}
}

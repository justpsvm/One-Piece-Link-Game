package com.knowhowinfo.util;

import java.awt.Point;

import com.knowhowinfo.interfece.MainInterface;

/**
 * @author admin ��Ϸ�е���ѧ������
 */
public class MathUtil {

	// �õ���
	public static int getRow(int y) {
		return y / MainInterface.GAMECORE_IMAGE_HEIGHT;
	}

	// �õ���
	public static int getCol(int x) {
		return x / MainInterface.GAMECORE_IMAGE_WIDTH;
	}

	// �õ���
	public static Point getPoint(int row, int col) {
		return new Point(col * MainInterface.GAMECORE_IMAGE_WIDTH, row
				* MainInterface.GAMECORE_IMAGE_HEIGHT);
	}

}

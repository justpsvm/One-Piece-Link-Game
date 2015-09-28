package com.knowhowinfo.util;

import java.util.ArrayList;
import java.util.Collections;
import com.db4o.ObjectSet;
import com.knowhowinfo.util.DbUtil;
import com.knowhowinfo.util.List;
import com.knowhowinfo.util.Plan;

/**
 * @author admin ���ݵĶ�ȡ������
 */
public class ReadDataUtil {

	// �����ҵķ���
	public static ArrayList<Integer> getMark() {
		ArrayList<Integer> marks = new ArrayList<Integer>();
		ObjectSet<List> mark = DbUtil.getInstance().getMark();
		while (mark.hasNext()) {
			List i = mark.next();
			marks.add(i.getMark());
		}
		// ����������������
		Collections.sort(marks);

		return marks;
	}

	// ������ڵ���Ϸ�ؿ�
	public static int getPass() {
		int index = -1;
		ObjectSet<Plan> pa = DbUtil.getInstance().getPass();
		while (pa.hasNext()) {
			Plan p = pa.next();
			index = p.getPass();
			break;
		}

		// ��Źؿ�
		switch (index) {
		case -1:// ���ݿ���û���ļ���ʱ��
		case 0:
			index = 1;
			break;
		case 1:
			index = 2;
			break;
		case 2:
			index = 3;
			break;
		case 3:
			index = 4;
			break;
		case 4:
			index = 5;
			break;
		case 5:
			index = 6;
			break;
		case 6:
			index = 7;
			break;
		}

		return index;
	}
}

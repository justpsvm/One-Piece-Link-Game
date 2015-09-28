package com.knowhowinfo.util;

import com.db4o.Db4oEmbedded;
import com.db4o.EmbeddedObjectContainer;
import com.db4o.ObjectSet;

/**
 * @author admin
 * 
 *         �����ݿ�ͳһ��������
 */
public class DbUtil {
	private String fileName = "data/data.db";

	private EmbeddedObjectContainer eoc;

	private static DbUtil util = new DbUtil();

	private DbUtil() {
		eoc = Db4oEmbedded.openFile(fileName);
	}

	public static DbUtil getInstance() {
		return util;
	}

	// ������������
	public void storeNum(List list) {
		ObjectSet<List> set = eoc.query(List.class);// ��ѯ
		if (set.size() > 2) {
			while (set.hasNext()) {
				List se = set.next();
				if (list.getMark() > se.getMark()) {
					se.setMark(list.getMark());// �޸�
					eoc.store(se);
					eoc.commit();// �ύ
					break;
				}
			}
		} else {
			eoc.store(list);
		}
	}

	// ȡ������
	public ObjectSet<List> getMark() {
		return eoc.query(List.class);
	}

	// ���뵱ǰ��Ϸ�Ľ���
	public void storePass(Plan plan) {
		ObjectSet<Plan> set = eoc.query(Plan.class);// ��ѯ
		if (set.size() != 0) {
			while (set.hasNext()) {
				Plan se = set.next();
				se.setPass(plan.getPass());// �޸�
				eoc.store(se);// ����
				eoc.commit();// �ύ
			}
		} else {
			eoc.store(plan);// ����
		}
	}

	// ��ȡ��Ϸ�Ľ���
	public ObjectSet<Plan> getPass() {
		return eoc.query(Plan.class);// ��ѯ;
	}

	// �رն������ݿ� �ͷ���Դ
	public void close() {
		eoc.close();
	}

}

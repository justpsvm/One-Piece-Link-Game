package com.knowhowinfo.ui;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;
import com.db4o.ObjectSet;
import com.knowhowinfo.interfece.MainInterface;
import com.knowhowinfo.util.AudioUtil;
import com.knowhowinfo.util.CoreUtil;
import com.knowhowinfo.util.DbUtil;
import com.knowhowinfo.util.List;
import com.knowhowinfo.util.Plan;
import com.knwohowinfo.page.*;

/**
 * @author admin �����
 */
public class MainPanel extends JPanel implements ActionListener {

	private GameMap map = new GameMap();

	private GameStop stop = new GameStop();// ��ͣ��Ϸ

	private GameStart start = new GameStart();// ��Ϸ��ʼ����

	private GameAbout about = new GameAbout();// ��Ϸ����

	private GameCoreMap core = new GameCoreMap();// ����������

	private Welcome welcome = new Welcome();// ��Ϸ��ӭ����

	private GameDialog dialog = new GameDialog();//

	private int auIndex;

	private GameList gList = new GameList();// ��Ϸ���а�

	private CoreUtil co = CoreUtil.getInstance();

	private GameSet set = new GameSet();// ��Ϸ����

	private AudioUtil audio = new AudioUtil();

	private BufferedImage buff;

	private Graphics pen;

	private Timer timer;

	public int flag = -1;// ���̿���

	private int index;

	private boolean boo2 = true;

	private boolean boo = true;

	private int music;

	private static MainPanel panle = new MainPanel();

	private MainPanel() {
		init();
		initComs();
	}

	// ʹ�õ���ģʽ
	public static MainPanel getInstance() {
		return panle;
	}

	private void initComs() {
		// ʹ��˫���弼��
		buff = new BufferedImage(MainInterface.GAMEMAP_SC_WIDTH,
				MainInterface.GAMEMAP_SC_HEIGHT, BufferedImage.TYPE_INT_ARGB);
		pen = buff.getGraphics();
	}

	// �ı䵱ǰ����
	public void control(int flag) {

		if (flag == 0) {// ��ͼ����
			playAudio(flag);
		}

		if (flag == -1) {// ֹͣȫ��������
			audio.wave1(true);
			audio.wave2(true);
			audio.wave3(true);
			audio.wave4(true);
			audio.wave5(true);
			audio.wave6(true);
			audio.wave7(true);
			audio.map(true);
		}

		if (flag == 4) {
			DbUtil.getInstance().close();// �ȹر����ݿ�
			System.exit(0);// �˳�����
			return;
		}

		this.flag = flag;
	}

	// ��Ч
	public void plauSound() {
		if (boo) {
			audio.sound();
		}
	}

	// ������
	public void playAudio(int index) {
		if (!boo2) {
			return;
		}
		this.music = index;

		switch (index) {
		case 0:// ���ŵ�ͼ����
			audio.wave1(true);
			audio.wave2(true);
			audio.wave3(true);
			audio.wave4(true);
			audio.wave5(true);
			audio.wave6(true);
			audio.wave7(true);

			audio.map(false);
			break;
		case 1:// ��һ��
			audio.map(true);
			audio.wave2(true);
			audio.wave3(true);
			audio.wave4(true);
			audio.wave5(true);
			audio.wave6(true);
			audio.wave7(true);

			audio.wave1(false);
			break;
		case 2:// �ڶ���
			audio.map(true);
			audio.wave1(true);
			audio.wave3(true);
			audio.wave4(true);
			audio.wave5(true);
			audio.wave6(true);
			audio.wave7(true);

			audio.wave2(false);
			break;
		case 3:// ������
			audio.map(true);
			audio.wave1(true);
			audio.wave2(true);
			audio.wave4(true);
			audio.wave5(true);
			audio.wave6(true);
			audio.wave7(true);

			audio.wave3(false);
			break;
		case 4:// ���Ĺ�
			audio.map(true);
			audio.wave1(true);
			audio.wave2(true);
			audio.wave3(true);
			audio.wave5(true);
			audio.wave6(true);
			audio.wave7(true);
			audio.wave4(false);
			break;
		case 5:// �����
			audio.map(true);
			audio.wave1(true);
			audio.wave2(true);
			audio.wave3(true);
			audio.wave4(true);
			audio.wave6(true);
			audio.wave7(true);
			audio.wave5(false);
			break;
		case 6:// ������
			audio.map(true);
			audio.wave1(true);
			audio.wave2(true);
			audio.wave3(true);
			audio.wave4(true);
			audio.wave5(true);
			audio.wave7(true);
			audio.wave6(false);
			break;
		case 7:// ���߹�
			audio.map(true);
			audio.wave1(true);
			audio.wave2(true);
			audio.wave3(true);
			audio.wave4(true);
			audio.wave5(true);
			audio.wave6(true);
			audio.wave7(false);
			break;
		}
	}

	private void init() {
		timer = new Timer(MainInterface.TIME, this);
		timer.setActionCommand("��ʱ��");
		timer.start();
	}

	// ����timer�Ƿ�����(ֹͣ)
	public void setTimer() {

		if (timer.isRunning()) {
			timer.stop();
		} else {
			timer.start();
		}

	}

	// ��ӭ����
	public void welcomeUpdata(int select) {
		welcome.updata(select);
	}

	// ��ͼ����
	public void mapUpdata(int select) {
		map.updata(select);
	}

	// ��ʼ����
	public void startUpdata(int select) {
		start.updata(select);
	}

	// ��Ϸ�ؿ�����ͼ�±�
	public void coreMap(int index) {
		this.index = index;
		core.setIndex(index);

	}

	// ���ڽ���
	public void aboutUpdata(int select) {
		about.updata(select);
	}

	// ��ͣ����
	public void stopUpdata(int select) {
		stop.updata(select);
	}

	// �ṩÿ�ε���ĵ�
	public void coreUpdata(ArrayList<Point> po) {
		core.setUpdata(po);
	}

	// ����Ĭ��
	public void coreDefault() {
		core.setDefault();// ����Ĭ��
		start.setDefault();// ��Ϸʱ��Ĭ��
	}

	// ��������ʾ
	public void corePrompt() {
		if (start.getPromptNum() == 0) {
			return;
		}
		start.setPromptNum();
		core.prompt();
	}

	// ����������
	public void coreUpNum() {
		if (start.getUpNum() == 0) {
			return;
		}
		start.setUpNum();
		core.upNum();
	}

	// ��Ϸ�Ի���
	public void dialogUpdata(int select) {
		dialog.setCommand(select);
	}

	// �õ���Ϸ�ĶԻ�����ʾ��Ϣ
	public int getDiaNum() {
		return dialog.getSelect();
	}

	// ��Ϸ���а�
	public void listUpdata(int select) {
		gList.Updata(select);
	}

	// ���õ�ͼ�߿�
	public void mapBorder() {
		map.inire();
		core.initIndex();
	}

	public void diaSet(int option) {
		if (option == 4) {// ���Ӯ��
			// ���������뵽���ݿ���
			if (start.getMark() != 0) {
				DbUtil.getInstance().storeNum(new List(start.getMark()));
			}
			// �õ���ǰ�ؿ�
			int index = core.getIndex();

			index++;

			ObjectSet<Plan> set = DbUtil.getInstance().getPass();

			if (set.size() == 0) {

				DbUtil.getInstance().storePass(new Plan(index));
			} else {
				int number = set.get(0).getPass();
				if (index > number) {
					// ����ؿ�
					DbUtil.getInstance().storePass(new Plan(index));
				}
			}
		}

		dialog.setDia(option);
	}

	// �õ���������ͼ
	public int[][] getMaps() {
		return core.getMaps();
	}

	// �ж��Ƿ��������
	public boolean isDelete(Point a, Point b) {
		return co.isDelete(a, b);
	}

	public void gameMap(int i) {
		map.setDraw(i);
	}

	// ��������
	public void gameSetUpdata(int index) {
		set.Updata(index);
	}

	// �鿴���� ��Ч״̬
	// ȷ�����ڵ��������
	public void setGame() {
		// ˵�������ȷ��

		boo = set.getIsDown();// ��Ч

		boo2 = set.getIsDown2();// ������

		if (false == boo2) {
			// ֹͣ�������ڷŵ�����
			audio.map(true);
			audio.wave1(true);
			audio.wave2(true);
			audio.wave3(true);
			audio.wave4(true);
			audio.wave5(true);
			audio.wave6(true);
			audio.wave7(true);
		} else {
			playAudio(music);
		}
	}

	public void gameSet(int index) {
		set.updata(index);

	}

	@Override
	public void paint(Graphics g) {

		switch (flag) {
		case -1:// ��ӭ����
			welcome.paint(pen);
			break;
		case 0:// ��ͼ����
			map.paint(pen);
			break;
		case 1:// ��ʼ��Ϸ����(�ؿ���)
			start.paint(pen);
			core.paint(pen);
			break;
		case 2:// �µ��ó�
			dialogUpdata(5);
			diaSet(5);
			flag = 6;
			break;
		case 3:// ������Ϸ
			about.paint(pen);
			break;
		case 5:// ��Ϸ��ͣ����
			stop.paint(pen);
			break;
		case 6:// ��Ϸ�Ի���
			dialog.paint(pen);
			break;
		case 8:
			gList.paint(pen);
			break;
		case 9:// ��Ϸ����
			set.paint(pen);
			break;
		}
		g.drawImage(buff, 0, 0, null);
	}

	// ����
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("��ʱ��".equals(cmd)) {
			repaint();
		}
	}

}

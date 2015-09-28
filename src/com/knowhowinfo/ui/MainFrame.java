package com.knowhowinfo.ui;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.knowhowinfo.interfece.MainInterface;

/**
 * @author admin ������
 */
public class MainFrame extends JFrame {

	private MainPanel panel = MainPanel.getInstance();

	private MouseHandler mouse = new MouseHandler();
	private MouseMotionHandler motion = new MouseMotionHandler();

	private File f = new File("image/image5.png");

	public MainFrame() {
		init();
		initComs();
		initListener();
	}

	private void initComs() {
		add(panel);
	}

	private void initListener() {
		// ������
		addMouseListener(mouse);

		// ��궯������
		addMouseMotionListener(motion);

	}

	private void init() {

		setTitle("������");
		setResizable(false);
		setSize(MainInterface.GAMEMAP_SC_WIDTH, MainInterface.GAMEMAP_SC_HEIGHT);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ���ó���ͼ��

		setIconImage(new ImageIcon("img/image2.jpg").getImage());

		// �޸����״̬
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image image = new ImageIcon(f.getAbsolutePath()).getImage();
		Cursor cursor = tk.createCustomCursor(image, new Point(5, 5), "stick");
		setCursor(cursor); // Ҳ�������������
	}
}

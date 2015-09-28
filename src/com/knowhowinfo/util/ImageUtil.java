package com.knowhowinfo.util;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ImageUtil {
	// ƴͼ
	public static void unionImgs() {
		JFileChooser jfc = new JFileChooser("D:\\Personal\\Desktop\\��������\\ͼƬ");
		jfc.setMultiSelectionEnabled(true);
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File[] files = jfc.getSelectedFiles();
			BufferedImage img = null;
			Graphics pen = null;
			try {
				img = ImageIO.read(files[0]);
				int litWidth = img.getWidth();
				int litHeight = img.getHeight();
				int rows = Integer.parseInt(JOptionPane.showInputDialog("��"));
				int cols = Integer.parseInt(JOptionPane.showInputDialog("��"));
				BufferedImage buff = new BufferedImage(litWidth * cols,
						litHeight * rows, BufferedImage.TYPE_INT_ARGB);// ͸��
				pen = buff.getGraphics();
				for (int i = 0; i < files.length; i++) {
					try {
						img = ImageIO.read(files[i]);
						pen.drawImage(img, i % cols * litWidth, i / cols
								* litHeight, litWidth, litHeight, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				ImageIO.write(buff, "png", new FileOutputStream("123.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

	}

	// ��ͼ
	public static ArrayList<BufferedImage> cutImage(String fileUrl, int rows,
			int cols, int nums) {
		ArrayList<BufferedImage> list = new ArrayList<BufferedImage>();
		try {
			BufferedImage img = ImageIO.read(new File(fileUrl));
			int lw = img.getWidth() / cols;
			int lh = img.getHeight() / rows;
			for (int i = 0; i < nums; i++) {
				BufferedImage buffImg = img.getSubimage(i % cols * lw, i / cols
						* lh, lw, lh);
				list.add(buffImg);
			}
			return list;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}

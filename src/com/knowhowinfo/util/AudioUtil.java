package com.knowhowinfo.util;

import java.applet.AudioClip;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * @author Administrator ��Ϸ�е���Ч ��������
 */
public class AudioUtil {
	private Player player;
	private Thread th;// ����һ���߳�
	private Thread th2;// ����һ���߳�

	public AudioUtil() {
		init();
	}

	private void init() {
		th = new Thread();
		th2 = new Thread();
	}

	@SuppressWarnings("deprecation")
	public void close() {
		th.stop();// ֹͣ���ֲ���
	}

	/**
	 * ��Ϸ�е���Ч
	 */
	public void sound() {
		th2 = new Thread(new Runnable() {
			@Override
			public void run() {
				// ѭ������
				try {
					player = new Player(new FileInputStream("Audio/sound.mp3"));
					player.play();
				} catch (JavaLayerException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		th2.start();// �߳�����
	}

	/**
	 * ��Ϸ��ͼ�е�����
	 */
	public void map(boolean boo) {
		if (boo) {
			th.stop();
			;

		} else {
			th.stop();
			;
			th = new Thread(new Runnable() {
				@Override
				public void run() {
					// ѭ������
					try {
						while (true) {
							player = new Player(new FileInputStream(
									"Audio/map.mp3"));
							player.play();
						}
					} catch (JavaLayerException e) {
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			});

			th.start();// �߳�����
		}
	}

	// ��һ��
	public void wave1(boolean boo) {

		if (boo) {
			th.stop();
		} else {
			th.stop();
			th = new Thread(new Runnable() {
				@Override
				public void run() {
					// ѭ������
					try {
						while (true) {
							player = new Player(new FileInputStream(
									"Audio/1.mp3"));
							player.play();
						}
					} catch (JavaLayerException e) {
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			th.start();// �߳�����
		}
	}

	// �� �� ��
	public void wave2(boolean boo) {

		if (boo) {
			th.stop();
		} else {
			th.stop();
			th = new Thread(new Runnable() {
				@Override
				public void run() {
					// ѭ������
					try {
						while (true) {
							player = new Player(new FileInputStream(
									"Audio/2.mp3"));
							player.play();
						}
					} catch (JavaLayerException e) {
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			});
			th.start();// �߳�����
		}

	}

	// ��3��
	public void wave3(boolean boo) {
		if (boo) {
			th.stop();
		} else {

			th.stop();
			th = new Thread(new Runnable() {
				@Override
				public void run() {
					// ѭ������
					try {
						while (true) {
							player = new Player(new FileInputStream(
									"Audio/3.mp3"));
							player.play();
						}
					} catch (JavaLayerException e) {
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			});
			th.start();// �߳�����
		}
	}

	// �� �� ��
	public void wave4(boolean boo) {

		if (boo) {
			th.stop();
		} else {
			th.stop();
			th = new Thread(new Runnable() {
				@Override
				public void run() {
					// ѭ������
					try {
						while (true) {
							player = new Player(new FileInputStream(
									"Audio/4.mp3"));
							player.play();
						}
					} catch (JavaLayerException e) {
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			});
			th.start();// �߳�����
		}
	}

	// �� �� ��
	public void wave5(boolean boo) {

		if (boo) {
			th.stop();
		} else {
			th.stop();
			th = new Thread(new Runnable() {
				@Override
				public void run() {
					// ѭ������
					try {
						while (true) {
							player = new Player(new FileInputStream(
									"Audio/5.mp3"));
							player.play();
						}
					} catch (JavaLayerException e) {
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			});
			th.start();// �߳�����
		}
	}

	// �� �� ��
	public void wave6(boolean boo) {
		if (boo) {
			th.stop();
		} else {
			th.stop();
			th = new Thread(new Runnable() {
				@Override
				public void run() {
					// ѭ������
					try {
						while (true) {
							player = new Player(new FileInputStream(
									"Audio/6.mp3"));
							player.play();
						}
					} catch (JavaLayerException e) {
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			});
			th.start();// �߳�����
		}
	}

	// �� �� ��
	public void wave7(boolean boo) {
		if (boo) {
			th.stop();

		} else {
			th.stop();
			th = new Thread(new Runnable() {
				@Override
				public void run() {
					// ѭ������
					try {
						while (true) {
							player = new Player(new FileInputStream(
									"Audio/7.mp3"));
							player.play();
						}
					} catch (JavaLayerException e) {
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			});
			th.start();// �߳�����
		}
	}
}

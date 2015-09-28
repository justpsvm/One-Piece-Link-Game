package com.knowhowinfo.interfece;

import java.awt.Color;
import java.awt.Font;
import java.io.File;

/**
 * @author Administrator ��Ϸ��ʹ�õĳ���
 */
public interface MainInterface {

	String FONT = "�����������԰�byС��_x!aocheng";

	String FONT2 = "����";

	int ROW = 9;
	int COL = 14;

	int GAMECORE_IMAGE_WIDTH = 60;
	int GAMECORE_IMAGE_HEIGHT = 60;

	// GameMap
	int GAMEMAP_SC_WIDTH = 830;

	int GAMEMAP_SC_HEIGHT = 622;

	// GameWelcomePanel

	String GAMEWELCOMEPANEL_BTN_KEEP = "�� �� �� Ϸ";

	String GAMEWELCOMEPANEL_BTN_START = "�� �� �� ��";

	String GAMEWELCOMEPANEL_BTN_SET = "�� Ϸ �� ��";

	String GAMEWELCOMEPANEL_BTN_ABOUT = "�� �� �� Ϸ";

	String gAMEWELCOMEPANEL_BTN_EXIT = "�� �� �� Ϸ";

	// Role
	int ROLE_SPEED = 5;
	int ROLE_IMAGE_HEIGHT = 160;

	// Color
	Color BORDER_COLOR = new Color(179, 108, 20);

	Color BORDER_COLOR_HYALINE = new Color(179, 108, 20, 50);

	Color Font_Color = new Color(51, 51, 51);

	// timerʱ��
	int TIME = 50;

	// ��Ϸ�ӳ�ʱ��(Loading)
	int DELAY_TIME = 3000;// 3��

	// ��Ϸ�е�����

	// ��Ϸ��ӭ
	File WELCOME_BACKGROUND_AUDIO = new File("Audio/Audio2.wav");

	// ���
	File MOUSE_AUDIO = new File("Audio/Audio3.wav");

	// ��ͼ�б�����
	File MAP_BACKGROUND_AUDIO = new File("Audio/Audio.wav");

	// ��Ϸ��ͼ�����˵:
	String COMMAND1 = "�糵��:·�ɴ�С����ļ���,����ð�յ���ʼ��,Ҳ����ֵ�����ǻ���ĵط���";

	String COMMAND2 = "����Ⱥ��:һ������˼��ĵ���,Ҳ��\"�ƽ𵺡��ƽ�Ĺ���\",��1000�׸߿յĿյ�(Sky Pyea)����ͬһ����,��״�������,400��ǰ,���ŵ���һ�뱻�������ĺ��������˸߿ա�";

	String COMMAND3 = "�ɿ�������:��ñ�����ź���ʿ�����ļ���,������һ����ƽ���õĴ���,�����������˶��������Ž����˲б���ͳ��,����ñ�����Ŵ��������,�����ֻص������õ����";

	String COMMAND4 = "�޸���:����Ϊ:\"��ʼ������ĳ���\",�������޽ܵĹ���,Ҳ���������ĵط�,������ǰ����������־,�������������ص���Ҳ����������";

	String COMMAND5 = "ħ֮��:\"�������亣\":�¹�Ī���Ǿ�ס�ĵط�,������·��һ�����Լ���������������, �������������б�\"�Ļ�\"-���޿�����,ʧȥȫ��ͬ��,�������������Ϊ:��Ϊ����,�Ż�ʧȥ��";

	String COMMAND6 = "ʥ����������:����������\"������\"�ܲ������ڵ�,λ��ΰ��·ǰ��κͺ���֮��,������½����,�˵صľ������������(������)";

	String COMMAND7 = "One Piece:����֮��-�����³����,ΰ��·���յ�վ,�����к�����֮���͵ĵط�,Ӣ��:\"ROUGH TALE\",��Ϊ:\"��̵Ĵ���\",·��һ�ﵽ�������³����������˵Ҳ����ʵ�����Լ�������!";

	// δ������ͼ˵��
	String COMMAND8 = "��ͼ��δ������ ";

	// �����Ϊ�ڹؿ���Χ��
	String COMMAND9 = "Come On!";

	// ABOUT
	Font F = new Font("����", Font.BOLD, 15);

	// ��Ϸ����ʧ�ĳ���
	int VALUE = -1;
}

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ending extends JFrame {
	// 게임 패널, 컨탠트팬으로 사용
	private JPanel gamePanel = new GamePanel("□", "⫸", 'q', 200);

	// 생성자 작성
	public Ending() {
		setTitle("Monster Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 게임 판넬의 객체화된 주소가 들어간다
		setContentPane(gamePanel);

		setSize(400, 400);
		setVisible(true);

		// 움직이며 찍는 것 (= 포커스)
		// 게임 판넬의 포커스를 활성 시켜라
		// = 마우스로 판넬에 이벤트를 주면 활성화된다
		gamePanel.setFocusable(true);

		// 키보드로 포커스를 입력 받을 수 있도록 설정
		gamePanel.requestFocus();
		
	}

	// 게임이 진행되는 패널
	// 배치관리자는 null로 설정한다
	public class GamePanel extends JPanel {
		// 사용자의 아이콘
		private String avatarChar;
		// 몬스터 아이콘
		private String monsterChar;
		// 종료키
		private char quitChar;
		// 몬스터가 움직이는 시간 간격
		private long monsterDelay;
		// 레이블 생성할 변수
		private JLabel avatar;
		private JLabel monster;
		// 아바타가 한번에 움직일 수 있는 픽셀 수
		private static final int AVATAR_MOVE = 10;

		// GamePanal("□", "⫸", 'q', 200)
		public GamePanel(String avatarChar, String monsterChar, char quitChar, long monsterDelay) {
			this.avatarChar = avatarChar;
			this.monsterChar = monsterChar;
			this.quitChar = quitChar;
			this.monsterDelay = monsterDelay;

			// 아바타와 괴물의 레이블 생성
			avatar = new JLabel(avatarChar);
			monster = new JLabel(monsterChar);

			// 아바타와 괴불의 레이블 위치를 마음대로 지정할 수 있도록 null로 설정
			setLayout(null);
			// 키 리스너 등록
			// MyKeyListener을 감자할 것이다.
			// 키보드로 아바타가 움직임이는 것을 감지할 것이다
			addKeyListener(new MyKeyListener());

			// 아바타 레이블의 위치설정
			avatar.setLocation(50, 150);
			// 아바타 크기 설정
			avatar.setSize(15, 15);
			// 아바타 색 설정
			avatar.setForeground(Color.blue);
			// 판넬에 부착
			add(avatar);

			// 괴물 레이블의 위치 설정
			monster.setLocation(200, 5);
			// 괴물 크기 설정
			monster.setSize(15, 15);
			// 판넬에 부착
			add(monster);

			// 괴물은 알아서 스레드가 움지겨줘야 하기 때문에
			// 움직이게 할 스레드 생성
			MonsterThread mt = new MonsterThread(monster, avatar, monsterDelay);
			mt.start();
		}

		// 키보드의 움직임을 감지하는 이벤트 리스너 구현
		// 게임 패널에 등록된 키 리스너
		// "상 하 좌 우" 키 등록과, 'q' 키를 종료키로 처리 할 수 있도록
		class MyKeyListener extends KeyAdapter {
			// 키를 눌렀을 때 실행 되도록 하는 곳
			@Override
			public void keyPressed(KeyEvent e) {
				// 종료 키는 유니코드 키값으로 넣어준다
				if (e.getKeyChar() == quitChar) {
					// 종료키가 입력되면 정상적으로 프로그램 종료
					System.exit(0);
				}

				int keyCode = e.getKeyCode();

				// 키 입력에 따라 아바타 레이블을
				// AVATAR_MOVE에 설정한 깂만큼 움직인다
				switch (keyCode) {
				// 위쪽 화살표를 클릭했을 때
				case KeyEvent.VK_UP:
					// 아바타의 x좌표 y좌표를 얻어와서
					// -10씩 움직인다(위로 움직이면 y 좌표값이 - 되니까)
					avatar.setLocation(avatar.getX(), avatar.getY() - AVATAR_MOVE);
					break;

				// 아래 화살표키
				case KeyEvent.VK_DOWN:
					// 아래로 가면 y좌표가 +되어 움직이니까
					avatar.setLocation(avatar.getX(), avatar.getY() + AVATAR_MOVE);
					break;

				// 왼쪽 화살표키
				case KeyEvent.VK_LEFT:
					// 왼쪽으로 가면 x좌표가 -되어 움직이니까
					avatar.setLocation(avatar.getX() - AVATAR_MOVE, avatar.getY());
					break;

				// 오른쪽 화살표키
				case KeyEvent.VK_RIGHT:
					// 오른쪽으로 가면 x좌표가 +되어 움직이니까
					avatar.setLocation(avatar.getX() + AVATAR_MOVE, avatar.getY());
					break;
				} // end switch

				// 아바타의 위치가 변경되었으니 다시 찍어준다(그려준다)
				// 이전에 위치하던 아바타를 지우고 다니 나타나게 해야 움직이는 것처럼 보이니까
				// 아바타의 부모 패널에게 다시 그리기를 지시함
				avatar.getParent().repaint();
			} // end KeyPressed
		}// end MyKeyListenr
	}

	// 괴물 작업 스레드 설정
	class MonsterThread extends Thread {
		// 좇아가는 괴물 레이블
		private JLabel from;
		// 도망가는 아바타 레이블
		private JLabel to;
		// 움직임 제어
		private long monsterDelay;
		// form 레이블이 한번에 움직일 수 있는 픽셀 수를 지정
		private static final int MONSTER_MOVE = 5;

		// new MonsterThread(monster, avatar, monsterDelay)
		public MonsterThread(JLabel monstar, JLabel avatar, long monsterDelay) {
			this.from = monstar;
			this.to = avatar;
			this.monsterDelay = monsterDelay;
		}

		@Override
		public void run() {
			// 현재 괴물의 위치
			int x = from.getX();
			int y = from.getY();

			boolean flag = true;
			
			while (flag) {
				// 아바타가 괴물의 왼쪽에 있는 경우
				if (to.getX() < from.getX()) {
					x = from.getX() - MONSTER_MOVE;
					// 아바타가 괴물의 오른쪽에 있는 경우
				} else {
					x = from.getX() + MONSTER_MOVE;
				}

				// 아바타가 괴물의 위쪽에 있는 경우
				if (to.getY() < from.getY()) {
					y = from.getY() - MONSTER_MOVE;
					// 아바타가 괴물의 아래쪽에 있는 경우
				} else {
					y = from.getY() + MONSTER_MOVE;
				}

				// 몬스터가 이용자를 잡으면 출력되도록함
				// 만약 같은 위치에 있을 경우
				// 오차범위를 줘야한다
				if (x > to.getX()- 10 && x < to.getX() + 10) {
					if (y > to.getY() - 10 && y < to.getY() + 10) {
						JOptionPane.showMessageDialog(null, "몬스터가 이겼습니다");
					}
				} else {
					// 200ms 동안 잠을 잔다
					try {
						sleep(monsterDelay);
					} catch (InterruptedException e) {
						return;
					}
				}
				
				try {
					sleep(monsterDelay);
				} catch (InterruptedException e) {
					return;
				}
				// 괴물의 위치 수정
				from.setLocation(x, y);
				// 괴물의 위치가 변경되었으니
				// 다시 그린다
				from.getParent().repaint();
			}
		}
	}

	public static void main(String[] args) {
		new Ending();
	}
}
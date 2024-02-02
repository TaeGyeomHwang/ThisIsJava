package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;

import constant.ViewState;
import model.StudentDAO;
import model.StudentDTO;

public class Main extends JFrame {
	
	private final LineBorder lb = new LineBorder(Color.black, 1, true);
	private final Main mainView;
	
	JTabbedPane tabbedPane;
	JInternalFrame internalFrame;
	JPanel topPanel, sidePanel, mainPanel, subPanel,insidePanel1, insidePanel2;
	JButton insertBtn, updateBtn, deleteBtn, absentBtn, tardyBtn, etcBtn, reportBtn;
	
	Set<Integer> temp = new HashSet<>();
	
	public Main() {
		mainView = this;
		getContentPane().add(getTopPanel(), BorderLayout.NORTH);
		getContentPane().add(new JScrollPane(getSidePanel()), BorderLayout.WEST);
		getContentPane().add(getTabbedPane(), BorderLayout.CENTER);
		
		setTitle("학생관리 프로그램");
		setBounds(500, 150, 1626, 1020);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		locationCenter();
		setVisible(true);
	}
	
	//배너(간판)
	private JPanel getTopPanel() {
		if(topPanel == null) {
			topPanel = new JPanel();
			JLabel topLabel = new JLabel("CODEHOWS");
			topLabel.setFont(new Font("굴림", Font.BOLD, 50));
			topPanel.add(topLabel);
		}
		return topPanel;
	}
	
	private JPanel getSidePanel() {
		if(sidePanel == null) {
			sidePanel = new JPanel();
			sidePanel.add(getInternalFrame());
		}
		return sidePanel;
	}
	
	private JTabbedPane getTabbedPane() {
		if(tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addTab("메인", getMainPanel());
			tabbedPane.addTab("서브", getSubPanel());
		}
		return tabbedPane;
	}
	
	//자리배치도(메인)
	private JPanel getMainPanel() {
		if(mainPanel == null) {
			mainPanel = new JPanel();
			mainPanel.setLayout(new GridLayout(4, 2, 500, 100));
			//추후 새로고침이 필요한 로직은 분리
			refreshSeatsList();
		}
		return mainPanel;
	}
	
	//서브 패널
	private JPanel getSubPanel() {
		if(subPanel == null) {
			subPanel = new JPanel();
		}
		return subPanel;
	}
	
	//사이드패널(인터널프레임)
	private JInternalFrame getInternalFrame() {
		if(internalFrame == null) {
			internalFrame = new JInternalFrame("학생 목록");
			internalFrame.getContentPane().add(getInsidePanel1(), BorderLayout.SOUTH);
			internalFrame.getContentPane().add(getInsidePanel2(), BorderLayout.NORTH);
			internalFrame.setVisible(true);
		}
		return internalFrame;
	}
	
	//사이드패널(하) - 버튼
	private JPanel getInsidePanel1() {
		if(insidePanel1 == null) {
			insidePanel1 = new JPanel();
			insidePanel1.setLayout(new GridLayout(0, 1, 0, 0));
			insidePanel1.add(getInsertBtn());
			insidePanel1.add(getUpdateBtn());
			insidePanel1.add(getDeleteBtn());
			insidePanel1.add(getAbsentBtn());
			insidePanel1.add(getTardyBtn());
			insidePanel1.add(getEtcBtn());
			insidePanel1.add(getReportBtn());
		}
		return insidePanel1;
	}
	
	//사이드패널(상) - 버튼
	private JPanel getInsidePanel2() {
		if(insidePanel2 == null) {
			insidePanel2 = new JPanel();
			insidePanel2.setLayout(new GridLayout(0, 1, 0, 0));
			//추후 새로고침이 필요한 로직은 분리
			refreshStudentList();
		}
		return insidePanel2;
	}
	
	//학생추가
	private JButton getInsertBtn() {
		if(insertBtn == null) {
			insertBtn = new JButton("학생 추가");
			insertBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//클릭 시 입력 폼 생성
					Info info = new Info(mainView, ViewState.CREATE);
					info.setVisible(true);
				}
			});
			insertBtn.setBorder(lb);
			insertBtn.setBackground(Color.GRAY);
			insertBtn.setForeground(Color.WHITE);
		}
		return insertBtn;
	}
	
	//학생수정
	private JButton getUpdateBtn() {
		if(updateBtn == null) {
			updateBtn = new JButton("학생 수정");
			updateBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//클릭 시 temp 내 선택된 모든 학생의 수정 폼 생성
					temp.forEach( t -> {
						Info info = new Info(mainView, ViewState.UPDATE, t);
						info.setVisible(true);
					});
				}
			});
			updateBtn.setBorder(lb);
			updateBtn.setBackground(Color.GRAY);
			updateBtn.setForeground(Color.WHITE);
		}
		return updateBtn;
	}
	
	//학생삭제
	private JButton getDeleteBtn() {
		if(deleteBtn == null) {
			deleteBtn = new JButton("학생 삭제");
			deleteBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//클릭 시 temp 내 선택된 모든 학생 삭제 확인
					int confirm = JOptionPane.showConfirmDialog(null, "선택된 모든 학생을 삭제하시겠습니까?", "confirm", JOptionPane.YES_NO_OPTION );
					//동의할 시 return 0
					if(confirm==0) {
						temp.forEach( s -> {
							StudentDAO.getInstance().deleteStudent(s);
						});
					}
					//삭제 후 학생 리스트, 자리배치도 새로고침
					refreshStudentList();
					refreshSeatsList();
				}
			});
			deleteBtn.setBorder(lb);
			deleteBtn.setBackground(Color.GRAY);
			deleteBtn.setForeground(Color.WHITE);
		}
		return deleteBtn;
	}
	
	private JButton getAbsentBtn() {
		if(absentBtn == null) {
			absentBtn = new JButton("결석 처리");
			absentBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//결석 처리 로직
				}
			});
			//스타일 추가
		}
		return absentBtn;
	}
	
	private JButton getTardyBtn() {
		if(tardyBtn == null) {
			tardyBtn = new JButton("지각 처리");
			tardyBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//지각 처리 로직
				}
			});
			//스타일 추가
		}
		return tardyBtn;
	}
	
	private JButton getEtcBtn() {
		if(etcBtn == null) {
			etcBtn = new JButton("기타 처리");
			etcBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//기타 처리 로직
				}
			});
			//스타일 추가
		}
		return etcBtn;
	}
	
	private JButton getReportBtn() {
		if(reportBtn == null) {
			reportBtn = new JButton("보고");
			reportBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//보고 로직
				}
			});
			//스타일 추가
		}
		return reportBtn;
	}
	
	public void refreshStudentList() {
		//사이드패널(상) 내 모든 체크박스 컴포넌트 삭제
		insidePanel2.removeAll();
		//temp 내 모든 선택된 학생 삭제
		temp.clear();
		//모든 학생 정보 조회
		StudentDAO.getInstance().getStudents().forEach(s -> {
			//각 학생마다 "학생이름(학번)"으로 체크박스 생성 
			JCheckBox chbx = new JCheckBox(s.getName()+" ("+s.getSno()+")");
			//클릭 시 동작
			chbx.addItemListener(new ItemListener() {
				@Override
				//변경 이벤트 발생 시 처리
				public void itemStateChanged(ItemEvent e) {
					//이벤트 객체로부터 타겟 받아옴
					JCheckBox target = (JCheckBox)e.getItem();
					//체크박스의 텍스트로부터 학번 분리
					int sno = Integer.parseInt(target.getText().split("\\(")[1].split("\\)")[0]);
					//체크박스가 미체크->체크 로 변경되면 temp에 추가
					if(target.isSelected()) temp.add(sno);
					//체크박스가 체크->미체크 로 변경되면 temp에서 삭제
					else temp.remove(sno);
				}
			});
			//위 텍스트 및 이벤트핸들러를 가진 체크박스 컴포넌트를 사이드패널(상)에 추가 -> 모든 학생에 대해 반복
			insidePanel2.add(chbx);
		});
		//인터널프레임이 자식 컴포넌트를 다시 배치하도록 지시
		this.internalFrame.revalidate();
	}
	
	public void refreshSeatsList() {
		//메인 패널 내 모든 그리드 패널 및 버튼 컴포넌트 삭제
		mainPanel.removeAll();
		for(int i=0; i<8; i++) {
			//패널 8개 1분단~8분단으로 분리
			JPanel seatsPanel = new JPanel();
			//한 패널 당 4자리로 분리
			seatsPanel.setLayout(new GridLayout(2, 2));
			for(int j=1; j<=4; j++) {
				//각 자리에 자리번호를 부여한 버튼 추가
				seatsPanel.add(setSeatNumbers(j+i*4));
			}
			//버튼 4개가 들어간 패널은 메인패널에 추가 -> 8번 반복
			mainPanel.add(seatsPanel);
		}
		//메인 패널이 자식 컴포넌트를 다시 배치하도록 지시
		this.mainPanel.revalidate();
	}
	private JButton setSeatNumbers(int seatNo) {
		//해당 자리에 배정된 학생이 있는지 조회
		StudentDTO std = StudentDAO.getInstance().getStudentBySeatNo(seatNo);
		JButton seat = null;
		//배정된 학생이 있으면  
		if(std.getSno()!=0) {
			//"학생이름(학번)"으로 버튼 생성
			seat = new JButton(std.getName() + " (" + std.getSno() + ")");
			seat.setFont(new Font("굴림", Font.BOLD, 25));
		//배정된 학생이 없으면
		} else {
			//"공석"으로 버튼 생성
			seat = new JButton("공석");
			seat.setFont(new Font("굴림", Font.BOLD, 25));
			seat.setForeground(new Color(192, 192, 192));
		}
		//각 버튼의 클릭시 이벤트 핸들러
		seat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//이벤트 객체로부터 버튼 객체 받아옴
				JButton clickedBtn = (JButton)e.getSource();
				//공석인 자리를 클릭한 경우
				if(clickedBtn.getText().equals("공석")) {
					//인원을 배치할지 확인
					int confirm = JOptionPane.showConfirmDialog(null, "인원을 배치하시겠습니까?", "confirm",JOptionPane.YES_NO_OPTION );
					//수락 시
					if(confirm==0) {
						//학번을 입력받아 해당 학생의 seatNumber 갱신
						try {
							int sno = Integer.parseInt(JOptionPane.showInputDialog("배치할 인원의 학번을 입력하세요."));
							StudentDAO.getInstance().updateSeatNumber(sno, seatNo);
						}catch(NumberFormatException ne) {
							JOptionPane.showMessageDialog(null,"숫자만 입력 가능합니다","확인",JOptionPane.WARNING_MESSAGE);
						}finally {
							refreshSeatsList();
						}
					}
				//공석이 아닌(배치된 자리)을 클릭한 경우
				}else {
					//해당 자리의 학번을 추출하여 학생 정보 창 생성
					int sno = Integer.parseInt(clickedBtn.getText().split("\\(")[1].split("\\)")[0]);
					Info info = new Info(mainView, ViewState.READ, sno);
					info.setVisible(true);
				}
			}
		});
		
		return seat;
	}
	
	//창 중앙 정렬
	private void locationCenter() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();
		int leftTopX = centerPoint.x - this.getWidth()/2;
		int leftTopY = centerPoint.y - this.getHeight()/2;
		this.setLocation(leftTopX, leftTopY);
	}

}

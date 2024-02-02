package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.regex.Pattern;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import constant.ViewState;
import exceptions.UnsuitableInputException;
import model.StudentDAO;
import model.StudentDTO;

public class Info extends JDialog {
	
	private Main mainView;
	private int sno;
	private final ViewState state;
	
	private JPanel infoPanel;
	private JLabel nameLabel;
	private JTextField nameInput;
	private JLabel birthLabel;
	private JTextField birthInput;
	private JLabel genderLabel; 
	private JPanel genderPanel;
	private JRadioButton maleBtn;
	private JRadioButton femaleBtn;
	private ButtonGroup genderInput;
	private JLabel mobileLabel;
	private JTextField mobileInput;
	private JLabel emailLabel;
	private JTextField emailInput;
	
	private JPanel btnGroup;
	private JButton cancelBtn;
	private JButton saveBtn;
	
	private final String EMAIL_FORMAT = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
	private final String PHONENUMBER_FORMAT = "^\\d{2,3}\\d{3,4}\\d{4}$";
	
	public Info(Main mainView, ViewState state) {
		//필드 초기화
		this.mainView = mainView;
		this.state = state;
		this.sno = 0;
		
    	//컴포넌트 초기화
		add(getInfoPanel(), BorderLayout.NORTH);
		add(getBtnGroup(), BorderLayout.SOUTH);
		initCompSize(new Dimension(140, 30));
        initEditable();
        
        //창 초기화
        setSize(280, 230);
        setResizable(false);
        setModal(true);
    	initTitle();
    	locationCenter();
    	pack();
    }
	
	public Info(Main mainView, ViewState state, int sno) {
		this(mainView, state);
		this.sno = sno;
        initStudentInfo();
    }
	
	//학생 정보 초기화
		private void initStudentInfo() {
			//학번으로 학생 조회 후 각 입력창에 초기화
			StudentDTO student = StudentDAO.getInstance().getStudentBySno(sno);
			nameInput.setText(student.getName());
			birthInput.setText(student.getBirth().toString());
			if(student.getGender().equals("남")) 
				maleBtn.setSelected(true);
			else 
				femaleBtn.setSelected(true);
			mobileInput.setText(student.getPhoneNumber());
			emailInput.setText(student.getEmail());
		}  
	
	//타이틀 초기화
	private void initTitle() {
		if(state == ViewState.UPDATE) {
    		setTitle("학생 수정");
    	}else if(state == ViewState.READ) {
    		setTitle("학생 정보");
    	}else if(state == ViewState.CREATE) {
    		setTitle("학생 추가");
    	}
	}
	
	//컴포넌트 크기 초기화
	private void initCompSize(Dimension d) {
		//그리드 레이아웃일 경우
		//가장 상위 컴포넌트만 사이즈 조절 시
		//모든 컴포넌트가 적용 받음
		nameLabel.setPreferredSize(d);
        nameInput.setPreferredSize(d);
	}
	
	//편집 가능 여부 초기화
	private void initEditable() {
		boolean editable = false;
		//생성 및 수정시 편집 가능
        if(state == ViewState.CREATE || state == ViewState.UPDATE) {
        	editable = true;
        //읽기 전용의 경우 편집 불가
    	}else if(state == ViewState.READ) {
    		editable = false;
    	}
        nameInput.setEditable(editable);
    	birthInput.setEditable(editable);
    	maleBtn.setEnabled(editable);
    	femaleBtn.setEnabled(editable);
    	mobileInput.setEditable(editable);
    	emailInput.setEditable(editable);
	}
	
	private JPanel getInfoPanel() {
		if(infoPanel == null) {
			infoPanel = new JPanel();
			//5행, 2열, 가로간격0, 세로간격3의 그리드 레이아웃
			infoPanel.setLayout(new GridLayout(5,2, 0, 3));
			
			nameLabel = new JLabel("이름");
			nameLabel.setHorizontalAlignment(JLabel.CENTER);
	        nameInput = new JTextField(20);
	        
	        birthLabel = new JLabel("생년월일");
	        birthLabel.setHorizontalAlignment(JLabel.CENTER);
	        birthInput = new JTextField(20);
	        
	        genderLabel = new JLabel("성별");
	        genderLabel.setHorizontalAlignment(JLabel.CENTER);
	        
	        genderInput = new ButtonGroup();
	        maleBtn = new JRadioButton("남");
	        maleBtn.setSelected(true);
	        femaleBtn = new JRadioButton("여");
	        genderInput.add(maleBtn);
	        genderInput.add(femaleBtn);
	        
	        genderPanel = new JPanel();
	        genderPanel.setLayout(new GridLayout(1,2));
	        genderPanel.add(maleBtn);
	        genderPanel.add(femaleBtn);
	        
	        mobileLabel = new JLabel("연락처");
	        mobileLabel.setHorizontalAlignment(JLabel.CENTER);
	        mobileInput = new JTextField(20);
	        
	        emailLabel = new JLabel("이메일");
	        emailLabel.setHorizontalAlignment(JLabel.CENTER);
	        emailInput = new JTextField(20);
	        
        	infoPanel.add(nameLabel);
	        infoPanel.add(nameInput);
	        infoPanel.add(birthLabel);
	        infoPanel.add(birthInput);
	        infoPanel.add(genderLabel);
	        infoPanel.add(genderPanel);
        	infoPanel.add(mobileLabel);
	        infoPanel.add(mobileInput);
        	infoPanel.add(emailLabel);
	        infoPanel.add(emailInput);
		}
		return infoPanel;
	}
	
	private JPanel getBtnGroup() {
		if(btnGroup == null) {
			btnGroup = new JPanel();
			btnGroup.setLayout(new GridLayout(1,2));
	        btnGroup.add(getCancelBtn());
	        if(state==ViewState.CREATE || state==ViewState.UPDATE)
	        	btnGroup.add(getSaveBtn());
		}
		return btnGroup;
	}
	
	private JButton getCancelBtn() {
		cancelBtn = new JButton("닫기");
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
            }
        });
        return cancelBtn;
	}
	
	private JButton getSaveBtn() {
		if(state == ViewState.CREATE) {
        	saveBtn = new JButton("추가");
	        saveBtn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	try {
	            		//유효성 검사 및 DTO객체 반환
	            		StudentDTO student = validateStudent();
	            		//저장 후 창닫기 및 학생 리스트 새로고침
	            		StudentDAO.getInstance().insertStudent(student);
	            		dispose();
	            		mainView.refreshStudentList();
	            		JOptionPane.showMessageDialog(null,"추가되었습니다","확인",JOptionPane.PLAIN_MESSAGE);
	            	}catch (ParseException pe) {
		            	JOptionPane.showMessageDialog(null,"생년월일(연-월-일) 형식이 잘못 입력되었습니다","확인",JOptionPane.WARNING_MESSAGE);
					}catch (UnsuitableInputException ue) {
						JOptionPane.showMessageDialog(null,ue.getMessage(),"확인",JOptionPane.WARNING_MESSAGE);
					}
	            }
	        });
    	}
        if(state == ViewState.UPDATE) {
        	saveBtn = new JButton("저장");
	        saveBtn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	try {
	            		//유효성 검사 및 DTO객체 반환
	            		StudentDTO student = validateStudent();
	            		//저장 후 창닫기 및 학생 리스트 새로고침
	            		StudentDAO.getInstance().updateStudent(student, sno);
	            		dispose();
	            		mainView.refreshStudentList();
	            		JOptionPane.showMessageDialog(null,"저장되었습니다","확인",JOptionPane.PLAIN_MESSAGE);
		            }catch (ParseException pe) {
		            	JOptionPane.showMessageDialog(null,"생년월일(연-월-일) 형식이 잘못 입력되었습니다","확인",JOptionPane.WARNING_MESSAGE);
					}catch (UnsuitableInputException ue) {
						JOptionPane.showMessageDialog(null,ue.getMessage(),"확인",JOptionPane.WARNING_MESSAGE);
					}
	            }
	        });
    	}
        return saveBtn;
	}
	
	//입력 폼 유효성검사
	private StudentDTO validateStudent() throws ParseException, UnsuitableInputException {
		StudentDTO student = new StudentDTO();
		
		student.setName(nameInput.getText().trim());
		
		//생년월일 8자리 형식이 아닐 경우 ParseException 발생
		student.setBirth(new Date(new SimpleDateFormat("yyyy-MM-dd")
			            				.parse(birthInput.getText().trim())
			            				.getTime()));
		
		Enumeration<AbstractButton> enums = genderInput.getElements();
		while(enums.hasMoreElements()) {
			JRadioButton jb = (JRadioButton)enums.nextElement();
			if(jb.isSelected())
				student.setGender(jb.getText().trim());
		}
		
		if(!Pattern.matches(PHONENUMBER_FORMAT, mobileInput.getText().trim()))
			throw new UnsuitableInputException("전화번호('-'없이 입력) 형식이 잘못 입력되었습니다");
		student.setPhoneNumber(mobileInput.getText().trim());
		
		if(!Pattern.matches(EMAIL_FORMAT, emailInput.getText().trim()))
			throw new UnsuitableInputException("이메일 형식이 잘못 입력되었습니다");
		student.setEmail(emailInput.getText().trim());
		
		return student;
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

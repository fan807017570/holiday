/*package com.zxzh.kjc.holiday.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.zxzh.kjc.holiday.common.ShellUtil;
import com.zxzh.kjc.holiday.entitiy.UserEntity;
import com.zxzh.kjc.holiday.service.impl.UserServiceImpl;

public class LoginDialog extends Dialog {
	private Shell shell;
	private Text usertext, pwdtext;
	private Button okbtn, cancelbtn;

	public LoginDialog(Shell parent, int style) {
		super(parent, style);
		this.shell=parent;
		// TODO Auto-generated constructor stub
	}

	public void creatContents() {
		// shell = new Shell(getParent(), getStyle());
//		shell.setSize(400, 200);
//		shell.setText("登录");
//		ShellUtil.setCenter(shell);
//		shell.setLayout(new GridLayout(2, false));

		Label lab1 = new Label(shell, SWT.None);
		lab1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lab1.setText("账户:");

		usertext = new Text(shell, SWT.BORDER);
		usertext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lab2 = new Label(shell, SWT.None);
		lab2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lab2.setText("密码:");

		pwdtext = new Text(shell, SWT.BORDER);
		pwdtext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);// 加上这一行以后，comp就是正常摆放

		Composite comp = new Composite(shell, SWT.NONE);
		comp.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		comp.setLayout(new FillLayout());
		okbtn = new Button(comp, SWT.NONE);
		okbtn.setText("确定");
		cancelbtn = new Button(comp, SWT.NONE);
		cancelbtn.setText("取消");
		addEvent();

	}

	private void addEvent(MainFrame mainFrame) {
		usertext.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.CR) {// 当按下的键为enter时，触发密码的text
					pwdtext.setFocus();
				}
			}
		});
		pwdtext.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.CR) {
					Event event = new Event();// 主动触发事件http://blog.csdn.net/cuser_online/article/details/6201340
					event.widget = okbtn;
					okbtn.notifyListeners(SWT.Selection, event);
				}
			}
		});
		okbtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				String userName = usertext.getText().trim();
				String pwdword = pwdtext.getText().trim();
				UserEntity user = new UserEntity();
				user.setPassWord(pwdword);
				user.setUserName(userName);
				int status;
				UserServiceImpl us = new UserServiceImpl();
				status = us.userLogin(user);
				if (status == -1) {
					MessageBox msg = new MessageBox(shell, SWT.OK);
					msg.setText("提示");
					msg.setMessage("用户名不存在");
					msg.open();
				} else if (status == 0) {
					MessageBox msg = new MessageBox(shell, SWT.OK);
					msg.setText("提示");
					msg.setMessage("密码错误");
					msg.open();
				} else if (status == 1) {
					// resultUser = user;
					MessageBox msg = new MessageBox(shell, SWT.OK);
					msg.setText("提示");
					msg.setMessage("登录成功");
					msg.open();
//					mainFrame.show();
//					shell.close();
					shell.close();
					Shell child = new Shell(shell, SWT.DIALOG_TRIM);
					child.setText("haha");
					child.setSize(100, 100);
					child.open();
					
				}
			}
		});
		cancelbtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
	}

}
*/
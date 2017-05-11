//package com.zxzh.kjc.holiday.common;
//
//import org.eclipse.swt.SWT;
//import org.eclipse.swt.layout.GridLayout;
//import org.eclipse.swt.widgets.Display;
//import org.eclipse.swt.widgets.Shell;
//import com.zxzh.kjc.holiday.ui.LoginDialog;
//
//public class SwtTest {
//	public static void main(String args[]) {
//		Display display = new Display();
//		Shell shell = new Shell(display, SWT.NO);
//		shell.setSize(400, 200);
//		shell.setText("登录");
//		ShellUtil.setCenter(shell);
//		shell.setLayout(new GridLayout(2, false));
//		shell.setLocation(10, 30);
//		LoginDialog login = new LoginDialog(shell, SWT.OK);
//		login.creatContents();
////		shell.dispose();
////		shell.remove
////		shell.setText("主窗体");
////		shell.setSize(1300,600);
//		shell.open();
//		while (!shell.isDisposed()) {
//			if (!display.readAndDispatch()) {
//				display.sleep();
//			}
//		}
//		display.dispose();
//	}
//
//}

/*package com.zxzh.kjc.holiday.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MainFrame extends Dialog {
	private Shell shell;
	private Display display;
	public MainFrame(Shell parent,Display  display) {
		super(parent);a
		this.shell=parent;
		this.display=display;
	}
	public void setProperties()
	{
		//设置窗体的各种属性
	}
	public void addComponents()
	{
		
	}
	public void addEvent()
	{
		
	}
	public   void show()
	{
		shell.setText("主窗体");
		shell.setSize(1300,600);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	public static void main(String args [])
	{
		Display display=new Display();
		Shell shell=new Shell(display);
		MainFrame mainFrame=new MainFrame(shell,display);
		mainFrame.show();
	}
	
}
*/
package com.zxzh.kjc.holiday.common;
import org.eclipse.swt.widgets.Shell;
//shell居中显示
public class ShellUtil {
	public static void setCenter(Shell shell){
		int width=shell.getMonitor().getClientArea().width;//电脑显示屏的宽度
		int height=shell.getMonitor().getClientArea().height;//电脑显示屏的高度
		int x=shell.getSize().x;//shell的宽度
		int y=shell.getSize().y;//shell的高度
		if(x>width){
			shell.getSize().x=width;
		}
		if(y>height){
			shell.getSize().y=height;
		}
		shell.setLocation((width-x)/2, (height-y)/2);
	}

}

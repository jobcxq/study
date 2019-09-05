package com.cxq.java.io.file.application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class File extends java.io.File {
	
	private static final long serialVersionUID = 1L;
	
	private String fileName;		//文件名
	private String filePath;		//文件路径
	private boolean isDir;			//是否文件夹
	private double fileSize;		//文件大小
	private String fileSizeUnit;	//文件大小表示的单位(B、KB、MB、GB、TB)
	private String name;			//文件名称（不含后缀）
	private String suffix;			//文件后缀名
	private List<File> children;	//子文件

	public File(String pathname) {
		super(pathname);
		System.out.println(pathname);
		writeLog("E:/log.txt",pathname + "\r\n");
		this.fileName = super.getName();
		this.filePath = this.getAbsolutePath();
		if(!this.isDirectory()){
			if(this.isFile() && !this.isHidden()){
				this.isDir = false;
				//文件名称和后缀
				int index = this.fileName.lastIndexOf(".");
				if(index >= 0){
					this.name = this.fileName.substring(0, index);
					this.suffix = this.fileName.substring(index + 1);
				}else{
					this.name = this.fileName;
				}
				//文件大小
				this.initFileSize();
			}
		}else{
			this.isDir = true;
			this.fileSize = 0;
			this.name = this.fileName;
			// TO 子文件
			java.io.File[] files = this.listFiles();
			if(files != null && files.length > 0){
				for(java.io.File f : files){
					if(this.children == null){
						this.children = new ArrayList<File>();
					}
					File children = new File(f.getAbsolutePath());
					this.children.add(children);
				}
			}
		}
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public boolean isDir() {
		return isDir;
	}

	public void setDir(boolean isDir) {
		this.isDir = isDir;
	}

	public double getFileSize() {
		return fileSize;
	}

	public void setFileSize(double fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileSizeUnit() {
		return fileSizeUnit;
	}

	public void setFileSizeUnit(String fileSizeUnit) {
		this.fileSizeUnit = fileSizeUnit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public List<File> getChildrens() {
		return children;
	}

	public void setChildren(List<File> children) {
		this.children = children;
	}
	
	/**
	 * 初始化文件大小属性
	 * (B、KB、MB、GB、TB)
	 */
	private void initFileSize(){
		long length = this.length();
		//字节显示
		if(length < 100){							//0-100B
			this.fileSize = length;
			this.fileSizeUnit = "B";
		}else if(length < 1048576L){				//0.1-1024KB
			this.fileSize = length/1024D;
			this.fileSizeUnit = "KB";
		}else if(length < 1073741824L){				//1-1024MB
			this.fileSize = length/1024D/1024D;
			this.fileSizeUnit = "MB";
		}else if(length < 1099511627776L){			//1-1024GB
			this.fileSize = length/1024D/1024D/1024D;
			this.fileSizeUnit = "GB";
		}else{// if(length < 1125899906842624L){	//1-1024TB
			this.fileSize = length/1024D/1024D/1024D/1024D;
			this.fileSizeUnit = "TB";
		}
		
		BigDecimal b = new BigDecimal(this.fileSize);
		this.fileSize = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public void writeLog(String logPath,String message){
		FileInputStream is = null;
		FileOutputStream os = null;
		java.io.File log = null;
		java.io.File newLog = null;
		try {
			log = new java.io.File(logPath);
			if(!log.exists())
				log.createNewFile();
			newLog = new java.io.File(logPath.substring(0, logPath.lastIndexOf(".")) + "_new" + logPath.substring(logPath.indexOf(".")));
			is = new FileInputStream(log);
			os = new FileOutputStream(newLog);
			byte[] bytes = new byte[1024];
			int index = 0;
			while((index = is.read(bytes)) > 0){
				os.write(bytes, 0, index);
			}
			bytes = message.getBytes();
			os.write(bytes, 0, bytes.length);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("1");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("2");
		}finally{
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException("3");
				}
			}
			if(os != null){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException("4");
				}
			}
			if(log.exists()){
				log.delete();
			}
			if(newLog.exists()){
				newLog.renameTo(log);
			}
		}
	}
	
	public static void main(String[] args) {
		String log = "E:/log.txt";
//		String message = "12345陈小钦\r\n";
		File file = new File(log);
//		file.writeLog(log, message);
		System.out.println("ok");
		
		
	}
	
}

package com.qicheng.old.tool;

import java.io.File;

public class UploadFile {
	public String upload(String dir,File formFile) throws Exception {
/*yyw		Date date = new Date();
		// 取欲上传的文件的名字和长度
		String fname = formFile.getName();
		// 将上传时间加入文件名
		int i = fname.indexOf(".");
		String name = String.valueOf(date.getTime());
		String type = fname.substring(i + 1);
		fname = name + "." + type;
		InputStream streamIn = new InputStream(); // 创建读取用户上传文件的对象
		File uploadFile = new File(dir); // 创建把上传数据写到目标文件的对象
		if (!uploadFile.exists() || uploadFile == null) { // 判断指定路径是否存在，不存在则创建路径
			uploadFile.mkdirs();
		}
		String path = uploadFile.getPath() + "/" + fname;
		OutputStream streamOut = new FileOutputStream(path);
		int bytesRead = 0;
		byte[] buffer = new byte[8192];
		while ((bytesRead = streamIn.read(buffer, 0, 8192)) != -1) {
			streamOut.write(buffer, 0, bytesRead);
		}
		streamOut.close();
		streamIn.close();
		return fname; */
		return "";
	}
}

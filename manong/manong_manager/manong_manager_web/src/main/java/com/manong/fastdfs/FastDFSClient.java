package com.manong.fastdfs;

import org.apache.commons.lang3.StringUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.File;
import java.io.InputStream;

public class FastDFSClient {

    private static StorageClient1 storageClient1 = null;

    static {
        try {
            //获取配置文件
            String classpath = new File(FastDFSClient.class.getResource("/").getFile()).getCanonicalPath();

            String CONF_FILENAME= classpath + File.separator +"conf" + File.separator +"fdfs_client.conf";

            ClientGlobal.init(CONF_FILENAME);

            //获取触发器
            TrackerClient trackerClient = new TrackerClient(ClientGlobal.g_tracker_group);
            TrackerServer trackerServer = trackerClient.getConnection();

            //获取存储服务器
            StorageServer storeStorage = trackerClient.getStoreStorage(trackerServer);

            storageClient1 = new StorageClient1(trackerServer,storeStorage);

        } catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * 文件上传
     * @param  文件输入流
     * @param  文件名
     */
    public static String uploadFile(InputStream fis, String fileName) {
        try {

            NameValuePair[] meta_list = null;

            //将输入流写入file_buff数组
            byte[] file_buff = null;
            if (fis != null) {
                int length = fis.available();//获取与fis关联的文件的字节数
                file_buff = new byte[length];//创建了一个和文件大小一样的缓冲区，刚刚好
                fis.read(file_buff);
            }

            String fileid = storageClient1.upload_file1(file_buff, getFileExe(fileName),meta_list);

            return fileid;

        } catch (Exception e) {

            return  null;

        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }


    private static String getFileExe(String fileName){
        if(StringUtils.isBlank(fileName)||!fileName.contains(".")){
            return "";
        }else {
            return fileName.substring(fileName.lastIndexOf(".")+1);
        }
    }

}

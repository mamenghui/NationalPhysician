package com.example.demo.util.yxtUtils;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Component
public class Aliyununtils {

//    static  String  endpoint = OSSProperties.ALIYUN_ENDPOINT;
//    static String accessKeyId =OSSProperties.ALIYUN_ACCESS_ID;
//    static  String accessKeySecret = OSSProperties.ALIYUN_ACCESS_KEY;
//    static String bucketName = OSSProperties.ALIYUN_BUCKET;
//    static String fileHost = OSSProperties.ALIYUN_DIR;


    public static String upload(File file){

         String  endpoint = OSSProperties.ALIYUN_ENDPOINT;
         String accessKeyId =OSSProperties.ALIYUN_ACCESS_ID;
         String accessKeySecret = OSSProperties.ALIYUN_ACCESS_KEY;
         String bucketName = OSSProperties.ALIYUN_BUCKET;
         String fileHost = OSSProperties.ALIYUN_DIR;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String ds = formatter.format(new Date());
        if (file==null){
            return null;
        }
        //创建一个服务器
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        try {

        if (! ossClient.doesBucketExist(bucketName)){
            ossClient.createBucket(bucketName);
            CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
            createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
            ossClient.createBucket(createBucketRequest);
            System.out.println(3);

        }
        //创建文件路径
        String fileUrl = fileHost+"/"+(ds+"/"+"-"+file.getName());
        //上传文件
        PutObjectResult result = ossClient.putObject(new PutObjectRequest(bucketName,fileUrl,file));
        //设置权限 这里是公开读
        ossClient.setBucketAcl(bucketName,CannedAccessControlList.PublicRead);
        if (null != result) {
            String sf = "https://patentz1.oss-cn-beijing.aliyuncs.com/";
            //logger.info();
            return sf+fileUrl;
        }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
        }
        return null;
    }


    /**
     * 获取一个随机的文件名
     *
     * @param oranName 初始的文件名
     * @return 返回加uuid后的文件名
     */
    private static String getRandomImageName(String oranName) {
        //获取一个uuid 去掉-
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //查一下是否带路径
        int cutPoint = oranName.lastIndexOf("/") + 1;
        //如果存在路径
        if (cutPoint != 0) {
            //掐头 如果开头是/ 则去掉
            String head = oranName.indexOf("/") == 0 ? oranName.substring(1, cutPoint) : oranName.substring(0, cutPoint);
            //去尾
            String tail = oranName.substring(cutPoint);
            //返回正确的带路径的图片名称
            return head + uuid + tail;
        }
        //不存在 直接返回
        return uuid + oranName;
    }


    /**
     * 打印文件的存储地址
     *
     * @param fileURL 文件URL
     */
    private static void printUploadSuccessInfo(String fileURL) {
        //上传成功
        System.out.println("upload success， path = " + getRealName(fileURL));
    }

    /**
     * 获取存储在服务器上的地址
     *
     * @param oranName 文件名
     * @return 文件URL
     */
    private static String getRealName(String oranName) {
        return getURLHead() + oranName;
    }


    /**
     * 获取图片的URL头信息
     *
     * @return 返回url头信息
     */
    private static String getURLHead() {
        String  endpoint = OSSProperties.ALIYUN_ENDPOINT;
        String accessKeyId =OSSProperties.ALIYUN_ACCESS_ID;
        String accessKeySecret = OSSProperties.ALIYUN_ACCESS_KEY;
        String bucketName = OSSProperties.ALIYUN_BUCKET;
        String fileHost = OSSProperties.ALIYUN_DIR;

        //从哪个位置截取
        int cutPoint = endpoint.lastIndexOf('/') + 1;
        //http头
        String head = endpoint.substring(0, cutPoint);
        //服务器地址信息
        String tail = endpoint.substring(cutPoint);
        //返回结果
        return head + bucketName + "." + tail + "/";
    }

    /**
     * MultipartFile2File
     * @param multipartFile
     * @return
     */
    private static File transferToFile(MultipartFile multipartFile) {
        //选择用缓冲区来实现这个转换即使用java 创建的临时文件 使用 MultipartFile.transferto()方法 。
        File file = null;
        try {
            //获取文件名
            String originalFilename = multipartFile.getOriginalFilename();
            //获取最后一个"."的位置
            int cutPoint = originalFilename.lastIndexOf(".");
            //获取文件名
            String prefix = originalFilename.substring(0,cutPoint);
            //获取后缀名
            String suffix = originalFilename.substring(cutPoint + 1);
            //创建临时文件
            file = File.createTempFile(prefix, suffix);
            //multipartFile2file
            multipartFile.transferTo(file);
            //删除临时文件
            file.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    /**
     * 上传文件流
     *  @param oranFileName 上传到服务器上的文件路径和名称
     * @param file         来自本地的文件或者文件流
     */
    public static String uploadFileInputSteam(String oranFileName, MultipartFile file) {

        String  endpoint = OSSProperties.ALIYUN_ENDPOINT;
        String accessKeyId =OSSProperties.ALIYUN_ACCESS_ID;
        String accessKeySecret = OSSProperties.ALIYUN_ACCESS_KEY;
        String bucketName = OSSProperties.ALIYUN_BUCKET;


        // <yourObjectName>上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg
        String objectName = getRandomImageName(oranFileName);

        // 创建OSSClient实例。
       // OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        //创建一个服务器
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传文件流
        try (InputStream inputStream = new FileInputStream(transferToFile(file))) {
            //上传到OSS
            ossClient.putObject(bucketName, objectName, inputStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //上传成功 打印文件存储地址
        printUploadSuccessInfo(objectName);

        // 关闭OSSClient。
        ossClient.shutdown();

        //返回文件在服务器上的全路径+名称
        return getRealName(objectName);
    }

    /**
     * 通过文件URL反向解析文件名
     *
     * @param fileURL 文件URL
     * @return 原文件名
     */
    private static String getObjectName(String fileURL) {
        return fileURL.substring(getURLHead().length());
    }

    /**
     * 批量获取 objectName
     *
     * @param fileURLs url列表
     * @return objectName列表
     */
    private static List<String> getObjectNames(List<String> fileURLs) {
        //创建返回对象
        List<String> result = null;
        //迭代转换
        for (String item : fileURLs) {
            result.add(item.substring(getURLHead().length()));
        }
        return result;
    }
    /**
     * 从OSS中下载一个文件
     *
     * @param fileURL       文件的url
     * @param localFileName 下载到本地的文件名称
     */
    public static void downloadFileToLoacal(String fileURL, String localFileName) {
        String  endpoint = OSSProperties.ALIYUN_ENDPOINT;
        String accessKeyId =OSSProperties.ALIYUN_ACCESS_ID;
        String accessKeySecret = OSSProperties.ALIYUN_ACCESS_KEY;
        String bucketName = OSSProperties.ALIYUN_BUCKET;

        //将url解析成objectName
        String objectName = getObjectName(fileURL);

        //创建一个服务器
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        // 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
        ossClient.getObject(new GetObjectRequest(bucketName, objectName), new File(localFileName));

        // 关闭OSSClient。
        ossClient.shutdown();

    }



}

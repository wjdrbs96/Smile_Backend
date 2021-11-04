package com.smile.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.util.IOUtils;
import com.smile.error.FileUploadIOException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * created by Gyunny 2021/11/04
 */
@RequiredArgsConstructor
@Service
public class FileUploadService {

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.s3.dir}")
    private String dir;

    private final AmazonS3Client s3Client;

    public String upload(MultipartFile file) {
        try {
            String fileName = "/" + UUID.randomUUID() + "-" + file.getOriginalFilename();
            ObjectMetadata objMeta = new ObjectMetadata();

            byte[] bytes = IOUtils.toByteArray(file.getInputStream());
            objMeta.setContentLength(bytes.length);

            ByteArrayInputStream byteArrayIs = new ByteArrayInputStream(bytes);

            s3Client.putObject(new PutObjectRequest(bucket, dir + fileName, byteArrayIs, objMeta)
                    .withCannedAcl(CannedAccessControlList.PublicRead));

            return s3Client.getUrl(bucket, dir + fileName).toString();
        } catch (IOException e) {
            throw new FileUploadIOException("File Upload IO Exception!!");
        }
    }

}

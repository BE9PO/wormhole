package com.example.wormhole.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Service
public class CryptFileService {
    @Value("${upload.path}")
    private String uploadPath = "D:/temp";

    @Value("${upload.tempPath}")
    private String uploadTempPath = "D:/temp_Decrypt/";

    private static final String SALT = "fd00000aa8660b5b010006acdc0100000101000100010000";

    public String encryptBytes(byte[] bytes, String password, String fileName) throws IOException {
        BytesEncryptor bytesEncryptor = Encryptors.standard(password, SALT);
        byte[] encryptedBytes = bytesEncryptor.encrypt(bytes);
        OutputStream outputStream = new FileOutputStream(uploadPath + "/" + fileName);
        outputStream.write(encryptedBytes);
        outputStream.close();
        return uploadPath + fileName;
    }

    public byte[] decryptBytes(byte[] encryptedBytes, String password) throws IOException {
        BytesEncryptor bytesDecrypt = Encryptors.standard(password, SALT);
        return bytesDecrypt.decrypt(encryptedBytes);
    }

    public File getTempFile(byte[] decryptBytes, String fileName) throws IOException {
        File uploadTempDir = new File(uploadTempPath);
        if (!uploadTempDir.exists()) {
            uploadTempDir.mkdir();
        }
        File tempFile = new File(uploadTempDir, fileName);
        OutputStream outputStream;
        outputStream = new FileOutputStream(tempFile);
        outputStream.write(decryptBytes);
        outputStream.close();
        return tempFile;
    }

    public void delleteTempFile(File file) {
        if (file.exists()) {
            file.delete();
        }
    }


}

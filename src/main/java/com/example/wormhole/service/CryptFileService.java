package com.example.wormhole.service;

import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Service
public class CryptFileService {

        public String encryptFile(byte[] multiPartFile, String password, String nameFile) throws IOException {
        //String salt = KeyGenerators.string().generateKey();
        String salt = "fd00000aa8660b5b010006acdc0100000101000100010000";
        BytesEncryptor bytesEncryptor = Encryptors.standard(password, salt);
        byte[] encryptedBytes = bytesEncryptor.encrypt(multiPartFile);
        //создаем зашифрованый файл
        OutputStream outputStream = new FileOutputStream("D:/temp/" + nameFile);
        outputStream.write(encryptedBytes);
        outputStream.close();
        return "D:/temp/" + nameFile;
    }

    public byte[] decryptFile(byte[] multiPartFile, String password) throws IOException {
        String salt = "fd00000aa8660b5b010006acdc0100000101000100010000";
        BytesEncryptor bytesDecrypt = Encryptors.standard(password, salt);
        byte[] decrypted = bytesDecrypt.decrypt(multiPartFile);
        String sdsa = "s";
        return decrypted;
    }

}

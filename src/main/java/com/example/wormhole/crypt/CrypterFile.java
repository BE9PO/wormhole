package com.example.wormhole.crypt;

import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.keygen.KeyGenerators;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CrypterFile {


    //TODO replace file to bytes []?
    //TODO solt del?

    public String encryptFile(byte[] multiPartFile, String password, String nameFile) throws IOException {


        String salt = KeyGenerators.string().generateKey();
        BytesEncryptor bytesEncryptor = Encryptors.standard(password, salt);
        byte[] encryptedBytes = bytesEncryptor.encrypt(multiPartFile);
        //создаем зашифрованый файл
        OutputStream outputStream = new FileOutputStream("D:/temp/" + nameFile);
        outputStream.write(encryptedBytes);
        return "D:/temp/" + nameFile;
    }

    //TODO solt del?
    public static synchronized byte[] decryptFile(File file, String password) throws IOException {
        String salt = KeyGenerators.string().generateKey();
        BytesEncryptor bytesEncryptor = Encryptors.standard(password, salt);
        Path path = Paths.get(file.getAbsolutePath());
        InputStream inputStream = new FileInputStream(file);
        //Создаем поток байтов из файла.
        byte[] bytesFromFile = Files.readAllBytes(path);
        return bytesEncryptor.decrypt(bytesFromFile);
    }

}

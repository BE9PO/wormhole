package com.example.wormhole.controller;

import com.example.wormhole.crypt.CrypterFile;
import com.example.wormhole.domain.FileImage;
import com.example.wormhole.domain.Message;
import com.example.wormhole.repository.FileImageRepository;
import com.example.wormhole.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class MainController {

    private final MessageRepository messageRepository;
    private final FileImageRepository imageRepository;

    @Autowired
    public MainController(MessageRepository messageRepository, FileImageRepository imageRepository) {
        this.messageRepository = messageRepository;
        this.imageRepository = imageRepository;
    }

    @Value("${upload.path}")
    public String path;

    @GetMapping("/")
    public String greeting(Model model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Model model) {
        Iterable<Message> messages = messageRepository.findAll();
        model.addAttribute("messages", messages);
        return "main";
    }

    @PostMapping("/main")
    public String add(
            @RequestParam String text,
            @RequestParam("file") MultipartFile file,
            Model model
    ) throws IOException {
        Message n = new Message();
        if (file != null) {
            FileImage newFile = new FileImage();
            //TODO ПОТОК??
            CrypterFile crypterFile = new CrypterFile();

            String path = crypterFile.encryptFile(file.getBytes(), "asda", file.getName() + System.currentTimeMillis());

            newFile.setName("asd");
            newFile.setDateOfLoad(System.currentTimeMillis());
            newFile.setPathToFile(path);
            imageRepository.save(newFile);
        }
        n.setMessage(text);
        messageRepository.save(n);

        Iterable<Message> messages = messageRepository.findAll();
        model.addAttribute("messages", messages);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Model model) {
        Iterable<Message> messageList;

        if (filter.isEmpty()) {
            messageList = messageRepository.findAll();
        } else {
            messageList = messageRepository.findByMessage(filter);
        }
        model.addAttribute("messages", messageList);
        return "main";
    }
}

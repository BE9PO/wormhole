package com.example.wormhole.controller;

import com.example.wormhole.domain.Examination;
import com.example.wormhole.domain.FileImage;
import com.example.wormhole.domain.Message;
import com.example.wormhole.repository.ExaminationRepository;
import com.example.wormhole.repository.FileImageRepository;
import com.example.wormhole.repository.MessageRepository;
import com.example.wormhole.service.CryptFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.joda.DateTimeParser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class MainController {
    private final MessageRepository messageRepository;
    private final FileImageRepository imageRepository;
    private final ExaminationRepository examinationRepository;

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    public MainController(MessageRepository messageRepository, FileImageRepository imageRepository, FileImageRepository imageRepository1,
                          ExaminationRepository examinationRepository) {
        this.messageRepository = messageRepository;
        this.imageRepository = imageRepository1;
        this.examinationRepository = examinationRepository;
    }

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

    @GetMapping("/solve")
    public String solve(Model model) {
        Iterable<Examination> examinations = examinationRepository.findAll();
        model.addAttribute("exps", examinations);
        return "solve";
    }

    @PostMapping("/main")
    public String add(
            @RequestParam String text,
            @RequestParam("file") MultipartFile file,
            Model model
    ) throws IOException {
        Message newMessage = new Message();
        List<FileImage> fileImages = new ArrayList<>();
        FileImage fileImage = new FileImage();
        CryptFileService cryptFileService = new CryptFileService();

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            cryptFileService.encryptBytes(file.getBytes(), "1", resultFileName);
            InputStream inputStream = new FileInputStream(new File(uploadDir + "/" + resultFileName));
            byte[] decryptedBytes = cryptFileService.decryptBytes(inputStream.readAllBytes(), "1");
            File tempFile = cryptFileService.getTempFile(decryptedBytes, resultFileName);


            //file.transferTo(new File(uploadPath + "/" + resultFileName));
            file.transferTo(tempFile);
            fileImage.setName(resultFileName);
            fileImage.setDateOfLoad(System.currentTimeMillis());

        }


        fileImages.add(fileImage);
        newMessage.setMessage(text);
        newMessage.setImages(fileImages);
        //save fileImage
        imageRepository.save(fileImage);
        messageRepository.save(newMessage);
        Iterable<Message> messages = messageRepository.findAll();
        model.addAttribute("messages", messages);
        return "main";
    }


    @PostMapping("/filter")
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

    @PostMapping("/addExp")
    public String addExp(@RequestParam String code,
                         String agency,
                         String date,
                         Model model) {
        Examination examination = new Examination();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String investigator = auth.getName();
        //Date date = new Date(System.currentTimeMillis());
        examination.setCode(code);
        examination.setAgency(agency);
        examination.setInvestigator(investigator);
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        examination.setDateInput(localDate);

        examinationRepository.save(examination);
        return "/addExp";
    }

    @GetMapping("/addExp")
    public String addExp(Model model) {
        return "addExp";
    }

//    @PostMapping("/material")
//    public String material(@RequestParam Examination examination,
//                         Date output,
//                         String conclusion,
//                         Model model) {
//       Optional<Examination> examinationList = examinationRepository.findById(examination.getId());
//       Examination examination1Red = examinationList.get();
//
//       examination1Red.setDateOutput(output);
//
//
//        return "/material";
//    }


}

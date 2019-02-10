package com.example.wormhole.controller;

import com.example.wormhole.domain.Examination;
import com.example.wormhole.domain.User;
import com.example.wormhole.repository.ExaminationRepository;
import com.example.wormhole.repository.UserRepository;
import com.example.wormhole.util.AuthenticationUtil;
import com.example.wormhole.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ExaminationController {
    private final ExaminationRepository examinationRepository;
    private final UserRepository userRepository;

    @Autowired
    public ExaminationController(ExaminationRepository examinationRepository, UserRepository userRepository) {
        this.examinationRepository = examinationRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/material")
    public String editMaterial(@RequestParam String conclusions,
                               @RequestParam String dateOut,
                               @RequestParam String exmID,
                               Model model){
        Long id = Long.parseLong(exmID);
        Optional<Examination> examination = examinationRepository.findById(id);
        Examination editedExamination = examination.get();
        editedExamination.setDateOutput(DataUtil.getLocalDate(dateOut));
        editedExamination.setConclusions(conclusions);
        editedExamination.setCode("OK!!!!!!!");
        examinationRepository.save(editedExamination);//SAVING@!!!!


        return "redirect:/solve";
    }

    @GetMapping("/material")
    public String editMaterial(@RequestParam String exmID,
                               Model model){
        return "material";
    }

    @PostMapping("/addExp")
    public String addExp(@RequestParam String code,
                         String agency,
                         String date,
                         Model model) {
        Examination examination = new Examination();
        User user = userRepository.findByUsername(AuthenticationUtil.getAuthUserName());
        examination.setCode(code);
        examination.setAgency(agency);
        examination.setInvestigator(user.getNameAndLastName());
        examination.setDateInput(DataUtil.getLocalDate(date));
        examination.setDaysInProduction();
        examinationRepository.save(examination);
        return "/addExp";
    }

    @GetMapping("/addExp")
    public String addExp(Model model) {
        return "addExp";
    }
}

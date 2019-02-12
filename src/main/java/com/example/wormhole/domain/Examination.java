package com.example.wormhole.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

@Entity
public class Examination {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;

    private LocalDate dateInput;

    private LocalDate dateOutput;

    private LocalDate dateStop;

    private LocalDate resumed;

    private String investigator;

    private String conclusions;

    private String agency;

    private int daysInProduction;

    @ElementCollection(targetClass = TypeExamination.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "Examination_Type")
    @Enumerated(EnumType.STRING)
    private Set<TypeExamination> typeExaminations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getDateInput() {
        return dateInput;
    }

    public void setDateInput(LocalDate dateInput) {
        this.dateInput = dateInput;
    }

    public LocalDate getDateOutput() {
        return dateOutput;
    }

    public void setDateOutput(LocalDate dateOutput) {
        this.dateOutput = dateOutput;
    }

    public LocalDate getDateStop() {
        return dateStop;
    }

    public void setDateStop(LocalDate dateStop) {
        this.dateStop = dateStop;
    }

    public LocalDate getResumed() {
        return resumed;
    }

    public void setResumed(LocalDate resumed) {
        this.resumed = resumed;
    }

    public String getInvestigator() {
        return investigator;
    }

    public void setInvestigator(String investigator) {
        this.investigator = investigator;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getConclusions() {
        return conclusions;
    }

    public void setConclusions(String conclusions) {
        this.conclusions = conclusions;
    }

    public Set<TypeExamination> getTypeExaminations() {
        return typeExaminations;
    }

    public void setTypeExaminations(Set<TypeExamination> typeExaminations) {
        this.typeExaminations = typeExaminations;
    }

    public int getDaysInProduction() {
        return daysInProduction;
    }

    public void setDaysInProduction(int daysInProduction) {
        this.daysInProduction = daysInProduction;
    }

    public void setDaysInProduction() {
        if (dateOutput == null) {
            Period periodOfProduction = getDateInput().until(LocalDate.now());
            setDaysInProduction(periodOfProduction.getDays());
        } else if (dateOutput.isAfter(dateInput)) {
            Period periodOfProduction = getDateInput().until(getDateOutput());
            setDaysInProduction(periodOfProduction.getDays());
        }
    }

}

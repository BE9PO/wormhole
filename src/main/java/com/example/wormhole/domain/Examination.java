package com.example.wormhole.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Examination {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int code;

    private Date dateInput;

    private Date dateOutput;

    private Date dateStop;

    private Date resumed;

    private String investigator;

    private String agency;

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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getDateInput() {
        return dateInput;
    }

    public void setDateInput(Date dateInput) {
        this.dateInput = dateInput;
    }

    public Date getDateOutput() {
        return dateOutput;
    }

    public void setDateOutput(Date dateOutput) {
        this.dateOutput = dateOutput;
    }

    public Date getDateStop() {
        return dateStop;
    }

    public void setDateStop(Date dateStop) {
        this.dateStop = dateStop;
    }

    public Date getResumed() {
        return resumed;
    }

    public void setResumed(Date resumed) {
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

    public Set<TypeExamination> getTypeExaminations() {
        return typeExaminations;
    }

    public void setTypeExaminations(Set<TypeExamination> typeExaminations) {
        this.typeExaminations = typeExaminations;
    }
}

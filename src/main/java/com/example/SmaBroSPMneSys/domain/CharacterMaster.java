package com.example.SmaBroSPMneSys.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "character_master")
public class CharacterMaster {

    @Id
    @Column(name = "chara_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer charaId;

    @Column(name = "chara_name")
    private String charaName;

    @Column(name = "icon_path")
    private String iconPath;

    @Column(name = "create_user")
    private Integer createUser;

    @Column(name = "update_user")
    private Integer updateUser;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;
}
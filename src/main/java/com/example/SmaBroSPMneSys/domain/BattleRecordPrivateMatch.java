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
@Table(name = "battle_record")
public class BattleRecordPrivateMatch {

    @Id
    @Column(name = "battle_record_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer battleRecordId;

    @Column(name = "used_chara_id")
    private Integer usedCharaId;

    @Column(name = "enemy_chara_id")
    private Integer enemyCharaId;

    @Column(name = "win_or_lose")
    private boolean winOrLose;
    
    @Column(name = "create_user")
    private Integer createUser;

    @Column(name = "update_user")
    private Integer updateUser;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;
}
package com.example.SmaBroSPMneSys.form;

import java.io.Serializable;

import lombok.Data;
/**
 * ユーザー情報 リクエストデータ
 */
@Data
public class BattleRecordForm implements Serializable {
	private Integer usedCharaId;
    private Integer enemyCharaId;
    private Boolean winOrLose;
}
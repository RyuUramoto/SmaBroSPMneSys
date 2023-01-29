package com.example.SmaBroSPMneSys.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
/**
 * ユーザー情報 リクエストデータ
 */
@Data
public class BattleRecordForm implements Serializable {
	private Integer usedCharaId;
    
	@NotNull(message = "必須：対戦キャラを選択してください。")
	private Integer enemyCharaId;
    private Boolean winOrLose;
}
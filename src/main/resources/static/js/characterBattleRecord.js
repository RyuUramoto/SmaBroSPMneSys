/**
 * characterBattleRecord.js
 */
$('div[id^="chara-image-"]').on('click', function() {

	var thisCharaButton = $(this);
		
	//  キャラボタンを選択状態にする
	var images = $('div[id^="chara-image-"]'); 
	images.each(function(i, element){
		element.classList.remove("selected");
	})
	thisCharaButton.addClass("selected");
		
	//勝ちボタンと負けボタンに選択中のキャラIDを設定させる
	var buttons = $('input[id^=enemyCharaId]');
	console.log(buttons);
	buttons.each(function(i, element){
		element.value = thisCharaButton[0].id.replace("chara-image-", "");
	})
});

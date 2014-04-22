
// 画面ロード時
$(function(){
	
	// アクティビティの取得
	$.get('/admin/dashboard/acitivity', {}, function(data, status){
		
		// TODO
		// エラー時のハンドリング(designとか画面側要件次第）
		if (status != 'success') {
			return false;
		};
		
		// TODO
		// あとは、デザインきまたら、それに応じて、情報を正しく加工すること
		var body = "";
		for (key in data) {
			body += ('<span style="color: gray;">' + key + '</span>:&nbsp;&nbsp;' + data[key] + '<br />');
		}
		$('#dashboard-activity-area').html(
				body
		);

	});
	
	// アクティビティの取得
	$.get('/admin/dashboard/schedule', {}, function(data, status){
		
		// TODO
		// エラー時のハンドリング(designとか画面側要件次第）
		if (status != 'success') {
			return false;
		};
		
		// TODO
		// あとは、デザインきまたら、それに応じて、情報を正しく加工すること
		var body = "";
		for (key in data) {
			body += ('<span style="color: gray;">' + key + '</span>:&nbsp;&nbsp;' + data[key] + '<br />');
		}
		$('#dashboard-schedule-area').html(
				body
		);

	});
	
	// ラップの取得
	$.get('/admin/dashboard/lap', {"empNo": "A12152", "monthTerm": 4}, function(data, status){
		
		// TODO
		// エラー時のハンドリング(designとか画面側要件次第）
		if (status != 'success') {
			return false;
		};
		
		// TODO
		// あとは、デザインきまたら、それに応じて、情報を正しく加工すること
		var body = "";
		for (key in data) {
			body += ('<span style="color: gray;">' + key + '</span>:&nbsp;&nbsp;' + data[key] + '<br />');
		}
		$('#dashboard-lap-area').html(
				body
		);

	});
	
	// イベントの取得
	$.get('/admin/dashboard/event', {"jobTypeId": 1, "eventGroupId": 1}, function(data, status){
		
		// TODO
		// エラー時のハンドリング(designとか画面側要件次第）
		if (status != 'success') {
			return false;
		};
		
		// TODO
		// あとは、デザインきまたら、それに応じて、情報を正しく加工すること
		var body = "";
		for (key in data) {
			body += ('<span style="color: gray;">' + key + '</span>:&nbsp;&nbsp;' + data[key] + '<br />');
		}
		$('#dashboard-event-area').html(
				body
		);

	});
	

	
});
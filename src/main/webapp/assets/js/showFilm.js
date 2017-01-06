/**
 * @author 张镇涛
 */
$(function(){
	$.ajax({
		url:'getLanguage',
		type:'post',
		dataType:'json',
		success:function(data){
			for(var key in data){
				$("#selectLanguage").append("<option value='"+data[key]['languageId']+"'>"+data[key]['name']+"</option>");
			}
		},
		error:function(){
			alert("error2");
		}
	})
	$("#inputTitle").blur(function(){
		if($("#inputTitle").val().trim() == ""){
			$("#errorTitle").addClass("HTooltip shake animated");
			$("#errorTitle").show();
		}
	});
	$("#inputTitle").focus(function(){
		$("#errorTitle").hide();
	})
	$("#editDiv").on('hidden.bs.modal',function(e){
		$("#errorTitle").hide();
		$("#errorDescription").hide();
		$("#inputId").val("0");
	})
	$("#btnSubmit").click(function(){
		if($("#inputTitle").val().trim() != "" && $("#inputDescription").val().trim() != null){
			$("#editDiv").hide();
			var param = $("#formEdit").serialize();
			$.ajax({
				url:'updateFilm',
				data:param,
				success:function(data){
					if(data == 'success'){
						$.tooltip('OK, 操作成功！', 2500, true);
						$('#table').bootstrapTable('refresh', null);
						$("#formEdit")[0].reset();
					}else if(data == 'faild'){
						$.tooltip("操作失败！");
					}else{
						$.tooltip(data);
					}
				},
				error:function(){
					$.tooltip("出错了！！！");
				}
			});
		}
	})
})
	$("#table").bootstrapTable({
		columns:[{
			field:'state',
			checkbox:'true'
		},{
			field:'filmId',
			title:'Film ID',
			sortable:'true'
		},{
			field:'title',
			title:'Title',
			sortable:'true'
		},{
			field:'description',
			title:'Description',
			sortable:'true'
		},{
			field:'language.name',
			title:'Language',
			sortable:'true'
		},{
			formatter:'operateFormatter',
			title:'Operate',
			events:"operateEvents"
		}],
		search:'true',	//启用搜索框
		url:'showFilms',	//服务器url
		pagination:'true',	//启用分页
		sortName:'film_id',	//默认排序字段
		sidePagination:'server',	//服务器分页
		pageList:[10,20,50],	//可选择的每页记录数量
		showColumns:'true',
		showRefresh:'true',
		showToggle:'true',
		clickToSelect:'true',
		striped:'true'
	});
	window.operateEvents = {
		'click .edit':function(e,value,row){
			$("#inputId").val(row.filmId);
			$("#inputTitle").val(row.title);
			$("#inputDescription").val(row.description);
			$("#selectLanguage").val(row.language.languageId);
		}
	};
	function operateFormatter(value,row,index){
		return [
		        '<div class="text-center">',
		        '<a class="edit" href="javascript:void(0)" title="Edit" data-toggle="modal" data-target="#editDiv">',
		        '<i class="glyphicon glyphicon-pencil"></i>',
		        '</a>',
		        '</div>'
		        ].join('');
	}
	var $table = $('#table'),$remove = $('#delete');
	$(function(){
		$table.on('check.bs.table uncheck.bs.table check-all.bs.table uncheck-all.bs.table',function(){
			$remove.prop('disabled',!$table.bootstrapTable('getSelections').length);
		})
		$remove.click(function(){
			$.dialog('confirm','提示','确定删除？',0,function(){
				$.closeDialog(); 
				var ids = $.map($table.bootstrapTable('getSelections'),function(row){
					return row.filmId;
				});
				$.ajax({
					url:'deleteFilm',
					data:'ids='+ids,
					type:'post',
					success:function(data){
						if(data == 'success'){
							$.tooltip('OK, 操作成功！', 2500, true);
							$table.bootstrapTable('remove',{
								field:'filmId',
								values:ids
							});
							$remove.prop('disabled',true);
						}else if(data == 'faild'){
							$.tooltip('删除失败！！！');
						}else{
							$.tooltip('出现异常，无法删除！！！');
						}
					},
					error:function(){
						$.tooltip('My God, 出错啦！！！');
					}
				});
			});
		});
	});
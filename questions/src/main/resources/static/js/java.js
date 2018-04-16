$(function () {
    var pager = $('#java').datagrid().datagrid('getPager');
    pager.pagination({
        pageSize:10,
        pageList:[10,15,20]
    });
});
function formatOper(val,row,index){
    return '<input class="btn btn-success btn-sm" type="button" value="详情" onclick="editAs('+index+')">';
}
function changeOper(val,row,index) {
    if (val=='未解答'){
        return 'color:red;';
    }else {
        return 'color:green;';
    }
}
function doAdd() {
    $('#fmd').form('clear');
    $('#add').dialog('open').dialog('setTitle','新增面试题');
}
function addWeb() {
    $('#fmd').form('submit', {
        onSubmit: function(){
            if ($(this).form('validate')){
                return true;
            }
            return false;
        },
        success:function(data){
            if (data=='新增成功'){
                alert(data);
                $('#add').dialog('close');
            }else {
                alert(data);
            }
            $('#java').datagrid('reload');
        }
    });
}
function doSearch(){
    $('#java').datagrid('reload',{
        func:$('#func').val()
    });
}
function editAs(index,row) {
    $('#java').datagrid('selectRow',index);
    var row = $('#java').datagrid('getSelected');
    var flags=row.flag;
    $('#edit').dialog('open').dialog('setTitle','试题详情');
    $('#edm').form('load',row);//将行数据赋值给form表单
    $('#btn').linkbutton('disable');
    document.getElementById('answer').setAttribute("readonly",'readonly');
    document.getElementById('problem').setAttribute("readonly",'readonly');

}
function openEdit() {
    document.getElementById('answer').removeAttribute("readonly");
    $('#answer').focus();
    $('#btn').linkbutton('enable');
}
function editWeb() {
    $('#edm').form('submit', {
        onSubmit: function(){
            if ($(this).form('validate')){
                return true;
            }
            return false;
        },
        success:function(data){
            if (data=='解答成功'){
                alert(data);
                $('#edit').dialog('close');
            }else {
                alert(data);
            }
            $('#java').datagrid('reload');
        }
    });
}
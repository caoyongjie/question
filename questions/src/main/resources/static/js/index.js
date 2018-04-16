function doSearch(title,uri){
    if ($('#tt').tabs('exists', title)){
        $('#tt').tabs('select', title);
        var currentTab = $('#tt').tabs('getSelected');
        RefreshTab(currentTab);
    } else {
        var content = '<iframe scrolling="auto" frameborder="0"  src="'+uri+'" style="width:100%;height:100%;"></iframe>';
        $('#tt').tabs('add',{
            title:title,
            content:content,
            closable:true
        });
    }
}
function RefreshTab(currentTab) {
    var url = $(currentTab.panel('options')).attr('href');
    $('#tt').tabs('update', {
        tab: currentTab,
        options: {
            href: url
        }
    });
    currentTab.panel('refresh');
}

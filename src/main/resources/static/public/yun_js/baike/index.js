$(function() {
    var categoryData = {};
    formatCategory(function() {
        var cateHtml = template('cateTpl', {content: categoryData});
        $("#cateList").empty().html(cateHtml);
    })

    // getHotList();
    // function getHotList() {
        // var url = __appconfig.approot + 'www/baike/hotList';
    //     $.getJSON(url, function(json) {
    //         console.log(json);
    //         var hotHtml = template('hotTpl', json);
    //         $("#hotList").empty().html(hotHtml);
    //     });
    // }

    getTagList();    
    function getTagList() {
        var url = __appconfig.approot + 'www/baike/tagList';
        $.getJSON(url, function(json) {
            console.log(json);
            var tagHtml = template('tagTpl', json);
            $("#tagList").empty().html(tagHtml);
        });
    }


    //类别数据
    function formatCategory(ck) {
        if ($.isEmptyObject(categoryData)) {
            var categories = sessionStorage.categories;
            if (typeof categories == 'undefined' || categories == null) {
                var url = __appconfig.approot + 'www/category/findSubCategory';
                $.getJSON(url, function(json, textStatus) {
                    var x = -1, top = new Array();
                    for (var i = 0; i < json.content.length; i++) {
                        var current = json.content[i],
                            obj = {
                            id: current.id,
                            name: current.name
                        };
                        if (i == 0 || current.parent.id != top[x].id) {
                            x++;
                            top[x] = current.parent;
                            delete top[x].parent;
                            top[x].children = [];                        
                        }
                        top[x].children.push(obj);                    
                    }
                    categoryData = top;
                    sessionStorage.setItem('categories', JSON.stringify(categoryData));
                    ck();
                });
            } else {
                categoryData = JSON.parse(categories);
                ck();
            }
        } else {
            ck();
        }
    }
});
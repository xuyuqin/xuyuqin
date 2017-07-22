;(function($){
	$.fn.pageBar = function(obj){
        totalpags=obj.totalpags;
        nowpage=obj.number;
        domId=this;
        htmlStr=[];
        createHtml();
	
		function createHtml(){
	    	if( totalpags<1 || nowpage>totalpags ) {return false;}
	    	
	    	nowpage>1 ? htmlStr.push('<li class="prev"><a href="#">上页</a></li>') : htmlStr.push('<li class="disabled"><a href="#">上页</a></li>');
	    	
	    	if(totalpags<=7){
	    		forPage(1,totalpags);
	    	}else{
	    		if(nowpage<5){
	    			nowpage<4 ? forPage(1,4) : forPage(1,5);
	    			htmlStr.push('<li class="disabled"><a href="#">...</a></li>');
	    			htmlStr.push('<li><a href="#">'+totalpags+'</a></li>');
	    		}else{
	    			htmlStr.push('<li><a href="#">1</a></li>');
	    			htmlStr.push('<li class="disabled"><a href="#">...</a></li>');
		            if(totalpags-nowpage>2){
		                forPage(nowpage-2,nowpage+1);
		                htmlStr.push('<li class="disabled"><a href="#">...</a></li>');
		                htmlStr.push('<li><a href="#">'+totalpags+'</a></li>');
		            }else{
		                forPage(nowpage-2,totalpags);
		            }
	    		}
	    	}
		    nowpage<totalpags ? htmlStr.push('<li class="next"><a href="#">下页</a></li>') : htmlStr.push('<li class="disabled"><a href="#">下页</a></li>');
	        domId.html(htmlStr.join(""));
	    };
		function forPage( start, end){
        	for(var i=start; i<=end; i++){
        		if(i==nowpage){
        			htmlStr.push('<li class="active"><a href="#">'+i+'</a></li>');
        		}else{
        			htmlStr.push('<li><a href="#">'+i+'</a></li>');
        		}
        	}
        }
	}
	
	$.fn.categorySelect = function(obj) {
		selectedCategory = obj || '';
		$categorySelect = this;

        var categories = sessionStorage.categories;
        if(typeof categories == 'undefined' || categories == null){
            var url = '/yun/category/list';

            $.getJSON(url, function(json, textStatus) {
                var x = -1, top = new Array();
                for (var i = 0; i < json.list.length; i++) {
                    var current = json.list[i],
                        obj = {
                        id: current.id,
                        name: current.name
                    };
                    if (i == 0 || current.parent == null) {
                        x++;
                        top[x] = current;
                        top[x].children = [];                        
                    }
                    top[x].children.push(obj);                    
                }
                sessionStorage.setItem('categories', JSON.stringify(top));
                categoryCreate.call($categorySelect, top, selectedCategory);
            });
        } else{
            categoryCreate.call($categorySelect, JSON.parse(categories), selectedCategory);
        }
               

        function categoryCreate(data, selectedCategory){
            var html = '';
            for (var i = 0; i < data.length; i++) {
                html += '<optgroup label="' + data[i].name + '">';
                for (var j = 0; j < data[i].children.length; j++) {
                    if (selectedCategory != '' && (selectedCategory == data[i].children[j].id || selectedCategory == data[i].children[j].name)) {
                        html += '<option value="' + data[i].children[j].id + '" selected="selected">' + data[i].children[j].name + '</option>';
                    } else {
                        html += '<option value="' + data[i].children[j].id + '">' + data[i].children[j].name + '</option>';
                    }
                }
                html += '</optgroup>';
            }
            this.append(html); 
            this.selectpicker('refresh');
        }
	}

	
})(jQuery);

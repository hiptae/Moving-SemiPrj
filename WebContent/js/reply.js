var boardreplyService = (function() {
    function add(reply, success, error) {
        console.log("reply add");
        $.ajax({
            url:'/reply',
            type:'post',
            data: JSON.stringify(reply),
            contentType:'application/json; charset=utf-8',
            success,
            error
        })
    }
    
    function getList(param, success, error) {
        const bno = param.bno;
        let page;
        if(!param || param.page < 0) {
        	page = 1;
        }
        else {
			page = param.page;
		}
        const url = `/reply/pages/${bno}/${page}`;
        $.getJSON(url).done(function(res) {
			success(res.replyCnt, res.list);
		}).fail(error);
    }
    function remove(rno, success, error) {
        console.log("reply remove");
        $.ajax("/reply/"+rno, {type:'delete'}).done(success).fail(error);
    }
    function modify(reply, success, error) {
        console.log("reply modify");
        $.ajax("/reply/"+reply.rno, {
            type:'put',
            data:JSON.stringify(reply),
            contentType:'application/json; charset=utf-8',
        }).done(success).fail(error);
    }
    function get(rno, success, error) {
        console.log("reply get");
        $.getJSON("/reply/"+rno).done(success).fail(error);
    }
    function displayTime(timeValue) {
        var gap = new Date().getTime() - timeValue;

        if(gap < 1000 * 60 * 60 * 24) {
            return moment(timeValue).format("HH:mm:ss");
        }
        else {
        	return moment(timeValue).format("YYYY/MM/DD HH:mm:ss");
        }
    }
    return {add, getList, remove, modify, get, displayTime};
})();
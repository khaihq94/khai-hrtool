function filterGlobal () {
    $('table').DataTable().search(
        $('#searchInputText').val()
    ).draw();
}

$(document).ready(function() {
 
    $('#searchInputText').keyup(function () {
    	var searchKeyword = $('#searchInputText').val();
    	if (searchKeyword) {
    		$('#empTable').show();
    	}
    	else {
    		$('#empTable').hide();
    	}
    } );
} );
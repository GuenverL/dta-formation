API_PIZZAS ="http://localhost:8080/pizzeria-admin-app/api/rest/pizzas";

$(document).ready(function(){
    $.ajax({
        url:API_PIZZAS
    }).then(function(data) {
        var pizzas = data.map(function(pizza){
            var ligne ="<tr>"+
                            "<td>"+pizza.code+"</td>"+
                            "<td>"+pizza.nom+"</td>"+
                            "<td>"+pizza.prix+"</td>"+
                            "<td>"+pizza.categorie+"</td>"+
                            "<td>"+
								'<a type="button" class="btn btn-warning btn-block" href="edit?code='+pizza.code+'">Editer<span class="glyphicon glyphicon-pencil pull-right"></span>'+
								"</a>"+
							"</td>"+
							"<td>"+
								'<a type="button" class="btn btn-danger btn-block" id="delBtn" data-toggle="modal" href="#delModal" data-del-id="'+pizza.code+'">Supprimer<span class="glyphicon glyphicon-remove pull-right"></span>'+
								"</a>"+
							"</td>"
            return ligne;
        });


        $(".table-responsive tbody").html(pizzas);
    });
});

function deletePizza(code){
    $.ajax({
        url:API_PIZZAS+"/"+code,
        type:"DELETE"
    });
}

$("#delModal").on(
	"show.bs.modal",
    function(e) {
		var del = $(e.relatedTarget).data("del-id");
		console.log($(e.currentTarget).find('a[id="valBtn"]').attr('onclick', 'deletePizza("'+del+'")'));
});
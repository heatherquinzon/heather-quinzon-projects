var money = getMoney();

$(document).ready(function() {
    
    loadItems();
    
    $('#change-return').click(function(event){
        var itemId = $('#item-nmber').val;
        var getMoney = $('#money-shown').val();
        
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/money/' + getMoney.toString() + '/item/' + itemId.toString(),
            success: function(data) {
                alert('IDK');
            },
            error: function(data) {
                var errorMessage = data.responseJSON.message;
                $('#message-given').val(errorMessage);

                $('#change-message').val('Youve been returned: \n$' + getMoney );
            }
        });
        
    });
    
    getItem();

});

function loadItems(){
    var itemDiv = $('#items');
    
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/items',
        success: function(itemArray) {
            
            $.each(itemArray, function(index, item) {
                var id = item.id;
                var name = item.name;
                var price = item.price;
                var quantity = item.quantity;
                var message = item.message;
                
                if(quantity > 0){
                    var row = '<button type="button" class="col-md-4 btn btn-outline-warning" id="' + id + '">';
                        row += '<p>' + id + '</p>';
                        row += '<p>' + name + '</p>';
                        row += '<p>' + "$" + price + '</p>';
                        row += '<p>' + "Quantity Left: " + quantity + '</p>';
                        row += '</button>';
                }
                
                itemDiv.append(row);
                
                 $('#' + id).click(function() {
                     $('#item-number').val(id);
                });
                
            });
            
        },
        error: function() {
             $('#errorMessages')
                .append($('<li>')
                       .attr({class: 'list-group-item list-group-item-danger'})
                       .text('Error calling web service. Please try again later.'));
        }
    });
}

function getMoney(){
    var money = $('#money-shown').val(); 
    var intMoney = Number(money);
    
    $('#add-dollar').click(function() {
        intMoney = intMoney + 1;
        $('#money-shown').val(intMoney.toFixed(2));
    });
    
    $('#add-quarter').click(function() {
        intMoney = intMoney + 0.25;
        $('#money-shown').val(intMoney.toFixed(2));
    });
    
    $('#add-dime').click(function() {
        intMoney = intMoney + 0.10;
        $('#money-shown').val(intMoney.toFixed(2));
    });
    
    $('#add-nickel').click(function() {
        intMoney = intMoney + 0.05;
        $('#money-shown').val(intMoney.toFixed(2));
    });
}

function getItem(){
    $('#errorMessages').empty();
    
    $('#purchase').click(function(event) {
        var itemId = $('#item-number').val();
        var getMoney = $('#money-shown').val();
        
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/money/' + getMoney.toString() + '/item/' + itemId.toString(),
            success: function(data) {
                var quarters = data.quarters;
                var dimes = data.dimes;
                var nickels = data.nickels;
                var pennies = data.pennies;
                
                var changeString = quarters + ' quarter(s) \n';
                    changeString += dimes + ' dime(s) \n';
                    changeString += nickels + ' nickel(s) \n';
                    changeString += pennies + ' pennie(s) \n';
                
                $('#message-given').val('THANK YOU!');
                
                $('#change-message').val(changeString);
                $('#change-return').click(function() {
                    document.location.reload();
                });
                

            },
            error: function(data) {
                var errorMessage = data.responseJSON.message;
                $('#message-given').val(errorMessage);
                getMoney();
    
            }
        })
    });
   
}





//    Written By: Alireza Boroumandyar
// First Written: 2022-03-18
//   Last Update: 2022-03-21

// Java script for handling two CRUD operations

const HOST="http://localhost:8080";

// Create
function addTree(){
    const name=document.getElementById("name").value
    const age=document.getElementById("age").value
    const type=document.getElementById("typeName").value
    $.ajax({
        method:"post",
        url:`${HOST}/tree`,
        data:JSON.stringify({
            "name":name,
            "age":age,
            "typeId":type
        }),
        headers:{
            'Accept':'Application/json',
            'Content-Type':'application/json'
        }
    }).done((response)=>{
        alert("Tree created by id: "+response)
        clearForm()
    }).fail((xhrObj, textStatus) => {
        // An error is 400 or 500 comes from API
        if (xhrObj && xhrObj.responseJSON && xhrObj.responseJSON.message) {
            alert(xhrObj.responseJSON.message)
        } else if (xhrObj && xhrObj.responseText) {
            alert(xhrObj.responseText)
        } else if (xhrObj) {
            alert("Error happened on storing data")
        }
    })
}

// Read
function getTreeById(){
    const id=document.getElementById("id").value;
    $.ajax({
        method:"get",
        url:`${HOST}/tree/`+id,
        data:id,
        headers:{
            'Accept':'application/json',
            'Content-Type':'application/json'
        }
    }).done((response)=> {
        document.getElementById("name").value=response.name
        document.getElementById("age").value=response.age
        document.getElementById("typeName").value=response.typeName
    }).fail((xhrObj, textStatus) => {
        // An error is 400 or 500 comes from API
        if (xhrObj && xhrObj.responseJSON && xhrObj.responseJSON.message) {
            alert(xhrObj.responseJSON.message)
        } else if (xhrObj && xhrObj.responseText) {
            alert(xhrObj.responseText)
        } else if (xhrObj) {
            alert("Error happened on reading data")
        }
    })
}

function getTrees(){
    $.ajax({
        method:"get",
        url:`${HOST}/tree`,
        headers:{
            'Accept':'application/json',
            'Content-Type':'application/json'
        }
    }).done((response)=> {
        const area=document.getElementById("area");
        area.innerHTML="id, name,    age,typeName\n"
        response.forEach(element => {
            area.innerHTML=area.innerHTML+element.id+" "
            +element.name+" "+element.age+" "
            +element.typeName+"\n"
        });
    }).fail((xhrObj, textStatus) => {
        // An error is 400 or 500 comes from API
        if (xhrObj && xhrObj.responseJSON && xhrObj.responseJSON.message) {
            alert(xhrObj.responseJSON.message)
        } else if (xhrObj && xhrObj.responseText) {
            alert(xhrObj.responseText)
        } else if (xhrObj) {
            alert("Error happened on reading data")
        }
    })
}


// Update
function updateTree(){
    const id=document.getElementById("id").value;
    const name=document.getElementById("name").value
    const age=document.getElementById("age").value
    const type=document.getElementById("typeName").value
    $.ajax({
        method:"put",
        url:`${HOST}/tree/`+id,
        data:JSON.stringify({
            "name":name,
            "age":age,
            "typeId":type
        }),
        headers:{
            'Accept':'application/json',
            'Content-Type':'application/json'
        }
    }).done((response)=> {
        alert("Tree successfully updated")
        clearForm();
    }).fail((xhrObj, textStatus) => {
        // An error is 400 or 500 comes from API
        if (xhrObj && xhrObj.responseJSON && xhrObj.responseJSON.message) {
            alert(xhrObj.responseJSON.message)
        } else if (xhrObj && xhrObj.responseText) {
            alert(xhrObj.responseText)
        } else if (xhrObj) {
            alert("Error happened on reading data")
        }
    })
}

// Delete
function deleteTree(){
    const id=document.getElementById("id").value;
    $.ajax({
        method:"delete",
        url:`${HOST}/tree/`+id,
        data:id,
        headers:{
            'Accept':'application/json',
            'Content-Type':'application/json'
        }
    }).done((response)=> {
        alert("Record deleted successfully")
    }).fail((xhrObj, textStatus) => {
        // An error is 400 or 500 comes from API
        if (xhrObj && xhrObj.responseJSON && xhrObj.responseJSON.message) {
            alert(xhrObj.responseJSON.message)
        } else if (xhrObj && xhrObj.responseText) {
            alert(xhrObj.responseText)
        } else if (xhrObj) {
            alert("Error happened on reading data")
        }
    })
}

// function to clear old data from input form
function clearForm(){
    document.getElementById("id").value=""
    document.getElementById("name").value=""
    document.getElementById("age").value=""
    document.getElementById("typeName").value=""
}
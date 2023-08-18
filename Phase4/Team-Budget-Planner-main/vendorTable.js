var myData = [
   {"vendorId" : 0, "vendor_name" : "Jack", "project_name" : "Apollo Project","technology":"Python"},
   {"vendorId" : 1, "vendor_name" : "Peter", "project_name" : "Hermes Project","technology":"Java"},
   {"vendorId" : 2, "vendor_name" : "Mark", "project_name" : "Zeus Project","technology":"C++"}
]

var currentDealId = myData.length;

function CreateTableFromJSON() {    
   

   // EXTRACT VALUE FOR HTML HEADER. 
   // ('Deal ID', 'Deal Name', 'Category' and 'Price')
   var col = [];
   for (var i = 0; i < myData.length; i++) {
       for (var key in myData[i]) {
           if (col.indexOf(key) === -1) {
               col.push(key);
           }
       }
   }

   // CREATE DYNAMIC TABLE.
   var table = document.createElement("table");

   // CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.

   var tr = table.insertRow(-1);                   // TABLE ROW.

   for (var i = 0; i < col.length; i++) {
       var th = document.createElement("th");      // TABLE HEADER.
       th.innerHTML = col[i];
       tr.appendChild(th);
   }

   // ADD JSON DATA TO THE TABLE AS ROWS.
   for (var i = 0; i < myData.length; i++) {

       tr = table.insertRow(-1);

       for (var j = 0; j < col.length; j++) {
           var tabCell = tr.insertCell(-1);
           tabCell.innerHTML = myData[i][col[j]];
       }
       // Insert Extra Cell for the Delete Icon
       //TODO: Complete this
       var tabCell2 = tr.insertCell(-1);
       tabCell2.innerHTML = "<button onclick='DeleteRow(this)'> Delete </button>";

   }

   // FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
   var divContainer = document.getElementById("showData");
   divContainer.innerHTML = "";
   divContainer.appendChild(table);
}
function editVendor(){
   var vendorName = document.getElementById("vendorName").value;
   var vendorId = document.getElementById("vendorId").value;
   document.getElementById("vendorName").value="";
   document.getElementById("vendorId").value="";
   for(var i = 0; i < myData.length; i++){ 
      if ( myData[i].vendorId == vendorId) { 
         myData[i].vendor_name=vendorName; 
      }
  }
  console.log("Editing Vendor Name");
  console.log(myData);
  CreateTableFromJSON();
}
function editProjectName(){
   var projectName = document.getElementById("projectName").value;
   var vendorId = document.getElementById("vendorId2").value;
   document.getElementById("projectName").value="";
   document.getElementById("vendorId2").value="";
   for(var i = 0; i < myData.length; i++){ 
      if ( myData[i].vendorId == vendorId) { 
         myData[i].project_name=projectName; 
      }
  }
  console.log("Editing Project Name");
  console.log(myData);
  CreateTableFromJSON();
}
function editProjectTech(){
   var projectTech = document.getElementById("projectTech").value;
   var vendorId = document.getElementById("vendorId3").value;
   document.getElementById("projectTech").value="";
   document.getElementById("vendorId3").value="";
   for(var i = 0; i < myData.length; i++){ 
      if ( myData[i].vendorId == vendorId) { 
         myData[i].technology=projectTech; 
      }
  }
  console.log("Editing Technology ");
  console.log(myData);
  CreateTableFromJSON();
}

function AddNewDeal() {
   var clientName = document.getElementById("clientNameInput").value;
   var projectName = document.getElementById("projectNameInput").value;
   var projectManager = document.getElementById("projectManagerInput").value;


   document.getElementById("clientNameInput").value = "";
   document.getElementById("projectNameInput").value = "";
   document.getElementById("projectManagerInput").value = "";

   InsertRow(currentDealId, clientName, projectName, projectManager);
   console.log("Inserted Row");
   console.log(myData);

}

function InsertRow(dealId, clientName, projectName, projectManager) {
   myData.push({"vendorId": dealId, "vendor_name" : clientName, "project_name" : projectName, "technology":projectManager})
   currentDealId++;
   CreateTableFromJSON();

}

function DeleteRow(element) {
   //var dealId=element.parentNode.parentNode.rowIndex-1;
   var vendorId=element.parentNode.parentNode.firstChild.innerHTML;
   console.log(vendorId);
   for( var i = 0; i < myData.length; i++){ 
   
       if ( myData[i].vendorId == vendorId) { 
   
           myData.splice(i, 1); 
       }
   
   }
   CreateTableFromJSON();
   console.log("Deleted Row");
   console.log(myData);
}
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Clients</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>  Table of clients</h1>
<div style="text-align: center">
    <table class="table table-bordered border-primary" style="table-layout: auto; width: 100%;">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Created</th>
            <th>Updated</th>
            <th>Address</th>
            <th>Phone number</th>
            <th>Contact person</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <#list clients as client>
            <tr>
                <td>${client.id}</td>
                <td>${client.name}</td>
                <td>${client.description}</td>
                <td>${client.createdAt}</td>
                <td>${client.updatedAt}</td>
                <td>${client.address}</td>
                <td>${client.phoneNumber}</td>
                <td>${client.contactPerson}</td>
                <td>
                    <a href="/gui/clients/update/${client.id}">Update</a>
                </td>
                <td>
                    <a href="/gui/clients/delete/${client.id}">Delete</a>
                </td>
            </tr>
        </#list>
    </table>
    <a href="/gui/clients/create"><input type="button" class="btn btn-outline-primary" style="width: 100%;" value="Create"></a>
</div>
</body>
</html>
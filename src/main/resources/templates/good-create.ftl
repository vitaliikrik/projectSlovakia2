<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Good creation</title>
</head>
<body>
<h1>Good Creation</h1>
<div style="width: 60%; text-align: center">
    <fieldset>
        <legend>Good create</legend>
        <form name="good" action="" method="POST">
            Name:<@spring.formInput "form.name" "" "text"/>
            <br>
            Description:<@spring.formInput "form.description" "" "text"/>
            <br>
            Price:<@spring.formInput "form.price" "" "text"/>
            <br>
            Delivery types:<@spring.formMultiSelect "form.deliveryTypes" allDeliveryTypes ""/>
            <br>
            <input type="submit" value="Create"/>
        </form>
    </fieldset>
</div>
</body>
</html>
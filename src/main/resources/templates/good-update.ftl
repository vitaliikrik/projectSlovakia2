<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Good update</title>
</head>
<body>
<h1>Good Update</h1>
<div style="width: 60%; text-align: center">
    <fieldset>
        <legend>Good update</legend>
        <form name="good" action="" method="POST">
            name:<@spring.formInput "form.name" "" "text"/>
            <br>
            Description:<@spring.formInput "form.description" "" "text"/>
            <br>
            Price:<@spring.formInput "form.price" "" "text"/>
            <br>
            Delivery types:<@spring.formMultiSelect "form.deliveryTypes" allDeliveryTypes ""/>
            <br>
            <input type="submit" value="Update"/>
        </form>
    </fieldset>
</div>
</body>
</html>
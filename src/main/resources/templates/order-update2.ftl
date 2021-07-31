<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order update 2</title>
</head>
<body>
<h1>Order Update 2</h1>
<div style="width: 60%; text-align: center">
    <fieldset>
        <legend>Order update</legend>
        <form name="good" action="" method="POST">
            <@spring.formInput "form.client" "" "hidden"/>
            <@spring.formInput "form.good" "" "hidden"/>
            Description:<@spring.formInput "form.description" "" "text"/>
            <br>
            Delivery types:<@spring.formSingleSelect "form.deliveryType" validDeliveryTypes!'DELIVERY_TO_HOME' ""/>
            <br>
            Amount:<@spring.formInput "form.amount" "" "text"/>
            <br>
            Purchase date:<@spring.formInput "form.purchaseDate" "" "text"/>
            <br>
            <input type="submit" value="Update"/>
        </form>
    </fieldset>
</div>
</body>
</html>
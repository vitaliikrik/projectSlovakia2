<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order update</title>
</head>
<body>
<h1>Order Update</h1>
<div style="width: 60%; text-align: center">
    <fieldset>
        <legend>Order update</legend>
        <form name="good" action="" method="POST">
            Client:<@spring.formSingleSelect "form.client" clients ""/>
            <br>
            Good: <@spring.formSingleSelect "form.good" goods ""/>
            <br>
            <input type="submit" value="Update"/>
        </form>
    </fieldset>
</div>
</body>
</html>
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order creation</title>
</head>
<body>
<h1>Order Creation</h1>
<div style="width: 60%; text-align: center">
    <fieldset>
        <legend>Order create</legend>
        <form name="good" action="" method="POST">
            Client:<@spring.formSingleSelect "form.client" clients ""/>
            <br>
            Good: <@spring.formSingleSelect "form.good" goods ""/>
            <br>
            <input type="submit" value="Create"/>
        </form>
    </fieldset>
</div>
</body>
</html>
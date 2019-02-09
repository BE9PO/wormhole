<#import "parts/common.ftl" as c>
<@c.page>


    <form method="post">

        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputEmail4">Set conclusions</label>
                <input type="text" class="form-control" id="conclusions" name="conclusions" placeholder=".....">

                <label for="inputEmail4">Date</label>
                <input type="date" class="form-control" id="dateOut" name="dateOut">
            </div>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary">Edit</button>
    </form>

</@c.page>
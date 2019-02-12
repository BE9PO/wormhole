<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
    Add new user
    ${message!}
    <form action="/registration" method="post">
        <div class="form-group row">
            <label for="inputLogin3" class="col-sm-2 col-form-label">Name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="fullName" placeholder="Name">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputLogin3" class="col-sm-2 col-form-label">Surname</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="lastName" placeholder="Surname">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputLogin3" class="col-sm-2 col-form-label">Login name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="username" placeholder="user">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" name="password" placeholder="Password">
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </div>
        <div class="form-group row">
            <div class="col-sm-10">
                <button type="submit" class="btn btn-primary">Let me in!</button>
            </div>
        </div>
    </form>


















</@c.page>
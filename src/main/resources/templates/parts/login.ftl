<#macro login path isRegisterForm>
<form action="${path}" method="post">

    <div class="form-group">
        <div class="col-sm-6">
            <label for="exampleInputEmail1">User name</label>
            <input type="text" name="username" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                   placeholder="Enter text">
        </div>

    </div>

    <div class="form-group">
        <div class="col-sm-6">
            <label for="exampleInputPassword1"> Password: </label>
            <input type="password" name="password" class="form-control" id="exampleInputPassword1"
                   placeholder="Password">
        </div>
    </div>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <#if !isRegisterForm>
    <a href="/registration">Create acc</a>
    </#if>
    <button type="submit" class="btn btn-primary"><#if isRegisterForm>Sign up<#else >Login</#if></button>
    </form>
</#macro>

<#macro logout>
        <form action="/logout" method="post">
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
            <button type="submit" value="Sign Out" class="btn btn-primary">Log out</button>
        </form>
</#macro>
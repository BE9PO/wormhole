<#import "parts/common.ftl" as c>
<@c.page>

    <form method="post">

    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputEmail4">СodeExp</label>
            <input type="text" class="form-control" id="inputСodeExp" name="code" placeholder="Введите код экспертизы">
        </div>
    </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary">Sign in</button>
    </form>


</@c.page>
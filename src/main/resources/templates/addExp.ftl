<#import "parts/common.ftl" as c>
<@c.page>

    <form method="post">

    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputEmail4">examination code</label>
            <input type="text" class="form-control" id="inputСodeExp" name="code" placeholder="3.5/666">

            <label for="inputEmail4">Agency</label>
            <input type="text" class="form-control" id="inputAgency" name="agency" placeholder="KT or RU">

        </div>
    </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary">Add to database</button>
    </form>


</@c.page>
<#import "parts/common.ftl" as c>
<@c.page>

    <form method="post">

        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputEmail4">examination code</label>
                <input type="text" class="form-control" id="inputСodeExp" name="code" placeholder="3.5/666">
                <label for="inputEmail4">Agency</label>
                <select class="custom-select" id="inputAgency" name="agency">
                    <option selected>Choose...</option>
                    <option value="KT">KT</option>
                    <option value="REU">REU</option>
                </select>
                <label for="inputEmail4">Date</label>
                <input type="date" class="form-control" id="date" name="date">
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary">Add to database</button>
    </form>


</@c.page>
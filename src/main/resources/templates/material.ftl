<#import "parts/common.ftl" as c>
<@c.page>
    <form method="post">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputEmail4">Set conclusions</label>
                <select class="custom-select" id="inputAgency" name="conclusions">
                    <option selected>Choose...</option>
                    <option value="was not possible">was not possible</option>
                    <option value="message of impossibility">message of impossibility</option>
                    <option value="positive">positive</option>
                    <option value="negative">negative</option>
                </select>
                <label for="inputEmail4">Date</label>
                <input type="date" class="form-control" id="dateOut" name="dateOut">
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary">Edit</button>
    </form>
</@c.page>
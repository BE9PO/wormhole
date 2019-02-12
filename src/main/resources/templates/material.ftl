<#import "parts/common.ftl" as c>
<@c.page>


   <form method="post">

        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputEmail4">Set conclusions</label>
                <input type="text" class="form-control" id="conclusions" name="conclusions" placeholder=".....">



                <select class="custom-select" id="inputAgency" name="conclusions">
                    <option selected>Choose...</option>
                    <option value="was not possible">KT</option>
                    <option value="message of impossibility">REU</option>
                    <option value="Positive">REU</option>
                    <option value="Negative">REU</option>
                    <option value="СНДЗ">REU</option>
                </select>





                <label for="inputEmail4">Date</label>
                <input type="date" class="form-control" id="dateOut" name="dateOut">
            </div>
        </div>

        <input type ="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary">Edit</button>
    </form>

</@c.page>
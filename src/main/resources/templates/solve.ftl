<#import "parts/common.ftl" as c>
<@c.page>
    <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample"
            aria-expanded="false" aria-controls="collapseExample">
        Filter
    </button>
    <div class="collapse" id="collapseExample">
        <div class="card card-body">
            <form method="post">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputEmail4">Set code</label>
                        <input type="text" class="form-control" id="code" name="code" placeholder="3.5/.....">
                        <label for="inputEmail4">Date input</label>
                        <input type="date" class="form-control" id="dateInput" name="dateInput">
                        <label for="inputEmail4">Date output</label>
                        <input type="date" class="form-control" id="dateOut" name="dateOut">
                    </div>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-primary">Find</button>
            </form>
        </div>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">code</th>
            <th scope="col">agency</th>
            <th scope="col">investigator</th>
            <th scope="col">date input</th>
            <th scope="col">date output</th>
            <th scope="col">days in prod</th>
            <th scope="col">conclusions</th>
        </tr>
        </thead>
        <tbody>
        <#list exps as exps>
            <tr>
                <th scope="row">
                    <a href="/material?exmID=${exps.getId()}" type="submit"
                       class="text-decoration-none">${exps.getId()}</a>
                </th>
                <td>${exps.getCode()}</td>
                <td>${exps.getAgency()}</td>
                <td>${exps.getInvestigator()}</td>
                <td>${exps.getDateInput()}</td>
                <td>
                    <#if exps.dateOutput??>
                        ${exps.dateOutput}
                    <#else >
                        in progress
                    </#if>
                </td>
                <td>
                    <#if exps.dateOutput??>
                        ${exps.setDaysInProduction()}
                        Done for - ${exps.getDaysInProduction()}
                    <#else >
                        ${exps.setDaysInProduction()}
                        ${exps.getDaysInProduction()}
                    </#if>
                </td>
                <td>
                    <#if exps.dateOutput??>
                        ${exps.getConclusions()}
                    <#else >
                        in progress
                    </#if>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>
<#import "parts/common.ftl" as c>
<@c.page>



    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">code</th>
            <th scope="col">agency</th>
            <th scope="col">investigator</th>
            <th scope="col">date input</th>
            <th scope="col">date output</th>
        </tr>
        </thead>
        <tbody>
        <#list exps as exps>
            <tr>
                <th scope="row">
                <a href="/material?exmID=${exps.getId()}" type="submit" class="text-decoration-none">${exps.getId()}</a>
                </th>
                <td>${exps.getCode()}</td>
                <td>${exps.getAgency()}</td>
                <td>${exps.getInvestigator()}</td>
                <td>${exps.getDateInput()}</td>
            </tr>
        </#list>
        </tbody>
    </table>







</@c.page>
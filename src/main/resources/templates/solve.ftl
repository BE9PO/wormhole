<#import "parts/common.ftl" as c>
<@c.page>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Код экспертизы</th>
        </tr>
        </thead>
        <tbody>
            <#list exps as exps>
                <tr>
                    <th scope="row">${exps.getId()}</th>
                    <td>${exps.getCode()}</td>
                </tr>
            </#list>
        </tbody>
    </table>
</@c.page>
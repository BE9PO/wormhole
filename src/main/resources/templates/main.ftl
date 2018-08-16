<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
<div>
    <@l.logout></@l.logout>
</div>

<div>
    <form method="post" enctype="multipart/form-data">
        <input type="text" name="text" placeholder="Intut text">
        <input type="file" name="file">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit"> Edd</button>
    </form>
</div>

<div>
    <div> Список сообщений</div>
    <form method="post" action="filter">
        <input type="text" name="filter">
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
        <button type="submit">FindByMessage</button>
    </form>
    <div>
        <#list messages as message>
            <p>
                <b>${message.id}</b>
                <spanp>${message.message}</spanp>
            </p>
        </#list>
    </div>
</div>
</@c.page>
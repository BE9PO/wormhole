<#import "parts/common.ftl" as c>
<@c.page>
    List Users
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Role</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
      <#list users as user>
      <tr>
          <td>${user.name}</td>
          <td>${user.role}</td>
          <td><a href="/user/${user.id}">edit</a> </td>
      </tr>

      </#list>
    </tbody>
</table>


</@c.page>
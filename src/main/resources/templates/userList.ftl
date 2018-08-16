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
          <td>${user.getUsername()}</td>
          <td>${user.getRoles()}</td>
          <td><a href="/user/${user.getId()}">edit</a> </td>
      </tr>

      </#list>
    </tbody>
</table>


</@c.page>
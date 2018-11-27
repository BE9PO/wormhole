<#include "security.ftl">
<#import "login.ftl" as login>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Wormhole</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/main">Messages</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/solve">LIST EXP</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/addExp">ADD EXP</a>
            </li>
            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/userList">User list</a>
            </li>
            </#if>
        </ul>
        <div class="navbar-text mr-3">
        ${name}
            <@login.logout/>
        </div>
    </div>
</nav>
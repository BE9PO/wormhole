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
                <a class="nav-link" href="/solve">view the list</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/addExp">add to the list</a>
            </li>
        </ul>
        <div class="navbar-text mr-3">
        </div>
    </div>
    <#if known>
        <div class="p-3">${name}</div>
        <@login.logout/>
    </#if>
</nav>
<#import "parts/page.ftl" as c>
<#import "parts/search.ftl" as s>
<#import "parts/resultTable.ftl"as t>
<#import "parts/login.ftl" as l>

<@c.page>
    <@l.logout/>
    <#if buy??><div><h2> Successful buy</h2> </div> </#if>
<@s.search "user"/>
    <#if userRole=="ADMIN"><div><a href="admin">Go to admin panel</a> </div> </#if>
<@t.result books, "forUser" />
</@c.page>
<#import "parts/page.ftl" as c>
<#import "parts/search.ftl" as s>
<#import "parts/resultTable.ftl"as t>
<#import "parts/login.ftl" as l>

<@c.page>
    <@l.logout/>

    <@s.search "adminSearch"/>
    <div><a href="book">Exit from admin panel</a> </div>
    <div><a href="addBook">Add book</a> </div>
    <@t.result books, "forAdmin" />
</@c.page>
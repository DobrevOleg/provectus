<#import "parts/page.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
    <@l.logout/>
    <h4>Adding</h4>
    <a href="/admin"><p>Back</p></a>

    <form action="add" method="post">
        <div><label> Title: <input type="text" name="title" /> </label></div>
        <div><label> Author: <input type="text" name="authors" /> </label></div>
        <div><label> Genre: <input type="text" name="genres" /> </label></div>
        <div><label> Description: <input type="text" name="description" /> </label></div>
        <div><label> Price: <input type="text" name="price"/> </label></div>

        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div><input type="submit" value="Confirm"/></div>
    </form>
</@c.page>
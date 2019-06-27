<#import "parts/page.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <@l.logout/>
    <h4>Editing</h4>
    <a href="/admin"><p>Back</p></a>

    <form action="edit" method="post">
        <div><label> Title: <input type="text" name="title" value="${books.getTitle()}"/> </label></div>
        <div><label> Author: <input type="text" name="authors" value="${books.getAuthors()}"/> </label></div>
        <div><label> Genre: <input type="text" name="genres" value="${books.getGenres()}"/> </label></div>
        <div><label> Description: <input type="text" name="description" value="${books.getDescription()}"/> </label></div>
        <div><label> Price: <input type="text" name="price"/> </label></div>
        <div><label> <input type="hidden" name="id" value="${books.getId()}"/> </label></div>

        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div><input type="submit" value="Confirm"/></div>
    </form>
</@c.page>
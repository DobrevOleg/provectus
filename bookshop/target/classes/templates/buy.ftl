<#import "parts/page.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <@l.logout/>
    <h4>Buying</h4>
    <a href="book"><p>Back</p></a>
    <h4>Info about the book</h4>
    <li>Title:    ${books.getTitle()}  </li>
    <li>Author:  ${books.getAuthors()} </li>
    <li>Genre:    ${books.getGenres()} </li>
    <li>Description:   ${books.getDescription()} </li>
    <li>Price:  ${books.getPrice()} </li>
   <br><br><br>

    <form action="buy" method="post">
        <div><label> First name : <input type="text" name="firstName"/> </label></div>
        <div><label> Last name: <input type="text" name="lastName"/> </label></div>
        <div><label> Address: <input type="text" name="address"/> </label></div>
        <div><label> Quantity: <input type="text" name="quantity"/> </label></div>
        <div><label> <input type="hidden" name="idBook" value="${books.getId()}"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div><input type="submit" value="Confirm"/></div>
    </form>
</@c.page>

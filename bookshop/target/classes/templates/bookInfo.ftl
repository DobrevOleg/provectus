<#import "parts/page.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <@l.logout/>
    <a href="book"><p>Back</p></a>
    <h4>Info about the book</h4>
    <li>Title:    ${books.getTitle()}  </li>
    <li>Author:  ${books.getAuthors()} </li>
    <li>Genre:    ${books.getGenres()} </li>
    <li>Description:   ${books.getDescription()} </li>
    <li>Price:  ${books.getPrice()} </li> <br><br>
    <a href="buy?id=${books.getId()}">buy</a>
</@c.page>
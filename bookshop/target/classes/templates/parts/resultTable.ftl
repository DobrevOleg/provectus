<#macro result books status>
    <table class="table table-bordered" >
        <tr class="active">
            <th> Title </th>
            <th> Author </th>
            <th> Genre </th>
        </tr>
        <#list books as book>
        <tr>
            <#if status=="forUser">
                 <td><a href="bookInfo?id=${book.getId()}"> ${book.getTitle()} </a>  </td>
            <#else>
                <td><a href="bookEdit?id=${book.getId()}"> ${book.getTitle()} </a>  </td>
            </#if>
            <td> ${book.getAuthors()} </td>
            <td> ${book.getGenres()} </td>
        </tr>
        </#list>

    </table>
</#macro>